(ns grains)

(defn square [n]
  (reduce *
          (repeat (dec n)
                  (bigint 2))))

(defn total []
  (reduce +
          (map square
               (range 1 (inc 64)))))
