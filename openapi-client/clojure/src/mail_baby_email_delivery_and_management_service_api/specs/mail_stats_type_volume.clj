(ns mail-baby-email-delivery-and-management-service-api.specs.mail-stats-type-volume
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def mail-stats-type-volume-data
  {
   (ds/opt :to) (s/map-of string? int?)
   (ds/opt :from) (s/map-of string? int?)
   (ds/opt :ip) (s/map-of string? int?)
   })

(def mail-stats-type-volume-spec
  (ds/spec
    {:name ::mail-stats-type-volume
     :spec mail-stats-type-volume-data}))
