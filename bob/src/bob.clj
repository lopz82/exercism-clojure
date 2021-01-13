(ns bob
  (:require [clojure.string :as s]))

(defn valid-char? [s]
  (boolean (re-matches #"[A-Za-z?!]" (str s))))

(defn punctuation? [s]
  (contains? (set "?!") s))

(defn question? [s]
  (s/ends-with? s "?"))

(defn yelling? [s]
  (let [s (s/join (filter (complement punctuation?) s))]
    (if (s/blank? s)
      false
      (= s (s/upper-case s)))))

(defn response-for [s]
  (let [f (apply str (filter valid-char? s))]
    (cond
      (and (yelling? f)
           (question? f)) "Calm down, I know what I'm doing!"
      (yelling? f) "Whoa, chill out!"
      (question? f) "Sure."
      (empty? (s/trim s)) "Fine. Be that way!"
      :else "Whatever.")))
