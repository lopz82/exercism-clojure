(ns hexadecimal)

(def hexmap (zipmap (map #(first (str %)) "0123456789abcdef")
                    (range)))

(defn- powers [s]
  (->> (count s)
       range
       reverse
       (map #(Math/pow 16 %))))

(defn hex-to-int [hex]
  (if (every? hexmap hex)
    (let [vals (map hexmap hex)]
      (->> hex
           powers
           (map * vals)
           (reduce +)
           int))
    0))

