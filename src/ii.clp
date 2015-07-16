(deftemplate Criterio
	(slot nombre)
	(slot calificacion)
	(slot condicion)
)



(defrule ii1 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre II1)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "La Identidad o logotipo del sitio debe ser: significativo, identificable y suficientemente visible")))
	)
)


(defrule ii2 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre II2)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Mantener la identidad del sitio en todas las p�ginas")))
	)
)


(defrule ii3 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre II3)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "El eslogan o tagline deben ser adecuados al objetivo del sitio")))
	)
)


(defrule ii4 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre II4)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Debe existir la Informaci�n institucional o empresarial")))
	)
)


(defrule ii5 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre II5)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Debe existir mecanismos de contacto")))
	)
)


(defrule ii6 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre II6)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Es necesario ofrecer informaci�n sobre la protecci�n de datos de car�cter personal o los derechos de autor de los contenidos del sitio web")))
	)
)


(defrule ii7 
	?f1<-(Criterio (nombre ?nombre) (calificacion ?calificacion) (condicion nil))
	=>
	(if (and (< ?calificacion 5)(= ?nombre II7)) then
		(retract ?f1)
		(assert (Criterio(nombre ?nombre)(calificacion ?calificacion)(condicion "Es necesario ofrecer informaci�n sobre el autor, fuentes y fechas de creaci�n y revisi�n del documento en art�culos, noticias e informes")))
	)
)