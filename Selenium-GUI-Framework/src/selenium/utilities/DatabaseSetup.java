package selenium.utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import selenium.utilities.ConfigurationReader;

import org.apache.commons.io.FileUtils;


public class DatabaseSetup {
	
	static Connection con;
	static PreparedStatement EMSDatabasePS;	
	static String username;
	static String password;
	static String url;
	static String dbServer;
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
	static ConfigurationReader configuration;
	int sleepTime;
	int tomcat;
	static int tomcatPort;
	
	public DatabaseSetup()
	{
		configuration = new ConfigurationReader("ConfigurationFiles/DB1.properties");
		dbServer = configuration.getPropertyValue("dbServer");
		try{
				if(dbServer.equals("sqlserver"))
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				else
					Class.forName("com.mysql.jdbc.Driver");
		
		url=configuration.getPropertyValue("databaseServerName");
		username=configuration.getPropertyValue("databaseServerUsername");
		password=configuration.getPropertyValue("databaseServerPassword");
		con = DriverManager.getConnection(url, username, password);
		databaseName=configuration.getPropertyValue("databaseName");
		databaseNameToReplace=configuration.getPropertyValue("databaseNameToReplace");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static void cleanup()
	{
		
		try{	int k =1;
				for(int i =1;;i++)
				{
					scriptNameList.clear();
					File file = new File("ConfigurationFiles/DB"+i+".properties");
					if(!file.exists())
						break;
					configuration = new ConfigurationReader("ConfigurationFiles/DB"+i+".properties");
					int j;
					for( j=1;;j++)
					{	
							
							String temp=configuration.getPropertyValue("script"+j);
							if(temp==null)
								break;
							scriptNameList.add(temp);
							
							
						
					}
					
					if(k==i)
					{// load driver and get con. only if scripts are to run from client using jdbc.
						dbServer = configuration.getPropertyValue("dbServer");
						if(dbServer.equals("sqlserver"))
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						else
							Class.forName("com.mysql.jdbc.Driver");
						url=configuration.getPropertyValue("databaseServerName");
						username=configuration.getPropertyValue("databaseServerUsername");
						password=configuration.getPropertyValue("databaseServerPassword");
						con = DriverManager.getConnection(url, username, password);
					}	
						
						databaseScriptPath=configuration.getPropertyValue("databaseScriptPath");
						databaseName=configuration.getPropertyValue("databaseName");
						System.out.print("Performing Database Cleanup on :"+databaseName);
						databaseNameToReplace=configuration.getPropertyValue("databaseNameToReplace");
						String[] dropnCreateParams = {databaseName};
						if(dbServer.equals("sqlserver"))
						{
						String sql1="master";
						String sql2="restore";
						scriptNameList.add(0,sql1);
						scriptNameList.add(sql2);
						}
						Iterator<String> it = scriptNameList.iterator();
						while(it.hasNext() && status == 0)
						{	
							String scriptToRun = it.next();
							runSqlScript(null, scriptToRun, dropnCreateParams);
						}
						k++;
					}
				}
//				
					
//			
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
			
			if(sqlScriptPath.equals("master"))
			{
				sqlScript="USE master; ALTER DATABASE "+databaseName+" SET SINGLE_USER WITH ROLLBACK IMMEDIATE;";
			}
			else if (sqlScriptPath.equals("restore"))
			{	
				sqlScript="USE master; ALTER DATABASE "+databaseName+" SET MULTI_USER;";
			}
			else if(sqlScriptPath!= null && !sqlScriptPath.equals(""))
			{
				System.out.println("Executing file : "+ databaseScriptPath + sqlScriptPath);
				sqlScript = FileUtils.readFileToString(new File(databaseScriptPath + sqlScriptPath));			
				sqlScript = sqlScript.replaceAll("GO", "");	
				sqlScript = sqlScript.replace(databaseNameToReplace, databaseName);
				
			}
			
			EMSDatabasePS = con.prepareStatement(sqlScript);
			
		
			
			if(params != null)
			{
				for(int i=1; i<= params.length ; i++)
				{	int j =i-1;
					try{
					EMSDatabasePS.setString(i, params[j]);
					}
					catch(SQLException e){
						
					}
				}
			}
			containsResultSet =  EMSDatabasePS.execute();
			
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
	public String executeSQLScript(String sqlScript)
	{
		boolean containsResultSet = false;
		boolean scriptFileNotExists = false;
		sqlScript = sqlScript.replace(databaseNameToReplace, databaseName);
		try{
		EMSDatabasePS = con.prepareStatement(sqlScript);
		containsResultSet =  EMSDatabasePS.execute();
		
		if(containsResultSet==true)
		{
			ResultSet result = EMSDatabasePS.getResultSet();
			while(result.next())
				return result.getString(1);
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
