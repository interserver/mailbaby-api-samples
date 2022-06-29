(ns mail-baby-email-delivery-api.specs.send-mail-adv-cc-inner
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def send-mail-adv-cc-inner-data
  {
   (ds/req :email) string?
   (ds/opt :name) string?
   })

(def send-mail-adv-cc-inner-spec
  (ds/spec
    {:name ::send-mail-adv-cc-inner
     :spec send-mail-adv-cc-inner-data}))
