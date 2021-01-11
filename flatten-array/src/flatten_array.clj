(ns flatten-array)

(defn flatten [arr]
  (filter number? (tree-seq sequential? seq arr)))
