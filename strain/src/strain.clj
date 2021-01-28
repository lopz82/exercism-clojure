(ns strain)

(defn retain [pred col]
  (for [item col :when (pred item)] item))

(defn discard [pred col]
  (retain (complement pred) col))

