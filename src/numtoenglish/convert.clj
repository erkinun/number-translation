(ns numtoenglish.convert)

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
  (and (integer? n) (> n 0) (<= n 1000)))

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
  (if (< num 20)
    (get small-numbers num)
    (apply str
     (interpose " "
                (filter some? [(tens->english (* 10 (int (/ num 10))))
                                   (get small-numbers (mod num 10))])))))

(defn concat-numbers
  [hunds tens]
  (cond
    (and (some? hunds) (some? tens)) (str hunds " and " tens)
    (some? hunds) hunds
    (some? tens) tens
    :else ""))

(defn number->english
  "converts a small number by converting hundreds and tens separately"
  [number]
  (if (= number 1000)
    (str "one thousand")
    (concat-numbers
     (hundreds->english (int (/ number 100)))
     (below-hundred->english (mod number 100)))))


(defn is-numeric
  "checks if a word supplied is numeric"
  [word]
  (= 0 (count (filter #(not (Character/isDigit %)) word))))

(defn convert
  "this is the main entry point for conversion, does the IO loop"
  []
  (do
    (println "Number to English converter; please enter a number between 1 to 1000 inclusive; to quit press Enter")
    (loop [number (read-line)]
      (when (not= number "")
        (if (is-numeric number) 
          (do
            (let [num (Integer. number)]
              (if (check-boundary num)
                (println (str "English: " (number->english num)))
                (println "Please enter a number between 1 to 1000 inclusive"))))
          (println "Please enter a number between 1 to 1000 inclusive"))
        (recur (read-line)))) ))

; convert-any
; reverting string
; map each char to an int
; group each 3 digits
; convert them with number->english
; zip them with appropriate and connectors

(defn divide-into-ts
  [n]
  (do
    (let [r (rem n 1000)
          div (int (/ n 1000))]
      (if (> div 0)
        (into  [r] (divide-into-ts div))
        [r]))))
