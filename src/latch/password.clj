(ns latch.password
  (:require [latch.crypto :as crypto]))

(def password-path "dev-resources/password.txt")
(def password #(crypto/decrypt (slurp password-path) "secret"))
