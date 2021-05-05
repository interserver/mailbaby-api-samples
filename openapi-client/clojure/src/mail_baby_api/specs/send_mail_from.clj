(ns mail-baby-api.specs.send-mail-from
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def send-mail-from-data
  {
   (ds/req :email) string?
   (ds/opt :name) string?
   })

(def send-mail-from-spec
  (ds/spec
    {:name ::send-mail-from
     :spec send-mail-from-data}))
