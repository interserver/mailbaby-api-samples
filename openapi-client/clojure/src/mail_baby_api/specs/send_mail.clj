(ns mail-baby-api.specs.send-mail
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def send-mail-data
  {
   (ds/opt :to) string?
   (ds/opt :from) string?
   (ds/opt :subject) string?
   (ds/opt :body) string?
   })

(def send-mail-spec
  (ds/spec
    {:name ::send-mail
     :spec send-mail-data}))
