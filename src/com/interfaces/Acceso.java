package com.interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.persistencia.Conexion;
import com.persistencia.Evaluador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;
import java.awt.Toolkit;

public class Acceso extends JFrame {

	private JPanel contentPane;
	private static JTextField txt_email;
	private JPasswordField txt_password;
	Evaluador evaluador=new Evaluador();
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Acceso.class.getResource("/img/logo1.png")));
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
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(223, 223, 233));
		panel.setBounds(324, 12, 742, 125);
		contentPane.add(panel);
		
		JLabel label_1 = new JLabel("Expert System of Heuristic Evaluation");
		label_1.setFont(new Font("Dialog", Font.BOLD, 25));
		label_1.setBounds(180, 30, 560, 30);
		panel.add(label_1);
		
		JLabel label = new JLabel("Inicio de Sesión");
		label.setFont(new Font("Dialog", Font.PLAIN, 16));
		label.setBounds(180, 72, 130, 15);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(26, 0, 118, 123);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Acceso.class.getResource("/img/logo1.png")));
		
		JLabel label_3 = new JLabel("<html><center> </center> <br><div style='text-align:justify;'><b>Expert System of Heuristic Evaluation</b> tiene por objeto servir de apoyo para la evaluación de usabilidad en aplicaciones mediante el análisis heurístico, constituyendose en una guía específica para aquellos profesionales que requieran de un software base con el que se pueda desarrollar una evaluación de usabilidad.<br> <br>El sistema permite ejecutar evaluaciones en forma de checklist que ayudan a identificar falencias dentro de una respectiva aplicación, todos las puntos están formulados como preguntas que tienen una posible respuesta en el rango de una escala numérica o textual que permitirá establecer si se evidencia o no un problema de usabilidad.<br><br> Para poder trabajar con EXSHE debe disponer de una cuenta proporcionada por el administrador del sistema.</div></html>");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_3.setBounds(36, 259, 503, 405);
		contentPane.add(label_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(223, 223, 233));
		panel_1.setBounds(36, 235, 503, 58);
		contentPane.add(panel_1);
		
		JLabel label_4 = new JLabel("¿Qué es EXSHE?");
		label_4.setFont(new Font("Dialog", Font.BOLD, 25));
		label_4.setBounds(147, 12, 235, 30);
		panel_1.add(label_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(223, 223, 233));
		panel_2.setBounds(583, 235, 340, 58);
		contentPane.add(panel_2);
		
		JLabel lblCriteriosAEvaluar = new JLabel("Criterios a Evaluar");
		lblCriteriosAEvaluar.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCriteriosAEvaluar.setBounds(53, 12, 286, 30);
		panel_2.add(lblCriteriosAEvaluar);
		
		JLabel criterios = new JLabel(verCriterios());
		criterios.setFont(new Font("Dialog", Font.PLAIN, 16));
		criterios.setBounds(551, 308, 398, 437);
		contentPane.add(criterios);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(223, 223, 233));
		panel_3.setBounds(967, 235, 344, 58);
		contentPane.add(panel_3);
		
		JLabel lblFunciones = new JLabel("Funciones");
		lblFunciones.setFont(new Font("Dialog", Font.BOLD, 25));
		lblFunciones.setBounds(101, 12, 152, 30);
		panel_3.add(lblFunciones);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(223, 223, 233));
		panel_4.setBounds(324, 149, 286, 27);
		contentPane.add(panel_4);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEmail.setBounds(12, 5, 69, 15);
		panel_4.add(lblEmail);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBorder(null);
		txt_email.setBackground(new Color(223, 223, 233));
		txt_email.setBounds(73, 3, 208, 20);
		panel_4.add(txt_email);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(223, 223, 233));
		panel_5.setBounds(622, 149, 304, 27);
		contentPane.add(panel_5);
		
		JLabel label_5 = new JLabel("Contraseña:");
		label_5.setFont(new Font("Dialog", Font.BOLD, 13));
		label_5.setBounds(10, 5, 89, 15);
		panel_5.add(label_5);
		
		txt_password = new JPasswordField();
		txt_password.setColumns(10);
		txt_password.setBorder(null);
		txt_password.setBackground(new Color(223, 223, 233));
		txt_password.setBounds(111, 4, 182, 20);
		panel_5.add(txt_password);
		
		final JButton btn_ingresar = new JButton("  Ingresar");
		btn_ingresar.setIcon(new ImageIcon(Acceso.class.getResource("/img/entrar.png")));
		btn_ingresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				resaltar(btn_ingresar);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				noResaltar(btn_ingresar);
			}
		});
		btn_ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ingresar();
			}
		});
		btn_ingresar.setBorder(UIManager.getBorder("CheckBox.border"));
		btn_ingresar.setBackground(SystemColor.controlHighlight);
		btn_ingresar.setBounds(938, 149, 127, 27);
		contentPane.add(btn_ingresar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Acceso.class.getResource("/img/usuarios.png")));
		lblNewLabel_1.setBounds(1011, 296, 64, 72);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Acceso.class.getResource("/img/subheuristicos.png")));
		label_2.setBounds(1011, 590, 64, 72);
		contentPane.add(label_2);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Acceso.class.getResource("/img/ejecucion.png")));
		label_6.setBounds(1011, 379, 64, 72);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Acceso.class.getResource("/img/proyecto.png")));
		label_7.setBounds(1011, 479, 64, 72);
		contentPane.add(label_7);
		
		JLabel lblManejoDeUsuarios = new JLabel("Manejo de Usuarios");
		lblManejoDeUsuarios.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblManejoDeUsuarios.setBounds(1098, 329, 170, 15);
		contentPane.add(lblManejoDeUsuarios);
		
		JLabel lblEjecucinDeEvaluaciones = new JLabel("Ejecución de Evaluaciones");
		lblEjecucinDeEvaluaciones.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblEjecucinDeEvaluaciones.setBounds(1098, 400, 213, 15);
		contentPane.add(lblEjecucinDeEvaluaciones);
		
		JLabel lblInformesDeResultados = new JLabel("Informes de Resultados");
		lblInformesDeResultados.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblInformesDeResultados.setBounds(1098, 500, 213, 15);
		contentPane.add(lblInformesDeResultados);
		
		JLabel lblNuevosCriterios = new JLabel("Administración de criterios");
		lblNuevosCriterios.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNuevosCriterios.setBounds(1098, 604, 213, 15);
		contentPane.add(lblNuevosCriterios);
		
		JLabel lblDeEvaluacin = new JLabel("de Evaluación");
		lblDeEvaluacin.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblDeEvaluacin.setBounds(1098, 631, 213, 15);
		contentPane.add(lblDeEvaluacin);
		this.setLocationRelativeTo(null);
		
		//Conexion.obtenerConexion();
	}
	
	
	public String verInformacion(){
		return "<html>"+
				    "<center>"+
				    " "+
				    "</center> <br>"+
				    "<div style='text-align:justify;'>"+
				    "Esta aplicación tiene por objeto servir de apoyo para la evaluación de la usabilidad de aplicaciones. Es una versión resumida de la guía que nosotros utilizamos en nuestra actividad profesional, aunque lo suficientemente extensa y específica como para resultar de utilidad a aquellos profesionales que requieran de un software base con el que empezar a trabajar en evaluación heurística.<br> <br>"+			
				    "La sistema está estructurada en forma de checklist, para facilitar la práctica de la evaluación. Todos las puntos están formulados como preguntas, dónde la respuesta afirmativa implica que que no existe un problema de usabilidad, y la negativa que si.<br><br> Antes de iniciar con la evaluación debe disponer de una cuenta."+
				    "</div>"+
				"</html>";
	}
	
	public String verCriterios(){
		return 		"<html><ul>"+
					"<li>ASPECTOS GENERALES</li><br>"+
					"<li>IDENTIDAD E INFORMACIÓN </li><br>"+					
					"<li>ESTRUCTURA Y NAVEGACIÓN</li><br>"+					
					"<li>ROTULADO</li><br>"+									
					"<li>LAYOUT DE LA PÁGINA</li><br>"+					
					"<li>ENTENDIBILIDAD Y FACILIDAD EN LA INTERACCIÓN</li><br>"+					
					"<li>CONTROL Y RETROALIMENTACIÓN</li><br>"+					
					"<li>ELEMENTOS MULTIMEDIA</li><br>"+					
					"<li>BÚSQUEDA</li><br>"+	
					"<li>AYUDA</li><br>"+	
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
	
	public void ingresar(){
			
			if(txt_email.getText().equals("") || txt_password.getText().equals("")){
				if(txt_password.getText().equals("")){
					txt_password.requestFocus();
				}
				if(txt_email.getText().equals("")){
					txt_email.requestFocus();
				}
				JOptionPane.showMessageDialog(null, "Por favor complete los campos.");
			}else{
						
				if(evaluador.verificarDatos(txt_email.getText(), txt_password.getText()).equals("ADMINISTRADOR")){				
					JOptionPane.showMessageDialog(null, "Bienvenido Administrador");			
					PrincipalAdministrador prin=new PrincipalAdministrador();
					prin.lbl_evaluador.setText(txt_email.getText());
					prin.show();
					prin.setExtendedState(MAXIMIZED_BOTH);				
					dispose();	
					
				}else if(evaluador.verificarDatos(txt_email.getText(), txt_password.getText()).equals("EVALUADOR")){
					JOptionPane.showMessageDialog(null, "Bienvenido Evaluador");
					PrincipalEvaluador prin=new PrincipalEvaluador();
					prin.lbl_evaluador.setText(txt_email.getText());
					prin.show();
					prin.setExtendedState(MAXIMIZED_BOTH);
					dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Contraseña o Username incorrecto.");
					txt_password.setText("");
					txt_email.setText("");
					txt_email.requestFocus();
				}
					
			}
		}
		public static void resaltar(JButton btn){
			btn.setBackground(new Color(200,200,200));
			
		}
		
		public static void noResaltar(JButton btn){
			btn.setBackground(new Color(230,230,230));
			
		}
	
		public static String conectado(){
			return txt_email.getText();
		}
}
