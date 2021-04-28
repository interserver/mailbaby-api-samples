(ns mail-baby-api.specs.send-mail
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [mail-baby-api.specs.mail-contact :refer :all]
            [mail-baby-api.specs.mail-contact :refer :all]
            [mail-baby-api.specs.mail-contact :refer :all]
            [mail-baby-api.specs.mail-contact :refer :all]
            [mail-baby-api.specs.mail-contact :refer :all]
            [mail-baby-api.specs.mail-attachment :refer :all]
            )
  (:import (java.io File)))


(def send-mail-data
  {
   (ds/req :id) int?
   (ds/req :from) mail-contact-spec
   (ds/req :to) (s/coll-of mail-contact-spec)
   (ds/req :subject) string?
   (ds/req :body) string?
   (ds/opt :replyto) (s/coll-of mail-contact-spec)
   (ds/opt :cc) (s/coll-of mail-contact-spec)
   (ds/opt :bcc) (s/coll-of mail-contact-spec)
   (ds/opt :attachments) (s/coll-of mail-attachment-spec)
   })

(def send-mail-spec
  (ds/spec
    {:name ::send-mail
     :spec send-mail-data}))
