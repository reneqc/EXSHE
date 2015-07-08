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
	int finalizada;	
	private static Connection conex=Conexion.obtenerConexion();
	
	public Evaluacion(){
		
		
		
	}
	
	
	public Evaluacion(String navegador, String versionNavegador){
		
		
		this.navegador=navegador;
		this.versionNavegador=versionNavegador;
		this.finalizada=0;		
		this.fecha=obtenerFecha();
		
		
		
	}
	
	
	public String obtenerFecha(){
		Calendar cal = Calendar.getInstance();
		//cal.add(Calendar.MONTH,-1);
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		return  format1.format(cal.getTime());
	}
	
	
	public int guardar(int id_proyecto,String email){
		try {
			Statement sentencia = (Statement) conex.createStatement();			
			String cadena = "insert into evaluacion(navegador,versionNavegador,fecha,finalizada,id_proyecto,id_evaluador)values('"+this.navegador+"','"+this.versionNavegador+"','"+this.fecha+"',"+this.finalizada+","+id_proyecto+",(select evaluador.id_evaluador from evaluador where evaluador.email='"+email+"'))";
			sentencia.execute(cadena);
			//Generando el resultado
			Statement sentencia1 = (Statement) conex.createStatement();	
			String cadena1="INSERT INTO resultado(id_evaluacion) VALUES ((select max(evaluacion.id_evaluacion) from evaluacion))";
			sentencia1.execute(cadena1);
			
			
			Statement sentencia2 = (Statement) conex.createStatement();	
			String cadena2="select subheuristico.id_subheuristico from subheuristico,heuristico where subheuristico.id_heuristico=heuristico.id_heuristico";
			ResultSet rs = sentencia2.executeQuery(cadena2);
			
			while (rs.next()){
				Statement sentencia3 = (Statement) conex.createStatement();	
				String cadena3="INSERT INTO calificacion(id_subheuristico, id_resultado, puntos) VALUES ("+rs.getInt(1)+",(select max(resultado.id_resultado) from resultado),-1)";
				sentencia3.execute(cadena3);
			}
			
			
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
		String cadena = "SELECT evaluacion.id_evaluacion,detalle.id_detalle,proyecto.id_proyecto ,proyecto.nombreSitio, proyecto.urlSitio,evaluador.apellido, evaluador.nombre,  evaluacion.fecha, evaluador.email, evaluacion.navegador,evaluacion.versionNavegador,evaluacion.finalizada FROM evaluador, detalle, proyecto,evaluacion WHERE evaluador.id_evaluador = detalle.id_evaluador AND proyecto.id_proyecto = detalle.id_proyecto AND evaluacion.id_proyecto=proyecto.id_proyecto AND evaluacion.id_evaluador=evaluador.id_evaluador AND evaluador.email='"+email+"' ORDER BY proyecto.fecha DESC ";
		ResultSet rs = sentencia.executeQuery(cadena);
		return rs;
		
	}
	
	
	
	public static ResultSet consultarCalificaciones(int id_evaluacion) throws SQLException{
		
		Statement sentencia = (Statement) conex.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		String cadena = "SELECT calificacion.id_calificacion, subheuristico.id_subheuristico, resultado.id_resultado, calificacion.puntos, subheuristico.criterio, subheuristico.tipo, heuristico.nombre, heuristico.descripcion FROM heuristico, subheuristico, resultado, calificacion, evaluacion WHERE heuristico.id_heuristico = subheuristico.id_heuristico AND subheuristico.id_subheuristico = calificacion.id_subheuristico AND resultado.id_resultado = calificacion.id_resultado AND evaluacion.id_evaluacion = resultado.id_evaluacion and evaluacion.id_evaluacion="+id_evaluacion;
		ResultSet rs = sentencia.executeQuery(cadena);
		return rs;
	}

	public static int calificar(int id_calificacion,double puntos) {
		try {
			
			Statement sentencia = (Statement) conex.createStatement();			
			String cadena = "update calificacion set puntos="+puntos+" where calificacion.id_calificacion="+id_calificacion;
			sentencia.execute(cadena);
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	
	}
	
	
	
	/*
	 * Metodo para conocer cual es la calificacion actual de un subheuristico
	 * 
	 */
	public static float consultarCalificacion(int id_calificacion){
		float puntos=-1;
		Statement sentencia;
		try {
			sentencia = (Statement) conex.createStatement();
			String cadena = "SELECT puntos from calificacion where calificacion.id_calificacion="+id_calificacion;
			ResultSet rs = sentencia.executeQuery(cadena);
			while(rs.next()){
				puntos=rs.getInt(1);			
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return puntos;
		
	}
	

	public static ResultSet verificarFinalizacion(int id_evaluacion) throws SQLException{

		
		Statement sentencia = (Statement) conex.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		String cadena = "SELECT calificacion.id_calificacion, subheuristico.id_subheuristico, resultado.id_resultado, calificacion.puntos, subheuristico.criterio, subheuristico.tipo, heuristico.nombre, heuristico.descripcion FROM heuristico, subheuristico, resultado, calificacion, evaluacion WHERE heuristico.id_heuristico = subheuristico.id_heuristico AND subheuristico.id_subheuristico = calificacion.id_subheuristico AND resultado.id_resultado = calificacion.id_resultado AND calificacion.puntos=-1 AND evaluacion.id_evaluacion = resultado.id_evaluacion and evaluacion.id_evaluacion="+id_evaluacion;
		ResultSet  rs = sentencia.executeQuery(cadena);
		return rs;

	}
	
	public static int cambiarEstado(int id_evaluacion){
		
		try {
			Statement sentencia= (Statement) conex.createStatement();
			String cadena="update evaluacion set finalizada=1 where id_evaluacion="+id_evaluacion;			
			sentencia.execute(cadena);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return 0;
		}
		
	}

	
	
	

}
