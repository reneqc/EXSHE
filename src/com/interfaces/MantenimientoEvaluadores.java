package com.interfaces;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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




import com.persistencia.Evaluador;


public class MantenimientoEvaluadores extends JFrame {

	private JPanel contentPane;
	private JTextField txt_nombre;
	private JTextField txt_apellido;
	private JTextField txt_email;
	private JPasswordField txt_password;
	private JPasswordField txt_passwordR;
	Evaluador evaluador;
	static MantenimientoEvaluadores frame = new MantenimientoEvaluadores();
	private JTextField txt_direccion;
	private JTextField txt_cargo;
	private JTextField txt_profesion;
	private JTextField txt_telefono;
	private JTextField txt_empresa;
	private JTable tbl_evaluadores;
	final JButton btnActualizar;
	final JButton btnGuardar;
	
	private int id_evaluador=-1;

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
	public MantenimientoEvaluadores() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MantenimientoEvaluadores.class.getResource("/img/logo1.png")));
		setResizable(false);
		setTitle("EXSHE - MANTENIMIENTO DE EVALUADORES");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarRegistro();
			}
		});
		
		
		

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setDefaultCloseOperation(cerrar());
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		setBounds(100, 100, 1366, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contenedor_registro = new JPanel();
		contenedor_registro.setBorder(new TitledBorder(null, "Registro de Evaluadores", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		contenedor_registro.setToolTipText("Registro de Evaluadores");
		contenedor_registro.setBounds(12, 97, 1326, 226);
		
		contentPane.add(contenedor_registro);
		contenedor_registro.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(476, 43, 378, 27);
		contenedor_registro.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(223, 223, 233));
		
		JLabel lblNombre = new JLabel("Nombres:");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNombre.setBounds(12, 5, 83, 15);
		panel_1.add(lblNombre);
		
		txt_nombre = new JTextField();
		txt_nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				validarSoloLetras(e);
			}
		});
		txt_nombre.setColumns(10);
		txt_nombre.setBorder(null);
		txt_nombre.setBackground(new Color(223, 223, 233));
		txt_nombre.setBounds(100, 3, 266, 20);
		panel_1.add(txt_nombre);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(24, 43, 422, 27);
		contenedor_registro.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(223, 223, 233));
		
		JLabel lblApellido = new JLabel("Apellidos:");
		lblApellido.setFont(new Font("Dialog", Font.BOLD, 13));
		lblApellido.setBounds(12, 5, 76, 15);
		panel_2.add(lblApellido);
		
		txt_apellido = new JTextField();
		txt_apellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				validarSoloLetras(e);
				
		             
			}
		});
		txt_apellido.setColumns(10);
		txt_apellido.setBorder(null);
		txt_apellido.setBackground(new Color(223, 223, 233));
		txt_apellido.setBounds(99, 3, 311, 20);
		panel_2.add(txt_apellido);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(885, 43, 404, 27);
		contenedor_registro.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(223, 223, 233));
		
		JLabel lblUsuario = new JLabel("Email:");
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 13));
		lblUsuario.setBounds(12, 5, 45, 15);
		panel_3.add(lblUsuario);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBorder(null);
		txt_email.setBackground(new Color(223, 223, 233));
		txt_email.setBounds(55, 3, 339, 20);
		panel_3.add(txt_email);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(24, 164, 422, 27);
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
		txt_password.setBounds(171, 3, 239, 20);
		panel_4.add(txt_password);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(476, 164, 378, 27);
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
		txt_passwordR.setBounds(172, 3, 206, 20);
		panel_5.add(txt_passwordR);
		
		final JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) 
				{
					limpiar();
				}
			}
		});
		btnLimpiar.setIcon(new ImageIcon(MantenimientoEvaluadores.class.getResource("/img/clear.png")));
		btnLimpiar.setBounds(887, 153, 109, 38);
		btnLimpiar.setFocusable(false);
		contenedor_registro.add(btnLimpiar);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				limpiar();
				
				
				
			}
		});
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				resaltar(btnLimpiar);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				noResaltar(btnLimpiar);
			}
		});
		btnLimpiar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnLimpiar.setBackground(SystemColor.controlHighlight);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) 
				{
					guardar();
				}
			}
		});
		btnGuardar.setIcon(new ImageIcon(MantenimientoEvaluadores.class.getResource("/img/save.png")));
		btnGuardar.setBounds(1163, 153, 120, 38);
		contenedor_registro.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				guardar();
					
		
				
			}
		});
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
		btnGuardar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnGuardar.setBackground(SystemColor.controlHighlight);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(223, 223, 233));
		panel_6.setBounds(24, 86, 422, 27);
		contenedor_registro.add(panel_6);
		
		JLabel lblIndiqueLa = new JLabel("Dirección:");
		lblIndiqueLa.setFont(new Font("Dialog", Font.BOLD, 13));
		lblIndiqueLa.setBounds(12, 5, 80, 15);
		panel_6.add(lblIndiqueLa);
		
		txt_direccion = new JTextField();
		txt_direccion.setColumns(10);
		txt_direccion.setBorder(null);
		txt_direccion.setBackground(new Color(223, 223, 233));
		txt_direccion.setBounds(79, 3, 331, 20);
		panel_6.add(txt_direccion);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(223, 223, 233));
		panel_7.setBounds(476, 121, 378, 27);
		contenedor_registro.add(panel_7);
		
		JLabel lblIndiqueElCargo = new JLabel("Cargo que ocupa:");
		lblIndiqueElCargo.setFont(new Font("Dialog", Font.BOLD, 13));
		lblIndiqueElCargo.setBounds(12, 5, 132, 15);
		panel_7.add(lblIndiqueElCargo);
		
		txt_cargo = new JTextField();
		txt_cargo.setColumns(10);
		txt_cargo.setBorder(null);
		txt_cargo.setBackground(new Color(223, 223, 233));
		txt_cargo.setBounds(136, 3, 230, 20);
		panel_7.add(txt_cargo);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(223, 223, 233));
		panel_8.setBounds(885, 82, 404, 27);
		contenedor_registro.add(panel_8);
		
		JLabel lblIndiqueLaProfesin = new JLabel("Indique la profesión:");
		lblIndiqueLaProfesin.setFont(new Font("Dialog", Font.BOLD, 13));
		lblIndiqueLaProfesin.setBounds(12, 5, 163, 15);
		panel_8.add(lblIndiqueLaProfesin);
		
		txt_profesion = new JTextField();
		txt_profesion.setColumns(10);
		txt_profesion.setBorder(null);
		txt_profesion.setBackground(new Color(223, 223, 233));
		txt_profesion.setBounds(147, 3, 247, 20);
		panel_8.add(txt_profesion);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(223, 223, 233));
		panel_9.setBounds(476, 82, 378, 27);
		contenedor_registro.add(panel_9);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTelfono.setBounds(12, 5, 74, 15);
		panel_9.add(lblTelfono);
		
		txt_telefono = new JTextField();
		txt_telefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				  
					char c=e.getKeyChar(); 		               
		          if(!Character.isDigit(e.getKeyChar()) && !Character.isISOControl(e.getKeyChar()))
		          {
		               Toolkit.getDefaultToolkit().beep();
		               e.consume();
		               JOptionPane.showMessageDialog(null,"Este campo solo acepta números"); 
		           }
			}
		});
		txt_telefono.setColumns(10);
		txt_telefono.setBorder(null);
		txt_telefono.setBackground(new Color(223, 223, 233));
		txt_telefono.setBounds(80, 3, 286, 20);
		panel_9.add(txt_telefono);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(223, 223, 233));
		panel_10.setBounds(24, 125, 422, 27);
		contenedor_registro.add(panel_10);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEmpresa.setBounds(12, 5, 75, 15);
		panel_10.add(lblEmpresa);
		
		txt_empresa = new JTextField();
		txt_empresa.setColumns(10);
		txt_empresa.setBorder(null);
		txt_empresa.setBackground(new Color(223, 223, 233));
		txt_empresa.setBounds(76, 3, 334, 20);
		panel_10.add(txt_empresa);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) 
				{
					actualizar();
				}
			}
		});
		btnActualizar.setToolTipText("Debe seleccionar un evaluador para poder actualizar");
		btnActualizar.setIcon(new ImageIcon(MantenimientoEvaluadores.class.getResource("/img/update.png")));
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnActualizar.setBackground(new Color(230,230,230));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnActualizar.setBackground(new Color(200,200,200));
			}
		});
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			actualizar();
				
	
			}
			
		});
		btnActualizar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnActualizar.setBackground(SystemColor.controlHighlight);
		btnActualizar.setBounds(1008, 153, 143, 38);
		contenedor_registro.add(btnActualizar);
		
		JPanel panel = new JPanel();
		panel.setBounds(478, 12, 397, 62);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(223, 223, 233));
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MantenimientoEvaluadores.class.getResource("/img/usuarios.png")));
		label_1.setBounds(23, 0, 72, 58);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Expert System of Heuristic Evaluation");
		label_2.setFont(new Font("Dialog", Font.BOLD, 13));
		label_2.setBounds(107, 12, 278, 15);
		panel.add(label_2);
		
		JLabel lblRegistro = new JLabel("Mantenimiento de Evaluadores");
		lblRegistro.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblRegistro.setBounds(107, 31, 278, 27);
		panel.add(lblRegistro);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(null, "Evaluadores Registrados", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_11.setBounds(12, 337, 1326, 354);
		contentPane.add(panel_11);
		panel_11.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 24, 1290, 307);
		panel_11.add(scrollPane);
		
		tbl_evaluadores = new JTable();
		tbl_evaluadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int indice=tbl_evaluadores.getSelectedRow();
				
				txt_apellido.setText(tbl_evaluadores.getValueAt(indice,1).toString());
				txt_nombre.setText(tbl_evaluadores.getValueAt(indice,2).toString());
				txt_email.setText(tbl_evaluadores.getValueAt(indice,3).toString());
				txt_direccion.setText(tbl_evaluadores.getValueAt(indice,4).toString());
				txt_telefono.setText(tbl_evaluadores.getValueAt(indice,5).toString());
				txt_profesion.setText(tbl_evaluadores.getValueAt(indice,6).toString());
				txt_empresa.setText(tbl_evaluadores.getValueAt(indice,7).toString());
				txt_cargo.setText(tbl_evaluadores.getValueAt(indice,8).toString());
				txt_password.setText(tbl_evaluadores.getValueAt(indice,10).toString());
				txt_passwordR.setText(tbl_evaluadores.getValueAt(indice,10).toString());
				id_evaluador=Integer.parseInt(tbl_evaluadores.getValueAt(indice,0).toString());
				btnActualizar.setEnabled(true);
				btnGuardar.setEnabled(false);
				
			}
		});
		tbl_evaluadores.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Apellidos", "Nombres", "Email", "Direcci\u00F3n", "Tel\u00E9fono", "Profesi\u00F3n", "Empresa", "Cargo", "Perfil", "Password"
			}
		));
		scrollPane.setViewportView(tbl_evaluadores);
		this.setLocationRelativeTo(null);
		
		try {
			cargarTabla();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		btnActualizar.setEnabled(false);
		
		JButton button = new JButton("  Atrás");
		button.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) 
				{
					dispose();
				}
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon(MantenimientoEvaluadores.class.getResource("/img/atras1.png")));
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBorder(UIManager.getBorder("CheckBox.border"));
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(12, 11, 112, 27);
		contentPane.add(button);
		
		
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
		
			dispose();

	}
	
	
	public void cargarTabla() throws SQLException{
		ResultSet rs=Evaluador.consultarTodos();
		DefaultTableModel modelo=new DefaultTableModel();
		
		modelo.addColumn("ID");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("EMAIL");
		modelo.addColumn("DIRECCIÓN");
		modelo.addColumn("TELÉFONO");
		modelo.addColumn("PROFESIÓN");
		modelo.addColumn("EMPRESA");
		modelo.addColumn("CARGO");
		modelo.addColumn("PERFIL");
		modelo.addColumn("PASSWORD");

		while(rs.next()){		
			
				if(rs.getString(9).equals("ADMINISTRADOR")){
				
				}else{
					modelo.addRow(new String[] {rs.getString(1),rs.getString(8),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(6),rs.getString(10),rs.getString(5),rs.getString(9),rs.getString(11)});
				}
			
						
			
			
			tbl_evaluadores.setModel(modelo);
		}
		
		formatearTabla();
		
		
	}
	
	public void formatearTabla(){
		//tbl_subheuristicos.getColumnModel().getColumn(0).setPreferredWidth(1);
		//tbl_subheuristicos.setBackground(new Color(161,202,232));
		tbl_evaluadores.setRowHeight(15);
		tbl_evaluadores.setForeground(new Color(0,0,0));
		tbl_evaluadores.setFont(new Font("Dialog", Font.PLAIN, 11));
		tbl_evaluadores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//tbl_subheuristicos.getTableHeader().setBackground(new Color(9,125,209));
		//tbl_subheuristicos.getTableHeader().setForeground(new Color(255,255,255));
		tbl_evaluadores.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 12));

		
		tbl_evaluadores.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(120);
		tbl_evaluadores.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(120);
		tbl_evaluadores.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(140);
		tbl_evaluadores.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(140);
		tbl_evaluadores.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(140);
		tbl_evaluadores.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(140);
		tbl_evaluadores.getTableHeader().getColumnModel().getColumn(7).setPreferredWidth(140);
		tbl_evaluadores.getTableHeader().getColumnModel().getColumn(8).setPreferredWidth(140);
		tbl_evaluadores.getTableHeader().getColumnModel().getColumn(9).setPreferredWidth(105);
		tbl_evaluadores.getTableHeader().getColumnModel().getColumn(10).setPreferredWidth(100);
		
		tbl_evaluadores.getColumnModel().getColumn(0).setMaxWidth(0);
		tbl_evaluadores.getColumnModel().getColumn(0).setMinWidth(0);
		tbl_evaluadores.getColumnModel().getColumn(0).setPreferredWidth(0);
		tbl_evaluadores.getColumnModel().getColumn(0).setResizable(false);
		
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		tbl_evaluadores.getColumnModel().getColumn(1).setCellRenderer(tcr);
		tbl_evaluadores.getColumnModel().getColumn(2).setCellRenderer(tcr);
		tbl_evaluadores.getColumnModel().getColumn(3).setCellRenderer(tcr);
		tbl_evaluadores.getColumnModel().getColumn(4).setCellRenderer(tcr);
		tbl_evaluadores.getColumnModel().getColumn(5).setCellRenderer(tcr);
		tbl_evaluadores.getColumnModel().getColumn(6).setCellRenderer(tcr);
		tbl_evaluadores.getColumnModel().getColumn(7).setCellRenderer(tcr);
		tbl_evaluadores.getColumnModel().getColumn(8).setCellRenderer(tcr);
		tbl_evaluadores.getColumnModel().getColumn(9).setCellRenderer(tcr);
		tbl_evaluadores.getColumnModel().getColumn(10).setCellRenderer(tcr);
	}
	
	
	public void limpiar(){
		id_evaluador=-1;
		txt_nombre.setText("");
		txt_apellido.setText("");
		txt_email.setText("");
		txt_direccion.setText("");
		txt_cargo.setText("");
		txt_profesion.setText("");
		txt_telefono.setText("");
		txt_empresa.setText("");
		txt_password.setText("");
		txt_passwordR.setText("");	
		btnActualizar.setEnabled(false);
		btnGuardar.setEnabled(true);
		txt_apellido.requestFocus();
		
	}
	
	public static void validarSoloLetras(KeyEvent e){
		
		char c=e.getKeyChar(); 		
		
        if(!Character.isLetter(c) && !Character.isISOControl(c) && !Character.isSpace(c))
        {
             Toolkit.getDefaultToolkit().beep();
             e.consume();
             JOptionPane.showMessageDialog(null,"Este campo solo acepta letras"); 
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
	
	
	public void actualizar(){
		

		String nombre=txt_nombre.getText();
		String apellido=txt_apellido.getText();
		String email=txt_email.getText();
		String direccion=txt_direccion.getText();
		String cargo=txt_cargo.getText();
		String profesion=txt_profesion.getText();
		String telefono=txt_telefono.getText();
		String empresa=txt_empresa.getText();
		String pass1=txt_password.getText();
		String pass2=txt_passwordR.getText();	
		
		
		
	if(id_evaluador==-1){
		JOptionPane.showMessageDialog(null,"Por favor seleccione un evaluador");
		
	}else{
		
		if (nombre.equals("") || apellido.equals("") || email.equals("") || pass1.equals("") || pass2.equals("")){
			
			
			if (pass2.equals("")){
				txt_passwordR.requestFocus();
			}
			
			
			if (pass1.equals("")){	
				txt_password.requestFocus();
			}

			if (email.equals("")){									
				txt_email.requestFocus();
			}
			
			if (apellido.equals("")){									
				txt_apellido.requestFocus();
			}
			
			if(nombre.equals("") ){						
				txt_nombre.requestFocus();
			}
			
			JOptionPane.showMessageDialog(null,"Por favor complete los campos.");
		}else{	
			
			if (email.length()>6){
				
				if(validarEmail(email)){
					if(pass1.length()<6){
						JOptionPane.showMessageDialog(null,"La contraseña debe tener al menos 6 caracteres.");
						txt_password.setText("");
						txt_passwordR.setText("");
						txt_password.requestFocus();

					}else{
						
						if(pass1.equals(pass2)){
							
							//Guardar Evaluador
							evaluador=new Evaluador(id_evaluador,nombre,apellido,email,direccion,cargo,profesion,telefono,empresa,pass1);
							int resultado=evaluador.actualizar();	
							limpiar();
							
							if (resultado>0){
								JOptionPane.showMessageDialog(null,"Evaluador actualizado exitosamente. ");
								try {
									cargarTabla();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								
							}else{
								JOptionPane.showMessageDialog(null,"No se pudo actualizar, intente usar otro email.");
								txt_email.requestFocus();
								txt_email.setText("");
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
					txt_email.requestFocus();
				}
			}else{
				JOptionPane.showMessageDialog(null,"El email debe tener al menos 6 caracteres.");
				txt_email.requestFocus();
				txt_email.setText("");
				txt_password.setText("");
				txt_passwordR.setText("");
			}
		}
	}
	}
	
	
	
	public void guardar(){
		
		
		String nombre=txt_nombre.getText();
		String apellido=txt_apellido.getText();
		String email=txt_email.getText();
		String direccion=txt_direccion.getText();
		String cargo=txt_cargo.getText();
		String profesion=txt_profesion.getText();
		String telefono=txt_telefono.getText();
		String empresa=txt_empresa.getText();
		String pass1=txt_password.getText();
		String pass2=txt_passwordR.getText();	
		
		
		
			
		
			if (nombre.equals("") || apellido.equals("") || email.equals("") || pass1.equals("") || pass2.equals("")){
				
				
				if (pass2.equals("")){
					txt_passwordR.requestFocus();
				}
				
				
				if (pass1.equals("")){	
					txt_password.requestFocus();
				}

				if (email.equals("")){									
					txt_email.requestFocus();
				}
				
				if(nombre.equals("") ){						
					txt_nombre.requestFocus();
				}
				
				if (apellido.equals("")){									
					txt_apellido.requestFocus();
				}
				
				
				
				JOptionPane.showMessageDialog(null,"Por favor complete los campos.");
			}else{	
				
				if (email.length()>6){
					
				
					if(pass1.length()<6){
						JOptionPane.showMessageDialog(null,"La contraseña debe tener al menos 6 caracteres.");
						txt_password.setText("");
						txt_passwordR.setText("");
						txt_password.requestFocus();

					}else{
						
						if(validarEmail(email)){
							if(pass1.equals(pass2)){
								
								
									
								
								//Guardar Evaluador
								evaluador=new Evaluador(nombre,apellido,email,direccion,cargo,profesion,telefono,empresa,pass1);
								int resultado=evaluador.guardar();		
								limpiar();
								
								if (resultado>0){
									JOptionPane.showMessageDialog(null,"Evaluador guardado exitosamente. ");
									try {
										cargarTabla();
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									
								}else{
									JOptionPane.showMessageDialog(null,"No se pudo guardar, intente usar otro email.");
									txt_email.requestFocus();
									txt_email.setText("");
									txt_password.setText("");
									txt_passwordR.setText("");
								}
								
								
								
							}else{
								
								JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden.");
								txt_password.requestFocus();
								txt_password.setText("");
								txt_passwordR.setText("");
							}
						}else{
							txt_email.setText("");
							txt_password.setText("");
							txt_passwordR.setText("");
							txt_email.requestFocus();
						}
					}
				}else{
					JOptionPane.showMessageDialog(null,"El email debe tener al menos 6 caracteres.");
					txt_email.requestFocus();
					txt_email.setText("");
					txt_password.setText("");
					txt_passwordR.setText("");
				}
			}
	}
}
