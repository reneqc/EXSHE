package com.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Evaluador {
	
	
	public String nombre;
	public String apellido;
	public String password;
	public String email;

	private Connection conex=Conexion.obtenerConexion();
	
	public Evaluador(){
		
	}
	
	public Evaluador(String n, String a, String p, String u){
		
		this.nombre=n;
		this.apellido=a;
		this.password=p;
		this.email=u;

	}
	
	public int guardar(){
		try {
			Statement sentencia = (Statement) conex.createStatement();			
			String cadena = "insert into evaluador(nombre,apellido,password,username) values ('"+this.nombre+"','"+this.apellido+"','"+this.password+"','"+this.email+"')";
			sentencia.execute(cadena);
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}

	}
	
	public boolean verificarDatos(String username, String password){
		try {
			String usernameBdd="";
			String passwordBdd="";
			
			Statement sentencia = (Statement) conex.createStatement();
			String cadena = "SELECT * FROM evaluador WHERE email='"+username+"' and password='"+password+"'";
			ResultSet rs = sentencia.executeQuery(cadena);		
				
			
			while(rs.next()){
				usernameBdd=rs.getString(3).toString();
				passwordBdd=rs.getString(11);
			
			}
			
			if(username.equals(usernameBdd) && password.equals(passwordBdd)){
				return true;
			}else{
				return false;
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		
		
	}

}
