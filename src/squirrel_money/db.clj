(ns squirrel-money.db
  (require 
    [clojure-csv.core :as csv]
    [clojure.contrib.duck-streams :as s]
    [clojure.contrib.sql :as sql]
    [yaclot.core :as y])
  (:gen-class))

(def *db* {:classname   "org.h2.Driver"
           :subprotocol "h2"
           :subname (str "file:./money")
           :user     ""
           :password ""})
 
(sql/with-connection *db*
  (do
    (sql/with-query-results rs ["select * from expense limit 10"]
                            (dorun (map #(println (:expense_id %)) rs)))
    (sql/with-query-results rs ["select count(*) from expense"]
                            (dorun (map #(println %) rs)))))

(def db-expense {:category (y/to-type String)
                 :subcategory (y/to-type String)
                 :detail (y/to-type String)
                 :value (y/to-type BigDecimal)
                 :date (y/to-type java.util.Date)})

(defn add-expense [record]
  (do (prn record) (prn (y/map-convert record db-expense))
  (sql/with-connection
    *db*
    (sql/insert-records "expense" (y/map-convert record db-expense)))))

(doall
  (map 
    #(add-expense (zipmap [:category :subcategory :detail :value :date] %))
    (take 10 (rest (csv/parse-csv (slurp "oszczednosci.csv"))))))