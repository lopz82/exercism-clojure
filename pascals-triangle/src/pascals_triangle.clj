(ns pascals-triangle)

(defn add-row [prev]
  (map #(apply + %) (partition 2 1 (concat [0] prev [0]))))

(def triangle
  (iterate #(add-row %) [1N]))

(defn row [n]
  (nth triangle (dec n)))
