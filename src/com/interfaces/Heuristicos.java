package com.interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.persistencia.Heuristico;
import javax.swing.ImageIcon;

public class Heuristicos extends JFrame {

	private JPanel contentPane;
	final static Heuristicos frameHeuristico1 = new Heuristicos();
	int  numHeuristico;
	public Heuristico h1=new Heuristico();
	
	JLabel lblDescripcion = new JLabel("Descripcion del Heuristico ");	
	JLabel lblNombre = new JLabel("Heuristico #");
	private JTable tbl_subheuristicos;
	JLabel txtContador = new JLabel("00:");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frameHeuristico1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Heuristicos() {
		setTitle("EXSHE - HEURÍSTICOS");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,  1366, 768);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(cerrar());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNombre.setBounds(241, 82, 855, 29);
		contentPane.add(lblNombre);
		lblDescripcion.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		
		
		lblDescripcion.setBounds(140, 143, 1187, 23);
		contentPane.add(lblDescripcion);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(31, 133, 1286, 2);
		contentPane.add(panel);
		
		JLabel lblNombre_1 = new JLabel("HEURÍSTICO Nº");
		lblNombre_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNombre_1.setBounds(31, 72, 171, 49);
		contentPane.add(lblNombre_1);
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		lblDescripcin.setBounds(31, 143, 125, 23);
		contentPane.add(lblDescripcin);
		
		JButton btnSig = new JButton("");
		btnSig.setIcon(new ImageIcon(Heuristicos.class.getResource("/img/next.png")));
		btnSig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
				if (numHeuristico<10){
				numHeuristico++;
				consultar_por_numero(numHeuristico);
				}else{
					JOptionPane.showMessageDialog(null,"No hay más heurísticos");
				}
				
			}
		});
		btnSig.setBounds(1271, 83, 40, 28);
		contentPane.add(btnSig);
		
		JButton btnAnt = new JButton("");
		btnAnt.setIcon(new ImageIcon(Heuristicos.class.getResource("/img/prev.png")));
		btnAnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numHeuristico>1){
				numHeuristico--;
				consultar_por_numero(numHeuristico);
				}else{
					JOptionPane.showMessageDialog(null,"No hay más heurísticos");
				}
			}
		});
		btnAnt.setBounds(1199, 82, 40, 28);
		contentPane.add(btnAnt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 233, 1286, 376);
		contentPane.add(scrollPane);
		
		tbl_subheuristicos = new JTable();
		tbl_subheuristicos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO", "CRITERIO", "M\u00C9TRICA"
			}
		));
		scrollPane.setViewportView(tbl_subheuristicos);
		
		JLabel lblCriteriosAEvaluar = new JLabel("Criterios a Evaluar");
		lblCriteriosAEvaluar.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCriteriosAEvaluar.setBounds(31, 199, 252, 29);
		contentPane.add(lblCriteriosAEvaluar);
		
		
		txtContador.setFont(new Font("Dialog", Font.BOLD, 18));
		txtContador.setBounds(196, 72, 43, 49);
		contentPane.add(txtContador);
		
		
		formatearTabla();
		
	}
	
	public int cerrar(){
		return 1;
	}
	
	
	
	public void consultar_por_numero(int n){
			numHeuristico=n;
			try {
				h1.consultarHeuristico(n);
				lblNombre.setText('"'+h1.getNombre()+'"');
				lblDescripcion.setText(h1.getDescripcion()+".");
				if(n!=10){
					txtContador.setText("0"+n+":");
				}else{
					txtContador.setText(n+":");
				}
				cargarTabla(n);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public void cargarTabla(int num) throws SQLException{
		ResultSet rs=h1.consultarSubheuristicos(num);
		DefaultTableModel modelo=new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("CRITERIO");
		modelo.addColumn("MÉTRICA");
		while(rs.next()){		
			if(rs.getString(4).equals("numero")){
				modelo.addRow(new String[] {rs.getString(2),rs.getString(3),"Numérica"});			
			}else{
				modelo.addRow(new String[] {rs.getString(2),rs.getString(3),"Textual"});		
			}
			
			tbl_subheuristicos.setModel(modelo);
		}
		formatearTabla();

	}
	public void formatearTabla(){
		//tbl_subheuristicos.getColumnModel().getColumn(0).setPreferredWidth(1);
		//tbl_subheuristicos.setBackground(new Color(161,202,232));
		tbl_subheuristicos.setRowHeight(25);
		tbl_subheuristicos.setForeground(new Color(0,0,0));
		tbl_subheuristicos.setFont(new Font("Dialog", Font.PLAIN, 15));
		tbl_subheuristicos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//tbl_subheuristicos.getTableHeader().setBackground(new Color(9,125,209));
		//tbl_subheuristicos.getTableHeader().setForeground(new Color(255,255,255));
		tbl_subheuristicos.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
		tbl_subheuristicos.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(163);
		
		tbl_subheuristicos.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(970);
		tbl_subheuristicos.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(150);
		
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		

		tbl_subheuristicos.getColumnModel().getColumn(0).setCellRenderer(tcr);
				
		tbl_subheuristicos.getColumnModel().getColumn(2).setCellRenderer(tcr);
	}
}
