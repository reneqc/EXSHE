package com.interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.persistencia.Evaluacion;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListaEvaluaciones extends JFrame {

	private JPanel contentPane;
	private JTable tbl_evaluacionesFinalizadas;
	private JTextField txt_evaluacion;
	int id_evaluacion=-1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaEvaluaciones frame = new ListaEvaluaciones();
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
	public ListaEvaluaciones() {
		setTitle("Resultados");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarPrincipal();
			}
		});
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1366, 730);
		//setDefaultCloseOperation(cerrarPrincipal());		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(183, 320, 1157, 279);
		contentPane.add(scrollPane);
		
		tbl_evaluacionesFinalizadas = new JTable();
		tbl_evaluacionesFinalizadas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int indice=tbl_evaluacionesFinalizadas.getSelectedRow();				
				id_evaluacion=Integer.parseInt(tbl_evaluacionesFinalizadas.getValueAt(indice,0).toString());
				String nombre=tbl_evaluacionesFinalizadas.getValueAt(indice,0).toString()+": "+tbl_evaluacionesFinalizadas.getValueAt(indice,2).toString();
				
				txt_evaluacion.setText(nombre); 
			}
		});
		tbl_evaluacionesFinalizadas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"filados", "New column", "filauno"
			}
		));
		
		scrollPane.setViewportView(tbl_evaluacionesFinalizadas);
		
		txt_evaluacion = new JTextField();
		txt_evaluacion.setHorizontalAlignment(SwingConstants.CENTER);
		txt_evaluacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_evaluacion.setEditable(false);
		txt_evaluacion.setColumns(10);
		txt_evaluacion.setBorder(null);
		txt_evaluacion.setBackground(SystemColor.controlHighlight);
		txt_evaluacion.setBounds(832, 261, 279, 26);
		contentPane.add(txt_evaluacion);
		
		JButton button = new JButton(" Informe");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(id_evaluacion==-1){
					
					 
					JOptionPane.showMessageDialog(null,"Por favor seleccione una evaluación de la tabla para poder generar su respectivo informe");
				}else{
					
					 try{
						 
						 JOptionPane.showMessageDialog(null,""+id_evaluacion," ", JOptionPane.ERROR_MESSAGE);
						 
					 }catch(Exception ex){
			               
			                System.out.println(ex);
			            }
				}
				
				
				
			}
		});
		button.setIcon(new ImageIcon(ListaEvaluaciones.class.getResource("/img/ver.png")));
		button.setBorder(UIManager.getBorder("CheckBox.border"));
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(1121, 261, 122, 27);
		contentPane.add(button);
		caragarTabla();
	}
	
	public void cerrarPrincipal(){
		this.dispose();
	}
	
public void caragarTabla(){
		
	ResultSet rs=null;
	try {
		rs=Evaluacion.consultarEvaluacionesFinalizadas();
	} catch (SQLException e) {
		System.out.println(e);
		e.printStackTrace();
	}
	
	DefaultTableModel modelo=new DefaultTableModel();	
	modelo.addColumn("ID");
	modelo.addColumn("SITIO");
	modelo.addColumn("URL");
	modelo.addColumn("NAVEGADOR");
	modelo.addColumn("VERSIÓN");
	modelo.addColumn("FECHA");
	modelo.addColumn("EVALUADOR");
	
	try {
		while(rs.next()){		

	
				modelo.addRow(new String[] {rs.getString(1),rs.getString(4),rs.getString(5),rs.getString(10),rs.getString(11),rs.getString(8),rs.getString(7)+" "+rs.getString(6)});			


		

			
				tbl_evaluacionesFinalizadas.setModel(modelo);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	formatearTabla();

}
public void formatearTabla(){


	tbl_evaluacionesFinalizadas.setRowHeight(16);
	tbl_evaluacionesFinalizadas.setForeground(new Color(0,0,0));
	tbl_evaluacionesFinalizadas.setFont(new Font("Dialog", Font.PLAIN, 12));
	tbl_evaluacionesFinalizadas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tbl_evaluacionesFinalizadas.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 13));
	
	tbl_evaluacionesFinalizadas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
	tbl_evaluacionesFinalizadas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
	tbl_evaluacionesFinalizadas.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(0);
	tbl_evaluacionesFinalizadas.getTableHeader().getColumnModel().getColumn(0).setResizable(false);

	tbl_evaluacionesFinalizadas.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(200);
	tbl_evaluacionesFinalizadas.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(200);
	tbl_evaluacionesFinalizadas.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(200);
	tbl_evaluacionesFinalizadas.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(200);
	tbl_evaluacionesFinalizadas.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(200);
	tbl_evaluacionesFinalizadas.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(229);
	
	
	DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
	tcr.setHorizontalAlignment(SwingConstants.CENTER);
	
	
	

	tbl_evaluacionesFinalizadas.getColumnModel().getColumn(1).setCellRenderer(tcr);
			
	tbl_evaluacionesFinalizadas.getColumnModel().getColumn(2).setCellRenderer(tcr);
	tbl_evaluacionesFinalizadas.getColumnModel().getColumn(3).setCellRenderer(tcr);
	tbl_evaluacionesFinalizadas.getColumnModel().getColumn(4).setCellRenderer(tcr);
	tbl_evaluacionesFinalizadas.getColumnModel().getColumn(5).setCellRenderer(tcr);
	tbl_evaluacionesFinalizadas.getColumnModel().getColumn(6).setCellRenderer(tcr);
}
}
