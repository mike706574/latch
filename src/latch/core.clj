(ns latch.core
  (:refer-clojure :exclude [read])
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [latch.crypto :as crypto]))

(defn encrypt [text key] (crypto/encrypt text key))
(defn decrypt [text key] (crypto/decrypt text key))

(defn encrypted [path]
  (if-let [resource (io/resource path)]
     (-> resource
         (slurp)
         (str/trim-newline))
     (throw (ex-info (str path " not found.") {:path path}))))

(defn decrypted [path key]
  (decrypt (encrypted path) key))

(defn encrypted-password [] (encrypted "password.txt"))
(defn encrypted-token [] (encrypted "token.txt"))

(defn decrypted-password [key] (decrypt (encrypted-password) key))
(defn decrypted-token [key] (decrypt (encrypted-token) key))
