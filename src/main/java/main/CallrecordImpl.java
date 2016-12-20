package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Callrecord;
import dao.CallrecordRepository;


@Service
public class CallrecordImpl {

	@Autowired
	CallrecordRepository call;
	
	Date date = new Date();
	@SuppressWarnings("deprecation")
	String date1;

	public CallrecordImpl() {
		this.date1 = this.getDateString(0);
	}

	public void printS() {
		
		List<Callrecord> c =  getCallrecords();
//		createExcel(c);
		createCSV(c);
	}
	
	public List<Callrecord> getCallrecords(){
		
		@SuppressWarnings("deprecation")
		String date2 = String.valueOf(this.getDateString(-2)) + " 21:00:00.00";
		final long oDestination = 3727151188L; 
		long origdestB = 3727151010L; 
		long origdestS = 3727151026L;
		return call.getCalls(date2, oDestination, origdestB, origdestS);
		
	}
	
	
	public void createCSV(List<Callrecord> c){
		
		
		
		
		try {
			FileWriter fstream = 
		            new FileWriter("C:\\detailraport\\CALL_CENTER_DETAIL_" + date1 + ".csv");
		    BufferedWriter out = new BufferedWriter(fstream);
		    out.write( "callid;origdestination;origin;callstart;queuestart;"+
					"callend;disconnecttime;calltypekey;calltypestepnum;"+
					"contacttype;termtype;answeringagent;queueend;"+""
							+ "waittime;waitresolution;caption;redirect;\r\n");
		    
			
			for(Callrecord o: c)
			{
				out.write(	o.getId() + ";" + o.getOrigdestination() + ";" + o.getOrigin()+";"
									+ o.getCallstart() + ";" + o.getQueuestart() + ";" + o.getCallend() + ";"
									+ o.getDisconnecttime() + ";" + o.getCalltypekey() + ";" + o.getCalltypestepnum()
									+ ";" + o.getContacttype() + ";" + o.getTermtype() + ";" + o.getAnsweringagent() 
									+ ";"+ o.getQueueend() + ";"+ o.getWaittime() + ";" + o.getWaitresolution() 
									+ ";" + o.getCaption() + ";" + o.getRedirect() + ";\r\n");
			}
			
			out.close();
			fstream.close();
			System.out.println("CSV written successfully.."); 
			
			
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
public void createExcel(){
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Sample sheet");
		 
		int rownum = 0;
		int cellnum = 0;
		
		Row row = sheet.createRow(rownum++);
		addCell("callid",row,cellnum++);
		addCell("origdestination",row,cellnum++);
		addCell("origin",row,cellnum++);
		addCell("callstart",row,cellnum++);
		addCell("queuestart",row,cellnum++);
		addCell("callend",row,cellnum++);
		addCell("disconnecttime",row,cellnum++);
		addCell("calltypekey",row,cellnum++);
		addCell("calltypestepnum",row,cellnum++);
		addCell("contacttype",row,cellnum++);
		addCell("termtype",row,cellnum++);
		addCell("answeringagent",row,cellnum++);
		addCell("queueend",row,cellnum++);
		addCell("waittime",row,cellnum++);
		addCell("waitresolution",row,cellnum++);
		addCell("caption",row,cellnum++);

		
		for (Callrecord cr : getCallrecords()) {
			row = sheet.createRow(rownum++);
		    cellnum = 0;
		    
	        addCell(cr.getId(),row,cellnum++);
	        addCell(cr.getOrigdestination(),row,cellnum++);
	        addCell(cr.getOrigin(),row,cellnum++);
	        addCell(cr.getCallstart(),row,cellnum++);
	        addCell(cr.getQueuestart(),row,cellnum++);
	        addCell(cr.getCallend(),row,cellnum++);
	        addCell(cr.getDisconnecttime(),row,cellnum++);
	        addCell(cr.getCalltypekey(),row,cellnum++);
	        addCell(cr.getCalltypestepnum(),row,cellnum++);
	        addCell(cr.getContacttype(),row,cellnum++);
	        addCell(cr.getTermtype(),row,cellnum++);
	        addCell(cr.getAnsweringagent(),row,cellnum++);
	        addCell(cr.getQueueend(),row,cellnum++);
	        addCell(cr.getWaittime(),row,cellnum++);
	        addCell(cr.getWaitresolution(),row,cellnum++);
	        addCell(cr.getCaption(),row,cellnum++);
		}
		 
		try {
		    FileOutputStream out = 
		            new FileOutputStream(new File("C:\\detailraport\\" + date1 + ".xls"));
		    workbook.write(out);
		    out.close();
		    System.out.println("Excel written successfully..");
		     
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	



	public void addCell(String s, Row row, int cellnum){
		Cell cell = row.createCell(cellnum);
		cell.setCellValue((String)s);
	}
	
	public void addCell(long l, Row row, int cellnum){
		Cell cell = row.createCell(cellnum);
		cell.setCellValue((long)l);
	}

	private String getDateString(int a) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(5, a);
		return dateFormat.format(cal.getTime());
	}

	

	
}
