package com.interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Ejecucion extends JFrame {

	private JPanel contentPane;
	JPanel contenedor_criterios = new JPanel();
	JLabel numeroVista = new JLabel(" ");
	
	
	
	private JTextField txt_nombre;
	private JTextField txt_navegador;
	private JTextField txt_url;
	private JTextField txt_version;
	private JTable tbl_evaluaciones;
	
	JPanel contenedorCriterio1 = new JPanel();
	JPanel contenedorCriterio2 = new JPanel();
	JPanel contenedorCriterio3 = new JPanel();
	JPanel contenedorCriterio4 = new JPanel();
	JPanel contenedorCriterio5 = new JPanel();
	JPanel contenedorCriterio6 = new JPanel();
	JPanel contenedorCriterio7 = new JPanel();
	JPanel contenedorCriterio8 = new JPanel();
	JPanel contenedorCriterio9 = new JPanel();
	
	
	//si es -3 no hay dato de calificacion
	int id_calificacion1=-3;
	int id_calificacion2=-3;
	int id_calificacion3=-3;
	int id_calificacion4=-3;
	int id_calificacion5=-3;
	int id_calificacion6=-3;
	int id_calificacion7=-3;
	int id_calificacion8=-3;
	int id_calificacion9=-3;
	int i=0;
	
	JButton btn_iniciar = new JButton("  Calificar");
	
	
	JLabel criterio1 = new JLabel("Criterio a evaluar");
	JLabel criterio2 = new JLabel("Criterio a evaluar");
	JLabel criterio3 = new JLabel("Criterio a evaluar");
	JLabel criterio4 = new JLabel("Criterio a evaluar");
	JLabel criterio5 = new JLabel("Criterio a evaluar");
	JLabel criterio6 = new JLabel("Criterio a evaluar");
	JLabel criterio7 = new JLabel("Criterio a evaluar");
	JLabel criterio8 = new JLabel("Criterio a evaluar");
	JLabel criterio9 = new JLabel("Criterio a evaluar");
	
	
	
	JComboBox combo1 = new JComboBox();
	JComboBox combo2 = new JComboBox();
	JComboBox combo3 = new JComboBox();
	JComboBox combo4 = new JComboBox();
	JComboBox combo5 = new JComboBox();
	JComboBox combo6 = new JComboBox();
	JComboBox combo7 = new JComboBox();
	JComboBox combo8 = new JComboBox();
	JComboBox combo9 = new JComboBox();
	
	
	
	ResultSet[] rs=new ResultSet[10];
	
	int id_evaluacion=-1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejecucion frame = new Ejecucion();
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
	public Ejecucion() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				cerrar();
			}
		});
		
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		panel.setBorder(new TitledBorder(null, "Evaluaciones", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 335, 708);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 310, 640);
		panel.add(scrollPane);
		
		tbl_evaluaciones = new JTable();
		tbl_evaluaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
				int indice=tbl_evaluaciones.getSelectedRow();
				
				txt_nombre.setText(tbl_evaluaciones.getValueAt(indice,2).toString());
				txt_url.setText(tbl_evaluaciones.getValueAt(indice,3).toString());
				txt_navegador.setText(tbl_evaluaciones.getValueAt(indice,4).toString());
				txt_version.setText(tbl_evaluaciones.getValueAt(indice,5).toString());
				id_evaluacion=Integer.parseInt(tbl_evaluaciones.getValueAt(indice,0).toString());
				
				
				
			}
		});
		tbl_evaluaciones.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "FIla 1"
			}
		));
		scrollPane.setViewportView(tbl_evaluaciones);
	
		
		
		btn_iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				String nombre=txt_nombre.getText();
				String url=txt_url.getText();
				
				String navegador=txt_navegador.getText();
				String version=txt_version.getText();
				
				
				String email= Acceso.conectado();
				//String email="perez@gmail.com";
				
				if(nombre.equals("") || url.equals("")){
					JOptionPane.showMessageDialog(null,"Por favor seleccione una evaluaci�n de la tabla");
				}else{
					if(version.equals("")||navegador.equals("")){
						JOptionPane.showMessageDialog(null, "Por favor seleccione una evaluaci�n de la tabla");	
						
						if(version.equals("")){
							txt_version.requestFocus();
						}
						
						if(navegador.equals("")){
							txt_navegador.requestFocus();
						}
						
						
					}else{
						
						
						tbl_evaluaciones.setEnabled(false);
							
						contenedor_criterios.setVisible(true);
						btn_iniciar.setEnabled(false);
							
							
							try {
								
								//primera carga
								JOptionPane.showMessageDialog(null, "EXSHE est� iniciando el test, por favor espere a que todos los criterios de evaluaci�n sean cargados.");	
								actualizarNumeroVista();
								rs=Evaluacion.consultarCalificaciones(id_evaluacion);
								
								cargarCriterios();
								
								
												
								
							
							} catch (Exception e) {
								
								e.printStackTrace();
							}
							

							
							
					}
					
				}
			
				
				
				
				
				
				
				
			}
		});
		btn_iniciar.setBorder(UIManager.getBorder("CheckBox.border"));
		btn_iniciar.setBackground(SystemColor.controlHighlight);
		btn_iniciar.setBounds(183, 19, 137, 27);
		panel.add(btn_iniciar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(355, 11, 985, 708);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Calificaci�n de criterios", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBackground(new Color(223, 223, 233));
		panel_11.setBounds(26, 32, 455, 27);
		panel_1.add(panel_11);
		
		JLabel label_11 = new JLabel("Nombre del Sitio:");
		label_11.setFont(new Font("Dialog", Font.BOLD, 12));
		label_11.setBounds(12, 5, 96, 15);
		panel_11.add(label_11);
		
		txt_nombre = new JTextField();
		txt_nombre.setEditable(false);
		txt_nombre.setColumns(10);
		txt_nombre.setBorder(null);
		txt_nombre.setBackground(new Color(223, 223, 233));
		txt_nombre.setBounds(118, 3, 319, 20);
		panel_11.add(txt_nombre);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBackground(new Color(223, 223, 233));
		panel_12.setBounds(26, 65, 455, 27);
		panel_1.add(panel_12);
		
		JLabel label_12 = new JLabel("Navegador para la evaluaci�n:");
		label_12.setFont(new Font("Dialog", Font.BOLD, 12));
		label_12.setBounds(12, 5, 170, 15);
		panel_12.add(label_12);
		
		txt_navegador = new JTextField();
		txt_navegador.setEditable(false);
		txt_navegador.setColumns(10);
		txt_navegador.setBorder(null);
		txt_navegador.setBackground(new Color(223, 223, 233));
		txt_navegador.setBounds(192, 3, 245, 20);
		panel_12.add(txt_navegador);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBackground(new Color(223, 223, 233));
		panel_13.setBounds(502, 31, 473, 27);
		panel_1.add(panel_13);
		
		JLabel label_13 = new JLabel("Url del Sitio:");
		label_13.setFont(new Font("Dialog", Font.BOLD, 12));
		label_13.setBounds(10, 5, 67, 15);
		panel_13.add(label_13);
		
		txt_url = new JTextField();
		txt_url.setEditable(false);
		txt_url.setColumns(10);
		txt_url.setBorder(null);
		txt_url.setBackground(new Color(223, 223, 233));
		txt_url.setBounds(87, 3, 376, 20);
		panel_13.add(txt_url);
		
		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBackground(new Color(223, 223, 233));
		panel_14.setBounds(502, 65, 473, 27);
		panel_1.add(panel_14);
		
		JLabel label_14 = new JLabel("Versi�n:");
		label_14.setFont(new Font("Dialog", Font.BOLD, 12));
		label_14.setBounds(10, 5, 47, 15);
		panel_14.add(label_14);
		
		txt_version = new JTextField();
		txt_version.setEditable(false);
		txt_version.setColumns(10);
		txt_version.setBorder(null);
		txt_version.setBackground(new Color(223, 223, 233));
		txt_version.setBounds(69, 3, 394, 20);
		panel_14.add(txt_version);
		
		
		contenedor_criterios.setBounds(10, 103, 965, 594);
		panel_1.add(contenedor_criterios);
		contenedor_criterios.setLayout(null);
		
		
		contenedorCriterio1.setLayout(null);
		contenedorCriterio1.setBackground(Color.LIGHT_GRAY);
		contenedorCriterio1.setBounds(16, 38, 949, 45);
		contenedor_criterios.add(contenedorCriterio1);
		
		
		criterio1.setForeground(Color.BLACK);
		criterio1.setFont(new Font("Dialog", Font.PLAIN, 12));
		criterio1.setBounds(10, 0, 939, 18);
		contenedorCriterio1.add(criterio1);
		combo1.setMaximumRowCount(12);
		combo1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(id_calificacion1!=-3){
					actualizarCalificacion(id_calificacion1, combo1);
					}

			}
		});
		
		
		combo1.setBounds(10, 20, 155, 21);
		contenedorCriterio1.add(combo1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(223, 223, 233));
		panel_4.setBounds(16, 0, 949, 27);
		contenedor_criterios.add(panel_4);
		
		JLabel label_1 = new JLabel("CRITERIOS A EVALUAR");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setBounds(406, 0, 172, 23);
		panel_4.add(label_1);
		numeroVista.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		numeroVista.setBounds(810, 5, 129, 14);
		panel_4.add(numeroVista);
		
	
		contenedorCriterio2.setLayout(null);
		contenedorCriterio2.setBackground(Color.LIGHT_GRAY);
		contenedorCriterio2.setBounds(16, 94, 949, 50);
		contenedor_criterios.add(contenedorCriterio2);
		
		
		criterio2.setForeground(Color.BLACK);
		criterio2.setFont(new Font("Dialog", Font.PLAIN, 12));
		criterio2.setBounds(10, 0, 929, 18);
		contenedorCriterio2.add(criterio2);
		combo2.setMaximumRowCount(12);
		combo2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				

				if(id_calificacion2!=-3){
				actualizarCalificacion(id_calificacion2, combo2);
				}

			}
		});
		
		
		combo2.setBounds(10, 18, 155, 21);
		contenedorCriterio2.add(combo2);
		
		
		contenedorCriterio3.setLayout(null);
		contenedorCriterio3.setBackground(Color.LIGHT_GRAY);
		contenedorCriterio3.setBounds(16, 151, 949, 50);
		contenedor_criterios.add(contenedorCriterio3);
		
		
		criterio3.setForeground(Color.BLACK);
		criterio3.setFont(new Font("Dialog", Font.PLAIN, 12));
		criterio3.setBounds(10, 0, 939, 18);
		contenedorCriterio3.add(criterio3);
		combo3.setMaximumRowCount(12);
		combo3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(id_calificacion3!=-3){
					actualizarCalificacion(id_calificacion3, combo3);
					}

				
			}
		});
		
		
		combo3.setBounds(10, 18, 155, 21);
		contenedorCriterio3.add(combo3);
		
		
		contenedorCriterio5.setLayout(null);
		contenedorCriterio5.setBackground(Color.LIGHT_GRAY);
		contenedorCriterio5.setBounds(16, 264, 949, 50);
		contenedor_criterios.add(contenedorCriterio5);
		
		
		criterio5.setForeground(Color.BLACK);
		criterio5.setFont(new Font("Dialog", Font.PLAIN, 12));
		criterio5.setBounds(10, 0, 939, 18);
		contenedorCriterio5.add(criterio5);
		combo5.setMaximumRowCount(12);
		combo5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(id_calificacion5!=-3){
					actualizarCalificacion(id_calificacion5, combo5);
					}

			}
		});
		
		
		combo5.setBounds(10, 18, 155, 21);
		contenedorCriterio5.add(combo5);
		
		
		contenedorCriterio4.setLayout(null);
		contenedorCriterio4.setBackground(Color.LIGHT_GRAY);
		contenedorCriterio4.setBounds(16, 207, 949, 50);
		contenedor_criterios.add(contenedorCriterio4);
		
		
		criterio4.setFont(new Font("Dialog", Font.PLAIN, 12));
		criterio4.setBounds(10, 0, 939, 18);
		contenedorCriterio4.add(criterio4);
		combo4.setMaximumRowCount(12);
		combo4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(id_calificacion4!=-3){
					actualizarCalificacion(id_calificacion4, combo4);
					}

			}
		});
		
		
		combo4.setBounds(10, 18, 155, 21);
		contenedorCriterio4.add(combo4);
		
		
		contenedorCriterio6.setLayout(null);
		contenedorCriterio6.setBackground(Color.LIGHT_GRAY);
		contenedorCriterio6.setBounds(16, 320, 949, 50);
		contenedor_criterios.add(contenedorCriterio6);
		
		
		criterio6.setForeground(Color.BLACK);
		criterio6.setFont(new Font("Dialog", Font.PLAIN, 12));
		criterio6.setBounds(10, 0, 939, 18);
		contenedorCriterio6.add(criterio6);
		combo6.setMaximumRowCount(12);
		combo6.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(id_calificacion6!=-3){
					actualizarCalificacion(id_calificacion6, combo6);
					}

			}
		});
		
		
		combo6.setBounds(10, 18, 155, 21);
		contenedorCriterio6.add(combo6);
		
		
		contenedorCriterio7.setLayout(null);
		contenedorCriterio7.setBackground(Color.LIGHT_GRAY);
		contenedorCriterio7.setBounds(16, 375, 949, 50);
		contenedor_criterios.add(contenedorCriterio7);
		
		
		criterio7.setForeground(Color.BLACK);
		criterio7.setFont(new Font("Dialog", Font.PLAIN, 12));
		criterio7.setBounds(10, 0, 939, 18);
		contenedorCriterio7.add(criterio7);
		combo7.setMaximumRowCount(12);
		combo7.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(id_calificacion7!=-3){
					actualizarCalificacion(id_calificacion7, combo7);
					}

			}
		});
		
		
		combo7.setBounds(10, 18, 155, 21);
		contenedorCriterio7.add(combo7);
		
		
		contenedorCriterio8.setLayout(null);
		contenedorCriterio8.setBackground(Color.LIGHT_GRAY);
		contenedorCriterio8.setBounds(16, 431, 949, 50);
		contenedor_criterios.add(contenedorCriterio8);
		
		
		criterio8.setForeground(Color.BLACK);
		criterio8.setFont(new Font("Dialog", Font.PLAIN, 12));
		criterio8.setBounds(10, 0, 939, 18);
		contenedorCriterio8.add(criterio8);
		combo8.setMaximumRowCount(12);
		combo8.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(id_calificacion8!=-3){
					actualizarCalificacion(id_calificacion8, combo8);
					}

			}
		});
		
		
		combo8.setBounds(10, 18, 155, 21);
		contenedorCriterio8.add(combo8);
		
		
		contenedorCriterio9.setLayout(null);
		contenedorCriterio9.setBackground(Color.LIGHT_GRAY);
		contenedorCriterio9.setBounds(16, 488, 949, 50);
		contenedor_criterios.add(contenedorCriterio9);
		
		
		criterio9.setForeground(Color.BLACK);
		criterio9.setFont(new Font("Dialog", Font.PLAIN, 12));
		criterio9.setBounds(10, 0, 939, 18);
		contenedorCriterio9.add(criterio9);
		combo9.setMaximumRowCount(12);
		combo9.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(id_calificacion9!=-3){
					actualizarCalificacion(id_calificacion9, combo9);
					}

			}
		});
		
	
		combo9.setBounds(10, 18, 155, 21);
		contenedorCriterio9.add(combo9);
		
		JButton button_1 = new JButton("Anterior");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(i>0){
					
					i--;
					actualizarNumeroVista();
					try {
						cargarCriterios();
					} catch (SQLException e) {
						//En caso de falla
						e.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(null, "Estos son los primeros criterios que debe calificar");
				}
			}
		});
		button_1.setBounds(19, 559, 89, 23);
		contenedor_criterios.add(button_1);
		
		JButton button_2 = new JButton("Siguiente");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(i<9){
					
					i++;
					actualizarNumeroVista();
					try {
						cargarCriterios();
					} catch (SQLException e) {
						//En caso de falla
						e.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(null, "Estos son los �ltimos criterios que debe calificar");
				}
			}
		});
		button_2.setBounds(128, 559, 89, 23);
		contenedor_criterios.add(button_2);
		
		JButton button_3 = new JButton("Guardar Sesi\u00F3n");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
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
						contenedor_criterios.setVisible(false);
						if(Evaluacion.cambiarEstadoAPendiete(id_evaluacion)>0){
							JOptionPane.showMessageDialog(null,"Sesi�n guardada exitosamente, recuerde que tiene criterios pendientes de calificar");
							cargarTabla();
							tbl_evaluaciones.setEnabled(true);
							limpiar();
							btn_iniciar.setEnabled(true);
						}else{
							JOptionPane.showMessageDialog(null,"Error al guardar la sesi�n");
						}
							
						
						
						
					}else{
						
						JOptionPane.showMessageDialog(null,"Todos los criterios ya han sido calificados, se recomienda que de clic en finalizar para visualizar el informe correspondiente a esta evaluaci�n");

						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_3.setBounds(239, 559, 138, 23);
		contenedor_criterios.add(button_3);
		
		JButton button_4 = new JButton("Finalizar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
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
						

						//JOptionPane.showMessageDialog(null,"No se puede finalizar a�n tiene "+i+" criterios pendientes de calificar: "+criteriosPendientes);
						
						MensajePendientes msjPendiente=new MensajePendientes();
						msjPendiente.mensajeError.setText("<html><div style='margin-top=3px;'><h3 style='color:red'>No se puede finalizar la evaluaci�n debido a que a�n tiene "+(i+-1)+" criterios pendientes de calificar: <br></h3>"+criteriosPendientes+"</div></html>");
						msjPendiente.show();
						
					}else{
						
						
						
					
						
						if(Evaluacion.cambiarEstado(id_evaluacion)>0){
							limpiar();				
							//panel_heuristicos.setVisible(false);
							//panel_descripcion.setVisible(false);
							tbl_evaluaciones.setEnabled(true);
							contenedor_criterios.setVisible(false);
							btn_iniciar.setEnabled(true);
							JOptionPane.showMessageDialog(null,"Evaluaci�n finalizada exitosamente");
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
		button_4.setBounds(396, 559, 89, 23);
		contenedor_criterios.add(button_4);
		
		
		
		cargarTabla();
		//constructor
		contenedor_criterios.setVisible(false);		
	}
	
	
	public void cerrar(){
		dispose();
	}
	
	
		
		
	public void cargarTabla() {
			
			//JOptionPane.showMessageDialog(null,Acceso.conectado());
			String email=Acceso.conectado();
			//String email="perez@gmail.com";
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
			modelo.addColumn("VERSI�N");
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
		modelo.addColumn("VERSI�N"); 5
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
	
	
	
	
	public int mostrarCriterioIndividual(JLabel lbl,JComboBox combo,ResultSet rs) throws  SQLException{
		int id_cali=-1;
		float puntos;
		
		
		//verde
		int r=209;
		int g=255;
		int b=212;
		
		//rojo			
		int rR=255;
		int gR=209;
		int bR=203;
	
		id_cali=rs.getInt(1);
		puntos=Evaluacion.consultarCalificacion(id_cali);

		lbl.setText("<html><div>"+rs.getString(9)+": "+rs.getString(5)+"</html></div>");
	
	
		if(rs.getString(6).equals("Num�rico")){
			
			
			
			cargarComboNumeros(combo);	
			if(puntos==-1){
				combo.setSelectedIndex(0);
				combo.setBackground(new Color(rR,gR, bR));//pintando rojo
				
			}else{
				
				combo.setBackground(new Color(r,g, b));//pintando verde
				if(puntos==-2){
					combo.setSelectedIndex(11);
					
				}else{
										
					combo.setSelectedIndex((int) puntos);
					
				}
			}
			
				}else{
				cargarComboTexto(combo);
		
				if(puntos==-1){
					combo.setSelectedIndex(0);
					combo.setBackground(new Color(rR,gR, bR));//rojo
				}
				
				
				
				
				
				if(puntos==0){
						combo.setSelectedIndex(1);
						combo.setBackground(new Color(r,g,b));//pintando verde
						
				}
				
				if(puntos>0 && puntos<5){
					combo.setSelectedIndex(2);	
					combo.setBackground(new Color(r,g,b));//pintando verde
					
				}
				if(puntos==5){
					combo.setSelectedIndex(3);	
					combo.setBackground(new Color(r,g,b));//pintando verde
				}
				if(puntos>5 && puntos<10){
					combo.setSelectedIndex(4);	
					combo.setBackground(new Color(r,g,b));//pintando verde
				}
				if(puntos==10){
					combo.setSelectedIndex(5);	
					combo.setBackground(new Color(r,g,b));//pintando verde
				}	
				if(puntos==-2){
					combo.setSelectedIndex(6);	
					combo.setBackground(new Color(r,g,b));//pintando verde
				}
			}
		
		return id_cali;
		
	}
	
	
	
	public void cargarComboNumeros(JComboBox combo){
		combo.removeAllItems();
		combo.addItem("Seleccione una opci�n");
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
		combo.addItem("Seleccione una opci�n");
		combo.addItem("NTS");
		combo.addItem("NEP");
		combo.addItem("NPP");
		combo.addItem("NPI");
		combo.addItem("S");
		combo.addItem("NA");


	}
	
	
	public void cargarCriterios() throws SQLException{
		
		id_calificacion1=-3;
		id_calificacion2=-3;		
		id_calificacion3=-3;
		id_calificacion4=-3;
		id_calificacion5=-3;
		id_calificacion6=-3;
		id_calificacion7=-3;
		id_calificacion8=-3;
		id_calificacion9=-3;
		
		mostrarPanelesCriterios();
		
		rs[i].first();
		
		if(i<9){
			id_calificacion1=mostrarCriterioIndividual(criterio1, combo1, rs[i]);
			rs[i].next();
			id_calificacion2=mostrarCriterioIndividual(criterio2, combo2, rs[i]);
			rs[i].next();
			id_calificacion3=mostrarCriterioIndividual(criterio3, combo3, rs[i]);
			rs[i].next();
			id_calificacion4=mostrarCriterioIndividual(criterio4, combo4, rs[i]);
			rs[i].next();
			id_calificacion5=mostrarCriterioIndividual(criterio5, combo5, rs[i]);
			rs[i].next();
			id_calificacion6=mostrarCriterioIndividual(criterio6, combo6, rs[i]);
			rs[i].next();
			id_calificacion7=mostrarCriterioIndividual(criterio7, combo7, rs[i]);
			rs[i].next();
			id_calificacion8=mostrarCriterioIndividual(criterio8, combo8, rs[i]);
			rs[i].next();
			id_calificacion9=mostrarCriterioIndividual(criterio9, combo9, rs[i]);
		}else{
			id_calificacion1=mostrarCriterioIndividual(criterio1, combo1, rs[i]);
			rs[i].next();
			id_calificacion2=mostrarCriterioIndividual(criterio2, combo2, rs[i]);
			rs[i].next();
			
			limpiarPanelesCriterios();
			

			
		}
	}
	
	public void limpiarPanelesCriterios(){
		contenedorCriterio3.setVisible(false);
		contenedorCriterio4.setVisible(false);
		contenedorCriterio5.setVisible(false);
		contenedorCriterio6.setVisible(false);
		contenedorCriterio7.setVisible(false);
		contenedorCriterio8.setVisible(false);
		contenedorCriterio9.setVisible(false);
		
	}
	
	public void mostrarPanelesCriterios(){
		contenedorCriterio1.setVisible(true);
		contenedorCriterio2.setVisible(true);
		contenedorCriterio3.setVisible(true);
		contenedorCriterio4.setVisible(true);
		contenedorCriterio5.setVisible(true);
		contenedorCriterio6.setVisible(true);
		contenedorCriterio7.setVisible(true);
		contenedorCriterio8.setVisible(true);
		contenedorCriterio9.setVisible(true);
		
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
	
	
	public void limpiar(){
		txt_navegador.setText("");
		txt_version.setText("");
		txt_nombre.setText("");
		txt_url.setText("");
		txt_navegador.requestFocus();
		
		id_calificacion1=-3;
		id_calificacion2=-3;		
		id_calificacion3=-3;
		id_calificacion4=-3;
		id_calificacion5=-3;
		id_calificacion6=-3;
		id_calificacion7=-3;
		id_calificacion8=-3;
		id_calificacion9=-3;
		
	}
	
	public void actualizarNumeroVista(){
		numeroVista.setText((i+1)+" de 10");
	}
}



