package com.interfaces;

import java.awt.Color;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import javax.swing.JPasswordField;
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

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import com.persistencia.Conexion;
import com.persistencia.Evaluador;
import com.persistencia.Proyecto;
import com.persistencia.RutaBase;


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
	private JTextField txtEmail;
	private JPasswordField passwordNueva;
	private JPasswordField passwordConfirmada;
	final JPanel panelConfiguracion = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					framePrincipal.setVisible(true);
					
					
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Acceso.class.getResource("/img/logo1.png")));
		setTitle("EXSHE - VENTANA PRINCIPAL DE ADMINISTRACIÓN");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarPrincipal();
			}
		});
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1366, 730);
		//setDefaultCloseOperation(cerrarPrincipal());		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		
		panelConfiguracion.setBounds(879, 81, 459, 124);
		panelConfiguracion.setBorder(new TitledBorder(null, "Configuración de la Cuenta de Administrador", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		contentPane.add(panelConfiguracion);
		panelConfiguracion.setLayout(null);
		
		JPanel panel_17 = new JPanel();
		panel_17.setLayout(null);
		panel_17.setBackground(new Color(223, 223, 233));
		panel_17.setBounds(12, 28, 435, 27);
		panelConfiguracion.add(panel_17);
		
		JLabel lblNuevoEmail = new JLabel("Nuevo Email:");
		lblNuevoEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNuevoEmail.setBounds(12, 5, 104, 15);
		panel_17.add(lblNuevoEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(223, 223, 233));
		txtEmail.setBounds(118, 3, 305, 20);
		panel_17.add(txtEmail);
		
		JPanel panel_18 = new JPanel();
		panel_18.setLayout(null);
		panel_18.setBackground(new Color(223, 223, 233));
		panel_18.setBounds(12, 57, 306, 27);
		panelConfiguracion.add(panel_18);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva Contraseña:");
		lblNuevaContrasea.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNuevaContrasea.setBounds(12, 5, 140, 15);
		panel_18.add(lblNuevaContrasea);
		
		passwordNueva = new JPasswordField();
		passwordNueva.setColumns(10);
		passwordNueva.setBorder(null);
		passwordNueva.setBackground(new Color(223, 223, 233));
		passwordNueva.setBounds(156, 3, 140, 20);
		panel_18.add(passwordNueva);
		
		JPanel panel_19 = new JPanel();
		panel_19.setLayout(null);
		panel_19.setBackground(new Color(223, 223, 233));
		panel_19.setBounds(12, 86, 306, 27);
		panelConfiguracion.add(panel_19);
		
		JLabel lblConfirmeLaContrasea = new JLabel("Confirme la Contraseña:");
		lblConfirmeLaContrasea.setFont(new Font("Dialog", Font.BOLD, 13));
		lblConfirmeLaContrasea.setBounds(12, 5, 179, 15);
		panel_19.add(lblConfirmeLaContrasea);
		
		passwordConfirmada = new JPasswordField();
		passwordConfirmada.setColumns(10);
		passwordConfirmada.setBorder(null);
		passwordConfirmada.setBackground(new Color(223, 223, 233));
		passwordConfirmada.setBounds(194, 3, 102, 20);
		panel_19.add(passwordConfirmada);
		
		JButton btnAceptar = new JButton(" Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email=txtEmail.getText().toString();
				String password1=passwordNueva.getText().toString();
				String password2=passwordConfirmada.getText().toString();
				
				
				
				if (email.equals("") || password1.equals("") || password2.equals("")){
					
					
					if (password2.equals("")){
						passwordConfirmada.requestFocus();
					}
					
					
					if (password1.equals("")){	
						passwordNueva.requestFocus();
					}

					if (email.equals("")){									
						txtEmail.requestFocus();
					}
					JOptionPane.showMessageDialog(null,"Por favor complete los campos.");
				}else{	
					
					if (email.length()>6){
						
					
						if(password1.length()<6){
							JOptionPane.showMessageDialog(null,"La contraseña debe tener al menos 6 caracteres.");
							passwordNueva.setText("");
							passwordConfirmada.setText("");
							passwordNueva.requestFocus();
	
						}else{
							
							if(validarEmail(email)){
								if(password1.equals(password2)){
									
									
		
									Object [] opciones ={"Aceptar","Cancelar"};
									int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Está seguro que desea cambiar los datos de la cuenta de administrador?","Mensaje de Confirmación",
									JOptionPane.YES_NO_OPTION,
									JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
									if (eleccion == JOptionPane.YES_OPTION)
									{
										
										int resultado=Evaluador.actualizarAdministrador(email, password1);		
										limpiar();
										
										if (resultado>0){
											JOptionPane.showMessageDialog(null,"Administrador actualizado exitosamente.");
											panelConfiguracion.setVisible(false);
											try {
												cargarTabla();
											} catch (SQLException ex) {
												// TODO Auto-generated catch block
												ex.printStackTrace();
											}
											
											
										}else{
											JOptionPane.showMessageDialog(null,"No se pudo actualizar, intente usar otro email.");
											txtEmail.requestFocus();
											txtEmail.setText("");
											passwordNueva.setText("");
											passwordConfirmada.setText("");
										}
										
										
										
										
										
										
										
										
									}else{
										
									}
									
									
									
									
									
								}else{
									
									JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden.");
									passwordNueva.requestFocus();
									passwordNueva.setText("");
									passwordConfirmada.setText("");
								}
							}else{
								txtEmail.setText("");
								passwordNueva.setText("");
								passwordConfirmada.setText("");
								txtEmail.requestFocus();
							}
						}
					}else{
						JOptionPane.showMessageDialog(null,"El email debe tener al menos 6 caracteres.");
						txtEmail.requestFocus();
						txtEmail.setText("");
						passwordNueva.setText("");
						passwordConfirmada.setText("");
					}
				}
				
				
				
			}
		});
		btnAceptar.setIcon(new ImageIcon(PrincipalAdministrador.class.getResource("/img/ok.png")));
		btnAceptar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnAceptar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnAceptar.setBackground(SystemColor.controlHighlight);
		btnAceptar.setBounds(330, 86, 120, 27);
		panelConfiguracion.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(PrincipalAdministrador.class.getResource("/img/cancel.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelConfiguracion.setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCancelar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnCancelar.setBackground(SystemColor.controlHighlight);
		btnCancelar.setBounds(330, 57, 120, 27);
		panelConfiguracion.add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBounds(-1, 0, 1600, 93);
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
//		mntmAcceso.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
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
		
		JMenuItem mntmFinalizados = new JMenuItem("Resultados");
		mntmFinalizados.setIcon(new ImageIcon(PrincipalAdministrador.class.getResource("/img/proyecto3.png")));
		mntmFinalizados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InformesProyectos ip=new InformesProyectos();
				ip.show();
			}
		});
		mnEvaluaciones.add(mntmFinalizados);
		
		JMenu mnEvaluaciones_1 = new JMenu("   Evaluaciones   ");
		menuBar.add(mnEvaluaciones_1);
		
		JMenuItem mntmPendientes = new JMenuItem("Pendientes");
		mntmPendientes.setIcon(new ImageIcon(PrincipalAdministrador.class.getResource("/img/pendientes2.png")));
		mntmPendientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
					 
					 JOptionPane.showMessageDialog(null, "Abriendo reporte de evaluaciones pendientes, por favor espere un momento");
					 	//String path = new File("").getAbsolutePath()+"/src/com/reportes/evaluacionesPendientes.jrxml";
					 	String path =RutaBase.obtenerRuta()+"evaluacionesPendientes.jrxml";
					 	abrirReporte(path, "Evaluaciones pendientes", "0", "finalizada");
		               
		            
		            }catch(Exception ex){
		                JOptionPane.showMessageDialog(null,"Error al cargar el reporte: "+ex, "ERROR",JOptionPane.ERROR_MESSAGE);
		                System.out.println(ex);
		            }
			}
		});
		mnEvaluaciones_1.add(mntmPendientes);
		
		JMenuItem mntmFinalizadas = new JMenuItem("Finalizadas");
		mntmFinalizadas.setIcon(new ImageIcon(PrincipalAdministrador.class.getResource("/img/evaluaciones1.png")));
		mntmFinalizadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				 try{
					 
					 	JOptionPane.showMessageDialog(null, "Abriendo reporte de evaluaciones finalizadas, por favor espere un momento");
					 	String path =RutaBase.obtenerRuta()+"evaluacionesFinalizadas.jrxml";
					 	
					 	abrirReporte(path, "Evaluaciones finalizadas", "1", "finalizada");
					 
		               /*	               
		               
		                JasperReport rutaInforme = JasperCompileManager.compileReport("C:\\EXSHE\\reportes\\evaluacionesFinalizadas.jrxml");
		                
		                Map parametros = new HashMap();
		                parametros.put("finalizada","1");
		                JasperPrint informe=JasperFillManager.fillReport(rutaInforme,parametros,Conexion.obtenerConexion());
		                JasperViewer ventanaVisor=new JasperViewer(informe,false);
		                ventanaVisor.setTitle("INFORME DE LA EVALUACIÓN");
		                ventanaVisor.setVisible(true);*/
		                
		            
		            }catch(Exception ex){
		                JOptionPane.showMessageDialog(null,"Error al cargar el reporte: "+ex, "ERROR",JOptionPane.ERROR_MESSAGE);
		                System.out.println(ex);
		            }
				
			}
		});
		mnEvaluaciones_1.add(mntmFinalizadas);
		
		JMenu mnEvaluadores = new JMenu("Evaluadores");		
		menuBar.add(mnEvaluadores);
		
		JMenuItem mnuMantenimientoEvaluadores = new JMenuItem("Mantenimiento");
		mnuMantenimientoEvaluadores.setIcon(new ImageIcon(PrincipalAdministrador.class.getResource("/img/evaluadores2.png")));
		//mnuMantenimientoEvaluadores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
		mnuMantenimientoEvaluadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MantenimientoEvaluadores registro1=new MantenimientoEvaluadores();
				registro1.show();
				
				
			}
		});
		mnEvaluadores.add(mnuMantenimientoEvaluadores);
		
		JMenu mnConfiguracin = new JMenu("   Configuración");
		menuBar.add(mnConfiguracin);
		
		JMenuItem mntmCambiarContrasea = new JMenuItem("Cambiar Contraseña");
		mntmCambiarContrasea.setIcon(new ImageIcon(PrincipalAdministrador.class.getResource("/img/configuracion.png")));
		mntmCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelConfiguracion.setVisible(true);
				txtEmail.requestFocus();
				
			}
		});
		mnConfiguracin.add(mntmCambiarContrasea);
		
		
		JMenu mnAyuda = new JMenu("  Ayuda  ");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmVer = new JMenuItem("Ver");
		mntmVer.setIcon(new ImageIcon(PrincipalAdministrador.class.getResource("/img/help1.png")));
		mnAyuda.add(mntmVer);
		lbl_evaluador.setFont(new Font("Dialog", Font.ITALIC, 12));
		
		lbl_evaluador.setBounds(144, 71, 222, 22);
		panel.add(lbl_evaluador);
		
		JLabel lblEvaluador = new JLabel("Usuario conectado:");
		lblEvaluador.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblEvaluador.setBounds(10, 71, 137, 22);
		panel.add(lblEvaluador);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(229, 229, 229));
		panel_1.setBounds(0, 34, 1600, 31);
		panel.add(panel_1);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				  int n = JOptionPane.showConfirmDialog(
				            null,
				            "¿Está seguro que desea salir a la ventana de acceso?",
				            "Mensaje de Confirmación",
				            JOptionPane.YES_NO_OPTION);
				  	
				  		
				        if(n==0){
				        	Acceso a1=new Acceso();
							a1.show();
							//a1.setExtendedState(MAXIMIZED_BOTH);
							dispose();
				        }
				        else {
				           //No
				        }
			}
		});
		label.setIcon(new ImageIcon(PrincipalAdministrador.class.getResource("/img/home4.png")));
		label.setToolTipText("Ventana de acceso");
		label.setBounds(39, 0, 24, 31);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InformesProyectos ip=new InformesProyectos();
				ip.show();
			}
		});
		label_1.setIcon(new ImageIcon(PrincipalAdministrador.class.getResource("/img/proyecto3.png")));
		label_1.setToolTipText("Resultados de Proyectos");
		label_1.setBounds(90, 0, 24, 31);
		panel_1.add(label_1);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				 try{
					 JOptionPane.showMessageDialog(null, "Abriendo reporte de evaluaciones finalizadas, por favor espere un momento");
					 String path =RutaBase.obtenerRuta()+"evaluacionesFinalizadas.jrxml";  
					
					 abrirReporte(path, "Evaluaciones finalizadas", "1", "finalizada");
		                
		            
		            }catch(Exception ex){
		                JOptionPane.showMessageDialog(null,"Error al cargar el reporte: "+ex, "ERROR",JOptionPane.ERROR_MESSAGE);
		                System.out.println(ex);
		            }
				
			}
		});
		label_4.setIcon(new ImageIcon(PrincipalAdministrador.class.getResource("/img/evaluaciones1.png")));
		label_4.setToolTipText("Ver informe de evaluaciones finalizadas");
		label_4.setBounds(146, 0, 24, 31);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MantenimientoEvaluadores registro1=new MantenimientoEvaluadores();
				registro1.show();
			}
		});
		label_5.setIcon(new ImageIcon(PrincipalAdministrador.class.getResource("/img/evaluadores2.png")));
		label_5.setToolTipText("Mantenimiento de evaluadores");
		label_5.setBounds(236, 0, 24, 31);
		panel_1.add(label_5);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(126, 0, 2, 31);
		panel_1.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(70, 0, 2, 31);
		panel_1.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(266, 0, 2, 31);
		panel_1.add(panel_14);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(PrincipalAdministrador.class.getResource("/img/help1.png")));
		label_6.setToolTipText("Ayuda");
		label_6.setBounds(320, 0, 24, 31);
		panel_1.add(label_6);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(216, 0, 2, 31);
		panel_1.add(panel_15);
		
		JLabel label_7 = new JLabel("");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				 try{
					 JOptionPane.showMessageDialog(null, "Abriendo reporte de evaluaciones pendientes, por favor espere un momento");
					 String path =RutaBase.obtenerRuta()+"evaluacionesPendientes.jrxml";
					 
					 	abrirReporte(path, "Evaluaciones Pendientes", "0", "finalizada");
		                
		            
		            }catch(Exception ex){
		                JOptionPane.showMessageDialog(null,"Error al cargar el reporte: "+ex, "ERROR",JOptionPane.ERROR_MESSAGE);
		                System.out.println(ex);
		            }
			}
		});
		label_7.setIcon(new ImageIcon(PrincipalAdministrador.class.getResource("/img/pendientes2.png")));
		label_7.setToolTipText("Ver informe de evaluaciones pendientes");
		label_7.setBounds(182, 0, 24, 31);
		panel_1.add(label_7);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBounds(309, 0, 2, 31);
		panel_1.add(panel_16);
		
		JLabel label_8 = new JLabel("");
		label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelConfiguracion.setVisible(true);
				txtEmail.requestFocus();
			}
		});
		label_8.setIcon(new ImageIcon(PrincipalAdministrador.class.getResource("/img/configuracion.png")));
		label_8.setBounds(280, 0, 24, 31);
		panel_1.add(label_8);
		label_8.setToolTipText("Cambiar Contraseña");
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(223, 223, 233));
		panel_2.setBounds(481, 105, 386, 77);
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
		panel_8.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registro de Proyectos", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_8.setBounds(42, 213, 567, 468);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(223, 223, 233));
		panel_3.setBounds(37, 34, 495, 27);
		panel_8.add(panel_3);
		
		JLabel lblNombreDelSitio = new JLabel("Nombre del Sitio a Evaluar:");
		lblNombreDelSitio.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombreDelSitio.setBounds(12, 5, 175, 15);
		panel_3.add(lblNombreDelSitio);
		
		txt_nombre = new JTextField();
		txt_nombre.setColumns(10);
		txt_nombre.setBorder(null);
		txt_nombre.setBackground(new Color(223, 223, 233));
		txt_nombre.setBounds(171, 3, 312, 20);
		panel_3.add(txt_nombre);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(223, 223, 233));
		panel_4.setBounds(37, 91, 495, 27);
		panel_8.add(panel_4);
		
		JLabel lblUrlDelSitio = new JLabel("Url del Sitio:");
		lblUrlDelSitio.setFont(new Font("Dialog", Font.BOLD, 12));
		lblUrlDelSitio.setBounds(12, 5, 74, 15);
		panel_4.add(lblUrlDelSitio);
		
		txt_url = new JTextField();
		txt_url.setColumns(10);
		txt_url.setBorder(null);
		txt_url.setBackground(new Color(223, 223, 233));
		txt_url.setBounds(96, 3, 387, 20);
		panel_4.add(txt_url);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(223, 223, 233));
		panel_5.setBounds(37, 143, 495, 32);
		panel_8.add(panel_5);
		
		JLabel lblTipoDeSitio = new JLabel("Tipo de Sitio:");
		lblTipoDeSitio.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTipoDeSitio.setBounds(11, 9, 78, 15);
		panel_5.add(lblTipoDeSitio);
		
		txt_tipo = new JComboBox();
		txt_tipo.setFont(new Font("Dialog", Font.PLAIN, 12));
		txt_tipo.setModel(new DefaultComboBoxModel(new String[] {"Por favor seleccione una opción", "Administración Pública / Institucional", "Banca electrónica", "Blog", "Comercio electrónico", "Comunicación / Noticias", "Corporativo / Empresas", "Descargas", "Educativo / Formativo", "Entornos colaborativos / Wikis", "Foros / Chat", "Ocio / Entretenimiento", "Personal", "Portal de Servicios", "Servicios interactivos basados en imágenes", "Servicios interactivos no basados en imágenes", "Webmail / Correo"}));
		txt_tipo.setForeground(new Color(51, 51, 51));
		txt_tipo.setBorder(null);
		txt_tipo.setBackground(UIManager.getColor(new Color(223, 223, 233)));
		txt_tipo.setBounds(99, 5, 384, 23);
		panel_5.add(txt_tipo);
		
		final JButton btnGuardar = new JButton("  Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
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
		btnGuardar.setBounds(404, 418, 128, 38);
		panel_8.add(btnGuardar);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(223, 223, 233));
		panel_6.setBounds(37, 201, 495, 32);
		panel_8.add(panel_6);
		
		JLabel lblEvaluador_1 = new JLabel("Evaluador 1:");
		lblEvaluador_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblEvaluador_1.setBounds(11, 9, 76, 15);
		panel_6.add(lblEvaluador_1);
		
		txt_evaluador1 = new JComboBox();
		txt_evaluador1.setFont(new Font("Dialog", Font.PLAIN, 12));
		txt_evaluador1.setModel(new DefaultComboBoxModel(new String[] {"Por favor seleccione una opción"}));
		txt_evaluador1.setForeground(UIManager.getColor("Button.foreground"));
		txt_evaluador1.setBorder(null);
		txt_evaluador1.setBackground((Color) null);
		txt_evaluador1.setBounds(97, 5, 386, 23);
		panel_6.add(txt_evaluador1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(223, 223, 233));
		panel_7.setBounds(37, 264, 495, 32);
		panel_8.add(panel_7);
		
		JLabel lblEvaluador_2 = new JLabel("Evaluador 2:");
		lblEvaluador_2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblEvaluador_2.setBounds(11, 9, 75, 15);
		panel_7.add(lblEvaluador_2);
		
		txt_evaluador2 = new JComboBox();
		txt_evaluador2.setFont(new Font("Dialog", Font.PLAIN, 12));
		txt_evaluador2.setModel(new DefaultComboBoxModel(new String[] {"Por favor seleccione una opción"}));
		txt_evaluador2.setForeground(UIManager.getColor("Button.foreground"));
		txt_evaluador2.setBorder(null);
		txt_evaluador2.setBackground((Color) null);
		txt_evaluador2.setBounds(96, 5, 387, 23);
		panel_7.add(txt_evaluador2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(223, 223, 233));
		panel_9.setBounds(37, 321, 495, 32);
		panel_8.add(panel_9);
		
		JLabel lblEvaluador_3 = new JLabel("Evaluador 3:");
		lblEvaluador_3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblEvaluador_3.setBounds(11, 9, 74, 15);
		panel_9.add(lblEvaluador_3);
		
		txt_evaluador3 = new JComboBox();
		txt_evaluador3.setFont(new Font("Dialog", Font.PLAIN, 12));
		txt_evaluador3.setModel(new DefaultComboBoxModel(new String[] {"Por favor seleccione una opción"}));
		txt_evaluador3.setForeground(UIManager.getColor("Button.foreground"));
		txt_evaluador3.setBorder(null);
		txt_evaluador3.setBackground((Color) null);
		txt_evaluador3.setBounds(95, 5, 388, 23);
		panel_9.add(txt_evaluador3);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(223, 223, 233));
		panel_10.setBounds(37, 380, 495, 32);
		panel_8.add(panel_10);
		
		JLabel lblEvaluador_4 = new JLabel("Evaluador 4:");
		lblEvaluador_4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblEvaluador_4.setBounds(11, 9, 77, 15);
		panel_10.add(lblEvaluador_4);
		
		txt_evaluador4 = new JComboBox();
		txt_evaluador4.setFont(new Font("Dialog", Font.PLAIN, 12));
		txt_evaluador4.setModel(new DefaultComboBoxModel(new String[] {"Por favor seleccione una opción"}));
		txt_evaluador4.setForeground(UIManager.getColor("Button.foreground"));
		txt_evaluador4.setBorder(null);
		txt_evaluador4.setBackground((Color) null);
		txt_evaluador4.setBounds(98, 5, 385, 23);
		panel_10.add(txt_evaluador4);
		
		final JButton Refrescar = new JButton("  Refrescar Datos");
		Refrescar.setFont(new Font("Tahoma", Font.BOLD, 11));
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
		Refrescar.setBounds(185, 418, 195, 38);
		panel_8.add(Refrescar);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBorder(new TitledBorder(null, "Proyectos Recientes", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_11.setBounds(614, 213, 724, 468);
		contentPane.add(panel_11);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 34, 684, 422);
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
		
		panelConfiguracion.setVisible(false);
	}
	
	
	public void cerrarPrincipal(){
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
		tbl_proyectos.setRowHeight(16);
		tbl_proyectos.setForeground(new Color(0,0,0));
		tbl_proyectos.setFont(new Font("Dialog", Font.PLAIN, 12));
		tbl_proyectos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//tbl_subheuristicos.getTableHeader().setBackground(new Color(9,125,209));
		//tbl_subheuristicos.getTableHeader().setForeground(new Color(255,255,255));
		tbl_proyectos.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 13));
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(0);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(0).setResizable(false);
		
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(0);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(1).setResizable(false);
		
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(150);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(150);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(150);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(80);
		tbl_proyectos.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(150);
		
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		

		tbl_proyectos.getColumnModel().getColumn(0).setCellRenderer(tcr);
				
		tbl_proyectos.getColumnModel().getColumn(2).setCellRenderer(tcr);
		tbl_proyectos.getColumnModel().getColumn(3).setCellRenderer(tcr);
		tbl_proyectos.getColumnModel().getColumn(4).setCellRenderer(tcr);
		tbl_proyectos.getColumnModel().getColumn(5).setCellRenderer(tcr);
		tbl_proyectos.getColumnModel().getColumn(6).setCellRenderer(tcr);
	}
	
	
	
	public  void resaltar(JButton btn){
		btn.setBackground(new Color(200,200,200));
		
	}
	
	public  void noResaltar(JButton btn){
		btn.setBackground(new Color(230,230,230));
		
	}
	public void abrirReporte(String path, String titulo, String parametro,String valorParametro){
		 try{
             
             //String rutaInforme="\\reportes\\reporteEvaluador.jasper";
            
             JasperReport report = JasperCompileManager.compileReport(path);
             
             Map parametros = new HashMap();
             parametros.put(valorParametro,parametro);
             JasperPrint informe=JasperFillManager.fillReport(report,parametros,Conexion.obtenerConexion());
             JasperViewer ventanaVisor=new JasperViewer(informe,false);
             ventanaVisor.setTitle(titulo);
             ventanaVisor.setVisible(true);
             
         
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null,"Error al cargar el reporte: "+ex, "ERROR",JOptionPane.ERROR_MESSAGE);
             System.out.println(ex);
         }
	}
	
	
	
	public boolean validarEmail(String email){
		
		  Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	       Matcher mat = pat.matcher(email);
	       if(mat.find()){
	          return true;
	       }else{
	          JOptionPane.showMessageDialog(null,"Formato de email incorrecto", "Advertencia",JOptionPane.ERROR_MESSAGE);
	          return false;
	     }
	}
}


