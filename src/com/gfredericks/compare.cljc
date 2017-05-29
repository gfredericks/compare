(ns com.gfredericks.compare
  "Helper functions (max min < > <= >=) for clojure.core/compare."
  (:refer-clojure :exclude [< > <= >= min max min-key max-key]))

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

(defn max
  "Returns the greatest of the arguments according to
  clojure.core/compare, preferring later values."
  ([x] x)
  ([x y] (if (> x y) x y))
  ([x y & more]
     (reduce max (max x y) more)))

(defn min
  "Returns the least of the arguments according to
  clojure.core/compare, preferring later values."
  ([x] x)
  ([x y] (if (< x y) x y))
  ([x y & more]
     (reduce min (min x y) more)))

(defn min-key
  "Returns the x for which (k x) is least, according to
  clojure.core/compare."
  ([k x] x)
  ([k x y] (if (< (k x) (k y)) x y))
  ([k x y & more]
   (reduce #(min-key k %1 %2) (min-key k x y) more)))

(defn max-key
  "Returns the x for which (k x) is greatest, according to
  clojure.core/compare."
  ([k x] x)
  ([k x y] (if (> (k x) (k y)) x y))
  ([k x y & more]
   (reduce #(max-key k %1 %2) (max-key k x y) more)))
