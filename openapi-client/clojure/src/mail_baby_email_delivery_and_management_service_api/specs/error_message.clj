(ns mail-baby-email-delivery-and-management-service-api.specs.error-message
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def error-message-data
  {
   (ds/req :code) int?
   (ds/req :message) string?
   })

(def error-message-spec
  (ds/spec
    {:name ::error-message
     :spec error-message-data}))
