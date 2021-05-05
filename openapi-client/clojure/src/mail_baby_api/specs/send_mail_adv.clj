(ns mail-baby-api.specs.send-mail-adv
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [mail-baby-api.specs.send-mail-adv-from :refer :all]
            [mail-baby-api.specs.mail-contact :refer :all]
            [mail-baby-api.specs.mail-contact :refer :all]
            [mail-baby-api.specs.mail-contact :refer :all]
            [mail-baby-api.specs.mail-contact :refer :all]
            [mail-baby-api.specs.mail-attachment :refer :all]
            )
  (:import (java.io File)))


(def send-mail-adv-data
  {
   (ds/req :subject) string?
   (ds/req :body) string?
   (ds/req :from) (s/coll-of send-mail-adv-from-spec)
   (ds/req :to) (s/coll-of mail-contact-spec)
   (ds/req :id) int?
   (ds/opt :replyto) (s/coll-of mail-contact-spec)
   (ds/opt :cc) (s/coll-of mail-contact-spec)
   (ds/opt :bcc) (s/coll-of mail-contact-spec)
   (ds/opt :attachments) (s/coll-of mail-attachment-spec)
   })

(def send-mail-adv-spec
  (ds/spec
    {:name ::send-mail-adv
     :spec send-mail-adv-data}))
