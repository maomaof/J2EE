package ws.utilities;
import ws.driver.*;
import ws.library.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class RunBatchFile1 implements Runnable{
	
	String startupPath ;
	public void setstartupPath(String startupPath)
	{
		this.startupPath = startupPath; 
	}
	
	public void run()
	{
		String bacthFilePath = startupPath;//"C:\\Program Files\\Safenet\\Sentinel EMS\\";
		   try
		     {
			  Runtime rt = Runtime.getRuntime() ;
		    //  Process p = rt.exec("C:\\Program Files\\SafeNet Sentinel\\Sentinel EMS\\ems-startservice.bat" );// + "ems-startserver.bat") ;
			  Process p = rt.exec(bacthFilePath);
			  System.out.println("Startup Process : " + p);
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
		        	while (!code.equals("4")){
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

		      System.out.println("SERVICE IS RUNNING");
		      //System.out.println("Exit Value of Startup Process : " + p.exitValue());
		      p.destroy();
		      //System.out.println("DONE") ;
		   }
		   catch(Exception exc)
		      {
		    	 System.out.println("Error While Starting Server ...."); 
		    	exc.printStackTrace();
		      }

      	}
	
	
}
