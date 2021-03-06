(deftemplate Informe
	(slot nombre)
	(slot porcentaje)
	(slot condicion)
)

(defrule completamenteUsable
	?f1<-(Informe (nombre ?nombre) (porcentaje ?porcentaje) (condicion nil))	
	=>( if (>= ?porcentaje 85.76 ) then 
		(retract ?f1)	
		(assert (Informe(nombre ?nombre)(porcentaje ?porcentaje)(condicion " Completamente Usable")))
		
		
)
)
(defrule muyUsable
	?f1<-(Informe (nombre ?nombre) (porcentaje ?porcentaje) (condicion nil))	
	=>(if ( and (>= ?porcentaje 71.48) (< ?porcentaje 85.76)) then 
		(retract ?f1)	
		(assert (Informe(nombre ?nombre)(porcentaje ?porcentaje)(condicion "Muy Usable")))	
		
)
)

(defrule usable
	?f1<-(Informe (nombre ?nombre) (porcentaje ?porcentaje) (condicion nil))	
	=>(if ( and (>= ?porcentaje 57.18) (< ?porcentaje 71.48)) then 
		(retract ?f1)	
		(assert (Informe(nombre ?nombre)(porcentaje ?porcentaje)(condicion "Usable")))	
)
)

(defrule medianamenteUsable
	?f1<-(Informe (nombre ?nombre) (porcentaje ?porcentaje) (condicion nil))	
	=>(if ( and (>= ?porcentaje 42.89) (< ?porcentaje 57.18)) then 
		(retract ?f1)	
		(assert (Informe(nombre ?nombre)(porcentaje ?porcentaje)(condicion "Medianamente Usable")))	
)
)

(defrule pocoUsable
	?f1<-(Informe (nombre ?nombre) (porcentaje ?porcentaje) (condicion nil))	
	=>(if ( and (>= ?porcentaje 28.59) (< ?porcentaje 42.89)) then 
		(retract ?f1)	
		(assert (Informe(nombre ?nombre)(porcentaje ?porcentaje)(condicion "Poco Usable")))	
)
)


(defrule casiNoUsable
	?f1<-(Informe (nombre ?nombre) (porcentaje ?porcentaje) (condicion nil))	
	=>(if ( and (>= ?porcentaje 14.30) (< ?porcentaje 28.59)) then 
		(retract ?f1)	
		(assert (Informe(nombre ?nombre)(porcentaje ?porcentaje)(condicion "Casi No Usable")))	
)
)


(defrule noUsable
	?f1<-(Informe (nombre ?nombre) (porcentaje ?porcentaje) (condicion nil))	
	=>(if ( and (>= ?porcentaje 00.00) (< ?porcentaje 14.30)) then 
		(retract ?f1)	
		(assert (Informe(nombre ?nombre)(porcentaje ?porcentaje)(condicion "No Usable")))	
)
)