package com.pruebas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.persistencia.Evaluacion;
import com.persistencia.Evaluador;
import com.persistencia.Heuristico;

public class Principal {

	@Test
	public void crearEvaluador() {
		
		Evaluador u=new Evaluador("Jose", "Valencia","jvalencia@gmail.com", "Latacunga", "Docente", "Ing. en Sistemas", "0989098789", "UTC", "123456");
		
		
		assertEquals(0,u.guardar());
		
	}

	
	@Test
	public void actualizarEvaluador() {
		
		Evaluador u=new Evaluador(2,"Jose", "Valencia","jvalencia@gmail.com", "Quito", "Secretario", "Ing. Comercial", "0989098789", "UTC", "123456");
		
		
		assertEquals(1,u.actualizar());
		
	}
	
	@Test
	public void autenticar() {
		
		Evaluador u=new Evaluador();
		
		//evitando datos repetidos
		assertEquals(true,u.verificarDatos("admin","admin"));
	}

	@Test
	
	public void consultaHeuristico(){
		
		Heuristico h=new Heuristico();
		
	}
	
	@Test	
	public void verFecha(){
		
		Evaluacion e=new Evaluacion();
		System.out.println(e.obtenerFecha());
		
	}
	
	
	
	/*
	@Test	
	public void crearEvaluacion(){
		
		Evaluacion e=new Evaluacion("Youtube","Internet Explorer","V8.1","www.youtube.com",1);
		
		assertEquals(1,e.guardar());

		
	}
	*/
	
	
}
