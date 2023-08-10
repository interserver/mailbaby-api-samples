(ns mail-baby-email-delivery-and-management-service-api.specs.email-address
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def email-address-data
  {
   (ds/opt :email) string?
   })

(def email-address-spec
  (ds/spec
    {:name ::email-address
     :spec email-address-data}))
