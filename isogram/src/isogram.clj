(ns isogram)

(defn isogram? [s]
  (->> s
       clojure.string/lower-case
       (filter #(Character/isLetter %))
       frequencies
       (every? #(= 1 (second %)))))
