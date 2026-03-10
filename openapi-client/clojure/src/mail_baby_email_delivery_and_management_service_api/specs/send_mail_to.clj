(ns mail-baby-email-delivery-and-management-service-api.specs.send-mail-to
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def send-mail-to-data
  {
   })

(def send-mail-to-spec
  (ds/spec
    {:name ::send-mail-to
     :spec send-mail-to-data}))
