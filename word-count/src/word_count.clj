(ns word-count)

(defn word-count [s]
  (->> s
       clojure.string/lower-case
       (re-seq #"[A-Za-z0-9]+")
       frequencies))
