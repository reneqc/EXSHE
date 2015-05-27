package com.interfaces;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Inicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial frame = new Inicial();
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
	public Inicial() {
		setTitle("EXSHE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1158, 864);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40,40,40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(29,29,29));
		panel.setBounds(35, 30, 1082, 78);
		contentPane.add(panel);
		panel.setLayout(null);
		
		final JPanel menu1 = new JPanel();
		menu1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuAzul(menu1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuGris(menu1);
			}
		});
		menuGris(menu1);
		menu1.setForeground(Color.DARK_GRAY);
		menu1.setBounds(0, 0, 104, 78);
		panel.add(menu1);
		menu1.setLayout(null);
		
		JLabel lblInicio = new JLabel("Inicio");
		lblInicio.setFont(new Font("Dialog", Font.BOLD, 14));
		lblInicio.setForeground(Color.LIGHT_GRAY);
		lblInicio.setBounds(35, 51, 41, 15);
		menu1.add(lblInicio);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Inicial.class.getResource("/img/home.png")));
		label.setBounds(39, 0, 32, 42);
		menu1.add(label);
		//this.setExtendedState(MAXIMIZED_BOTH);
	}
	
	
	public void menuGris(JPanel panel){
		panel.setBackground(new Color(29,29,29));
	}
	
	public void menuAzul(JPanel panel){
		panel.setBackground(new Color(1,103,167));
	}
}
