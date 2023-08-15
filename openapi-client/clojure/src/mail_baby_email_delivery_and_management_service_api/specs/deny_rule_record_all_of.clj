(ns mail-baby-email-delivery-and-management-service-api.specs.deny-rule-record-all-of
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def deny-rule-record-all-of-data
  {
   (ds/req :id) int?
   (ds/req :created) inst?
   })

(def deny-rule-record-all-of-spec
  (ds/spec
    {:name ::deny-rule-record-all-of
     :spec deny-rule-record-all-of-data}))
