(ns kindergarten-garden)

(def children ["alice" "bob" "charlie" "david" "eve"
               "fred" "ginny" "harriet" "ileana" "joseph"
               "kincaid" "larry"])

(def plants {\G :grass \C :clover \R :radishes \V :violets})

(defn garden
  ([s]
   (garden s children))
  ([s students]
   (let [students (->> students (map #(keyword (clojure.string/lower-case %))) sort)]
     (->> (clojure.string/split s #"\n")
          (map (partial map plants))
          (map (partial partition 2))
          (map #(zipmap students %))
          (apply merge-with concat)))))
