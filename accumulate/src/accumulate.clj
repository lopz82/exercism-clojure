(ns accumulate)

(defn accumulate [f args] (for [arg args] (f arg)))
