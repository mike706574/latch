(ns latch.credentials
  (:require [clojure.java.io :as io]
            [latch.crypto :as crypto]))

(defn ^:private exists?
  [arg]
  (.exists (io/file arg)))

(def ^:private password-path "dev-resources/password.txt")
(def password #(when (exists? password-path)
                 (crypto/decrypt (slurp password-path) "secret")))

(def ^:private token-path "dev-resources/token.txt")
(def token (when (exists? token-path)
             (crypto/decrypt (slurp token-path) "secret")))
