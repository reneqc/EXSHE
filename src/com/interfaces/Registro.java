package com.interfaces;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

import com.persistencia.Evaluador;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField txt_nombre;
	private JTextField txt_apellido;
	private JTextField txt_username;
	private JPasswordField txt_password;
	private JPasswordField txt_passwordR;
	Evaluador evaluador;
	static Registro frame = new Registro();

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
		setBounds(100, 100, 560, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(223, 223, 233));
		panel.setBounds(95, 22, 365, 78);
		contentPane.add(panel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Registro.class.getResource("/img/user.png")));
		label_1.setBounds(12, 12, 50, 54);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Expert System of Heuristic Evaluation");
		label_2.setFont(new Font("Dialog", Font.BOLD, 13));
		label_2.setBounds(75, 12, 278, 15);
		panel.add(label_2);
		
		JLabel lblRegistro = new JLabel("Registro de Evaluadores");
		lblRegistro.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblRegistro.setBounds(74, 39, 278, 27);
		panel.add(lblRegistro);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(223, 223, 233));
		panel_1.setBounds(44, 163, 447, 27);
		contentPane.add(panel_1);
		
		JLabel lblNombre = new JLabel("Ingrese su Nombre:");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNombre.setBounds(42, 5, 152, 15);
		panel_1.add(lblNombre);
		
		txt_nombre = new JTextField();
		txt_nombre.setColumns(10);
		txt_nombre.setBorder(null);
		txt_nombre.setBackground(new Color(223, 223, 233));
		txt_nombre.setBounds(202, 3, 245, 20);
		panel_1.add(txt_nombre);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(223, 223, 233));
		panel_2.setBounds(44, 215, 447, 27);
		contentPane.add(panel_2);
		
		JLabel lblApellido = new JLabel("Ingrese su Apellido:");
		lblApellido.setFont(new Font("Dialog", Font.BOLD, 13));
		lblApellido.setBounds(44, 5, 153, 15);
		panel_2.add(lblApellido);
		
		txt_apellido = new JTextField();
		txt_apellido.setColumns(10);
		txt_apellido.setBorder(null);
		txt_apellido.setBackground(new Color(223, 223, 233));
		txt_apellido.setBounds(202, 3, 245, 20);
		panel_2.add(txt_apellido);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(223, 223, 233));
		panel_3.setBounds(44, 269, 447, 27);
		contentPane.add(panel_3);
		
		JLabel lblUsuario = new JLabel("Indique su Usuario:");
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 13));
		lblUsuario.setBounds(49, 5, 149, 15);
		panel_3.add(lblUsuario);
		
		txt_username = new JTextField();
		txt_username.setColumns(10);
		txt_username.setBorder(null);
		txt_username.setBackground(new Color(223, 223, 233));
		txt_username.setBounds(200, 3, 245, 20);
		panel_3.add(txt_username);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(223, 223, 233));
		panel_4.setBounds(44, 319, 447, 27);
		contentPane.add(panel_4);
		
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
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(223, 223, 233));
		panel_5.setBounds(44, 372, 447, 27);
		contentPane.add(panel_5);
		
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
		
		final JButton btnIngresar = new JButton("  Guardar");
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
		btnIngresar.setBounds(375, 425, 117, 38);
		contentPane.add(btnIngresar);
		
		final JButton btnCancelar = new JButton("Volver");
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
		btnCancelar.setBounds(229, 425, 117, 38);
		contentPane.add(btnCancelar);
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
