package com.interfaces;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import jess.Fact;
import jess.JessException;
import jess.Rete;

import com.persistencia.Evaluacion;

public class Resultados extends JFrame {

	public int idEvaluacion;
	private JPanel contentPane;
	private static Rete motor;
	private static Rete motorHeuristicos;
	public JTextArea txtResultado;
	public Map values = new HashMap();
	public String[] ides= {"AG","II","EN","RO","LA","EF","CR","EM","BU","AY"};
	public float[] proms = {0,0,0,0,0,0,0,0,0,0};
	public String[] resul= null;
	ArrayList<String> results= new ArrayList<String>();
	ArrayList<ResultSet> records;
	ArrayList<Rete> motores = new ArrayList<Rete>();
	
	public String[] archivos= {"ag.clp","ii.clp","en.clp","ro.clp","la.clp","ef.clp","cr.clp","em.clp","bu.clp","ay.clp"};

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resultados frame = new Resultados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Resultados(int id) throws SQLException {
		idEvaluacion=id;
		records= new ArrayList<ResultSet>();
		
		
		for (int i = 0; i < ides.length; i++) {
			proms[i]=Evaluacion.consultarPromedioHeuristico(idEvaluacion, ides[i]);			
		}
		
		for (int i = 0; i < ides.length; i++) {
			records.add(Evaluacion.consultarListaNotas(idEvaluacion, ides[i]));
		}
		for (int i = 0; i < archivos.length; i++) {
			Rete moto= new Rete();
			try {
				moto.batch(archivos[i]);
				while (records.get(i).next()) {
					moto.assertString("(Criterio(nombre "+records.get(i).getString(2)+")(calificacion "+records.get(i).getString(1)+"))");				
				}
				
				moto.executeCommand("(facts)");
				motores.add(moto);				
			} catch (JessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		motor=new Rete();
		motorHeuristicos = new Rete();
		
		try {
			motor.batch("heuristicas.clp");
			motorHeuristicos.batch("Individuales.clp");
			for (int i = 0; i < ides.length ; i++) {
				motorHeuristicos.assertString("(Heuristico(nombre "+ides[i]+")(promedio "+proms[i]+"))");
			}
			motor.assertString("(Informe (nombre "+id+")(porcentaje "+Evaluacion.consultarPorcentajeCalificados(id)+"))");
			motor.executeCommand("(facts)");
			motorHeuristicos.executeCommand("(facts)");
			
		} catch (JessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		setTitle("EXSHE - INFORMES");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarInformes();
			}
		});

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1366, 730);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 55, 1249, 583);
		contentPane.add(scrollPane);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
		obtenerNivelUsabilidad();
	}

	public void cerrarInformes() {

		dispose();

	}

	public void obtenerNivelUsabilidad() {
		
		
		
		String mensaje="El nivel de usabilidad del sitio es ";
		String otro= "\n Se recomienda: \n";
		try{
			
			motor.run();
			motorHeuristicos.run();
			Iterator it=motor.listFacts();
			Fact faux;
			
			while(it.hasNext()){
				faux=(Fact)it.next();
				
				if(faux.getName().equals("MAIN::Informe")){
					
					System.out.println("Guarda la rutina");
					
					mensaje+=faux.getSlotValue("porcentaje")+" que representa: "+faux.getSlotValue("condicion")+"\n";
					
				}else{
					System.out.println("Entra Aqui");
				}		
				
			}
			
			/*
			 * Iteracion de recomendaciones de heuristicos
			 * 
			 */
			
			Iterator itEur=motorHeuristicos.listFacts();
			Fact fauxE;
			
			while(itEur.hasNext()){
				
				
				fauxE=(Fact)itEur.next();
				
				if(fauxE.getName().equals("MAIN::Heuristico")){
					
					System.out.println("Guarda la rutina");
					if (!fauxE.getSlotValue("condicion").toString().equals("nil")) {
						results.add(""+fauxE.getSlotValue("nombre"));
						//mensaje+=fauxE.getSlotValue("nombre")+" que representa: "+fauxE.getSlotValue("condicion")+"\n";						
					}					
					
				}else{
					System.out.println("Entra Aqui");
				}
				
			}
			
			
			/*
			 * Testing
			 * 
			 */
			for (int i = 0; i < motores.size(); i++) {
				
					motores.get(i).run();
					Iterator itTest=motores.get(i).listFacts();
					Fact fauxTest;
					
					
					while(itTest.hasNext()){
						fauxTest=(Fact)itTest.next();
						
						if(fauxTest.getName().equals("MAIN::Criterio")){
							
							System.out.println("Guarda la rutina");
							
								if (!fauxTest.getSlotValue("condicion").toString().equals("nil")) {
									otro+=fauxTest.getSlotValue("nombre")+" que representa: "+fauxTest.getSlotValue("condicion")+"\n";									
								}
							
						}else{
							System.out.println("Entra Aqui");
						}		
						
					}
					motores.get(i).executeCommand("(facts)");
			
			}
			
			
			
			txtResultado.setText(mensaje+otro);
			try {
				
				motor.executeCommand("(facts)");
				motorHeuristicos.executeCommand("(facts)");
			} catch (JessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}catch(Exception ex){
			System.out.println("Error ----------->>>>>> "+ex);
		}
		
		

	}

	public void obtenerRecomendacionesHeuristicos() throws SQLException {
		
		
		for (int i = 0; i < values.size(); i++) {
			values.put(ides[i], Evaluacion.consultarPromedioHeuristico(idEvaluacion, ides[i]));
		}
		

	}
	
	public void obtenerRecomendacionesCriterios() {

	}
}
