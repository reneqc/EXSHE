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

import javax.swing.JButton;
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
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class PrincipalEvaluador extends JFrame {

	private JPanel contentPane;
	JLabel lbl_evaluador = 	new JLabel("Evaluador conectado para evaluar");
	public static PrincipalEvaluador framePrincipal = new PrincipalEvaluador();
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

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
	public PrincipalEvaluador() {
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
		panel.setBounds(-1, 0, 1600, 89);
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
		mntmAcceso.setAccelerator(
		         KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.SHIFT_MASK));
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
		
		JMenu mnEvaluaciones = new JMenu("  Evaluaciones  ");
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
		
		
		JMenu mnAyuda = new JMenu("  Ayuda  ");
		menuBar.add(mnAyuda);
		lbl_evaluador.setFont(new Font("Dialog", Font.ITALIC, 12));
		
		lbl_evaluador.setBounds(188, 58, 222, 22);
		panel.add(lbl_evaluador);
		
		JLabel lblEvaluador = new JLabel("Evaluador conectado:");
		lblEvaluador.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblEvaluador.setBounds(35, 58, 151, 22);
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
		panel_2.setBounds(478, 101, 365, 78);
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
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(390, 213, 522, 509);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(223, 223, 233));
		panel_5.setBounds(81, 12, 365, 78);
		panel_8.add(panel_5);
		
		JLabel label = new JLabel("NUEVA EVALUACIÓN");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(96, 28, 204, 19);
		panel_5.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(223, 223, 233));
		panel_3.setBounds(41, 113, 447, 27);
		panel_8.add(panel_3);
		
		JLabel label_1 = new JLabel("Aplicación a Evaluar:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 13));
		label_1.setBounds(70, 5, 153, 15);
		panel_3.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(223, 223, 233));
		textField.setBounds(249, 3, 198, 20);
		panel_3.add(textField);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(223, 223, 233));
		panel_4.setBounds(41, 168, 447, 70);
		panel_8.add(panel_4);
		
		JLabel label_3 = new JLabel("Navegador:");
		label_3.setFont(new Font("Dialog", Font.BOLD, 13));
		label_3.setBounds(33, 5, 198, 15);
		panel_4.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(223, 223, 233));
		textField_1.setBounds(249, 3, 198, 55);
		panel_4.add(textField_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(223, 223, 233));
		panel_6.setBounds(41, 277, 447, 56);
		panel_8.add(panel_6);
		
		JLabel label_4 = new JLabel("Versión del Navegador");
		label_4.setFont(new Font("Dialog", Font.BOLD, 13));
		label_4.setBounds(12, 9, 159, 28);
		panel_6.add(label_4);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBorder(null);
		passwordField.setBackground(new Color(223, 223, 233));
		passwordField.setBounds(246, 3, 198, 41);
		panel_6.add(passwordField);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(223, 223, 233));
		panel_7.setBounds(41, 375, 447, 27);
		panel_8.add(panel_7);
		
		JLabel label_5 = new JLabel("Url del Sitio");
		label_5.setFont(new Font("Dialog", Font.BOLD, 13));
		label_5.setBounds(53, 5, 103, 15);
		panel_7.add(label_5);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setColumns(10);
		passwordField_1.setBorder(null);
		passwordField_1.setBackground(new Color(223, 223, 233));
		passwordField_1.setBounds(249, 3, 198, 20);
		panel_7.add(passwordField_1);
		
		JButton button = new JButton("Actualizar");
		button.setBorder(null);
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(216, 437, 117, 38);
		panel_8.add(button);
		
		JButton button_1 = new JButton("  Evaluar");
		button_1.setBorder(null);
		button_1.setBackground(SystemColor.controlHighlight);
		button_1.setBounds(353, 437, 117, 38);
		panel_8.add(button_1);
		
		JButton button_2 = new JButton("Eliminar");
		button_2.setBorder(null);
		button_2.setBackground(SystemColor.controlHighlight);
		button_2.setBounds(55, 437, 117, 38);
		panel_8.add(button_2);
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
