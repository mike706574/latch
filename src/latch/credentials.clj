(ns latch.credentials
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [latch.crypto :as crypto]))

(defn ^:private exists?
  [arg]
  (.exists (io/file arg)))

(defn ^:private slurp-and-decrypt [path]
  (when (exists? path)
     (-> path
         (slurp)
         (str/trim-newline)
         (crypto/decrypt "secret"))))

(def password (partial slurp-and-decrypt "dev-resources/password.txt"))
(def token (partial slurp-and-decrypt "dev-resources/token.txt"))
