(ns mail-baby-email-delivery-and-management-service-api.specs.mail-order-detail
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def mail-order-detail-data
  {
   (ds/req :id) int?
   (ds/req :status) string?
   (ds/req :username) string?
   (ds/req :password) string?
   (ds/opt :comment) string?
   })

(def mail-order-detail-spec
  (ds/spec
    {:name ::mail-order-detail
     :spec mail-order-detail-data}))
