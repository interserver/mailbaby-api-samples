(ns mail-baby-email-delivery-and-management-service-api.specs.raw-mail
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def raw-mail-data
  {
   (ds/req :raw_email) string?
   })

(def raw-mail-spec
  (ds/spec
    {:name ::raw-mail
     :spec raw-mail-data}))
