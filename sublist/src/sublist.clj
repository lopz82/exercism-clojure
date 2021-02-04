(ns sublist)

(defn list-contains?
  [list1 list2]
  (some (partial = list2)
        (partition (count list2) 1 list1)))

(defn classify
  [list1 list2]
  (let [len1 (count list1)
        len2 (count list2)]
    (cond
      (= list1 list2) :equal
      (and (> len1 len2) (list-contains? list1 list2)) :superlist
      (and (> len2 len1) (list-contains? list2 list1)) :sublist
      :else :unequal)))







