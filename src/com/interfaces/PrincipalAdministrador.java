package com.interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.persistencia.Evaluador;
import com.persistencia.Proyecto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrincipalAdministrador extends JFrame {

	private JPanel contentPane;
	JLabel lbl_evaluador = 	new JLabel("Evaluador conectado para evaluar");
	public static PrincipalAdministrador framePrincipal = new PrincipalAdministrador();
	private JTextField txt_nombre;
	private JTextField txt_url;
	final JComboBox txt_tipo;
	JComboBox txt_evaluador1,txt_evaluador2,txt_evaluador3,txt_evaluador4;
	Proyecto proyecto;
	private JTable tbl_proyectos;

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
	public PrincipalAdministrador() {
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
		panel.setBounds(-1, 0, 1600, 77);
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
		mntmAcceso.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.SHIFT_MASK));
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
		
		JMenu mnEvaluaciones = new JMenu("  Proyectos");
		menuBar.add(mnEvaluaciones);
		
		JMenu mnHeursticas = new JMenu("  Heurísticos  ");
		menuBar.add(mnHeursticas);
		mnHeursticas.addSeparator();
		JMenuItem mntmA = new JMenuItem("1.   Aspectos Generales");
		mntmA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				Heuristicos h1 = new Heuristicos();
				h1.consultar_por_numero(1);				
				h1.setVisible (true); 				
			}
		});
		mnHeursticas.add(mntmA);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("2.   Identidad e Información");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Heuristicos h1 = new Heuristicos();
				h1.consultar_por_numero(2);
				h1.setVisible (true);
			}
		});
		mnHeursticas.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("3.   Estructura y Navegación");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Heuristicos h1 = new Heuristicos();
				h1.consultar_por_numero(3);
				h1.setVisible (true);
			}
		});
		mnHeursticas.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("4.   Rotulado");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Heuristicos h1 = new Heuristicos();
				h1.consultar_por_numero(4);
				h1.setVisible (true);
			}
		});
		mnHeursticas.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("5.   Layout de la Página");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Heuristicos h1 = new Heuristicos();
				h1.consultar_por_numero(5);
				h1.setVisible (true);
			}
		});
		mnHeursticas.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("6.   Entendibilidad y Facilidad en la Interacción");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Heuristicos h1 = new Heuristicos();
				h1.consultar_por_numero(6);
				h1.setVisible (true);
			}
		});
		mnHeursticas.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("7.   Control y Retroalimentacion");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Heuristicos h1 = new Heuristicos();
				h1.consultar_por_numero(7);
				h1.setVisible (true);
			}
		});
		mnHeursticas.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("8.   Elementos Multimedia");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Heuristicos h1 = new Heuristicos();
				h1.consultar_por_numero(8);
				h1.setVisible (true);
			}
		});
		mnHeursticas.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7= new JMenuItem("9.   Búsqueda");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Heuristicos h1 = new Heuristicos();
				h1.consultar_por_numero(9);
				h1.setVisible (true);
			}
		});
		mnHeursticas.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("10. Ayuda");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Heuristicos h1 = new Heuristicos();
				h1.consultar_por_numero(10);
				h1.setVisible (true);
			}
		});
		mnHeursticas.add(mntmNewMenuItem_8);
		
		JMenu mnEvaluadores = new JMenu("Evaluadores");		
		menuBar.add(mnEvaluadores);
		
		JMenuItem mnuMantenimientoEvaluadores = new JMenuItem("Mantenimiento");
		mnuMantenimientoEvaluadores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.SHIFT_MASK));
		mnuMantenimientoEvaluadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MantenimientoEvaluadores registro1=new MantenimientoEvaluadores();
				registro1.show();
				
				
			}
		});
		mnEvaluadores.add(mnuMantenimientoEvaluadores);
		
		
		JMenu mnAyuda = new JMenu("  Ayuda  ");
		menuBar.add(mnAyuda);
		lbl_evaluador.setFont(new Font("Dialog", Font.ITALIC, 12));
		
		lbl_evaluador.setBounds(170, 58, 222, 22);
		panel.add(lbl_evaluador);
		
		JLabel lblEvaluador = new JLabel("Usuario conectado:");
		lblEvaluador.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblEvaluador.setBounds(35, 58, 137, 22);
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
		panel_2.setBounds(481, 89, 386, 77);
		contentPane.add(panel_2);
		
		JLabel lblLog = new JLabel("LOG");
		lblLog.setIcon(new ImageIcon(PrincipalAdministrador.class.getResource("/img/proyecto.png")));
		lblLog.setBounds(12, 4, 68, 70);
		panel_2.add(lblLog);
		
		JLabel label_2 = new JLabel("Expert System of Heuristic Evaluation");
		label_2.setFont(new Font("Dialog", Font.BOLD, 13));
		label_2.setBounds(96, 12, 278, 15);
		panel_2.add(label_2);
		
		JLabel lblBienvenido = new JLabel("PROYECTOS");
		lblBienvenido.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblBienvenido.setBounds(96, 39, 278, 15);
		panel_2.add(lblBienvenido);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "Registro de Proyectos", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_8.setBounds(42, 205, 567, 504);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(223, 223, 233));
		panel_3.setBounds(37, 34, 495, 27);
		panel_8.add(panel_3);
		
		JLabel lblNombreDelSitio = new JLabel("Nombre del Sitio a Evaluar:");
		lblNombreDelSitio.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNombreDelSitio.setBounds(12, 5, 223, 15);
		panel_3.add(lblNombreDelSitio);
		
		txt_nombre = new JTextField();
		txt_nombre.setColumns(10);
		txt_nombre.setBorder(null);
		txt_nombre.setBackground(new Color(223, 223, 233));
		txt_nombre.setBounds(222, 3, 261, 20);
		panel_3.add(txt_nombre);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(223, 223, 233));
		panel_4.setBounds(37, 91, 495, 27);
		panel_8.add(panel_4);
		
		JLabel lblUrlDelSitio = new JLabel("Url del Sitio:");
		lblUrlDelSitio.setFont(new Font("Dialog", Font.BOLD, 13));
		lblUrlDelSitio.setBounds(12, 5, 100, 15);
		panel_4.add(lblUrlDelSitio);
		
		txt_url = new JTextField();
		txt_url.setColumns(10);
		txt_url.setBorder(null);
		txt_url.setBackground(new Color(223, 223, 233));
		txt_url.setBounds(130, 3, 353, 20);
		panel_4.add(txt_url);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(223, 223, 233));
		panel_5.setBounds(37, 143, 495, 32);
		panel_8.add(panel_5);
		
		JLabel lblTipoDeSitio = new JLabel("Tipo de Sitio:");
		lblTipoDeSitio.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTipoDeSitio.setBounds(11, 9, 100, 15);
		panel_5.add(lblTipoDeSitio);
		
		txt_tipo = new JComboBox();
		txt_tipo.setFont(new Font("Dialog", Font.PLAIN, 12));
		txt_tipo.setModel(new DefaultComboBoxModel(new String[] {"Por favor seleccione una opción", "Administración Pública / Institucional", "Banca electrónica", "Blog", "Comercio electrónico", "Comunicación / Noticias", "Corporativo / Empresas", "Descargas", "Educativo / Formativo", "Entornos colaborativos / Wikis", "Foros / Chat", "Ocio / Entretenimiento", "Personal", "Portal de Servicios", "Servicios interactivos basados en imágenes", "Servicios interactivos no basados en imágenes", "Webmail / Correo"}));
		txt_tipo.setForeground(new Color(51, 51, 51));
		txt_tipo.setBorder(null);
		txt_tipo.setBackground(UIManager.getColor(new Color(223, 223, 233)));
		txt_tipo.setBounds(129, 5, 354, 23);
		panel_5.add(txt_tipo);
		
		final JButton btnGuardar = new JButton("  Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				resaltar(btnGuardar);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				noResaltar(btnGuardar);
			}
		});
		btnGuardar.setIcon(new ImageIcon(PrincipalAdministrador.class.getResource("/img/save.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String tipo=txt_tipo.getSelectedItem().toString();
				String nombre=txt_nombre.getText();
				String url=txt_url.getText();
				
				
				String evaluador1=txt_evaluador1.getSelectedItem().toString();
				String evaluador2=txt_evaluador2.getSelectedItem().toString();
				String evaluador3=txt_evaluador3.getSelectedItem().toString();
				String evaluador4=txt_evaluador4.getSelectedItem().toString();
				
				String[] e1=evaluador1.split(":");
				String[] e2=evaluador2.split(":");
				String[] e3=evaluador3.split(":");
				String[] e4=evaluador4.split(":");
				
				if (tipo.equals("Por favor seleccione una opción") || nombre.equals("") || url.equals("")){
					JOptionPane.showMessageDialog(null, "Por favor complete los campos o seleccione un tipo de sitio");
					if(tipo.equals("")){
						txt_tipo.requestFocus();						
					}
					if(url.equals("")){
						txt_url.requestFocus();						
					}
					if(nombre.equals("")){
						txt_nombre.requestFocus();						
					}
					
				}else{
					if(evaluador1.equals("Por favor seleccione una opción") || evaluador2.equals("Por favor seleccione una opción") || evaluador3.equals("Por favor seleccione una opción") || evaluador4.equals("Por favor seleccione una opción")){
						JOptionPane.showMessageDialog(null, "Por favor seleccione los evaluadores");
					}else{
						Boolean repetidos=(evaluador1==evaluador2 || evaluador1==evaluador3 || evaluador1==evaluador4 || evaluador2==evaluador3 || evaluador2==evaluador4 || evaluador3==evaluador4);
						if(repetidos){
							JOptionPane.showMessageDialog(null, "Debe seleccionar diferentes evaluadores");
						
							
							}else{
								proyecto=new Proyecto(url, nombre, tipo,e1[1],e2[1],e3[1],e4[1]);
				 				
								if(proyecto.guardar()>0){
									JOptionPane.showMessageDialog(null,"Proyecto guardado Exitosamente");	
									limpiar();
									try {
										cargarTabla();
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
								}else{
									JOptionPane.showMessageDialog(null,"Error al guardar el proyecto");						
								}
								
							
							}
					}
				}
			}
		});
		btnGuardar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnGuardar.setBackground(SystemColor.controlHighlight);
		btnGuardar.setBounds(409, 439, 128, 38);
		panel_8.add(btnGuardar);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(223, 223, 233));
		panel_6.setBounds(37, 201, 495, 32);
		panel_8.add(panel_6);
		
		JLabel lblEvaluador_1 = new JLabel("Evaluador 1:");
		lblEvaluador_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEvaluador_1.setBounds(11, 9, 100, 15);
		panel_6.add(lblEvaluador_1);
		
		txt_evaluador1 = new JComboBox();
		txt_evaluador1.setFont(new Font("Dialog", Font.PLAIN, 12));
		txt_evaluador1.setModel(new DefaultComboBoxModel(new String[] {"Por favor seleccione una opción"}));
		txt_evaluador1.setForeground(UIManager.getColor("Button.foreground"));
		txt_evaluador1.setBorder(null);
		txt_evaluador1.setBackground((Color) null);
		txt_evaluador1.setBounds(129, 5, 354, 23);
		panel_6.add(txt_evaluador1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(223, 223, 233));
		panel_7.setBounds(37, 264, 495, 32);
		panel_8.add(panel_7);
		
		JLabel lblEvaluador_2 = new JLabel("Evaluador 2:");
		lblEvaluador_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEvaluador_2.setBounds(11, 9, 100, 15);
		panel_7.add(lblEvaluador_2);
		
		txt_evaluador2 = new JComboBox();
		txt_evaluador2.setFont(new Font("Dialog", Font.PLAIN, 12));
		txt_evaluador2.setModel(new DefaultComboBoxModel(new String[] {"Por favor seleccione una opción"}));
		txt_evaluador2.setForeground(UIManager.getColor("Button.foreground"));
		txt_evaluador2.setBorder(null);
		txt_evaluador2.setBackground((Color) null);
		txt_evaluador2.setBounds(129, 5, 354, 23);
		panel_7.add(txt_evaluador2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(223, 223, 233));
		panel_9.setBounds(37, 321, 495, 32);
		panel_8.add(panel_9);
		
		JLabel lblEvaluador_3 = new JLabel("Evaluador 3:");
		lblEvaluador_3.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEvaluador_3.setBounds(11, 9, 100, 15);
		panel_9.add(lblEvaluador_3);
		
		txt_evaluador3 = new JComboBox();
		txt_evaluador3.setFont(new Font("Dialog", Font.PLAIN, 12));
		txt_evaluador3.setModel(new DefaultComboBoxModel(new String[] {"Por favor seleccione una opción"}));
		txt_evaluador3.setForeground(UIManager.getColor("Button.foreground"));
		txt_evaluador3.setBorder(null);
		txt_evaluador3.setBackground((Color) null);
		txt_evaluador3.setBounds(129, 5, 354, 23);
		panel_9.add(txt_evaluador3);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(223, 223, 233));
		panel_10.setBounds(37, 380, 495, 32);
		panel_8.add(panel_10);
		
		JLabel lblEvaluador_4 = new JLabel("Evaluador 4:");
		lblEvaluador_4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEvaluador_4.setBounds(11, 9, 100, 15);
		panel_10.add(lblEvaluador_4);
		
		txt_evaluador4 = new JComboBox();
		txt_evaluador4.setFont(new Font("Dialog", Font.PLAIN, 12));
		txt_evaluador4.setModel(new DefaultComboBoxModel(new String[] {"Por favor seleccione una opción"}));
		txt_evaluador4.setForeground(UIManager.getColor("Button.foreground"));
		txt_evaluador4.setBorder(null);
		txt_evaluador4.setBackground((Color) null);
		txt_evaluador4.setBounds(129, 5, 354, 23);
		panel_10.add(txt_evaluador4);
		
		final JButton Refrescar = new JButton("  Refrescar Datos");
		Refrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cargarEvaluadores();
					cargarTabla();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		Refrescar.setIcon(new ImageIcon(PrincipalAdministrador.class.getResource("/img/refresh.png")));
		Refrescar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				resaltar(Refrescar);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				noResaltar(Refrescar);
			}
		});
		Refrescar.setBorder(UIManager.getBorder("CheckBox.border"));
		Refrescar.setBackground(SystemColor.controlHighlight);
		Refrescar.setBounds(185, 439, 195, 38);
		panel_8.add(Refrescar);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBorder(new TitledBorder(null, "Proyectos Recientes", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_11.setBounds(614, 204, 724, 505);
		contentPane.add(panel_11);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 34, 684, 448);
		panel_11.add(scrollPane);
		
		tbl_proyectos = new JTable();
		tbl_proyectos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID_DETALLE","ID_PROYECTO", "NOMBRE DEL SITIO","URL", "EVALUADOR","FECHA", "TIPO DEL SITIO"
			}
		));
		tbl_proyectos.getColumnModel().getColumn(4).setPreferredWidth(110);
		scrollPane.setViewportView(tbl_proyectos);
		
		try {
			cargarEvaluadores();
			cargarTabla();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
	
	
	
	public void cargarEvaluadores() throws SQLException{
		ResultSet evaluadores=Evaluador.consultarTodos();
		
		txt_evaluador1.removeAllItems();
		txt_evaluador1.addItem("Por favor seleccione una opción");
		
		txt_evaluador1.removeAllItems();
		txt_evaluador1.addItem("Por favor seleccione una opción");
		
		txt_evaluador2.removeAllItems();
		txt_evaluador2.addItem("Por favor seleccione una opción");
		
		txt_evaluador3.removeAllItems();
		txt_evaluador3.addItem("Por favor seleccione una opción");
		
		txt_evaluador4.removeAllItems();
		txt_evaluador4.addItem("Por favor seleccione una opción");
		while(evaluadores.next()){			
			
			if(evaluadores.getInt(1)>1){
				String evaluador=evaluadores.getString(8)+" "+evaluadores.getString(2)+":"+evaluadores.getString(3);
				txt_evaluador1.addItem(evaluador);
				txt_evaluador2.addItem(evaluador);
				txt_evaluador3.addItem(evaluador);
				txt_evaluador4.addItem(evaluador);
			}
			
			
		}
	}

	public void limpiar(){
		txt_nombre.setText("");
		txt_url.setText("");
		txt_tipo.setSelectedIndex(0);
		txt_evaluador1.setSelectedIndex(0);
		txt_evaluador2.setSelectedIndex(0);
		txt_evaluador3.setSelectedIndex(0);
		txt_evaluador4.setSelectedIndex(0);
		txt_nombre.requestFocus();
		
	}
	
	
	public void cargarTabla() throws SQLException{
		ResultSet rs=proyecto.consultarEvaluadoresProyectos();
		DefaultTableModel modelo=new DefaultTableModel();	
		modelo.addColumn("ID_DETALLE");
		modelo.addColumn("ID_PROYECTO");
		modelo.addColumn("NOMBRE DEL SITIO");
		modelo.addColumn("URL");
		modelo.addColumn("EVALUADOR");
		modelo.addColumn("FECHA");
		modelo.addColumn("TIPO DEL SITIO");		
		while(rs.next()){		
	
				modelo.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)+" "+rs.getString(6),rs.getString(7),rs.getString(9)});			

		

			
				tbl_proyectos.setModel(modelo);
		}
		formatearTabla();

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
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(160);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(200);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(250);
		
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		

		tbl_proyectos.getColumnModel().getColumn(0).setCellRenderer(tcr);
				
		tbl_proyectos.getColumnModel().getColumn(2).setCellRenderer(tcr);
	}
	
	
	
	public  void resaltar(JButton btn){
		btn.setBackground(new Color(200,200,200));
		
	}
	
	public  void noResaltar(JButton btn){
		btn.setBackground(new Color(230,230,230));
		
	}
	
	
}


