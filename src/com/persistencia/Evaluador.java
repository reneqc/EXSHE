package com.persistencia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
public class Evaluador {
	
	public int id;
	public String nombre;
	public String apellido;
	public String email;
	public String direccion;
	public String cargo;
	public String profesion;
	public String telefono;
	public String perfil;
	public String empresa;
	public String password;
	private static Connection conex=Conexion.obtenerConexion();
	
	
	public Evaluador(){
		
	}
	
	//Constructor Utilizado para Actualizar Evaluadores
	public Evaluador(int id,String nombre, String apellido, String email,String direccion, String cargo, String profesion, String telefono, String empresa, String password){
		this.id=id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.direccion = direccion;
		this.cargo = cargo;
		this.profesion = profesion;
		this.telefono = telefono;
		this.perfil = "EVALUADOR";
		this.empresa = empresa;
		this.password = password;
		
	}
	
	//Constructor Utilizado para crear nuevos evaluadores
	public Evaluador(String nombre, String apellido, String email,String direccion, String cargo, String profesion, String telefono, String empresa, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.direccion = direccion;
		this.cargo = cargo;
		this.profesion = profesion;
		this.telefono = telefono;
		this.perfil = "EVALUADOR";
		this.empresa = empresa;
		this.password = password;
	}
	
	public int guardar(){
		try {
			Statement sentencia = (Statement) conex.createStatement();			
			String cadena = "insert into evaluador(nombre,apellido,email,direccion,cargo,profesion,telefono,perfil,empresaEvaluador,password)"
					+ " values ('"+this.nombre+"','"+this.apellido+"','"+this.email+"','"+this.direccion+"','"+this.cargo+"','"+this.profesion+"','"+this.telefono+"','"+this.perfil+"','"+this.empresa+"','"+this.password+"')";
			sentencia.execute(cadena);
			return 1;
		} catch (SQLException e ) {
			System.out.println(e);
			return 0;
		}

	}
	
	public int actualizar(){
		try {
			Statement sentencia = (Statement) conex.createStatement();			
			String cadena = "update evaluador set apellido='"+this.apellido+"', nombre='"+this.nombre+"', email='"+this.email+"', direccion='"+this.direccion+"', cargo='"+this.cargo+"', profesion='"+this.profesion+"', telefono='"+this.telefono+"', empresaEvaluador='"+this.empresa+"', password='"+this.password+"' where id_evaluador="+this.id;                 
			sentencia.execute(cadena);
			return 1;
		} catch (SQLException e ) {
			System.out.println(e);
			return 0;
		}

	}
	
	public String verificarDatos(String email, String password){
		try {
			String emailBdd="";
			String passwordBdd="";
			String perfil="desconocido";
			
			Statement sentencia = (Statement) conex.createStatement();
			String cadena = "SELECT email,password,perfil FROM evaluador WHERE email='"+email+"' and password='"+password+"'";
			ResultSet rs = sentencia.executeQuery(cadena);		
				
			
			while(rs.next()){
				emailBdd=rs.getString(1).toString();
				passwordBdd=rs.getString(2);				
				perfil= rs.getString(3);
				
			
			}
			
			if(email.equals(emailBdd) && password.equals(passwordBdd)){
				return perfil;
				
			}
			return perfil;
			
		} catch (Exception e) {
			System.out.println(e);
			return perfil;
		}
		
	}
	
	
	public static ResultSet consultarTodos() throws SQLException{
		Statement sentencia = (Statement) conex.createStatement();
		String cadena = "SELECT * FROM evaluador";
		ResultSet rs = sentencia.executeQuery(cadena);
		return rs;
		
	}

}
