(defproject fun.mike/latch "0.2.1-SNAPSHOT"
  :description "A project."
  :url "https://github.com/mike706574/latch"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.0.0"
  :dependencies [[commons-codec "1.10"]]
  :profiles {:dev {:source-paths ["dev"]
                   :target-path "target/dev"
                   :dependencies [[org.clojure/clojure "1.9.0-alpha20"]
                                  [org.clojure/tools.namespace "0.2.11"]]}}
  :repl-options {:init-ns user})
