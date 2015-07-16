(deftemplate Criterio
	(slot nombre)
	(slot calificacion)
	(slot condicion)
)



(defrule ay1 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre AY1)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "El enlace a la secci�n de Ayuda debe estar colocado en una zona visible y est�ndar")))
	)
)


(defrule ay2 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre AY2)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Debe haber f�cil acceso y retorno del sistema de ayuda")))
	)
)


(defrule ay3 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre AY3)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Es necesario ofrecer ayuda contextual para las tareas complejas")))
	)
)


(defrule ay4 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre AY4)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Para la selecci�n de las FAQs debe ser correcta tanto la elecci�n como la redacci�n de las preguntas")))
	)
)


(defrule ay5 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre AY5)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Debe ser correcta la redacci�n de las respuestas de las FAQs")))
	)
)