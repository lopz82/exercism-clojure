(ns robot-name)


(defn rand-char [x, y]
  (rand-nth (map char (range x y))))


(defn rand-name []
  (str (apply str (repeatedly 2 #(rand-char 65 91)))
       (apply str (repeatedly 3 #(rand-char 48 58)))))


(defn robot []
  (atom (rand-name)))


(defn robot-name [robot]
  @robot)


(defn reset-name [robot]
  (reset! robot (rand-name)))
