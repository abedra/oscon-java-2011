(defproject availabl "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :main availabl.core
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [org.clojure/data.json "0.1.0"]
                 [org.clojure/tools.logging "0.2.0"]
                 [ring/ring-jetty-adapter "0.3.11"]
                 [ring/ring-core "0.3.11"]
                 [compojure "0.6.5"]]
  :dev-dependencies [[swank-clojure "1.3.0"]])