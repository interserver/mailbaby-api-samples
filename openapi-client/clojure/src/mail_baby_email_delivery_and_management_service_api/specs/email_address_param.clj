(ns mail-baby-email-delivery-and-management-service-api.specs.email-address-param
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def email-address-param-data
  {
   (ds/req :email) string?
   })

(def email-address-param-spec
  (ds/spec
    {:name ::email-address-param
     :spec email-address-param-data}))
