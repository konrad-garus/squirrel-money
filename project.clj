(defproject squirrel-money "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [com.h2database/h2 "1.3.159"]
                 [compojure "0.6.4"]
                 [ring/ring-core "0.3.11"]
                 [ring/ring-jetty-adapter "0.3.11"]
                 [clojure-csv/clojure-csv "1.3.2"]
                 [yaclot "0.1.1-SNAPSHOT"]]
  :main squirrel-money.core)