(ns mail-baby-api.specs.body-1
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def body-1-data
  {
   (ds/opt :to) string?
   (ds/opt :from) string?
   (ds/opt :subject) string?
   (ds/opt :body) string?
   })

(def body-1-spec
  (ds/spec
    {:name ::body-1
     :spec body-1-data}))
