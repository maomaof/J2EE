/***********************************************************************
 * (C) Copyright 2011 SafeNet, Inc. All rights reserved. This software
 * contains proprietary information, which shall not be reproduced or
 * transferred to other documents and shall not be disclosed to others
 * or used for manufacturing or any other purpose without prior written
 * permission of SafeNet, Inc.
 **********************************************************************/
/*******************Revision History*************************************
 * Written By: Debasish Pradhan
 * Last Updated Date: 14-Feb-2011
 * Objective: Class to execute selenium actions/commands
 ************************************************************************/
package selenium.library;

import com.thoughtworks.selenium.DefaultSelenium;

import com.thoughtworks.selenium.SeleniumException;
import com.thoughtworks.selenium.SeleneseTestCase;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.AssertionError; 
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;
import selenium.utilities.ConfigurationReader;
import selenium.utilities.DatabaseSetup;
import selenium.utilities.SikuliExecutor;
import selenium.utilities.TestTime;
import selenium.utilities.WebService;



public class SeleniumCommandExecutor
{
	
	private static String filename;   // Name of image file
	private static DefaultSelenium selenium; // selenium instatnce
	private static String serverHost=null;  // Selenium argument
	private static int serverPort;	// Selenium argument
	private static String browserStartCommand=null;	// Selenium argument
	private static String browserURL=null;	// Selenium argument
	private static String failureReason=null; // failure message
	private static SeleneseTestCase assertObject;
	private static TestTime time;
	private static int visible=1;
	private static Object selen; 
	private static Map object = new HashMap();
	private static int visibleTimeOut;  // waitForVisible time out
	static String assertParameters[]; //Splitting action Parameters
	static Object[] args; //used to pass parameters to selenium functions
	static Class SeleniumClass; //finding class
	static int filecount=1;
	static Exception e; // Exception e
	static String tableelement[]; //to store xpath value
	//used to read xpath properties file
	private static ConfigurationReader configuration;
	private static ConfigurationReader seleniumConf;
	private static String ip,browser; // stores ip address and browser
	static Class[] parameterTypes = null; //for obtaining parameter types of a selenium function
    private static String seleniumMode;
    private static SeleniumServer server;
	static Method seleniumMethods[]; //Getting all declared methods of selenium class
    private static long waitTime;
    public static String waitTimeOut;
	static int totalFunctions; //total no. of functions
	static int totalParameters; //stores total no. of parameters of a selenium function
    private static int sikuli=0;
	static int j=0;
	static int count=0;
	private static String sikuliOnly;
	private static WebService wsCall = new WebService();
	
	public static String startSelenium(String Browser) 
	{	
		
		browser="xx";
		seleniumConf=new ConfigurationReader("ConfigurationFiles/configuration.properties");
		if(Browser==null)
			browserStartCommand=seleniumConf.getPropertyValue("browserStartCommand");
		else
			browserStartCommand = Browser;
		
		configuration=new ConfigurationReader(seleniumConf.getPropertyValue("uiMap")+"/"+browserStartCommand.replace("*","")+".properties");
		/*Initialize selenium server configuration*/
		serverHost=seleniumConf.getPropertyValue("serverHost");
		serverPort=Integer.parseInt(seleniumConf.getPropertyValue("serverPort"));
		
		browserURL=seleniumConf.getPropertyValue("browserURL");
		failureReason="";
		visibleTimeOut=Integer.parseInt(seleniumConf.getPropertyValue("visTimeOut"));
		visibleTimeOut = visibleTimeOut*1000;
		waitTimeOut=seleniumConf.getPropertyValue("waitTimeOut");
		waitTimeOut=waitTimeOut+"000";
		seleniumMode= seleniumConf.getPropertyValue("selenium");
		sikuliOnly=seleniumConf.getPropertyValue("sikuliOnly");
		if(sikuliOnly.equalsIgnoreCase("yes"))
		{
			sikuli=1;
			ip="localhost";
			
		}
		if(sikuli!=1)
		{
		if(seleniumMode.equals("server"))
		{		RemoteControlConfiguration rcconf=new RemoteControlConfiguration();
				rcconf.setPort(serverPort);
				rcconf.setTrustAllSSLCertificates(true);
				
				
				try
				{
				server = new SeleniumServer(rcconf);
				server.start();
				}
				catch(Exception e)
				{	System.out.println(e.getMessage());
				
				}
		}
		
		selenium=new DefaultSelenium(serverHost,serverPort,browserStartCommand,browserURL);
		
		 
		selenium.start();
		
		if(!seleniumMode.equals("server"))
		{	
			String logs = selenium.retrieveLastRemoteControlLogs();
			int i = logs.indexOf("host=");
			if(i==-1)
			try {
				Thread.sleep(30000);
				logs = selenium.retrieveLastRemoteControlLogs();
				i = logs.indexOf("host=");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		i = i+5;
		int j = logs.indexOf("port=");
		j--;
		ip = logs.substring(i,j);
		logs = null;
		}
		else
			ip="localhost";
		}
		return ip;
		
		
	}
	public static String getBrowser()
	{	if(sikuli!=1)
		{
		browser=selenium.getEval("navigator.appName");
		
		if(browser.contains("scape"))
		{	browser=selenium.getEval("navigator.userAgent");
			if(browser.contains("irefox"))
				browser="FF";
			else if(browser.contains("hrome"))
				browser="CM";
			else 
				browser="xx";
			
		}
	else if(browser.contains("xplorer"))
	{	
		browser="IE";
		
	}
	else
		browser=selenium.getEval("navigator.appName");
		}
	if(sikuli==1)
	{
		browser="sl";
	}
		return browser;
		
		
	}
	public static void closeSelenium()
	{	
		
		if(sikuli!=1)
		{
		selenium.stop();
		if(seleniumMode.equals("server"))
		{
			server.stop();
		}
		}
		
	}
	
		
	//Function to execute selenium commands using reflection
	public static int executeSeleniumCommandUsingReflection(String Testcase, String Step,String Action,String UiLocator,String ActionParameter)
	{
		String uiLoc=UiLocator;
		filename = "";
		failureReason = ""; 
		int status=1;
		try
		{	
			assertParameters = ActionParameter.split(","); //Splitting action Parameters
			Object[] args; //used to pass parameters to selenium functions
			SeleniumClass = Class.forName("com.thoughtworks.selenium.DefaultSelenium"); //finding class
			
			
		    parameterTypes = null; //for obtaining parameter types of a selenium function
		    
		    
		    seleniumMethods=SeleniumClass.getDeclaredMethods(); //Getting all declared methods of selenium class
		    
		   
		    totalFunctions = seleniumMethods.length; //total no. of functions
		    		    
		    j=0; // used for looping purpose
		    if(Action.equalsIgnoreCase("sikuli"))
		    {
		    	if(ActionParameter.equalsIgnoreCase("on"))
		    		sikuli=1;
		    	else
		    		sikuli=0;
		    }
		    else if(sikuli==1)
		    {	UiLocator=getUilocator(UiLocator);
		    	ActionParameter=getUilocator(ActionParameter);
		    	SikuliExecutor.sikuliCommandExecutor(Action, UiLocator, ActionParameter);
		    }
		      	
		    else if(Action.equalsIgnoreCase("assertEquals")) //checking if actions is assertequals or not
		    	{		
		    			
		    			
		    			for(j=0;j<totalFunctions;j++)  // searching for selenium function
			    		{	if(assertParameters[1].equals(seleniumMethods[j].getName()))
			    		    	{	parameterTypes = seleniumMethods[j].getParameterTypes();
			    		    	break;
			    		    	}
			    		}
		    			if(j!=totalFunctions)
		    			{
			    		totalParameters = parameterTypes.length;
			    		if(totalParameters ==2) // args initialization
			    		{	
			    			args = new Object[]{new String(getUilocator(assertParameters[2])),new String(getUilocator(assertParameters[3]))};
			    		}
			    		else if(totalParameters==1)
			    		{	
			    			args = new Object[]{new String(getUilocator(assertParameters[2]))};
			    		}
			    		else
			    			args = null;
			    	    String temp =  seleniumMethods[j].invoke(selenium, args).toString();		
			    		if(assertParameters[0].equals(temp)==false)
			    			throw new AssertionError("Expected \""+assertParameters[0]+"\" but saw \""+temp+"\" instead");// calling function
			    		//assert object is an object of selenesetestcase class
		    			}
		    			else
		    			{
		    				if(assertParameters[1].equalsIgnoreCase("browser")==true)
		    				{
		    					if(browser.equalsIgnoreCase(getUilocator(assertParameters[0]))==false)
		    					{
		    						throw new AssertionError("Expected \""+assertParameters[0]+"\" but saw \""+browser+"\" instead");
		    					}
		    				}
		    				else if(assertParameters[0].equals(getUilocator(assertParameters[1]))==false)
		    				{
		    					throw new AssertionError("Expected \""+assertParameters[0]+"\" but saw \""+assertParameters[1]+"\" instead");
		    				}
		    			}
			    					    	    		
			    		
		    	}
		    
		    else if (Action.equalsIgnoreCase("Login"))
		    {
		    	UiLocator=browserURL+UiLocator;
		    	
		    	
		    	
		    	int response = wsCall.login(UiLocator, ActionParameter);
		    	if(response!=200)
		    	{
		    		throw new AssertionError("Login Failed "+response);
		    	}
		    	
		    }
		    else if (Action.equalsIgnoreCase("POST"))
		    {
		    	UiLocator=browserURL+UiLocator;
		    	
		    	
		    	
		    	int response = wsCall.doPost(UiLocator, ActionParameter);
		    	if(response!=200)
		    	{
		    		throw new AssertionError("Post Execution Fail Response Code "+response);
		    	}
		    	
		    }
		    else if (Action.equalsIgnoreCase("GET"))
		    {
		    	
		    	UiLocator=browserURL+UiLocator;
		    	
		    	
		    	int response = wsCall.doGet(UiLocator);
		    	if(response!=200)
		    	{
		    		throw new AssertionError("Get Execution Fail Response Code "+response);
		    	}
		    }
		    else if (Action.equalsIgnoreCase("PUT"))
		    {
		    	UiLocator=browserURL+UiLocator;
		    	
		    	
		    	int response = wsCall.doPut(UiLocator, ActionParameter);
		    	if(response!=201)
		    	{
		    		throw new AssertionError("Put Execution Fail Response Code "+response);
		    	}
		    }
		    else if (Action.equalsIgnoreCase("DELETE"))
		    {
		    	UiLocator=browserURL+UiLocator;
		    	
		    	
		    	int response = wsCall.doDelete(UiLocator);
		    	if(response!=204)
		    	{
		    		throw new AssertionError("Delete Execution Fail Response Code "+response);
		    	}
		    }
		    else if(Action.equalsIgnoreCase("verifyEquals")) //checking if actions is assertequals or not
	    	{		
	    			
	    			
	    			for(j=0;j<totalFunctions;j++)  // searching for selenium function
		    		{	if(assertParameters[1].equals(seleniumMethods[j].getName()))
		    		    	{	parameterTypes = seleniumMethods[j].getParameterTypes();
		    		    	break;
		    		    	}
		    		}
	    			if(j!=totalFunctions)
	    			{
	    			totalParameters = parameterTypes.length;
		    		if(totalParameters ==2) // args initialization
		    		{	
		    			args = new Object[]{new String(getUilocator(assertParameters[2])),new String(getUilocator(assertParameters[3]))};
		    		}
		    		else if(totalParameters==1)
		    		{	
		    			args = new Object[]{new String(getUilocator(assertParameters[2]))};
		    		}
		    		else
		    			args = null;
		    	    String temp = seleniumMethods[j].invoke(selenium, args).toString();		
		    		if(assertParameters[0].equals(temp)==false)
		    			throw new SeleniumException("Expected \""+assertParameters[0]+"\" but saw \""+temp+"\" instead");// calling function
		    		//assert object is an object of selenesetestcase class
	    			}
		    		else
	    			{
	    				if(assertParameters[1].equalsIgnoreCase("browser")==true)
	    				{
	    					if(browser.equalsIgnoreCase(getUilocator(assertParameters[0]))==false)
	    					{
	    						throw new SeleniumException("Expected \""+assertParameters[0]+"\" but saw \""+browser+"\" instead");
	    					}
	    				}
	    				else if(assertParameters[0].equals(getUilocator(assertParameters[1]))==false)
	    				{
	    					throw new SeleniumException("Expected \""+assertParameters[0]+"\" but saw \""+assertParameters[1]+"\" instead");
	    				}
	    			}	    		
		    					    	    		
		    		
	    	}
		    	else if(Action.equalsIgnoreCase("assertTrue"))//checking if action is assertTrue
		    	{		
		    			
		    			
		    			for(j=0;j<totalFunctions;j++)
			    		{	if(assertParameters[0].equals(seleniumMethods[j].getName()))	
			    		 	{	parameterTypes = seleniumMethods[j].getParameterTypes();
			    		    	break;
			    		    	}
			    		}
			    		totalParameters = parameterTypes.length;
			    		if(totalParameters ==2)
			    		{	
			    			args = new Object[]{new String(getUilocator(assertParameters[1])),new String(assertParameters[2])};
			    		}
			    		else if(totalParameters==1)
			    		{	
			    			args = new Object[]{new String(getUilocator(assertParameters[1]))};
			    		}
			    		else
			    			args = null;
			    	
			    	try{	
			    	if(((Boolean)seleniumMethods[j].invoke(selenium, args))==false)
			    	{		throw new AssertionError("Error:"+assertParameters[1]+" not found");
			    	
			    	}
			    	}
			    	catch(Exception e)
			    	{
			    		throw new AssertionError(e.getLocalizedMessage());
			    	}
			    		
			    		
			    		
			    					    	    		
			    		
		    	}
		    	else if(Action.equalsIgnoreCase("verifyTrue"))//checking if action is assertTrue
		    	{		
		    			
		    			
		    			for(j=0;j<totalFunctions;j++)
			    		{	if(assertParameters[0].equals(seleniumMethods[j].getName()))	
			    		 	{	parameterTypes = seleniumMethods[j].getParameterTypes();
			    		    	break;
			    		    	}
			    		}
			    		totalParameters = parameterTypes.length;
			    		if(totalParameters ==2)
			    		{	
			    			args = new Object[]{new String(getUilocator(assertParameters[1])),new String(assertParameters[2])};
			    		}
			    		else if(totalParameters==1)
			    		{	
			    			args = new Object[]{new String(getUilocator(assertParameters[1]))};
			    		}
			    		else
			    			args = null;
			    	
			    	try{	
			    	if(((Boolean)seleniumMethods[j].invoke(selenium, args))==false)
			    	{		throw new SeleniumException("Error:"+assertParameters[1]+" not found");
			    	
			    	}
			    	}catch(Exception e)
			    	{
			    		throw new SeleniumException(e.getLocalizedMessage());
			    	}
			    		
			    	
			    					    	    		
			    		
		    	}
		    	else if(Action.equalsIgnoreCase("waitForVisible"))   // wait for Visible Function
		    	{
		    		
		    		
		    		for (int second = 0;; second+=100) {
		    			if (second >= visibleTimeOut) 
		    				throw new AssertionError("Timed out after "+second+" ms"+" Element "+UiLocator+ActionParameter+" not found");
		    			try { 
		    				if(UiLocator!="")
		    					{	if (selenium.isVisible(getUilocator(UiLocator))) 
		    						failureReason="Loading Time : "+second+" ms";
		    						break;
		    					}
		    				else
		    					if(selenium.isTextPresent(ActionParameter))
		    					{	failureReason="Loading Time : "+second+" ms";
		    						break;
		    					}
		    				
		    				}
		    			catch (Exception e) {}
		    			try
		    			{Thread.sleep(100);
		    			
		    			}
		    			catch(Exception e){}
		    		}
		    		

		    	}
		    	else if(Action.equalsIgnoreCase("assertNotEquals")) //checking if actions is assertequals or not
		    	{		
	    			
	    			
	    			for(j=0;j<totalFunctions;j++)  // searching for selenium function
		    		{	if(assertParameters[1].equals(seleniumMethods[j].getName()))
		    		    	{	parameterTypes = seleniumMethods[j].getParameterTypes();
		    		    	break;
		    		    	}
		    		}
		    		if(j!=totalFunctions)
		    		{
	    			totalParameters = parameterTypes.length;
		    		if(totalParameters ==2) // args initialization
		    		{	
		    			args = new Object[]{new String(getUilocator(assertParameters[2])),new String(getUilocator(assertParameters[3]))};
		    		}
		    		else if(totalParameters==1)
		    		{	
		    			args = new Object[]{new String(getUilocator(assertParameters[2]))};
		    		}
		    		else
		    			args = null;
		    	    String temp = seleniumMethods[j].invoke(selenium, args).toString();		
		    		if(!assertParameters[0].equals(temp)==false)
		    			throw new AssertionError("Expected \""+assertParameters[0]+"\" but saw \""+temp+"\" instead");// calling function
		    		//assert object is an object of selenesetestcase class
		    		}
		    		else
	    			{
	    				if(assertParameters[1].equalsIgnoreCase("browser")==true)
	    				{
	    					if(!browser.equalsIgnoreCase(getUilocator(assertParameters[0]))==false)
	    					{
	    						throw new AssertionError("Expected \""+assertParameters[0]+"\" but saw \""+browser+"\" instead");
	    					}
	    				}
	    				else if(!assertParameters[0].equals(getUilocator(assertParameters[1]))==false)
	    				{
	    					throw new AssertionError("Expected \""+assertParameters[0]+"\" but saw \""+assertParameters[1]+"\" instead");
	    				}
	    			}	    	
		    		
		    			    		
		    					    	    		
		    		
		    	}
		    	else if(Action.equalsIgnoreCase("verifyNotEquals")) //checking if actions is assertequals or not
		    	{		
	    			
	    			
	    			for(j=0;j<totalFunctions;j++)  // searching for selenium function
		    		{	if(assertParameters[1].equals(seleniumMethods[j].getName()))
		    		    	{	parameterTypes = seleniumMethods[j].getParameterTypes();
		    		    	break;
		    		    	}
		    		}
		    		if(j!=totalFunctions)
		    		{
	    			totalParameters = parameterTypes.length;
		    		if(totalParameters ==2) // args initialization
		    		{	
		    			args = new Object[]{new String(getUilocator(assertParameters[2])),new String(getUilocator(assertParameters[3]))};
		    		}
		    		else if(totalParameters==1)
		    		{	
		    			args = new Object[]{new String(getUilocator(assertParameters[2]))};
		    		}
		    		else
		    			args = null;
		    	    String temp = seleniumMethods[j].invoke(selenium, args).toString();		
		    		if(!assertParameters[0].equals(temp)==false)
		    			throw new SeleniumException("Expected \""+assertParameters[0]+"\" but saw \""+temp+"\" instead");// calling function
		    		//assert object is an object of selenesetestcase class
		    		}
		    		else
	    			{
	    				if(assertParameters[1].equalsIgnoreCase("browser")==true)
	    				{
	    					if(!browser.equalsIgnoreCase(getUilocator(assertParameters[0]))==false)
	    					{
	    						throw new SeleniumException("Expected \""+assertParameters[0]+"\" but saw \""+browser+"\" instead");
	    					}
	    				}
	    				else if(!assertParameters[0].equals(getUilocator(assertParameters[1]))==false)
	    				{
	    					throw new SeleniumException("Expected \""+assertParameters[0]+"\" but saw \""+assertParameters[1]+"\" instead");
	    				}
	    			}	    	
		    		
		    					    	    		
		    		
		    	}
		    	else if(Action.equalsIgnoreCase("wait"))  // wait function
		    	{
		    		Thread.sleep(Integer.parseInt(ActionParameter));
		    			
		    			
		    			
		    		

		    	}
		    	else if(Action.equalsIgnoreCase("assertFalse"))//checking if action is assertFalse
		    	{		
		    			
		    			
		    			for(j=0;j<totalFunctions;j++)
			    		{	if(assertParameters[0].equals(seleniumMethods[j].getName()))	
			    		 	{	parameterTypes = seleniumMethods[j].getParameterTypes();
			    		    	break;
			    		    	}
			    		}
			    		totalParameters = parameterTypes.length;
			    		if(totalParameters ==2)
			    		{	
			    			args = new Object[]{new String(getUilocator(assertParameters[1])),new String(assertParameters[2])};
			    		}
			    		else if(totalParameters==1)
			    		{	
			    			args = new Object[]{new String(getUilocator(assertParameters[1]))};
			    		}
			    		else
			    			args = null;
			    	
			    		try{
			    			
			    		
			    		if(((Boolean)seleniumMethods[j].invoke(selenium, args))==true)
				    	{		throw new AssertionError("Error:"+assertParameters[1]+" found");
				    	
				    	}
			    		}
			    		catch(Exception e)
			    		{
			    			
			    		}
		
			    		
			    					    	    		
			    		
		    	}
		    	else if(Action.equalsIgnoreCase("verifyFalse"))//checking if action is assertFalse
		    	{		
		    			
		    			
		    			for(j=0;j<totalFunctions;j++)
			    		{	if(assertParameters[0].equals(seleniumMethods[j].getName()))	
			    		 	{	parameterTypes = seleniumMethods[j].getParameterTypes();
			    		    	break;
			    		    	}
			    		}
			    		totalParameters = parameterTypes.length;
			    		if(totalParameters ==2)
			    		{	
			    			args = new Object[]{new String(getUilocator(assertParameters[1])),new String(assertParameters[2])};
			    		}
			    		else if(totalParameters==1)
			    		{	
			    			args = new Object[]{new String(getUilocator(assertParameters[1]))};
			    		}
			    		else
			    			args = null;
			    	
			    		try{
			    		if(((Boolean)seleniumMethods[j].invoke(selenium, args))==true)
				    	{		throw new SeleniumException("Error:"+assertParameters[1]+" found");
				    	
				    	}
			    		}
			    		catch(Exception e)
			    		{
			    			
			    		}
		
			    		
			    					    	    		
			    		
		    	}
		    	else if(Action.equalsIgnoreCase("visible"))
		    	{		if(Integer.parseInt(ActionParameter)==0)
		    				visible=0;
		    			else
		    				visible=1;
		    	}
		    	else if(Action.equalsIgnoreCase("waitForPageToLoadOnFailExit"))
		    	{	
		    		try
		    		{
		    			waitTime=time.gettimemillis();		    			
		    			if(ActionParameter!="")
		    				selenium.waitForPageToLoad(ActionParameter);
		    			else
		    				selenium.waitForPageToLoad(waitTimeOut);
		    			waitTime=(time.gettimemillis()-waitTime);
		    			failureReason="Loading Time : "+waitTime+" ms";
		    		}
		    		catch(SeleniumException e)
		    		{
		    			throw new AssertionError("XHR wait for page to Load fails exiting current test case");
		    		}
		    	}
		    	else if(Action.equalsIgnoreCase("waitForPageToLoad"))
		    	{
		    		waitTime=time.gettimemillis();		    			
		    		if(ActionParameter!="")
	    				selenium.waitForPageToLoad(ActionParameter);
	    			else
	    				selenium.waitForPageToLoad(waitTimeOut);
		    		
	    			waitTime=(time.gettimemillis()-waitTime);
	    			failureReason="Loading Time : "+waitTime+" ms";
		    	}
		    		   		
		    	else if(Action.equalsIgnoreCase("db_Cleanup"))
		    	{	
		    		DatabaseSetup.cleanup();
		    		try{
		    		selenium.refresh();
		    		selenium.waitForPageToLoad("10000");
		    		}
		    		catch(SeleniumException e){}
		    		try{
			    		selenium.refresh();
			    		selenium.waitForPageToLoad("10000");
			    		}
			    	catch(SeleniumException e){}
			    	try{
				    		selenium.refresh();
				    		selenium.waitForPageToLoad("10000");
				    		}
				    		catch(SeleniumException e){}
		    		
		    	}
		    	else if(Action.equalsIgnoreCase("execute"))
		    	{
		    		if(ActionParameter.contains(".exe"))
		    			Runtime.getRuntime().exec(ActionParameter).waitFor();
		    		else if(ActionParameter.contains(".bat"))
		    		{
		    			Runtime.getRuntime().exec(new String[]{"cmd.exe","/c",ActionParameter}).waitFor();
		    			
		    		}
		    		else
		    		{
		    			throw new AssertionError("Error: "+ActionParameter+"is not a valid exe/bat file");
		    		}
		    		Thread.sleep(5000);
		    	}
		    	else // if action is normal selenium command
		    	{	
		    		
		    		for(j=0;j<totalFunctions;j++) // finding the selenium function
		    		{	
		    			if(Action.equalsIgnoreCase(seleniumMethods[j].getName()))
		    		    	{	
		    					parameterTypes = seleniumMethods[j].getParameterTypes();
		    		    		if(Action.equalsIgnoreCase("open")&&parameterTypes.length==2)
		    		    			continue;
		    		    		break;
		    		    	}
		    		}
		    		
		    		totalParameters = parameterTypes.length;		    		// no. of parameters
		    		
		    		if(Action.equalsIgnoreCase("waitForCondition"))
		    		{		
		    			UiLocator = getUilocator(UiLocator);
		    			ActionParameter = "selenium."+ActionParameter;
		    			assertParameters=ActionParameter.split(",");
		    			UiLocator="("+assertParameters[0]+"(\""+UiLocator+"\"))";
		    			if(assertParameters.length>1)
		    				ActionParameter=assertParameters[1];
		    			else
		    				ActionParameter=null;
		    			args = new Object[]{new String(UiLocator),new String(ActionParameter)};
			    		
			    		
		    			
		    		}
		    		else{
		    			
		    		UiLocator=getUilocator(UiLocator);
		    		ActionParameter=getUilocator(ActionParameter);
		    		if(totalParameters ==2) //storing parameters
		    		{		
		    				{if(UiLocator!="")
		    				{	if(visible==1)
		    					{
		    					if(selenium.isVisible(UiLocator)==false)
		    							throw new SeleniumException("ERROR: Element "+UiLocator+" is not Visible",e);
		    					}
		    					if(selenium.isEditable(UiLocator)==false)
		    					throw new SeleniumException("ERROR: Element "+UiLocator+" is not Editable",e);
		    				}}
		    				args = new Object[]{new String(UiLocator),new String(ActionParameter)};
		    		}
		    		else if(totalParameters==1)
		    			if(UiLocator!="")
		    			{	if(visible==1)
		    				{
		    				if(selenium.isVisible(UiLocator)==false)
			    				throw new SeleniumException("ERROR: Element "+UiLocator+" is not Visible",e);
		    				}
		    			args = new Object[]{new String(UiLocator)};
		    			}
		    			else
		    				args = new Object[]{new String(ActionParameter)};
		    		else
		    			args = null;
		    		}		
		    		selen=seleniumMethods[j].invoke(selenium, args); //calling selenium functions
		    		if(selen!=null)
		    			object.put(Step,selen);
		    		System.out.println(selen);
		    		
		    	}
		    	  
		    
			
		
				
			
			
		}
		
		
		catch(AssertionError e) 
		{	status=-1;
			captureScreen(Testcase,Step);
			
		/***get error description for logging purpose*/
		failureReason=e.getMessage();
		failureReason=failureReason.replace(getUilocator(uiLoc), uiLoc);
		System.out.println(e.getMessage());
		
		}
		catch(ClassNotFoundException e) 
		{	status=-1;
			captureScreen(Testcase,Step);
		/***get error description for logging purpose*/
		failureReason=e.getMessage();
		System.out.println(e.getMessage());
		}
		catch(IllegalAccessException e) 
		{	status=-1;
			captureScreen(Testcase,Step);
		/***get error description for logging purpose*/
		failureReason=e.getMessage();
		System.out.println(e.getMessage());
		}
		catch(InvocationTargetException e)  
		{	status=-1;
			captureScreen(Testcase,Step);
			
		/***get error description for logging purpose*/
		failureReason=e.getMessage();
		System.out.println(e.getMessage());
		if(failureReason==null)
			{
				status=-2;
				failureReason=e.getTargetException().getMessage();
				failureReason=failureReason.replace(getUilocator(uiLoc), uiLoc);
				System.out.println(failureReason);
				
				
			}
		}
		catch(SeleniumException e)
		{
			status=-2;
			captureScreen(Testcase,Step);
			/***get error description for logging purpose*/
			failureReason=e.getMessage();
			failureReason=failureReason.replace(getUilocator(uiLoc), uiLoc);
			System.out.println(e.getMessage());
			
			
			/***code to log in log4j***/
		}
		catch(Exception e)
		{
			status=-1;
			captureScreen(Testcase,Step);
			/***get error description for logging purpose*/
			failureReason=e.getMessage();
			System.out.println(e.getMessage());
			if(failureReason==null)
			{
		
				failureReason=e.getLocalizedMessage();
				if(failureReason!=null&&failureReason!="")
				failureReason=failureReason.replace(getUilocator(uiLoc), uiLoc);
				System.out.println(failureReason);
				
			}
			
			/***code to log in log4j***/
		}
		
		
	
		return status;
	}
		
	
	
	
	public static String getFailureReason()  //returns failure message
	{
		return failureReason;
	}
	public static void captureScreen(String test,String step) //captures screenshot 
	{
		 	
			count++;
			filename = ip+"_"+browser+"_"+test+"_"+step+"_"+count+".jpg";
		 	filecount++;
		 	if(sikuli==1)
		 	{
		 		  try {
		 	            
		 			 Toolkit toolkit = Toolkit.getDefaultToolkit();
		 			Dimension screenSize = toolkit.getScreenSize();  
		 			  Robot robot = new Robot();
		 	            // Capture the screen shot of the area of the screen defined by the rectangle
		 	            BufferedImage bi=robot.createScreenCapture(new Rectangle(screenSize));
		 	            ImageIO.write(bi, "jpg", new File("Logs/Images/"+filename));
		 	            
		 	        } catch (AWTException e) {
		 	            e.printStackTrace();
		 	        } catch (IOException e) {
		 	            e.printStackTrace();
		 	        }
		 	}
		 	else
		 	{
		 	String a=selenium.captureScreenshotToString();
			try
			{byte[] decodedScreenshot = 
				Base64.decodeBase64(a.getBytes()); 
				      FileOutputStream fos = new FileOutputStream(new File("Logs/Images/"+filename)); 
				     fos.write(decodedScreenshot); 
				     fos.close(); 
		 	
			}
		 	catch(Exception e)
		 	{	System.out.println(e.getStackTrace());
		 	}
		 	}
			   
		   
	}
	public static String getScreenPath() // returns image file name
	{	return filename;
	}
	
	
	public static String getUilocator(String Locator) // used to fetch actual UI locator value from xpath property file using input sheet value
	{	
		
		if(Locator.startsWith("*")==false)// if locator is normal ui element
		{	if(configuration.getPropertyValue(Locator)==null)
				return Locator;
			else
				return configuration.getPropertyValue(Locator);
		}
		Locator=Locator.substring(1);
		// if locator is some output from software
		if(Locator.startsWith("step"))
		{	Locator=Locator.replaceAll("\\]","");
			tableelement=Locator.split("\\[");
			
			Locator=(String) object.get(tableelement[1]);
			return Locator;
		}
		
		//if locator is a table element
		Locator=Locator.replaceAll("\\]","");
		tableelement=Locator.split("\\[");
		Locator=configuration.getPropertyValue(tableelement[0]);
		
		if(tableelement[1].contains("step"))
		{	
			
			tableelement[1]=(String) object.get(tableelement[2]);
		}
		Locator=Locator.replace("xx", tableelement[1]);
		if(tableelement.length==3)
			Locator=Locator.replace("yy", tableelement[2]);
		return Locator;
		
	
	
	}
}
	
