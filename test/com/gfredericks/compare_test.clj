(ns com.gfredericks.compare-test
  (:refer-clojure :exclude [< > <= >= min max min-key max-key])
  (:require [clojure.test :refer :all]
            [com.gfredericks.compare :refer [< > <= >= min max min-key max-key]]))

(deftest the-only-test
  ;; totally exhaustive
  (are [expr value] (= expr value)
       (max "foo" "bar" "_") "foo"
       (max :hey) :hey

       (min "seven") "seven"
       (min [8 110] [7 11] [9 9]) [7 11]

       (< :x93) true
       (< :x90 :z) true
       (< [3] [4] [2]) false

       (< ["hey"] ["hey"]) false
       (<= ["hey"] ["hey"] ["hey"]) true

       (> [100 0] [40 40]) true

       (>= :x :x :x :x :x :x :x :a) true
       (>= :x :x :x :x :x :x :x :z) false

       (min-key #(subvec % 1) [20 30] [30 1] [10 10]) [30 1]

       (max-key second
                ["foo" "bar" "Baz"]
                ["sake" "chomp"]
                ["welll" "aa" "aa" "aa"])
       ["sake" "chomp"]))
