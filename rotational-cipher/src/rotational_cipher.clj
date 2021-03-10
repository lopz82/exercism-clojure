(ns rotational-cipher)

(defn- rotator [s]
  (fn [c rot]
    (let [c (int c)]
      (-> (- c s)
          (+ rot)
          (mod 26)
          (+ s)
          char))))

(def lower-rotator (rotator (int \a)))
(def upper-rotator (rotator (int \A)))

(defn- rotate-char [rot c]
  (cond-> c
    (Character/isUpperCase c) (upper-rotator rot)
    (Character/isLowerCase c) (lower-rotator rot)))

(defn rotate [letter rot]
  (->> letter
       (map (partial rotate-char rot))
       (apply str)))
