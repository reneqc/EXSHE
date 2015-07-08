package com.persistencia;

public class Script {
	
	
	
	public static String crearTablaCalificacion(){
		String script1="CREATE TABLE calificacion( id_calificacion INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),  id_subheuristico INTEGER NOT NULL,  id_resultado INTEGER NOT NULL,  puntos DOUBLE PRECISION, PRIMARY KEY (id_calificacion)) ";
		return script1;
	}
	
	
	public static String crearTablaDetalle(){
		String script1=" CREATE TABLE  detalle  (id_detalle  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),   id_evaluador  INTEGER NOT NULL,   id_proyecto  INTEGER NOT NULL,  PRIMARY KEY ( id_detalle ))";
		return script1;
	}
	
	public static String crearTablaEvaluacion(){
		String script1=" CREATE TABLE  evaluacion  (id_evaluacion  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),   navegador  varchar(100) NOT NULL,   fecha  DATE NOT NULL,   finalizada  INTEGER NOT NULL,   versionNavegador  varchar(45) NOT NULL,   id_proyecto  INTEGER NOT NULL,   id_evaluador  INTEGER NOT NULL,  PRIMARY KEY ( id_evaluacion ))";
		return script1;
	}
	
	
	
	public static String crearTablaEvaluador(){
			String script1=" CREATE TABLE   evaluador  (   id_evaluador  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),   nombre  varchar(45) NOT NULL,   email  varchar(45) UNIQUE NOT NULL,   direccion  varchar(200) NOT NULL,   cargo  varchar(45) NOT NULL,   profesion  varchar(100) NOT NULL,   telefono  varchar(15) NOT NULL,   apellido  varchar(45) NOT NULL,   perfil  varchar(45) NOT NULL,   empresaEvaluador  varchar(100) NOT NULL,   password  varchar(200) NOT NULL,  PRIMARY KEY ( id_evaluador ))";
			return script1;
	}
	
	
	public static String crearTablaHeuristico(){
			String script1=" CREATE TABLE   heuristico  (  id_heuristico  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),  descripcion  varchar(20000) NOT NULL,  nombre  varchar(20000) NOT NULL,  PRIMARY KEY ( id_heuristico ))";
			return script1;
	}
	
	
	public static String crearTablaProyecto(){
		String script1="CREATE TABLE proyecto  (id_proyecto  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),  urlSitio  varchar(200) NOT NULL,  nombreSitio  varchar(100) NOT NULL,  tipoSitio  varchar(100) NOT NULL,   fecha  date NOT NULL,  PRIMARY KEY ( id_proyecto ))";
		return script1;
	}
	
	
	public static String crearTablaResultado(){
		String script1=" CREATE TABLE  resultado  (   id_resultado  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),   id_evaluacion  INTEGER NOT NULL,  PRIMARY KEY ( id_resultado ))";
		return script1;
	}
	
	public static String crearTablaSubHeuristico(){
		String script1=" CREATE TABLE  subheuristico  ( id_subheuristico  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), criterio  varchar(20000) NOT NULL,   tipo  varchar(45) NOT NULL,   id_heuristico  INTEGER NOT NULL,  PRIMARY KEY ( id_subheuristico ))";
		return script1;
	}
	
	public static String insertarAdministrador(){
		String script1=" INSERT INTO  evaluador  (nombre ,  email ,  direccion ,  cargo ,  profesion ,  telefono ,  apellido ,  perfil ,  empresaEvaluador ,  password ) VALUES ('', 'admin', '', '', '', '', '', 'ADMINISTRADOR', '', 'admin')";
		return script1;
		
	}
	


}
