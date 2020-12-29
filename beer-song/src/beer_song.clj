(ns beer-song)

(defn verse
  "Returns the nth verse of the song."
  [num]
  (case num
    0 (str "No more bottles of beer on the wall, no more bottles of beer.\n"
           "Go to the store and buy some more, 99 bottles of beer on the wall.\n")
    1 (str "1 bottle of beer on the wall, 1 bottle of beer.\n"
           "Take it down and pass it around, no more bottles of beer on the wall.\n")
    2 (str "2 bottles of beer on the wall, 2 bottles of beer.\n"
           "Take one down and pass it around, 1 bottle of beer on the wall.\n")
    (str num " bottles of beer on the wall, " num " bottles of beer.\n"
         "Take one down and pass it around, " (- num 1) " bottles of beer on the wall.\n"))
  )


(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start]
   (sing start 0))
  ([start end]
   (clojure.string/join "\n" (map verse (range start (dec end) -1)))
   ))
