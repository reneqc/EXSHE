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

import javax.swing.DefaultCellEditor;
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
import javax.swing.table.TableColumn;

import com.persistencia.Evaluacion;
import com.persistencia.Heuristico;

public class EjecucionEvaluaciones extends JFrame {

	private JPanel contentPane;
	public static EjecucionEvaluaciones framePrincipal = new EjecucionEvaluaciones();
	private JTextField txt_navegador;
	private JTable tbl_evaluaciones;
	JLabel  lbl_evaluador;
	
	JButton btnAnterior,btnSiguiente,btnFinalizar;
	JScrollPane panelSubHeuristicos;
	int id_evaluacion=-1;
	public Heuristico h1=new Heuristico();
	int  numHeuristico=1;
	JLabel lbl_heuristico;
	JLabel lbl_descripcion;
	 Evaluacion evaluacion;
	 private JTextField txt_version;
	 private JTextField txt_nombre;
	 private JTextField txt_url;
	 private JTable tbl_subheuristicos;
	 JPanel panel_heuristicos;
	 JPanel panel_descripcion;
	 
	 
	 JComboBox puntuacion1;
	 String[] opNumericas={"1","2","3","4","5","6","7","8","9","10"};
	 
	 
	 JComboBox puntuacion2;
	 String[]  opTextuales={"A","B","C","D","E"};
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					framePrincipal.setVisible(true);
					//framePrincipal.setExtendedState(MAXIMIZED_BOTH);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	


	/**
	 * Create the frame.
	 */
	public EjecucionEvaluaciones() {
		setTitle("EXSHE - EVALUACIONES");
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(223, 223, 233));
		panel_2.setBounds(481, 8, 402, 84);
		contentPane.add(panel_2);
		
		JLabel lblLog = new JLabel("LOG");
		lblLog.setIcon(new ImageIcon(EjecucionEvaluaciones.class.getResource("/img/ejecucion.png")));
		lblLog.setBounds(22, 12, 62, 66);
		panel_2.add(lblLog);
		
		JLabel label_2 = new JLabel("Expert System of Heuristic Evaluation");
		label_2.setFont(new Font("Dialog", Font.BOLD, 13));
		label_2.setBounds(112, 12, 278, 33);
		panel_2.add(label_2);
		
		JLabel lblBienvenido = new JLabel("EVALUACIONES");
		lblBienvenido.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblBienvenido.setBounds(112, 37, 278, 35);
		panel_2.add(lblBienvenido);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "Ejecutar evaluaciones", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_8.setBounds(377, 104, 961, 618);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(223, 223, 233));
		panel_3.setBounds(12, 61, 449, 27);
		panel_8.add(panel_3);
		
		JLabel lblNavegadorParaLa = new JLabel("Navegador para la evaluación:");
		lblNavegadorParaLa.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNavegadorParaLa.setBounds(12, 5, 242, 15);
		panel_3.add(lblNavegadorParaLa);
		
		txt_navegador = new JTextField();
		txt_navegador.setEditable(false);
		txt_navegador.setColumns(10);
		txt_navegador.setBorder(null);
		txt_navegador.setBackground(new Color(223, 223, 233));
		txt_navegador.setBounds(249, 3, 188, 20);
		panel_3.add(txt_navegador);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(223, 223, 233));
		panel_7.setBounds(482, 22, 467, 27);
		panel_8.add(panel_7);
		
		JLabel lblUrlDelSitio = new JLabel("Url del Sitio:");
		lblUrlDelSitio.setFont(new Font("Dialog", Font.BOLD, 13));
		lblUrlDelSitio.setBounds(32, 5, 103, 15);
		panel_7.add(lblUrlDelSitio);
		
		txt_url = new JTextField();
		txt_url.setEditable(false);
		txt_url.setColumns(10);
		txt_url.setBorder(null);
		txt_url.setBackground(new Color(223, 223, 233));
		txt_url.setBounds(131, 3, 324, 20);
		panel_7.add(txt_url);
		
		final JButton btnGuardar = new JButton("  Iniciar");
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre=txt_nombre.getText();
				String url=txt_url.getText();
				
				String navegador=txt_navegador.getText();
				String version=txt_version.getText();
				
				String email=lbl_evaluador.getText();
				
				if(nombre.equals("") || url.equals("")){
					JOptionPane.showMessageDialog(null,"Por favor seleccione una evaluación de la tabla");
				}else{
					if(version.equals("")||navegador.equals("")){
						JOptionPane.showMessageDialog(null, "Por favor seleccione una evaluación de la tabla");	
						
						if(version.equals("")){
							txt_version.requestFocus();
						}
						
						if(navegador.equals("")){
							txt_navegador.requestFocus();
						}
						
						
					}else{
						
						
							
							btnGuardar.setEnabled(false);
							btnAnterior.setVisible(true);
							btnSiguiente.setVisible(true);
							btnFinalizar.setVisible(true);							
							tbl_evaluaciones.setEnabled(false);
							panelSubHeuristicos.setVisible(true);
							panel_heuristicos.setVisible(true);
							panel_descripcion.setVisible(true);
							JOptionPane.showMessageDialog(null, "Test Iniciado");
							
					}
					
				}
				
			}
		});
		btnGuardar.setIcon(new ImageIcon(EjecucionEvaluaciones.class.getResource("/img/start2.png")));
		btnGuardar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnGuardar.setBackground(SystemColor.controlHighlight);
		btnGuardar.setBounds(819, 61, 130, 27);
		panel_8.add(btnGuardar);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(223, 223, 233));
		panel_4.setBounds(482, 61, 325, 27);
		panel_8.add(panel_4);
		
		JLabel lblVersinDelNavegador = new JLabel("Versión:");
		lblVersinDelNavegador.setFont(new Font("Dialog", Font.BOLD, 13));
		lblVersinDelNavegador.setBounds(12, 5, 69, 15);
		panel_4.add(lblVersinDelNavegador);
		
		txt_version = new JTextField();
		txt_version.setEditable(false);
		txt_version.setColumns(10);
		txt_version.setBorder(null);
		txt_version.setBackground(new Color(223, 223, 233));
		txt_version.setBounds(72, 3, 241, 20);
		panel_4.add(txt_version);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(223, 223, 233));
		panel_6.setBounds(12, 22, 449, 27);
		panel_8.add(panel_6);
		
		JLabel lblNombreDelSitio = new JLabel("Nombre del Sitio:");
		lblNombreDelSitio.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNombreDelSitio.setBounds(12, 5, 129, 15);
		panel_6.add(lblNombreDelSitio);
		
		txt_nombre = new JTextField();
		txt_nombre.setEditable(false);
		txt_nombre.setColumns(10);
		txt_nombre.setBorder(null);
		txt_nombre.setBackground(new Color(223, 223, 233));
		txt_nombre.setBounds(151, 3, 286, 20);
		panel_6.add(txt_nombre);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(numHeuristico<10){
					numHeuristico++;
					try {
						cargarTablaSubheuristicos(numHeuristico);
						consultar_por_numero(numHeuristico);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnSiguiente.setBorder(UIManager.getBorder("CheckBox.border"));
		btnSiguiente.setBackground(SystemColor.controlHighlight);
		btnSiguiente.setBounds(607, 579, 113, 27);
		panel_8.add(btnSiguiente);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(numHeuristico>1){
					numHeuristico--;
					try {
						cargarTablaSubheuristicos(numHeuristico);
						consultar_por_numero(numHeuristico);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnAnterior.setBorder(UIManager.getBorder("CheckBox.border"));
		btnAnterior.setBackground(SystemColor.controlHighlight);
		btnAnterior.setBounds(482, 579, 113, 27);
		panel_8.add(btnAnterior);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAnterior.setVisible(false);
				btnSiguiente.setVisible(false);
				btnFinalizar.setVisible(false);
				btnGuardar.setEnabled(true);
				limpiar();				
				panel_heuristicos.setVisible(false);
				panel_descripcion.setVisible(false);
				tbl_evaluaciones.setEnabled(true);
				panelSubHeuristicos.setVisible(false);
				JOptionPane.showMessageDialog(null,"Evaluación finalizada");
			}
		});
		btnFinalizar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnFinalizar.setBackground(SystemColor.controlHighlight);
		btnFinalizar.setBounds(732, 579, 113, 27);
		panel_8.add(btnFinalizar);
		
		panel_heuristicos = new JPanel();
		panel_heuristicos.setLayout(null);
		panel_heuristicos.setBackground(new Color(223, 223, 233));
		panel_heuristicos.setBounds(12, 111, 937, 52);
		panel_8.add(panel_heuristicos);
		
		lbl_heuristico = new JLabel("Heurístico a evaluar");
		lbl_heuristico.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lbl_heuristico.setBounds(12, 0, 913, 52);
		panel_heuristicos.add(lbl_heuristico);
		
		panelSubHeuristicos = new JScrollPane();
		panelSubHeuristicos.setBounds(12, 230, 937, 336);
		panel_8.add(panelSubHeuristicos);
		
		tbl_subheuristicos = new JTable();
		tbl_subheuristicos.setRowHeight(25);
		tbl_subheuristicos.setForeground(Color.BLACK);
		tbl_subheuristicos.setFont(new Font("Dialog", Font.PLAIN, 15));
		tbl_subheuristicos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panelSubHeuristicos.setViewportView(tbl_subheuristicos);
		
		panel_descripcion = new JPanel();
		panel_descripcion.setLayout(null);
		panel_descripcion.setBackground(new Color(223, 223, 233));
		panel_descripcion.setBounds(12, 167, 937, 27);
		panel_8.add(panel_descripcion);
		
		JLabel lblDescripci = new JLabel("  DESCRIPCIÓN:");
		lblDescripci.setFont(new Font("Dialog", Font.BOLD, 13));
		lblDescripci.setBounds(0, 0, 116, 26);
		panel_descripcion.add(lblDescripci);
		
		lbl_descripcion = new JLabel("Descripcion del heuristico");
		lbl_descripcion.setFont(new Font("Dialog", Font.ITALIC, 12));
		lbl_descripcion.setBounds(124, 0, 801, 26);
		panel_descripcion.add(lbl_descripcion);
		panelSubHeuristicos.setVisible(false);
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new TitledBorder(null, "Evaluaciones", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_9.setBounds(12, 104, 353, 618);
		contentPane.add(panel_9);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		scrollPane.setBounds(12, 35, 336, 541);
		panel_9.add(scrollPane);
		
		tbl_evaluaciones = new JTable();
		
		tbl_evaluaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				int indice=tbl_evaluaciones.getSelectedRow();
				
				txt_nombre.setText(tbl_evaluaciones.getValueAt(indice,2).toString());
				txt_url.setText(tbl_evaluaciones.getValueAt(indice,3).toString());
				txt_navegador.setText(tbl_evaluaciones.getValueAt(indice,4).toString());
				txt_version.setText(tbl_evaluaciones.getValueAt(indice,5).toString());
				id_evaluacion=Integer.parseInt(tbl_evaluaciones.getValueAt(indice,1).toString());
				//JOptionPane.showMessageDialog(null,id_proyecto);
				
				

			}
		});
		tbl_evaluaciones.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID_DETALLE","ID_PROYECTO", "NOMBRE DEL SITIO","URL", "EVALUADOR","FECHA", "TIPO DEL SITIO"
				}
			));
		scrollPane.setViewportView(tbl_evaluaciones);
		
		lbl_evaluador = new JLabel("Evaluador conectado para evaluar");
		lbl_evaluador.setFont(new Font("Dialog", Font.ITALIC, 12));
		lbl_evaluador.setBounds(181, 8, 245, 30);
		contentPane.add(lbl_evaluador);
		
		JLabel label_3 = new JLabel("Evaluador conectado:");
		label_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label_3.setBounds(30, 12, 151, 22);
		contentPane.add(label_3);
		
		
		cargarTabla();
		
		btnAnterior.setVisible(false);
		btnSiguiente.setVisible(false);
		btnFinalizar.setVisible(false);
		
		try {
			cargarTablaSubheuristicos(numHeuristico);
			consultar_por_numero(numHeuristico);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		panel_heuristicos.setVisible(false);
		panel_descripcion.setVisible(false);
	}
	
	
	public void cerrarPrincipal(){
		Object [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(rootPane,"Esta seguro que desea cerrar la Ventana de Evaluaciones","Mensaje de Confirmación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
		if (eleccion == JOptionPane.YES_OPTION)
		{
			dispose();
		}else{
			
		}
	}
	
	
	
	
	
	
	
	public void cargarTabla() {
		
		//JOptionPane.showMessageDialog(null,Acceso.conectado());
		//String email=Acceso.conectado();
		String email="perez@gmail.com";
		ResultSet rs=null;
		try {
			rs = Evaluacion.consultarEvaluacionesEvaluador(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DefaultTableModel modelo=new DefaultTableModel();	
		modelo.addColumn("ID_EVALUACION");
		modelo.addColumn("ID_PROYECTO");
		modelo.addColumn("NOMBRE DEL SITIO");
		modelo.addColumn("URL");
		modelo.addColumn("NAVEGADOR");
		modelo.addColumn("VERSIÓN");
		modelo.addColumn("FECHA");		
		try {
			while(rs.next()){		

					modelo.addRow(new String[] {rs.getString(1),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(10),rs.getString(11),rs.getString(8)});			

			

				
					tbl_evaluaciones.setModel(modelo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formatearTabla();
		

	}
	
	public void formatearTabla(){
		//tbl_subheuristicos.getColumnModel().getColumn(0).setPreferredWidth(1);
		//tbl_subheuristicos.setBackground(new Color(161,202,232));
		tbl_evaluaciones.setRowHeight(25);
		tbl_evaluaciones.setForeground(new Color(0,0,0));
		tbl_evaluaciones.setFont(new Font("Dialog", Font.PLAIN, 15));
		tbl_evaluaciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//tbl_subheuristicos.getTableHeader().setBackground(new Color(9,125,209));
		//tbl_subheuristicos.getTableHeader().setForeground(new Color(255,255,255));
		tbl_evaluaciones.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(0).setResizable(false);
		
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(0);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(1).setResizable(false);
		
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(200);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(200);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(160);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(200);
		tbl_evaluaciones.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(250);
		
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		

		tbl_evaluaciones.getColumnModel().getColumn(0).setCellRenderer(tcr);
				
		tbl_evaluaciones.getColumnModel().getColumn(2).setCellRenderer(tcr);
	}
	
	
	public void limpiar(){
		txt_navegador.setText("");
		txt_version.setText("");
		txt_nombre.setText("");
		txt_url.setText("");
		txt_navegador.requestFocus();
		id_evaluacion=-1;
	}
	
	
	public void cerrarEjecucion(){
		Object [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Está seguro que desea cerrar la Ventana de Mantenimiento de Evaluadores?","Mensaje de Confirmación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
		if (eleccion == JOptionPane.YES_OPTION)
		{
			dispose();
		}else{
			
		}
	}
	
	
	public void cargarTablaSubheuristicos(int num) throws SQLException{
		ResultSet rs=h1.consultarSubheuristicos(num);
		DefaultTableModel modelo=new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("PTOS");
		modelo.addColumn("CRITERIO");
		modelo.addColumn("MÉTRICA");
		tbl_subheuristicos.setModel(modelo);
		
	
		while(rs.next()){		
			if(rs.getString(4).equals("numero")){
				puntuacion1=new JComboBox(opNumericas);	
				tbl_subheuristicos.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(puntuacion1));
				modelo.addRow(new Object[] {1,"Seleccione",rs.getString(3),"Numérica"});
				
			}else{	
				
				modelo.addRow(new Object[] {1,"Seleccione",rs.getString(3),"Textual"});		
			}
			
		
			
			
		}
		
		formatearTabla2();

	}
	public void formatearTabla2(){
		//tbl_subheuristicos.getColumnModel().getColumn(0).setPreferredWidth(1);
		//tbl_subheuristicos.setBackground(new Color(161,202,232));
		tbl_subheuristicos.setRowHeight(25);
		tbl_subheuristicos.setForeground(new Color(0,0,0));
		tbl_subheuristicos.setFont(new Font("Dialog", Font.PLAIN, 15));
		tbl_subheuristicos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//tbl_subheuristicos.getTableHeader().setBackground(new Color(9,125,209));
		//tbl_subheuristicos.getTableHeader().setForeground(new Color(255,255,255));
		tbl_subheuristicos.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
		tbl_subheuristicos.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(0);
		tbl_subheuristicos.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		tbl_subheuristicos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		
		tbl_subheuristicos.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(100);
		tbl_subheuristicos.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(970);
		
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		

		tbl_subheuristicos.getColumnModel().getColumn(0).setCellRenderer(tcr);
		tbl_subheuristicos.getColumnModel().getColumn(1).setCellRenderer(tcr);

	}
	
	public void consultar_por_numero(int n){
		numHeuristico=n;
		try {
			h1.consultarHeuristico(n);
			lbl_heuristico.setText("<html><div> HEURÍSTICO Nº "+numHeuristico+": "+h1.getNombre()+"</div></html>");
			lbl_descripcion.setText(h1.getDescripcion()+".");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
