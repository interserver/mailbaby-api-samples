(ns mail-baby-email-delivery-api.specs.send-mail-adv-bcc-inner
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def send-mail-adv-bcc-inner-data
  {
   (ds/req :email) string?
   (ds/opt :name) string?
   })

(def send-mail-adv-bcc-inner-spec
  (ds/spec
    {:name ::send-mail-adv-bcc-inner
     :spec send-mail-adv-bcc-inner-data}))
