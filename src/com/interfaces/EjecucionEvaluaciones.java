package com.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.persistencia.Evaluacion;
import com.persistencia.Heuristico;
import javax.swing.JRadioButton;

public class EjecucionEvaluaciones extends JFrame {

	private JPanel contentPane;
	public static EjecucionEvaluaciones framePrincipal = new EjecucionEvaluaciones();
	private JTextField txt_navegador;
	private JTable tbl_evaluaciones;
	JLabel  lbl_evaluador;
	ResultSet rs;
	JLabel lbl_criterio1;
	JLabel lbl_criterio2;
	JLabel lbl_criterio3;
	JLabel lbl_criterio4;
	JLabel lbl_criterio5;
	JLabel lbl_criterio6;
	JLabel lbl_criterio7;
	JLabel lbl_criterio8;
	JLabel lbl_criterio9;
	
	final JButton btnIniciar;
	
	String[] calificaciones;
	String[] codigos;
	String[] criterios;
	
	
	int contadorCriterios=0;
	
	JComboBox comboCalificacion1;
	JComboBox comboCalificacion2;
	JComboBox comboCalificacion3;
	JComboBox comboCalificacion4;
	JComboBox comboCalificacion5;
	JComboBox comboCalificacion6;
	JComboBox comboCalificacion7;
	JComboBox comboCalificacion8;
	JComboBox comboCalificacion9;
	
	JPanel contenedor_calificaciones;
	

	int id_calificacion1;	
	int id_calificacion2;
	int id_calificacion3;
	int id_calificacion4;
	int id_calificacion5;
	int id_calificacion6;
	int id_calificacion7;
	int id_calificacion8;
	int id_calificacion9;
	
	
	//int contador=1;
	JButton btnAnterior,btnSiguiente,btnFinalizar;
	int id_evaluacion=-1;
	public Heuristico h1=new Heuristico();
	int  numHeuristico=1;
	 Evaluacion evaluacion;
	 private JTextField txt_version;
	 private JTextField txt_nombre;
	 private JTextField txt_url;
	 


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					framePrincipal.setVisible(true);
					//framePrincipal.setExtendedState(MAXIMIZED_BOTH);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	


	/**
	 * Create the frame.
	 */
	public EjecucionEvaluaciones() {
		setTitle("EXSHE - EJECUCIÓN DE EVALUACIONES");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarPrincipal();
			}
		});
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		//setDefaultCloseOperation(cerrarPrincipal());		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "Ejecutar evaluaciones", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_8.setBounds(357, 8, 981, 714);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(223, 223, 233));
		panel_3.setBounds(12, 68, 449, 27);
		panel_8.add(panel_3);
		
		JLabel lblNavegadorParaLa = new JLabel("Navegador para la evaluación:");
		lblNavegadorParaLa.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNavegadorParaLa.setBounds(12, 5, 170, 15);
		panel_3.add(lblNavegadorParaLa);
		
		txt_navegador = new JTextField();
		txt_navegador.setEditable(false);
		txt_navegador.setColumns(10);
		txt_navegador.setBorder(null);
		txt_navegador.setBackground(new Color(223, 223, 233));
		txt_navegador.setBounds(192, 3, 245, 20);
		panel_3.add(txt_navegador);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(223, 223, 233));
		panel_7.setBounds(482, 29, 473, 27);
		panel_8.add(panel_7);
		
		JLabel lblUrlDelSitio = new JLabel("Url del Sitio:");
		lblUrlDelSitio.setFont(new Font("Dialog", Font.BOLD, 12));
		lblUrlDelSitio.setBounds(10, 5, 67, 15);
		panel_7.add(lblUrlDelSitio);
		
		txt_url = new JTextField();
		txt_url.setEditable(false);
		txt_url.setColumns(10);
		txt_url.setBorder(null);
		txt_url.setBackground(new Color(223, 223, 233));
		txt_url.setBounds(87, 3, 376, 20);
		panel_7.add(txt_url);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(223, 223, 233));
		panel_4.setBounds(482, 68, 473, 27);
		panel_8.add(panel_4);
		
		JLabel lblVersinDelNavegador = new JLabel("Versión:");
		lblVersinDelNavegador.setFont(new Font("Dialog", Font.BOLD, 12));
		lblVersinDelNavegador.setBounds(12, 5, 47, 15);
		panel_4.add(lblVersinDelNavegador);
		
		txt_version = new JTextField();
		txt_version.setEditable(false);
		txt_version.setColumns(10);
		txt_version.setBorder(null);
		txt_version.setBackground(new Color(223, 223, 233));
		txt_version.setBounds(69, 3, 394, 20);
		panel_4.add(txt_version);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(223, 223, 233));
		panel_6.setBounds(12, 30, 449, 27);
		panel_8.add(panel_6);
		
		JLabel lblNombreDelSitio = new JLabel("Nombre del Sitio:");
		lblNombreDelSitio.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombreDelSitio.setBounds(12, 5, 96, 15);
		panel_6.add(lblNombreDelSitio);
		
		txt_nombre = new JTextField();
		txt_nombre.setEditable(false);
		txt_nombre.setColumns(10);
		txt_nombre.setBorder(null);
		txt_nombre.setBackground(new Color(223, 223, 233));
		txt_nombre.setBounds(118, 3, 319, 20);
		panel_6.add(txt_nombre);
		
		contenedor_calificaciones = new JPanel();
		contenedor_calificaciones.setVisible(false);
		contenedor_calificaciones.setBounds(12, 106, 959, 597);
		panel_8.add(contenedor_calificaciones);
		contenedor_calificaciones.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 38, 949, 45);
		contenedor_calificaciones.add(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		
		lbl_criterio1 = new JLabel("Criterio a evaluar");
		lbl_criterio2 = new JLabel("Criterio a evaluar");
		lbl_criterio3 = new JLabel("Criterio a evaluar");
		lbl_criterio4 = new JLabel("Criterio a evaluar");
		lbl_criterio5 = new JLabel("Criterio a evaluar");
		lbl_criterio6 = new JLabel("Criterio a evaluar");
		lbl_criterio7 = new JLabel("Criterio a evaluar");
		lbl_criterio8 = new JLabel("Criterio a evaluar");
		lbl_criterio9 = new JLabel("Criterio a evaluar");
		
		lbl_criterio1.setBounds(10, 0, 939, 18);
		panel.add(lbl_criterio1);
		lbl_criterio1.setForeground(new Color(0, 0, 0));
		lbl_criterio1.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		comboCalificacion1 = new JComboBox();
		comboCalificacion1.setBounds(10, 20, 155, 21);
		panel.add(comboCalificacion1);
		comboCalificacion1.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opción"}));
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setIcon(new ImageIcon(EjecucionEvaluaciones.class.getResource("/img/prev.png")));
		btnAnterior.setBounds(10, 565, 131, 23);
		contenedor_calificaciones.add(btnAnterior);
		btnAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {


						actualizarCalificacion(id_calificacion1,comboCalificacion1);
						actualizarCalificacion(id_calificacion2,comboCalificacion2);
						actualizarCalificacion(id_calificacion3,comboCalificacion3);
						actualizarCalificacion(id_calificacion4,comboCalificacion4);
						actualizarCalificacion(id_calificacion5,comboCalificacion5);
						actualizarCalificacion(id_calificacion6,comboCalificacion6);
						actualizarCalificacion(id_calificacion7,comboCalificacion7);
						actualizarCalificacion(id_calificacion8,comboCalificacion8);
						actualizarCalificacion(id_calificacion9,comboCalificacion9);
						
						rs.previous();	
						mostrarCriterioIndividual(lbl_criterio9, comboCalificacion9);
						
						rs.previous();	
						mostrarCriterioIndividual(lbl_criterio8, comboCalificacion8);
						
						rs.previous();	
						mostrarCriterioIndividual(lbl_criterio7, comboCalificacion7);

						rs.previous();	
						mostrarCriterioIndividual(lbl_criterio6, comboCalificacion6);
						
						rs.previous();	
						mostrarCriterioIndividual(lbl_criterio5, comboCalificacion5);
						
						rs.previous();	
						mostrarCriterioIndividual(lbl_criterio4, comboCalificacion4);
						
						rs.previous();	
						mostrarCriterioIndividual(lbl_criterio3, comboCalificacion3);
						
						rs.previous();	
						mostrarCriterioIndividual(lbl_criterio2, comboCalificacion2);
						
						rs.previous();	
						mostrarCriterioIndividual(lbl_criterio1, comboCalificacion1);
						
						//regresar
				
						
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"Este es el primer criterio que debe evaluar");
				}
				

			}
		});
		btnAnterior.setBorder(UIManager.getBorder("CheckBox.border"));
		btnAnterior.setBackground(SystemColor.controlHighlight);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setIcon(new ImageIcon(EjecucionEvaluaciones.class.getResource("/img/next.png")));
		btnSiguiente.setBounds(163, 565, 136, 23);
		contenedor_calificaciones.add(btnSiguiente);
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			
			}
		});
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(rs.isLast()){
						JOptionPane.showMessageDialog(null,"Este fue el último criterio que debe evaluar");
					}else{
						
						try {
							rs.next();
							id_calificacion1=mostrarCriterioIndividual(lbl_criterio1,comboCalificacion1);
							
						} catch (Exception e2) {
							lbl_criterio1.setText("----------------------");
							comboCalificacion1.removeAllItems();
						}
						
						
						try {
							rs.next();
							id_calificacion2=mostrarCriterioIndividual(lbl_criterio2,comboCalificacion2);
							
						} catch (Exception e2) {
							lbl_criterio2.setText("-------------------");
							comboCalificacion1.removeAllItems();
						}
						
						
						

						
					
						
						
						actualizarCalificacion(id_calificacion1,comboCalificacion1);
						actualizarCalificacion(id_calificacion2,comboCalificacion2);
						actualizarCalificacion(id_calificacion3,comboCalificacion3);
						actualizarCalificacion(id_calificacion4,comboCalificacion4);
						actualizarCalificacion(id_calificacion5,comboCalificacion5);
						actualizarCalificacion(id_calificacion6,comboCalificacion6);
						actualizarCalificacion(id_calificacion7,comboCalificacion7);
						actualizarCalificacion(id_calificacion8,comboCalificacion8);
						actualizarCalificacion(id_calificacion9,comboCalificacion9);
						
						
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"Este fue el último criterio que debe evaluar");
				}
				
				
			}
		});
		btnSiguiente.setBorder(UIManager.getBorder("CheckBox.border"));
		btnSiguiente.setBackground(SystemColor.controlHighlight);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBackground(new Color(223, 223, 233));
		panel_11.setBounds(368, 0, 208, 27);
		contenedor_calificaciones.add(panel_11);
		
		JLabel lblCriterioAEvaluar = new JLabel("CRITERIOS A EVALUAR");
		lblCriterioAEvaluar.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCriterioAEvaluar.setBounds(32, 0, 172, 23);
		panel_11.add(lblCriterioAEvaluar);
		
		btnFinalizar = new JButton("   Finalizar");
		btnFinalizar.setIcon(new ImageIcon(EjecucionEvaluaciones.class.getResource("/img/stop2.png")));
		btnFinalizar.setBounds(525, 565, 136, 23);
		contenedor_calificaciones.add(btnFinalizar);
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizarCalificacion(id_calificacion1,comboCalificacion1);
				actualizarCalificacion(id_calificacion1,comboCalificacion2);
				actualizarCalificacion(id_calificacion1,comboCalificacion3);
				actualizarCalificacion(id_calificacion1,comboCalificacion4);
				actualizarCalificacion(id_calificacion1,comboCalificacion5);
				actualizarCalificacion(id_calificacion1,comboCalificacion6);
				actualizarCalificacion(id_calificacion1,comboCalificacion7);
				actualizarCalificacion(id_calificacion1,comboCalificacion8);
				actualizarCalificacion(id_calificacion1,comboCalificacion9);
				ResultSet pendientes;
				try {
					pendientes = Evaluacion.verificarFinalizacion(id_evaluacion);
					
					if(pendientes.next()){
						int i=1;
						String criteriosPendientes="";
						pendientes.beforeFirst();
						while(pendientes.next()){
							
			
							criteriosPendientes+=pendientes.getString(9)+": "+pendientes.getString(5)+" <br> ";
						
							i++;
						}
						

						//JOptionPane.showMessageDialog(null,"No se puede finalizar aún tiene "+i+" criterios pendientes de calificar: "+criteriosPendientes);
						
						MensajePendientes msjPendiente=new MensajePendientes();
						msjPendiente.mensajeError.setText("<html><div><h3 style='color:red'>No se puede finalizar la evaluación debido a que aún tiene "+(i+-1)+" criterios pendientes de calificar: <br></h3>"+criteriosPendientes+"</div></html>");
						msjPendiente.show();
						
					}else{
						
						
						
					
						
						if(Evaluacion.cambiarEstado(id_evaluacion)>0){
							btnAnterior.setVisible(false);
							btnSiguiente.setVisible(false);
							btnFinalizar.setVisible(false);
							btnIniciar.setEnabled(true);
							limpiar();				
							//panel_heuristicos.setVisible(false);
							//panel_descripcion.setVisible(false);
							tbl_evaluaciones.setEnabled(true);
							contenedor_calificaciones.setVisible(false);
							JOptionPane.showMessageDialog(null,"Evaluación finalizada exitosamente");
							cargarTabla();
						}else{
							JOptionPane.showMessageDialog(null,"Error al finalizar. Por favor revise que todos los criterios esten calificados");
						}
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

					
				
			}
		});
		btnFinalizar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnFinalizar.setBackground(SystemColor.controlHighlight);
		
		JButton btnGuardarSesin = new JButton("  Guardar Sesión");
		btnGuardarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarCalificacion(id_calificacion1,comboCalificacion1);
				actualizarCalificacion(id_calificacion2,comboCalificacion2);
				actualizarCalificacion(id_calificacion3,comboCalificacion3);
				actualizarCalificacion(id_calificacion4,comboCalificacion4);
				actualizarCalificacion(id_calificacion5,comboCalificacion5);
				actualizarCalificacion(id_calificacion6,comboCalificacion6);
				actualizarCalificacion(id_calificacion7,comboCalificacion7);
				actualizarCalificacion(id_calificacion8,comboCalificacion8);
				actualizarCalificacion(id_calificacion9,comboCalificacion9);
				ResultSet pendientes;
				
				try {
					pendientes = Evaluacion.verificarFinalizacion(id_evaluacion);
					
					if(pendientes.next()){
						int i=0;
						String criteriosPendientes="";
						pendientes.beforeFirst();
						while(pendientes.next()){
							criteriosPendientes=criteriosPendientes+pendientes.getString(5)+"-";
							i++;
						}
						contenedor_calificaciones.setVisible(false);
						if(Evaluacion.cambiarEstadoAPendiete(id_evaluacion)>0){
							JOptionPane.showMessageDialog(null,"Sesión guardada exitosamente, recuerde que tiene criterios pendientes de calificar");
							cargarTabla();
							tbl_evaluaciones.setEnabled(true);
							limpiar();
							btnIniciar.setEnabled(true);
						}else{
							JOptionPane.showMessageDialog(null,"Error al guardar la sesión");
						}
							
						
						
						
					}else{
						
						JOptionPane.showMessageDialog(null,"Todos los criterios ya han sido calificados, se recomienda que de clic en finalizar para visualizar el informe correspondiente a esta evaluación");

						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGuardarSesin.setIcon(new ImageIcon(EjecucionEvaluaciones.class.getResource("/img/puas3.png")));
		btnGuardarSesin.setBorder(UIManager.getBorder("CheckBox.border"));
		btnGuardarSesin.setBackground(SystemColor.controlHighlight);
		btnGuardarSesin.setBounds(326, 565, 174, 23);
		contenedor_calificaciones.add(btnGuardarSesin);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(Color.LIGHT_GRAY);
		panel_10.setBounds(0, 94, 949, 50);
		contenedor_calificaciones.add(panel_10);
		
	
		lbl_criterio2.setForeground(Color.BLACK);
		lbl_criterio2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbl_criterio2.setBounds(10, 0, 929, 18);
		panel_10.add(lbl_criterio2);
		
		
		comboCalificacion2 = new JComboBox();
		comboCalificacion2.setBounds(10, 18, 155, 21);
		panel_10.add(comboCalificacion2);
		comboCalificacion2.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opción"}));
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBackground(Color.LIGHT_GRAY);
		panel_13.setBounds(0, 151, 949, 50);
		contenedor_calificaciones.add(panel_13);
		
		
		lbl_criterio3.setForeground(Color.BLACK);
		lbl_criterio3.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbl_criterio3.setBounds(10, 0, 939, 18);
		panel_13.add(lbl_criterio3);
		
		
		comboCalificacion3 = new JComboBox();
		comboCalificacion3.setBounds(10, 18, 155, 21);
		panel_13.add(comboCalificacion3);
		comboCalificacion3.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opción"}));
		
		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBackground(Color.LIGHT_GRAY);
		panel_15.setBounds(0, 207, 949, 50);
		contenedor_calificaciones.add(panel_15);
		
		
		
		lbl_criterio4.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbl_criterio4.setBounds(10, 0, 939, 18);
		panel_15.add(lbl_criterio4);
		
		
		comboCalificacion4 = new JComboBox();
		comboCalificacion4.setBounds(10, 18, 155, 21);
		panel_15.add(comboCalificacion4);
		comboCalificacion4.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opción"}));
		
		JPanel panel_17 = new JPanel();
		panel_17.setLayout(null);
		panel_17.setBackground(Color.LIGHT_GRAY);
		panel_17.setBounds(0, 264, 949, 50);
		contenedor_calificaciones.add(panel_17);
		
		
		lbl_criterio5.setForeground(Color.BLACK);
		lbl_criterio5.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbl_criterio5.setBounds(10, 0, 939, 18);
		panel_17.add(lbl_criterio5);
		
		
		comboCalificacion5 = new JComboBox();
		comboCalificacion5.setBounds(10, 18, 155, 21);
		panel_17.add(comboCalificacion5);
		comboCalificacion5.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opción"}));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 320, 949, 50);
		contenedor_calificaciones.add(panel_1);
		
		
		lbl_criterio6.setForeground(Color.BLACK);
		lbl_criterio6.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbl_criterio6.setBounds(10, 0, 939, 18);
		panel_1.add(lbl_criterio6);
		
		comboCalificacion6 = new JComboBox();
		comboCalificacion6.setBounds(10, 18, 155, 21);
		panel_1.add(comboCalificacion6);
		comboCalificacion6.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opción"}));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 375, 949, 50);
		contenedor_calificaciones.add(panel_2);
		
		
		lbl_criterio7.setForeground(Color.BLACK);
		lbl_criterio7.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbl_criterio7.setBounds(10, 0, 939, 18);
		panel_2.add(lbl_criterio7);
		
		comboCalificacion7 = new JComboBox();
		comboCalificacion7.setBounds(10, 18, 155, 21);
		panel_2.add(comboCalificacion7);
		comboCalificacion7.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opción"}));
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(0, 431, 949, 50);
		contenedor_calificaciones.add(panel_5);
		
		
		lbl_criterio8.setForeground(Color.BLACK);
		lbl_criterio8.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbl_criterio8.setBounds(10, 0, 939, 18);
		panel_5.add(lbl_criterio8);
		
		comboCalificacion8 = new JComboBox();
		comboCalificacion8.setBounds(10, 18, 155, 21);
		panel_5.add(comboCalificacion8);
		comboCalificacion8.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opción"}));
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBackground(Color.LIGHT_GRAY);
		panel_12.setBounds(0, 488, 949, 50);
		contenedor_calificaciones.add(panel_12);
		
		
		lbl_criterio9.setForeground(Color.BLACK);
		lbl_criterio9.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbl_criterio9.setBounds(10, 0, 939, 18);
		panel_12.add(lbl_criterio9);
		
		comboCalificacion9 = new JComboBox();
		comboCalificacion9.setBounds(10, 18, 155, 21);
		panel_12.add(comboCalificacion9);
		comboCalificacion9.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opción"}));
		btnFinalizar.setVisible(false);
		btnSiguiente.setVisible(false);
		
		btnAnterior.setVisible(false);
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new TitledBorder(null, "Evaluaciones", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_9.setBounds(12, 49, 335, 673);
		contentPane.add(panel_9);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		scrollPane.setBounds(12, 57, 310, 605);
		panel_9.add(scrollPane);
		
		tbl_evaluaciones = new JTable();
		
		tbl_evaluaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				int indice=tbl_evaluaciones.getSelectedRow();
				
				txt_nombre.setText(tbl_evaluaciones.getValueAt(indice,2).toString());
				txt_url.setText(tbl_evaluaciones.getValueAt(indice,3).toString());
				txt_navegador.setText(tbl_evaluaciones.getValueAt(indice,4).toString());
				txt_version.setText(tbl_evaluaciones.getValueAt(indice,5).toString());
				id_evaluacion=Integer.parseInt(tbl_evaluaciones.getValueAt(indice,0).toString());
				
				try {
					verCriterios(id_evaluacion);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				

			}
		});
		tbl_evaluaciones.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID_DETALLE","ID_PROYECTO", "NOMBRE DEL SITIO","URL", "EVALUADOR","FECHA", "TIPO DEL SITIO"
				}
			));
		scrollPane.setViewportView(tbl_evaluaciones);
		
		btnIniciar = new JButton("  Calificar");
		btnIniciar.setBounds(185, 19, 137, 27);
		panel_9.add(btnIniciar);
		
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre=txt_nombre.getText();
				String url=txt_url.getText();
				
				String navegador=txt_navegador.getText();
				String version=txt_version.getText();
				
				String email=lbl_evaluador.getText();
				
				if(nombre.equals("") || url.equals("")){
					JOptionPane.showMessageDialog(null,"Por favor seleccione una evaluación de la tabla");
				}else{
					if(version.equals("")||navegador.equals("")){
						JOptionPane.showMessageDialog(null, "Por favor seleccione una evaluación de la tabla");	
						
						if(version.equals("")){
							txt_version.requestFocus();
						}
						
						if(navegador.equals("")){
							txt_navegador.requestFocus();
						}
						
						
					}else{
						
							contenedor_calificaciones.setVisible(true);
							
							btnIniciar.setEnabled(false);
							btnAnterior.setVisible(true);
							btnSiguiente.setVisible(true);
							btnFinalizar.setVisible(true);							
							tbl_evaluaciones.setEnabled(false);
							
							
							
							try {
								
								
								rs.first();
								id_calificacion1=mostrarCriterioIndividual(lbl_criterio1,comboCalificacion1);
								
								rs.next();
								id_calificacion2=mostrarCriterioIndividual(lbl_criterio2,comboCalificacion2);
								
								rs.next();
								id_calificacion3=mostrarCriterioIndividual(lbl_criterio3,comboCalificacion3);
								
								
								rs.next();
								id_calificacion4=mostrarCriterioIndividual(lbl_criterio4,comboCalificacion4);
								
								
								rs.next();
								id_calificacion5=mostrarCriterioIndividual(lbl_criterio5,comboCalificacion5);
								
								
								rs.next();
								id_calificacion6=mostrarCriterioIndividual(lbl_criterio6,comboCalificacion6);
								
								
								rs.next();
								id_calificacion7=mostrarCriterioIndividual(lbl_criterio7,comboCalificacion7);
								
								rs.next();
								id_calificacion8=mostrarCriterioIndividual(lbl_criterio8,comboCalificacion8);
								
								rs.next();
								id_calificacion9=mostrarCriterioIndividual(lbl_criterio9,comboCalificacion9);
							
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							//panel_heuristicos.setVisible(true);
							//panel_descripcion.setVisible(true);
							JOptionPane.showMessageDialog(null, "Test Iniciado");
							
					}
					
				}
				
			}
		});
		btnIniciar.setIcon(new ImageIcon(EjecucionEvaluaciones.class.getResource("/img/start2.png")));
		btnIniciar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnIniciar.setBackground(SystemColor.controlHighlight);
		
		lbl_evaluador = new JLabel("Evaluador conectado para evaluar");
		lbl_evaluador.setFont(new Font("Dialog", Font.ITALIC, 12));
		lbl_evaluador.setBounds(181, 8, 245, 30);
		contentPane.add(lbl_evaluador);
		
		JLabel label_3 = new JLabel("Evaluador conectado:");
		label_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label_3.setBounds(30, 12, 151, 22);
		contentPane.add(label_3);
		
		
		cargarTabla();
		
		
	
	}
	
	
	public void cerrarPrincipal(){
		Object [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Está seguro que desea cerrar la ventana de ejecución de evaluaciones?","Mensaje de Confirmación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
		if (eleccion == JOptionPane.YES_OPTION)
		{
			dispose();
		}else{
			
		}
		
		
		
		/****************CONSTRUCTOR****************////////
		

		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	public void cargarTabla() {
		
		//JOptionPane.showMessageDialog(null,Acceso.conectado());
		//String email=Acceso.conectado();
		String email="perez@gmail.com";
		ResultSet rsTabla=null;
		try {
			rsTabla = Evaluacion.consultarEvaluacionesEvaluador(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DefaultTableModel modelo=new DefaultTableModel();	
		modelo.addColumn("ID_EVALUACION");
		modelo.addColumn("ID_PROYECTO");
		modelo.addColumn("SITIO");
		modelo.addColumn("URL");
		modelo.addColumn("NAVEGADOR");
		modelo.addColumn("VERSIÓN");
		modelo.addColumn("ESTADO");		
		try {
			while(rsTabla.next()){		

				if(rsTabla.getBoolean(12)){
					modelo.addRow(new String[] {rsTabla.getString(1),rsTabla.getString(3),rsTabla.getString(4),rsTabla.getString(5),rsTabla.getString(10),rsTabla.getString(11),"Finalizada"});			
				}else{
					modelo.addRow(new String[] {rsTabla.getString(1),rsTabla.getString(3),rsTabla.getString(4),rsTabla.getString(5),rsTabla.getString(10),rsTabla.getString(11),"Pendiente"});
				}
			

				
					tbl_evaluaciones.setModel(modelo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formatearTabla();
		

	}
	
	public void formatearTabla(){
		/*
		modelo.addColumn("ID_EVALUACION"); 0 
		modelo.addColumn("ID_PROYECTO"); 1
		modelo.addColumn("NOMBRE DEL SITIO"); 2
		modelo.addColumn("URL"); 3
		modelo.addColumn("NAVEGADOR"); 4
		modelo.addColumn("VERSIÓN"); 5
		modelo.addColumn("FECHA");	6
		*/
		
		//tbl_subheuristicos.getColumnModel().getColumn(0).setPreferredWidth(1);
		//tbl_subheuristicos.setBackground(new Color(161,202,232));
		tbl_evaluaciones.setRowHeight(15);
		tbl_evaluaciones.setForeground(new Color(0,0,0));
		tbl_evaluaciones.setFont(new Font("Dialog", Font.PLAIN, 11));
		tbl_evaluaciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//tbl_subheuristicos.getTableHeader().setBackground(new Color(9,125,209));
		//tbl_subheuristicos.getTableHeader().setForeground(new Color(255,255,255));
		tbl_evaluaciones.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 12));
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(0).setResizable(false);
		
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(1).setResizable(false);
		
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(100);
		
		//url sitio
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(3).setResizable(false);
		
		//tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(200);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(125);
		
		
		//Version
				tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
				tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
				tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(0);
				tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(5).setResizable(false);
		
		//tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(200);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(80);
		
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		

		tbl_evaluaciones.getColumnModel().getColumn(2).setCellRenderer(tcr);
				
		tbl_evaluaciones.getColumnModel().getColumn(4).setCellRenderer(tcr);
		tbl_evaluaciones.getColumnModel().getColumn(6).setCellRenderer(tcr);
	}
	
	
	public void limpiar(){
		txt_navegador.setText("");
		txt_version.setText("");
		txt_nombre.setText("");
		txt_url.setText("");
		txt_navegador.requestFocus();
		id_evaluacion=-1;
	}
	
	
	public void cerrarEjecucion(){
		Object [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Está seguro que desea cerrar la Ventana de Mantenimiento de Evaluadores?","Mensaje de Confirmación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
		if (eleccion == JOptionPane.YES_OPTION)
		{
			dispose();
		}else{
			
		}
	}
	
	
	//Para calificar criterios de uno en uno
	
	/*
	 * 
	 * Se envia el id de la evaluacion y se obtiene un listado de todos los heuristicos
	 */
	public void verCriterios(int id) throws SQLException{
		//rs=Evaluacion.consultarCalificaciones(id);
	}
	
	
	public void cargarComboNumeros(JComboBox combo){
		combo.removeAllItems();
		combo.addItem("Seleccione una opción");
		combo.addItem("1");
		combo.addItem("2");
		combo.addItem("3");
		combo.addItem("4");
		combo.addItem("5");
		combo.addItem("6");
		combo.addItem("7");
		combo.addItem("8");
		combo.addItem("9");
		combo.addItem("10");		
		combo.addItem("NA");
	}
	
	public void cargarComboTexto(JComboBox combo){
		combo.removeAllItems();
		combo.addItem("Seleccione una opción");
		combo.addItem("NTS");
		combo.addItem("NEP");
		combo.addItem("NPP");
		combo.addItem("NPI");
		combo.addItem("S");
		combo.addItem("NA");


	}
	
	
		
	
	
	
	
	public void actualizarCalificacion(int id_cal,JComboBox combo){
		double puntos;	
		if(combo.getSelectedIndex()==0){
			puntos=-1;
		}else{
			
			String valorSeleccionado=combo.getSelectedItem().toString();
			
			if(valorSeleccionado.equals("NTS")){
				puntos=0;
			}else{
				if(valorSeleccionado.equals("NEP")){
					puntos=2.5;
				}else{
					if(valorSeleccionado.equals("NPP")){
						puntos=5;
					}else{
						if(valorSeleccionado.equals("NPI")){
							puntos=7.5;
						}else{
							if(valorSeleccionado.equals("S")){
								puntos=10;
							}else{
								if(valorSeleccionado.equals("NA")){
									puntos=-2;
								}else{
									puntos=Integer.parseInt(valorSeleccionado);
								}
								
							}
							
							
						}
						
					}
					
				}
				
			}
			
		}

		if(Evaluacion.calificar(id_cal, puntos)>0){
			
		}else{
			JOptionPane.showMessageDialog(null,"Error al calificar");
		}
	}
	
	
	
	
	
	
	
	
	public int mostrarCriterioIndividual(JLabel lbl,JComboBox combo) throws HeadlessException, SQLException{
		int id_cali=-10;
		float puntos;
		/*Primera opcion*/
		
		if(rs.isLast()){
			JOptionPane.showMessageDialog(null,"No hay más criterios que mostrar");
			
			lbl.setText("----------------");
			combo.removeAllItems();
		}else{
	
		id_cali=rs.getInt(1);
		puntos=Evaluacion.consultarCalificacion(id_cali);

		lbl.setText("<html><div>"+rs.getString(9)+": "+rs.getString(5)+"</html></div>");
	
	
		if(rs.getString(6).equals("Numérico")){
			
			cargarComboNumeros(combo);	
			if(puntos==-1){
				comboCalificacion1.setSelectedIndex(0);
				
			}else{
				if(puntos==0){
					combo.setSelectedIndex(11);
				}else{
					combo.setSelectedIndex((int) puntos);
				}
			}
			
		}else{
		cargarComboTexto(combo);

		if(puntos==-1){
			combo.setSelectedIndex(0);
		}
		
		if(puntos==0){
				combo.setSelectedIndex(1);					
		}
		
		if(puntos>0 && puntos<5){
			combo.setSelectedIndex(2);					
		}
		if(puntos==5){
			comboCalificacion1.setSelectedIndex(3);					
		}
		if(puntos>5 && puntos<10){
			comboCalificacion1.setSelectedIndex(4);					
		}
		if(puntos==10){
			comboCalificacion1.setSelectedIndex(5);					
		}	
		if(puntos==-2){
			comboCalificacion1.setSelectedIndex(6);					
		}
	}
}
		return id_cali;
		
	}
	
	
	
}
