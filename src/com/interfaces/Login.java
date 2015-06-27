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
import javax.swing.border.EmptyBorder;

import com.persistencia.Evaluador;

public class Login extends JFrame {

	private JPanel contentPane;
	public JTextField txt_email;
	public JPasswordField txt_password;
	Evaluador evaluador=new Evaluador();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setTitle("EXSHE - LOGIN");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarLogin();
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 550, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(223,223,233));
		panel.setBounds(105, 32, 365, 78);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/img/user.png")));
		label.setBounds(12, 12, 50, 54);
		panel.add(label);
		
		JLabel lblExpertSystemOf = new JLabel("Expert System of Heuristic Evaluation");
		lblExpertSystemOf.setFont(new Font("Dialog", Font.BOLD, 13));
		lblExpertSystemOf.setBounds(75, 12, 278, 15);
		panel.add(lblExpertSystemOf);
		
		JLabel lblInicioDeSesi = new JLabel("Inicio de Sesión");
		lblInicioDeSesi.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblInicioDeSesi.setBounds(74, 39, 278, 15);
		panel.add(lblInicioDeSesi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(223, 223, 233));
		panel_1.setBounds(105, 152, 365, 27);
		contentPane.add(panel_1);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 13));
		lblUsuario.setBounds(40, 5, 69, 15);
		panel_1.add(lblUsuario);
		
		txt_email = new JTextField();
		txt_email.setBackground(new Color(223, 223, 233));
		txt_email.setBounds(115, 3, 245, 20);
		panel_1.add(txt_email);
		txt_email.setBorder(null);
		txt_email.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(223, 223, 233));
		panel_2.setBounds(105, 204, 365, 27);
		contentPane.add(panel_2);
		
		JLabel lblContrase = new JLabel("Contraseña:");
		lblContrase.setFont(new Font("Dialog", Font.BOLD, 13));
		lblContrase.setBounds(10, 5, 89, 15);
		panel_2.add(lblContrase);
		
		txt_password = new JPasswordField();
		txt_password.setColumns(10);
		txt_password.setBorder(null);
		txt_password.setBackground(new Color(223, 223, 233));
		txt_password.setBounds(111, 4, 245, 20);
		panel_2.add(txt_password);
		
		final JButton btnIngresar = new JButton("  Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresar();
			}
		});
		btnIngresar.setIcon(new ImageIcon(Login.class.getResource("/img/entrar.png")));
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
		btnIngresar.setBounds(353, 259, 117, 38);
		btnIngresar.setBorder(null);
		btnIngresar.setBackground(new Color(230,230,230));
		contentPane.add(btnIngresar);
		
		final JButton btnCancelar = new JButton("  Volver");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acceso acceso=new Acceso();
				acceso.setExtendedState(MAXIMIZED_BOTH);
				acceso.show();
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
		btnCancelar.setIcon(new ImageIcon(Login.class.getResource("/img/close.png")));
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(SystemColor.controlHighlight);
		btnCancelar.setBounds(224, 259, 117, 38);
		contentPane.add(btnCancelar);
	}
	
	public static void resaltar(JButton btn){
		btn.setBackground(new Color(200,200,200));
		
	}
	
	public static void noResaltar(JButton btn){
		btn.setBackground(new Color(230,230,230));
		
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
	
	public int cerrar(){
		return 1;
	}
	
	public void cerrarLogin(){
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
