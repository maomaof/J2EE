package ws.utilities;
import ws.driver.*;
import ws.library.*;
import java.io.*;
import java.net.*;
public class Server{
	ServerSocket providerSocket;
	Socket connection = null;
	ObjectOutputStream out;
	ObjectInputStream in;
	String message;
	
	Runnable service1 = new RunBatchFile1();
	Thread thread = null;
	RunBatchfile2 service2 = new RunBatchfile2();
	SQLScriptExecutor executor = new SQLScriptExecutor();
	
	Server(){}
	
	void run(int serverPort, String startupPath, String shutdownPath)
	{
		
		((RunBatchFile1)service1).setstartupPath(startupPath);
		service2.setshutdownPath(shutdownPath);
		
		try{
			//1. creating a server socket
			providerSocket = new ServerSocket(serverPort, 10);
			//2. Wait for connection
			System.out.println("Waiting for connection");
			connection = providerSocket.accept();
			System.out.println("Connection received from " + connection.getInetAddress().getHostName());
			//3. get Input and Output streams
			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();
			in = new ObjectInputStream(connection.getInputStream());
			sendMessage("Connection successful");
			//4. The two parts communicate via the input and output streams
			do{
				try{
					System.out.println("JUST BEFORE READ");
					message = (String)in.readObject();
					System.out.println("client>" + message);
					if (message.equalsIgnoreCase("Start"))
					{
						thread = new Thread(service1);
						thread.start();
					}
					if (message.equalsIgnoreCase("Stop"))
					{
						service2.shutdown();
					}
					if(message.equalsIgnoreCase("runScript"))
					{
						executor.runScript();
					}
					
					//	sendMessage("bye");
				}
				catch(ClassNotFoundException classnot){
					System.err.println("Data received in unknown format");
				}
			}while(!message.equals("Bye"));
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			//4: Closing connection
			try{
				in.close();
				out.close();
				providerSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}
	void sendMessage(String msg)
	{
		try{
			out.writeObject(msg);
			out.flush();
			System.out.println("server>" + msg);
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	public static void main(String args[])
	{
//		startUpPath = args[2];
//		shutdownPath = args[3];
//		installationPath = args[1];
//		serverPort = args[0];
//		
//		providerSocket = "";
		
		Server server = new Server();
		
			server.run(Integer.valueOf(args[0]), args[1], args[2]);
	}
}
