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
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import com.persistencia.Conexion;
import com.persistencia.Evaluacion;
import com.persistencia.RutaBase;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class InformesEvaluador extends JFrame {

	private JPanel contentPane;
	JLabel lbl_evaluador;
	int id_evaluacion=-1;
	

	private JTable tbl_evaluacionesFinalizadas;
	private JPanel panel_1;
	
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblInformesEvaluaciones;
	private JTextField txt_evaluacion;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformesEvaluador frame = new InformesEvaluador();
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
	public InformesEvaluador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InformesEvaluador.class.getResource("/img/logo1.png")));
		setTitle("EXSHE - INFORMES");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarInformes();
			}
		});
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1366, 730);		
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Evaluador conectado:");
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label.setBounds(12, 12, 151, 22);
		contentPane.add(label);
		
		lbl_evaluador = new JLabel("Evaluador conectado para evaluar");
		lbl_evaluador.setFont(new Font("Dialog", Font.ITALIC, 12));
		lbl_evaluador.setBounds(161, 8, 245, 30);
		contentPane.add(lbl_evaluador);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 142, 1303, 539);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Historial de evaluaciones finalizadas", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 58, 1232, 457);
		panel.add(scrollPane);
		
		tbl_evaluacionesFinalizadas = new JTable();
		tbl_evaluacionesFinalizadas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int indice=tbl_evaluacionesFinalizadas.getSelectedRow();				
				
				id_evaluacion=Integer.parseInt(tbl_evaluacionesFinalizadas.getValueAt(indice,0).toString());
				String nombre=tbl_evaluacionesFinalizadas.getValueAt(indice,2).toString();
				txt_evaluacion.setText(nombre); 
		}
		});
		tbl_evaluacionesFinalizadas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","SITIO", "URL", "NAVEGADOR","VERSION", "FECHA","EVALUADOR"
			}
		));
		scrollPane.setViewportView(tbl_evaluacionesFinalizadas);
		
		txt_evaluacion = new JTextField();
		txt_evaluacion.setEditable(false);
		txt_evaluacion.setHorizontalAlignment(SwingConstants.CENTER);
		txt_evaluacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_evaluacion.setBackground(SystemColor.controlHighlight);
		txt_evaluacion.setBounds(381, 20, 385, 26);
		panel.add(txt_evaluacion);
		txt_evaluacion.setColumns(10);
		txt_evaluacion.setBorder(null);
		
		JButton btnResultados = new JButton("Recomendaciones");
		btnResultados.setIcon(new ImageIcon(InformesEvaluador.class.getResource("/img/result.png")));
		btnResultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			verInformeDeResultados();
			}
		});
		btnResultados.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnResultados.setBorder(UIManager.getBorder("CheckBox.border"));
		btnResultados.setBackground(SystemColor.controlHighlight);
		btnResultados.setBounds(1095, 20, 165, 27);
		panel.add(btnResultados);
		
		JButton btnVerInforme = new JButton(" Informe");
		btnVerInforme.setBounds(811, 20, 122, 27);
		panel.add(btnVerInforme);
		btnVerInforme.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVerInforme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				verInformeDeEvaluacion();
			}
		});
		btnVerInforme.setIcon(new ImageIcon(InformesEvaluador.class.getResource("/img/ver.png")));
		btnVerInforme.setBorder(UIManager.getBorder("CheckBox.border"));
		btnVerInforme.setBackground(SystemColor.controlHighlight);
		
		JButton btnProbemas = new JButton("  Probemas");
		btnProbemas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				verInformeDeProblemas();
			}
		});
		btnProbemas.setIcon(new ImageIcon(InformesEvaluador.class.getResource("/img/cancelar12.png")));
		btnProbemas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProbemas.setBorder(UIManager.getBorder("CheckBox.border"));
		btnProbemas.setBackground(SystemColor.controlHighlight);
		btnProbemas.setBounds(952, 20, 122, 27);
		panel.add(btnProbemas);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(223, 223, 233));
		panel_1.setBounds(447, 32, 402, 84);
		contentPane.add(panel_1);
		
		label_1 = new JLabel("LOG");
		label_1.setIcon(new ImageIcon(InformesEvaluador.class.getResource("/img/reportes.png")));
		label_1.setBounds(22, 12, 62, 66);
		panel_1.add(label_1);
		
		label_2 = new JLabel("Expert System of Heuristic Evaluation");
		label_2.setFont(new Font("Dialog", Font.BOLD, 13));
		label_2.setBounds(112, 12, 278, 33);
		panel_1.add(label_2);
		
		lblInformesEvaluaciones = new JLabel("INFORMES DE EVALUACIONES");
		lblInformesEvaluaciones.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblInformesEvaluaciones.setBounds(112, 37, 278, 35);
		panel_1.add(lblInformesEvaluaciones);
		
		button = new JButton("  Atr\u00E1s");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		button.setIcon(new ImageIcon(InformesEvaluador.class.getResource("/img/atras1.png")));
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBorder(UIManager.getBorder("CheckBox.border"));
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(12, 45, 112, 27);
		contentPane.add(button);
		cargarTabla();
	}
	
	public void cerrarInformes(){

			dispose();
	
	}
	
	public void cargarTabla(){
		String email=Acceso.conectado();
		//String email="perez@gmail.com";
		lbl_evaluador.setText(email);
		ResultSet rs=null;
		try {
			rs=Evaluacion.evaluacionesFinalizadasPorEvaluador(email);
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		DefaultTableModel modelo=new DefaultTableModel();	
		modelo.addColumn("ID");
		modelo.addColumn("SITIO");
		modelo.addColumn("URL");
		modelo.addColumn("NAVEGADOR");
		modelo.addColumn("VERSI�N");
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
	
	
	
	public void verInformeDeEvaluacion(){
		
		
		if(id_evaluacion==-1){
			
			 
			JOptionPane.showMessageDialog(null,"Por favor seleccione una evaluaci�n de la tabla para poder generar su respectivo informe");
		}else{
			
			 try{
	               
				 	JOptionPane.showMessageDialog(null,"Generando el reporte, por favor espere un momento");
	                //String rutaInforme="\\reportes\\reporteEvaluador.jasper";
				 	String path =RutaBase.obtenerRuta()+"reporteIndividualEvaluacion.jrxml";
	                abrirReporte(path, "Reporte de la Evaluaci�n ev_"+id_evaluacion, String.valueOf(id_evaluacion), "id_evaluacion");	                
	                
	            
	            }catch(Exception ex){
	                JOptionPane.showMessageDialog(null,"Error al cargar el reporte: "+ex, "ERROR",JOptionPane.ERROR_MESSAGE);
	                System.out.println(ex);
	            }
			  
			
		}
		
	}
	
	
	
public void verInformeDeProblemas(){
		
		
		if(id_evaluacion==-1){
			
			 
			JOptionPane.showMessageDialog(null,"Por favor seleccione una evaluaci�n de la tabla para poder generar su respectivo informe de problemas");
		}else{
			
			 try{
	               
				 	JOptionPane.showMessageDialog(null,"Generando el reporte, por favor espere un momento");
	                //String rutaInforme="\\reportes\\reporteEvaluador.jasper";
				 	String path =RutaBase.obtenerRuta()+"problemasEvaluacion.jrxml";
	                abrirReporte(path, "Reporte de Problemas de la Evaluaci�n ev_"+id_evaluacion, String.valueOf(id_evaluacion), "id_evaluacion");	                
	                
	            
	            }catch(Exception ex){
	                JOptionPane.showMessageDialog(null,"Error al cargar el reporte: "+ex, "ERROR",JOptionPane.ERROR_MESSAGE);
	                System.out.println(ex);
	            }
			  
			
		}
		
	}



	public void abrirReporte(String path, String titulo, String parametro,String valorParametro){
		 try{
            
            //String rutaInforme="\\reportes\\reporteEvaluador.jasper";
           
            JasperReport report = JasperCompileManager.compileReport(path);
            
            Map parametros = new HashMap();
            parametros.put(valorParametro,parametro);
            JasperPrint informe=JasperFillManager.fillReport(report,parametros,Conexion.obtenerConexion());
            JasperViewer ventanaVisor=new JasperViewer(informe,false);
            ventanaVisor.setTitle(titulo);
            ventanaVisor.setVisible(true);
            
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error al cargar el reporte: "+ex, "ERROR",JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
	}
	
	
	
	
public void verInformeDeResultados(){
		
		
		if(id_evaluacion==-1){
			
			 
			JOptionPane.showMessageDialog(null,"Por favor seleccione un proyecto de la tabla para poder generar sus respectivos resultados");
		}else{
			
			 try{
	               
				 	JOptionPane.showMessageDialog(null,"Generando el reporte, por favor espere un momento");
	                //String rutaInforme="\\reportes\\reporteEvaluador.jasper";
				 	String path =RutaBase.obtenerRuta()+"resultadosIndividual.jrxml";
	                abrirReporte(path, "Informe de Resultados Individuales ev_"+id_evaluacion, String.valueOf(id_evaluacion), "id_evaluacion");	                
	                
	            
	            }catch(Exception ex){
	                JOptionPane.showMessageDialog(null,"Error al cargar el reporte: "+ex, "ERROR",JOptionPane.ERROR_MESSAGE);
	                System.out.println(ex);
	            }
			  
			
		}
		
	}
}
