(ns mail-baby-email-delivery-api.api.default
  (:require [mail-baby-email-delivery-api.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [mail-baby-email-delivery-api.specs.send-mail-adv-attachments-inner :refer :all]
            [mail-baby-email-delivery-api.specs.send-mail-adv-from :refer :all]
            [mail-baby-email-delivery-api.specs.send-mail-adv-to-inner :refer :all]
            [mail-baby-email-delivery-api.specs.send-mail :refer :all]
            [mail-baby-email-delivery-api.specs.send-mail-adv-replyto-inner :refer :all]
            [mail-baby-email-delivery-api.specs.get-mail-orders-401-response :refer :all]
            [mail-baby-email-delivery-api.specs.mail-log-entry :refer :all]
            [mail-baby-email-delivery-api.specs.send-mail-adv-cc-inner :refer :all]
            [mail-baby-email-delivery-api.specs.get-mail-orders-200-response-inner :refer :all]
            [mail-baby-email-delivery-api.specs.generic-response :refer :all]
            [mail-baby-email-delivery-api.specs.send-mail-adv :refer :all]
            [mail-baby-email-delivery-api.specs.send-mail-adv-bcc-inner :refer :all]
            [mail-baby-email-delivery-api.specs.mail-log :refer :all]
            )
  (:import (java.io File)))


(defn-spec get-mail-orders-with-http-info any?
  "displays a list of mail service orders"
  []
  (call-api "/mail" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["apiKeyAuth"]}))

(defn-spec get-mail-orders (s/coll-of get-mail-orders-200-response-inner-spec)
  "displays a list of mail service orders"
  []
  (let [res (:data (get-mail-orders-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of get-mail-orders-200-response-inner-spec) res st/string-transformer)
       res)))


(defn-spec ping-server-with-http-info any?
  "Checks if the server is running"
  []
  (call-api "/ping" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       []
             :auth-names    []}))

(defn-spec ping-server any?
  "Checks if the server is running"
  []
  (let [res (:data (ping-server-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode any? res st/string-transformer)
       res)))


(defn-spec send-adv-mail-with-http-info any?
  "Sends an Email with Advanced Options
  Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc."
  [send-mail-adv send-mail-adv]
  (check-required-params send-mail-adv)
  (call-api "/mail/advsend" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    send-mail-adv
             :content-types ["application/json" "application/x-www-form-urlencoded"]
             :accepts       ["application/json"]
             :auth-names    ["apiKeyAuth"]}))

(defn-spec send-adv-mail generic-response-spec
  "Sends an Email with Advanced Options
  Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc."
  [send-mail-adv send-mail-adv]
  (let [res (:data (send-adv-mail-with-http-info send-mail-adv))]
    (if (:decode-models *api-context*)
       (st/decode generic-response-spec res st/string-transformer)
       res)))


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


(defn-spec view-mail-log-with-http-info any?
  "displays the mail log
  By passing in the appropriate options, you can search for
available inventory in the system"
  ([] (view-mail-log-with-http-info nil))
  ([{:keys [id search skip limit startDate endDate]} (s/map-of keyword? any?)]
   (call-api "/mail/log" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"id" id "search" search "skip" skip "limit" limit "startDate" startDate "endDate" endDate }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["apiKeyAuth"]})))

(defn-spec view-mail-log mail-log-spec
  "displays the mail log
  By passing in the appropriate options, you can search for
available inventory in the system"
  ([] (view-mail-log nil))
  ([optional-params any?]
   (let [res (:data (view-mail-log-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode mail-log-spec res st/string-transformer)
        res))))


