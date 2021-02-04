(ns atbash-cipher
  (:require [clojure.string :as str]))

(def CODE
  (zipmap "abcdefghijklmnopqrstuvwxyz1234567890"
          (reverse "0987654321abcdefghijklmnopqrstuvwxyz")))

(defn encode [s]
  (->> s
       str/lower-case
       (filter #(Character/isLetterOrDigit %))
       (map CODE)
       (partition-all 5 5)
       (map str/join)
       (str/join " ")))
