(ns collatz-conjecture)

(defn collatz [num]
  (if (< num 1)
    (throw (IllegalArgumentException. (str "invalid n: " num)))
    (loop [n num i 0]
      (cond
        (= n 1) i
        (even? n) (recur (/ n 2) (inc i))
        :else (recur (+ 1 (* n 3)) (inc i))))))
