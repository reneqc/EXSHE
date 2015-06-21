package com.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Evaluacion {
	
	String nombre;
	String navegador;
	String versionNavegador;
	String urlSitio;
	String fecha;
	Boolean finalizada;
	public String tipoSitio;
	int idEvaluador;	
	private Connection conex=Conexion.obtenerConexion();
	
	public Evaluacion(){
		
		
		
	}
	
	
	public Evaluacion(String nombre, String navegador, String versionNavegador,String urlSitio,int idEvaluador){
		
		this.nombre=nombre;
		this.navegador=navegador;
		this.versionNavegador=versionNavegador;
		this.urlSitio=urlSitio;
		this.finalizada=false;
		this.idEvaluador=idEvaluador;
		this.fecha=obtenerFecha();
		this.tipoSitio="ninguno";
	
		
		
		
	}
	
	
	public String obtenerFecha(){
		Calendar cal = Calendar.getInstance();
		//cal.add(Calendar.MONTH,-1);
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		return  format1.format(cal.getTime());
	}
	
	
	public int guardar(){
		try {
			Statement sentencia = (Statement) conex.createStatement();			
			String cadena = "insert into evaluacion(finalizada,fecha,nombreSitio,navegador,versionNavegador,urlSitio,tipoSitio,id_evaluador) values ("+this.finalizada+",'"+this.fecha+"','"+this.nombre+"','"+this.navegador+"','"+this.versionNavegador+"','"+this.urlSitio+"','"+this.tipoSitio+"',"+this.idEvaluador+")";
			sentencia.execute(cadena);
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}

	}
	
	
	

}
