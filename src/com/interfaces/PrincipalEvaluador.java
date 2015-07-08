package com.interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.persistencia.Evaluacion;

public class PrincipalEvaluador extends JFrame {

	private JPanel contentPane;
	JLabel lbl_evaluador = 	new JLabel("Evaluador conectado para evaluar");
	public static PrincipalEvaluador framePrincipal = new PrincipalEvaluador();
	private JTextField txt_navegador;
	private JTable tbl_proyectos;
	JPanel contenedor_proyectos;
	int id_proyecto;

	 Evaluacion evaluacion;
	 private JTextField txt_version;
	 private JTextField txt_nombre;
	 private JTextField txt_url;
	 private JTable tbl_evaluaciones;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					framePrincipal.setVisible(true);
					framePrincipal.setExtendedState(MAXIMIZED_BOTH);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	


	/**
	 * Create the frame.
	 */
	public PrincipalEvaluador() {
		setTitle("EXSHE - VENTANA PRINCIPAL");
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
		
		JPanel panel = new JPanel();
		panel.setBounds(-1, 0, 1600, 89);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1600, 36);
		panel.add(menuBar);
		
		JMenu menu = new JMenu("  ");
		menuBar.add(menu);
		menu.addSeparator();
		
		JMenu mnNewMenu_2 = new JMenu("   Inicio   ");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmAcceso = new JMenuItem("Ventana de Acceso");
		mntmAcceso.setAccelerator(
		         KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.SHIFT_MASK));
		mntmAcceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				  int n = JOptionPane.showConfirmDialog(
				            null,
				            "¿Está seguro que desea salir a la ventana de acceso?",
				            "Mensaje de Confirmación",
				            JOptionPane.YES_NO_OPTION);
				  	
				  		
				        if(n==0){
				        	Acceso a1=new Acceso();
							a1.show();
							a1.setExtendedState(MAXIMIZED_BOTH);
							dispose();
				        }
				        else {
				           //No
				        }
				        
				
			}
		});
		mnNewMenu_2.add(mntmAcceso);
		
		JMenu mnEvaluaciones = new JMenu("  Evaluaciones  ");
		menuBar.add(mnEvaluaciones);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem(" Ejecutar");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EjecucionEvaluaciones ejecucion=new EjecucionEvaluaciones();
				ejecucion.lbl_evaluador.setText(lbl_evaluador.getText());
				
				ejecucion.show();
				
				
			}
		});
		mnEvaluaciones.add(mntmNewMenuItem_9);
		
		JMenu mnHeursticos = new JMenu("    Heurísticos    ");
		menuBar.add(mnHeursticos);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("  Administración");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdministracionHeuristicos administracion=new AdministracionHeuristicos();
				administracion.show();
			}
		});
		mnHeursticos.add(mntmNewMenuItem);
		
		JMenu mnSubHeursticos = new JMenu("Sub Heurísticos");
		menuBar.add(mnSubHeursticos);
		
		JMenuItem menuItem = new JMenuItem("  Administración");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdministracionSubHeuristicos adminSub=new AdministracionSubHeuristicos();
				adminSub.show();
			}
		});
		mnSubHeursticos.add(menuItem);
		
		
		JMenu mnAyuda = new JMenu("  Ayuda  ");
		menuBar.add(mnAyuda);
		lbl_evaluador.setFont(new Font("Dialog", Font.ITALIC, 12));
		
		lbl_evaluador.setBounds(187, 54, 222, 31);
		panel.add(lbl_evaluador);
		
		JLabel lblEvaluador = new JLabel("Evaluador conectado:");
		lblEvaluador.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblEvaluador.setBounds(35, 58, 151, 22);
		panel.add(lblEvaluador);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 34, 1600, 22);
		panel.add(panel_1);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 0, 1600, 25);
		panel_1.add(menuBar_1);
		
		JMenu mnNewMenu = new JMenu("   ");
		menuBar_1.add(mnNewMenu);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(223, 223, 233));
		panel_2.setBounds(459, 101, 384, 78);
		contentPane.add(panel_2);
		
		JLabel lblLog = new JLabel("LOG");
		lblLog.setIcon(new ImageIcon(PrincipalEvaluador.class.getResource("/img/evaluaciones.png")));
		lblLog.setBounds(12, 0, 62, 78);
		panel_2.add(lblLog);
		
		JLabel label_2 = new JLabel("Expert System of Heuristic Evaluation");
		label_2.setFont(new Font("Dialog", Font.BOLD, 13));
		label_2.setBounds(94, 12, 278, 15);
		panel_2.add(label_2);
		
		JLabel lblBienvenido = new JLabel("Evaluaciones");
		lblBienvenido.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblBienvenido.setBounds(94, 38, 278, 15);
		panel_2.add(lblBienvenido);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "Creación de Evaluaciones", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_8.setBounds(443, 201, 444, 498);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(223, 223, 233));
		panel_5.setBounds(41, 47, 365, 78);
		panel_8.add(panel_5);
		
		JLabel label = new JLabel("NUEVA EVALUACIÓN");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(96, 28, 204, 19);
		panel_5.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(223, 223, 233));
		panel_3.setBounds(12, 318, 410, 27);
		panel_8.add(panel_3);
		
		JLabel lblNavegadorParaLa = new JLabel("Navegador para la evaluación:");
		lblNavegadorParaLa.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNavegadorParaLa.setBounds(12, 5, 242, 15);
		panel_3.add(lblNavegadorParaLa);
		
		txt_navegador = new JTextField();
		txt_navegador.setColumns(10);
		txt_navegador.setBorder(null);
		txt_navegador.setBackground(new Color(223, 223, 233));
		txt_navegador.setBounds(249, 3, 149, 20);
		panel_3.add(txt_navegador);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(223, 223, 233));
		panel_7.setBounds(12, 250, 410, 27);
		panel_8.add(panel_7);
		
		JLabel lblUrlDelSitio = new JLabel("Url del Sitio:");
		lblUrlDelSitio.setFont(new Font("Dialog", Font.BOLD, 13));
		lblUrlDelSitio.setBounds(12, 5, 103, 15);
		panel_7.add(lblUrlDelSitio);
		
		txt_url = new JTextField();
		txt_url.setEditable(false);
		txt_url.setColumns(10);
		txt_url.setBorder(null);
		txt_url.setBackground(new Color(223, 223, 233));
		txt_url.setBounds(111, 3, 287, 20);
		panel_7.add(txt_url);
		
		JButton btnGuardar = new JButton("  Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre=txt_nombre.getText();
				String url=txt_url.getText();
				
				String navegador=txt_navegador.getText();
				String version=txt_version.getText();
				
				String email=lbl_evaluador.getText();
				
				if(nombre.equals("") || url.equals("")){
					contenedor_proyectos.setBorder(new TitledBorder(null, "Proyectos disponibles para evaluar", TitledBorder.LEFT, TitledBorder.TOP, null, Color.red));
					JOptionPane.showMessageDialog(null,"Por favor seleccione un proyecto de la tabla");
					
					
					//contenedor_proyectos.setBackground(new Color(204,116,128));
					contenedor_proyectos.setForeground(new Color(204,116,128));
				}else{
					if(version.equals("")||navegador.equals("")){
						JOptionPane.showMessageDialog(null, "Por favor complete los campos");	
						
						if(version.equals("")){
							txt_version.requestFocus();
						}
						
						if(navegador.equals("")){
							txt_navegador.requestFocus();
						}
						
						
					}else{
						evaluacion=new Evaluacion(navegador, version);
						
						if(evaluacion.guardar(id_proyecto, email)>0){						
							contenedor_proyectos.setBorder(new TitledBorder(null, "Proyectos disponibles para evaluar", TitledBorder.LEFT, TitledBorder.TOP, null, null));
							JOptionPane.showMessageDialog(null, "Evaluación creada exitosamente");
							limpiar();
							cargarTablaEvaluaciones();
						}else{
							JOptionPane.showMessageDialog(null, "No se pudo crear la evaluación");
						}
					}
					
				}
				
			}
		});
		btnGuardar.setIcon(new ImageIcon(PrincipalEvaluador.class.getResource("/img/save.png")));
		btnGuardar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnGuardar.setBackground(SystemColor.controlHighlight);
		btnGuardar.setBounds(284, 428, 140, 38);
		panel_8.add(btnGuardar);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(223, 223, 233));
		panel_4.setBounds(12, 380, 410, 27);
		panel_8.add(panel_4);
		
		JLabel lblVersinDelNavegador = new JLabel("Versión del navegador:");
		lblVersinDelNavegador.setFont(new Font("Dialog", Font.BOLD, 13));
		lblVersinDelNavegador.setBounds(12, 5, 178, 15);
		panel_4.add(lblVersinDelNavegador);
		
		txt_version = new JTextField();
		txt_version.setColumns(10);
		txt_version.setBorder(null);
		txt_version.setBackground(new Color(223, 223, 233));
		txt_version.setBounds(188, 3, 202, 20);
		panel_4.add(txt_version);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(223, 223, 233));
		panel_6.setBounds(12, 189, 410, 27);
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
		txt_nombre.setBounds(151, 3, 250, 20);
		panel_6.add(txt_nombre);
		
		JButton button = new JButton("Limpiar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		button.setIcon(new ImageIcon(PrincipalEvaluador.class.getResource("/img/clear.png")));
		button.setFocusable(false);
		button.setBorder(UIManager.getBorder("CheckBox.border"));
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(312, 150, 109, 27);
		panel_8.add(button);
		
		contenedor_proyectos = new JPanel();
		contenedor_proyectos.setLayout(null);
		contenedor_proyectos.setBorder(new TitledBorder(null, "Proyectos disponibles para evaluar", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		contenedor_proyectos.setBounds(22, 201, 409, 499);
		contentPane.add(contenedor_proyectos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		scrollPane.setBounds(12, 35, 385, 437);
		contenedor_proyectos.add(scrollPane);
		
		tbl_proyectos = new JTable();
		tbl_proyectos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indice=tbl_proyectos.getSelectedRow();
				
				txt_nombre.setText(tbl_proyectos.getValueAt(indice,2).toString());
				txt_url.setText(tbl_proyectos.getValueAt(indice,3).toString());
				id_proyecto=Integer.parseInt(tbl_proyectos.getValueAt(indice,1).toString());
				contenedor_proyectos.setBorder(new TitledBorder(null, "Proyectos disponibles para evaluar", TitledBorder.LEFT, TitledBorder.TOP, null, null));
				//JOptionPane.showMessageDialog(null,tbl_proyectos.getValueAt(indice,0).toString());

			}
		});
		tbl_proyectos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID_DETALLE","ID_PROYECTO", "NOMBRE DEL SITIO","URL", "EVALUADOR","FECHA", "TIPO DEL SITIO"
				}
			));
		scrollPane.setViewportView(tbl_proyectos);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new TitledBorder(null, "Evaluaciones existentes", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_10.setBounds(897, 201, 441, 499);
		contentPane.add(panel_10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 35, 417, 437);
		panel_10.add(scrollPane_1);
		
		tbl_evaluaciones = new JTable();
		tbl_evaluaciones.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID_DETALLE","ID_PROYECTO", "NOMBRE DEL SITIO","URL", "EVALUADOR","FECHA", "TIPO DEL SITIO"
				}
			));
		scrollPane_1.setViewportView(tbl_evaluaciones);
		
		
		cargarTabla();
	}
	
	
	public void cerrarPrincipal(){
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
	
	
	
	
	
	
	
	public void cargarTabla() {
		
		//JOptionPane.showMessageDialog(null,Acceso.conectado());
		String email=Acceso.conectado();
		//String email="perez@gmail.com";
		ResultSet rs=null;
		try {
			rs = Evaluacion.consultarProyectosEvaluador(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DefaultTableModel modelo=new DefaultTableModel();	
		modelo.addColumn("ID_EVALUACION");
		modelo.addColumn("ID_PROYECTO");
		modelo.addColumn("NOMBRE DEL SITIO");
		modelo.addColumn("URL");
		modelo.addColumn("EVALUADOR");
		modelo.addColumn("FECHA");
		modelo.addColumn("TIPO DEL SITIO");		
		try {
			while(rs.next()){		

					modelo.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)+" "+rs.getString(6),rs.getString(7),rs.getString(9)});			

			

				
					tbl_proyectos.setModel(modelo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formatearTabla();
		cargarTablaEvaluaciones();
		

	}
	
	public void formatearTabla(){
		//tbl_subheuristicos.getColumnModel().getColumn(0).setPreferredWidth(1);
		//tbl_subheuristicos.setBackground(new Color(161,202,232));
		tbl_proyectos.setRowHeight(25);
		tbl_proyectos.setForeground(new Color(0,0,0));
		tbl_proyectos.setFont(new Font("Dialog", Font.PLAIN, 15));
		tbl_proyectos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//tbl_subheuristicos.getTableHeader().setBackground(new Color(9,125,209));
		//tbl_subheuristicos.getTableHeader().setForeground(new Color(255,255,255));
		
		
		
		tbl_proyectos.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(0);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(0).setResizable(false);
		
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(0);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(1).setResizable(false);
		
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(200);
		
		
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(200);
		

		//nombre del evaluador
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(0);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(4).setResizable(false);
		
		
		//fecha de creacion de la evaluacion
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(0);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(5).setResizable(false);
		
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(250);
		
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		

		tbl_proyectos.getColumnModel().getColumn(0).setCellRenderer(tcr);
				
		tbl_proyectos.getColumnModel().getColumn(2).setCellRenderer(tcr);
	}
	
	
	public void limpiar(){
		txt_navegador.setText("");
		txt_version.setText("");
		txt_nombre.setText("");
		txt_url.setText("");
		contenedor_proyectos.setBorder(new TitledBorder(null, "Proyectos disponibles para evaluar", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		//txt_navegador.requestFocus();
	}
	
public void cargarTablaEvaluaciones() {
		
		//JOptionPane.showMessageDialog(null,Acceso.conectado());
		String email=Acceso.conectado();
		//String email="perez@gmail.com";
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
		formatearTablaEvaluaciones();
		

	}
	
	public void formatearTablaEvaluaciones(){
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
		tbl_evaluaciones.setRowHeight(25);
		tbl_evaluaciones.setForeground(new Color(0,0,0));
		tbl_evaluaciones.setFont(new Font("Dialog", Font.PLAIN, 15));
		tbl_evaluaciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//tbl_subheuristicos.getTableHeader().setBackground(new Color(9,125,209));
		//tbl_subheuristicos.getTableHeader().setForeground(new Color(255,255,255));
		tbl_evaluaciones.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
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
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(160);
		
		
		//Version
				tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
				tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
				tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(0);
				tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(5).setResizable(false);
		
		//tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(200);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(100);
		
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		

		tbl_evaluaciones.getColumnModel().getColumn(0).setCellRenderer(tcr);
				
		tbl_evaluaciones.getColumnModel().getColumn(2).setCellRenderer(tcr);
	}
}
