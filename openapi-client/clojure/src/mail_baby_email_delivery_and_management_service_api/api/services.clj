(ns mail-baby-email-delivery-and-management-service-api.api.services
  (:require [mail-baby-email-delivery-and-management-service-api.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-blocks :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-address :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.deny-rule-new :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-block-click-house :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-address-name :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.send-mail :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-order :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.get-mail-orders-401-response :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-log-entry :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-attachment :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.generic-response :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.get-stats-200-response-inner :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.deny-rule-record :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-block-rspamd :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.send-mail-adv :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-log :refer :all]
            )
  (:import (java.io File)))


(defn-spec get-mail-orders-with-http-info any?
  "displays a list of mail service orders
  This will return a list of the mail orders you have in our system including their id, status, username, and optional comment."
  []
  (call-api "/mail" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["apiKeyAuth"]}))

(defn-spec get-mail-orders (s/coll-of mail-order-spec)
  "displays a list of mail service orders
  This will return a list of the mail orders you have in our system including their id, status, username, and optional comment."
  []
  (let [res (:data (get-mail-orders-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of mail-order-spec) res st/string-transformer)
       res)))


