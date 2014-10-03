# compare

A tiny Clojure utility library with six helper functions for using
`clojure.core/compare`: `max`, `min`, `<`, `>`, `<=`, and `>=`.

## Obtainage

`[com.gfredericks/compare "0.1.0"]`

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
