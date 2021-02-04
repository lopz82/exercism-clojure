(ns armstrong-numbers)

(defn exp [base power]
  (apply * (repeat power base)))

(defn figures [n]
  (->> n
       (iterate #(quot % 10))
       (take-while pos?)
       (map #(mod % 10))))

(defn armstrong? [num]
  (->> num
       figures
       (map #(exp % (count (str num))))
       (apply +)
       (= num)))
