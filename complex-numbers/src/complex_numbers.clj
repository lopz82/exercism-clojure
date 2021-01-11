(ns complex-numbers)

(defn sq [x]
  (reduce * (repeat 2 x)))

(defn sum-squares [[& n]]
  (reduce + (map sq n)))

(def real first)

(def imaginary second)

(defn conjugate [[a b]]
  [a (* -1 b)])

(def add (partial map +))

(def sub (partial map -))

(defn mul [[a b] [c d]]
  [(apply - (map * [a b] [c d]))
   (apply + (map * [a b] (reverse [c d])))])

(defn div [[a b] [c d]]
  (map double [(/ (apply + (map * [a b] [c d]))
                  (sum-squares [c d]))
               (/ (apply - (map * (reverse [a b]) [c d]))
                  (sum-squares [c d]))]))

(defn abs [[a b]]
  (Math/sqrt (apply + (map #(sq %) [a b]))))
