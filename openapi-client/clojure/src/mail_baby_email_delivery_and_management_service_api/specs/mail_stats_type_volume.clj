(ns mail-baby-email-delivery-and-management-service-api.specs.mail-stats-type-volume
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-stats-type-volume-to :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-stats-type-volume-from :refer :all]
            [mail-baby-email-delivery-and-management-service-api.specs.mail-stats-type-volume-ip :refer :all]
            )
  (:import (java.io File)))


(def mail-stats-type-volume-data
  {
   (ds/opt :to) mail-stats-type-volume-to-spec
   (ds/opt :from) mail-stats-type-volume-from-spec
   (ds/opt :ip) mail-stats-type-volume-ip-spec
   })

(def mail-stats-type-volume-spec
  (ds/spec
    {:name ::mail-stats-type-volume
     :spec mail-stats-type-volume-data}))
