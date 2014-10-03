(ns com.gfredericks.compare
  "Helper functions (max min < > <= >=) for clojure.core/compare."
  (:refer-clojure :exclude [max min < > <= >=]))

(defn max
  "Returns the greatest of the arguments according to
  clojure.core/compare, preferring later values."
  ([x] x)
  ([x y] (if (pos? (compare x y)) x y))
  ([x y & more]
     (reduce max (max x y) more)))

(defn min
  "Returns the least of the arguments according to
  clojure.core/compare, preferring later values."
  ([x] x)
  ([x y] (if (neg? (compare x y)) x y))
  ([x y & more]
     (reduce min (min x y) more)))

(defn <
  "Returns non-nil if args are in monotonically increasing order
  according to clojure.core/compare, otherwise false."
  ([x] true)
  ([x y] (neg? (compare x y)))
  ([x y & more]
   (if (< x y)
     (if (next more)
       (recur y (first more) (next more))
       (< y (first more)))
     false)))

(defn >
  "Returns non-nil if args are in monotonically decreasing order
  according to clojure.core/compare, otherwise false."
  ([x] true)
  ([x y] (pos? (compare x y)))
  ([x y & more]
   (if (> x y)
     (if (next more)
       (recur y (first more) (next more))
       (> y (first more)))
     false)))

(defn <=
  "Returns non-nil if args are in monotonically non-decreasing order
  according to clojure.core/compare, otherwise false."
  ([x] true)
  ([x y] (not (pos? (compare x y))))
  ([x y & more]
   (if (<= x y)
     (if (next more)
       (recur y (first more) (next more))
       (<= y (first more)))
     false)))

(defn >=
  "Returns non-nil if args are in monotonically non-increasing order
  according to clojure.core/compare, otherwise false."
  ([x] true)
  ([x y] (not (neg? (compare x y))))
  ([x y & more]
   (if (>= x y)
     (if (next more)
       (recur y (first more) (next more))
       (>= y (first more)))
     false)))
