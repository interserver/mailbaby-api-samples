(ns mail-baby-email-delivery-and-management-service-api.api.blocking
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
            [mail-baby-email-delivery-and-management-service-api.specs.send-mail-raw :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.generic-response :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.deny-rule-record :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-block-rspamd :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.send-mail-adv :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-stats-type-volume-from :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-log :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-addresses-types :refer :all]
            )
  (:import (java.io File)))


(defn-spec add-rule-with-http-info any?
  "Creates a new email deny rule.
  Adds a new email deny rule into the system to block new emails that match the given criteria"
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
  "Creates a new email deny rule.
  Adds a new email deny rule into the system to block new emails that match the given criteria"
  ([type string?, data string?, ] (add-rule type data nil))
  ([type string?, data string?, optional-params any?]
   (let [res (:data (add-rule-with-http-info type data optional-params))]
     (if (:decode-models *api-context*)
        (st/decode generic-response-spec res st/string-transformer)
        res))))


(defn-spec delete-rule-with-http-info any?
  "Removes an deny mail rule.
  Removes one of the configured deny mail rules from the system."
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
  "Removes an deny mail rule.
  Removes one of the configured deny mail rules from the system."
  [ruleId int?]
  (let [res (:data (delete-rule-with-http-info ruleId))]
    (if (:decode-models *api-context*)
       (st/decode generic-response-spec res st/string-transformer)
       res)))


(defn-spec delist-block-with-http-info any?
  "Removes an email address from the blocked list
  Removes an email address from the various block lists."
  [body string?]
  (check-required-params body)
  (call-api "/mail/blocks/delete" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json" "multipart/form-data"]
             :accepts       ["application/json"]
             :auth-names    ["apiKeyAuth"]}))

(defn-spec delist-block generic-response-spec
  "Removes an email address from the blocked list
  Removes an email address from the various block lists."
  [body string?]
  (let [res (:data (delist-block-with-http-info body))]
    (if (:decode-models *api-context*)
       (st/decode generic-response-spec res st/string-transformer)
       res)))


(defn-spec get-mail-blocks-with-http-info any?
  "displays a list of blocked email addresses"
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
  "displays a list of blocked email addresses"
  []
  (let [res (:data (get-mail-blocks-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode mail-blocks-spec res st/string-transformer)
       res)))


(defn-spec get-rules-with-http-info any?
  "Displays a listing of deny email rules.
  Returns a listing of all the deny block rules you have configured."
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
  "Displays a listing of deny email rules.
  Returns a listing of all the deny block rules you have configured."
  []
  (let [res (:data (get-rules-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of deny-rule-record-spec) res st/string-transformer)
       res)))


