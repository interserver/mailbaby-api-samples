(ns mail-baby-api.specs.mail-contact
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def mail-contact-data
  {
   (ds/req :email) string?
   (ds/opt :name) string?
   })

(def mail-contact-spec
  (ds/spec
    {:name ::mail-contact
     :spec mail-contact-data}))
