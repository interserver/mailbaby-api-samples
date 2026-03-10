(ns mail-baby-email-delivery-and-management-service-api.specs.mail-stats-volume
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def mail-stats-volume-data
  {
   (ds/opt :to) (s/map-of string? int?)
   (ds/opt :from) (s/map-of string? int?)
   (ds/opt :ip) (s/map-of string? int?)
   })

(def mail-stats-volume-spec
  (ds/spec
    {:name ::mail-stats-volume
     :spec mail-stats-volume-data}))
