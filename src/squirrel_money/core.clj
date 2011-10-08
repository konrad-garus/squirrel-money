(ns squirrel-money.core
  (require 
    [clojure.contrib.sql :as sql]
    [compojure.core :as compojure]
    [compojure.route :as route]
    [ring.adapter.jetty :as ring-jetty])
  (:gen-class))

(defn pff [] "Lala")

(compojure/defroutes main-routes
  (compojure/GET "/" [] (str "<h1>" (pff) "</h1>"))
  (route/not-found "<h1>Page not found</h1>"))


;(defn -main [& args]
 ; (do
    (prn "Hello, world")
    (ring-jetty/run-jetty main-routes {:port 11080})
;  ))