(ns advent-of-clojure.aoc-2021.day-01
  (:require [clojure.string :as string]))

(defn prep
  [input]
  (->>
   (string/split-lines input)
   (map #(Long/parseLong %))))

(defn part-1
  [input]
  (->>
   (prep input)
   (partition 2 1)
   (filter #(< (first %) (last %)))
   count))

(defn part-2
  [input]
  (->>
   (prep input)
   (partition 3 1)
   (partition 2 1)
   (filter #(< (reduce + (first %)) (reduce + (last %))))
   count))