(ns mail-baby-email-delivery-and-management-service-api.api.history
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


(defn-spec get-stats-with-http-info any?
  "Account usage statistics
  Returns aggregate sending statistics for your mail account(s) across a selectable time window.  Useful for dashboards, billing reviews, and detecting unusual traffic patterns.

The response includes:
- **`usage`** — total messages accepted by the relay during the current billing
  cycle (used for cost calculation).
- **`cost`** — estimated cost for the billing cycle based on the base plan price
  plus per-email charges.
- **`received`** / **`sent`** — count of messages accepted by the relay /
  successfully delivered to the destination MX within the selected `time` window.
- **`volume`** — top-500 breakdown of message counts grouped by source IP (`ip`),
  destination address (`to`), and sender address (`from`) within the selected window.


**Time windows** (controlled by the `time` parameter):
| Value | Window | |-------|--------| | `1h` | Last 1 hour (default) | | `24h` | Last 24 hours | | `7d` | Last 7 days | | `month` | Current calendar month (1st to now) | | `day` | Today (midnight to now) | | `billing` | Current billing cycle (last invoice date to next invoice date) | | `all` | All time |"
  ([] (get-stats-with-http-info nil))
  ([{:keys [time]} (s/map-of keyword? any?)]
   (call-api "/mail/stats" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"time" time }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["apiKeyAuth"]})))

(defn-spec get-stats mail-stats-type-spec
  "Account usage statistics
  Returns aggregate sending statistics for your mail account(s) across a selectable time window.  Useful for dashboards, billing reviews, and detecting unusual traffic patterns.

The response includes:
- **`usage`** — total messages accepted by the relay during the current billing
  cycle (used for cost calculation).
- **`cost`** — estimated cost for the billing cycle based on the base plan price
  plus per-email charges.
- **`received`** / **`sent`** — count of messages accepted by the relay /
  successfully delivered to the destination MX within the selected `time` window.
- **`volume`** — top-500 breakdown of message counts grouped by source IP (`ip`),
  destination address (`to`), and sender address (`from`) within the selected window.


**Time windows** (controlled by the `time` parameter):
| Value | Window | |-------|--------| | `1h` | Last 1 hour (default) | | `24h` | Last 24 hours | | `7d` | Last 7 days | | `month` | Current calendar month (1st to now) | | `day` | Today (midnight to now) | | `billing` | Current billing cycle (last invoice date to next invoice date) | | `all` | All time |"
  ([] (get-stats nil))
  ([optional-params any?]
   (let [res (:data (get-stats-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode mail-stats-type-spec res st/string-transformer)
        res))))


(defn-spec view-mail-log-with-http-info any?
  "Displays the mail log
  Returns a paginated list of every email message accepted by the relay for your mail account(s).  All filter parameters are optional and combinable.

**Pagination** is controlled by `skip` and `limit`.  The response includes a `total` count so clients can determine how many pages exist.

**Date filtering** uses Unix timestamps (`startDate` / `endDate`).  For example, to retrieve emails sent in January 2024: `startDate=1704067200&endDate=1706745599`.

**Delivery status** can be filtered with the `delivered` parameter: `delivered=1` returns only successfully delivered messages; `delivered=0` returns messages still in queue or that failed.

**Address filtering** distinguishes between the SMTP envelope address (`from`, `to`) and message headers (`headerfrom` for the `From:` header, `replyto` for `Reply-To:`). These may differ when a message is sent on behalf of another address.

The `mailid` parameter corresponds to the `id` field in the returned `MailLogEntry` objects, **not** the `_id` field.  It also matches the transaction ID returned in the `text` field of a successful send response from `/mail/send`, `/mail/advsend`, or `/mail/rawsend`.

The `messageId` parameter searches the `Message-ID` email header (case-insensitive substring match)."
  ([] (view-mail-log-with-http-info nil))
  ([{:keys [id origin mx from to subject mailid messageId replyto headerfrom delivered skip limit startDate endDate]} (s/map-of keyword? any?)]
   (call-api "/mail/log" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"id" id "origin" origin "mx" mx "from" from "to" to "subject" subject "mailid" mailid "messageId" messageId "replyto" replyto "headerfrom" headerfrom "delivered" delivered "skip" skip "limit" limit "startDate" startDate "endDate" endDate }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["apiKeyAuth"]})))

(defn-spec view-mail-log mail-log-spec
  "Displays the mail log
  Returns a paginated list of every email message accepted by the relay for your mail account(s).  All filter parameters are optional and combinable.

**Pagination** is controlled by `skip` and `limit`.  The response includes a `total` count so clients can determine how many pages exist.

**Date filtering** uses Unix timestamps (`startDate` / `endDate`).  For example, to retrieve emails sent in January 2024: `startDate=1704067200&endDate=1706745599`.

**Delivery status** can be filtered with the `delivered` parameter: `delivered=1` returns only successfully delivered messages; `delivered=0` returns messages still in queue or that failed.

**Address filtering** distinguishes between the SMTP envelope address (`from`, `to`) and message headers (`headerfrom` for the `From:` header, `replyto` for `Reply-To:`). These may differ when a message is sent on behalf of another address.

The `mailid` parameter corresponds to the `id` field in the returned `MailLogEntry` objects, **not** the `_id` field.  It also matches the transaction ID returned in the `text` field of a successful send response from `/mail/send`, `/mail/advsend`, or `/mail/rawsend`.

The `messageId` parameter searches the `Message-ID` email header (case-insensitive substring match)."
  ([] (view-mail-log nil))
  ([optional-params any?]
   (let [res (:data (view-mail-log-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode mail-log-spec res st/string-transformer)
        res))))


