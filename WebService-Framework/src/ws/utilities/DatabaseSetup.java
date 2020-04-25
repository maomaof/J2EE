package ws.utilities;
import ws.driver.*;
import ws.library.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.collections.map.StaticBucketMap;
import org.apache.commons.io.FileUtils;


public class DatabaseSetup {
	
	static Connection con;
	static PreparedStatement EMSDatabasePS;	
	static String username;
	static String password;
	static String url;
	static int status = 0;
	static String databaseName ;
	static String serverName;
	static String port;
	static String driverClassName;
	static String databaseScriptPath ;	
	static String databaseServerPort;
	static String start;
	static String stop;
	static int webServer;
	static List<String> scriptNameList = new ArrayList<String>();
	static String databaseNameToReplace ;
	static int noOfDatabases;
	static Map<String, Properties> dbMap;
	static int cleanUp;
	static boolean runScriptsOnServerSide ;
	Client client;
	int sleepTime;
	int tomcat;
	static int tomcatPort; 
	static String scriptName = null;
    public static String webServicesList=null;
    public static String webService=null;
	static SQLScriptExecutor scriptServer =new SQLScriptExecutor();
	static int jacocosuite;
	//int count=0;
	
	public DatabaseSetup()
	{
		loadProperties();
		if(tomcat==0)
		client = new Client();
	}
	
	public void loadProperties() 
	{
		try{
			dbMap = new HashMap();
			Properties properties = new Properties();
			InputStream inStream = new FileInputStream("ConfigurationFiles/WebServiceAutomation.properties"); 
			properties.load(inStream);
			sleepTime = Integer.valueOf(properties.getProperty("sleepTime"));
			tomcat=Integer.valueOf(properties.getProperty("automationServer"));
			tomcatPort = Integer.valueOf(properties.getProperty("tomcatPort"));
			start=properties.getProperty("srvstart");//use "start" in case of using startservice.bat
			stop=properties.getProperty("srvstop");//use "stop" in case of using stopservice.bat
			webService=properties.getProperty("webService");
			webServer=Integer.valueOf(properties.getProperty("webServer"));
			int j = 1;
			String dbFileKey = "DB" + j;
			String dbName = null;
			runScriptsOnServerSide = Boolean.valueOf(properties.getProperty("runScriptsOnServerSide"));
			cleanUp = Integer.valueOf(properties.getProperty("cleanUp"));
			webServicesList=properties.getProperty("webServicesList");
			jacocosuite = Integer.valueOf(properties.getProperty("jacoco"));
			while(properties.containsKey(dbFileKey))
			{
				dbName = properties.getProperty(dbFileKey);
				loadDBPropFile(dbName, dbFileKey);
				j++;
				dbFileKey = "DB" + j;
			}
		}
		catch(Exception e)
		{
			System.out.println("Database Configuration Error .... Exiting !!");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void cleanup(String dbName, int position)
	{
		boolean startServer = false;
		boolean server =false;
		//Runnable run=new RunBatchFile1();
		
		
		
		Thread thread = null;
		RunBatchfile2 shutd=new RunBatchfile2();
		RunBatchFile1 startd=new RunBatchFile1();
		try{
					
			if(cleanUp == 0)
			{
				return;
			}
			else if(position < cleanUp)
			{
				System.out.println("Performing cleanup on db : " + dbName);
				/*
				 * when position is -1 ie forceful cleanup from input sheet then cleanup performed irrespective of 
				 * the value of cleanup property.
				 * When position and cleanup has respective values
				 * (0,1),(0,2),(1,2)- perform cleanup and (1,1)- no cleanup
				 * 
				 *  What about (0,2) ? Ans: cleanup will be performed as condition 2 superceds 0 and 1. 
				 */
				if(tomcat!=1)
				if(webServer==1)	
				{if(client.isServerOn())
				{
					/*******jacoco implementation************/
					if(jacocosuite==1)
					{	
						jacoco suite=new jacoco();
					}
					
					System.out.println("Stopping server ...........11111111");
					client.stopServer();
					Thread.sleep(10*1000);
				}
				}
				if(tomcat==1)
				if(webServer==1)	
				{	try{
					ServerSocket sc = new ServerSocket(tomcatPort);
					
					sc.close();
					
					}
					catch(BindException e)
					{	server=true;
						
					}
					if(server==true)
					{	
						/*******jacoco implementation************/
						if(jacocosuite==1)
						{	
							jacoco suite=new jacoco();
						}
						
						System.out.println("Stopping server ...........11111111");
						
						shutd.setshutdownPath(stop);
						shutd.shutdown();
						//Thread.sleep(10*1000);
					}
				}
				
				if(runScriptsOnServerSide)
				{
					if(tomcat==1)
						scriptServer.runScript();
					else
						
					client.sendMessage("runScript");
				}
				else
				{
					
					Set<String> dbNameSet = dbMap.keySet();
					Iterator<String> dbNameSetIterator = dbNameSet.iterator();
					while(dbNameSetIterator.hasNext())
					{
						dbName = dbNameSetIterator.next();
						loadProperties(dbName);
										
					// load driver and get con. only if scripts are to run from client using jdbc.
						Class.forName(driverClassName);
						con = DriverManager.getConnection(url, username, password);
						String[] dropnCreateParams = {databaseName};
						Iterator<String> it = scriptNameList.iterator();
						//if(count>0)	
							//runSqlScript("DECLARE @databaseName varchar(255) set @databaseName = 'EMSDB' DECLARE @kill varchar(8000) = ''; SELECT @kill = @kill + 'kill ' + CONVERT(varchar(5), spid) + ';' FROM master..sysprocesses WHERE dbid = db_id(@databaseName) EXEC(@kill);", null, null);
						
						while(it.hasNext() && status == 0)
						{	
							String scriptToRun = it.next();
							
							runSqlScript(null, scriptToRun, dropnCreateParams);
							//runSqlScript( scriptToRun,databaseScriptPath, dropnCreateParams);
						}
						runSqlScript("USE [EMSDB];UPDATE T_ENF SET IsEnabled = 'True' WHERE ENFName = 'Sentinel Cloud';INSERT INTO T_VENDOR_ENF (VendorId, EnfId) VALUES(1,2);UPDATE T_EMS_PROPERTIES SET IsVisible = 'True' WHERE PropertyKey = 'frequency' OR PropertyKey = 'cloudDefaultLM' OR PropertyKey = 'timezone';", null, null);
						//count++;
					}
					
				}
//						client.startServer();
				if(webServer==1)
					startServer = true;
				else
					startServer=false;
			}
				
			
//			else
//			{
//				loadProperties(dbName);
//				System.out.println("Stopping server ...........22222222222");
//				client.stopServer();
//				Thread.sleep(5000);
//								
//				if(scriptNameList.size() == 0)
//				{
//					client.sendMessage("runScript");
//				}
//				else
//				{
//					// load driver and get con. only if scripts are to run from client using jdbc.
//					Class.forName(driverClassName);
//					con = DriverManager.getConnection(url, username, password);
//					String[] dropnCreateParams = {databaseName};
//					
//					Iterator<String> it = scriptNameList.iterator();
//					while(it.hasNext() && status == 0)
//					{	
//						String scriptToRun = it.next();
//						runSqlScript(null, scriptToRun, dropnCreateParams);
//					}
//				}
////				client.startServer();
//				startServer = true;
//			}
			
			if(startServer)
			{
				System.out.println("Starting server ...........");
				if(tomcat==1)
				
				{	
					/*((RunBatchFile1)run).setstartupPath(start);
					thread = new Thread(run);
					thread.start();
					Thread.sleep(sleepTime*1000);*/
					
					startd.setstartupPath(start);
					startd.run();
					Thread.sleep(10*1000);
					
				}
				else 
				{	client.startServer();
				
				Thread.sleep(sleepTime*1000);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("ERROR while setting up databases.");
			e.printStackTrace();
			System.exit(1);
		}
		finally
		{
			try{
				if(con != null)
				{
					con.close();
				}
			}
			catch(SQLException sqle)
			{
				System.out.println("Exception while closing Connection to database.");
				sqle.printStackTrace();
			}
		}

	}
	
	private static boolean runSqlScript(String sqlScript, String sqlScriptPath, String[] params)
	{
		boolean containsResultSet = false;
		boolean scriptFileNotExists = false;
		try {
			if(sqlScriptPath!= null && !sqlScriptPath.equals(""))
			{
				System.out.println("Executing file : "+ databaseScriptPath + sqlScriptPath);
				sqlScript = FileUtils.readFileToString(new File(databaseScriptPath + sqlScriptPath));			
				sqlScript = sqlScript.replaceAll("GO", "");	
				sqlScript = sqlScript.replaceAll(databaseNameToReplace, databaseName);
			}
			
			EMSDatabasePS = con.prepareStatement(sqlScript);
//			if(params != null)
//			{
//				for(int i=0; i< params.length ; i++)
//				{
//					EMSDatabasePS.setString(i, params[i]);
//				}
//			}
			containsResultSet =  EMSDatabasePS.execute();
			if (EMSDatabasePS.getUpdateCount()!=0)
			{
				containsResultSet=true;	
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			status = 1;
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
			scriptFileNotExists = true;
			status = 1;
		}  	finally {
			try
			{
				if(EMSDatabasePS != null)
				{
					EMSDatabasePS.close();
				}
			}
			catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return containsResultSet ;
	}
	public boolean executeQuery(String dbNameToRunQuery, String sqlQuery)
	{
		boolean result = false;
		try{
			loadProperties(dbNameToRunQuery);
		//	Class.forName(driverClassName);
			con = DriverManager.getConnection(url, username, password);
			
			result = runSqlScript(sqlQuery, null, null);
		}
		catch(SQLException sqlEx)
		{
			sqlEx.printStackTrace();
		}
		finally
		{
			try
			{
				if(con != null)
				{
					con.close();
				}
			}
			catch(SQLException sqle)
			{
				System.out.println("Exception while closing Connection to database.");
				sqle.printStackTrace();
			}
		}
		return result;
	}
	
	private void loadDBPropFile(String dbName, String fileName)
	{
		try
		{
			Properties properties = new Properties();
			InputStream inStream = new FileInputStream("DatabaseConfiguration/"+fileName+".properties"); 
			properties.load(inStream);
			dbMap.put(dbName, properties);
		}
		catch(Exception ex)
		{
			System.out.println("Database Configuration Error .... Exiting !!");
			ex.printStackTrace();
			System.exit(1);
		}
		
	}
	public static void loadProperties(String dbName)
	{
		try{
			Properties properties = new Properties();
			InputStream inStream = new FileInputStream("ConfigurationFiles/WebServiceAutomation.properties");
			properties.load(inStream);			
			properties = dbMap.get(properties.getProperty(dbName));
			if(properties == null)
				properties = dbMap.get(dbName);
			username = properties.getProperty("databaseServerUsername");
			password = properties.getProperty("databaseServerPassword");
			url = properties.getProperty("databaseServerName");
			databaseServerPort = properties.getProperty("databaseServerPort");
			url = url + ":" + databaseServerPort ; // jdbc:sqlserver://noi1-501589:1433
			databaseName = properties.getProperty("databaseName");
			databaseScriptPath = properties.getProperty("databaseScriptPath");
			driverClassName = properties.getProperty("driverClassName");
			
			
			databaseNameToReplace = properties.getProperty("databaseNameToReplace");
//			cleanUp = Integer.valueOf((properties.getProperty("cleanUp")));
			
			int i = 1;
			String key;			
			key = "script" + i; 
			
			 scriptName = null;
			scriptNameList.clear();
					
			while(properties.containsKey(key))
			{
				scriptName = properties.getProperty(key);
				scriptNameList.add(scriptName) ;
				i++;
				key = "script" + i;
			}
		}catch(Exception ex)
		{
			System.out.println("Could not load properties for dbName : " + dbName);
			ex.printStackTrace();
			System.exit(1);
		}
	}
	public void stopServer()
	{	
		if(tomcat!=1)
		{client.stopServer();
		client.endConnection();
		}
	
	}
}
