(ns leap)

(defn divisible-by? [year n]
  (zero? (mod year n)))

(defn leap-year? [year]
  (or (and (divisible-by? year 4)
           (not (divisible-by? year 100)))
      (divisible-by? year 400)))
