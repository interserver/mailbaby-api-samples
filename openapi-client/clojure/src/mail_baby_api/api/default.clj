(ns mail-baby-api.api.default
  (:require [mail-baby-api.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [mail-baby-api.specs.mail-order :refer :all]
            [mail-baby-api.specs.mail-attachment :refer :all]
            [mail-baby-api.specs.error-response :refer :all]
            [mail-baby-api.specs.generic-response :refer :all]
            [mail-baby-api.specs.send-mail-from :refer :all]
            [mail-baby-api.specs.mail-log :refer :all]
            [mail-baby-api.specs.mail-contact :refer :all]
            [mail-baby-api.specs.send-mail :refer :all]
            )
  (:import (java.io File)))


(defn-spec get-mail-orders-with-http-info any?
  "displays a list of mail service orders"
  ([] (get-mail-orders-with-http-info nil))
  ([{:keys [id]} (s/map-of keyword? any?)]
   (call-api "/mail" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"id" id }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "application/xml" "text/plain"]
              :auth-names    ["apiKeyAuth"]})))

(defn-spec get-mail-orders (s/coll-of mail-order-spec)
  "displays a list of mail service orders"
  ([] (get-mail-orders nil))
  ([optional-params any?]
   (let [res (:data (get-mail-orders-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode (s/coll-of mail-order-spec) res st/string-transformer)
        res))))


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


(defn-spec place-mail-order-with-http-info any?
  "places a mail order
  Adds an item to the system"
  ([] (place-mail-order-with-http-info nil))
  ([{:keys [mail-order]} (s/map-of keyword? any?)]
   (call-api "/mail/order" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    mail-order
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["apiKeyAuth"]})))

(defn-spec place-mail-order any?
  "places a mail order
  Adds an item to the system"
  ([] (place-mail-order nil))
  ([optional-params any?]
   (let [res (:data (place-mail-order-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any? res st/string-transformer)
        res))))


(defn-spec send-adv-mail-by-id-with-http-info any?
  "Sends an Email with Advanced Options
  Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc."
  [send-mail send-mail]
  (check-required-params send-mail)
  (call-api "/mail/advsend" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    send-mail
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["apiKeyAuth"]}))

(defn-spec send-adv-mail-by-id generic-response-spec
  "Sends an Email with Advanced Options
  Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc."
  [send-mail send-mail]
  (let [res (:data (send-adv-mail-by-id-with-http-info send-mail))]
    (if (:decode-models *api-context*)
       (st/decode generic-response-spec res st/string-transformer)
       res)))


(defn-spec send-mail-by-id-with-http-info any?
  "Sends an Email
  Sends An email through one of your mail orders."
  [send-mail send-mail]
  (check-required-params send-mail)
  (call-api "/mail/send" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    send-mail
             :content-types ["application/json" "application/x-www-form-urlencoded"]
             :accepts       ["application/json"]
             :auth-names    ["apiKeyAuth"]}))

(defn-spec send-mail-by-id generic-response-spec
  "Sends an Email
  Sends An email through one of your mail orders."
  [send-mail send-mail]
  (let [res (:data (send-mail-by-id-with-http-info send-mail))]
    (if (:decode-models *api-context*)
       (st/decode generic-response-spec res st/string-transformer)
       res)))


(defn-spec validate-mail-order-with-http-info any?
  "validatess order details before placing an order"
  []
  (call-api "/mail/order" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["apiKeyAuth"]}))

(defn-spec validate-mail-order any?
  "validatess order details before placing an order"
  []
  (let [res (:data (validate-mail-order-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode any? res st/string-transformer)
       res)))


(defn-spec view-mail-log-by-id-with-http-info any?
  "displays the mail log
  By passing in the appropriate options, you can search for
available inventory in the system"
  ([] (view-mail-log-by-id-with-http-info nil))
  ([{:keys [id searchString skip limit]} (s/map-of keyword? any?)]
   (call-api "/mail/log" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"id" id "searchString" searchString "skip" skip "limit" limit }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["apiKeyAuth"]})))

(defn-spec view-mail-log-by-id (s/coll-of mail-log-spec)
  "displays the mail log
  By passing in the appropriate options, you can search for
available inventory in the system"
  ([] (view-mail-log-by-id nil))
  ([optional-params any?]
   (let [res (:data (view-mail-log-by-id-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode (s/coll-of mail-log-spec) res st/string-transformer)
        res))))


