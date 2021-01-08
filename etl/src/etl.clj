(ns etl
  (:require [clojure.string :as s]))


(defn transform [source]
  (into {}
        (for [[key value] source]
          (zipmap (map s/lower-case value)
                  (repeat key)))))
