(ns advent-of-code.day1
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [advent-of-code.core :as core]))

(def inputs
  (first (core/csv-resource->vec "day1.csv")))

(defn mass->fuel [mass]
  (-> mass (quot 3) (- 2)))

(defn mass->total-fuel [mass]
  (reduce + (rest (take-while pos? (iterate mass->fuel mass)))))

(defn part1 []
  (reduce + (map mass->fuel inputs)))

(defn part2 []
  (reduce + (map mass->total-fuel inputs)))
