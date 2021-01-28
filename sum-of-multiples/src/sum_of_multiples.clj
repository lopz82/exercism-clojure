(ns sum-of-multiples)

(defn sum-of-multiples [divs top]
  (->> divs
       (mapcat #(range 0 top %))
       distinct
       (apply +)))
