(ns pangram)

(defn pangram? [s]
  (= (set "thequickbrownfoxjumpsoverthelazydog")
     (set (filter #(Character/isLetter %) (clojure.string/lower-case s)))))

