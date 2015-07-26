package com.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

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
	
	public static float consultarPorcentajeCalificados(int id) throws SQLException{
		float resultado=0;
		Statement sentencia = (Statement) conex.createStatement();
		String cadena = "select  (sum (puntos)*100)/(count(puntos)*10) as porcentaje  from evaluacion, calificacion, resultado where evaluacion.id_evaluacion=resultado.id_evaluacion and puntos > -1 and resultado.id_resultado= calificacion.id_resultado  and evaluacion.id_evaluacion="+id;
		ResultSet rs = sentencia.executeQuery(cadena);
		while(rs.next()){			
				resultado= rs.getFloat(1);
		}

		return resultado;
		
	}
	
	
	public static float consultarPromedioHeuristico(int id , String nom) throws SQLException{
		float resultado=0;
		Statement sentencia = (Statement) conex.createStatement();
		String cadena = "select  avg (puntos)  from evaluacion, calificacion, resultado, heuristico, subheuristico where evaluacion.id_evaluacion=resultado.id_evaluacion and puntos > -1 and resultado.id_resultado= calificacion.id_resultado  and evaluacion.id_evaluacion="+id+"  and heuristico.id_heuristico=subheuristico.ID_HEURISTICO and subheuristico.ID_SUBHEURISTICO= calificacion.ID_SUBHEURISTICO and heuristico.CODIGO='"+nom+"'";
		ResultSet rs = sentencia.executeQuery(cadena);
		
		while(rs.next()){			
			resultado= rs.getFloat(1);
		}
		
		return resultado;
		
	}
	
	public static ResultSet consultarListaNotas(int id , String nom) throws SQLException{
		
		
		Statement sentencia = (Statement) conex.createStatement();
		String cadena = "select  puntos, subheuristico.CODIGO  from evaluacion, calificacion, resultado, heuristico, subheuristico where evaluacion.id_evaluacion=resultado.id_evaluacion and puntos > -1 and resultado.id_resultado= calificacion.id_resultado  and evaluacion.id_evaluacion="+id+"  and heuristico.id_heuristico=subheuristico.ID_HEURISTICO and subheuristico.ID_SUBHEURISTICO= calificacion.ID_SUBHEURISTICO and heuristico.CODIGO='"+nom+"' ORDER by heuristico.ID_HEURISTICO ASC";
		ResultSet rs = sentencia.executeQuery(cadena);
				
		return rs;
		
	}
	
	
	public static ResultSet consultarEvaluacionesEvaluador(String email) throws SQLException{
		Statement sentencia = (Statement) conex.createStatement();
		String cadena = "SELECT evaluacion.id_evaluacion,detalle.id_detalle,proyecto.id_proyecto ,proyecto.nombreSitio, proyecto.urlSitio,evaluador.apellido, evaluador.nombre,  evaluacion.fecha, evaluador.email, evaluacion.navegador,evaluacion.versionNavegador,evaluacion.finalizada FROM evaluador, detalle, proyecto,evaluacion WHERE evaluador.id_evaluador = detalle.id_evaluador AND proyecto.id_proyecto = detalle.id_proyecto AND evaluacion.id_proyecto=proyecto.id_proyecto AND evaluacion.id_evaluador=evaluador.id_evaluador AND evaluador.email='"+email+"' ORDER BY proyecto.fecha DESC ";
		ResultSet rs = sentencia.executeQuery(cadena);
		return rs;
		
	}
	
	/*
	
	public static ResultSet consultarCalificaciones(int id_evaluacion) throws SQLException{
		
		Statement sentencia = (Statement) conex.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		String cadena = "SELECT calificacion.id_calificacion, subheuristico.id_subheuristico, resultado.id_resultado, calificacion.puntos, subheuristico.criterio, subheuristico.tipo, heuristico.nombre, heuristico.descripcion, subheuristico.codigo FROM heuristico, subheuristico, resultado, calificacion, evaluacion WHERE heuristico.id_heuristico = subheuristico.id_heuristico AND subheuristico.id_subheuristico = calificacion.id_subheuristico AND resultado.id_resultado = calificacion.id_resultado AND evaluacion.id_evaluacion = resultado.id_evaluacion and evaluacion.id_evaluacion="+id_evaluacion+" order by subheuristico.id_subheuristico ASC";
		ResultSet rs = sentencia.executeQuery(cadena);
		return rs;
	}
	*/

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
		String cadena = "SELECT calificacion.id_calificacion, subheuristico.id_subheuristico, resultado.id_resultado, calificacion.puntos, subheuristico.criterio, subheuristico.tipo, heuristico.nombre, heuristico.descripcion, subheuristico.codigo FROM heuristico, subheuristico, resultado, calificacion, evaluacion WHERE heuristico.id_heuristico = subheuristico.id_heuristico AND subheuristico.id_subheuristico = calificacion.id_subheuristico AND resultado.id_resultado = calificacion.id_resultado AND calificacion.puntos=-1 AND evaluacion.id_evaluacion = resultado.id_evaluacion and evaluacion.id_evaluacion="+id_evaluacion;
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
	
	public static int cambiarEstadoAPendiete(int id_evaluacion){
		
		try {
			Statement sentencia= (Statement) conex.createStatement();
			String cadena="update evaluacion set finalizada=0 where id_evaluacion="+id_evaluacion;			
			sentencia.execute(cadena);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return 0;
		}
		
	}
	
	
	public static ResultSet evaluacionesFinalizadasPorEvaluador(String email) throws SQLException{
		
		Statement sentencia = (Statement) conex.createStatement();
		String cadena = "SELECT evaluacion.id_evaluacion,detalle.id_detalle,proyecto.id_proyecto ,proyecto.nombreSitio, proyecto.urlSitio,evaluador.apellido, evaluador.nombre,  evaluacion.fecha, evaluador.email, evaluacion.navegador,evaluacion.versionNavegador,evaluacion.finalizada FROM evaluador, detalle, proyecto,evaluacion WHERE evaluador.id_evaluador = detalle.id_evaluador AND proyecto.id_proyecto = detalle.id_proyecto AND evaluacion.id_proyecto=proyecto.id_proyecto AND evaluacion.id_evaluador=evaluador.id_evaluador AND evaluacion.finalizada=1 AND evaluador.email='"+email+"' ORDER BY proyecto.fecha DESC ";
		ResultSet rs = sentencia.executeQuery(cadena);
		return rs;
		
		
	}
	
	
	
	public static ResultSet consultarEvaluacionesFinalizadas() throws SQLException{
			
			Statement sentencia = (Statement) conex.createStatement();
			String cadena = "SELECT evaluacion.id_evaluacion,detalle.id_detalle,proyecto.id_proyecto ,proyecto.nombreSitio, proyecto.urlSitio,evaluador.apellido, evaluador.nombre,  evaluacion.fecha, evaluador.email, evaluacion.navegador,evaluacion.versionNavegador,evaluacion.finalizada FROM evaluador, detalle, proyecto,evaluacion WHERE evaluador.id_evaluador = detalle.id_evaluador AND proyecto.id_proyecto = detalle.id_proyecto AND evaluacion.id_proyecto=proyecto.id_proyecto AND evaluacion.id_evaluador=evaluador.id_evaluador AND evaluacion.finalizada=1  ORDER BY proyecto.fecha DESC ";
			ResultSet rs = sentencia.executeQuery(cadena);
			return rs;
			
	}
	
	
	
	public static ResultSet[] consultarCalificaciones(int id_evaluacion) throws SQLException{
			ResultSet[] rs = new ResultSet[10]; 
			Statement sentencia0 = (Statement) conex.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement sentencia1 = (Statement) conex.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement sentencia2 = (Statement) conex.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement sentencia3 = (Statement) conex.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement sentencia4 = (Statement) conex.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement sentencia5 = (Statement) conex.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement sentencia6 = (Statement) conex.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement sentencia7 = (Statement) conex.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement sentencia8 = (Statement) conex.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement sentencia9 = (Statement) conex.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			String cadena0 = "SELECT calificacion.id_calificacion, subheuristico.id_subheuristico, resultado.id_resultado, calificacion.puntos, subheuristico.criterio, subheuristico.tipo, heuristico.nombre, heuristico.descripcion, subheuristico.codigo FROM heuristico, subheuristico, resultado, calificacion, evaluacion WHERE heuristico.id_heuristico = subheuristico.id_heuristico AND subheuristico.id_subheuristico = calificacion.id_subheuristico AND resultado.id_resultado = calificacion.id_resultado AND evaluacion.id_evaluacion = resultado.id_evaluacion and evaluacion.id_evaluacion="+id_evaluacion+" and subheuristico.id_subheuristico<=9";
			rs[0] = sentencia0.executeQuery(cadena0);
			
			String cadena1 = "SELECT calificacion.id_calificacion, subheuristico.id_subheuristico, resultado.id_resultado, calificacion.puntos, subheuristico.criterio, subheuristico.tipo, heuristico.nombre, heuristico.descripcion, subheuristico.codigo FROM heuristico, subheuristico, resultado, calificacion, evaluacion WHERE heuristico.id_heuristico = subheuristico.id_heuristico AND subheuristico.id_subheuristico = calificacion.id_subheuristico AND resultado.id_resultado = calificacion.id_resultado AND evaluacion.id_evaluacion = resultado.id_evaluacion and evaluacion.id_evaluacion="+id_evaluacion+" and subheuristico.id_subheuristico>=10 and subheuristico.id_subheuristico<=18  order by subheuristico.id_subheuristico ASC";
			rs[1] = sentencia1.executeQuery(cadena1);
			
			String cadena2 = "SELECT calificacion.id_calificacion, subheuristico.id_subheuristico, resultado.id_resultado, calificacion.puntos, subheuristico.criterio, subheuristico.tipo, heuristico.nombre, heuristico.descripcion, subheuristico.codigo FROM heuristico, subheuristico, resultado, calificacion, evaluacion WHERE heuristico.id_heuristico = subheuristico.id_heuristico AND subheuristico.id_subheuristico = calificacion.id_subheuristico AND resultado.id_resultado = calificacion.id_resultado AND evaluacion.id_evaluacion = resultado.id_evaluacion and evaluacion.id_evaluacion="+id_evaluacion+" and subheuristico.id_subheuristico>=19 and subheuristico.id_subheuristico<=27  order by subheuristico.id_subheuristico ASC";
			rs[2] = sentencia2.executeQuery(cadena2);
			
			String cadena3 = "SELECT calificacion.id_calificacion, subheuristico.id_subheuristico, resultado.id_resultado, calificacion.puntos, subheuristico.criterio, subheuristico.tipo, heuristico.nombre, heuristico.descripcion, subheuristico.codigo FROM heuristico, subheuristico, resultado, calificacion, evaluacion WHERE heuristico.id_heuristico = subheuristico.id_heuristico AND subheuristico.id_subheuristico = calificacion.id_subheuristico AND resultado.id_resultado = calificacion.id_resultado AND evaluacion.id_evaluacion = resultado.id_evaluacion and evaluacion.id_evaluacion="+id_evaluacion+" and subheuristico.id_subheuristico>=28 and subheuristico.id_subheuristico<=36  order by subheuristico.id_subheuristico ASC";
			rs[3] = sentencia3.executeQuery(cadena3);
			
			String cadena4 = "SELECT calificacion.id_calificacion, subheuristico.id_subheuristico, resultado.id_resultado, calificacion.puntos, subheuristico.criterio, subheuristico.tipo, heuristico.nombre, heuristico.descripcion, subheuristico.codigo FROM heuristico, subheuristico, resultado, calificacion, evaluacion WHERE heuristico.id_heuristico = subheuristico.id_heuristico AND subheuristico.id_subheuristico = calificacion.id_subheuristico AND resultado.id_resultado = calificacion.id_resultado AND evaluacion.id_evaluacion = resultado.id_evaluacion and evaluacion.id_evaluacion="+id_evaluacion+" and subheuristico.id_subheuristico>=37 and subheuristico.id_subheuristico<=45  order by subheuristico.id_subheuristico ASC";
			rs[4] = sentencia4.executeQuery(cadena4);
			
			String cadena5 = "SELECT calificacion.id_calificacion, subheuristico.id_subheuristico, resultado.id_resultado, calificacion.puntos, subheuristico.criterio, subheuristico.tipo, heuristico.nombre, heuristico.descripcion, subheuristico.codigo FROM heuristico, subheuristico, resultado, calificacion, evaluacion WHERE heuristico.id_heuristico = subheuristico.id_heuristico AND subheuristico.id_subheuristico = calificacion.id_subheuristico AND resultado.id_resultado = calificacion.id_resultado AND evaluacion.id_evaluacion = resultado.id_evaluacion and evaluacion.id_evaluacion="+id_evaluacion+" and subheuristico.id_subheuristico>=46 and subheuristico.id_subheuristico<=54  order by subheuristico.id_subheuristico ASC";
			rs[5] = sentencia5.executeQuery(cadena5);
			
			
			String cadena6 = "SELECT calificacion.id_calificacion, subheuristico.id_subheuristico, resultado.id_resultado, calificacion.puntos, subheuristico.criterio, subheuristico.tipo, heuristico.nombre, heuristico.descripcion, subheuristico.codigo FROM heuristico, subheuristico, resultado, calificacion, evaluacion WHERE heuristico.id_heuristico = subheuristico.id_heuristico AND subheuristico.id_subheuristico = calificacion.id_subheuristico AND resultado.id_resultado = calificacion.id_resultado AND evaluacion.id_evaluacion = resultado.id_evaluacion and evaluacion.id_evaluacion="+id_evaluacion+" and subheuristico.id_subheuristico>=55 and subheuristico.id_subheuristico<=63  order by subheuristico.id_subheuristico ASC";
			rs[6] = sentencia6.executeQuery(cadena6);
			
			String cadena7 = "SELECT calificacion.id_calificacion, subheuristico.id_subheuristico, resultado.id_resultado, calificacion.puntos, subheuristico.criterio, subheuristico.tipo, heuristico.nombre, heuristico.descripcion, subheuristico.codigo FROM heuristico, subheuristico, resultado, calificacion, evaluacion WHERE heuristico.id_heuristico = subheuristico.id_heuristico AND subheuristico.id_subheuristico = calificacion.id_subheuristico AND resultado.id_resultado = calificacion.id_resultado AND evaluacion.id_evaluacion = resultado.id_evaluacion and evaluacion.id_evaluacion="+id_evaluacion+" and subheuristico.id_subheuristico>=64 and subheuristico.id_subheuristico<=72  order by subheuristico.id_subheuristico ASC";
			rs[7] = sentencia7.executeQuery(cadena7);
			
			String cadena8 = "SELECT calificacion.id_calificacion, subheuristico.id_subheuristico, resultado.id_resultado, calificacion.puntos, subheuristico.criterio, subheuristico.tipo, heuristico.nombre, heuristico.descripcion, subheuristico.codigo FROM heuristico, subheuristico, resultado, calificacion, evaluacion WHERE heuristico.id_heuristico = subheuristico.id_heuristico AND subheuristico.id_subheuristico = calificacion.id_subheuristico AND resultado.id_resultado = calificacion.id_resultado AND evaluacion.id_evaluacion = resultado.id_evaluacion and evaluacion.id_evaluacion="+id_evaluacion+" and subheuristico.id_subheuristico>=73 and subheuristico.id_subheuristico<=81  order by subheuristico.id_subheuristico ASC";
			rs[8] = sentencia8.executeQuery(cadena8);
			
			
			String cadena9 = "SELECT calificacion.id_calificacion, subheuristico.id_subheuristico, resultado.id_resultado, calificacion.puntos, subheuristico.criterio, subheuristico.tipo, heuristico.nombre, heuristico.descripcion, subheuristico.codigo FROM heuristico, subheuristico, resultado, calificacion, evaluacion WHERE heuristico.id_heuristico = subheuristico.id_heuristico AND subheuristico.id_subheuristico = calificacion.id_subheuristico AND resultado.id_resultado = calificacion.id_resultado AND evaluacion.id_evaluacion = resultado.id_evaluacion and evaluacion.id_evaluacion="+id_evaluacion+" and subheuristico.id_subheuristico>81  order by subheuristico.id_subheuristico ASC";
			rs[9] = sentencia9.executeQuery(cadena9);
			
			return rs;
		}
	
		public static boolean verificarEstado(int id_evaluacion) throws SQLException{
			boolean estado=false;
			Statement sentencia = (Statement) conex.createStatement();
			String cadena = "SELECT evaluacion.finalizada FROM evaluacion where evaluacion.id_evaluacion="+id_evaluacion+" ORDER BY id_evaluacion ";
			ResultSet rs = sentencia.executeQuery(cadena);
			while(rs.next()){
				estado=rs.getBoolean(1);					
			}
			
			return estado;
			
		}
	
	
	

}
