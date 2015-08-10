SELECT
     evaluador.nombre,
     evaluador.email,
     evaluador.apellido 
FROM
     evaluador,evaluacion,proyecto
where evaluacion.ID_PROYECTO =proyecto.ID_PROYECTO and evaluador.ID_EVALUADOR=evaluacion.ID_EVALUADOR and evaluacion.ID_PROYECTO=2

