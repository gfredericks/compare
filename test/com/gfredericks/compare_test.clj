(ns com.gfredericks.compare-test
  (:refer-clojure :exclude [max min < > <= >=])
  (:require [clojure.test :refer :all]
            [com.gfredericks.compare :refer [max min < > <= >=]]))

(deftest the-only-test
  ;; totally exhaustive
  (are [expr value] (= expr value)
       (compare/max "foo" "bar" "_") "foo"
       (compare/max :hey) :hey

       (compare/min "seven") "seven"
       (compare/min [8 110] [7 11] [9 9]) [7 11]

       (< :x93) true
       (< :x90 :z) true
       (< [3] [4] [2]) false

       (< ["hey"] ["hey"]) false
       (<= ["hey"] ["hey"] ["hey"]) true

       (> [100 0] [40 40]) true

       (>= :x :x :x :x :x :x :x :a) true
       (>= :x :x :x :x :x :x :x :z) false))
