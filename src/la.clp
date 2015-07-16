(deftemplate Criterio
	(slot nombre)
	(slot calificacion)
	(slot condicion)
)



(defrule la1 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre LA1)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Se deben aprovechar las zonas de alta jerarqu�a informativa de la p�gina para los contenidos de mayor relevancia")))
	)
)


(defrule la2 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre LA2)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Se debe evitar la sobrecarga informativa")))
	)
)


(defrule la3 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre LA3)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Las interfaces deben ser limpias, sin ruido visual")))
	)
)


(defrule la4 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre LA4)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Deben existir zonas en blanco entre los objetos informativos de la p�gina para poder descansar la vista")))
	)
)


(defrule la5 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre LA5)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Mejorar el espacio visual de la p�gina")))
	)
)


(defrule la6 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre LA6)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Utilizar correctamente la jerarqu�a visual para la colocaci�n de los diferentes elementos del contenido")))
	)
)


(defrule la7 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre LA7)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Controlado la longitud de p�gina")))
	)
)


(defrule la8 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre LA8)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Mejorar la versi�n impresa de la p�gina")))
	)
)


(defrule la9 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre LA9)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Mejorar el texto de la p�gina para que se pueda leer sin dificultad")))
	)
)


(defrule la10 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre LA10)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Evitar utilizar texto parpadeante o deslizante")))
	)
)