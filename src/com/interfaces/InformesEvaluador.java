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

public class InformesEvaluador extends JFrame {

	private JPanel contentPane;
	JLabel lbl_evaluador;
	int id_evaluacion=-1;
	

	private JTable tbl_evaluacionesFinalizadas;
	private JPanel panel_1;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblInformesEvaluaciones;

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
		setTitle("EXSHE - INFORMES");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarInformes();
			}
		});
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1366, 768);		
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
		panel.setBounds(35, 142, 1303, 580);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Historial de evaluaciones finalizadas", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 64, 1232, 492);
		panel.add(scrollPane);
		
		tbl_evaluacionesFinalizadas = new JTable();
		tbl_evaluacionesFinalizadas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int indice=tbl_evaluacionesFinalizadas.getSelectedRow();				
			
				id_evaluacion=Integer.parseInt(tbl_evaluacionesFinalizadas.getValueAt(indice,0).toString());
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
		
		JButton btnVerInforme = new JButton(" Informe");
		btnVerInforme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				verInformeDeEvaluacion();
			}
		});
		btnVerInforme.setIcon(new ImageIcon(InformesEvaluador.class.getResource("/img/ver.png")));
		btnVerInforme.setBorder(UIManager.getBorder("CheckBox.border"));
		btnVerInforme.setBackground(SystemColor.controlHighlight);
		btnVerInforme.setBounds(1139, 24, 122, 27);
		panel.add(btnVerInforme);
		
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
		cargarTabla();
	}
	
	public void cerrarInformes(){
		Object [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Está seguro que desea cerrar la ventana de informes?","Mensaje de Confirmación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
		if (eleccion == JOptionPane.YES_OPTION)
		{
			dispose();
		}else{
			
		}
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

	
		tbl_evaluacionesFinalizadas.setRowHeight(20);
		tbl_evaluacionesFinalizadas.setForeground(new Color(0,0,0));
		tbl_evaluacionesFinalizadas.setFont(new Font("Dialog", Font.PLAIN, 14));
		tbl_evaluacionesFinalizadas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbl_evaluacionesFinalizadas.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
		
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
			
			 
			JOptionPane.showMessageDialog(null,"Por favor seleccione una evaluación de la tabla para poder generar su respectivo informe");
		}else{
			
			 try{
	               
	                //String rutaInforme="\\reportes\\reporteEvaluador.jasper";
				 	String path =RutaBase.obtenerRuta()+"reporteIndividualEvaluacion.jrxml";
	                abrirReporte(path, "Reporte  individual", String.valueOf(id_evaluacion), "id_evaluacion");	                
	                
	            
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
}
