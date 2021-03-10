(ns isbn-verifier)

(def isbnmap (zipmap [\0 \1 \2 \3 \4 \5 \6 \7 \8 \9 \X]
                     (range)))

(defn isbn? [n]
  (and ((complement nil?) (re-matches #"\d-?\d{3}-?\d{5}-?[\dX]" n))
       (->> n
            (keep isbnmap)
            (map * (range 10 0 -1))
            (apply +)
            (#(mod % 11))
            (zero?))))
