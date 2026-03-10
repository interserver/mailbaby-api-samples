(ns mail-baby-email-delivery-and-management-service-api.api.blocking
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


(defn-spec add-rule-with-http-info any?
  "Creates a new email deny rule
  Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.

The `type` field selects the matching strategy:
- **`email`** — exact match against the SMTP envelope `MAIL FROM` address. - **`domain`** — matches any sender address at the specified domain. - **`destination`** — exact match against the SMTP envelope `RCPT TO` address. - **`startswith`** — matches any sender address whose local-part (the portion
  before the `@`) starts with the given string.  Only alphanumeric characters
  and `+`, `_`, `.`, `-` are permitted in the prefix.


If `username` is provided it must be the SMTP username of one of your active mail orders (e.g. `mb20682`).  If omitted the rule is associated with your first active order.

On success the response `text` field contains the newly created rule's `id`, which can later be passed to `DELETE /mail/rules/{ruleId}` to remove it."
  ([type string?, data string?, ] (add-rule-with-http-info type data nil))
  ([type string?, data string?, {:keys [user]} (s/map-of keyword? any?)]
   (check-required-params type data)
   (call-api "/mail/rules" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {"user" user "type" type "data" data }
              :content-types ["application/x-www-form-urlencoded" "application/json"]
              :accepts       ["application/json"]
              :auth-names    ["apiKeyAuth"]})))

(defn-spec add-rule generic-response-spec
  "Creates a new email deny rule
  Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.

The `type` field selects the matching strategy:
- **`email`** — exact match against the SMTP envelope `MAIL FROM` address. - **`domain`** — matches any sender address at the specified domain. - **`destination`** — exact match against the SMTP envelope `RCPT TO` address. - **`startswith`** — matches any sender address whose local-part (the portion
  before the `@`) starts with the given string.  Only alphanumeric characters
  and `+`, `_`, `.`, `-` are permitted in the prefix.


If `username` is provided it must be the SMTP username of one of your active mail orders (e.g. `mb20682`).  If omitted the rule is associated with your first active order.

On success the response `text` field contains the newly created rule's `id`, which can later be passed to `DELETE /mail/rules/{ruleId}` to remove it."
  ([type string?, data string?, ] (add-rule type data nil))
  ([type string?, data string?, optional-params any?]
   (let [res (:data (add-rule-with-http-info type data optional-params))]
     (if (:decode-models *api-context*)
        (st/decode generic-response-spec res st/string-transformer)
        res))))


(defn-spec delete-rule-with-http-info any?
  "Removes a deny mail rule
  Permanently removes a single deny rule identified by its numeric `ruleId`.

The `ruleId` is the `id` field returned by `GET /mail/rules` or the `text` field from a successful `POST /mail/rules` response.

Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account."
  [ruleId int?]
  (check-required-params ruleId)
  (call-api "/mail/rules/{ruleId}" :delete
            {:path-params   {"ruleId" ruleId }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["apiKeyAuth"]}))

(defn-spec delete-rule generic-response-spec
  "Removes a deny mail rule
  Permanently removes a single deny rule identified by its numeric `ruleId`.

The `ruleId` is the `id` field returned by `GET /mail/rules` or the `text` field from a successful `POST /mail/rules` response.

Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account."
  [ruleId int?]
  (let [res (:data (delete-rule-with-http-info ruleId))]
    (if (:decode-models *api-context*)
       (st/decode generic-response-spec res st/string-transformer)
       res)))


(defn-spec delist-block-with-http-info any?
  "Removes an email address from the block lists
  Delists an email address from all three block list stores:
1. The rspamd spam-filter database (`fromemail` / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.

Use `GET /mail/blocks` to discover which addresses are currently blocked.  The `from` field in any returned block entry is a valid input for this call.

**Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules."
  [email-address-param email-address-param]
  (check-required-params email-address-param)
  (call-api "/mail/blocks/delete" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    email-address-param
             :content-types ["application/json" "multipart/form-data"]
             :accepts       ["application/json"]
             :auth-names    ["apiKeyAuth"]}))

(defn-spec delist-block generic-response-spec
  "Removes an email address from the block lists
  Delists an email address from all three block list stores:
1. The rspamd spam-filter database (`fromemail` / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.

Use `GET /mail/blocks` to discover which addresses are currently blocked.  The `from` field in any returned block entry is a valid input for this call.

**Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules."
  [email-address-param email-address-param]
  (let [res (:data (delist-block-with-http-info email-address-param))]
    (if (:decode-models *api-context*)
       (st/decode generic-response-spec res st/string-transformer)
       res)))


(defn-spec get-mail-blocks-with-http-info any?
  "Displays a list of blocked email addresses
  Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s).  Three categories are returned:

- **`local`** — messages flagged by the `LOCAL_BL_RCPT` rspamd rule.  These are
  messages sent to recipients on your account's local block list.
- **`mbtrap`** — messages flagged by the `MBTRAP` rspamd rule.  These are messages
  that triggered MailBaby's internal trap / honeypot detection.
- **`subject`** — senders whose recent messages contain spam-indicative subjects
  (strings containing `@`, `smtp`, `socks4`, or `socks5`) with high repetition
  (more than 4 identical subjects from the same sender in the last 3 days).


The `local` and `mbtrap` results cover the last 5 days.  The `subject` results cover the last 3 days.

A sender address returned in any of these lists can be delisted using `POST /mail/blocks/delete` with the `email` field set to that address."
  []
  (call-api "/mail/blocks" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["apiKeyAuth"]}))

(defn-spec get-mail-blocks mail-blocks-spec
  "Displays a list of blocked email addresses
  Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s).  Three categories are returned:

- **`local`** — messages flagged by the `LOCAL_BL_RCPT` rspamd rule.  These are
  messages sent to recipients on your account's local block list.
- **`mbtrap`** — messages flagged by the `MBTRAP` rspamd rule.  These are messages
  that triggered MailBaby's internal trap / honeypot detection.
- **`subject`** — senders whose recent messages contain spam-indicative subjects
  (strings containing `@`, `smtp`, `socks4`, or `socks5`) with high repetition
  (more than 4 identical subjects from the same sender in the last 3 days).


The `local` and `mbtrap` results cover the last 5 days.  The `subject` results cover the last 3 days.

A sender address returned in any of these lists can be delisted using `POST /mail/blocks/delete` with the `email` field set to that address."
  []
  (let [res (:data (get-mail-blocks-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode mail-blocks-spec res st/string-transformer)
       res)))


(defn-spec get-rules-with-http-info any?
  "Displays a listing of deny email rules
  Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.

Four rule types are supported:
| `type` | `data` format | Effect | |--------|---------------|--------| | `email` | `user@domain.com` | Rejects any message from this exact sender address | | `domain` | `domain.com` | Rejects any message from any address at this domain | | `destination` | `user@domain.com` | Rejects any message addressed to this recipient | | `startswith` | `prefix` | Rejects any message whose sender address begins with this string (alphanumeric, `+`, `_`, `.`, `-` only) |

Use `POST /mail/rules` to add new rules and `DELETE /mail/rules/{ruleId}` to remove them.  The `id` field in each returned record is the value needed for the delete call."
  []
  (call-api "/mail/rules" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["apiKeyAuth"]}))

(defn-spec get-rules (s/coll-of deny-rule-record-spec)
  "Displays a listing of deny email rules
  Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.

Four rule types are supported:
| `type` | `data` format | Effect | |--------|---------------|--------| | `email` | `user@domain.com` | Rejects any message from this exact sender address | | `domain` | `domain.com` | Rejects any message from any address at this domain | | `destination` | `user@domain.com` | Rejects any message addressed to this recipient | | `startswith` | `prefix` | Rejects any message whose sender address begins with this string (alphanumeric, `+`, `_`, `.`, `-` only) |

Use `POST /mail/rules` to add new rules and `DELETE /mail/rules/{ruleId}` to remove them.  The `id` field in each returned record is the value needed for the delete call."
  []
  (let [res (:data (get-rules-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of deny-rule-record-spec) res st/string-transformer)
       res)))


