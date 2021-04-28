(ns mail-baby-api.specs.mail-log
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def mail-log-data
  {
   (ds/opt :id) int?
   })

(def mail-log-spec
  (ds/spec
    {:name ::mail-log
     :spec mail-log-data}))
