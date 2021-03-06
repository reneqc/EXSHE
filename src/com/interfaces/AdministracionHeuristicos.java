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
import java.sql.ResultSet;
import java.sql.SQLException;

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
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.persistencia.Evaluador;
import com.persistencia.Heuristico;

import javax.swing.UIManager;


public class AdministracionHeuristicos extends JFrame {

	private JPanel contentPane;
	private JTextField txt_descripcion;
	private JTextField txt_nombre;
	Evaluador evaluador;
	static AdministracionHeuristicos frame = new AdministracionHeuristicos();
	private JTable tbl_heuristicos;
	final JButton btnActualizar,btnGuardar;
	private int id_heuristico=-1;

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
	public AdministracionHeuristicos() {
		setResizable(false);
		setTitle("EXSHE - ADMINISTRACIÓN DE HEURISTICOS");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarAdministracionHeuristicos();
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
		contenedor_registro.setBorder(new TitledBorder(null, "Registro de Heurísticos", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		contenedor_registro.setToolTipText("Registro de  Heurísticos");
		contenedor_registro.setBounds(12, 112, 1326, 155);
		
		contentPane.add(contenedor_registro);
		contenedor_registro.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 64, 1302, 27);
		contenedor_registro.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(223, 223, 233));
		
		JLabel lblNombre = new JLabel("Descripción:");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNombre.setBounds(12, 5, 91, 15);
		panel_1.add(lblNombre);
		
		txt_descripcion = new JTextField();
		txt_descripcion.setColumns(10);
		txt_descripcion.setBorder(null);
		txt_descripcion.setBackground(new Color(223, 223, 233));
		txt_descripcion.setBounds(114, 3, 1176, 20);
		panel_1.add(txt_descripcion);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 25, 1302, 27);
		contenedor_registro.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(223, 223, 233));
		
		JLabel lblApellido = new JLabel("Nombre del Heurístico:");
		lblApellido.setFont(new Font("Dialog", Font.BOLD, 13));
		lblApellido.setBounds(12, 5, 178, 15);
		panel_2.add(lblApellido);
		
		txt_nombre = new JTextField();
		txt_nombre.setColumns(10);
		txt_nombre.setBorder(null);
		txt_nombre.setBackground(new Color(223, 223, 233));
		txt_nombre.setBounds(189, 3, 1101, 20);
		panel_2.add(txt_nombre);
		
	    btnGuardar = new JButton("  Guardar");
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
		btnGuardar.setIcon(new ImageIcon(AdministracionHeuristicos.class.getResource("/img/save.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre=txt_nombre.getText().toString();
				String descripcion=txt_descripcion.getText().toString();
				
				if(nombre.equals("") || descripcion.equals("")){
					JOptionPane.showMessageDialog(null, "Por favor complete los campos");
					txt_descripcion.requestFocus();
					txt_nombre.requestFocus();
				}else{
				
					Heuristico heuristico=new Heuristico(nombre,descripcion);
					
					if(heuristico.guardar()>0){
						JOptionPane.showMessageDialog(null, "Heurístico guardado exitosamente");
						limpiar();
						try {
							cargarTabla();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else{
						JOptionPane.showMessageDialog(null, "Error al guardar");
					}
				}
			}
		});
		btnGuardar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnGuardar.setBackground(SystemColor.controlHighlight);
		btnGuardar.setBounds(1167, 105, 134, 38);
		contenedor_registro.add(btnGuardar);
		
		final JButton btnLimpiar = new JButton("Limpiar");
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
		btnLimpiar.setIcon(new ImageIcon(AdministracionHeuristicos.class.getResource("/img/clear.png")));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setFocusable(false);
		btnLimpiar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnLimpiar.setBackground(SystemColor.controlHighlight);
		btnLimpiar.setBounds(854, 105, 109, 38);
		contenedor_registro.add(btnLimpiar);
		
		btnActualizar = new JButton("  Actualizar");
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				resaltar(btnActualizar);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				noResaltar(btnActualizar);
			}
		});
		btnActualizar.setIcon(new ImageIcon(AdministracionHeuristicos.class.getResource("/img/update.png")));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nombre=txt_nombre.getText().toString();
				String descripcion=txt_descripcion.getText().toString();
				
				
				if(id_heuristico==-1){
					JOptionPane.showMessageDialog(null, "Por favor seleccione el heurístico a editar");
				}else{
				
					if(nombre.equals("") || descripcion.equals("")){
						JOptionPane.showMessageDialog(null, "Por favor complete los campos");
						txt_descripcion.requestFocus();
						txt_nombre.requestFocus();
					}else{
					
						Heuristico heuristico=new Heuristico(id_heuristico,nombre,descripcion);
						
						if(heuristico.actualizar()>0){
							JOptionPane.showMessageDialog(null, "Heurístico actualizado exitosamente");
							id_heuristico=-1;
							btnActualizar.setEnabled(false);
							btnGuardar.setEnabled(true);
							limpiar();
							try {
								cargarTabla();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}else{
							JOptionPane.showMessageDialog(null, "Error al actualizar");
						}
					}
				}
				
				
			}
		});
		btnActualizar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnActualizar.setBackground(SystemColor.controlHighlight);
		btnActualizar.setBounds(990, 105, 153, 38);
		contenedor_registro.add(btnActualizar);
		
		JPanel panel = new JPanel();
		panel.setBounds(473, 12, 398, 88);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(223, 223, 233));
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AdministracionHeuristicos.class.getResource("/img/listado.png")));
		label_1.setBounds(0, 0, 133, 74);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Expert System of Heuristic Evaluation");
		label_2.setFont(new Font("Dialog", Font.BOLD, 13));
		label_2.setBounds(108, 12, 278, 15);
		panel.add(label_2);
		
		JLabel lblRegistro = new JLabel("Administración de Heurísticos");
		lblRegistro.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblRegistro.setBounds(108, 39, 278, 27);
		panel.add(lblRegistro);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(null, "Heurísticos Existentes", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_11.setBounds(12, 297, 1326, 437);
		contentPane.add(panel_11);
		panel_11.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 22, 1289, 392);
		panel_11.add(scrollPane);
		
		tbl_heuristicos = new JTable();
		tbl_heuristicos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbl_heuristicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int indice=tbl_heuristicos.getSelectedRow();
				txt_nombre.setText(tbl_heuristicos.getValueAt(indice,1).toString());
				txt_descripcion.setText(tbl_heuristicos.getValueAt(indice,2).toString());
				id_heuristico=Integer.parseInt(tbl_heuristicos.getValueAt(indice,0).toString());
				btnActualizar.setEnabled(true);
				btnGuardar.setEnabled(false);
				
			
			}
		});
		tbl_heuristicos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOMBRE", "DESCRIPCI\u00D3N"
			}
		));
		scrollPane.setViewportView(tbl_heuristicos);
		this.setLocationRelativeTo(null);
		
		try {
			cargarTabla();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		btnActualizar.setEnabled(false);
		
	}
	
	public int cerrar(){
		return 1;
	}
	
	public void cerrarAdministracionHeuristicos(){
		Object [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Está seguro que desea cerrar la ventana de administración de heurísticos?","Mensaje de Confirmación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
		if (eleccion == JOptionPane.YES_OPTION)
		{
			dispose();
		}else{
			
		}
	}
	
	
	public void cargarTabla() throws SQLException{
		ResultSet rs=Heuristico.consultarTodos();
		DefaultTableModel modelo=new DefaultTableModel();
		
		modelo.addColumn("ID");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("DESCRIPCIÓN");
		

		while(rs.next()){		
			
			
					modelo.addRow(new String[] {rs.getString(1),rs.getString(3),rs.getString(2)});
		
			
						
			
			
			tbl_heuristicos.setModel(modelo);
		}
		
		formatearTabla();
		
		
	}
	
	public void formatearTabla(){
		//tbl_subheuristicos.getColumnModel().getColumn(0).setPreferredWidth(1);
		//tbl_subheuristicos.setBackground(new Color(161,202,232));
		tbl_heuristicos.setRowHeight(20);
		tbl_heuristicos.setForeground(new Color(0,0,0));
		tbl_heuristicos.setFont(new Font("Dialog", Font.PLAIN, 13));
		//tbl_subheuristicos.getTableHeader().setBackground(new Color(9,125,209));
		//tbl_subheuristicos.getTableHeader().setForeground(new Color(255,255,255));
		tbl_heuristicos.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
		tbl_heuristicos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		tbl_heuristicos.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		tbl_heuristicos.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(0);
		tbl_heuristicos.getTableHeader().getColumnModel().getColumn(0).setResizable(false);
		
		//tbl_heuristicos.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(120);
		
		
		tbl_heuristicos.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(250);	
		tbl_heuristicos.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(1100);
		
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.LEFT);
	}
	
	
	void limpiar(){
		txt_descripcion.setText("");
		txt_nombre.setText("");
		id_heuristico=-1;
		btnActualizar.setEnabled(false);
		btnGuardar.setEnabled(true);
		txt_nombre.requestFocus();
	}
	
	public  void resaltar(JButton btn){
		btn.setBackground(new Color(200,200,200));
		
	}
	
	public  void noResaltar(JButton btn){
		btn.setBackground(new Color(230,230,230));
		
	}
}
