(ns advent-of-clojure.aoc-2021.day-03)

(defn prep
  [input]
  (for [[_ command value] (re-seq #"(\w+)\s+(\d+)" input)]
    {:command (keyword command)
     :value (Long/parseLong value)}))

(defn part-1 [input] 0)
(defn part-2 [input] 0)