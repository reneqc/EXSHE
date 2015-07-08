package com.reportes;

import java.sql.Connection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public abstract class AbstractReport {
	private static JasperReport report;
	private static JasperPrint reporFilled;
	private static JasperViewer viewer;
	
	public static void createReport(Connection cn, String path){
		try {
			report = (JasperReport)JRLoader.loadObjectFromFile(path);
			reporFilled = JasperFillManager.fillReport(report,null, cn);			
		} catch (JRException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
	
	public static void showViewer(){
		viewer = new JasperViewer(reporFilled);
		viewer.setVisible(true);
	}
	
	public static void exportToPDF(String destinoPath){
		try {
			JasperExportManager.exportReportToPdfFile(reporFilled, destinoPath);
		} catch (JRException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
