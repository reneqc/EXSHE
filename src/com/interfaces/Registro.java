package com.interfaces;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(223, 223, 233));
		panel.setBounds(97, 59, 365, 78);
		contentPane.add(panel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Registro.class.getResource("/img/user.png")));
		label_1.setBounds(12, 12, 50, 54);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Expert System of Heuristic Evaluation");
		label_2.setFont(new Font("Dialog", Font.BOLD, 13));
		label_2.setBounds(75, 12, 278, 15);
		panel.add(label_2);
		
		JLabel lblRegistro = new JLabel("Registro de Usuarios");
		lblRegistro.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblRegistro.setBounds(74, 39, 278, 27);
		panel.add(lblRegistro);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Registro.class.getResource("/img/textura.png")));
		label.setBounds(-20, 0, 580, 107);
		contentPane.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(223, 223, 233));
		panel_1.setBounds(44, 163, 447, 27);
		contentPane.add(panel_1);
		
		JLabel lblNombre = new JLabel("Ingrese su Nombre:");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNombre.setBounds(42, 5, 152, 15);
		panel_1.add(lblNombre);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(223, 223, 233));
		textField.setBounds(202, 3, 245, 20);
		panel_1.add(textField);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(223, 223, 233));
		panel_2.setBounds(44, 215, 447, 27);
		contentPane.add(panel_2);
		
		JLabel lblApellido = new JLabel("Ingrese su Apellido:");
		lblApellido.setFont(new Font("Dialog", Font.BOLD, 13));
		lblApellido.setBounds(44, 5, 153, 15);
		panel_2.add(lblApellido);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(223, 223, 233));
		textField_1.setBounds(202, 3, 245, 20);
		panel_2.add(textField_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(223, 223, 233));
		panel_3.setBounds(44, 269, 447, 27);
		contentPane.add(panel_3);
		
		JLabel lblUsuario = new JLabel("Indique su Usuario:");
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 13));
		lblUsuario.setBounds(49, 5, 149, 15);
		panel_3.add(lblUsuario);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(223, 223, 233));
		textField_2.setBounds(200, 3, 245, 20);
		panel_3.add(textField_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(223, 223, 233));
		panel_4.setBounds(44, 319, 447, 27);
		contentPane.add(panel_4);
		
		JLabel lblIngreseSuContrasea = new JLabel("Escriba una Contraseña:");
		lblIngreseSuContrasea.setFont(new Font("Dialog", Font.BOLD, 13));
		lblIngreseSuContrasea.setBounds(12, 5, 180, 15);
		panel_4.add(lblIngreseSuContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBorder(null);
		passwordField.setBackground(new Color(223, 223, 233));
		passwordField.setBounds(199, 3, 245, 20);
		panel_4.add(passwordField);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(223, 223, 233));
		panel_5.setBounds(44, 372, 447, 27);
		contentPane.add(panel_5);
		
		JLabel lblRepitaLaContrasea = new JLabel("Confirme la Contraseña:");
		lblRepitaLaContrasea.setFont(new Font("Dialog", Font.BOLD, 13));
		lblRepitaLaContrasea.setBounds(12, 5, 187, 15);
		panel_5.add(lblRepitaLaContrasea);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setColumns(10);
		passwordField_1.setBorder(null);
		passwordField_1.setBackground(new Color(223, 223, 233));
		passwordField_1.setBounds(202, 3, 245, 20);
		panel_5.add(passwordField_1);
		
		final JButton btnIngresar = new JButton("  Guardar");
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
		
		final JButton btnCancelar = new JButton("Cancelar");
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
}
