(ns advent-of-code.day1
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [advent-of-code.core :as core]))

(def inputs
  (first (core/csv-resource->vec "day1.csv")))

(defn mass->fuel [mass]
  (-> mass (/ 3) int (- 2)))

(defn part1 []
  (reduce + (map mass->fuel inputs)))

(defn part2 []
  (reduce + (map (fn [mass]
                   (loop [fuel (mass->fuel mass)
                          extra (mass->fuel fuel)]
                     (if (< extra 0)
                       fuel
                       (recur (+ fuel extra)
                              (mass->fuel extra)))))
                 inputs)))
