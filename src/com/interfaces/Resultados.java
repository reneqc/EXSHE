package com.interfaces;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
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
		
		motor=new Rete();
		motorHeuristicos = new Rete();
		
		try {
			motor.batch("heuristicas.clp");
			motor.assertString("(Informe (nombre "+id+")(porcentaje "+Evaluacion.consultarPorcentajeCalificados(id)+"))");
			motor.executeCommand("(facts)");
			
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
		scrollPane.setBounds(535, 55, 366, 298);
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
		try{
			motor.run();			
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
			
			txtResultado.setText(mensaje);
			try {
				motor.executeCommand("(facts)");
			} catch (JessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}catch(Exception ex){
			System.out.println("Error ----------->>>>>> "+ex);
		}
		
		

	}

	public void obtenerRecomendacionesHeuristicos() throws SQLException {
		Map val = new HashMap();
		
		String[] ides= {"AG","II","EN","RO","LA","EF","CR","EM","BU","AY"};
		
		for (int i = 0; i < ides.length; i++) {
			
			val.put(ides[i], Evaluacion.consultarPromedioHeuristico(idEvaluacion, ides[i]));
		}
		for (int i = 0; i < val.size(); i++) {
			val.put(ides[i], Evaluacion.consultarPromedioHeuristico(idEvaluacion, ides[i]));
		}
		

	}
	
	public void obtenerRecomendacionesCriterios() {

	}
}
