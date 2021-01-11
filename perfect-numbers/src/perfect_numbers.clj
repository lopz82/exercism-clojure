(ns perfect-numbers)

(defn factors [n]
  (->> (range 1 n)
       (filter #(zero? (mod n %)))))

(defn classify [n]
  (if (neg? n)
    (throw (IllegalArgumentException. "The provided number must be positive"))
    (let [sum (reduce + (factors n))]
      (cond
        (= sum n) :perfect
        (> sum n) :abundant
        :else :deficient))))
