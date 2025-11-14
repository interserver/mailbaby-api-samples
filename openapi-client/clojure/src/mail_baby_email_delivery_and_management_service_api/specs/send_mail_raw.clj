(ns mail-baby-email-delivery-and-management-service-api.specs.send-mail-raw
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def send-mail-raw-data
  {
   (ds/req :raw_email) string?
   (ds/opt :id) int?
   })

(def send-mail-raw-spec
  (ds/spec
    {:name ::send-mail-raw
     :spec send-mail-raw-data}))
