(ns rna-transcription)

(def dna->rna {\G \C \C \G \T \A \A \U})

(defn to-rna [dna]
  (let [rna (apply str (map dna->rna dna))]
    (assert (= (count dna) (count rna)))
    rna))
