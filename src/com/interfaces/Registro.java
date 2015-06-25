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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.persistencia.Evaluador;


public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField txt_nombre;
	private JTextField txt_apellido;
	private JTextField txt_username;
	private JPasswordField txt_password;
	private JPasswordField txt_passwordR;
	Evaluador evaluador;
	static Registro frame = new Registro();
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;
	private JPasswordField passwordField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	public Registro() {
		setResizable(false);
		setTitle("EXSHE - REGISTRO");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarRegistro();
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setDefaultCloseOperation(cerrar());
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contenedor_registro = new JPanel();
		contenedor_registro.setBorder(new TitledBorder(null, "Registro de Evaluadores", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		contenedor_registro.setToolTipText("Registro de Evaluadores");
		contenedor_registro.setBounds(27, 118, 918, 604);
		
		contentPane.add(contenedor_registro);
		contenedor_registro.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(23, 31, 422, 27);
		contenedor_registro.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(223, 223, 233));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNombre.setBounds(12, 5, 73, 15);
		panel_1.add(lblNombre);
		
		txt_nombre = new JTextField();
		txt_nombre.setColumns(10);
		txt_nombre.setBorder(null);
		txt_nombre.setBackground(new Color(223, 223, 233));
		txt_nombre.setBounds(91, 3, 319, 20);
		panel_1.add(txt_nombre);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(23, 80, 422, 27);
		contenedor_registro.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(223, 223, 233));
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Dialog", Font.BOLD, 13));
		lblApellido.setBounds(12, 5, 70, 15);
		panel_2.add(lblApellido);
		
		txt_apellido = new JTextField();
		txt_apellido.setColumns(10);
		txt_apellido.setBorder(null);
		txt_apellido.setBackground(new Color(223, 223, 233));
		txt_apellido.setBounds(92, 3, 245, 20);
		panel_2.add(txt_apellido);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(23, 132, 422, 27);
		contenedor_registro.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(223, 223, 233));
		
		JLabel lblUsuario = new JLabel("Email:");
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 13));
		lblUsuario.setBounds(33, 5, 45, 15);
		panel_3.add(lblUsuario);
		
		txt_username = new JTextField();
		txt_username.setColumns(10);
		txt_username.setBorder(null);
		txt_username.setBackground(new Color(223, 223, 233));
		txt_username.setBounds(145, 3, 213, 20);
		panel_3.add(txt_username);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(23, 459, 447, 27);
		contenedor_registro.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(223, 223, 233));
		
		JLabel lblIngreseSuContrasea = new JLabel("Escriba una Contraseña:");
		lblIngreseSuContrasea.setFont(new Font("Dialog", Font.BOLD, 13));
		lblIngreseSuContrasea.setBounds(12, 5, 180, 15);
		panel_4.add(lblIngreseSuContrasea);
		
		txt_password = new JPasswordField();
		txt_password.setColumns(10);
		txt_password.setBorder(null);
		txt_password.setBackground(new Color(223, 223, 233));
		txt_password.setBounds(199, 3, 245, 20);
		panel_4.add(txt_password);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(23, 512, 447, 27);
		contenedor_registro.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(223, 223, 233));
		
		JLabel lblRepitaLaContrasea = new JLabel("Confirme la Contraseña:");
		lblRepitaLaContrasea.setFont(new Font("Dialog", Font.BOLD, 13));
		lblRepitaLaContrasea.setBounds(12, 5, 187, 15);
		panel_5.add(lblRepitaLaContrasea);
		
		txt_passwordR = new JPasswordField();
		txt_passwordR.setColumns(10);
		txt_passwordR.setBorder(null);
		txt_passwordR.setBackground(new Color(223, 223, 233));
		txt_passwordR.setBounds(202, 3, 245, 20);
		panel_5.add(txt_passwordR);
		
		final JButton btnCancelar = new JButton("Volver");
		btnCancelar.setBounds(200, 554, 117, 38);
		contenedor_registro.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acceso acceso=new Acceso();
				acceso.show();
				acceso.setExtendedState(MAXIMIZED_BOTH);
				dispose();
				
			}
		});
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				resaltar(btnCancelar);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				noResaltar(btnCancelar);
			}
		});
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(SystemColor.controlHighlight);
		
		final JButton btnIngresar = new JButton("  Guardar");
		btnIngresar.setBounds(353, 554, 117, 38);
		contenedor_registro.add(btnIngresar);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nom=txt_nombre.getText();
				String ape=txt_apellido.getText();
				String pass1=txt_password.getText();
				String pass2=txt_passwordR.getText();	
				String user=txt_username.getText();
				
				
				if (nom.equals("") || ape.equals("") || user.equals("") || pass1.equals("") || pass2.equals("")){
					
					
					if (pass2.equals("")){
						txt_passwordR.requestFocus();
					}
					
					
					if (pass1.equals("")){	
						txt_password.requestFocus();
					}

					if (user.equals("")){									
						txt_username.requestFocus();
					}
					
					if (ape.equals("")){									
						txt_apellido.requestFocus();
					}
					
					if(nom.equals("") ){						
						txt_nombre.requestFocus();
					}
					
					JOptionPane.showMessageDialog(null,"Por favor complete los campos.");
				}else{	
					
					if (user.length()>6){
						
					
						if(pass1.length()<6){
							JOptionPane.showMessageDialog(null,"La contraseña debe tener al menos 6 caracteres.");
							txt_password.setText("");
							txt_passwordR.setText("");
							txt_password.requestFocus();
	
						}else{
							
							if(pass1.equals(pass2)){
								
								//Guardar Evaluador
								evaluador=new Evaluador(nom, ape, pass1, user);
								int resultado=evaluador.guardar();
								
								if (resultado>0){
									JOptionPane.showMessageDialog(null,"Evaluador guardado exitosamente. Ya puede iniciar sesión");
									dispose();
									Login login=new Login();
									login.txt_username.setText(user);
									login.txt_password.requestFocus();
									login.show();
									
								}else{
									JOptionPane.showMessageDialog(null,"No se pudo guardar, intente usar otro username.");
									txt_username.requestFocus();
									txt_username.setText("");
									txt_password.setText("");
									txt_passwordR.setText("");
								}
								
								
							}else{
								
								JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden.");
								txt_password.requestFocus();
								txt_password.setText("");
								txt_passwordR.setText("");
							}
						}
					}else{
						JOptionPane.showMessageDialog(null,"El username debe tener al menos 6 caracteres.");
						txt_username.requestFocus();
						txt_username.setText("");
						txt_password.setText("");
						txt_passwordR.setText("");
					}
				}
				
	
			}
		});
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				resaltar(btnIngresar);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				noResaltar(btnIngresar);
			}
		});
		btnIngresar.setBorder(null);
		btnIngresar.setBackground(SystemColor.controlHighlight);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(223, 223, 233));
		panel_6.setBounds(23, 242, 422, 27);
		contenedor_registro.add(panel_6);
		
		JLabel lblIndiqueLa = new JLabel("Dirección:");
		lblIndiqueLa.setFont(new Font("Dialog", Font.BOLD, 13));
		lblIndiqueLa.setBounds(12, 5, 158, 15);
		panel_6.add(lblIndiqueLa);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBorder(null);
		passwordField.setBackground(new Color(223, 223, 233));
		passwordField.setBounds(97, 3, 313, 20);
		panel_6.add(passwordField);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(223, 223, 233));
		panel_7.setBounds(23, 344, 447, 27);
		contenedor_registro.add(panel_7);
		
		JLabel lblIndiqueElCargo = new JLabel("Cargo que ocupa:");
		lblIndiqueElCargo.setFont(new Font("Dialog", Font.BOLD, 13));
		lblIndiqueElCargo.setBounds(12, 5, 132, 15);
		panel_7.add(lblIndiqueElCargo);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setColumns(10);
		passwordField_1.setBorder(null);
		passwordField_1.setBackground(new Color(223, 223, 233));
		passwordField_1.setBounds(239, 3, 208, 20);
		panel_7.add(passwordField_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(223, 223, 233));
		panel_8.setBounds(23, 305, 371, 27);
		contenedor_registro.add(panel_8);
		
		JLabel lblIndiqueLaProfesin = new JLabel("Indique la profesión:");
		lblIndiqueLaProfesin.setFont(new Font("Dialog", Font.BOLD, 13));
		lblIndiqueLaProfesin.setBounds(12, 5, 208, 15);
		panel_8.add(lblIndiqueLaProfesin);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setColumns(10);
		passwordField_2.setBorder(null);
		passwordField_2.setBackground(new Color(223, 223, 233));
		passwordField_2.setBounds(172, 3, 187, 20);
		panel_8.add(passwordField_2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(223, 223, 233));
		panel_9.setBounds(23, 181, 294, 27);
		contenedor_registro.add(panel_9);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTelfono.setBounds(12, 5, 180, 15);
		panel_9.add(lblTelfono);
		
		passwordField_3 = new JPasswordField();
		passwordField_3.setColumns(10);
		passwordField_3.setBorder(null);
		passwordField_3.setBackground(new Color(223, 223, 233));
		passwordField_3.setBounds(90, 3, 192, 20);
		panel_9.add(passwordField_3);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(223, 223, 233));
		panel_10.setBounds(23, 411, 447, 27);
		contenedor_registro.add(panel_10);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEmpresa.setBounds(12, 5, 180, 15);
		panel_10.add(lblEmpresa);
		
		passwordField_4 = new JPasswordField();
		passwordField_4.setColumns(10);
		passwordField_4.setBorder(null);
		passwordField_4.setBackground(new Color(223, 223, 233));
		passwordField_4.setBounds(199, 3, 245, 20);
		panel_10.add(passwordField_4);
		
		JPanel panel = new JPanel();
		panel.setBounds(478, 12, 365, 82);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(223, 223, 233));
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Registro.class.getResource("/img/user.png")));
		label_1.setBounds(12, 12, 50, 54);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Expert System of Heuristic Evaluation");
		label_2.setFont(new Font("Dialog", Font.BOLD, 13));
		label_2.setBounds(74, 22, 278, 15);
		panel.add(label_2);
		
		JLabel lblRegistro = new JLabel("Mantenimiento de Evaluadores");
		lblRegistro.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblRegistro.setBounds(74, 39, 278, 27);
		panel.add(lblRegistro);
		this.setLocationRelativeTo(null);
	}
	
	public  void resaltar(JButton btn){
		btn.setBackground(new Color(200,200,200));
		
	}
	
	public  void noResaltar(JButton btn){
		btn.setBackground(new Color(230,230,230));
		
	}
	
	public int cerrar(){
		return 1;
	}
	
	public void cerrarRegistro(){
		Object [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Está seguro que desea cerrar la Ventana de Registro?","Mensaje de Confirmación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
		if (eleccion == JOptionPane.YES_OPTION)
		{
			dispose();
		}else{
			
		}
	}
}
