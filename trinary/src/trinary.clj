(ns trinary)

(defn- binary? [s]
  (every? #{\0 \1 \2} s))

(defn to-decimal [s]
  (if (binary? s)
    (reduce + (map #(* (Integer/parseInt (str %1)) %2)
                   (reverse s)
                   (iterate (partial * 3) 1)))
    0))


