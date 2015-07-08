package com.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Heuristico {

	int id;
	String nombre;
	String descripcion;
	static Connection conex = Conexion.obtenerConexion();
	
	
	public Heuristico(){
		
	}
	
	public Heuristico(String nombre, String descripcion){
		this.nombre=nombre;
		this.descripcion=descripcion;
		
	}
	
	public Heuristico(int id,String nombre, String descripcion){
		this.id=id;
		this.nombre=nombre;
		this.descripcion=descripcion;
		
	}
	
	
	
	public int actualizar(){
		try {
			Statement sentencia = (Statement) conex.createStatement();			
			String cadena = "update heuristico set nombre='"+this.nombre+"', descripcion='"+this.descripcion+"' where id_heuristico="+this.id;                 
			sentencia.execute(cadena);
			return 1;
		} catch (SQLException e ) {
			System.out.println(e);
			return 0;
		}

	}
	
	public int guardar(){
		try {
			Statement sentencia = (Statement) conex.createStatement();			
			String cadena = "insert into heuristico(nombre,descripcion) values('"+this.nombre+"','"+this.descripcion+"')";
			sentencia.execute(cadena);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public void consultarHeuristico(int numero) throws SQLException {

		Statement sentencia = (Statement) conex.createStatement();
		String cadena = "select * from heuristico where id_heuristico=" + numero;
		ResultSet rs = sentencia.executeQuery(cadena);

		while (rs.next()) {
			this.id = rs.getInt(1);
			this.nombre = rs.getString(2);
			this.descripcion = rs.getString(3);

		}

	}
	
	
	public static ResultSet consultarTodos() throws SQLException{
		Statement sentencia = (Statement) conex.createStatement();
		String cadena = "select * from heuristico";
		ResultSet rs = sentencia.executeQuery(cadena);
		return rs;
	}

	public ResultSet consultarSubheuristicos(int id_heuristico) throws SQLException{
		Statement sentencia = (Statement) conex.createStatement();
		String cadena = "SELECT * FROM subheuristico WHERE id_heuristico="+id_heuristico;
		ResultSet rs = sentencia.executeQuery(cadena);
		return rs;
		
	}
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	

}
