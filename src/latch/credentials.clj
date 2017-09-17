(ns latch.credentials
  (:require [latch.crypto :as crypto]))

(def ^:private password-path "dev-resources/password.txt")
(def password #(crypto/decrypt (slurp password-path) "secret"))

(def ^:private token-path "dev-resources/token.txt")
(def token #(slurp token-path))
