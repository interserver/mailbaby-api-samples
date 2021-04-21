(ns mail-baby-api.api.default
  (:require [mail-baby-api.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [mail-baby-api.specs.mail-order :refer :all]
            [mail-baby-api.specs.mail-attachment :refer :all]
            [mail-baby-api.specs.error-response :refer :all]
            [mail-baby-api.specs.generic-response :refer :all]
            [mail-baby-api.specs.mail-log :refer :all]
            [mail-baby-api.specs.mail-contact :refer :all]
            [mail-baby-api.specs.send-mail :refer :all]
            )
  (:import (java.io File)))


(defn-spec get-mail-by-id-with-http-info any?
  "Gets mail order information by id
  returns information about a mail order in the system with the given id."
  [id int?]
  (check-required-params id)
  (call-api "/mail/{id}" :get
            {:path-params   {"id" id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["apiKeyAuth" "apiLoginAuth" "apiPasswordAuth"]}))

(defn-spec get-mail-by-id mail-order-spec
  "Gets mail order information by id
  returns information about a mail order in the system with the given id."
  [id int?]
  (let [res (:data (get-mail-by-id-with-http-info id))]
    (if (:decode-models *api-context*)
       (st/decode mail-order-spec res st/string-transformer)
       res)))


(defn-spec get-mail-orders-with-http-info any?
  "displays a list of mail service orders"
  []
  (call-api "/mail" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json" "application/xml" "text/plain"]
             :auth-names    ["apiKeyAuth" "apiLoginAuth" "apiPasswordAuth"]}))

(defn-spec get-mail-orders (s/coll-of mail-order-spec)
  "displays a list of mail service orders"
  []
  (let [res (:data (get-mail-orders-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of mail-order-spec) res st/string-transformer)
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
              :auth-names    ["apiKeyAuth" "apiLoginAuth" "apiPasswordAuth"]})))

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
  [id int?, send-mail send-mail]
  (check-required-params id send-mail)
  (call-api "/mail/{id}/advsend" :post
            {:path-params   {"id" id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    send-mail
             :content-types ["application/json" "application/xml" "application/x-www-form-urlencoded" "text/plain"]
             :accepts       ["application/json"]
             :auth-names    ["apiKeyAuth" "apiLoginAuth" "apiPasswordAuth"]}))

(defn-spec send-adv-mail-by-id generic-response-spec
  "Sends an Email with Advanced Options
  Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc."
  [id int?, send-mail send-mail]
  (let [res (:data (send-adv-mail-by-id-with-http-info id send-mail))]
    (if (:decode-models *api-context*)
       (st/decode generic-response-spec res st/string-transformer)
       res)))


(defn-spec send-mail-by-id-with-http-info any?
  "Sends an Email
  Sends An email through one of your mail orders."
  ([id int?, ] (send-mail-by-id-with-http-info id nil))
  ([id int?, {:keys [subject body to toName from fromName]} (s/map-of keyword? any?)]
   (check-required-params id)
   (call-api "/mail/{id}/send" :post
             {:path-params   {"id" id }
              :header-params {}
              :query-params  {"subject" subject "body" body "to" to "toName" toName "from" from "fromName" fromName }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["apiKeyAuth" "apiLoginAuth" "apiPasswordAuth"]})))

(defn-spec send-mail-by-id generic-response-spec
  "Sends an Email
  Sends An email through one of your mail orders."
  ([id int?, ] (send-mail-by-id id nil))
  ([id int?, optional-params any?]
   (let [res (:data (send-mail-by-id-with-http-info id optional-params))]
     (if (:decode-models *api-context*)
        (st/decode generic-response-spec res st/string-transformer)
        res))))


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
             :auth-names    ["apiKeyAuth" "apiLoginAuth" "apiPasswordAuth"]}))

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
  ([id int?, ] (view-mail-log-by-id-with-http-info id nil))
  ([id int?, {:keys [searchString skip limit]} (s/map-of keyword? any?)]
   (check-required-params id)
   (call-api "/mail/{id}/log" :get
             {:path-params   {"id" id }
              :header-params {}
              :query-params  {"searchString" searchString "skip" skip "limit" limit }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["apiKeyAuth" "apiLoginAuth" "apiPasswordAuth"]})))

(defn-spec view-mail-log-by-id (s/coll-of mail-log-spec)
  "displays the mail log
  By passing in the appropriate options, you can search for
available inventory in the system"
  ([id int?, ] (view-mail-log-by-id id nil))
  ([id int?, optional-params any?]
   (let [res (:data (view-mail-log-by-id-with-http-info id optional-params))]
     (if (:decode-models *api-context*)
        (st/decode (s/coll-of mail-log-spec) res st/string-transformer)
        res))))


