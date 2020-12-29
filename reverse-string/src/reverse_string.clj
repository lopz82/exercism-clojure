(ns reverse-string)

(defn reverse-string [s]
  (clojure.string/join (map str
                            (reduce conj
                                    '()
                                    s))))
