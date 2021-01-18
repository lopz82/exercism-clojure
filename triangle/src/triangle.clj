(ns triangle)

(defn inits [s] (filter seq (reductions conj [] s)))

(defn tails [s] (take-while seq (iterate rest s)))

(defn comb [s] (map #(rest (concat %1 %2)) (tails s) (inits s)))

(defn triangle-identity? [s] (> (apply + (rest s)) (first s)))

(defn valid? [sides]
  (and (every? triangle-identity? (comb sides))
       (every? pos? sides)))

(defn different-sides [sides f n]
  (if (valid? sides)
    (f n (count (set sides)))
    false))

(defn equilateral? [& sides]
  (different-sides sides = 1))

(defn isosceles? [& sides]
  (different-sides sides >= 2))

(defn scalene? [& sides]
  (different-sides sides = 3))
