(ns drill.core
  (:use [clojure.contrib.str-utils2 :only (tail)]))

(def short-front-map
  {
   "Please"	"Favor de"
   "Don't"	"No"
   "You have to"	"Tiene"
   "You must"	"Debe"
   "I'm going to"	"Voy a"
   "You need to"	"Necesita"
   "Do you want to"	"¿Quiere"
   "Can you"	"¿Puede"
   "Do you like to"	"¿Le gusta"
   "Do you prefer to"	"¿Prefiere"
   "I would like to"	"Quisiera"
   "Let's"	"Vamos"
   "Could you"	"¿Podría"
   })

(def verb-map
  {
   "come"	"venir"
   "consult"	"consultar"
   "drink"	"beber"
   "drive"	"manejar"
   "eat"	"comer"
   "follow"	"sequir"
   "go"   	"ir"
   "help"	"ayudar"
   "learn"	"aprender"
   "leave"	"salir"
   "listen"	"escuchar"
   "look"	"mirar"
   "plan"	"planear"
   "play"	"jugar"
   "practice"	"practicar"
   "read"	"leer"
   "run"	"correr"
   "sleep"	"dormir"
   "speak"	"hablar"
   "study"	"estudiar"
   "talk"	"platicar"
  "understand"	"entender"
   "wait"	"esperar"
   "walk"	"caminar"
   "work"	"trabajar"
   "write"	"escribir"
   })

(def short-front (keys short-front-map))
(def verb (keys verb-map))

(defn ex1 []
  (let [rnd-sf-english (rand-nth short-front)
	rnd-verb-english (rand-nth verb)
	rnd-sf-spanish (short-front-map rnd-sf-english)
	rnd-verb-spanish (verb-map rnd-verb-english)]
    (println rnd-sf-english rnd-verb-english)
    (println rnd-sf-spanish rnd-verb-spanish)))

(defn -main []
  (println "1. generated test question goes here") ;randomized drill item printed
  (let [feedback (read-line)]
    (print "2. input from keyboard is: '" feedback "'\n")
    ;; continues if user hits ENTER; to exit, type something
    (if-let [result (not (= feedback ""))]
      (print "3a. input was '" feedback "'--my signal to EXIT PROGRAM\n")
      (do
	(println "3b. question answer goes here\n\n") ;answer, if given, printed here
	(recur)))))
