(ns mail-baby-email-delivery-api.specs.get-mail-orders-401-response
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def get-mail-orders-401-response-data
  {
   (ds/req :code) string?
   (ds/req :message) string?
   })

(def get-mail-orders-401-response-spec
  (ds/spec
    {:name ::get-mail-orders-401-response
     :spec get-mail-orders-401-response-data}))
