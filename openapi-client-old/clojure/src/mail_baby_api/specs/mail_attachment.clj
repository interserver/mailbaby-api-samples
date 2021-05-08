(ns mail-baby-api.specs.mail-attachment
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def mail-attachment-data
  {
   (ds/req :data) any?
   (ds/opt :filename) string?
   })

(def mail-attachment-spec
  (ds/spec
    {:name ::mail-attachment
     :spec mail-attachment-data}))
