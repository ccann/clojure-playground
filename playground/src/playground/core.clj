(ns playground.core)

;; recursive itoa: returns int n as Java array of chars
(defn itoa [n]
  (let [is-neg (< n 0)
        pos-num (if is-neg (- 0 n) n)
        ascii-zero 48
        ascii-dash 45]
    (loop [num (/ pos-num 10)
           rem (mod pos-num 10)
           acc '()]
      (if (< (int num) 1)
        (if is-neg
          (to-array (cons (char ascii-dash) (cons (char (+ ascii-zero rem)) acc)))
          (to-array (cons (char (+ ascii-zero rem)) acc)))
        (recur (/ num 10) (mod num 10) (cons (char (+ ascii-zero rem)) acc))))))


;;FizzBuzz solution 1
(defn mult5? [n]
  (= 0 (mod n 5)))

(defn mult3? [n]
  (= 0 (mod n 3)))

(defn fizz-buzz []
  (for [x (map inc (range 100))]
    (cond (and (mult3? x) (mult5? x)) "FizzBuzz"
          (mult3? x) "Fizz"
          (mult5? x) "Buzz"
          :else x)))

;;FizzBuzz solution 2
(defn fizz-buzz2 []
  (map #(cond (= (mod % 15) 0) "FizzBuzz"
              (= (mod % 3) 0) "Fizz"
              (= (mod % 5) 0) "Buzz"
              :else %) (map inc (range 100))))
