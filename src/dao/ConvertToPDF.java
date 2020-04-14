package dao;
import java.io.*;
import java.util.*;
import utility.*;
import java.sql.*; 
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
public class ConvertToPDF {
public void ConverToPDF() throws SQLException, ClassNotFoundException, FileNotFoundException, DocumentException {
	 
	Connection con = ConnectionManager.getConnection();
	 Statement st = con.createStatement();
     ResultSet query_set = st.executeQuery("SELECT id,empname,dept,salary,age,post FROM employeedetails");
     
     Document my_pdf_report = new Document();
   
     PdfWriter.getInstance(my_pdf_report, new FileOutputStream("EmpDetails.pdf"));
     my_pdf_report.open();            
    
     Paragraph p1 = new Paragraph( "EMPLOYEE DETAILS \n");
     p1.setAlignment(Paragraph.ALIGN_CENTER);
     my_pdf_report.add(p1);
     Paragraph l = new Paragraph("__________________________________________________________________________\n\n");
	 my_pdf_report.add(l);
     PdfPTable my_report_table = new PdfPTable(6);
     PdfPCell table_cell;
     
     String h1 = "Employee_id";
     table_cell=new PdfPCell(new Phrase(h1));
     my_report_table.addCell(table_cell);
     String h2 = "Employee_ame";
     table_cell=new PdfPCell(new Phrase(h2));
     my_report_table.addCell(table_cell);
     String h3 = "Department";
     table_cell=new PdfPCell(new Phrase(h3));
     my_report_table.addCell(table_cell);
     String h4 = "Salary";
     table_cell=new PdfPCell(new Phrase(h4));
     my_report_table.addCell(table_cell);
     String h5 = "Age";
     table_cell=new PdfPCell(new Phrase(h5));
     my_report_table.addCell(table_cell);
     String h6 = "Post";
     table_cell=new PdfPCell(new Phrase(h6));
     my_report_table.addCell(table_cell);
 
    
     while (query_set.next()) {                
                     String Eid = query_set.getString("id");
					table_cell=new PdfPCell(new Phrase(Eid));
                     my_report_table.addCell(table_cell);
                     String emp_name=query_set.getString("empname");
                     table_cell=new PdfPCell(new Phrase(emp_name));
                     my_report_table.addCell(table_cell);
                     String Dept=query_set.getString("dept");
                     table_cell=new PdfPCell(new Phrase(Dept));
                     my_report_table.addCell(table_cell);
                     String Salary=query_set.getString("salary");
                     table_cell=new PdfPCell(new Phrase(Salary));
                     my_report_table.addCell(table_cell);
                     String Age=query_set.getString("Age");
                     table_cell=new PdfPCell(new Phrase(Age));
                     my_report_table.addCell(table_cell);
                     String Post=query_set.getString("post");
                     table_cell=new PdfPCell(new Phrase(Post));
                     my_report_table.addCell(table_cell);
                     
                     }
     
     my_pdf_report.add(my_report_table);                       
     my_pdf_report.close();
     
     
     query_set.close();
     st.close(); 
     con.close();               
	}
}