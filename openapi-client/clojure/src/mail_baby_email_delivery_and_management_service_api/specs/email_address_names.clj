(ns mail-baby-email-delivery-and-management-service-api.specs.email-address-names
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def email-address-names-data
  {
   })

(def email-address-names-spec
  (ds/spec
    {:name ::email-address-names
     :spec email-address-names-data}))
