(ns nth-prime)

(defn is-prime? [n]
  (every? (complement zero?) (map (partial mod n) (range 2, n))))

(defn nth-prime [n]
  (when (<= n 0)
    (throw (IllegalArgumentException. "index must be greater than 0")))
  (last (take n (filter is-prime? (iterate inc 2)))))





