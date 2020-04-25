package selenium.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
//import org.json.JSONObject;
import org.apache.http.client.HttpClient;

public class WebService {

	String version="application/vnd.ems.v12";
	
	String respMessage;
	private static ConfigurationReader configuration=new ConfigurationReader("ConfigurationFiles/configuration.properties");
	
	String trustStore=configuration.getPropertyValue("keystorePath");
	String trustStorePassword=configuration.getPropertyValue("keyStorePassword");
	
	public WebService()
	{
		System.setProperty("javax.net.ssl.trustStore", trustStore);
		System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
	}
	String sessionId;
	public int login(String uri, String input)throws Exception
	{
		
		byte postData[];
	    	       
        input= readFile(input);
        HttpURLConnection con = getConnection(uri);
		if (version != null) {
		con.setRequestProperty("Accept", version);
		}
	    con.setRequestMethod("POST");
		con.setDoOutput(true);
		
		
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
		
		Map m = con.getHeaderFields();
		String abc=m.get("Set-Cookie").toString();
		sessionId=abc.substring(abc.indexOf("JSESSIONID="),abc.indexOf(";", abc.indexOf("JSESSIONID")));
		
		
		
			return getResponse(con, sessionId);
	}
	public int doPost(String uri, String input) throws Exception {
		
		/***********Clear SessionId,if login is to be called***/ //Updated By Debasish
	        
				
		         byte postData[];
		       
		       
		        input= readFile(input);
		        HttpURLConnection con = getConnection(uri);
				if (version != null) {
				con.setRequestProperty("Accept", version);
				}
			    con.setRequestMethod("POST");
				con.setDoOutput(true);
				if (sessionId != null) 
				con.setRequestProperty("Cookie", sessionId);
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
					
					return getResponse(con, sessionId);
	
			}
			
   /*doPost*/

	
	public int doPut(String uri, String input) throws Exception {
		byte postData[];
	        
        input= readFile(input);
		HttpURLConnection con = getConnection(uri);
		if (version != null) {
			con.setRequestProperty("Accept", version);
		}
		con.setRequestMethod("PUT");
		con.setDoOutput(true);
		if (sessionId != null) {
			con.setRequestProperty("Cookie", sessionId);
		}

		con.setInstanceFollowRedirects(true);
		postData=input.getBytes();
		con.getOutputStream().write(postData);
		con.getOutputStream().flush();
		con.getOutputStream().close();

		return getResponse(con, sessionId);
	}
	public int doGet(String uri) throws Exception {

		HttpURLConnection con = getConnection(uri);
		con.setRequestMethod("GET");
		if (version != null) {
			con.setRequestProperty("Accept", version);
		}
		con.setDoOutput(false);
		con.setRequestProperty("Cookie", sessionId);

		return getResponse(con, sessionId);
	}
	public int doDelete(String uri) throws Exception {

		HttpURLConnection con = getConnection(uri);
		con.setRequestMethod("DELETE");
		if (version != null) {
			con.setRequestProperty("Accept", version);
		}
		con.setDoOutput(false);
		con.setRequestProperty("Cookie", sessionId);

		return getResponse(con, sessionId);
	}
	private HttpURLConnection getConnection(String uri) throws Exception,
			IOException {

		HttpURLConnection con = (HttpURLConnection) new URL(uri)
				.openConnection();
		con.setUseCaches(false);
		con.setRequestProperty("Accept", "application/json");

		return con;
	}

	private int getResponse(HttpURLConnection con,String sessionId) throws Exception {

		
						
						
						
						return con.getResponseCode();
								
		
	}

	public String convertToXml(String response)
	{	String filePath = "outputxml.xml";
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
}
