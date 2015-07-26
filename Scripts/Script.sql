select subheuristico.criterio,subheuristico.codigo,proyecto.nombreSitio,proyecto.urlSitio,proyecto.fecha, avg(puntos) AS Promedio from evaluacion,proyecto,resultado,calificacion,subheuristico
where proyecto.id_proyecto=evaluacion.id_proyecto and evaluacion.id_evaluacion=resultado.id_evaluacion and
calificacion.id_resultado=resultado.id_resultado and subheuristico.id_subheuristico=calificacion.id_subheuristico
and puntos>-1 and proyecto.id_proyecto=1 group by subheuristico.id_subheuristico,subheuristico.criterio,subheuristico.codigo,proyecto.nombreSitio,proyecto.urlSitio,proyecto.fecha
order by subheuristico.id_subheuristico