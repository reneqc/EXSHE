package com.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class Proyecto {
	
	String urlSitio;
	String nombreSitio;
	String tipoSitio;
	String fecha;
	String evaluador1;
	String evaluador2;
	String evaluador3;
	String evaluador4;
	
	private static Connection conex=Conexion.obtenerConexion();
	
	public Proyecto(String urlSitio, String nombreSitio, String tipoSitio,String evaluador1,String evaluador2,String evaluador3,String evaluador4) {
		super();
		this.urlSitio = urlSitio;
		this.nombreSitio = nombreSitio;
		this.tipoSitio = tipoSitio;
		this.fecha=obtenerFecha();
		this.evaluador1=evaluador1;
		this.evaluador2=evaluador2;
		this.evaluador3=evaluador3;
		this.evaluador4=evaluador4;
				
		
	}
	
	

	public int guardar(){
		try {
			int id_proyecto;
			Statement sentencia = (Statement) conex.createStatement();			
			String cadena = "insert into proyecto(urlSitio,nombreSitio,tipoSitio,fecha) values ('"+this.urlSitio+"','"+this.nombreSitio+"','"+this.tipoSitio+"','"+this.fecha+"')";
			sentencia.execute(cadena);
			id_proyecto=obtenerUltimoRegistro();
			
			String cadena1="INSERT INTO detalle(id_evaluador,id_proyecto) VALUES ((select id_evaluador from evaluador where email='"+evaluador1+"'),"+id_proyecto+")";
			String cadena2="INSERT INTO detalle(id_evaluador,id_proyecto) VALUES ((select id_evaluador from evaluador where email='"+evaluador2+"'),"+id_proyecto+")";
			String cadena3="INSERT INTO detalle(id_evaluador,id_proyecto) VALUES ((select id_evaluador from evaluador where email='"+evaluador3+"'),"+id_proyecto+")";
			String cadena4="INSERT INTO detalle(id_evaluador,id_proyecto) VALUES ((select id_evaluador from evaluador where email='"+evaluador4+"'),"+id_proyecto+")";
			
			sentencia.execute(cadena1);
			sentencia.execute(cadena2);
			sentencia.execute(cadena3);
			sentencia.execute(cadena4);
			return 1;
		} catch (SQLException e ) {
			System.out.println(e);
			return 0;
		}
		
	}
	
	private int obtenerUltimoRegistro() throws SQLException{
		int ultimo_id=0;
		Statement sentencia = (Statement) conex.createStatement();	
		String cadena2="select max(id_proyecto) from proyecto"; 
		ResultSet rs=sentencia.executeQuery(cadena2);
		
		while(rs.next()){
			ultimo_id= rs.getInt(1);
		}
		
		return ultimo_id;
		
	}
	
	public String obtenerFecha(){
		Calendar cal = Calendar.getInstance();
		//cal.add(Calendar.MONTH,-1);
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		return  format1.format(cal.getTime());
	}

	
	public static ResultSet consultarEvaluadoresProyectos() throws SQLException{
		Statement sentencia = (Statement) conex.createStatement();
		String cadena = "SELECT detalle.id_detalle,proyecto.id_proyecto ,proyecto.nombreSitio, proyecto.urlSitio,evaluador.apellido, evaluador.nombre,  proyecto.fecha, evaluador.email, proyecto.tipoSitio FROM evaluador, detalle, proyecto WHERE evaluador.id_evaluador = detalle.id_evaluador AND proyecto.id_proyecto = detalle.id_proyecto ORDER BY proyecto.id_proyecto DESC ";
		ResultSet rs = sentencia.executeQuery(cadena);
		return rs;
		
	}
	
	
	public static ResultSet consultarProyectos() throws SQLException{
		Statement sentencia = (Statement) conex.createStatement();
		String cadena = "SELECT  proyecto.ID_PROYECTO,urlSitio,nombreSitio, tipoSitio, proyecto.fecha, COUNT(id_evaluacion) from evaluacion, proyecto where evaluacion.id_proyecto=proyecto.id_proyecto and evaluacion.finalizada=1 GROUP BY proyecto.ID_PROYECTO, urlSitio ,nombreSitio, tipoSitio, proyecto.fecha";
		ResultSet rs = sentencia.executeQuery(cadena);
		return rs;
		
	}
	
	
	

}
