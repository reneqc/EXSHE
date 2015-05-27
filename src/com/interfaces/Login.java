package com.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(223,223,233));
		panel.setBounds(105, 64, 365, 78);
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
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/img/textura.png")));
		lblNewLabel.setBounds(-10, 0, 580, 107);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(223, 223, 233));
		panel_1.setBounds(105, 172, 365, 27);
		contentPane.add(panel_1);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 13));
		lblUsuario.setBounds(40, 5, 69, 15);
		panel_1.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(new Color(223, 223, 233));
		txtUsuario.setBounds(115, 3, 245, 20);
		panel_1.add(txtUsuario);
		txtUsuario.setBorder(null);
		txtUsuario.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(223, 223, 233));
		panel_2.setBounds(105, 224, 365, 27);
		contentPane.add(panel_2);
		
		JLabel lblContrase = new JLabel("Contraseña:");
		lblContrase.setFont(new Font("Dialog", Font.BOLD, 13));
		lblContrase.setBounds(10, 5, 89, 15);
		panel_2.add(lblContrase);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBorder(null);
		txtPassword.setBackground(new Color(223, 223, 233));
		txtPassword.setBounds(111, 4, 245, 20);
		panel_2.add(txtPassword);
		
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
		btnIngresar.setBounds(353, 279, 117, 38);
		btnIngresar.setBorder(null);
		btnIngresar.setBackground(new Color(230,230,230));
		contentPane.add(btnIngresar);
		
		final JButton btnCancelar = new JButton("  Cancelar");
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
		btnCancelar.setBounds(224, 279, 117, 38);
		contentPane.add(btnCancelar);
	}
	
	public static void resaltar(JButton btn){
		btn.setBackground(new Color(200,200,200));
		
	}
	
	public static void noResaltar(JButton btn){
		btn.setBackground(new Color(230,230,230));
		
	}
	
	public void ingresar(){
		JOptionPane.showMessageDialog(null, txtPassword.getText());
	}

}
