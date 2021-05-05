(ns mail-baby-api.specs.body
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def body-data
  {
   (ds/opt :to) string?
   (ds/opt :from) string?
   (ds/opt :subject) string?
   (ds/opt :body) string?
   })

(def body-spec
  (ds/spec
    {:name ::body
     :spec body-data}))
