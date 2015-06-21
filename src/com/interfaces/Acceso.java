package com.interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Acceso extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceso frame = new Acceso();
					frame.setVisible(true);		
					frame.setExtendedState(MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Acceso() {
		setTitle("EXSHE - VENTANA DE ACCESO");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarAcceso();
			}
		});
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Acceso.class.getResource("/img/logo1.png")));
		lblNewLabel.setBounds(342, 12, 118, 123);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(223, 223, 233));
		panel.setBounds(491, 26, 572, 96);
		contentPane.add(panel);
		
		JLabel label_1 = new JLabel("Expert System of Heuristic Evaluation");
		label_1.setFont(new Font("Dialog", Font.BOLD, 25));
		label_1.setBounds(12, 27, 560, 30);
		panel.add(label_1);
		
		JLabel label = new JLabel("Inicio de Sesión");
		label.setFont(new Font("Dialog", Font.PLAIN, 16));
		label.setBounds(12, 69, 278, 15);
		panel.add(label);
		
		JButton btnNewButton = new JButton("Ingresar");	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login login=new Login();
				login.show();
				dispose();
				
			}
		});
		btnNewButton.setBounds(491, 134, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro registro1=new Registro();
				registro1.show();
				dispose();
			}
		});
		btnRegistro.setBounds(620, 134, 117, 25);
		contentPane.add(btnRegistro);
		
		JLabel label_3 = new JLabel("<html><center> </center> <br><div style='text-align:justify;'>Esta aplicación tiene por objeto servir de apoyo para la evaluación de la usabilidad de aplicaciones. Es una versión resumida de la guía que nosotros utilizamos en nuestra actividad profesional, aunque lo suficientemente extensa y específica como para resultar de utilidad a aquellos profesionales que requieran de un software base con el que empezar a trabajar en evaluación heurística.<br> <br>La sistema está estructurada en forma de checklist, para facilitar la práctica de la evaluación. Todos las puntos están formulados como preguntas, dónde la respuesta afirmativa implica que que no existe un problema de usabilidad, y la negativa que si.<br><br> Antes de iniciar con la evaluación debe registrarse o si ya dispone de un usuario puede ingresar.</div></html>");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_3.setBounds(36, 241, 503, 405);
		contentPane.add(label_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(223, 223, 233));
		panel_1.setBounds(36, 206, 503, 58);
		contentPane.add(panel_1);
		
		JLabel label_4 = new JLabel("¿Qué es EXSHE?");
		label_4.setFont(new Font("Dialog", Font.BOLD, 25));
		label_4.setBounds(147, 12, 235, 30);
		panel_1.add(label_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(223, 223, 233));
		panel_2.setBounds(580, 206, 340, 58);
		contentPane.add(panel_2);
		
		JLabel lblCriteriosAEvaluar = new JLabel("Criterios a Evaluar");
		lblCriteriosAEvaluar.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCriteriosAEvaluar.setBounds(53, 12, 286, 30);
		panel_2.add(lblCriteriosAEvaluar);
		
		JLabel criterios = new JLabel(verCriterios());
		criterios.setFont(new Font("Dialog", Font.PLAIN, 16));
		criterios.setBounds(554, 285, 398, 437);
		contentPane.add(criterios);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(223, 223, 233));
		panel_3.setBounds(967, 206, 344, 58);
		contentPane.add(panel_3);
		
		JLabel lblFunciones = new JLabel("Funciones");
		lblFunciones.setFont(new Font("Dialog", Font.BOLD, 25));
		lblFunciones.setBounds(101, 12, 152, 30);
		panel_3.add(lblFunciones);
		this.setLocationRelativeTo(null);
	}
	
	
	public String verInformacion(){
		return "<html>"+
				    "<center>"+
				    " "+
				    "</center> <br>"+
				    "<div style='text-align:justify;'>"+
				    "Esta aplicación tiene por objeto servir de apoyo para la evaluación de la usabilidad de aplicaciones. Es una versión resumida de la guía que nosotros utilizamos en nuestra actividad profesional, aunque lo suficientemente extensa y específica como para resultar de utilidad a aquellos profesionales que requieran de un software base con el que empezar a trabajar en evaluación heurística.<br> <br>"+			
				    "La sistema está estructurada en forma de checklist, para facilitar la práctica de la evaluación. Todos las puntos están formulados como preguntas, dónde la respuesta afirmativa implica que que no existe un problema de usabilidad, y la negativa que si.<br><br> Antes de iniciar con la evaluación debe registrarse o si ya dispone de un usuario puede ingresar."+
				    "</div>"+
				"</html>";
	}
	
	public String verCriterios(){
		return 		"<html><ul>"+
					"<li>ASPECTOS GENERALES</li><br>"+
					"<li>IDENTIDAD E INFORMACIÓN </li><br>"+					
					"<li>ESTRUCTURA Y NAVEGACIÓN</li><br>"+					
					"<li>ROTULADO</li><br>"+					
					"<li>ESTRUCTURA Y NAVEGACIÓN</li><br>"+					
					"<li>LAYOUT DE LA PÁGINA</li><br>"+					
					"<li>ENTENDIBILIDAD Y FACILIDAD EN LA INTERACCIÓN</li><br>"+					
					"<li>CONTROL Y RETROALIMENTACIÓN</li><br>"+					
					"<li>ELEMENTOS MULTIMEDIA</li><br>"+					
					"<li>BÚSQUEDA Y AYUDA</li><br>"+														
					"</ul></html>";
	}
	
	
	public void cerrarAcceso(){
		Object [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(rootPane,"Esta seguro que desea cerrar la aplicación","Mensaje de Confirmación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
		if (eleccion == JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}else{
			
		}
	}
	
}
