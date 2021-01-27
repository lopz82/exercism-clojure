(ns prime-factors)

(defn of [num]
  (loop [n num
         div 2
         primes []]
    (cond
      (= 1 n) primes
      (zero? (mod n div)) (recur (/ n div) div (conj primes div))
      :else (recur n (inc div) primes))))
