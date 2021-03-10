(ns proverb)

(defn- last-verse [a] (str "And all for the want of a " a "."))
(defn- verse [[a b]] (str "For want of a " a " the " b " was lost."))

(defn recite [pieces]
  (let [l (list (last-verse (first pieces)))]
    (if (not-empty pieces) (->> pieces
                                (partition 2 1)
                                (map verse)
                                (#(concat % l))
                                (clojure.string/join "\n"))
          "")))
