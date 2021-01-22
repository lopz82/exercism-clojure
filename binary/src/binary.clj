(ns binary)

(defn- binary? [n]
  (every? #{\0 \1} n))

(defn to-decimal [n]
  (if (binary? n)
    (apply +
           (map #(* (Integer/parseInt (str %1)) %2)
                (reverse n)
                (iterate (partial * 2) 1)))
    0))







