(ns mail-baby-email-delivery-api.specs.mail-log-entry
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def mail-log-entry-data
  {
   (ds/req :_id) int?
   (ds/req :id) string?
   (ds/req :from) string?
   (ds/req :to) string?
   (ds/req :subject) string?
   (ds/req :messageId) string?
   (ds/req :created) string?
   (ds/req :time) int?
   (ds/req :user) string?
   (ds/req :transtype) string?
   (ds/req :transhost) string?
   (ds/req :originhost) string?
   (ds/req :origin) string?
   (ds/req :interface) string?
   (ds/req :date) string?
   (ds/req :sendingZone) string?
   (ds/req :bodySize) int?
   (ds/req :sourceMd5) string?
   (ds/req :seq) int?
   (ds/req :domain) string?
   (ds/req :recipient) string?
   (ds/req :locked) int?
   (ds/req :lockTime) int?
   (ds/req :assigned) string?
   (ds/req :queued) string?
   (ds/req :_lock) string?
   (ds/req :logger) string?
   (ds/req :mxPort) int?
   (ds/req :connectionKey) string?
   (ds/req :mxHostname) string?
   (ds/req :sentBodyHash) string?
   (ds/req :sentBodySize) int?
   (ds/req :md5Match) int?
   })

(def mail-log-entry-spec
  (ds/spec
    {:name ::mail-log-entry
     :spec mail-log-entry-data}))
