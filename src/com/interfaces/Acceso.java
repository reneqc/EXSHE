package com.interfaces;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import com.persistencia.Conexion;
import com.persistencia.Evaluador;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		setBounds(100, 100, 1366, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(223, 223, 233));
		panel.setBounds(324, 11, 742, 109);
		contentPane.add(panel);
		
		JLabel label_1 = new JLabel("Expert System of Heuristic Evaluation");
		label_1.setFont(new Font("Dialog", Font.BOLD, 25));
		label_1.setBounds(182, 22, 560, 30);
		panel.add(label_1);
		
		JLabel label = new JLabel("Inicio de Sesión");
		label.setFont(new Font("Dialog", Font.PLAIN, 16));
		label.setBounds(180, 63, 130, 15);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(26, 0, 118, 114);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Acceso.class.getResource("/img/logo1.png")));
		
		JLabel label_3 = new JLabel("<html><center> </center> <br><div style='text-align:justify;'><b>Expert System of Heuristic Evaluation</b> tiene por objeto servir de apoyo para la evaluación de usabilidad en aplicaciones mediante el análisis heurístico, constituyendose en una guía específica para aquellos profesionales que requieran de un software base con el que se pueda desarrollar una evaluación de usabilidad.<br> <br>El sistema permite ejecutar evaluaciones con las que se búsca identificar falencias dentro de una respectiva aplicación, todos los puntos están formulados como preguntas que tienen una posible respuesta en el rango de una escala numérica o textual que permitirá establecer si se evidencia o no un problema de usabilidad.<br><br> Para poder trabajar con EXSHE debe disponer de una cuenta proporcionada por el administrador del sistema.</div></html>");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_3.setBounds(46, 203, 503, 373);
		contentPane.add(label_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(223, 223, 233));
		panel_1.setBounds(46, 188, 503, 39);
		contentPane.add(panel_1);
		
		JLabel lblquEsExshe = new JLabel("¿Qué es EXSHE?");
		lblquEsExshe.setFont(new Font("Dialog", Font.BOLD, 25));
		lblquEsExshe.setBounds(139, 0, 235, 39);
		panel_1.add(lblquEsExshe);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(223, 223, 233));
		panel_2.setBounds(586, 188, 340, 39);
		contentPane.add(panel_2);
		
		JLabel lblCriteriosAEvaluar = new JLabel("Criterios a Evaluar");
		lblCriteriosAEvaluar.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCriteriosAEvaluar.setBounds(53, 0, 286, 39);
		panel_2.add(lblCriteriosAEvaluar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(223, 223, 233));
		panel_3.setBounds(967, 188, 344, 39);
		contentPane.add(panel_3);
		
		JLabel lblFunciones = new JLabel("Funciones");
		lblFunciones.setFont(new Font("Dialog", Font.BOLD, 25));
		lblFunciones.setBounds(101, 0, 152, 39);
		panel_3.add(lblFunciones);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(223, 223, 233));
		panel_4.setBounds(324, 131, 286, 27);
		contentPane.add(panel_4);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEmail.setBounds(12, 5, 69, 15);
		panel_4.add(lblEmail);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBorder(null);
		txt_email.setBackground(new Color(223, 223, 233));
		txt_email.setBounds(64, 3, 217, 20);
		panel_4.add(txt_email);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(223, 223, 233));
		panel_5.setBounds(622, 131, 304, 27);
		contentPane.add(panel_5);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Dialog", Font.BOLD, 13));
		lblContrasea.setBounds(10, 5, 89, 15);
		panel_5.add(lblContrasea);
		
		txt_password = new JPasswordField();
		txt_password.setColumns(10);
		txt_password.setBorder(null);
		txt_password.setBackground(new Color(223, 223, 233));
		txt_password.setBounds(97, 4, 196, 20);
		panel_5.add(txt_password);
		
		final JButton btn_ingresar = new JButton("  Ingresar");
		btn_ingresar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode()==KeyEvent.VK_ENTER) 
				{				
						
					ingresar();
					
				}
			}
		});
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
		btn_ingresar.setBounds(938, 131, 127, 27);
		contentPane.add(btn_ingresar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Acceso.class.getResource("/img/usuarios.png")));
		lblNewLabel_1.setBounds(1011, 251, 64, 72);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Acceso.class.getResource("/img/ejecucion.png")));
		label_6.setBounds(1011, 349, 64, 72);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Acceso.class.getResource("/img/proyecto.png")));
		label_7.setBounds(1011, 466, 64, 72);
		contentPane.add(label_7);
		
		JLabel lblManejoDeUsuarios = new JLabel("Manejo de Usuarios");
		lblManejoDeUsuarios.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblManejoDeUsuarios.setBounds(1098, 281, 170, 15);
		contentPane.add(lblManejoDeUsuarios);
		
		JLabel lblEjecucinDeEvaluaciones = new JLabel("Ejecución de Evaluaciones");
		lblEjecucinDeEvaluaciones.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblEjecucinDeEvaluaciones.setBounds(1085, 372, 213, 15);
		contentPane.add(lblEjecucinDeEvaluaciones);
		
		JLabel lblInformesDeResultados = new JLabel("Informes de Resultados");
		lblInformesDeResultados.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblInformesDeResultados.setBounds(1098, 500, 213, 15);
		contentPane.add(lblInformesDeResultados);
		
		final JButton btnAyuda = new JButton("  Ayuda");
		btnAyuda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode()==KeyEvent.VK_ENTER) 
				{
					
				abrirAyuda();	
				}
			}
		});
		btnAyuda.setToolTipText("Abrir Contenido de Ayuda");
		btnAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				resaltar(btnAyuda);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				noResaltar(btnAyuda);
			}
		});
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirAyuda();
			}
		});
		btnAyuda.setIcon(new ImageIcon(Acceso.class.getResource("/img/help1.png")));
		btnAyuda.setBorder(UIManager.getBorder("CheckBox.border"));
		btnAyuda.setBackground(SystemColor.controlHighlight);
		btnAyuda.setBounds(206, 601, 127, 27);
		contentPane.add(btnAyuda);
		
		JLabel lblAspectosGenerales = new JLabel("1. ASPECTOS GENERALES");
		lblAspectosGenerales.setToolTipText("Se refiere a objetivos, look & feel, coherencia y nivel de actualización de contenidos.");
		lblAspectosGenerales.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblAspectosGenerales.setBounds(586, 239, 340, 39);
		contentPane.add(lblAspectosGenerales);
		
		JLabel lblIdentidad = new JLabel("2. IDENTIDAD E INFORMACIÓN");
		lblIdentidad.setToolTipText("Se refiere a la identidad del sitio e información sobre el proveedor y la autoría de los contenidos");
		lblIdentidad.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblIdentidad.setBounds(586, 278, 340, 39);
		contentPane.add(lblIdentidad);
		
		JLabel lblEstructuraY = new JLabel("3. ESTRUCTURA Y NAVEGACIÓN");
		lblEstructuraY.setToolTipText("Centrado en la idoneidad de la arquitectura de información y navegación del sitio");
		lblEstructuraY.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblEstructuraY.setBounds(586, 318, 340, 39);
		contentPane.add(lblEstructuraY);
		
		JLabel lblRotulado = new JLabel("4. ROTULADO");
		lblRotulado.setToolTipText("Representa la significación y familiaridad del rotulado de los contenidos");
		lblRotulado.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblRotulado.setBounds(586, 357, 340, 39);
		contentPane.add(lblRotulado);
		
		JLabel lblLayoutDeLa = new JLabel("5. LAYOUT DE LA PÁGINA");
		lblLayoutDeLa.setToolTipText("Análisis de la distribución y aspecto de los elementos de navegación e información en la interfaz");
		lblLayoutDeLa.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblLayoutDeLa.setBounds(586, 397, 340, 39);
		contentPane.add(lblLayoutDeLa);
		
		JLabel lblEntendibilidadY = new JLabel("6. ENTENDIBILIDAD Y FACILIDAD EN LA");
		lblEntendibilidadY.setToolTipText("Representa la calidad de los contenidos textuales");
		lblEntendibilidadY.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblEntendibilidadY.setBounds(586, 437, 340, 39);
		contentPane.add(lblEntendibilidadY);
		
		JLabel lblElementosMultimedia = new JLabel("7. CONTROL Y RETROALIMENTACIÓN");
		lblElementosMultimedia.setToolTipText("Se informa al usuario de lo que está ocurriendo en la web");
		lblElementosMultimedia.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblElementosMultimedia.setBounds(587, 507, 340, 39);
		contentPane.add(lblElementosMultimedia);
		
		JLabel lblElementosMultimedia_1 = new JLabel("8. ELEMENTOS MULTIMEDIA");
		lblElementosMultimedia_1.setToolTipText("Mide la calidad de los distintos elementos audiovisuales");
		lblElementosMultimedia_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblElementosMultimedia_1.setBounds(587, 548, 340, 39);
		contentPane.add(lblElementosMultimedia_1);
		
		JLabel lblBsqueda = new JLabel("9. BÚSQUEDA");
		lblBsqueda.setToolTipText("Mide las opciones de búsqueda interna de la página");
		lblBsqueda.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblBsqueda.setBounds(587, 587, 340, 39);
		contentPane.add(lblBsqueda);
		
		JLabel lblAyuda = new JLabel("10. AYUDA");
		lblAyuda.setToolTipText("Mide los elementos de apoyo para que el usuario tenga una navegación fluida");
		lblAyuda.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblAyuda.setBounds(586, 627, 340, 39);
		contentPane.add(lblAyuda);
		
		JLabel lblInteraccin = new JLabel("INTERACCIÓN");
		lblInteraccin.setToolTipText("Representa la calidad de los contenidos textuales");
		lblInteraccin.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblInteraccin.setBounds(608, 463, 340, 39);
		contentPane.add(lblInteraccin);
		this.setLocationRelativeTo(null);
		
		//Conexion.obtenerConexion();
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
		int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Está seguro que desea cerrar la aplicación?","Mensaje de Confirmación",
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
					//prin.setExtendedState(MAXIMIZED_BOTH);				
					dispose();	
					
				}else if(evaluador.verificarDatos(txt_email.getText(), txt_password.getText()).equals("EVALUADOR")){
					JOptionPane.showMessageDialog(null, "Bienvenido Evaluador");
					PrincipalEvaluador prin=new PrincipalEvaluador();
					prin.lbl_evaluador.setText(txt_email.getText());
					prin.show();
					//prin.setExtendedState(MAXIMIZED_BOTH);
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
		
		
		public void abrirAyuda(){
			try {
			     File path = new File ("C:\\EXSHE\\ayuda\\ayuda_exshe.pdf");
			     Desktop.getDesktop().open(path);
			   // JOptionPane.showMessageDialog(null,"Abriendo archivo de ayuda (.pdf)");
			}catch (IOException ex) {
			     ex.printStackTrace();
			     JOptionPane.showMessageDialog(null,"No se pudo abrir el archivo de ayuda, puede ser que no tenga un programa lector de archivos (.pdf) instalado en su sistema");
			}
		}
}
