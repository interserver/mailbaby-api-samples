(ns mail-baby-email-delivery-api.specs.send-mail-adv-attachments-inner
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def send-mail-adv-attachments-inner-data
  {
   (ds/req :data) any?
   (ds/opt :filename) string?
   })

(def send-mail-adv-attachments-inner-spec
  (ds/spec
    {:name ::send-mail-adv-attachments-inner
     :spec send-mail-adv-attachments-inner-data}))
