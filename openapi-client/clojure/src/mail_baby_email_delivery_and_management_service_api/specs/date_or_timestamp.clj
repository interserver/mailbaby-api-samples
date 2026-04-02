(ns mail-baby-email-delivery-and-management-service-api.specs.date-or-timestamp
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def date-or-timestamp-data
  {
   })

(def date-or-timestamp-spec
  (ds/spec
    {:name ::date-or-timestamp
     :spec date-or-timestamp-data}))
