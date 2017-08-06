package Dao;

import Entities.Customer;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileOutputStream;
import java.util.*;


public class Pdf {

    //    public  static void mailsend(String key, String email,String fm ) throws MessagingException {
               /* Create Connection objects */
    public void createpdf(String regno,String email)throws Exception {
        String host = "smtp.gmail.com";
        String from = "rtsskmit@gmail.com";
        String pass = "rtssmini";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true"); // added this line
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        System.out.println("hellllooooooooooo");
        String[] to = {email}; // added this line
//        Class.forName ("com.mysql.jdbc.Driver");
        //      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "CDKcdk11");
        //    Statement stmt = conn.createStatement();
        //  Statement stmt1 = conn.createStatement();
                /* Define the SQL query */
        //ResultSet query_set = stmt.executeQuery("SELECT DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER_ID,LOCATION_ID FROM DEPARTMENTS");
        //ResultSet query_set1 = stmt1.executeQuery("SELECT DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER_ID,LOCATION_ID FROM DEPARTMENTS");
                /* Step-2: Initialize PDF documents - logical objects */
        Document my_pdf_report = new Document();
        PdfWriter.getInstance(my_pdf_report, new FileOutputStream("Supplier Details Report" + regno + ".pdf"));

        my_pdf_report.open();
        ServiceOrderDAOImpl ser = new ServiceOrderDAOImpl();

        Map<String, Integer> map = ser.getServiceOrder(regno);

        // my_pdf_report.open();
        Image imgsup = Image.getInstance("pic.PNG");

        my_pdf_report.add(imgsup);
        my_pdf_report.add(new Paragraph("Supplier Details Report", FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.GREEN)));
        my_pdf_report.add(new Paragraph(new Date().toString()));
        my_pdf_report.add(new Paragraph("----------------------------------------------------------------------------------------------------------------"));
        my_pdf_report.add(new Paragraph("                "));
        PdfPTable tablesup = new PdfPTable(2);
        System.out.println("1st");

        PdfPCell cell = new PdfPCell(new Paragraph("Customer Information"));
        tablesup.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        cell.setColspan(8);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GREEN);
        tablesup.addCell(cell);
        CustomerDAOImpl cust = new CustomerDAOImpl();
        Customer customer = cust.getCustomer(regno);
        tablesup.addCell("Registration number");
        tablesup.addCell(customer.getRegNo());
        tablesup.addCell("Name");
        tablesup.addCell(customer.getName());
        tablesup.addCell("Email");
        tablesup.addCell(customer.getEmail());
        tablesup.addCell("Booking date");
        tablesup.addCell(customer.getBookingDate().toString());
        tablesup.addCell("Mobile Number");
        tablesup.addCell(Long.toString(customer.getMobileNo()));
        PdfPCell cell1 = new PdfPCell(new Paragraph("Service Information"));
        tablesup.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        cell1.setColspan(8);
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setBackgroundColor(BaseColor.GREEN);
        tablesup.addCell(cell1);

        tablesup.addCell("SERVICE NAME");
        tablesup.addCell("PRICE");
        //tablesup.addCell("Address");
        //tablesup.addCell("Contact Info");

        // tablesup.addCell(cell);
        Set keyset = map.keySet();
        int sum = 0;
        Iterator lt = keyset.iterator();
        while (lt.hasNext()) {
            System.out.println("2nd");
            //String dept_id = query_set.getString("DEPARTMENT_ID");
            String s = lt.next().toString();
            tablesup.addCell(s);
            Integer i = map.get(s);
            sum += i;
            //String dept_name=query_set.getString("DEPARTMENT_NAME");
            tablesup.addCell(Integer.toString(i));


            /*String manager_id=query_set.getString("MANAGER_ID");
            tablesup.addCell(manager_id);
            String location_id=query_set.getString("LOCATION_ID");
            tablesup.addCell(location_id);
        */
        }
        double cgst=(sum*9)/100;
        double sgst=(sum*9)/100;
        double gtotal=sum+cgst+sgst;
        tablesup.addCell("TOTAL");
        tablesup.addCell(Integer.toString(sum));
        tablesup.addCell("+CGST");
        tablesup.addCell(Double.toString(cgst));
        tablesup.addCell("+SGST");
        tablesup.addCell(Double.toString(sgst));
        tablesup.addCell("GRAND TOTAL");
        tablesup.addCell(Integer.toString(sum));
        //query_set.close();
        my_pdf_report.add(tablesup);
        //added
        /*
        my_pdf_report.add(new Paragraph("----------------------------------------------------------------------------------------------------------------"));
        my_pdf_report.add(new Paragraph("                "));
        PdfPTable tablesup1= new PdfPTable(4);

        PdfPCell cell1 = new PdfPCell(new Paragraph("Supplier Information"));

        cell1.setColspan(8);
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setBackgroundColor(BaseColor.CYAN);
        tablesup1.addCell(cell);
        tablesup1.addCell("Supplier ID");
        tablesup1.addCell("Supplier Name");
        tablesup1.addCell("Address");
        tablesup1.addCell("Contact Info");

        // tablesup.addCell(cell);

        while (query_set1.next()) {

            String dept_id = query_set1.getString("DEPARTMENT_ID");
            System.out.print(dept_id);
            tablesup1.addCell(dept_id);
            System.out.print("after"+dept_id);
            String dept_name=query_set1.getString("DEPARTMENT_NAME");
            tablesup1.addCell(dept_name);

            String manager_id=query_set1.getString("MANAGER_ID");
            tablesup1.addCell(manager_id);
            String location_id=query_set1.getString("LOCATION_ID");
            tablesup1.addCell(location_id);
        }
//added
        my_pdf_report.add(tablesup1);
        JOptionPane.showMessageDialog(null, "Report Saved...");

        my_pdf_report.close();

                /* Close all DB related objects */
        /*query_set.close();
        query_set1.close();
        stmt.close();
        conn.close();
*/
        my_pdf_report.close();
        System.out.println("3rd");
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));

        InternetAddress[] toAddress = new InternetAddress[to.length];

        // To get the array of addresses
        for (int i = 0; i < to.length; i++) { // changed from a while loop
            toAddress[i] = new InternetAddress(to[i]);
        }
        System.out.println(Message.RecipientType.TO);

        for (int i = 0; i < toAddress.length; i++) { // changed from a while loop
            message.addRecipient(Message.RecipientType.TO, toAddress[i]);
        }
        message.setSubject("sending invoice");
        message.setText("Message sent");
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();

        String filename = "Supplier Details Report" + regno + ".pdf";//change accordingly

        DataSource source = new FileDataSource(filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(filename);


        Multipart multipart = new MimeMultipart();

        multipart.addBodyPart(messageBodyPart2);

        message.setContent(multipart);

        Transport transport = session.getTransport("smtp");
        transport.connect(host, from, pass);
        transport.sendMessage(message, message.getAllRecipients());
//        i++;
        transport.close();
    }
}

