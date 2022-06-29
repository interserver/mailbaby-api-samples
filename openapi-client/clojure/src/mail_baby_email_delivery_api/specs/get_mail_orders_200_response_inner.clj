(ns mail-baby-email-delivery-api.specs.get-mail-orders-200-response-inner
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def get-mail-orders-200-response-inner-data
  {
   (ds/req :id) int?
   (ds/req :status) string?
   (ds/req :username) string?
   (ds/opt :password) string?
   (ds/opt :comment) string?
   })

(def get-mail-orders-200-response-inner-spec
  (ds/spec
    {:name ::get-mail-orders-200-response-inner
     :spec get-mail-orders-200-response-inner-data}))
