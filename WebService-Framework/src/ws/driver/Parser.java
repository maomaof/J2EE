/*---------------------------PARSER TO GET VALUES FROM XML FILE ----------------------------------*/
/*---------------------------CREATED BY RAKHI-----------------------------------------------------*/
/* Updation Date: 18-Aug-2011
 * Updated By: Debasish
 * Updated Section: inputParameters manipulation
 * Objective: To resolve issue: If only xml input file is to be passed to webservice url, then xml being created for processing, gets invalid. symbol "&" is created before xml.
 */
package ws.driver;
import ws.library.*;
import ws.utilities.*;

import java.awt.Dialog;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.swing.JOptionPane;

import net.sf.json.JSONObject;

import org.jdom.Element;

public class Parser {
	
	static String stop;

	ReportGenerator generator = new ReportGenerator();
	DatabaseSetup databaseSetup = new DatabaseSetup();
	FunctionExecutor functionExeceutor = new FunctionExecutor();
	

 	boolean dbCleanUp ;
 	
 	public Parser()
 	{
// 		loadProperties();
 	}
 	
	//METHOD TO FETCH VALUES FROM INPUT FILE.
	/**q
	 * @throws Exception
	 */
	public void getValuesFromInputFile()throws Exception
	{
		try{
		generator.createSummaryReportHeader("");
		
			databaseSetup.cleanup(null,0); // start with a fresh EMS DB
			
			ExecutionEngine engine = new ExecutionEngine();
			List<File> fileList=Arrays.asList(getFiles("InputFiles"));//Get list of Files From InputFolder
			String url=null;
			String protocol=null;
			String method=null;
			String expectedReturnCode = null;
			String expectedResponse = null;
			String serviceName = null;
			String output = "";
			
			
			Calendar cal = new GregorianCalendar(); 
			
			String month = String.valueOf(cal.get(Calendar.MONTH)+1);
			String dayOfMonth = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
			String year = String.valueOf(cal.get(Calendar.YEAR));
			String hour24 = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
			String min = String.valueOf(cal.get(Calendar.MINUTE));
			String todaysDate =  year+"-"+month+"-"+dayOfMonth;
			
			List<Element> inputList = null;
			String sqlQuery = null;
			String dbNameToRunQuery = null;
			String functionName = null;
			
			for(File file : fileList)
			{
				System.out.println("Starting File Execution ....");
				String fileName = file.getName();
				fileName = fileName.replace("xml","html");
				generator.setFileName(fileName);
				generator.addSeperatorInSummaryReport();
				generator.createDetailedReportHeader("");
				
				System.out.println(file);
	//			System.out.println(file.getPath());
			
				Element rootElement = XMLParser.getRootElementFromXMLFile(file.getPath());
				List<Element> tcList = XMLParser.getChildren(rootElement, "TC");
				boolean performedDBCleanup = false;
				for (Element tcElement : tcList)
				{	
					System.out.println("\n" +"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
					String tcId = tcElement.getAttribute("id").getValue();
					System.out.println("TEST CASE ID :" + tcId);
					String tcDescription = tcElement.getAttribute("TestDescription").getValue();
					
					List<Element> StepList = XMLParser.getChildren(tcElement, "Step");
					int i=0;
					String stepNumber;
					
					for (Element stepElement : StepList)
					{
						i++;
						stepNumber="STEP NO. "+i;
						System.out.println("\n" + stepNumber);
						
						Element serviceElement=XMLParser.getFirstChild(stepElement,"Service");
						serviceName = serviceElement.getAttribute("name").getValue().trim();
						
						// perform database cleanup when service name is DB_Cleanup
						// stop tomcat before cleaning up database
						
						if(serviceName.indexOf("DB_Cleanup")!= -1)
						{
							dbNameToRunQuery = serviceName.substring(10);
							databaseSetup.cleanup(dbNameToRunQuery, -1);
							performedDBCleanup = true;
							engine.addResponseList();
							continue;
						}
						String stepDescription = null;
						if(stepElement.getAttribute("StepDescription") != null)
						{
							stepDescription = stepElement.getAttribute("StepDescription").getValue();
						}
						if(serviceName.indexOf("SQLQuery") != -1)
						{
							inputList = XMLParser.getChildren(stepElement, "Input");
							sqlQuery = inputList.get(0).getText();
							dbNameToRunQuery = serviceName.substring(9);
							// TODO implement below method SQLQuery:DB1
							
							if (sqlQuery.contains("filePath_"))
							{ 
								ExecutionEngine.processInputStringForFILEPATH(sqlQuery);
								sqlQuery=ExecutionEngine.fileData;
							}
							boolean queryResult = databaseSetup.executeQuery(dbNameToRunQuery, sqlQuery);
							if(queryResult)
								generator.generateStepOutput(tcId ,tcDescription, stepDescription , serviceName,sqlQuery,"","",expectedResponse,null,"");
							else
								generator.generateStepOutput(tcId ,tcDescription, stepDescription , serviceName,sqlQuery,""," ",expectedResponse,null,"");
							continue;
						}
						
						if(serviceName.indexOf("Function") != -1)
						{
							inputList = XMLParser.getChildren(stepElement, "Input");
							functionName = inputList.get(0).getText();
							String functionResult = functionExeceutor.execute(functionName);
							if(functionResult.indexOf("Function executed succefully.") != -1)
								generator.generateStepOutput(tcId ,tcDescription, stepDescription , serviceName,functionName,"","",expectedResponse,null,functionResult);
							else
								generator.generateStepOutput(tcId ,tcDescription, stepDescription , serviceName,functionName,""," ",expectedResponse,null,functionResult);
						
							continue;
						}
						
						
						StringBuffer inputParameters = new StringBuffer();
						String inputToProcess = null;
						inputList = XMLParser.getChildren(stepElement, "Input");
						if(!(inputList.isEmpty()))
						{
								
								for (Element inputElement : inputList)
								{
									String inputValue = inputElement.getText().trim();
									
									if(inputValue.indexOf("flag=") != -1)
									{
										continue;// ignore input parameter containing flag, used for soapui.
									}
									
									if(inputValue.indexOf("TIMESTAMP") != -1)
									{
										inputValue = inputValue.replaceFirst("TIMESTAMP", month+dayOfMonth+hour24+min);
									}
									if(inputValue.indexOf("=DATE") != -1)
									{
										if(DatabaseSetup.webService.equals("REST"))
										inputValue = inputValue.replaceFirst("DATE", todaysDate);
									}
									if(inputValue.indexOf("Alpha(") != -1)
									{
										int range = new Integer(inputValue.substring(inputValue.indexOf("(")+1, inputValue.indexOf(")")));
										inputValue = inputValue.replaceFirst("Alpha(\\d*)", getAlphaNumericRandomNumber(range));
										inputValue = inputValue.substring(0, inputValue.indexOf("("));
									}
									if(inputValue.indexOf("Numeric(") != -1)
									{
										int range = new Integer(inputValue.substring(inputValue.indexOf("(")+1, inputValue.indexOf(")")));
										inputValue = inputValue.replaceFirst("Numeric(\\d*)", getNumericRandomNumber(range));
										inputValue = inputValue.substring(0, inputValue.indexOf("("));
									}
									if (inputParameters.length()==0 && inputValue.contains("filePath_")) //Updated By Debasish
									{
										inputParameters.append(inputValue);
									}
									else{
										if(inputParameters.length()>0)											
											inputParameters.append("&");
										inputParameters.append(inputValue);
									}
								}
//								inputToProcess = inputParameters.toString().substring(0, inputParameters.toString().lastIndexOf("&"));
						}
							Element ExpectedReturnCodeElement=XMLParser.getFirstChild(stepElement,"ExpectedReturnCode");
							
							Element ExpectedResponseElement=XMLParser.getFirstChild(stepElement, "ExpectedResponse");
							
							if(ExpectedReturnCodeElement != null)
							{
								expectedReturnCode = ExpectedReturnCodeElement.getValue().trim();
								System.out.println("ExpectedReturnCode ="+expectedReturnCode );
							}
							if(ExpectedResponseElement != null)
							{
								expectedResponse = ExpectedResponseElement.getValue().trim();
								System.out.println("ExpectedResponse= "+expectedResponse);
							}
							
							
							if (DatabaseSetup.webService.equals("REST"))
							{
							
							
							Element rootElementOfWebserviceList=XMLParser.getRootElementFromXMLFile(DatabaseSetup.webServicesList);
							
							
							Element serviceElementOfWebserviceList=XMLParser.getChildFromList(XMLParser.getChildren(rootElementOfWebserviceList),"name", serviceName);
							if(serviceElementOfWebserviceList == null)
							{
								System.out.println("STOPPING AUTOMATION .....");
								System.out.println("COULD NOT FIND SERVICE : " + serviceName + " : IN WebServiceList.xml FILE.");
								generator.createFooter();
								databaseSetup.stopServer();
								System.exit(0);
							}
							url=serviceElementOfWebserviceList.getAttributeValue("url");
							/*String inputs[]=inputParameters.toString().split("&");
							int count=1;
							
							while(url.contains("{"))
							{	
								int arr=1;
								StringBuffer temp=new StringBuffer();
								for(arr=1;arr<inputs.length;arr++)
									if(!(inputs[arr].split("="))[0].contains("param"))
									{	
										
										temp.append(inputs[arr]);
									}
								for(arr=1;arr<inputs.length;arr++)
									if((inputs[arr].split("="))[0].contains("param"+count))
										break;
									
								
								int start = url.indexOf("{");
								int end=url.indexOf("}",start);
								url=url.substring(0,start)+(inputs[arr].split("="))[1]+url.substring(++end);
								inputParameters=temp;
								count++;
								
							}*/
							protocol=serviceElementOfWebserviceList.getAttributeValue("protocol");
							method=serviceElementOfWebserviceList.getAttributeValue("method");
							
							
							}
						StringBuffer actualReturnCode = new StringBuffer("");
						StringBuffer actualResponseBuffer = new StringBuffer("");
						StringBuffer responseTime =new StringBuffer("");
						if(DatabaseSetup.webService.equals("REST"))
						try{
							engine.execute(url, inputParameters.toString(), method, serviceName, protocol,actualReturnCode,actualResponseBuffer,expectedReturnCode,tcId,Integer.toString(i),responseTime);//,tcId,tcDescription);
						}catch(Exception e)
						{
							System.out.println(e.getStackTrace());
						}
						
					else
						{  
						String dirname ="/com";
							File f1 =new File(dirname);
							/*if(!f1.exists())
							{
							RunBatchFile1 startd=new RunBatchFile1();
							startd.setstartupPath("wsdl.bat");
							startd.run();
							Thread.sleep(10*1000); 
							}*/
						engine.executeSoap(inputParameters.toString(),serviceName,actualReturnCode,actualResponseBuffer,expectedReturnCode,tcId,Integer.toString(i),responseTime);
						}
						String actualResponse = actualResponseBuffer.toString();
						try{
						if(actualResponse.indexOf("<table")!= -1)
						{
							if(actualResponse.startsWith("JSON :"))
							{
								actualResponse = actualResponse.substring(6);
							}
							// TODO else case for xml output.
							FileOutputStream fout = new FileOutputStream("./output/"+serviceName+"_"+ stepNumber+"_"+tcId +".html");
				 if(actualResponse.indexOf("entCert")!= -1)
							{
								actualResponse = JSONObject.fromObject(actualResponse).getString("entCert");
							}
							else if(actualResponse.indexOf("licCert")!= -1)
							{
								actualResponse = JSONObject.fromObject(actualResponse).getString("licCert");
							} 
							fout.write(actualResponse.getBytes());
							actualResponse = "HTML output in " +  serviceName+"_"+ stepNumber +".html";
							fout.flush();
							fout.close();
						}
						}catch(Exception e)
						{
							System.out.println(e.getStackTrace());
						}
						
						
						output = generator.generateStepOutput(tcId ,tcDescription, stepDescription , serviceName,inputParameters.toString(),expectedReturnCode,actualReturnCode.toString(),expectedResponse,responseTime,actualResponse);
						if(output.indexOf("FAIL") != -1)
						{
//							break; // move on to next Test Case if any step in the current Test Case fails.
						}
						expectedResponse = null;
						expectedReturnCode = null;
					}
					engine.clearResponseList();
					generator.generateTCOutput(tcId, serviceName);
				}
					databaseSetup.cleanup(null, 1);
				}
				
			generator.createFooter();
			
			System.out.println("COMPLETED INPUT SHEET EXECUTION.");
			databaseSetup.stopServer();
		}
		catch(Exception ex){
			System.out.println("Exception occured............");
			ex.printStackTrace();
		}
		
		}

	/**
	 * Generates a no. in range 1 to size
	 */
	private static Integer getRandomInt(int size) 
	{
		Random r = new Random();
		return new Integer( r.nextInt(size) +1);
	}

	/**
	 * Generates a alphaNumeric string of length size
	 * @param size
	 * @return
	 */
	private static String getAlphaNumericRandomNumber(int size) {
		StringBuilder alphaNumeric = new StringBuilder("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
		StringBuilder result = new StringBuilder("");
		for(int i = 0; i< size; i++ ) {
			result.append(alphaNumeric.charAt(getRandomInt(61))) ;
		}
		return result.toString();
	}

	/**
	 * Generates a numeric String of length size  
	 * @param size
	 * @return
	 */
	private static String getNumericRandomNumber(int size) {
		StringBuilder result = new StringBuilder("");
		for(int i = 0; i< size; i++ ) {
			result.append(getRandomInt(9)) ;
		}
		return result.toString();
	}
	public File [] getFiles(String dirName)
	{
		File inputFolder=new File(dirName);
		int noOfFiles=inputFolder.listFiles().length;
		
		File files[]=new File[noOfFiles];
		
		files=inputFolder.listFiles();
		
		return(files);
	}
	
	private static void copyfile(String srFile, String dtFile){
		  try{
		  File f1 = new File(srFile);
		  File f2 = new File(dtFile);
		  InputStream in = new FileInputStream(f1);
		  
		  //For Append the file.
		//  OutputStream out = new FileOutputStream(f2,true);

		  //For Overwrite the file.
		  OutputStream out = new FileOutputStream(f2);

		  byte[] buf = new byte[1024];
		  int len;
		  while ((len = in.read(buf)) > 0){
		  out.write(buf, 0, len);
		  }
		  in.close();
		  out.close();
		  System.out.println("File copied.");
		  }
		  catch(FileNotFoundException ex){
		  System.out.println(ex.getMessage() + " in the specified directory.");
		  System.exit(0);
		  }
		  catch(IOException e){
		  System.out.println(e.getMessage());  
		  }}
		 
	
	
	public static void main(String args[])throws Exception
	{
		
		  
	      // Process pr = Runtime.getRuntime().exec("cmd /C calling.vbs");
	       //pr.waitFor();

		    Parser parse=new Parser();
		    parse.getValuesFromInputFile();
	}
	
}
