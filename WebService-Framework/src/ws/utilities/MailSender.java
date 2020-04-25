package ws.utilities;
import ws.driver.*;
import ws.library.*;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;
import java.io.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

// Send a simple, single part, text/plain e-mail
public class MailSender {

    public void sendMail(String message){
    	try {
    	Properties properties = new Properties();
		InputStream inStream = new FileInputStream("ConfigurationFiles/WebServiceAutomation.properties"); 
		properties.load(inStream);
		String mailingListing[] = properties.getProperty("mailingListing").split(",");
		if(mailingListing == null)
		{
			System.out.println("Mailing List is empty.");
			return;
		}
    	
        // SUBSTITUTE YOUR EMAIL ADDRESSES HERE!!!
        String from = properties.getProperty("mailFrom");
        // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!!!
        String host = properties.getProperty("mailServer");

        String subject = properties.getProperty("mailSubject");
         String fileAttachment = properties.getProperty("fileAttachment");
         
         File file = new  File(fileAttachment);
         //getCanonicalPath is added by Anuja Upreti  Date 25 May 2011
         String path = file.getCanonicalPath();
          String output;
          output ="\\output\\";
          int occurance;
          occurance =path.lastIndexOf('\\');   
          //System.out.println("Anuja"+occurance);
             String new_path;
             new_path =path.substring(0,occurance);
             System.out.println(new_path);
             new_path= new_path+output;
            new_path=new_path+fileAttachment;
           System.out.println(new_path);
          //Create properties, get Session
        Properties props = new Properties();

        // If using static Transport.send(),
        // need to specify which host to send it to
        props.put("mail.smtp.host", host);
        // To see what is going on behind the scene
        props.put("mail.debug", "false");
        Session session = Session.getInstance(props);
        
        // Instantiatee a message
        Message msg = new MimeMessage(session);

        //Set message attributes
        msg.setFrom(new InternetAddress(from));
        msg.setSubject(subject);
        
        InternetAddress[] address = new InternetAddress[mailingListing.length];
		for (int i = 0; i < mailingListing.length; i++)
		   address[i] = new InternetAddress(mailingListing[i]);
		msg.setRecipients(Message.RecipientType.TO, address); 
		
        
        
        msg.setDataHandler(new DataHandler(new HTMLDataSource(message)));
        
            if(fileAttachment != null)
            {
            	setFileAsAttachment(msg, new_path, message);
            }
        	
        //Send the message
        Transport.send(msg);
        System.out.println("Mail Sent Successfully");
        }
        catch (Exception mex) {
            // Prints all nested (chained) exceptions as well
            mex.printStackTrace();
        }
    }
    
    // Set a file as an attachment.  Uses JAF FileDataSource.
    public static void setFileAsAttachment(Message msg, String filename, String htmlMessage)
             throws MessagingException {

        // Create and fill first part
        MimeBodyPart p1 = new MimeBodyPart();
        p1.setText(htmlMessage,"US-ASCII","html");

        // Create second part
        MimeBodyPart p2 = new MimeBodyPart();

        // Put a file in the second part
        FileDataSource fds = new FileDataSource(filename);
        p2.setDataHandler(new DataHandler(fds));
        p2.setFileName(fds.getName());

        // Create the Multipart.  Add BodyParts to it.
        Multipart mp = new MimeMultipart();
        mp.addBodyPart(p1);
        mp.addBodyPart(p2);

        // Set Multipart as the message's content
        msg.setContent(mp);
    }
    
    public static void main(String [] a) throws Exception
    {
    	MailSender sender = new MailSender();
    	sender.sendMail("");
    }
}//End of class


class HTMLDataSource implements DataSource {
    private String html;

    public HTMLDataSource(String htmlString) {
        html = htmlString;
    }

    // Return html string in an InputStream.
    // A new stream must be returned each time.
    public InputStream getInputStream() throws IOException {
        if (html == null) throw new IOException("Null HTML");
        return new ByteArrayInputStream(html.getBytes());
    }

    public OutputStream getOutputStream() throws IOException {
        throw new IOException("This DataHandler cannot write HTML");
    }

    public String getContentType() {
        return "text/html";
    }

    public String getName() {
        return "JAF text/html dataSource to send e-mail only";
    }
}
