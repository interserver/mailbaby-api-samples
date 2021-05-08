(ns mail-baby-api.specs.inline-response-401
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-401-data
  {
   (ds/req :code) string?
   (ds/req :message) string?
   })

(def inline-response-401-spec
  (ds/spec
    {:name ::inline-response-401
     :spec inline-response-401-data}))
