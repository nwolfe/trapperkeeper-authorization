(ns puppetlabs.trapperkeeper.authorization.ring
  (:require [schema.core :as schema])
  (:import (java.security.cert X509Certificate)))

;; schema

(def RequestMethod (schema/enum :get :post :put :delete :head :options))

(def Request
  "A ring request with an embedded optional SSL client certificate."
  {:uri schema/Str
   :request-method RequestMethod
   :remote-addr schema/Str
   (schema/optional-key :ssl-client-cert) X509Certificate
   schema/Keyword schema/Any})

