(ns nucleotide-count)

(def nuc-map '{\A 0, \T 0, \C 0, \G 0})

(defn nucleotide-counts [strand]
  {:pre [seq strand]}
  (merge nuc-map (frequencies strand)))


(defn count-of-nucleotide-in-strand [nucleotide strand]
  (if (contains? nuc-map nucleotide)
    (get (nucleotide-counts strand) nucleotide 0)
    (throw (IllegalArgumentException. (str "invalid nucleotide" nucleotide)))))
