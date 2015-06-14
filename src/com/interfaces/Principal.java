package com.interfaces;

import java.awt.Color;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.FramePeer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
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
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtSistemaEscolsticoUtc;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	public static Principal framePrincipal = new Principal();

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
	public Principal() {
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
		panel.setBounds(-1, 0, 1366, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1366, 36);
		panel.add(menuBar);
		
		JMenu menu = new JMenu("  ");
		menuBar.add(menu);
		
		JMenu mnInicio = new JMenu("  Inicio  ");
		menuBar.add(mnInicio);
		
		JMenu mnEvaluaciones = new JMenu("  Evaluaciones  ");
		menuBar.add(mnEvaluaciones);
		
		JMenu mnOpciones = new JMenu("  Opciones  ");
		menuBar.add(mnOpciones);
		
		JMenu mnHeursticas = new JMenu("  Heurísticos  ");
		menuBar.add(mnHeursticas);
		
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
		
		
		JMenu mnAyuda = new JMenu("  Ayuda  ");
		menuBar.add(mnAyuda);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(-1, 37, 1351, 25);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 0, 1135, 25);
		panel_1.add(menuBar_1);
		
		JMenu mnNewMenu = new JMenu("  ");
		menuBar_1.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu(" ");
		mnNewMenu_1.setIcon(new ImageIcon(Principal.class.getResource("/img/nue.png")));
		menuBar_1.add(mnNewMenu_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 244, 436, 422);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setShowGrid(false);
		table.setFont(new Font("Dialog", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Sistema Escolástico UTC              02/06/15      20:15"},
				{"Sistema Escolástico UTC              02/06/15      20:15"},
			
			},
			new String[] {
				"Evaluaciones Recientes"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(223, 223, 233));
		panel_2.setBounds(489, 82, 365, 78);
		contentPane.add(panel_2);
		
		JLabel lblLog = new JLabel("LOG");
		lblLog.setBounds(12, 12, 50, 54);
		panel_2.add(lblLog);
		
		JLabel label_2 = new JLabel("Expert System of Heuristic Evaluation");
		label_2.setFont(new Font("Dialog", Font.BOLD, 13));
		label_2.setBounds(75, 12, 278, 15);
		panel_2.add(label_2);
		
		JLabel lblBienvenido = new JLabel("VENTANA PRINCIPAL");
		lblBienvenido.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblBienvenido.setBounds(74, 39, 278, 15);
		panel_2.add(lblBienvenido);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(223, 223, 233));
		panel_3.setBounds(591, 365, 447, 27);
		contentPane.add(panel_3);
		
		JLabel lblNombreDelSisitio = new JLabel("Aplicación a Evaluar:");
		lblNombreDelSisitio.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNombreDelSisitio.setBounds(70, 5, 153, 15);
		panel_3.add(lblNombreDelSisitio);
		
		txtSistemaEscolsticoUtc = new JTextField();
		txtSistemaEscolsticoUtc.setText("Sistema Escolástico UTC");
		txtSistemaEscolsticoUtc.setColumns(10);
		txtSistemaEscolsticoUtc.setBorder(null);
		txtSistemaEscolsticoUtc.setBackground(new Color(223, 223, 233));
		txtSistemaEscolsticoUtc.setBounds(249, 3, 198, 20);
		panel_3.add(txtSistemaEscolsticoUtc);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(223, 223, 233));
		panel_4.setBounds(591, 417, 447, 70);
		contentPane.add(panel_4);
		
		JLabel lblObjetivoDeLa = new JLabel("Objetivo de la Evaluación:");
		lblObjetivoDeLa.setFont(new Font("Dialog", Font.BOLD, 13));
		lblObjetivoDeLa.setBounds(33, 5, 198, 15);
		panel_4.add(lblObjetivoDeLa);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(223, 223, 233));
		textField_1.setBounds(249, 3, 198, 55);
		panel_4.add(textField_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(223, 223, 233));
		panel_6.setBounds(591, 506, 447, 56);
		contentPane.add(panel_6);
		
		JLabel lblreasAEvaluar = new JLabel("Áreas a Evaluar:");
		lblreasAEvaluar.setFont(new Font("Dialog", Font.BOLD, 13));
		lblreasAEvaluar.setBounds(108, 5, 120, 15);
		panel_6.add(lblreasAEvaluar);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBorder(null);
		passwordField.setBackground(new Color(223, 223, 233));
		passwordField.setBounds(246, 3, 198, 41);
		panel_6.add(passwordField);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(223, 223, 233));
		panel_7.setBounds(591, 574, 447, 27);
		contentPane.add(panel_7);
		
		JLabel lblObservacin = new JLabel("Observación:");
		lblObservacin.setFont(new Font("Dialog", Font.BOLD, 13));
		lblObservacin.setBounds(128, 5, 103, 15);
		panel_7.add(lblObservacin);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setColumns(10);
		passwordField_1.setBorder(null);
		passwordField_1.setBackground(new Color(223, 223, 233));
		passwordField_1.setBounds(249, 3, 198, 20);
		panel_7.add(passwordField_1);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(SystemColor.controlHighlight);
		btnEliminar.setBounds(631, 627, 117, 38);
		contentPane.add(btnEliminar);
		
		JButton btnEvaluar = new JButton("  Evaluar");
		btnEvaluar.setBorder(null);
		btnEvaluar.setBackground(SystemColor.controlHighlight);
		btnEvaluar.setBounds(922, 627, 117, 38);
		contentPane.add(btnEvaluar);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(223, 223, 233));
		panel_5.setBounds(631, 245, 365, 78);
		contentPane.add(panel_5);
		
		JLabel lblNueva = new JLabel("NUEVA EVALUACIÓN");
		lblNueva.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNueva.setBounds(96, 28, 204, 19);
		panel_5.add(lblNueva);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBorder(null);
		btnActualizar.setBackground(SystemColor.controlHighlight);
		btnActualizar.setBounds(780, 627, 117, 38);
		contentPane.add(btnActualizar);
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
	
}
