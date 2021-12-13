(ns advent-of-clojure.core
  (:require [advent-of-clojure.aoc-2021.day-01]
            [advent-of-clojure.aoc-2021.day-02]
            [clojure.string :as string])
  (:use [clansi :only [style]]))

(defn read-input
  [day]
  (slurp (clojure.java.io/resource day)))

(defn call-aoc
  [year day part input]
  (apply (resolve (symbol (format "advent-of-clojure.aoc-%4d.day-%02d/part-%d" year day part))) [input]))

(defn run-part
  [year day part configs]
  (println (str ">> Part " part ":"))
  (loop [[config & rest] configs]
    (let [[file expected] config
          input (read-input file)
          answer (call-aoc year day part input)]
      (print (str "File: " file))
      (if (= answer expected)
        (do
          (println (str ", success: " (style answer :green :underline)))
          (if rest (recur rest)))
        (println (str ", wanted: " (style expected :yellow) ", got: " (style answer :red)))))))

(defn run
  [year day]
  (case [year day]
    [2021 1] (do
               (run-part
                year day 1
                '(["day-01.example.txt", 7]
                  ["day-01.input.txt", 1754]))

               (run-part
                year day 2
                '(["day-01.example.txt", 5]
                  ["day-01.input.txt", 1789])))

    [2021 2] (do
               (run-part
                year day 1
                '(["day-02.example.txt", 150]
                  ["day-02.input.txt", 2150351]))

               (run-part
                year day 2
                '(["day-02.example.txt", 900]
                  ["day-02.input.txt", 1842742223])))

    (println (str "AoC " year " exercise day " day " not implemented."))))

(defn -main
  "Used to dispatch tasks from the command line."
  [part]
  (->>
   (string/split part #"\.")
   (map #(Integer/parseInt %))
   (apply run)))
