(deftemplate Criterio
	(slot nombre)
	(slot calificacion)
	(slot condicion)
)



(defrule em1 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre EM1)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Las fotograf�as deben estar bien recortadas")))
	)
)


(defrule em2 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre EM2)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Las fotograf�as deben ser comprensibles")))
	)
)


(defrule em3 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre EM3)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Las fotograf�as deben tener una correcta resoluci�n")))
	)
)


(defrule em4 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre EM4)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "El uso de im�genes o animaciones deben proporcionar alg�n valor a�adido")))
	)
)


(defrule em5 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre EM5)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Se debe evitar el uso de animaciones c�clicas")))
	)
)


(defrule em6 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre EM6)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "El uso de sonidos debe proporcionar alg�n tipo de valor a�adido")))
	)
)