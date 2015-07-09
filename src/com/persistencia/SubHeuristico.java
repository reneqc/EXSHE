package com.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SubHeuristico {
	
	String id;
	String criterio;
	String tipo;
	int id_heuristico;
	private static Connection conex=Conexion.obtenerConexion();
	
	
	/*
	 * Metodo para construir un objeto para modificarlo
	 * 
	 */
	public SubHeuristico(String id, String criterio, String tipo, int id_heuristico) {
		this.id = id;
		this.criterio = criterio;
		this.tipo = tipo;
		this.id_heuristico = id_heuristico;
	}
	
	/*
	 * Metodo para construir un objeto para guardarlo
	 * 
	 */
	public SubHeuristico(String criterio, String tipo, int id_heuristico) {
		this.criterio = criterio;
		this.tipo = tipo;
		this.id_heuristico = id_heuristico;
	}
	
	public static ResultSet consultarTodos() throws SQLException{
		Statement sentencia = (Statement) conex.createStatement();
		String cadena = "SELECT * FROM subheuristico,heuristico  where subheuristico.id_heuristico=heuristico.id_heuristico order by heuristico.id_heuristico ";
		ResultSet rs = sentencia.executeQuery(cadena);
		return rs;
		
	}
	
	/*
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
	*/
	
	public int guardar(){
		try {
			Statement sentencia = (Statement) conex.createStatement();			
			String cadena = "insert into subheuristico(criterio,tipo,id_heuristico) values('"+this.criterio+"','"+this.tipo+"',"+this.id_heuristico+")";
			sentencia.execute(cadena);
			return 1;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return 0;
		}
	}
	
	

}
