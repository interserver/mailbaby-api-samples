(ns mail-baby-email-delivery-and-management-service-api.specs.email-addresses-types
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def email-addresses-types-data
  {
   })

(def email-addresses-types-spec
  (ds/spec
    {:name ::email-addresses-types
     :spec email-addresses-types-data}))
