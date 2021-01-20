(ns bob
  (:require [clojure.string :as s]))

(defn has-letter? [s]
  (some #(Character/isLetter (int %)) s))

(defn question? [s]
  (s/ends-with? s "?"))

(defn yelling? [s]
  (and (= s (s/upper-case s))
       (has-letter? s)))

(defn response-for [s]
  (let [f (s/trim s)]
    (cond
      (and (yelling? f)
           (question? f)) "Calm down, I know what I'm doing!"
      (yelling? f) "Whoa, chill out!"
      (question? f) "Sure."
      (empty? s)) "Fine. Be that way!"
      :else "Whatever."))
