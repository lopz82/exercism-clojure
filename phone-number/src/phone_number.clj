(ns phone-number)

(defn parse [n]
  (re-matches #"^\+?1?\s*\(?([2-9]{1}[0-9]{2})\)?[.\s-]*([2-9]{1}[0-9]{2})[.\s-]*([0-9]{4})\s*$" n))

(defn number [num-string]
  (if-let [num (parse num-string)]
    (reduce str (rest num))
    "0000000000"))

(defn area-code [num-string]
  (second (parse num-string)))

(defn pretty-print [num-string]
  (let [match (rest (parse num-string))]
    (reduce str ["(" (first match) ") " (clojure.string/join "-" (rest match))])))
