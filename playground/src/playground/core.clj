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
