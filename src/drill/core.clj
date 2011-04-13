(ns drill.core)

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
	first-char-spanish (subs fw-spanish 0 1)
	end-char-english (if (= first-char-spanish \¿) "?" ".")
	]
    (printf "%s %s%s\n" fw v end-char-english)))
    
(defn simple-frontwords-verb-answer [fw-pair v-pair]
  (let [fw (nth fw-pair 0)
	v  (nth v-pair 0)
	fw-spanish (nth fw-pair 1)
	v-spanish  (nth v-pair 1)
	first-char-spanish (get fw-spanish 0)
	end-char-spanish (if (= first-char-spanish \¿) "?" ".")
	]
    (printf "%s %s%s\n" fw-spanish
	    v-spanish end-char-spanish)))

(defn -main []
  (let [result (atom "")]
    (print "after initial let, result is'" @result "'\n")
    (while (= "" @result)
    (let [fw-pair (rand-nth front-words-pairs)
	  v-pair  (rand-nth verb-pairs)]
      (simple-frontwords-verb-question fw-pair v-pair) ;print question
      (reset! result (read-line)) ;user enters text+Return or Return
      (print "after read-line, result is'" @result "'\n")
      (simple-frontwords-verb-answer fw-pair v-pair) ;print answer
      )) ;end of while
    ))

(-main)


