(ns raindrops)

(defn- divisible-by? [factor num]
  (zero? (mod num factor)))

(defn convert [n]
  (cond-> nil
          (divisible-by? 3 n) (str "Pling")
          (divisible-by? 5 n) (str "Plang")
          (divisible-by? 7 n) (str "Plong")
          :always (or (str n))))
