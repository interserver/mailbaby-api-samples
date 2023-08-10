(ns mail-baby-email-delivery-and-management-service-api.specs.get-stats-200-response-inner
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def get-stats-200-response-inner-data
  {
   (ds/req :id) int?
   (ds/req :status) string?
   (ds/req :username) string?
   (ds/opt :password) string?
   (ds/opt :comment) string?
   })

(def get-stats-200-response-inner-spec
  (ds/spec
    {:name ::get-stats-200-response-inner
     :spec get-stats-200-response-inner-data}))
