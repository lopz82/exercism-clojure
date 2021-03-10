(ns run-length-encoding)

(defn encode
  "encodes a single occurrence"
  [[f & r :as ch]]
  (cond->> f
           (seq r) (str (count ch))))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (->> plain-text
       (partition-by identity)
       (map encode)
       (apply str)))

(defn decode
  "decodes a single occurrence"
  [[_ num char]]
  (cond->> char
           ((complement empty?) num) (repeat (Integer/parseInt num))))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (->> cipher-text
       (re-seq #"(\d*)([a-zA-Z ])")
       (mapcat decode)
       (apply str)))
