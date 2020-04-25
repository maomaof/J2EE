package ws.utilities;
import ws.driver.*;
import ws.library.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class RunBatchfile2 {
	
	String shutdownPath ;
	
	public void setshutdownPath(String shutdownPath)
	{
		this.shutdownPath = shutdownPath; 
	}
	
	public void shutdown()
	{
		String bacthFilePath = shutdownPath;//"C:\\Program Files\\Safenet\\Sentinel EMS\\";
		   try
		     {
		      Runtime rt = Runtime.getRuntime() ;
		      Process p = rt.exec(bacthFilePath);
		      System.out.println("Shutdown Process : " + p);
		      InputStream i = p.getInputStream();
		      while(i.read() != -1)
		      {
		        i.read();
		        
		      }
		      
		      InputStream errInStr = p.getErrorStream();
		      while(errInStr.read() != -1)
		      {
		    	  errInStr.read();
		      }
		      /**code to find the return code of the service*/
		       	String cmd = "sc query sentinelEMS";
		        Runtime run = Runtime.getRuntime();
		        BufferedReader buf=null;
		        InputStreamReader isr=null;
		        String code="0";
		        try {
		        	while (!code.equals("1")){ //1 is the return for stopped service.
			        	Process pr = run.exec(cmd);
	                    pr.waitFor();
	                    isr =new InputStreamReader(pr.getInputStream());
	                    buf = new BufferedReader(isr);
	                    String line = "";
	                    String[] sqlState;
	                    String[] sqlCode;
                  	while ((line = buf.readLine()) != null) {
	                                    if(line.trim().indexOf("STATE")!=-1){
	                                                    sqlState=line.trim().split(":");
	                                                    sqlCode=sqlState[1].trim().split(" ");
	                                                    code=sqlCode[0].trim();
	                                                    break;
	                                    }
	                    }
	                }
                                    
		        	}
		        	finally{
		        			try{
                                  buf.close();
                                  isr.close();
		        				}catch(Exception e){
                                  try{
                                                  isr.close();
                                  }catch(Exception ie){
                                                  ie.printStackTrace();
                                  }
                  }
                  buf=null;
                  isr=null;
		        	}

		      System.out.println("SERVICE STOPPED.");
		      
		      //System.out.println("Exit Value of shutdown Process : " + p.exitValue());
		      p.destroy();
		      //System.out.println("DONE With Shutdown") ;
		      }catch(Exception exc)
		      {
		    	System.out.println("Error While Shutting down Server ....");  
		    	exc.printStackTrace();
		      }

        

		
	}
}
