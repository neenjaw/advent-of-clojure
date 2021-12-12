(ns advent-of-clojure.core
  (:require [advent-of-clojure.aoc-2021.day-01]
            [clojure.string :as string]))

(defn read-input
  [day]
  (slurp (clojure.java.io/resource day)))

(defn run-part
  [part part-fn configs]
  (println (str ">> Part " part ":"))
  (loop [[config & rest] configs]
    (let [[file expected] config
          input (read-input file)
          answer (part-fn input)]
      (print (str "File: " file))
      (if (= answer expected)
        (do
          (println (str ", got expected: " answer))
          (if rest (recur rest)))
        (println (str ", wanted: " expected ", got: " answer))))))

(defn run
  [year day]
  (case [year day]
    [2021 1] (do
               (run-part
                1
                advent-of-clojure.aoc-2021.day-01/part-1
                '(["day-01.example.txt", 7]
                  ["day-01.input.txt", 1754]))

               (run-part
                2
                advent-of-clojure.aoc-2021.day-01/part-2
                '(["day-01.example.txt", 5]
                  ["day-01.input.txt", 1789])))

    (println (str "AoC " year " exercise day " day " not implemented."))))

(defn -main
  "Used to dispatch tasks from the command line."
  [part]
  (let [parts (map #(Integer/parseInt %) (string/split part #"\."))]
    (apply run parts)))
