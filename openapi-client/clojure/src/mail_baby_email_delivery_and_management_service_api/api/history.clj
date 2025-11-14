(ns mail-baby-email-delivery-and-management-service-api.api.history
  (:require [mail-baby-email-delivery-and-management-service-api.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-blocks :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-address :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-stats-type-volume-to :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.deny-rule-new :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-stats-type-volume :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-block-click-house :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-address-name :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-address-types :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.send-mail :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-stats-type-volume-ip :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-order :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.error-message :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-stats-type :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-attachment :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-log-entry :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.generic-response :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.deny-rule-record :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-block-rspamd :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.raw-mail :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.send-mail-adv :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-stats-type-volume-from :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-log :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-addresses-types :refer :all]
            )
  (:import (java.io File)))


(defn-spec get-stats-with-http-info any?
  "Account usage statistics.
  Returns information about the usage on your mail accounts."
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
  "Account usage statistics.
  Returns information about the usage on your mail accounts."
  ([] (get-stats nil))
  ([optional-params any?]
   (let [res (:data (get-stats-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode mail-stats-type-spec res st/string-transformer)
        res))))


(defn-spec view-mail-log-with-http-info any?
  "displays the mail log
  Get a listing of the emails sent through this system"
  ([] (view-mail-log-with-http-info nil))
  ([{:keys [id origin mx from to subject mailid skip limit startDate endDate replyto headerfrom delivered]} (s/map-of keyword? any?)]
   (call-api "/mail/log" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"id" id "origin" origin "mx" mx "from" from "to" to "subject" subject "mailid" mailid "skip" skip "limit" limit "startDate" startDate "endDate" endDate "replyto" replyto "headerfrom" headerfrom "delivered" delivered }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["apiKeyAuth"]})))

(defn-spec view-mail-log mail-log-spec
  "displays the mail log
  Get a listing of the emails sent through this system"
  ([] (view-mail-log nil))
  ([optional-params any?]
   (let [res (:data (view-mail-log-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode mail-log-spec res st/string-transformer)
        res))))


