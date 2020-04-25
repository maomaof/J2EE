package selenium.utilities;


import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import selenium.utilities.ConfigurationReader;



public class Mail {
	private static String mailSenderHost,mailFrom,mailTo,mailCC,mailBCC,mailSubject,mailBody,externalFile;	
	public static boolean sendMail(int totalTest,int failTest,String logFiles[],int warningTest) throws FileNotFoundException,IOException, AddressException, MessagingException,SendFailedException
	{
		try
		{
			/*Get the configurable items from properties file */
			ConfigurationReader p=new ConfigurationReader("ConfigurationFiles/configuration.properties");
			
			mailSenderHost=p.getPropertyValue("mailSenderHost");
			mailFrom=p.getPropertyValue("mailFrom");
			mailTo=p.getPropertyValue("mailTo");
			mailCC=p.getPropertyValue("mailCC");
			mailBCC=p.getPropertyValue("mailBCC");
			mailSubject=p.getPropertyValue("mailSubject")+" "+p.getPropertyValue("productName")+" "+p.getPropertyValue("version")+" build "+p.getPropertyValue("build");
			long passPerc=(long)(((totalTest-failTest)*100)/totalTest);
			mailBody=p.getPropertyValue("mailBody")+"<br><br><br><table border = 1><th>Test Summary</th><tr><td><font size =4.5>Total Test Cases</td><td><font size =4.5>"+totalTest+"</font></td></tr><tr><td><font size = 4 color = green>Pass Test Cases</td><td><font size = 4 color = green>"+(totalTest-failTest)+"</td></tr><tr><td></font><font color = red size = 3>Fail Test Cases</td><td><font color = red size = 3>"+failTest+"</font></td></tr><tr><td><font color = green size = 3>Pass Percentage</td><td><font color = green size = 3>"+passPerc+"</font></td></tr><tr><td><font color = Orange size = 3>Pass with Warning TestCases </td><td><font color = Orange size = 3>"+warningTest;
			try{
				externalFile=p.getPropertyValue("externalFilePath");
			}catch(Exception e)
			{
				externalFile=null;
			}
			
			
			File zipFile = new File(logFiles[2]);
			
			/*Get System Properties*/
			Properties props=System.getProperties();
			props.put("mail.smtp.host", mailSenderHost);
			/*Create a session with server*/
			Session session=Session.getInstance(props,null);
			
			boolean debug=false;
			session.setDebug(debug);
			/*Creating Subject, Body , Attachments */
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailFrom));
			if(!mailTo.isEmpty())
			{
			/*mail to To*/
			String[] To=mailTo.split(",");
			InternetAddress[] toAddress = new InternetAddress[To.length];
			for (int i = 0; i < To.length; i++)
			   toAddress[i] = new InternetAddress(To[i]);
			message.setRecipients(Message.RecipientType.TO, toAddress); 
			}
			/*mail to CC*/
			if(!mailCC.isEmpty())
			{
			String[] CC=mailCC.split(",");
			InternetAddress[] CCAddress = new InternetAddress[CC.length];
			for (int i = 0; i < CC.length; i++)
			   CCAddress[i] = new InternetAddress(CC[i]);
			message.setRecipients(Message.RecipientType.CC, CCAddress); 
			}
			if(!mailBCC.isEmpty())
			{
			/*mail to BCC*/
			String[] BCC=mailBCC.split(",");
			InternetAddress[] BCCAddress = new InternetAddress[BCC.length];
			for (int i = 0; i < BCC.length; i++)
			   BCCAddress[i] = new InternetAddress(BCC[i]);
			message.setRecipients(Message.RecipientType.BCC, BCCAddress); 
			}
			message.setSubject(mailSubject);
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			String[] attachment = logFiles;
			if(externalFile!=null&&!externalFile.equals(""))
			{	List list = new ArrayList(Arrays.asList(attachment));
				list.add(externalFile);
				
				attachment=null;
				attachment=(String[]) list.toArray(new String[list.size()]);
			}
			
			MimeBodyPart messageBodyPartAttachedFile0,messageBodyPartAttachedFile1,messageBodyPartAttachedFile2,messageBodyPartAttachedFile3;
			messageBodyPartAttachedFile0=new MimeBodyPart();
			messageBodyPartAttachedFile1=new MimeBodyPart();
			messageBodyPartAttachedFile2=new MimeBodyPart();
			messageBodyPartAttachedFile3=new MimeBodyPart();
			
			for(int i=0;i<attachment.length;i++)
			{
				switch(i)
				{
					case 0:
						messageBodyPartAttachedFile0.attachFile(attachment[i]);
						break;
					case 1:
						
						messageBodyPartAttachedFile1.attachFile(attachment[i]);
						break;
					case 2:
						
						messageBodyPartAttachedFile2.attachFile(attachment[i]);
						break;
					case 3:
						
						messageBodyPartAttachedFile3.attachFile(attachment[i]);
						break;
						
				}
			}
			
			Multipart mp=new MimeMultipart();
		
			long size = zipFile.length(); // calculating size of images.zip
			size =size/1000;   //size in kb
			if(failTest>0||warningTest>0&&size<10000)//if size < 10 MB
				messageBodyPart.setText(mailBody,"US-ASCII","html");
			else if(failTest==0) // if no fail test
			{	mailBody=p.getPropertyValue("mailBody2")+"<br><br><br><table border = 1><th>Test Summary</th><tr><td><font size =4.5>Total Test Cases</td><td><font size =4.5>"+totalTest+"</font></td></tr><tr><td><font size = 4 color = green>Pass Test Cases</td><td><font size = 4 color = green>"+(totalTest-failTest)+"</td></tr><tr><td></font><font color = red size = 3>Fail Test Cases</td><td><font color = red size = 3>"+failTest+"</font></td></tr><tr><td><font color = green size = 3>Pass Percentage</td><td><font color = green size = 3>"+passPerc+"</font></td></tr><tr><td><font color = Orange size = 3>Pass with Warning TestCases </td><td><font color = Orange size = 3>"+warningTest;
			messageBodyPart.setText(mailBody,"US-ASCII","html");
			}
			else if(size>=10000) //if size>10MB
			{	mailBody=p.getPropertyValue("mailBody")+"<br>Note: Due to Large Size of images.zip we are unable to mail it.<br>For images.zip please visit "+p.getPropertyValue("logLocation")+"<br><br><br><table border = 1><th>Test Summary</th><tr><td><font size =4.5>Total Test Cases</td><td><font size =4.5>"+totalTest+"</font></td></tr><tr><td><font size = 4 color = green>Pass Test Cases</td><td><font size = 4 color = green>"+(totalTest-failTest)+"</td></tr><tr><td></font><font color = red size = 3>Fail Test Cases</td><td><font color = red size = 3>"+failTest+"</font></td></tr><tr><td><font color = green size = 3>Pass Percentage</td><td><font color = green size = 3>"+passPerc+"</font></td></tr><tr><td><font color = Orange size = 3>Pass with Warning TestCases </td><td><font color = Orange size = 3>"+warningTest;
			messageBodyPart.setText(mailBody,"US-ASCII","html");
			}
			mp.addBodyPart(messageBodyPart);
			for(int i=0;i<attachment.length;i++)
			{
				switch(i)
				{
					case 0:
						mp.addBodyPart(messageBodyPartAttachedFile0);
						break;
					case 1:
						mp.addBodyPart(messageBodyPartAttachedFile1);
						break;
					case 2:
						if(failTest>0||warningTest>0&&size<10000)
							mp.addBodyPart(messageBodyPartAttachedFile2);
						break;
					case 3:
						mp.addBodyPart(messageBodyPartAttachedFile3);
						break;
						
				}
			}
			
			message.setContent(mp,"text/html");
			
			
			try
			{	System.out.println("sending Mail");
				Transport.send(message);
				System.out.println("Mail Sent");
			}
			
			catch(SendFailedException sfe)
			{
				message.setRecipients(Message.RecipientType.TO,  sfe.getValidUnsentAddresses());
			 	Transport.send(message);
			}
		}	
		catch(IOException io)
		{
			io.printStackTrace();
		}
		
		
		return true;
		}
	
}
