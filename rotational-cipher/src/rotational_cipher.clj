(ns rotational-cipher)

(defn- rotator [start]
  (fn [c rot]
    (let [c (int c)
          s (int start)]
      (-> (- c s)
          (+ rot)
          (mod 26)
          (+ s)
          char))))

(def lower-rotator (rotator \a))
(def upper-rotator (rotator \A))

(defn- rotate-char [c rot]
  (cond
    (Character/isUpperCase c) (upper-rotator c rot)
    (Character/isLowerCase c) (lower-rotator c rot)
    :else c))

(defn rotate [letter rot]
  (->> (repeat rot)
       (map rotate-char letter)
       (apply str)))
