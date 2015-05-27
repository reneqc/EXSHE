package com.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.UIManager;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152, 864);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-1, 0, 1135, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(-2, 0, 1137, 49);
		panel.add(menuBar);
		
		JMenu menu = new JMenu("  ");
		menuBar.add(menu);
		
		JMenu mnInicio = new JMenu("  Inicio  ");
		menuBar.add(mnInicio);
		
		JMenu mnEvaluaciones = new JMenu("  Evaluaciones  ");
		menuBar.add(mnEvaluaciones);
		
		JMenu mnOpciones = new JMenu("  Opciones  ");
		menuBar.add(mnOpciones);
		
		JMenu mnHeursticas = new JMenu("  Heurísticas  ");
		menuBar.add(mnHeursticas);
		
		JMenu mnAyuda = new JMenu("  Ayuda  ");
		menuBar.add(mnAyuda);
	}
}
