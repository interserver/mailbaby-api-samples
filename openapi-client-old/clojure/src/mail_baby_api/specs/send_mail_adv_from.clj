(ns mail-baby-api.specs.send-mail-adv-from
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def send-mail-adv-from-data
  {
   (ds/req :email) string?
   (ds/opt :name) string?
   })

(def send-mail-adv-from-spec
  (ds/spec
    {:name ::send-mail-adv-from
     :spec send-mail-adv-from-data}))
