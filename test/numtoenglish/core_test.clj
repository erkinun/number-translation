(ns numtoenglish.core-test
  (:require [clojure.test :refer :all]
            [numtoenglish.core :refer :all]
            [numtoenglish.convert :refer :all]))

(deftest number->english->tests
  (testing "1 should return one"
    (is (= "one" (number->english 1))))
  (testing "20 should return twenty"
    (is (= "twenty" (number->english 20))))
  (testing "241 should return two hundred and forty one"
    (is (= "two hundred and forty one" (number->english 241))))
  (testing "1000 should return one thousand"
    (is (= "one thousand" (number->english 1000)))))

(deftest boundary-tests
  (testing "non numeric input should return false"
    (is (= false (check-boundary "some_name")))))

(deftest only-tens-conversion
  (testing "42 should return forty two"
    (is (= "forty two" (number->english 42)))))

(deftest only-hundreds-conversion
  (testing "200 should return two hundred"
    (is (= "two hundred" (number->english 200)))))

(deftest hundreds->englist-test
  (testing "2 should return as two hundred"
    (is (= "two hundred" (hundreds->english 2)))))

(deftest tens->english-test
  (testing "30 should return as thirty"
    (is (= "thirty" (tens->english 30)))))

(deftest below-hundred-test
  (testing "74 should return seventy four"
    (is (= "seventy four" (below-hundred->english 74)))))

(deftest hundreds->english-test
  (testing "0 should return nil from this function"
    (is (= nil (hundreds->english 0)))))

(deftest isnumeric-test
  (testing "123 should return true"
    (is (= true (is-numeric "123"))))
  (testing "erkin123 should return false"
    (is (= false (is-numeric "erkin123")))))
