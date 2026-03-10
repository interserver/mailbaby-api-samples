(ns mail-baby-email-delivery-and-management-service-api.specs.send-mail
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [mail-baby-email-delivery-and-management-service-api.specs.send-mail-to :refer :all]
            )
  (:import (java.io File)))


(def send-mail-data
  {
   (ds/req :to) send-mail-to-spec
   (ds/req :from) string?
   (ds/req :subject) string?
   (ds/req :body) string?
   (ds/opt :id) int?
   })

(def send-mail-spec
  (ds/spec
    {:name ::send-mail
     :spec send-mail-data}))
