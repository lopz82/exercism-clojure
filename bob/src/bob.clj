(ns bob)

(def valid-chars (into #{} (concat (map char (concat (range 97 123) ;; uppercase letter
                                                     (range 65 91))) ;; lowercase letters
                                   [\? \!])))

(defn valid-char? [s]
  (contains? valid-chars s))

(defn question? [s]
  (= \? (last s)))

(defn yelling? [s]
  (if (or (empty? s) (= "?" s))
    false
    (= s (clojure.string/upper-case s))))

(defn response-for [s]
  (let [f (apply str (filter valid-char? s))]
    (cond
      (and (yelling? f) (question? f)) "Calm down, I know what I'm doing!"
      (yelling? f) "Whoa, chill out!"
      (question? f) "Sure."
      (empty? (clojure.string/trim s)) "Fine. Be that way!"
      :else "Whatever.")))
