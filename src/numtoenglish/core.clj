(ns numtoenglish.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println args))

(def hede 5)

(def small-numbers
  {1 "one",
   2 "two",
   3 "three",
   4 "four",
   5 "five",
   6 "six",
   7 "seven",
   8 "eight",
   9 "nine",
   10 "ten",
   11 "eleven",
   12 "twelve",
   13 "thirteen",
   14 "fourteen",
   15 "fifteen",
   16 "sixteen",
   17 "seventeen",
   18 "eighteen",
   19 "nineteen"})

(def ten-products
  {20 "twenty",
   30 "thirty",
   40 "forty",
   50 "fifty",
   60 "sixty",
   70 "seventy",
   80 "eighty",
   90 "ninety"})

(defn check-boundary
  [n]
  (and (> n 0) (<= n 1000)))

;; might not be needed at all
(defn num->array
  [num]
  (reverse (.split (str num) "")))

(defn hundreds->english
  [digit]
  (when (not= digit 0)
      (str (get small-numbers digit) " hundred")))

(defn tens->english
  [digit]
  (if (= digit 0) ""
      (str (get ten-products digit))))

(defn below-hundred->english
  [num]
  (if (<= num 20)
    (get small-numbers num)
    (str
     (tens->english (* 10 (int (/ num 10))))
     " "
     (get small-numbers (mod num 10)))))

(defn concat-numbers
  [hunds tens]
  (cond
    (and (some? hunds) (some? tens)) (str hunds " and " tens)
    (and (some? hunds) (not (some? tens))) hunds
    (and (not (some? hunds)) (some? tens)) tens
    :else ""))

(defn number->english
  [number]
  (concat-numbers
   (hundreds->english (int (/ number 100)))
   (below-hundred->english (mod number 100))))


