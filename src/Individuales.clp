(deftemplate Heuristico
	(slot nombre)
	(slot promedio)
	(slot condicion)
)



(defrule ag
	?f1<-(Heuristico (nombre ?nombre) (promedio ?promedio) (condicion nil))
	=>
	(if (and (< ?promedio 5)(= ?nombre AG)) then
		(retract ?f1)
		(assert (Heuristico(nombre ?nombre)(promedio ?promedio)(condicion "Aspectos generales")))
	)
)


(defrule ii
	?f1<-(Heuristico (nombre ?nombre) (promedio ?promedio) (condicion nil))
	=>
	(if (and (< ?promedio 5)(= ?nombre II)) then
		(retract ?f1)
		(assert (Heuristico(nombre ?nombre)(promedio ?promedio)(condicion "Identidad e Información")))
	)
)


(defrule en
	?f1<-(Heuristico (nombre ?nombre) (promedio ?promedio) (condicion nil))
	=>
	(if (and (< ?promedio 5)(= ?nombre EN)) then
		(retract ?f1)
		(assert (Heuristico(nombre ?nombre)(promedio ?promedio)(condicion "Estructura y navegación")))
	)
)


(defrule ro
	?f1<-(Heuristico (nombre ?nombre) (promedio ?promedio) (condicion nil))
	=>
	(if (and (< ?promedio 5)(= ?nombre RO)) then
		(retract ?f1)
		(assert (Heuristico(nombre ?nombre)(promedio ?promedio)(condicion "Rotulado")))
	)
)


(defrule la
	?f1<-(Heuristico (nombre ?nombre) (promedio ?promedio) (condicion nil))
	=>
	(if (and (< ?promedio 5)(= ?nombre LA)) then
		(retract ?f1)
		(assert (Heuristico(nombre ?nombre)(promedio ?promedio)(condicion "Layout de la página")))
	)
)


(defrule ef
	?f1<-(Heuristico (nombre ?nombre) (promedio ?promedio) (condicion nil))
	=>
	(if (and (< ?promedio 5)(= ?nombre EF)) then
		(retract ?f1)
		(assert (Heuristico(nombre ?nombre)(promedio ?promedio)(condicion "Extendibilidad y facilidad de interacción")))
	)
)


(defrule cr
	?f1<-(Heuristico (nombre ?nombre) (promedio ?promedio) (condicion nil))
	=>
	(if (and (< ?promedio 5)(= ?nombre CR)) then
		(retract ?f1)
		(assert (Heuristico(nombre ?nombre)(promedio ?promedio)(condicion "Control y retroalimentación")))
	)
)


(defrule em
	?f1<-(Heuristico (nombre ?nombre) (promedio ?promedio) (condicion nil))
	=>
	(if (and (< ?promedio 5)(= ?nombre EM)) then
		(retract ?f1)
		(assert (Heuristico(nombre ?nombre)(promedio ?promedio)(condicion "Elementos multimedia")))
	)
)


(defrule bu
	?f1<-(Heuristico (nombre ?nombre) (promedio ?promedio) (condicion nil))
	=>
	(if (and (< ?promedio 5)(= ?nombre BU)) then
		(retract ?f1)
		(assert (Heuristico(nombre ?nombre)(promedio ?promedio)(condicion "Búsqueda")))
	)
)


(defrule ay
	?f1<-(Heuristico (nombre ?nombre) (promedio ?promedio) (condicion nil))
	=>
	(if (and (< ?promedio 5)(= ?nombre AY)) then
		(retract ?f1)
		(assert (Heuristico(nombre ?nombre)(promedio ?promedio)(condicion "Ayuda")))
	)
)