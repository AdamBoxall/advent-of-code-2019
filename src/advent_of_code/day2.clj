(ns advent-of-code.day2
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [advent-of-code.core :as core]))

(def inputs
  (first (core/csv-resource->vec "day2.csv")))

(defn evaluate [instructions]
  (reduce (fn [results [opcode noun verb position]]
            (let [f (if (= 1 opcode) + *)]
              (assoc results position
                             (f (nth results noun)
                                (nth results verb)))))
          instructions
          (take (.indexOf (take-nth 4 instructions) 99)
                (partition 4 instructions))))

(defn part1 []
  (first (evaluate inputs)))

(defn part2 []
  (for [noun (range 100)
        verb (range 100)
        :let [output (first (evaluate (-> inputs
                                          (assoc 1 noun)
                                          (assoc 2 verb))))]
        :when (= 19690720 output)]
    [noun verb]))
