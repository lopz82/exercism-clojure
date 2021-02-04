(ns acronym
  (:require [clojure.string :as str]))

(defn acronym [s]
  (->> (re-seq #"[A-Z]+[a-z]*|[a-z]+" s)
       (map #(str/upper-case (first %)))
       (apply str)))
