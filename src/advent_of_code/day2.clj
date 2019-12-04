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
  (loop [noun 0 verb 0]
    (if (= 19690720 (first (evaluate (-> inputs
                                         (assoc 1 noun)
                                         (assoc 2 verb)))))
      [noun verb]
      (if-not (and (= verb 100) (= noun 100))
        (if (= verb 100)
          (recur (inc noun) 0)
          (recur noun (inc verb)))))))
