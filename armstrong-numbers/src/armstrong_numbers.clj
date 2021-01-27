(ns armstrong-numbers)

(defn exp [base power]
  (reduce * 1 (repeat power base)))

(defn armstrong? [num]
  (= num (->> (seq (str num))
              (map #(Integer/parseInt (str %)))
              (map #(exp % (count (str num))))
              (reduce +))))

