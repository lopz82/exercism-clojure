(ns scrabble-score)

(defn score-map [[string value]]
  (zipmap (map str string)
          (repeat (count string) value)))

(def SCORES
  {"AEIOULNRST" 1
   "DG"         2
   "BCMP"       3
   "FHVWY"      4
   "K"          5
   "JX"         8
   "QZ"         10})

(def SCORES-MAP (reduce merge {} (map score-map SCORES)))

(defn score-letter [letter]
  (SCORES-MAP (clojure.string/upper-case letter)))

(defn score-word [word]
  (->> word
       (map score-letter)
       (apply +)))
