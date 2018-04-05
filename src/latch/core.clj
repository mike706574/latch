(ns latch.core
  (:refer-clojure :exclude [read])
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [latch.crypto :as crypto]))

(defn encrypt
  "Encrypts text using key."
  [text key]
  (crypto/encrypt text key))

(defn decrypt
  "Decrypts text using key."
  [text key]
  (crypto/decrypt text key))

(defn encrypted
  "Retrieves the encrypted content from path on the classpath."
  [path]
  (if-let [resource (io/resource path)]
     (-> resource
         (slurp)
         (str/trim-newline))
     (throw (ex-info (str path " not found.") {:path path}))))

(defn decrypted
  "Retrieves and decrypts the content from path on the classpath."
  [path key]
  (decrypt (encrypted path) key))

(defn encrypted-password
  "Retrieves the encrypted password from password.txt on the classpath."
  []
  (encrypted "password.txt"))

(defn encrypted-token
  "Retrieves the encrypted token from token.txt on the classpath."
  []
  (encrypted "token.txt"))

(defn decrypted-password
  "Decrypts the password from password.txt on the classpath using key."
  [key]
  (decrypt (encrypted-password) key))

(defn decrypted-token
  "Decrypts the token from token.txt on the classpath using key."
  [key] (decrypt (encrypted-token) key))
