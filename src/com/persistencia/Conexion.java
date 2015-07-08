package com.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexion {
	
	
	@SuppressWarnings("finally")
	public static Connection obtenerConexion(){
		Connection conexion=null;
		String nombreDb="bdd_exshe";
		try{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			conexion=DriverManager.getConnection("jdbc:derby:"+nombreDb+";create=true");
			Statement sentencia=conexion.createStatement();
			
			try {
				
				
				sentencia.execute(Script.crearTablaCalificacion());
				sentencia.execute(Script.crearTablaDetalle());
				sentencia.execute(Script.crearTablaEvaluacion());
				sentencia.execute(Script.crearTablaEvaluador());
				sentencia.execute(Script.crearTablaProyecto());
				sentencia.execute(Script.crearTablaHeuristico());
				sentencia.execute(Script.crearTablaResultado());
				sentencia.execute(Script.crearTablaSubHeuristico());
				sentencia.execute(Script.insertarAdministrador());
				
				System.out.println("Tablas creadas exitosamente");
			} catch (Exception e) {
				System.out.println("Las tablas ya existen --> "+e);
			}
			
			

			
		}catch(ClassNotFoundException ex){
			 JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
	            conexion=null;
			
			
		} catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "No se podrá acceder a la información del sistema debido a que la aplicación ya está abierta", "ERROR AL CONECTARSE CON LA BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            conexion=null;
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        finally
        {
            return conexion;
        }
	}

}
