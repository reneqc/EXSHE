package com.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Heuristico {

	int id;
	String nombre;
	String descripcion;
	Connection conex = Conexion.obtenerConexion();

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
