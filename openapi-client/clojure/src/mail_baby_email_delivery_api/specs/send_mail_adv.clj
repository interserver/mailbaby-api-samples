(ns mail-baby-email-delivery-api.specs.send-mail-adv
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [mail-baby-email-delivery-api.specs.send-mail-adv-from :refer :all]
            [mail-baby-email-delivery-api.specs.send-mail-adv-to-inner :refer :all]
            [mail-baby-email-delivery-api.specs.send-mail-adv-replyto-inner :refer :all]
            [mail-baby-email-delivery-api.specs.send-mail-adv-cc-inner :refer :all]
            [mail-baby-email-delivery-api.specs.send-mail-adv-bcc-inner :refer :all]
            [mail-baby-email-delivery-api.specs.send-mail-adv-attachments-inner :refer :all]
            )
  (:import (java.io File)))


(def send-mail-adv-data
  {
   (ds/req :subject) string?
   (ds/req :body) string?
   (ds/req :from) send-mail-adv-from-spec
   (ds/req :to) (s/coll-of send-mail-adv-to-inner-spec)
   (ds/opt :replyto) (s/coll-of send-mail-adv-replyto-inner-spec)
   (ds/opt :cc) (s/coll-of send-mail-adv-cc-inner-spec)
   (ds/opt :bcc) (s/coll-of send-mail-adv-bcc-inner-spec)
   (ds/opt :attachments) (s/coll-of send-mail-adv-attachments-inner-spec)
   (ds/opt :id) int?
   })

(def send-mail-adv-spec
  (ds/spec
    {:name ::send-mail-adv
     :spec send-mail-adv-data}))
