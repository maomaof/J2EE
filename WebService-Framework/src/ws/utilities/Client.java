package ws.utilities;
//import ws.driver.*;
//import ws.library.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Properties;


public class Client {
	Socket requestSocket;
	ObjectOutputStream out;
 	ObjectInputStream in;
 	String message;
 	String host ;
 	int serverPort ;
 	boolean serverOn = false;
 	
 	Client()
 	{
 		try
 		{
 			Properties properties = new Properties();
 			InputStream inStream = new FileInputStream("ConfigurationFiles/WebServiceAutomation.properties"); 
 			properties.load(inStream);
 			
 			// For authentication etc
 			host = properties.getProperty("host");
 			serverPort = Integer.valueOf(properties.getProperty("serverPort"));
 			
	 		requestSocket = new Socket(host, serverPort);
	 		System.out.println("Connected to " + host +" in port "+ serverPort);
	 		//2. get Input and Output streams
	 		out = new ObjectOutputStream(requestSocket.getOutputStream());
	 		out.flush();
	 		in = new ObjectInputStream(requestSocket.getInputStream());
	 		
	 		message = (String)in.readObject();
			System.out.println("server>" + message);
 		}
 		catch(Exception ex)
 		{
 			System.out.println("COULD NOT CONNECT TO HOST : " + host);
 			ex.printStackTrace();
 			System.exit(1);
 		}
 	}
 	
 	public boolean isServerOn()
 	{
 		return serverOn;
 	}
 	
 	public void startServer()
 	{
 		sendMessage("Start");
 		serverOn = true;
 	}
 	
 	public void stopServer()
 	{
 		sendMessage("Stop");
 		serverOn = false;
 	}
 	
 	public void runScript()
 	{
 		sendMessage("runScript");
 		serverOn = false;
 	}
 	public void endConnection()
 	{	sendMessage("Bye");
 		serverOn = false;
 	}
 	
 	void sendMessage(String msg)
	{
		try{
			out.writeObject(msg);
			out.flush();
			System.out.println("client>" + msg);
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	
 	
}
