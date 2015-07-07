package com.interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class EjecucionEvaluaciones extends JFrame {

	private JPanel contentPane;
	public static EjecucionEvaluaciones framePrincipal = new EjecucionEvaluaciones();
	private JTextField txt_navegador;
	private JTable tbl_evaluaciones;
	JLabel  lbl_evaluador;
	ResultSet rs;
	JLabel lbl_criterio;
	final JButton btnGuardar;
	JComboBox comboCalificacion;
	JPanel contenedor_calificaciones;
	
	int id_calificacion;
	
	//int contador=1;
	JButton btnAnterior,btnSiguiente,btnFinalizar;
	int id_evaluacion=-1;
	public Heuristico h1=new Heuristico();
	int  numHeuristico=1;
	JLabel lbl_heuristico;
	JLabel lbl_descripcion;
	 Evaluacion evaluacion;
	 private JTextField txt_version;
	 private JTextField txt_nombre;
	 private JTextField txt_url;
	 JPanel panel_heuristicos;
	 JPanel panel_descripcion;
	 


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
		setTitle("EXSHE - EVALUACIONES");
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(223, 223, 233));
		panel_2.setBounds(481, 8, 402, 84);
		contentPane.add(panel_2);
		
		JLabel lblLog = new JLabel("LOG");
		lblLog.setIcon(new ImageIcon(EjecucionEvaluaciones.class.getResource("/img/ejecucion.png")));
		lblLog.setBounds(22, 12, 62, 66);
		panel_2.add(lblLog);
		
		JLabel label_2 = new JLabel("Expert System of Heuristic Evaluation");
		label_2.setFont(new Font("Dialog", Font.BOLD, 13));
		label_2.setBounds(112, 12, 278, 33);
		panel_2.add(label_2);
		
		JLabel lblBienvenido = new JLabel("EVALUACIONES");
		lblBienvenido.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblBienvenido.setBounds(112, 37, 278, 35);
		panel_2.add(lblBienvenido);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "Ejecutar evaluaciones", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_8.setBounds(389, 104, 961, 618);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(223, 223, 233));
		panel_3.setBounds(12, 68, 449, 27);
		panel_8.add(panel_3);
		
		JLabel lblNavegadorParaLa = new JLabel("Navegador para la evaluación:");
		lblNavegadorParaLa.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNavegadorParaLa.setBounds(12, 5, 242, 15);
		panel_3.add(lblNavegadorParaLa);
		
		txt_navegador = new JTextField();
		txt_navegador.setEditable(false);
		txt_navegador.setColumns(10);
		txt_navegador.setBorder(null);
		txt_navegador.setBackground(new Color(223, 223, 233));
		txt_navegador.setBounds(249, 3, 188, 20);
		panel_3.add(txt_navegador);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(223, 223, 233));
		panel_7.setBounds(482, 29, 467, 27);
		panel_8.add(panel_7);
		
		JLabel lblUrlDelSitio = new JLabel("Url del Sitio:");
		lblUrlDelSitio.setFont(new Font("Dialog", Font.BOLD, 13));
		lblUrlDelSitio.setBounds(32, 5, 103, 15);
		panel_7.add(lblUrlDelSitio);
		
		txt_url = new JTextField();
		txt_url.setEditable(false);
		txt_url.setColumns(10);
		txt_url.setBorder(null);
		txt_url.setBackground(new Color(223, 223, 233));
		txt_url.setBounds(131, 3, 324, 20);
		panel_7.add(txt_url);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(223, 223, 233));
		panel_4.setBounds(482, 68, 467, 27);
		panel_8.add(panel_4);
		
		JLabel lblVersinDelNavegador = new JLabel("Versión:");
		lblVersinDelNavegador.setFont(new Font("Dialog", Font.BOLD, 13));
		lblVersinDelNavegador.setBounds(12, 5, 69, 15);
		panel_4.add(lblVersinDelNavegador);
		
		txt_version = new JTextField();
		txt_version.setEditable(false);
		txt_version.setColumns(10);
		txt_version.setBorder(null);
		txt_version.setBackground(new Color(223, 223, 233));
		txt_version.setBounds(72, 3, 383, 20);
		panel_4.add(txt_version);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(223, 223, 233));
		panel_6.setBounds(12, 29, 449, 27);
		panel_8.add(panel_6);
		
		JLabel lblNombreDelSitio = new JLabel("Nombre del Sitio:");
		lblNombreDelSitio.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNombreDelSitio.setBounds(12, 5, 129, 15);
		panel_6.add(lblNombreDelSitio);
		
		txt_nombre = new JTextField();
		txt_nombre.setEditable(false);
		txt_nombre.setColumns(10);
		txt_nombre.setBorder(null);
		txt_nombre.setBackground(new Color(223, 223, 233));
		txt_nombre.setBounds(151, 3, 286, 20);
		panel_6.add(txt_nombre);
		
		contenedor_calificaciones = new JPanel();
		contenedor_calificaciones.setVisible(false);
		contenedor_calificaciones.setBounds(12, 119, 937, 452);
		panel_8.add(contenedor_calificaciones);
		contenedor_calificaciones.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 261, 937, 42);
		contenedor_calificaciones.add(panel);
		panel.setLayout(null);
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		
		lbl_criterio = new JLabel("Criterio a evaluar");
		lbl_criterio.setForeground(new Color(0, 0, 0));
		lbl_criterio.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		lbl_criterio.setBounds(12, 6, 913, 27);
		panel.add(lbl_criterio);
		
		panel_descripcion = new JPanel();
		panel_descripcion.setBounds(0, 161, 937, 42);
		contenedor_calificaciones.add(panel_descripcion);
		panel_descripcion.setLayout(null);
		panel_descripcion.setBackground(new Color(223, 223, 233));
		
		lbl_descripcion = new JLabel("Descripcion del heuristico");
		lbl_descripcion.setFont(new Font("Dialog", Font.PLAIN, 14));
		lbl_descripcion.setBounds(12, 0, 913, 42);
		panel_descripcion.add(lbl_descripcion);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 115, 299, 34);
		contenedor_calificaciones.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(223, 223, 233));
		
		JLabel lblDescripcinDelHeurstico = new JLabel("DESCRIPCIÓN DEL HEURÍSTICO");
		lblDescripcinDelHeurstico.setBounds(12, 0, 275, 34);
		panel_5.add(lblDescripcinDelHeurstico);
		lblDescripcinDelHeurstico.setFont(new Font("Dialog", Font.BOLD, 16));
		
		panel_heuristicos = new JPanel();
		panel_heuristicos.setBounds(0, 58, 937, 45);
		contenedor_calificaciones.add(panel_heuristicos);
		panel_heuristicos.setLayout(null);
		panel_heuristicos.setBackground(new Color(223, 223, 233));
		
		lbl_heuristico = new JLabel("Heurístico a evaluar");
		lbl_heuristico.setFont(new Font("Dialog", Font.PLAIN, 14));
		lbl_heuristico.setBounds(12, 0, 900, 40);
		panel_heuristicos.add(lbl_heuristico);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 12, 253, 34);
		contenedor_calificaciones.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(223, 223, 233));
		
		JLabel lblNombreDelHeurstico = new JLabel("NOMBRE DEL HEURÍSTICO");
		lblNombreDelHeurstico.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNombreDelHeurstico.setBounds(12, 0, 234, 34);
		panel_1.add(lblNombreDelHeurstico);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(0, 413, 113, 27);
		contenedor_calificaciones.add(btnAnterior);
		btnAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
						if(rs.isFirst()){
							JOptionPane.showMessageDialog(null,"Este es el primer criterio que debe evaluar");
						}else{
						
						rs.previous();	
						actualizarCalificacion();
						mostrarDatos();
						
						
						
						}
						
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

			}
		});
		btnAnterior.setBorder(UIManager.getBorder("CheckBox.border"));
		btnAnterior.setBackground(SystemColor.controlHighlight);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(125, 413, 113, 27);
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
						rs.next();
						actualizarCalificacion();
						mostrarDatos();
						
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnSiguiente.setBorder(UIManager.getBorder("CheckBox.border"));
		btnSiguiente.setBackground(SystemColor.controlHighlight);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBackground(new Color(223, 223, 233));
		panel_11.setBounds(0, 215, 208, 34);
		contenedor_calificaciones.add(panel_11);
		
		JLabel lblCriterioAEvaluar = new JLabel("CRITERIO A EVALUAR");
		lblCriterioAEvaluar.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCriterioAEvaluar.setBounds(12, 0, 192, 34);
		panel_11.add(lblCriterioAEvaluar);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(223, 223, 233));
		panel_10.setBounds(0, 315, 143, 34);
		contenedor_calificaciones.add(panel_10);
		
		JLabel lblCalificaci = new JLabel("CALIFICACIÓN");
		lblCalificaci.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCalificaci.setBounds(12, 0, 130, 34);
		panel_10.add(lblCalificaci);
		
		comboCalificacion = new JComboBox();
		comboCalificacion.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opción"}));
		comboCalificacion.setBounds(0, 361, 238, 24);
		contenedor_calificaciones.add(comboCalificacion);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(250, 413, 113, 27);
		contenedor_calificaciones.add(btnFinalizar);
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAnterior.setVisible(false);
				btnSiguiente.setVisible(false);
				btnFinalizar.setVisible(false);
				btnGuardar.setEnabled(true);
				limpiar();				
				panel_heuristicos.setVisible(false);
				panel_descripcion.setVisible(false);
				tbl_evaluaciones.setEnabled(true);
				contenedor_calificaciones.setVisible(false);
				
				JOptionPane.showMessageDialog(null,"Evaluación finalizada");
			}
		});
		btnFinalizar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnFinalizar.setBackground(SystemColor.controlHighlight);
		btnFinalizar.setVisible(false);
		btnSiguiente.setVisible(false);
		
		btnAnterior.setVisible(false);
		
		
		
		
		panel_heuristicos.setVisible(false);
		panel_descripcion.setVisible(false);
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new TitledBorder(null, "Evaluaciones", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_9.setBounds(0, 104, 387, 618);
		contentPane.add(panel_9);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		scrollPane.setBounds(12, 57, 363, 519);
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
		
		btnGuardar = new JButton("  Calificar");
		btnGuardar.setBounds(245, 18, 130, 27);
		panel_9.add(btnGuardar);
		
		btnGuardar.addActionListener(new ActionListener() {
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
							
							btnGuardar.setEnabled(false);
							btnAnterior.setVisible(true);
							btnSiguiente.setVisible(true);
							btnFinalizar.setVisible(true);							
							tbl_evaluaciones.setEnabled(false);
							
							
							
							try {
								rs.first();
								mostrarDatos();
							
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							panel_heuristicos.setVisible(true);
							panel_descripcion.setVisible(true);
							JOptionPane.showMessageDialog(null, "Test Iniciado");
							
					}
					
				}
				
			}
		});
		btnGuardar.setIcon(new ImageIcon(EjecucionEvaluaciones.class.getResource("/img/start2.png")));
		btnGuardar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnGuardar.setBackground(SystemColor.controlHighlight);
		
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
		int eleccion = JOptionPane.showOptionDialog(rootPane,"Esta seguro que desea cerrar la Ventana de Evaluaciones","Mensaje de Confirmación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
		if (eleccion == JOptionPane.YES_OPTION)
		{
			dispose();
		}else{
			
		}
	}
	
	
	
	
	
	
	
	public void cargarTabla() {
		
		//JOptionPane.showMessageDialog(null,Acceso.conectado());
		//String email=Acceso.conectado();
		String email="perez@gmail.com";
		ResultSet rs=null;
		try {
			rs = Evaluacion.consultarEvaluacionesEvaluador(email);
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
			while(rs.next()){		

				if(rs.getBoolean(12)){
					modelo.addRow(new String[] {rs.getString(1),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(10),rs.getString(11),"Finalizada"});			
				}else{
					modelo.addRow(new String[] {rs.getString(1),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(10),rs.getString(11),"Pendiente"});
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
		tbl_evaluaciones.setRowHeight(20);
		tbl_evaluaciones.setForeground(new Color(0,0,0));
		tbl_evaluaciones.setFont(new Font("Dialog", Font.PLAIN, 13));
		tbl_evaluaciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//tbl_subheuristicos.getTableHeader().setBackground(new Color(9,125,209));
		//tbl_subheuristicos.getTableHeader().setForeground(new Color(255,255,255));
		tbl_evaluaciones.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 15));
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(0).setResizable(false);
		
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(1).setResizable(false);
		
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(150);
		
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
		
		
		

		tbl_evaluaciones.getColumnModel().getColumn(0).setCellRenderer(tcr);
				
		tbl_evaluaciones.getColumnModel().getColumn(2).setCellRenderer(tcr);
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
	
	
	public void verCriterios(int id) throws SQLException{
		rs=Evaluacion.consultarCalificaciones(id);
		
	}
	
	
	public void cargarComboNumeros(){
		comboCalificacion.removeAllItems();
		comboCalificacion.addItem("Seleccione una opción");
		comboCalificacion.addItem("1");
		comboCalificacion.addItem("2");
		comboCalificacion.addItem("3");
		comboCalificacion.addItem("4");
		comboCalificacion.addItem("5");
		comboCalificacion.addItem("6");
		comboCalificacion.addItem("7");
		comboCalificacion.addItem("8");
		comboCalificacion.addItem("9");
		comboCalificacion.addItem("10");		
		comboCalificacion.addItem("NA");
	}
	
	public void cargarComboTexto(){
		comboCalificacion.removeAllItems();
		comboCalificacion.addItem("Seleccione una opción");
		comboCalificacion.addItem("NTS");
		comboCalificacion.addItem("NEP");
		comboCalificacion.addItem("NPP");
		comboCalificacion.addItem("NPI");
		comboCalificacion.addItem("S");
		comboCalificacion.addItem("NA");


	}
	
	public void mostrarDatos(){
		double puntos=-1;
		try {
			
			try {
				id_calificacion=rs.getInt(1);
				//JOptionPane.showMessageDialog(null,id_calificacion);
				puntos=Evaluacion.consultarCalificacion(id_calificacion);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			lbl_heuristico.setText("<html><div>"+rs.getString(8)+"</html></div>");		
			lbl_descripcion.setText("<html><div>"+rs.getString(7)+"</html></div>");
			lbl_criterio.setText("<html><div>"+rs.getString(5)+"</html></div>");
			
			
			if(rs.getString(6).equals("numero")){
				
				cargarComboNumeros();	
				
				if(puntos==-1){
					comboCalificacion.setSelectedIndex(0);
				}else{
					if(puntos==0){
						comboCalificacion.setSelectedIndex(11);
					}else{
						comboCalificacion.setSelectedIndex((int) puntos);
					}
				}
				
			}else{
				cargarComboTexto();
				if(puntos==-1){
					comboCalificacion.setSelectedIndex(0);
				}else{

					if(puntos==0){
						comboCalificacion.setSelectedIndex(1);					
					}else{
						if(puntos==2.5){
							comboCalificacion.setSelectedIndex(2);					
						}else{
							if(puntos==5){
								comboCalificacion.setSelectedIndex(3);					
							}else{
								if(puntos==7.5){
									comboCalificacion.setSelectedIndex(4);					
								}else{
									if(puntos==10){
										comboCalificacion.setSelectedIndex(5);					
									}else{
										comboCalificacion.setSelectedIndex(6);
									}
								}
								
							}
						}
						
					}
				}

			
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void actualizarCalificacion(){
		double puntos;	
		if(comboCalificacion.getSelectedIndex()==0){
			puntos=-1;
		}else{
			
			String valorSeleccionado=comboCalificacion.getSelectedItem().toString();
			
			if(valorSeleccionado.equals("NTS")){
				puntos=2.5;
			}else{
				if(valorSeleccionado.equals("NEP")){
					puntos=3.5;
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
									puntos=0;
								}else{
									puntos=Integer.parseInt(valorSeleccionado);
								}
								
							}
							
							
						}
						
					}
					
				}
				
			}
			
		}

		if(Evaluacion.calificar(id_calificacion, puntos)>0){
			
		}else{
			JOptionPane.showMessageDialog(null,"Error al calificar");
		}
	}
}
