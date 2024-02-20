(ns mail-baby-email-delivery-and-management-service-api.api.sending
  (:require [mail-baby-email-delivery-and-management-service-api.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-blocks :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-address :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.deny-rule-new :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-block-click-house :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-address-name :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-address-types :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.send-mail :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-order :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.error-message :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-attachment :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-log-entry :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.generic-response :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.get-stats-200-response-inner :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.deny-rule-record :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-block-rspamd :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.send-mail-adv :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-log :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-addresses-types :refer :all]
            )
  (:import (java.io File)))


(defn-spec send-adv-mail-with-http-info any?
  "Sends an Email with Advanced Options
  Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.

```
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/x-www-form-urlencoded' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data 'subject=Welcome' \\
--data 'body=Hello' \\
--data from=user@domain.com \\
--data to=support@interserver.net
```

```
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/x-www-form-urlencoded' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data 'subject=Welcome' \\
--data 'body=Hello' \\
--data from=user@domain.com \\
--data \"to[0][name]=Joe\" \\
--data \"to[0][email]=support@interserver.net\"
```

```
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/x-www-form-urlencoded' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data 'subject=Welcome' \\
--data 'body=Hello' \\
--data from=\"Joe <user@domain.com>\" \\
--data to=\"Joe <support@interserver.net>\"
```

```
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/x-www-form-urlencoded' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data 'subject=Welcome' \\
--data 'body=Hello' \\
--data from=user@domain.com \\
--data \"to=support@interserver.net, support@interserver.net\"
```

```
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/x-www-form-urlencoded' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data 'subject=Welcome' \\
--data 'body=Hello' \\
--data from=user@domain.com \\
--data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\"
```

```
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/x-www-form-urlencoded' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data 'subject=Welcome' \\
--data 'body=Hello' \\
--data from=user@domain.com \\
--data \"to[0][name]=Joe\" \\
--data \"to[0][email]=support@interserver.net\" \\
--data \"to[1][name]=Joe\" \\
--data \"to[1][email]=support@interserver.net\"
```

```
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/json' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data '{
\"subject\": \"Welcome\",
\"body\": \"Hello\",
\"from\": \"user@domain.com\",
\"to\": \"support@interserver.net\"
}'
```

```
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/json' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data '{
\"subject\": \"Welcome\",
\"body\": \"Hello\",
\"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"},
\"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}]
}'
```

```
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/json' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data '{
\"subject\": \"Welcome\",
\"body\": \"Hello\",
\"from\": \"Joe <user@domain.com>\",
\"to\": \"Joe <support@interserver.net>\"
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
  Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.

```
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/x-www-form-urlencoded' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data 'subject=Welcome' \\
--data 'body=Hello' \\
--data from=user@domain.com \\
--data to=support@interserver.net
```

```
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/x-www-form-urlencoded' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data 'subject=Welcome' \\
--data 'body=Hello' \\
--data from=user@domain.com \\
--data \"to[0][name]=Joe\" \\
--data \"to[0][email]=support@interserver.net\"
```

```
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/x-www-form-urlencoded' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data 'subject=Welcome' \\
--data 'body=Hello' \\
--data from=\"Joe <user@domain.com>\" \\
--data to=\"Joe <support@interserver.net>\"
```

```
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/x-www-form-urlencoded' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data 'subject=Welcome' \\
--data 'body=Hello' \\
--data from=user@domain.com \\
--data \"to=support@interserver.net, support@interserver.net\"
```

```
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/x-www-form-urlencoded' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data 'subject=Welcome' \\
--data 'body=Hello' \\
--data from=user@domain.com \\
--data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\"
```

```
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/x-www-form-urlencoded' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data 'subject=Welcome' \\
--data 'body=Hello' \\
--data from=user@domain.com \\
--data \"to[0][name]=Joe\" \\
--data \"to[0][email]=support@interserver.net\" \\
--data \"to[1][name]=Joe\" \\
--data \"to[1][email]=support@interserver.net\"
```

```
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/json' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data '{
\"subject\": \"Welcome\",
\"body\": \"Hello\",
\"from\": \"user@domain.com\",
\"to\": \"support@interserver.net\"
}'
```

```
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/json' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data '{
\"subject\": \"Welcome\",
\"body\": \"Hello\",
\"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"},
\"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}]
}'
```

```
curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\
--header 'Accept: application/json' \\
--header 'Content-Type: application/json' \\
--header 'X-API-KEY: YOUR_API_KEY' \\
--data '{
\"subject\": \"Welcome\",
\"body\": \"Hello\",
\"from\": \"Joe <user@domain.com>\",
\"to\": \"Joe <support@interserver.net>\"
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
  Sends an email through one of your mail orders.

*Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead."
  [to string?, from string?, subject string?, body string?]
  (check-required-params to from subject body)
  (call-api "/mail/send" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {"to" to "from" from "subject" subject "body" body }
             :content-types ["application/x-www-form-urlencoded" "application/json"]
             :accepts       ["application/json"]
             :auth-names    ["apiKeyAuth"]}))

(defn-spec send-mail generic-response-spec
  "Sends an Email
  Sends an email through one of your mail orders.

*Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead."
  [to string?, from string?, subject string?, body string?]
  (let [res (:data (send-mail-with-http-info to from subject body))]
    (if (:decode-models *api-context*)
       (st/decode generic-response-spec res st/string-transformer)
       res)))


