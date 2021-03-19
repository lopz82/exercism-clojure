(ns anagram
  (:require [clojure.string :as str]))

(defn anagram? [w freq prospect]
  (let [prosp (str/lower-case prospect)
        prosp-frec (frequencies prosp)]
    (and (not= w prosp)
         (= freq prosp-frec))))

(defn anagrams-for [word prospect-list]
  (let [w (str/lower-case word)
        freq (frequencies w)]
    (->> prospect-list
         (filter (partial anagram? w freq)))))
