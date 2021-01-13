(ns binary-search)

(defn middle [vec]
  (quot (count vec) 2))

(defn search-for [num vec]
  (loop [v vec
         pos 0]
    (let [mid-pos (middle v)
          mid-value (nth v mid-pos)]
      (cond
        (and (not= mid-value num)
             (= 1 (count v))) (throw (IllegalArgumentException. (str "not found")))
        (= mid-value num) (+ pos mid-pos)
        (< mid-value num) (recur (take-last (/ (count v) 2) v) (+ pos mid-pos))
        (> mid-value num) (recur (take (/ (count v) 2) v) pos)))))
