(ns drill.core
  (:use [clojure.contrib.str-utils2 :only (get tail)]))

(def front-words-pairs
  [
   ["Please"	"Favor de"]
   ["Don't"	"No"]
   ["You have to"	"Tiene"]
   ["You must"	"Debe"]
   ["I'm going to"	"Voy a"]
   ["You need to"	"Necesita"]
   ["Do you want to"	"¿Quiere"]
   ["Can you"	"¿Puede"]
   ["Do you like to"	"¿Le gusta"]
   ["Do you prefer to"	"¿Prefiere"]
   ["I would like to"	"Quisiera"]
   ["Let's"	"Vamos"]
   ["Could you"	"¿Podría"]
   ])

(def verb-pairs
  [
   ["come"	"venir"]
   ["consult"	"consultar"]
   ["drink"	"beber"]
   ["drive"	"manejar"]
   ["eat"	"comer"]
   ["follow"	"sequir"]
   ["go"   	"ir"]
   ["help"	"ayudar"]
   ["learn"	"aprender"]
   ["leave"	"salir"]
   ["listen"	"escuchar"]
   ["look"	"mirar"]
   ["plan"	"planear"]
   ["play"	"jugar"]
   ["practice"	"practicar"]
   ["read"	"leer"]
   ["run"	"correr"]
   ["sleep"	"dormir"]
   ["speak"	"hablar"]
   ["study"	"estudiar"]
   ["talk"	"platicar"]
   ["understand"	"entender"]
   ["wait"	"esperar"]
   ["walk"	"caminar"]
   ["work"	"trabajar"]
   ["write"	"escribir"]
   ])

(def front-words (map #(nth % 0) front-words-pairs))
(def verb (map #(nth % 0) verb-pairs))

(defn simple-frontwords-verb-question [fw-pair v-pair]
  (let [fw (nth fw-pair 0)
	v  (nth v-pair 0)
	fw-spanish (nth fw-pair 1)
	v-spanish  (nth v-pair 1)
	first-char-spanish (get fw-spanish 0)
	end-char-either (if (= first-char-spanish \¿) "?" ".")
	]
    (swank.core/break)))
    
(defn -main []
  (println "1. generated test question goes here") ;randomized drill item printed
  (let [feedback (read-line)]
    (print "2. input from keyboard is: '" feedback "'\n")
    ;; continues if user hits ENTER; to exit, type something
    (if-let [result (not (= feedback [""]))]
      (print "3a. input was '" feedback "'--my signal to EXIT PROGRAM\n")
      (do
	(println "3b. question answer goes here\n\n") ;answer, if given, printed here
	(recur)))))
