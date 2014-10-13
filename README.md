# compare

A tiny Clojure utility library with eight helper functions for using
`clojure.core/compare`: `<`, `>`, `<=`, `>=`, `min`, `max`, `min-key`,
and `max-key`.

Each works just like the corresponding function in `clojure.core`, but
accepts arbitrary `Comparable` objects like `clojure.core/compare`,
instead of only numbers.

## Obtainage

`[com.gfredericks/compare "0.1.1"]`

## Usage

``` clojure
(require '[com.gfredericks.compare :as compare])

(compare/>= "foo" "bar") ;; => true
(compare/min ["z"] ["h"] ["m"]) ;; => ["h"]
```

## License

Copyright © 2014 Gary Fredericks

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
