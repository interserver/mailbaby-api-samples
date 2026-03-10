(ns mail-baby-email-delivery-and-management-service-api.api.sending
  (:require [mail-baby-email-delivery-and-management-service-api.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [mail-baby-email-delivery-and-management-service-api.specs.send-mail-to :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-order-detail :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-blocks :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-stats-volume :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.deny-rule-new :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-block-click-house :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-address-name :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-address-types :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.send-mail :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-order :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.error-message :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-stats-type :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-attachment :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-log-entry :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.send-mail-raw :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.generic-response :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-block-rspamd :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.deny-rule-record :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-address-param :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.send-mail-adv :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-address-names :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-addresses-types :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-log :refer :all]
            )
  (:import (java.io File)))


(defn-spec raw-mail-with-http-info any?
  "Sends a raw RFC 822 email
  Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.

This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact.  If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.

The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.

If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.

On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record."
  [send-mail-raw send-mail-raw]
  (check-required-params send-mail-raw)
  (call-api "/mail/rawsend" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    send-mail-raw
             :content-types ["application/json" "multipart/form-data"]
             :accepts       ["application/json"]
             :auth-names    ["apiKeyAuth"]}))

(defn-spec raw-mail generic-response-spec
  "Sends a raw RFC 822 email
  Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.

This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact.  If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.

The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.

If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.

On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record."
  [send-mail-raw send-mail-raw]
  (let [res (:data (raw-mail-with-http-info send-mail-raw))]
    (if (:decode-models *api-context*)
       (st/decode generic-response-spec res st/string-transformer)
       res)))


(defn-spec send-adv-mail-with-http-info any?
  "Sends an Email with Advanced Options
  Sends an email through one of your mail orders with full control over recipients, headers, and attachments.  Supports multiple To / CC / BCC addresses, named contacts, Reply-To overrides, and base64-encoded file attachments.

**Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `\"Joe <joe@example.com>, jane@example.com\"`) and the structured `[{\"email\":\"...\",\"name\":\"...\"}]` array format.  When using JSON, both formats are equally supported.

**HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.

**Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.

If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.

On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.

## Examples

### Form — basic string addresses
```sh curl -X POST https://api.mailbaby.net/mail/advsend \\
  -H 'X-API-KEY: YOUR_API_KEY' \\
  -H 'Content-Type: application/x-www-form-urlencoded' \\
  -d 'subject=Welcome' \\
  -d 'body=Hello' \\
  -d from=user@domain.com \\
  -d to=support@interserver.net
```
### Form — RFC 822 named addresses
```sh curl -X POST https://api.mailbaby.net/mail/advsend \\
  -H 'X-API-KEY: YOUR_API_KEY' \\
  -H 'Content-Type: application/x-www-form-urlencoded' \\
  -d 'subject=Welcome' \\
  -d 'body=Hello' \\
  -d 'from=Joe <user@domain.com>' \\
  -d 'to=Jane <support@interserver.net>'
```
### Form — multiple recipients as array
```sh curl -X POST https://api.mailbaby.net/mail/advsend \\
  -H 'X-API-KEY: YOUR_API_KEY' \\
  -H 'Content-Type: application/x-www-form-urlencoded' \\
  -d 'subject=Welcome' -d 'body=Hello' \\
  -d from=user@domain.com \\
  -d 'to[0][name]=Joe' -d 'to[0][email]=support@interserver.net' \\
  -d 'to[1][name]=Jane' -d 'to[1][email]=jane@interserver.net'
```
### JSON — structured objects
```sh curl -X POST https://api.mailbaby.net/mail/advsend \\
  -H 'X-API-KEY: YOUR_API_KEY' \\
  -H 'Content-Type: application/json' \\
  -d '{
    \"subject\": \"Welcome\",
    \"body\": \"<h1>Hello</h1>\",
    \"from\": {\"email\": \"user@domain.com\", \"name\": \"Sender Name\"},
    \"to\": [{\"email\": \"joe@client.com\", \"name\": \"Joe Client\"}],
    \"cc\": [{\"email\": \"manager@client.com\"}],
    \"attachments\": [{\"filename\": \"report.pdf\", \"data\": \"BASE64_DATA\"}]
  }'
```"
  ([subject string?, body string?, from email-address-types-spec, to email-addresses-types-spec, ] (send-adv-mail-with-http-info subject body from to nil))
  ([subject string?, body string?, from email-address-types-spec, to email-addresses-types-spec, {:keys [replyto cc bcc attachments id]} (s/map-of keyword? any?)]
   (check-required-params subject body from to)
   (call-api "/mail/advsend" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {"subject" subject "body" body "from" from "to" to "replyto" replyto "cc" cc "bcc" bcc "attachments" (with-collection-format attachments :csv) "id" id }
              :content-types ["application/x-www-form-urlencoded" "application/json"]
              :accepts       ["application/json"]
              :auth-names    ["apiKeyAuth"]})))

(defn-spec send-adv-mail generic-response-spec
  "Sends an Email with Advanced Options
  Sends an email through one of your mail orders with full control over recipients, headers, and attachments.  Supports multiple To / CC / BCC addresses, named contacts, Reply-To overrides, and base64-encoded file attachments.

**Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `\"Joe <joe@example.com>, jane@example.com\"`) and the structured `[{\"email\":\"...\",\"name\":\"...\"}]` array format.  When using JSON, both formats are equally supported.

**HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.

**Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.

If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.

On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.

## Examples

### Form — basic string addresses
```sh curl -X POST https://api.mailbaby.net/mail/advsend \\
  -H 'X-API-KEY: YOUR_API_KEY' \\
  -H 'Content-Type: application/x-www-form-urlencoded' \\
  -d 'subject=Welcome' \\
  -d 'body=Hello' \\
  -d from=user@domain.com \\
  -d to=support@interserver.net
```
### Form — RFC 822 named addresses
```sh curl -X POST https://api.mailbaby.net/mail/advsend \\
  -H 'X-API-KEY: YOUR_API_KEY' \\
  -H 'Content-Type: application/x-www-form-urlencoded' \\
  -d 'subject=Welcome' \\
  -d 'body=Hello' \\
  -d 'from=Joe <user@domain.com>' \\
  -d 'to=Jane <support@interserver.net>'
```
### Form — multiple recipients as array
```sh curl -X POST https://api.mailbaby.net/mail/advsend \\
  -H 'X-API-KEY: YOUR_API_KEY' \\
  -H 'Content-Type: application/x-www-form-urlencoded' \\
  -d 'subject=Welcome' -d 'body=Hello' \\
  -d from=user@domain.com \\
  -d 'to[0][name]=Joe' -d 'to[0][email]=support@interserver.net' \\
  -d 'to[1][name]=Jane' -d 'to[1][email]=jane@interserver.net'
```
### JSON — structured objects
```sh curl -X POST https://api.mailbaby.net/mail/advsend \\
  -H 'X-API-KEY: YOUR_API_KEY' \\
  -H 'Content-Type: application/json' \\
  -d '{
    \"subject\": \"Welcome\",
    \"body\": \"<h1>Hello</h1>\",
    \"from\": {\"email\": \"user@domain.com\", \"name\": \"Sender Name\"},
    \"to\": [{\"email\": \"joe@client.com\", \"name\": \"Joe Client\"}],
    \"cc\": [{\"email\": \"manager@client.com\"}],
    \"attachments\": [{\"filename\": \"report.pdf\", \"data\": \"BASE64_DATA\"}]
  }'
```"
  ([subject string?, body string?, from email-address-types-spec, to email-addresses-types-spec, ] (send-adv-mail subject body from to nil))
  ([subject string?, body string?, from email-address-types-spec, to email-addresses-types-spec, optional-params any?]
   (let [res (:data (send-adv-mail-with-http-info subject body from to optional-params))]
     (if (:decode-models *api-context*)
        (st/decode generic-response-spec res st/string-transformer)
        res))))


(defn-spec send-mail-with-http-info any?
  "Sends an Email
  Sends an email through one of your mail orders using a simple flat set of fields. This is the quickest way to send a single-recipient plain-text or HTML message.

**HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.

The `from` address is also automatically set as the `Reply-To` header.

*Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.

On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record."
  ([to send-mail-to-spec, from string?, subject string?, body string?, ] (send-mail-with-http-info to from subject body nil))
  ([to send-mail-to-spec, from string?, subject string?, body string?, {:keys [id]} (s/map-of keyword? any?)]
   (check-required-params to from subject body)
   (call-api "/mail/send" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {"to" to "from" from "subject" subject "body" body "id" id }
              :content-types ["application/x-www-form-urlencoded" "application/json"]
              :accepts       ["application/json"]
              :auth-names    ["apiKeyAuth"]})))

(defn-spec send-mail generic-response-spec
  "Sends an Email
  Sends an email through one of your mail orders using a simple flat set of fields. This is the quickest way to send a single-recipient plain-text or HTML message.

**HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.

The `from` address is also automatically set as the `Reply-To` header.

*Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.

On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record."
  ([to send-mail-to-spec, from string?, subject string?, body string?, ] (send-mail to from subject body nil))
  ([to send-mail-to-spec, from string?, subject string?, body string?, optional-params any?]
   (let [res (:data (send-mail-with-http-info to from subject body optional-params))]
     (if (:decode-models *api-context*)
        (st/decode generic-response-spec res st/string-transformer)
        res))))


