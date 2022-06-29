(ns mail-baby-email-delivery-api.specs.send-mail-adv-to-inner
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def send-mail-adv-to-inner-data
  {
   (ds/req :email) string?
   (ds/opt :name) string?
   })

(def send-mail-adv-to-inner-spec
  (ds/spec
    {:name ::send-mail-adv-to-inner
     :spec send-mail-adv-to-inner-data}))
