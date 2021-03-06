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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
import com.persistencia.Heuristico;
import com.persistencia.SubHeuristico;


public class AdministracionSubHeuristicos extends JFrame {

	private JPanel contentPane;
	private JTextField txt_criterio;
	Evaluador evaluador;
	static AdministracionSubHeuristicos frame = new AdministracionSubHeuristicos();
	private JTable tbl_heuristicos;
	JComboBox txt_heuristicos;
	private int id_heuristico=-1;

	JComboBox txt_tipo;
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
	public AdministracionSubHeuristicos() {
		setResizable(false);
		setTitle("EXSHE - ADMINISTRACIÓN DE SUB HEURÍSTICOS");
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
		contenedor_registro.setBorder(new TitledBorder(null, "Registro de Sub Heurísticos", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		contenedor_registro.setToolTipText("Registro de  Heurísticos");
		contenedor_registro.setBounds(12, 99, 1326, 197);
		
		contentPane.add(contenedor_registro);
		contenedor_registro.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 64, 1302, 27);
		contenedor_registro.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(223, 223, 233));
		
		JLabel lblNombre = new JLabel("Criterio:");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNombre.setBounds(12, 5, 91, 15);
		panel_1.add(lblNombre);
		
		txt_criterio = new JTextField();
		txt_criterio.setColumns(10);
		txt_criterio.setBorder(null);
		txt_criterio.setBackground(new Color(223, 223, 233));
		txt_criterio.setBounds(73, 3, 1217, 20);
		panel_1.add(txt_criterio);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 25, 1302, 27);
		contenedor_registro.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(223, 223, 233));
		
		JLabel lblApellido = new JLabel("Nombre del Heurístico:");
		lblApellido.setFont(new Font("Dialog", Font.BOLD, 13));
		lblApellido.setBounds(12, 5, 178, 15);
		panel_2.add(lblApellido);
		
		txt_heuristicos = new JComboBox();
		txt_heuristicos.setBounds(191, 0, 528, 24);
		panel_2.add(txt_heuristicos);
		
		JButton btnGuardar = new JButton("  Guardar");
		btnGuardar.setIcon(new ImageIcon(AdministracionSubHeuristicos.class.getResource("/img/save.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String criterio=txt_criterio.getText().toString();
				String tipo=txt_tipo.getSelectedItem().toString();
				
				String heuristicoAuxiliar=txt_heuristicos.getSelectedItem().toString();
				
				
				
				
				if(criterio.equals("") || tipo.equals("Por favor seleccione una opción")||heuristicoAuxiliar.equals("Por favor seleccione una opción")){
					
					
					JOptionPane.showMessageDialog(null, "Por favor complete los campos o seleccione la información requerida","Advertencia", JOptionPane.WARNING_MESSAGE);
					
					if(criterio.equals("")){
						txt_criterio.requestFocus();
					}
					
					
				}else{
					String[] id_heuristicoAux=heuristicoAuxiliar.split(":");
					
					
					int id=Integer.parseInt(id_heuristicoAux[0]);
					SubHeuristico subHeuristico=new SubHeuristico(criterio, tipo, id);
					
					if(subHeuristico.guardar()>0){
						JOptionPane.showMessageDialog(null,"SubHeurístico guardado Exitosamente");	
						limpiar();
						try {
							cargarTabla();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
								
					}else{
						JOptionPane.showMessageDialog(null,"Error al guardar el subheurístico");						
					}
				}
				
				
				
				
				
				
				
			}
		});
		btnGuardar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnGuardar.setBackground(SystemColor.controlHighlight);
		btnGuardar.setBounds(1180, 144, 134, 38);
		contenedor_registro.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				limpiar();
			}
		});
		btnLimpiar.setIcon(new ImageIcon(AdministracionSubHeuristicos.class.getResource("/img/clear.png")));
		btnLimpiar.setFocusable(false);
		btnLimpiar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnLimpiar.setBackground(SystemColor.controlHighlight);
		btnLimpiar.setBounds(852, 143, 109, 40);
		contenedor_registro.add(btnLimpiar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(223, 223, 233));
		panel_3.setBounds(12, 104, 1302, 27);
		contenedor_registro.add(panel_3);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTipo.setBounds(12, 5, 178, 15);
		panel_3.add(lblTipo);
		
		txt_tipo = new JComboBox();
		txt_tipo.setModel(new DefaultComboBoxModel(new String[] {"Por favor seleccione una opción", "Numérico", "Textual"}));
		txt_tipo.setBounds(66, 0, 268, 24);
		panel_3.add(txt_tipo);
		
		JButton btnRefrescar = new JButton("Refrescar Datos");
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cargarHeuristicos();
					limpiar();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRefrescar.setIcon(new ImageIcon(AdministracionSubHeuristicos.class.getResource("/img/refresh.png")));
		btnRefrescar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnRefrescar.setBackground(SystemColor.controlHighlight);
		btnRefrescar.setBounds(973, 144, 176, 38);
		contenedor_registro.add(btnRefrescar);
		
		JPanel panel = new JPanel();
		panel.setBounds(478, 12, 404, 74);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(223, 223, 233));
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AdministracionSubHeuristicos.class.getResource("/img/subheuristicos.png")));
		label_1.setBounds(22, 0, 90, 82);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Expert System of Heuristic Evaluation");
		label_2.setFont(new Font("Dialog", Font.BOLD, 13));
		label_2.setBounds(114, 12, 278, 15);
		panel.add(label_2);
		
		JLabel lblRegistro = new JLabel("Sub Heurísticos");
		lblRegistro.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblRegistro.setBounds(114, 35, 278, 27);
		panel.add(lblRegistro);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(null, "Sub heurísticos existentes", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_11.setBounds(12, 308, 1326, 414);
		contentPane.add(panel_11);
		panel_11.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 32, 1302, 370);
		panel_11.add(scrollPane);
		
		tbl_heuristicos = new JTable();
		tbl_heuristicos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbl_heuristicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*
				int indice=tbl_heuristicos.getSelectedRow();
				//txt_nombre.setText(tbl_heuristicos.getValueAt(indice,1).toString());
				txt_criterio.setText(tbl_heuristicos.getValueAt(indice,2).toString());
				id_heuristico=Integer.parseInt(tbl_heuristicos.getValueAt(indice,0).toString());
				
				*/
				
			
			}
		});
		tbl_heuristicos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "HRURISTICO", "CRITERIO","TIPO"
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
		
		
	}
	
	public int cerrar(){
		return 1;
	}
	
	public void cerrarAdministracionHeuristicos(){
		Object [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Está seguro que desea cerrar la ventana de administración de Sub heurísticos?","Mensaje de Confirmación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
		if (eleccion == JOptionPane.YES_OPTION)
		{
			dispose();
		}else{
			
		}
	}
	
	
	public void cargarTabla() throws SQLException{
		ResultSet rs=SubHeuristico.consultarTodos();
		DefaultTableModel modelo=new DefaultTableModel();
		
		modelo.addColumn("ID");
		modelo.addColumn("HEURISTICO");
		modelo.addColumn("CRITERIO");
		modelo.addColumn("TIPO");
		

		while(rs.next()){		
			
			
					modelo.addRow(new String[] {rs.getString(1),rs.getString(7),rs.getString(2),rs.getString(3)});
		
			
						
			
			
			tbl_heuristicos.setModel(modelo);
		}
		
		formatearTabla();
		
		cargarHeuristicos();
		
		
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
		tbl_heuristicos.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(100);
		
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.LEFT);
	}
	
	public void cargarHeuristicos() throws SQLException{
		ResultSet heuristicos=Heuristico.consultarTodos();
		
		txt_heuristicos.removeAllItems();
		txt_heuristicos.addItem("Por favor seleccione una opción");
		
		while(heuristicos.next()){
			String h=heuristicos.getString(1)+": "+heuristicos.getString(3);
			txt_heuristicos.addItem(h);
			
		}
		
		
	}
	
	
	void limpiar(){
		txt_criterio.setText("");
		txt_heuristicos.setSelectedIndex(0);
		txt_tipo.setSelectedIndex(0);
	}
}
