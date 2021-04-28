(ns mail-baby-api.specs.error-response
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def error-response-data
  {
   (ds/req :code) string?
   (ds/req :message) string?
   })

(def error-response-spec
  (ds/spec
    {:name ::error-response
     :spec error-response-data}))
