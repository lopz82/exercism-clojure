(ns series)

(defn slices [string length]
  (cond
    (empty? string) []
    (zero? length) [""]
    :else (map clojure.string/join (partition length 1 string))))


