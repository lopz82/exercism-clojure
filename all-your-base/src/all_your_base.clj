(ns all-your-base)

(defn exp [base n]
  (reduce * (repeat n base)))

(defn base->value [base n]
  (->> (count n)
       range
       reverse
       (map #(exp base %))
       (map * n)
       (reduce +)))

(defn value->base [base n]
  (loop [result nil
         num n]
    (if (zero? num)
      result
      (recur (conj result (mod num base)) (quot num base)))))

(defn convert [original n converted]
  (cond
    (some (partial >= 1) (list original converted)) nil
    (empty? n) '()
    (every? zero? n) '(0)
    (some neg? n) nil
    (some (partial <= original) n) nil
    :else (->> n
               (base->value original)
               (value->base converted))))







