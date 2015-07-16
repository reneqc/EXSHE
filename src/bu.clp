(deftemplate Criterio
	(slot nombre)
	(slot calificacion)
	(slot condicion)
)



(defrule bu1 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre BU1)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Si es necesaria la búsqueda, debe estar accesible desde todas las páginas del sitio")))
	)
)


(defrule bu2 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre BU2)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "La búsqueda debe ser fácilmente reconocible como tal")))
	)
)


(defrule bu3 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre BU3)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "La búsqueda debe estar fácilmente accesible")))
	)
)


(defrule bu4 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre BU4)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "La caja de texto de la búsqueda debe ser lo suficientemente ancha")))
	)
)


(defrule bu5 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre BU5)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "El sistema de búsqueda debe ser simple y claro")))
	)
)


(defrule bu6 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre BU6)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Se debe permitir la búsqueda avanzada")))
	)
)


(defrule bu7 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre BU7)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Se debe mostrar los resultados de la búsqueda de forma comprensible para el usuario")))
	)
)


(defrule bu8 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre BU8)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Debe existir asistencia al usuario en caso de no poder ofrecer resultados para una consulta dada")))
	)
)