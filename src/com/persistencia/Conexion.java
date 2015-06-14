package com.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	
	@SuppressWarnings("finally")
	public static Connection obtenerConexion(){
		Connection conexion=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String servidor="jdbc:mysql://localhost:3306/exshe1";
			String usuarioDb="root";
			String passDb="12345";
			conexion=(Connection) DriverManager.getConnection(servidor,usuarioDb,passDb);
			//JOptionPane.showMessageDialog(null,"Conexión Exitosa");
		}catch(ClassNotFoundException ex){
			 JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
	            conexion=null;
			
			
		} catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
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
