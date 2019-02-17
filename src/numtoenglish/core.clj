(ns numtoenglish.core
  (:gen-class))


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
    (some? hunds) hunds
    (some? tens) tens
    :else ""))

(defn number->english
  [number]
  (if (= number 1000)
    (str "one thousand")
    (concat-numbers
     (hundreds->english (int (/ number 100)))
     (below-hundred->english (mod number 100)))))

(defn convert
  []
  (do
    (println "Number to English converter; please enter a number between 1 to 1000 inclusive; to quit press Enter")
    (loop [number (read-line)]
      (when (not= number "")
        (do
          (let [num (Integer. number)]
            (println (str "You entered: " num))
            (if (check-boundary num)
              (println (str "English: " (number->english num)))
              (println "Please enter a number between 1 to 1000 inclusive"))))
        (recur (read-line)))) ))

(defn -main
  "This is the entry point for the converter tool"
  [& args]
  (convert)
  )
