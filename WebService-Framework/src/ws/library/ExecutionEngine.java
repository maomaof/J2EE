/*Last Updated By: Debasish Pradhan
 * Last Updated On: 31-Aug-2011
 * Objective: To Fix Issue: sessionId should be null before login is called. sessionId should be null, after logout is called.
 * Section Updated: doPost
 * 
 */
package ws.library;
import ws.driver.*;
import ws.utilities.*;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.omg.CORBA.portable.OutputStream;
import org.xml.sax.InputSource;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.Node;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;

import javax.xml.xpath.XPathFactory;

import org.apache.axis.types.UnsignedLong;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;


import org.apache.axis.types.UnsignedLong.*;

import com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssLocator;
import com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoap;
import com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus;

import net.sourceforge.jtds.jdbc.Driver;


public class ExecutionEngine {

	private static final String UTF_8 = null;
	private String sessionId;
	private String respMessage;
	private List<String> responseList;

	private static String host;
	private static String httpPort;
	private static String httpsPort;
	private static String sslServer;
	private static String trustStore;
	private static String trustStorePass;
	private static String version;
	private static long time;
	private static String webServicesList;
	public String testId,stepNo,service;
	FileOutputStream fileRef;
	public static String fileData ="";
	public long startTime;
	public long endTime;
	 HaspBssSoap service1 ;
	public static String webServiceVersion;
	
	public ExecutionEngine() {
		loadProperties();
		responseList = new ArrayList<String>();
	}

	public void loadProperties() {
		
		try {

			Properties properties = new Properties();
			InputStream inStream = new FileInputStream(
					"ConfigurationFiles/WebServiceAutomation.properties");
			properties.load(inStream);
			
			// For authentication etc
			host = properties.getProperty("host");
			httpPort = properties.getProperty("httpPort");
			httpsPort = properties.getProperty("httpsPort");
			trustStore = properties.getProperty("trustStore");
			trustStorePass = properties.getProperty("trustStorePass");
			version = properties.getProperty("version");
			webServicesList=properties.getProperty("webServicesList");
			webServiceVersion=properties.getProperty("webServiceVersion");
			System.out.println("trustStore : " + trustStore);
			System.setProperty("javax.net.ssl.trustStore", trustStore);
			System.setProperty("javax.net.ssl.trustStorePassword",
					trustStorePass);
			CheckTomcatAndSSL checkTomcat = new CheckTomcatAndSSL();
			/*if (!checkTomcat.validate(trustStore, trustStorePass, host,
					httpPort, httpsPort, "Y").equals("ok")) {
				System.out.println("Configuration Error .... Exiting !!");
				System.exit(1);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean containsOnlyNumbers(String str) {

		// It can't contain only numbers if it's null or empty...
		if (str == null || str.length() == 0)
			return false;

		for (int i = 0; i < str.length(); i++) {

			// If we find a non-digit character we return false.
			if (!Character.isDigit(str.charAt(i)))
				return false;
		}

		return true;
	}

	
	@SuppressWarnings("null")
	public void executeSoap(String inputString, String serviceName, StringBuffer actualReturnCode,StringBuffer actualResponse, String expectedReturnCodeElement,String test,String step, StringBuffer responseTime)
	throws Exception
	{
		testId=test;
		stepNo=step;
		service=serviceName;
		int ieRC = 0;
		String eResponse = "";
		
		String eRC = "";
		String testdesc = "";
		
		/* The added parameters are used */
		if (expectedReturnCodeElement != null) {
			eRC = expectedReturnCodeElement;
			if (!eRC.equals("") && !eRC.equals("*")) {
				if (containsOnlyNumbers(eRC)) {
					ieRC = Integer.parseInt(eRC);
				}

			} else {
				// System.out.println("Please Check Expected Return Code For Test Case:"+tcId+", WebService:"+serviceName);
				System.exit(0);
			}
		}
		
		
		if(inputString.contains("host"))
		{
			Properties properties = new Properties();
			InputStream inStream = new FileInputStream("ConfigurationFiles/WebServiceAutomation.properties"); 
			properties.load(inStream);
			String host =properties.getProperty("host");
			inputString=inputString.replaceFirst("host",host);
			String port =properties.getProperty("tomcatPort");
			inputString=inputString.replaceFirst("tomcatPort", port);
			
			
		 //inputString.replace("host",host );
		}
		if(serviceName.contentEquals("initialize"))
		{
		HaspBssLocator locator = new HaspBssLocator();
		locator.setMaintainSession(true);
		  service1 = locator.getHaspBssSoap();
		}
		 
        Class<?> cls = Class.forName("com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoap");
        //info = cls.getName(); 
         Object o = Class.forName("com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus").getClass();
          
          Method[] theMethods = cls.getMethods();
         	  Class[] parameterTypes;
         	  int i=0;
         	  for (Method mn : theMethods)
         	  {
         		  
         	  
         		  String methodString = mn.getName();
         		  int i1,i2;
         		  if(methodString.contentEquals(serviceName))
         			 
         		  {
         		  i1 = mn.getParameterTypes().length;
         		
//         		  
         		 
         		  int j=0;
         		
         		String array[] =null;
        		String arrayholder =null;
        		

        		//inputString="filePath_inputxml/c2v.xml,vendorId=1";
        		/*Parsing input string start*/
        		array = inputString.split("&");
        		i2=array.length;
        		boolean flag=false;
        		if(i1>=(i2))
        			i=i1;
        		else
        			i=i2;
        		int k1=array.length,k=1,k2=0  ;
        		Object [] valuesArr =new Object[i];
        		if(array[0].contains("filePath_"))
        		{
        			valuesArr[0]=array[0].substring(array[0].lastIndexOf("=")+1);
        		   flag=true;
        		}
        		if(k1>0)
        		{
        		while(array[k2].contains("=")||array[k2].contains("filePath_"))
        				{
        			
        			arrayholder =array[k2];
        		    int a=arrayholder.lastIndexOf("=");
        		    
        		    
        		    arrayholder=arrayholder.substring(a+1);
        		    	
        		    if (flag==true)
        		    	flag=false;
        		    	//valuesArr[k]=arrayholder;
        		    else
        		    	valuesArr[k-1]=arrayholder;	
        		   
        		   k2++;
        		    k++;
        		    if(k2==k1)
        		    break;
        			
        				}
        	
        		
        			
        		
        		}
        		else if(k1==1)
        		{
        			
        			valuesArr[k1-1]=array[k1-1];
        		}
        		
        		/*parsing input String ends*/
         		  Object [] objArr = new Object[i1]; 
         		  j=0;
         		  for (Class p : mn.getParameterTypes())
         		  {
         			  
         			  Object obj =null;
         			 String argument =p.getName();
         			
         			  if(argument.contains("int"))
         			  {
         				  Boolean t;
         			   t=p.isPrimitive();
         			 
         			 obj=Integer.valueOf(valuesArr[j].toString());
         			  }
         			  else if(argument.contains("java.lang.String"))
         			  {
         				obj=valuesArr[j];  
         			  }
         			 else if(argument.contains("UnsignedLong"))
   			      	{
   			      	
   			      	 Class <?> cl =Class.forName("org.apache.axis.types.UnsignedLong");
   			      	Constructor m =cl.getDeclaredConstructor(String.class);
   			         
   			      		
   			      	
   			      	 obj=m.newInstance(valuesArr[j].toString());
   			      	}
   			      	
         			  else
         			  {
         				 Constructor Con;
         				 Constructor [] Conn;
         				
         			    if(i2<i1)
         			    {
         			    	if(p.isArray())
             				{
             				Class p1 =p.getComponentType();
             				 Con = p1.getConstructor();
             				}
             				else
             				{
             				 Con = p.getConstructor();
             				}
         			    obj =createObject(Con,null);
         			    }
         			    
         			    else
         			    /*1*/
         			    {
         			    	if(p.isArray())
             				{
         			    	
             				Class p1 =p.getComponentType();
             				 Conn =p1.getConstructors();
             				}
             				else
             				{
             					 Conn =p.getConstructors();
             				}
         			    
         			    for(Constructor c: Conn)
         			    /*2*/  
         			    {
         			    	 Object objtemp1=null;
         			    	 if(c.getParameterTypes().length>0)	
                  			    /*3*/
                  			    {
                  			    	Object objtemp[]=new Object[c.getParameterTypes().length];
                  			          int  icount=0; int j1=0;
                  			     Class[] Parameter =c.getParameterTypes();
                  			
                  			    
                  			     for(Class Param: Parameter)
                  			     /*4*/
                  			     {
                  			    	
                      			      	
                      			      	if(Param.getName().contains("int"))
                      			      	{
                      			      		objtemp[icount]=Integer.valueOf(valuesArr[j].toString());
                      			    
                      			      	}
                      			      	else if(Param.getName().contains("boolean"))
                      			      	{
                      			      	objtemp[icount]=Boolean.valueOf(valuesArr[j].toString());	
                      			      	}
                      			      	else if(Param.getName().contains("String"))	
                      			      	{
                      			      	objtemp[icount]=valuesArr[j];
                      			    
                      			      	}
                      			      	else if(Param.getName().contains("UnsignedLong"))
                      			      	{
                      			      	
                      			      	 Class <?> cl =Class.forName("org.apache.axis.types.UnsignedLong");
                      			      	Constructor m =cl.getDeclaredConstructor(String.class);
                      			         
                      			      		
                      			      	
                      			      	 objtemp[icount]=m.newInstance(valuesArr[j].toString());
                      			      	}
                      			      	else
                      			      	{
                  			          
                                            Constructor [] Conn1 = Param.getDeclaredConstructors();
                     			             for(Constructor c1: Conn1)
                     			                
                     			             {
                     			      	if (Conn1.length>0)
                     			            
                     			             	{
                     			      		Object objtemp2[]=new Object[c1.getParameterTypes().length];
                        			          int  icount1=0;
                     			      	       j1=j;
                     			      	 Class[] Parameter1 =c1.getParameterTypes();
                     			      
                     			      	for(Class  Param2 :Parameter1) 
                     			      	/*7*/
                     			      	{  /*for starts*/
                     			      
                     			      	   if(Param2.getName().contains("int"))
                     			      	    {
                     			      		objtemp2[icount1]=Integer.valueOf(valuesArr[j1].toString());
                     			      	 
                     			    
                     			         	}
                     			      	else if(Param2.getName().contains("boolean"))
                     			         	  {
                     			      	objtemp2[icount1]=Boolean.valueOf(valuesArr[j1].toString());	
                     			       
                     			         	  }
                     			      	else if(Param2.getName().contains("String"))	
                     			         	{
                     			      	objtemp2[icount1]=valuesArr[j1];
                     			       
                     			    
                     			          	}
                     			      	else if(Param2.getName().contains("long"))
                 			      	    {
                 			      		objtemp2[icount1]=Long.valueOf(valuesArr[j1].toString());
                 			      	 
                 			    
                 			         	}
                     			               
                     			      	else
                     			      		/*else starts*/
                     			      	{
                     			      
                     			         Constructor[] conn2 =Param2.getDeclaredConstructors();
                     			          if(conn2.length>0)
                     			        
                     			              { /*if starts*/
                     			        	for (Constructor cc: conn2)
            	         		    		  /*for starts*/
                     			        	   {
            	         		    		  if (cc.getParameterTypes().length>0)
            	         		    		      
            	         		    		        {
            	         		    			  cc.setAccessible(true);
            	         		    			  objtemp2[icount1]=cc.newInstance(valuesArr[j1]);
            	         		    			
            	         		    	    	
            	         		    		         }	 
            	         		    		
            	         		    		      }/*for ends*/
                     			      
                     			                }  /*if ends*/
                     			        
                     			      	    } /*else ends*/
                     			           
                     			      	 icount1++;
                   			             j1++;
                     			         			      	
                     			      	} /*for ends*/
                     			      		                  			           
                     			    	      
                     			    	          Object []arguments=objtemp2;
                     			    	
                     			    	
                     			    	             if(c1.getParameterTypes().length>0)
                     			    	             {
                     			    	            	 System.out.println(c1.getName());
                     			    	            	 c1.setAccessible(true);
                     			      	             objtemp1 =createObject(c1,arguments);
                     			    	            	
                     			    	              
                     			    	              }
                     			    
                     			    	    
                     			    	             objtemp[icount]=objtemp1;  
                     			    	        	
                     			    	             
                     			    	           
                     			       }
                     			    	
                     			      
   								   }
                     			        	         
                     			           
                  			       
                      			         	
                  			     }
                  			   
                      			      icount++;
                      			      if(j1>j)
                      			        j=j1;
                      			      else
      								   j++;
                      			      
                  			     }	
                  			      
                  			   
                  			     i=0;
                  			     while(objtemp.length>0&&i<objtemp.length)
                  			     {
         			    	   System.out.println(objtemp[i]);
         			    	   i++;
                  			     }
                  			     if(p.isArray())
                  			     {
                  			     Object obj2=null;
                  			     Class <?> cls1 = Class.forName(c.getName());
                  			     Object obj1= Array.newInstance(cls1, 1);
                  			     obj2=c.newInstance(objtemp);
                  			     Array.set(obj1, 0, obj2);
                  			    obj=obj1;
                  			     }
                  			     else
                  			     {
                  			    	obj=c.newInstance(objtemp);
                  			     }
                  			    
                               
                  			 
                  			  
                  			     
         			   
         			  
         			
         			    
                  			    
                  			    }
         			    	 
         			      }}
         		     	  }
         			  
         			 if( obj!=null&&obj.toString().contains("filePath_"))
         			 { 
         				 String file=null;
         				file=processInputStringForFILEPATH((String)obj); 
         				objArr[j]=fileData;
         				 
         			 }
         			 else
         			 {
         			 if(j>=i)
         			 {
         			objArr[i1-1]=obj;
         			break;
         			 }
         		   objArr[j] =obj ;
         			 }
         			 
         		  
      			  j++;
      			 
      			 /*1*/
         		  }
         		 
         		
         		  
         		 Object Result= mn.invoke(service1,objArr);
         		 if (Result==null)
         		 {
         			 int counter=0;
         			 Object []value = new Object[objArr.length];
         			
         		  while(objArr.length>0 &&counter<objArr.length)
         		  {
         		  if(objArr[counter]!=null)	
         		  {
         		  Class <?> res =Class.forName(objArr[counter].getClass().getName()) ; 
         		
         		  if(!res.getCanonicalName().contains("java.lang.Integer"))
         		  {
         		 Field[] f=  res.getDeclaredFields();
         		  for (Field ff :f)
         		  {
         			ff.setAccessible(true);
         			
         			Object obj =ff.get(objArr[counter]);
         			if(obj!=null)
         			{
         			if(obj.getClass().isArray())
         			{
         				Class <?> res1 =Class.forName(obj.getClass().getName()); 
         				if(!res1.getCanonicalName().contains("char"))
         				isArrayClass(actualResponse,obj);
         				
         			}
         			else
         			{
         			 if(obj.getClass().getName().contains("Status"))
          				actualReturnCode.append(obj.toString()); 
          			 else
          				 actualResponse.append(obj.toString());
         			}
         		  }
         		  }	
         		  	
         		  }
         		  
         		  } 
         		    	
         		counter++; 
         		
         		 }}
         		 else
         		 actualReturnCode.append(Result.toString());
         		 
         		 
         		
         		  
        		
         		  }}}
           //Method method1= cls.getMethod(serviceName,args1);
	
         
           
           
          
                // 
                 
         		  
         	  Object createObject(Constructor constructor,Object[] arguments) {

       		  //  System.out.println("Constructor: " + constructor.toString());
       		    Object object = null;

       		    try {
       		      object = constructor.newInstance(arguments);
       		    //  System.out.println("Object: " + object.toString());
       		      return object;
       		    } catch (InstantiationException e) {
       		      System.out.println(e);
       		    } catch (IllegalAccessException e) {
       		      System.out.println(e);
       		    } catch (IllegalArgumentException e) {
       		      System.out.println(e);
       		    } catch (InvocationTargetException e) {
       		      System.out.println(e);
       		    }
       		    return object;
       		  }
       		     	  
         	  

	public void addResponseList(){
		responseList.add("DB Cleaned");
	}
	public void execute(String inputURI, String inputString, String method,
			String serviceName, String protocol, StringBuffer actualReturnCode,
			StringBuffer actualResponse, String expectedReturnCodeElement,String test,String step, StringBuffer responseTime)
			throws Exception// ,/* Element outputElement,*/String
							// expectedReturnCodeElement, String
							// expectedResponseElement, String tcId, String
							// testDescription)throws Exception
	{
		
		
		
		//******
		testId=test;
		stepNo=step;
		service=serviceName;
		int ieRC = 0;
		String eResponse = "";
		
		String eRC = "";
		String testdesc = "";
		
		/* The added parameters are used */
		if (expectedReturnCodeElement != null) {
			eRC = expectedReturnCodeElement;
			if (!eRC.equals("") && !eRC.equals("*")) {
				if (containsOnlyNumbers(eRC)) {
					ieRC = Integer.parseInt(eRC);
				}

			} else {
				// System.out.println("Please Check Expected Return Code For Test Case:"+tcId+", WebService:"+serviceName);
				System.exit(0);
			}
		}
		
		/*-----------------*/
		System.out.println("Web Services Name - " + serviceName);
		System.out.println("Web Services Method - " + method);
		if(inputURI.contains("{version}"))
		{
			inputURI=inputURI.replace("{version}", webServiceVersion);
		}
		if (inputString.indexOf("JSON_") != -1) {
			inputString = processInputStringForJSON(inputString, responseList,
					inputURI);
		}
		if (inputString.indexOf("OUTPUT_") != -1) {
			inputString = processInputString(inputString, responseList);
		}
		
		if (inputString.indexOf("xpathoutput_") != -1) {
			inputString = processInputStringForXPATH(inputString, responseList);
		}
		
		if (inputString.indexOf("filePath_") != -1) {
			
			inputString =processInputStringForFILEPATH(inputString);
		}
		
		if(inputString.contains(";"))
		{
			String xmlOutput=null;
			
			String[] xpathsArray = inputString.substring(inputString.indexOf(";")).split(";");
			for (int i = 1; i < xpathsArray.length; i++) {
				String xpathExpression = xpathsArray[i].substring(0, xpathsArray[i].indexOf("_"));
				String valueToSubstitute = xpathsArray[i].substring(xpathsArray[i].indexOf("_")+1);
				xmlOutput = modifyXMLOutput(xpathExpression, valueToSubstitute,fileData);
				fileData=xmlOutput;
			}	
		}
			
		if (protocol.equals("http")) {
			sslServer = host + ":" + httpPort;
		} else {
			if (protocol.equals("https")) {
				sslServer = host + ":" + httpsPort;
			} else
				System.out.println("Unknown protocol");
		}
		 
		int count=1;
		String inputs[]=inputString.toString().split("&");
		
		if(!inputURI.contains("{"))
		{
		if(inputString.contains("param"))
		{
		inputString=inputString.substring(inputString.indexOf("=")+1);	
		}
		}
		while(inputURI.contains("{"))
		{	
			
			int arr=0;
			StringBuffer temp=new StringBuffer();
			String temp1= new String();
			for(arr=0;arr<inputs.length;arr++)
			{
				if((inputs[arr]).contains("fileData"))
				{	
					
					temp.append(fileData);
				}
			    if(inputs[arr].contains("?"))
			    {
			    	System.out.println(inputs[arr]);
			    	temp1=inputs[arr];
			    }
			}
			for(arr=0;arr<inputs.length;arr++)
				if((inputs[arr].split("="))[0].contains("param"+count))
					break;
				
			
			int start = inputURI.indexOf("{");
			int end=inputURI.indexOf("}",start);
			inputURI=inputURI.substring(0,start)+(inputs[arr].split("="))[1]+inputURI.substring(++end);
			
			inputString = inputString.substring(inputString.indexOf("&")+1);
			
			if(temp1.length()>0)
		     inputString=temp1.toString();
			if(temp.length()>0)
			inputString=temp.toString();
			count++;
		
			
			
		}
		  if(inputString.contains("fileData"))
		  {
			inputString= fileData;  
		  }
		
		  	 
		/*filePath ends*/

		// Login
		int code = 0;
		
		if (method.equals("GET"))// Code for method=Get
		{
           
			String uri = new URI(protocol, sslServer, inputURI, inputString, null).toString();
			if(uri.contains("%3F"))
			{
				uri=uri.replace("%3F", "?");
			}
			if (inputString != null && inputString.length() > 0) {
				System.out.println("URI : " + uri + "\n");
			}
			startTime=0;
			endTime=0;
			time=0;
			startTime=System.currentTimeMillis();
			
			code = doGet(uri,inputString);
			endTime =System.currentTimeMillis();
			
			time=endTime-startTime;
		    
			
			
		} else if(method.equals("POST"))// Code For method=Post
		{

			String uri = new URI(protocol, sslServer, inputURI, null, null)
					.toString();
			System.out.println("URI -" + uri + "\nInput String - "
					+ inputString);
			String []input = null;
		      
			startTime=0;
			endTime=0;
			time=0;
			startTime=System.currentTimeMillis();
			if(uri.contains("login.ws"))
			{
				  DefaultHttpClient httpclient= new DefaultHttpClient();
				  StringEntity se = new StringEntity(inputString ,"UTF-8"); 
				  HttpContext localContext = new BasicHttpContext();
				  HttpPost httppost = new HttpPost(uri);
				  httppost.setEntity(se);
				  HttpResponse emsResponse = httpclient.execute(httppost,localContext);
				  
				  Header[] cookieHeader=emsResponse.getHeaders("Set-Cookie"); 
				   if(cookieHeader!=null && cookieHeader.length>0){
						for(Header header:cookieHeader)
				         {  
				   for(HeaderElement element:header.getElements())
				     {
				        	
				     if(element.getName().equalsIgnoreCase("JSESSIONID"))
				     {
				       sessionId=element.getValue();
				    	break;
				    	
				    	}     
				        }
				     if(sessionId!=null && sessionId.length()>0)
				     {
				    	  break;
				     }
				      
				         }}	 
				    code =emsResponse.getStatusLine().getStatusCode();
					if(code==HttpStatus.SC_OK)
					{
				  HttpEntity entity =emsResponse.getEntity();
				
				//  System.out.println(EntityUtils.getContentCharSet(entity));
				  respMessage =EntityUtils.toString(entity);
				//  responseList.add(respMessage);
				// actualResponse.append(respMessage);
				 //actualReturnCode.append(Integer.toString(statuscode));
				 
				 System.out.println("SessionId in ExecutionEngine :"+sessionId);
				 System.out.println("respMessage in ExecutionEngine:"+respMessage);
				 
					}}
						
		//Login for json
			
		
			else
			{
				
				code = doPost(uri, inputString);
			}
			if  (uri.contains("Login.xml")||uri.contains("loginByEID.xml")||uri.contains("loginByContact.xml"))
			{
			//if (code == HttpServletResponse.SC_OK) 
			if (Integer.toString(code).matches(eRC)) 
				{
						if (code==HttpServletResponse.SC_OK)
						{
							if(inputURI.indexOf(".json") != -1)
							{
								sessionId = JSONObject.fromObject(respMessage).getString("sessionId");	
								respMessage = "JSON :" + respMessage;	
							}
							else
							{
								SAXBuilder parser = new SAXBuilder();
								StringReader reader = new StringReader(respMessage);
								try
								{
									Document doc = parser.build(reader);
									Element rootElement = doc.getRootElement();
									sessionId = rootElement.getChild("sessionId").getText();
								}
								catch(Exception e)
								{
									System.out.println("Exception Occurred while Parsing : " +respMessage);
									e.printStackTrace();
								}
							}
						}
						System.out.println("[RESPONSE]  " + respMessage);
				}
				else
				{
					if(respMessage.indexOf(eResponse) != -1)
					{
						respMessage = eResponse;
					}
						if (respMessage.indexOf("Error")!=-1)
						{
						System.out.println("failure : " + JSONObject.fromObject(respMessage).getString("Error"));
						}
						if (code==HttpServletResponse.SC_OK)
						{
							sessionId = JSONObject.fromObject(respMessage).getString("sessionId");	
						}
//						if (code!=HttpServletResponse.SC_OK)
//						{
//						}
				}
			//actualResponse.append(respMessage);
			//actualReturnCode.append(Integer.toString(code));
			}
            endTime =System.currentTimeMillis();
			
			time=endTime-startTime;
		}
		else if(method.equals("PUT"))
		{
			String uri = new URI(protocol, sslServer, inputURI, null, null)
			.toString();
	System.out.println(":URI -" + uri + "\nInput String - "
			+ inputString);
	startTime=0;
	endTime=0;
	time=0;
	startTime=System.currentTimeMillis();
	code = doPut(uri, inputString.getBytes());
	endTime =System.currentTimeMillis();
	
	time=endTime-startTime;
		}
		else
		{
			String uri = new URI(protocol, sslServer, inputURI, null, null)
			.toString();
			if (inputString != null && inputString.length() > 0) {
				System.out.println("URI : " + uri + "\n");
			}
			startTime=0;
			endTime=0;
			time=0;
			startTime=System.currentTimeMillis();
	code = doDelete(uri);
endTime =System.currentTimeMillis();
	
	time=endTime-startTime;
		}

		
	//String uri = new URI(protocol, sslServer, inputURI, null, null)

		//.toString();
		
	//}
	
	
			
		
		/***************** Code For WebService=Login *****************/
		/*if (serviceName.equals("productKeyLogin")) {
			if (code == HttpServletResponse.SC_OK)
			if (Integer.toString(code).matches(eRC)) {
				if (code == HttpServletResponse.SC_OK) {
					if (inputURI.indexOf(".json") != -1) {
						sessionId = JSONObject.fromObject(respMessage)
								.getString("sessionId");
						respMessage = "JSON :" + respMessage;
					} else {
						SAXBuilder parser = new SAXBuilder();
						StringReader reader = new StringReader(respMessage);
						try {
							Document doc = parser.build(reader);
							Element rootElement = doc.getRootElement();
							sessionId = rootElement.getChild("sessionId")
									.getText();
							
						} catch (Exception e) {
							System.out
									.println("Exception Occurred while Parsing : "
											+ respMessage);
							e.printStackTrace();
						}
					}
				}
				System.out.println("[RESPONSE]  " + respMessage);
			} else {
				if (respMessage.indexOf(eResponse) != -1) {
					respMessage = eResponse;
				}
				if (respMessage.indexOf("Error") != -1) {
					System.out.println("failure : "
							+ JSONObject.fromObject(respMessage).getString(
									"Error"));
				}
				if (code == HttpServletResponse.SC_OK) {
					//sessionId = JSONObject.fromObject(respMessage).getString("sessionId");
				
				}
				
				// if (code!=HttpServletResponse.SC_OK)
				// {
				// }
					}}*/
			actualResponse.append(respMessage);
			responseTime.append(time);
			responseList.add(respMessage);
			 actualReturnCode.append(Integer.toString(code));
		
		}
		/***************** End Of Code For WebService=Login *****************/

			/***************** Code For WebService Except Login ***************/
	
	
	
	/**
	 * This method reads text data as string from a file.
	 * @param inputString
	 * @return
	 */
	
	  private static String readFile(String filePath)
	  {
		  StringBuffer fileData = new StringBuffer(1000);
		  try{
		      BufferedReader reader = new BufferedReader(
		              new FileReader(filePath));
		      char[] buf = new char[1024];
		      int numRead=0;
		      while((numRead=reader.read(buf)) != -1){
		          String readData = String.valueOf(buf, 0, numRead);
		          fileData.append(readData);
		          buf = new char[1024];
		      }
		      reader.close();
		  }
		  catch(Exception ex)
		  {
			  ex.printStackTrace();
		  }
		  return fileData.toString();
	      
		  
	  }

	/**
	 * 
	 * @param inputString
	 * @param outputList
	 * @return
	 */
    public static String processInputStringForFILEPATH(String inputString)
    {
    	
    	String startingString = inputString.substring(0, inputString.indexOf("filePath_"));
		String endingString = inputString.substring(inputString.indexOf("filePath_"));
		String filePath;
		if(endingString.contains("&"))
		{	filePath = endingString.substring(endingString.indexOf("_")+1, endingString.indexOf("&"));
			endingString = endingString.substring(endingString.indexOf("&"));
		}
		else if (endingString.contains(";"))
		{	filePath=endingString.substring(endingString.indexOf("_")+1,endingString.indexOf(";"));
			endingString =endingString.substring(endingString.indexOf(";"));
		}
		else
		{
			filePath=endingString.substring(endingString.indexOf("_")+1);
			endingString ="";
		}
		
		
		fileData = readFile(filePath);
		inputString = startingString + "fileData" + endingString;
		
		return inputString;
	}	
    	
    
	private static String processInputStringForXPATH(String inputString, List<String> outputList) {
		String temp = inputString.substring(inputString.indexOf("_")+1, inputString.indexOf(";"));
		String xmlOutput;
		if(!temp.contains((".xml")))
		{
		int outputStepNo = Integer.valueOf(inputString.substring(inputString.indexOf("_")+1, inputString.indexOf(";")));
		outputStepNo--;
		xmlOutput = outputList.get(outputStepNo);
		}
		else
		{
			xmlOutput=temp;
		}
		if(xmlOutput.contains(".xml"))
			xmlOutput=readFile(xmlOutput);
		
			
		String[] xpathsArray = inputString.substring(inputString.indexOf(";")).split(";");
		for (int i = 1; i < xpathsArray.length; i++) {
			String xpathExpression = xpathsArray[i].substring(0, xpathsArray[i].indexOf("_"));
			String valueToSubstitute = xpathsArray[i].substring(xpathsArray[i].indexOf("_")+1);
			xmlOutput = modifyXMLOutput(xpathExpression, valueToSubstitute,xmlOutput);
		}
		fileData=xmlOutput ;
		//Generating full string with file data updated by Anuja
		inputString = inputString.substring(0,inputString.indexOf("xpathoutput_")-1)+"&"+"fileData";
		
		//inputString = inputString + "fileData"; 
		return inputString;
	}

	private static String modifyXMLOutput(String xpathExpression, String valueToSubstitute, String xml) {
		String stringResult = "";
		try {
			Properties properties = new Properties();
			InputStream inStream = new FileInputStream("xpathMap/xpath.properties");
			properties.load(inStream);
			xpathExpression = (String)properties.get(xpathExpression);
			if(xpathExpression == null)
				throw new Exception("xpathExpression is null. Check properties file.");
			javax.xml.parsers.DocumentBuilderFactory domFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
			domFactory.setNamespaceAware(true);
			javax.xml.parsers.DocumentBuilder builder = domFactory.newDocumentBuilder();
			org.w3c.dom.Document doc = builder.parse(new InputSource(new StringReader(xml)));
			javax.xml.xpath.XPath xpath = javax.xml.xpath.XPathFactory.newInstance().newXPath();
			// XPath Query for showing all nodes value
			javax.xml.xpath.XPathExpression expr = xpath.compile(xpathExpression);
			Object result = expr.evaluate(doc,javax.xml.xpath.XPathConstants.NODESET);
			org.w3c.dom.NodeList nodes = (org.w3c.dom.NodeList) result;
			org.w3c.dom.Node node = nodes.item(0);
			    node.setTextContent(valueToSubstitute);
			    
		    Source source = new DOMSource(doc.getFirstChild());
		    StringWriter stringWriter = new StringWriter();
		    Result result1 = new StreamResult(stringWriter);
		    TransformerFactory factory = TransformerFactory.newInstance();
		    Transformer transformer = factory.newTransformer();
		  // Omitting the declaration part of xml. by Anuja
		    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		    transformer.transform(source, result1);
		    

		    stringResult = stringWriter.getBuffer().toString();	
		    
		    
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return stringResult;
	}

	/*
	 * Used when 1. a value in name value pair is to be substituted with a value
	 * in json or xml output. 2. COMPLETE xml or json output is to be inserted
	 * in a value in name value pair
	 */
	 
	 /*
	private static String processInputString(String inputString,
			List<String> outputList) {
		String[] strArray = inputString.split("&");
		
		String subString = null;
		String paramValue = null;
		
		for (int i = 0; i < strArray.length; i++) {
			if (strArray[i].indexOf("OUTPUT_") != -1) {
				
				subString = strArray[i].substring(strArray[i].indexOf("=") + 1);
				String[] details = subString.split("_");
				String output = outputList.get(Integer.valueOf(details[1]).intValue() - 1);
				String [] outputDetails = output.split(",");
				if(output.contains(".xml"))
					output=readFile(output);
				String paramName = details[2];
				inputString = inputString + "&";
				if (paramName.equals("COMPLETE")) {
					if (output.startsWith("JSON :")) {
						output = output.substring(6);
					}
					inputString = inputString.replaceFirst("OUTPUT_\\d*_\\w*&",
							output + "&");
					break;// if the output is in XML format then the WS which
							// resulted in output should
					// be .xml WS call.
				}
				// if above if executes then the below if will not get executed.
				if (output.startsWith("JSON :")) {
					output = output.substring(6);
					try {
						paramValue = JSONObject.fromObject(output).getString(
								paramName);
					} catch (JSONException je) {
						je.printStackTrace();
					}
				} else {
					// extract parameter value from xml output string.
					SAXBuilder parser = new SAXBuilder();
					StringReader reader = new StringReader(output);
					try {
						Document doc = parser.build(reader);
						Element rootElement = doc.getRootElement();

						if (rootElement.getChild(paramName) == null) {
							paramValue = output.substring(output.indexOf("<"
									+ paramName + ">")
									+ 2 + paramName.length(), output
									.indexOf("</" + paramName + ">"));
						} else {
							paramValue = rootElement.getChild(paramName)
									.getText();
						}
					} catch (Exception e) {
						System.out
								.println("Exception Occurred while Parsing : "
										+ output);
						e.printStackTrace();
						break;
					}
				}
              //updated by anuja for OUTPUT_stepno_tagname  
				inputString = inputString.replaceFirst("OUTPUT_\\d*_\\w*&",
						paramValue + "&");
			}
		}
		
		return inputString;
		
	}
	
	*/
	
	private static String processInputString(String inputString, List<String> outputList) throws JDOMException, IOException {
		String[] strArray = inputString.split("&");
		String returnString = "";
		//inputString = "";
		String subString = null;
		String paramValue = "";
		String[] xpathAgrs = null;
		int k=0;
		String output = null;
		for (int i = 0; i < strArray.length; i++) {
			xpathAgrs = strArray[i].toString().split(";");
			for(int j =0; j < xpathAgrs.length; j++){
				if (xpathAgrs[j].indexOf("OUTPUT_") != -1) {					
					subString = xpathAgrs[j].substring(xpathAgrs[j].indexOf("OUTPUT_"));					
					String[] outputsToUpdate = subString.split(",");  
					
					for(int o2=0; o2< outputsToUpdate.length; o2++){
						String[] details = outputsToUpdate[o2].split("_");						
						String paramName = details[2];
						output = outputList.get(Integer.valueOf(details[1]).intValue() - 1);
						if(paramName.indexOf("COMPLETE") != -1){							
							outputsToUpdate[o2] = output;
						}else{
							if(output.contains(".xml"))
								output=readFile(output);
							
							SAXBuilder parser = new SAXBuilder();
							StringReader reader = new StringReader(output);
							
							try {
								Document doc = parser.build(reader);
								XPath xPath = XPath.newInstance("//" + paramName);						    
							    Element param = (Element) xPath.selectSingleNode(doc);
								
							    paramValue = param.getText();
							    if(paramName.contains("/"))
							    	outputsToUpdate[o2] = paramValue;
							    else
							    	outputsToUpdate[o2] = outputsToUpdate[o2].replaceFirst("OUTPUT_\\d*_\\w*", paramValue);								
							} catch (Exception e) {
								System.out.println("Exception Occurred while Parsing : " + output);
								e.printStackTrace();
								break;
							}
						}									 
					}
					subString = "";
					for(String token : outputsToUpdate){
						if(subString.length()>0)
							subString += ",";
						subString += token;
					}
					
					xpathAgrs[j] = xpathAgrs[j].substring(0, xpathAgrs[j].indexOf("OUTPUT_")) + subString;
				}
			}			
			String actvals = "";
			k=0;
			for(String args : xpathAgrs){
				if(k>0)
					actvals = actvals.concat(";");
				actvals = actvals.concat(args);
				k++;
			}
			strArray[i] = actvals;
		}
		k=0;
		for(String str : strArray){			
			if(k>0)
				returnString += "&";
			returnString = returnString.concat(str);
			k++;
		}
		return returnString;
	}
	

	/**
	 * Used when 1. Json output(can be COMPLETE) of previous step is to be
	 * substituted in json input of current step. 2. XML(can be COMPLETE) output
	 * of previous step is to be substituted in XML input of current step.
	 * 
	 * @param inputString
	 * @param outputList
	 * @param uri
	 *            - used for determining request is .xml or .json
	 * @return
	 */
	private static String processInputStringForJSON(String inputString,
			List<String> outputList, String uri) {
		String subString = null;
		String paramValue = null;
		while (inputString.indexOf("JSON_") != -1) {
			int index = inputString.indexOf("JSON_");
			int endIndex = inputString.indexOf("<", index);
			String nameValue = inputString.substring(index, endIndex);
			subString = nameValue.substring(nameValue.indexOf("=") + 1);// this
																		// line
																		// not
																		// required
			String[] details = subString.split("_");
			String output = outputList.get(Integer.valueOf(details[1])
					.intValue() - 1);
			String paramName = details[2];
			if (paramName.equals("COMPLETE'")) {
				if (uri.indexOf(".xml") != -1) {
					inputString = inputString.replaceFirst("JSON_\\d*_\\w*<",
							output + "<");
				} else {
					inputString = inputString.replaceFirst("JSON_\\d*_\\w*'",
							output + "'");
				}
				break;
			}
			if (paramName.indexOf("'") != -1)
				paramName = paramName.substring(0, paramName.indexOf("'"));

			if (output.startsWith("JSON :")) {
				output = output.substring(6);
				paramValue = JSONObject.fromObject(output).getString(paramName);
			} else {
				// extract parameter value from xml output string.
				SAXBuilder parser = new SAXBuilder();
				StringReader reader = new StringReader(output);
				try {
					Document doc = parser.build(reader);
					Element rootElement = doc.getRootElement();
					paramValue = rootElement.getChild(paramName).getText();
				} catch (Exception e) {
					System.out.println("Exception Occurred while Parsing : "
							+ output);
					e.printStackTrace();
					break;
				}
			}
			// inputString = inputString.replaceFirst("JSON_\\d*_\\w*<",
			// paramValue+"<");
			if (uri.indexOf(".xml") != -1) {
				inputString = inputString.replaceFirst("JSON_\\d*_\\w*<",
						output + "<");
			} else {
				inputString = inputString.replaceFirst("JSON_\\d*_\\w*'",
						output + "'");
			}

		}

		return inputString;
	}

	/*
	 * private static String processInputStringForJSON(String inputString,
	 * List<String> outputList) { String subString = null;
	 * 
	 * while(inputString.indexOf("JSON_") != -1) { int index =
	 * inputString.indexOf("JSON_"); int endIndex = inputString.indexOf("'",
	 * index);
	 * 
	 * String nameValue = inputString.substring(index, endIndex);
	 * 
	 * subString = nameValue.substring(nameValue.indexOf("=")+1); String []
	 * details = nameValue.split("_"); String output=
	 * outputList.get(Integer.valueOf(details[1]).intValue()-1);
	 * if(output.startsWith("JSON :")) { // TODO :: truncate "JSON :" from
	 * output } String paramName = details[2]; if(paramName.equals("COMPLETE'"))
	 * { inputString = inputString.replaceFirst("JSON_\\d*_\\w*'", output+"'");
	 * break; } if(paramName.indexOf("'") != -1) paramName =
	 * paramName.substring(0, paramName.indexOf("'")); String paramValue =
	 * JSONObject.fromObject(output).getString(paramName); inputString =
	 * inputString.replaceFirst("JSON_\\d*_\\w*'", paramValue+"'");
	 * 
	 * }
	 * 
	 * return inputString; }
	 */
	/*doPost updated by Anuja*/
	private int doPost(String uri, String input) throws Exception {
		
		/***********Clear SessionId,if login is to be called***/ //Updated By Debasish
	        
				
		         byte postData[];
		       
		        if(uri.contains("loginByProductKey.ws"))
		         {
		         //input=input.substring(input.indexOf("&")+1);
		         uri=uri+"?productKey="+input;
		         }
		       		        
		        HttpURLConnection con = getConnection(uri);
				if (version != null) {
				con.setRequestProperty("Accept", version);
				}
			    con.setRequestMethod("POST");
				con.setDoOutput(true);
				if (sessionId != null) 
				con.setRequestProperty("Cookie", "JSESSIONID=" + sessionId);
				//ems_2.0 
				//con.setRequestProperty("Content-Type","application/x-www-form-urlencoded ; text/xml; charset=\"utf-8\"");
				con.setRequestProperty("Content-Type","text/xml; charset=\"utf-8\"");
				con.setInstanceFollowRedirects(true);
				postData=input.getBytes();
				con.getOutputStream().write(postData);
                 
				con.getOutputStream().flush();
				con.getOutputStream().close();
				/***********Clear SessionId,if login is to be called***/ //Updated By Debasish
				
				/**************************************************/    
				if(uri.contains("loginByProductKey.ws"))
				{
				String header;
				  for (int j = 1;; j++) {
				        header = con.getHeaderField(j);
				        if (header == null)
				          break;
				        if(header.contains("JSESSIONID"))
				        {
				        String s, s1=header;
				        
				        s=s1.substring(s1.indexOf("JSESSIONID"), s1.indexOf(";"));
				  
				        s=s.substring(s.indexOf("=")+1);
				        sessionId=s;
				        
				        }       }
				      }
				
					return getResponse(con);
		         
		/*HttpURLConnection con = getConnection(uri);
		if(version != null )
		{
			con.setRequestProperty("Accept", version);
		}
		con.setRequestMethod("POST");	
		con.setDoOutput(true);
		if (sessionId != null) {
			con.setRequestProperty("Cookie", "JSESSIONID=" + sessionId);
		}
		
		con.setInstanceFollowRedirects(true);
		
		con.getOutputStream().write(input.getBytes());
		con.getOutputStream().flush();
		con.getOutputStream().close();

		return getResponse(con);*/ 		
			}
			
   /*doPost*/

	
	private int doPut(String uri, byte[] postData) throws Exception {
		HttpURLConnection con = getConnection(uri);
		if (version != null) {
			con.setRequestProperty("Accept", version);
		}
		con.setRequestMethod("PUT");
		con.setDoOutput(true);
		if (sessionId != null) {
			con.setRequestProperty("Cookie", "JSESSIONID=" + sessionId);
		}

		con.setInstanceFollowRedirects(true);

		con.getOutputStream().write(postData);
		con.getOutputStream().flush();
		con.getOutputStream().close();

		return getResponse(con);
	}
	private int doGet(String uri,String input) throws Exception {
		
		HttpURLConnection con = getConnection(uri);
		con.setRequestMethod("GET");
		if (version != null) {
			con.setRequestProperty("Accept", version);
		}
		con.setDoOutput(false);
		con.setRequestProperty("Cookie", "JSESSIONID=" + sessionId);

		return getResponse(con);
	}
	private int doDelete(String uri) throws Exception {

		HttpURLConnection con = getConnection(uri);
		con.setRequestMethod("DELETE");
		if (version != null) {
			con.setRequestProperty("Accept", version);
		}
		con.setDoOutput(false);
		con.setRequestProperty("Cookie", "JSESSIONID=" + sessionId);

		return getResponse(con);
	}
	private HttpURLConnection getConnection(String uri) throws Exception,
			IOException {

		HttpURLConnection con = (HttpURLConnection) new URL(uri)
				.openConnection();
		con.setUseCaches(false);
		con.setRequestProperty("Accept", "application/json");

		return con;
	}

	private int getResponse(HttpURLConnection con) throws Exception {

		System.out.println("SessionId in ExecutionEngine : " + sessionId);
		InputStreamReader reader = null;

		// Get the input stream
		try {
			// Normal
			reader = new InputStreamReader(con.getInputStream());
		} catch (Exception e) {
			// Exception
			reader = new InputStreamReader(con.getErrorStream());
		}

		// Get the content
		try {

			// if
			// (con.getContentType().toLowerCase().contains("application/json"))
			if (con.getURL().toString().contains(".ws")
					|| con.getURL().toString().contains(".xml"))

			{

				char[] dataSect = new char[4096];
				int count = 0;
				respMessage = "";

				for (;;) {

					// Start retrieving data from server side
					count = reader.read(dataSect);

					if (count == -1) {
						// End of retrieving data
						break;
					} else {
						// Retrieving data
						if (count < dataSect.length) {
							// Part data is used
							char[] partDataSect = new char[count];
							System.arraycopy(dataSect, 0, partDataSect, 0,
									count);

							// Make use of part of the dataSect
							respMessage += String.valueOf(partDataSect);
						} else {
							// Make use of the dataSect directly
							respMessage += String.valueOf(dataSect);
						}
					}
				}
				if(respMessage=="")
					respMessage=con.getHeaderField("Location");
				reader.close();
				boolean jsonWS = false;
				if (con.getURL().toString().contains(".json")) {
					if (respMessage.indexOf("sessionId") == -1) // dont put in
																// list for
																// login output
						respMessage = "JSON :" + respMessage; // JSON : will be
																// truncated
																// from the
																// response
					// output while reading it.

					jsonWS = true;
				}
				if(con.getHeaderField("Content-Type")!=null)
				if(con.getHeaderField("Content-Type").contains("xml"))
					if (!service.equals("login") && !service.equals("loginByEID")
							&& !service.equals("loginByContact"))
							respMessage=convertToXml(respMessage);
				//responseList.add(respMessage);
				if (respMessage!=null)
				if (respMessage.indexOf("Resource not found") != -1) {
					System.out
							.println("/n Either resourse name or method invalid.");
				}
				System.out.println("respMessage in ExecutionEngine: "
						+ respMessage);
				/*
				 * WebService Returns JSON String which contains failure code in
				 * string.So, we have extract error code from string
				 */
				String errorcode = "", srch = "{\"stat\":\"fail\",\"code\":";
				if (jsonWS) {
					if (respMessage.contains(srch)) {
						int startindex = respMessage.indexOf(srch)
								+ srch.length();
						String str = respMessage.substring(startindex);
						int endindex = str.indexOf(",");
						errorcode = str.substring(0, endindex);
						return Integer.parseInt(errorcode);
					} else {
						return con.getResponseCode();
					}
				} else {
					String paramName = "code";
					
					if (respMessage!=null&&respMessage.contains(paramName)) {
						SAXBuilder parser = new SAXBuilder();
						StringReader respMessageReader = new StringReader(
								respMessage);
						Document doc = parser.build(respMessageReader);
						Element rootElement = doc.getRootElement();
						errorcode = rootElement.getChild(paramName).getText();
						return Integer.parseInt(errorcode);
					} else {
						
						
						
						
						return con.getResponseCode();
								
					}

				}
			} else {
				respMessage = new JSONObject().element("Error",
						con.getResponseMessage()).toString();
				return HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE;
			}
		} catch (Exception e) {
			// catch unexpected error
			String errorMessage = e.getMessage() != null ? e.getMessage() : con
					.getResponseMessage();
			respMessage = new JSONObject().element("Error", errorMessage)
					.toString();
			reader.close();
			return HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
		}
	}

	public String convertToXml(String response)
	{	String filePath = "outputxml/"+testId+"_"+stepNo+".xml";
		try
		{
		File file1=new File(filePath);
		if(file1.exists())
		{
			file1.delete();
		}
		FileOutputStream fileRef=new FileOutputStream(filePath,true);
		fileRef.write(response.getBytes());
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return filePath;
	}
	public void clearResponseList() {
		responseList.clear();
	}
	
	public void isArrayClass(StringBuffer actualResponse, Object value)
	{
		 Object[] array1 = (Object[]) value;
	 try{
	     for (Object a :array1 )
	     {
	 	 Class<?> cls1 =Class.forName(a.getClass().getCanonicalName());
	      Object obj_1 =Class.forName(a.getClass().getCanonicalName());
	 	Field [] field1 = cls1.getDeclaredFields();
	 
	 	
	 	//if (field1.length>0)
	 	 for(Field f: field1)
	 	 {
	 		
	 		if(!Modifier.isPublic(f.getModifiers()))
		    		f.setAccessible(true);
	 	 
	 		if(!f.toString().contains("_"))
	 		{
	 	  Object output=f.get(a);
	 	  if(output==null)
	 	  {
	 	   Class <?> c =Class.forName(a.getClass().getName());	
	 	   Field [] f1 =c.getDeclaredFields();
	 	   for(Field ff : f1)
	 	   {
	 		  if(!Modifier.isPublic(ff.getModifiers()))
		    		ff.setAccessible(true);
	 		   output=ff.get(a);
	 		   if(output!=null)
	 		  actualResponse.append(ff.getName()+output.toString());   
	 	   }
	 	  }
	 	
	 	  else
	 	 actualResponse.append(f.getName()+output.toString());
	 		}
	 		
	}

	}
	 }
	 catch(Exception e)
	 {
		 System.out.println(e.getMessage());
	 }
	 }
}


