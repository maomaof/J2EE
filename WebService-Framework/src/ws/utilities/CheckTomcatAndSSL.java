package ws.utilities;
import ws.driver.*;
import ws.library.*;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//import java.net.URL;

import javax.net.ssl.*;
import javax.net.ssl.HttpsURLConnection;

import com.sun.net.ssl.*;


public class CheckTomcatAndSSL {
	
	
		public String validate(String trustStore ,String trustStorePassword ,String hostName ,String httpPort ,String httpsPort, String SSLConfigured ) 
		{
				String url, responseMessage;
				int responseCode;
				boolean result=false;
				String httpURL="http://"+hostName+ ":" + httpPort;
				String httpsURL="https://"+hostName+ ":" + httpsPort;
				HttpURLConnection httpCon;
				HttpsURLConnection httpsCon;
				String resultDescription="";
				
				
				try {
				if(SSLConfigured.equalsIgnoreCase("Y"))
				{	
					
						
					
						File f=new File(trustStore);
						if(!(f.isFile()))
						{	
							System.out.println("keystore not found");
							resultDescription="keystore not found";
						}
						else
						{
					
						
						System.setProperty("javax.net.ssl.trustStore", trustStore);
						System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
					
					
							httpsCon = (HttpsURLConnection) new URL(httpsURL).openConnection();
					
					
							httpsCon.setUseCaches(false);
				
							httpsCon.setRequestMethod("GET");
				
							httpsCon.setDoOutput(false);
					
							try
							{
								responseMessage = httpsCon.getResponseMessage();
					
								responseCode = httpsCon.getResponseCode();
						
								if(responseMessage.equalsIgnoreCase("ok"))
								{
									resultDescription = "ok";
								}
								else
								{	
									httpsURL=httpsURL+"/ems/";
									httpsCon = (HttpsURLConnection) new URL(httpsURL).openConnection();
									
									
									httpsCon.setUseCaches(false);
						
									httpsCon.setRequestMethod("GET");
						
									httpsCon.setDoOutput(false);
									
									responseMessage = httpsCon.getResponseMessage();
									
									responseCode = httpsCon.getResponseCode();
									
									if(responseMessage.equalsIgnoreCase("ok"))
									{
										resultDescription = "ok";
									}
									
									else
									{
										resultDescription = "Fail";
									}
							
								}
							}
					
							catch(javax.net.ssl.SSLException e)
							{
								e.printStackTrace();
								resultDescription="Invalid keystore";
								System.out.println("Invalid keystore");
							}
					
							catch(java.net.ConnectException e)
							{
								resultDescription="SSL is not Configured on given port number";
								System.out.println("SSL is not Configured on given port number");
							}
					
							catch(java.net.SocketException e)
							{
								e.printStackTrace();
								resultDescription="Wrong password";
								System.out.println("Wrong password");
							}
							catch(java.net.UnknownHostException e)
							{
								resultDescription="Unknown Host";
								System.out.println("Unknown Host");
							}
					
					
						}
					
						}
						
			
				else
					if(SSLConfigured.equalsIgnoreCase("N"))
					{
						httpCon=(HttpURLConnection) new URL(httpURL).openConnection();
						
						
						httpCon.setUseCaches(false);
					
						httpCon.setRequestMethod("GET");
					
						httpCon.setDoOutput(false);
						try
						{
							responseMessage = httpCon.getResponseMessage();
						
							responseCode = httpCon.getResponseCode();
							
							if(responseMessage.equalsIgnoreCase("ok"))
							{
								resultDescription = "ok";
							}
							else
							{
								resultDescription = "Fail";
								
							}
						}
						catch(java.net.ConnectException e)
						{
							resultDescription="Please start tomcat first,  Tomcat is not running on the given port number.";
							System.out.println("Please start tomcat first,  Tomcat is not running on the given port number.");
							
						}
						catch(java.net.UnknownHostException e)
						{
							resultDescription="Unknown Host";
							System.out.println("Unknown Host");
						}
							
						
						
						
						
						
						
						
							
					}	
					
					
					
					
					else
					{
						url="invalid";
						resultDescription="Invalid SSL parameter";
						System.out.println("Invalid SSL parameter");
					
					}
				
					
					
				
				} 
				
				catch (MalformedURLException e) {
					
					resultDescription="MalformedURL";
					e.printStackTrace();
				} catch (java.net.SocketException e) {
					
					resultDescription="Java.net.socketException";
					e.printStackTrace();
				}catch (IOException e) {
					
					resultDescription="IOException";
					e.printStackTrace();
				}
				return resultDescription;
				
				}
				
			
		
		

	}


