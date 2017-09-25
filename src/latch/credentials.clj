(ns latch.credentials
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [latch.crypto :as crypto]))

(defn ^:private slurp-and-decrypt [path]
  (when-let [resource (io/resource path)]
     (-> resource
         (slurp)
         (str/trim-newline)
         (crypto/decrypt "secret"))))

(def password (partial slurp-and-decrypt "password.txt"))
(def token (partial slurp-and-decrypt "token.txt"))
