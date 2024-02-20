(ns mail-baby-email-delivery-and-management-service-api.specs.email-address-types
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def email-address-types-data
  {
   (ds/req :email) string?
   (ds/opt :name) string?
   })

(def email-address-types-spec
  (ds/spec
    {:name ::email-address-types
     :spec email-address-types-data}))
