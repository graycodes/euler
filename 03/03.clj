(ns example.core
  (:require [clojure.math.numeric-tower :as math]))

(def number 600851475143)

(defn isPrime [num] 
  (if (< num 3)
    true
    (if (= (mod num 2) 0)
      false
      (loop [rng (range 3 (+ 1 (math/sqrt num)))]
        (if (= 0 (count rng))
          true
          (if (= 0 (mod num (first rng)))
            false
            (recur (rest rng))))))))

(defn isFacOf [small large]
  (= 0 (mod large small)))

(defn isFacOfNum [small]
  (isFacOf small number))

(defn largestPrime [num]
  (let [facs (filter isFacOfNum (range (int (math/ceil (math/sqrt num))) 0 -1))]
    (first (filter isPrime facs))))

