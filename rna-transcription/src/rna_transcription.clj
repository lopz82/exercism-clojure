(ns rna-transcription)

(def dna-rna (zipmap [\G \C \T \A] [\C \G \A \U]))

(defn transcript [n]
  {:post [%]}
  (dna-rna n))

(defn to-rna [dna]
  (->> dna
       (map transcript)
       (apply str)))
