package com.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Evaluacion {
		
	String navegador;
	String versionNavegador;
	String fecha;
	Boolean finalizada;	
	private static Connection conex=Conexion.obtenerConexion();
	
	public Evaluacion(){
		
		
		
	}
	
	
	public Evaluacion(String navegador, String versionNavegador){
		
		
		this.navegador=navegador;
		this.versionNavegador=versionNavegador;
		this.finalizada=false;		
		this.fecha=obtenerFecha();
		
		
		
	}
	
	
	public String obtenerFecha(){
		Calendar cal = Calendar.getInstance();
		//cal.add(Calendar.MONTH,-1);
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		return  format1.format(cal.getTime());
	}
	
	
	public int guardar(int id_proyecto,String email){
		try {
			Statement sentencia = (Statement) conex.createStatement();			
			String cadena = "insert into evaluacion(navegador,versionNavegador,fecha,finalizada,id_proyecto,id_evaluador)values('"+this.navegador+"','"+this.versionNavegador+"','"+this.fecha+"',"+this.finalizada+","+id_proyecto+",(select evaluador.id_evaluador from evaluador where evaluador.email='"+email+"'))";
			
			//Generando el resultado
			Statement sentencia1 = (Statement) conex.createStatement();	
			String cadena1="INSERT INTO resultado(id_evaluacion) VALUES ((select max(evaluacion.id_evaluacion) from evaluacion));";
			sentencia1.execute(cadena1);
			
			
			Statement sentencia2 = (Statement) conex.createStatement();	
			String cadena2="select subheuristico.id_subheuristico from subheuristico,heuristico where subheuristico.id_heuristico=heuristico.id_heuristico;";
			ResultSet rs = sentencia2.executeQuery(cadena2);
			
			while (rs.next()){
				Statement sentencia3 = (Statement) conex.createStatement();	
				String cadena3="INSERT INTO calificacion(id_subheuristico, id_resultado, puntos) VALUES ("+rs.getInt(1)+",(select max(resultado.id_resultado) from resultado),-1);";
				sentencia3.execute(cadena3);
			}
			
			sentencia.execute(cadena);
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}

	}
	
	
	public static ResultSet consultarProyectosEvaluador(String email) throws SQLException{
		Statement sentencia = (Statement) conex.createStatement();
		String cadena = "SELECT detalle.id_detalle,proyecto.id_proyecto ,proyecto.nombreSitio, proyecto.urlSitio,evaluador.apellido, evaluador.nombre,  proyecto.fecha, evaluador.email, proyecto.tipoSitio FROM evaluador, detalle, proyecto WHERE evaluador.id_evaluador = detalle.id_evaluador AND proyecto.id_proyecto = detalle.id_proyecto AND evaluador.email='"+email+"' ORDER BY proyecto.fecha DESC ";
		ResultSet rs = sentencia.executeQuery(cadena);
		return rs;
		
	}
	
	
	public static ResultSet consultarEvaluacionesEvaluador(String email) throws SQLException{
		Statement sentencia = (Statement) conex.createStatement();
		String cadena = "SELECT evaluacion.id_evaluacion,detalle.id_detalle,proyecto.id_proyecto ,proyecto.nombreSitio, proyecto.urlSitio,evaluador.apellido, evaluador.nombre,  evaluacion.fecha, evaluador.email, evaluacion.navegador,evaluacion.versionNavegador FROM evaluador, detalle, proyecto,evaluacion WHERE evaluador.id_evaluador = detalle.id_evaluador AND proyecto.id_proyecto = detalle.id_proyecto AND evaluacion.id_proyecto=proyecto.id_proyecto AND evaluacion.id_evaluador=evaluador.id_evaluador AND evaluador.email='"+email+"' ORDER BY proyecto.fecha DESC ";
		ResultSet rs = sentencia.executeQuery(cadena);
		return rs;
		
	}
	
	

	
	
	

}
