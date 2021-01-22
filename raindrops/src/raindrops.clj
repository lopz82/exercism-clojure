(ns raindrops)

(defn- divisible-by? [factor, resp]
  (fn [num]
    (when (zero? (mod num factor)) resp)))

(def by-3? (divisible-by? 3 "Pling"))

(def by-5? (divisible-by? 5 "Plang"))

(def by-7? (divisible-by? 7 "Plong"))

(defn convert [n]
  (let [raindrop (map #(%1 %2) [by-3? by-5? by-7?] (repeat 3 n))]
    (if (every? nil? raindrop)
      (str n)
      (clojure.string/join raindrop))))
