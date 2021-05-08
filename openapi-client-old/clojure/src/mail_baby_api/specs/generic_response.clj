(ns mail-baby-api.specs.generic-response
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def generic-response-data
  {
   (ds/opt :status) string?
   (ds/opt :text) string?
   })

(def generic-response-spec
  (ds/spec
    {:name ::generic-response
     :spec generic-response-data}))
