package ws.utilities;
import ws.driver.*;
import ws.library.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Properties;


public class SQLScriptExecutor {
	
	String scriptPath ;
	public void setscriptPath(String scriptPath)
	{
		this.scriptPath = scriptPath; 
	}
	
	public void runScript()
	{
		String scriptFilePath = scriptPath;//"C:\\Program Files\\Safenet\\Sentinel EMS\\";
		   try
		     {
			   
			   Properties properties = new Properties();
			   InputStream inStream = new FileInputStream("ConfigurationFiles/WebServiceAutomation.properties"); 
			   properties.load(inStream);
			   String scriptLocationOnServer = properties.getProperty("scriptLocationOnServer");
		      Runtime rt = Runtime.getRuntime() ;
		      //TODO : make code generic for windows and linux "ubuntu", "temp123","sudo -s","temp123",
		      String [] cmds = {scriptLocationOnServer}; 
		      Process process = rt.exec(cmds);// + "ems-stopserver.bat") ;
		      System.out.println("Script Execution Process new : " + process);
		      InputStream i = process.getInputStream();
		      
		      InputStream is = process.getInputStream();
		       InputStreamReader isr = new InputStreamReader(is);
		       BufferedReader br = new BufferedReader(isr);
		       String line;
		       
		       while ((line = br.readLine()) != null) {
		         System.out.println(line);
		       }
		       
		       is = process.getErrorStream();
		       isr = new InputStreamReader(is);
		       br = new BufferedReader(isr);
		       while ((line = br.readLine()) != null) {
			         System.out.println(line);
			       }
//		      OutputStream os = p.getOutputStream();
		      
		      process.destroy();
		      System.out.println("DONE With Script Execution") ;
		      }catch(Exception exc)
		      {
		    	System.out.println("ERRORR In Script Execution ....");  
		    	exc.printStackTrace();
		      }
	}
	
	public static void main(String [] a)
	{
		SQLScriptExecutor executor = new SQLScriptExecutor();
		executor.runScript();
	}
	
}
