(ns gigasecond
  (:import java.util.Date)
  (:import java.text.SimpleDateFormat))

(defn from-string [s]
  (.parse (SimpleDateFormat. "yyyy MM dd") s))

(defn parse-date [date]
  (-> (clojure.string/join " " date)
      from-string
      .getTime))

(defn extract-date [date]
  (let [date (new Date date)]
    [(+ 1900 (.getYear date))
     (+ 1 (.getMonth date))
     (.getDate date)]))

(defn from [& date]
  (-> (parse-date date)
      (+ 1000000000000)
      (extract-date)))
