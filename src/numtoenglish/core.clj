(ns numtoenglish.core
  (:require [numtoenglish.convert :as convert])
  (:gen-class))


(defn -main
  "This is the entry point for the converter tool"
  [& args]
  (convert/convert))
