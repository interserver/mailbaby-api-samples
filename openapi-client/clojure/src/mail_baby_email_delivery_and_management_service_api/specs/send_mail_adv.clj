(ns mail-baby-email-delivery-and-management-service-api.specs.send-mail-adv
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [mail-baby-email-delivery-and-management-service-api.specs.email-address-types :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-addresses-types :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-addresses-types :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-addresses-types :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.email-addresses-types :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-attachment :refer :all]
            )
  (:import (java.io File)))


(def send-mail-adv-data
  {
   (ds/req :subject) string?
   (ds/req :body) string?
   (ds/req :from) email-address-types-spec
   (ds/req :to) email-addresses-types-spec
   (ds/opt :replyto) email-addresses-types-spec
   (ds/opt :cc) email-addresses-types-spec
   (ds/opt :bcc) email-addresses-types-spec
   (ds/opt :attachments) (s/coll-of mail-attachment-spec)
   (ds/opt :id) int?
   })

(def send-mail-adv-spec
  (ds/spec
    {:name ::send-mail-adv
     :spec send-mail-adv-data}))
