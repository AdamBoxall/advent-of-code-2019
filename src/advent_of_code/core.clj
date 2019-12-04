(ns advent-of-code.core
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn csv-resource->vec [resource]
  (vec (map #(vec (map read-string (str/split % #",")))
            (str/split-lines (slurp (io/resource resource))))))
