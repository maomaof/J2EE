package ws.utilities;
import ws.driver.*;
import ws.library.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/*
 * Class to generate html output for given teststep and testCase information.
 * Updated Date: 19-Aug-2011
 * Updated By: Debasish
 * Updated Section:generateStepOutput
 * Objective: Issue: step o/p is fail, even if actualreturncode,expectedreturncode,expectedresponse and actualresponse are correct.
 */
public class ReportGenerator {
	
	private String fileName;
	
	private String detailedReportLocation ;
	private String summaryReportLocation ;
	
	private List<String> statusList;
	private String testCaseId = "";
	private String testCaseDescription = "";
	
	private static final String col0 = "TestCase Id";
	private String col1 = "TestDescription";   
	private String col2 = "Step Description";
	private String col3 = "Service Name" ;
	private String col3_4 = "Input" ;
	private String stepDescription = "Step Description" ;
	
	private static final String col4 = "Exp. Ret Code";
	private static final String col5 = "Act. Ret Code";
	private static final String col6 = "Exp. Response";
	private static final String col7 = "Act. Response";
	private static final String col8 = "Status";
	private static final String col9 = "Response time(ms)";
		
	private int headerCalled = -1;
	private int footerCalled = -1;
	
	// class level fields to keep count
	static int passwscnt = 0;  // testStep
	static int failwscnt = 0;  // testStep
	static int failtccnt = 0; // testcase 
	static int passtccnt = 0; // testcase 
	
	static int serialNo = 0;
	
	Calendar cal = new GregorianCalendar(); 
	
	String month = String.valueOf(cal.get(Calendar.MONTH));
	String dayOfMonth = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
	String hour24 = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
	String min = String.valueOf(cal.get(Calendar.MINUTE)); 
	
	String timestamp = ":" +month + ":" + dayOfMonth +":" +hour24 +":" +min; 
	
	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}
	
	/**
	 * create reportHeader with given Column names
	 */
	public void setColumnNames(String col1, String col2, String col3, String col4)
	{
		if(col1 != null && !col1.equals(""))
		{
			this.col1 = col1;
		}
		else
		{
			this.col1 = null;
		}
		if(col2 != null && !col2.equals(""))
		{
			this.col2 = col2;
		}
		else
		{
			this.col2 = null;
		}
		if(col3 != null && !col3.equals(""))
		{
			this.col3 = col3;
		}
		else
		{
			this.col3 = null;
		}
		if(col4 != null && !col4.equals(""))
		{
			this.col3_4 = col4;
		}
		else
		{
			this.col3_4 = null;
		}

	}
	
	
	/**
	 * Constructor
	 */
	public ReportGenerator()
	{
		if(detailedReportLocation == null || detailedReportLocation.equals(""))
		{
			detailedReportLocation = "./output/";
		}
		if(summaryReportLocation == null || summaryReportLocation.equals(""))
		{
			summaryReportLocation = "./output/SummaryReport.html";
		}
		
		statusList = new ArrayList();
		
	}
	
	
	/**
	 * Constructor
	 */
	public void setOutputLocation(String detailedReportLocation, String summaryReportLocation)
	{
		if(detailedReportLocation != null && !detailedReportLocation.equals(""))
		{
			this.detailedReportLocation = detailedReportLocation;
		}
		if(summaryReportLocation != null && !summaryReportLocation.equals(""))
		{
			this.summaryReportLocation = summaryReportLocation;
		}
	}
	
	/*
	 * Creates Header info. like date, build no.etc
	 */
	public void createDetailedReportHeader(String build)
	{		
		
		if(build == null || build.equals(""))
		{
			build = "Test Build";
		}
					
		try{
		File file1 = new File(detailedReportLocation + fileName);
		if(file1.exists())
		{
			file1.delete();
		}
						
		OutputStream ws=new FileOutputStream(detailedReportLocation + fileName, true); 
		failwscnt=0;
		passwscnt=0;
		
		String dtstart,dtend;
		dtstart=getDateTime();
		
		ws.write("Start Time = ".getBytes());
		ws.write(dtstart.getBytes());
		ws.write("<table width=1340px border=1 >".getBytes());	
		ws.write(("<tr width=1340px"+" style"+"="+"background-color:#FFFF66><td width=1340px colspan"
		 +"="+"100"+"<div align"+"="+"center"+">"
		 +"Detailed Report , Build Identification : "
		 +build+"</div>"+"</td>"+"</tr>").getBytes());
		
		String col1Header = "";
		String col2Header = "";
		String col3Header = "";
		String col3_4Header = "";
		if(col1 != null)
		{
			col1Header = col1+"</td>"+"<td width=200px>";
		}
		if(col2 != null)
		{
			col2Header = col2+"</td>"+"<td width=200px>";
		}
		if(col3 != null)
		{
			col3Header = col3+"</td>"+"<td width=62px>";
		}
		if(col3_4 != null)
		{
			col3_4Header = col3_4+"</td>"+"<td width=62px>";
		}
		
		ws.write(("<tr width=1400px"+" style"+"="+"background-color:#FFFF66><td width=100px>"
         + col0 + "</td>"+"<td width=50px>"
		 +col1Header
//		 +stepDescription +"</td>"+"<td width=100px>"
		 +col2Header
		 +col3Header
		 +col3_4Header
		 +col4+"</td>"+"<td width=260px>"
		 +col5+"</td>"+"<td width=260px>"
		 +col6+"</td>"+"<td width=260px>"
		 +col7+"</td>"+"<td width=74px>"
		 +col9+"</td>"+"<td width=74px>"
		 +col8+"</td>"+"</tr>").getBytes());
		
		System.out.println("Reporting started at : " + dtstart + " for build : " + build);
		
		ws.close();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public void createSummaryReportHeader(String build)
	{
	
		if(build == null || build.equals(""))
		{
			build = "Test Build";
		}
		try{
			File file1 = new File(summaryReportLocation);
		
			if(file1.exists())
			file1.delete();	
		OutputStream tc=new FileOutputStream(summaryReportLocation, true);  
		failtccnt=0;
		passtccnt=0;
		String dtstart,dtend;
		dtstart=getDateTime();
		tc.write("<html><head><title>Summary Report</title></head><body>".getBytes());
		
		tc.write("<span>Start Time=".getBytes());
		tc.write(dtstart.getBytes());
		
		System.out.println("Reporting started at : " + dtstart + " for build : " + build);
		
		tc.write((" " + build + "</span>").getBytes());
		tc.write("<table width=\"600px\" border=\"1px\">".getBytes());	
		tc.write(("<tr style=\"background-color:#FFFF66;\"><td colspan=\"3\">Summary Report , Build Identification : " + build + "</td></tr>").getBytes());
		
		tc.write(("<tr style=\"background-color:#FFFF66;\"><td width=\"200px\">Sr. No.</td><td width=\"200px\">" + col0 + "</td><td width=\"200px\">" + col8 + "</td></tr>").getBytes());
		
		tc.close();
		
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public String generateStepOutput(String testCaseId, String col1, 
			String col2, String col3, String col4 ,String expectedRC, 
			String actualRC, String expectedResponse,StringBuffer responseTime, String actualResponse)
	{
		
		
		if(col1 == null)
		{
			col1 = "";
		}
		if(col2 == null)
		{
			col2 = "";
		}
		if(col3 == null)
		{
			col3 = "";
		}
//		if(col4 == null)
//		{
//			col4 = "";
//		}
		if(expectedResponse == null)
		{
			expectedResponse = "";
		}
		
//		if(stepDescription == null)
//		{
//			stepDescription = "";
//		}
		String output= "";
//		if(headerCalled == -1)
//		{
//			createHeader("");
//			headerCalled = 0;
//		}
		try{
			String printtestCaseId = "" ;
		if(testCaseId != null)
		{
			if(!this.testCaseId.equals(testCaseId))
			{
				this.testCaseId = testCaseId;
				printtestCaseId = testCaseId;
			}
			else
			{
				printtestCaseId = "";
			}
		}
		else
		{
			printtestCaseId = "";
		}
		
		String printtestCaseDescription = "" ;
		if(testCaseDescription != null)
		{
			if(!this.testCaseDescription.equals(col1))
			{
				this.testCaseDescription = col1;
				printtestCaseDescription = col1;
			}
			else
			{
				printtestCaseDescription = "";
			}
		}
		else
		{
			printtestCaseDescription = "";
		}
		
		
		OutputStream fout = new FileOutputStream(detailedReportLocation + fileName, true);	
		String colourcode="";
		boolean passed = false;
		String originalExpectedResponse = expectedResponse;
		if(actualRC.equals(expectedRC)) /*IF PASS and response is in json format...*/ 
		{
			if(actualResponse.startsWith("JSON :"))
			{
				actualResponse = actualResponse.substring(6);
				if((expectedResponse == null || expectedResponse.equals("")) || (actualResponse.equals(expectedResponse)))
				{
					colourcode="#7BF9BA";	
					passwscnt=passwscnt+1;
					statusList.add("PASS");
					output= "PASS";
					passed = true;
				}
				else if(expectedResponse.equals("CHECK_MANUALLY"))
				{
					colourcode="#FFFF99";
					passwscnt=passwscnt+1;
					statusList.add("PASS");
					output= "PASS";
					passed = true;
				}
				else if(expectedResponse.indexOf("PARTIAL") != -1)
				{
					expectedResponse = expectedResponse.substring(expectedResponse.indexOf("_")+1, expectedResponse.length());
					if(actualResponse.indexOf(expectedResponse) != -1)
					{
						colourcode="#FFFF99";
						passwscnt=passwscnt+1;
						statusList.add("PASS");
						output= "PASS";
						passed = true;
					}
				}
				
				if(!passed && expectedResponse!= null && !expectedResponse.equals("CHECK_MANUALLY") && !actualResponse.equals(expectedResponse))
				{	if(expectedResponse.contains(".xml")&&actualResponse.contains(".xml"))
					{	ExecutionEngine e;
						String actualResp=readFile(actualResponse);
						String expectedResp=readFile("expectedxml/"+expectedResponse);
						if(!actualResp.equals(expectedResp))
						{
							colourcode="#FF6699";				
							failwscnt=failwscnt+1;
							statusList.add("FAIL");
							output= "FAIL";
						}
					}
				else
				{
					colourcode="#FF6699";				
					failwscnt=failwscnt+1;
					statusList.add("FAIL");
					output= "FAIL";
				}
				}
			}
			else // response is in xml format //|| (actualResponse.equals(expectedResponse))
			{
				
				if((expectedResponse == null || expectedResponse.equals("")) )
				{
					colourcode="#7BF9BA";	
					passwscnt=passwscnt+1;
					statusList.add("PASS");
					output= "PASS";
					passed = true;
				}
				else if(expectedResponse.equals("CHECK_MANUALLY"))
				{
					colourcode="#FFFF99";
					passwscnt=passwscnt+1;
					statusList.add("PASS");
					output= "PASS";
					passed = true;
				}
				else if(expectedResponse.indexOf("PARTIAL") != -1)
				{
					expectedResponse = expectedResponse.substring(expectedResponse.indexOf("_")+1, expectedResponse.length());
					expectedResponse = expectedResponse.replaceAll("\"", "");
					expectedResponse = expectedResponse.replace("{", "");
					expectedResponse = expectedResponse.replaceAll("}", "");
					
					String varName = expectedResponse.substring(0, expectedResponse.indexOf(":"));
					String varValue = expectedResponse.substring(expectedResponse.indexOf(":")+1, expectedResponse.length());
					expectedResponse = "<" +varName + ">" +  varValue ;
					
					if(actualResponse.indexOf(expectedResponse) != -1)
					{
						colourcode="#FFFF99";
						passwscnt=passwscnt+1;
						statusList.add("PASS");
						output= "PASS";
						passed = true;
					}
				}
				else 
				{
					
					
					// TODO create xml string from json and comapare expected output and actual output xmls.
//					String xmlFromJson = XMLParser.fromJsonToXMLStr(expectedResponse, "EMSResponse",false);
					if(expectedResponse.contains(".xml")&&actualResponse.contains(".xml"))
					{	ExecutionEngine e;
						String actualResp=readFile(actualResponse);
						String expectedResp=readFile("expectedxml/"+expectedResponse);
					
					if(!XMLParser.testIdentical(expectedResp, actualResp))
					{
						colourcode="#FF6699";				
						failwscnt=failwscnt+1;
						statusList.add("FAIL");
						output= "FAIL";
						passed = false;
					}
					else
					{
						colourcode="#7BF9BA";	
						passwscnt=passwscnt+1;
						statusList.add("PASS");
						output= "PASS";
						
						passed = true;
					}
					}
				}
				/***--------------------------***/
				//updated by Debasish on 19-Aug-2011
				if(expectedResponse!= null )
				{
					
					if (expectedResponse.contains(actualResponse))
					{
					colourcode="#7BF9BA";	
					passwscnt=passwscnt+1;
					statusList.add("PASS");				
					output= "PASS";				
					passed = true;
				}}
				
				
				/***--------------------------***/
				if(!passed && expectedResponse!= null && !expectedResponse.equals("CHECK_MANUALLY"))
				{
					colourcode="#FF6699";				
					failwscnt=failwscnt+1;
					statusList.add("FAIL");
					output= "FAIL";
				}
				
			}
			
		}
		else 
		/*if Fail...*/
		{
			
		/*	if(DatabaseSetup.webService.equals("SOAP"))
			{
			if(actualRC.contains(expectedRC))
			{
				colourcode="#FFFF99";
				passwscnt=passwscnt+1;
				statusList.add("PASS");
				output= "PASS";
				passed = true;	
			}}
			else
			{*/
			colourcode="#FF6699";				
			failwscnt=failwscnt+1;
			statusList.add("FAIL");
			output= "FAIL";
		//}
			}
			
		if(actualResponse.startsWith("JSON :"))
		{
			actualResponse = actualResponse.substring(actualResponse.indexOf("JSON :")+1, actualResponse.length());
		}
		else
		{
			actualResponse = convertXmlInHtml(actualResponse);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<tr width=1400px");
		sb.append(" style=background-color:"+colourcode+">");
		sb.append("<td><div style=\"width:100px;overflow:auto;\">");
		sb.append(printtestCaseId);
		sb.append("</div></td>");
		if(this.col1 != null)
		{
			sb.append("<td><div style=\"width:200px;overflow:auto;\">");
			sb.append(printtestCaseDescription);
			sb.append("</div></td>");
		}
//		if(stepDescription != null)
//		{
//			sb.append("<td width=100px>");
//			sb.append(stepDescription);
//			sb.append("</td>");
//		}
		if(this.col2 != null)
		{
			sb.append("<td><div style=\"width:200px;overflow:auto;\">");
			sb.append(col2);
			sb.append("</td>");
		}
		if(this.col3 != null)
		{
			sb.append("<td ><div style=\"width:422px;overflow:auto;\">");
			sb.append(col3);
			sb.append("</div></td>");
		}
		if(this.col3_4 != null)
		{
			sb.append("<td ><div style=\"width:422px;overflow:auto;\">");
			sb.append(col4);
			sb.append("</div></td>");
		}
		
		sb.append("<td width=62px>");
		sb.append(expectedRC);
		sb.append("</td><td width=62px>");
		sb.append(actualRC);
		sb.append("</td><td><div style=\"width:260px;overflow:auto;\">");
		if(originalExpectedResponse.contains(".xml"))
			sb.append("<a href=../expectedxml/"+originalExpectedResponse+">"+originalExpectedResponse+"</a>");
		else
			sb.append(convertXmlInHtml(originalExpectedResponse));
		sb.append("</div></td><td><div style=\"width:260px;overflow:auto;\">");
		
		if(actualResponse.contains(".xml"))
			sb.append("<a href=../"+actualResponse+">"+actualResponse+"</a>");
		
		else
			sb.append(actualResponse);
		sb.append("</div></td><td width=74px>");
		
		sb.append(responseTime);
		sb.append("</div></td><td width=74px>");
		sb.append(output);
		sb.append("</td></tr>");
		
		
		fout.write(sb.toString().getBytes());

		System.out.println("Status in Report : " +output);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return output;
	}
	
	public void generateTCOutput(String testCaseId, String testCaseName)
	{
		try{
			serialNo = serialNo +1;
		String output = "";
		if(statusList.contains("FAIL"))
		{
			output = "FAIL";
		}
		OutputStream fout = new FileOutputStream(summaryReportLocation, true);
		OutputStream foutWS = new FileOutputStream(detailedReportLocation+fileName, true);
		if(output.indexOf("FAIL") != -1)
		{
			output = "FAIL ****";
			fout.write(("<tr style=\"background-color:#FF6699;\">").getBytes());
			failtccnt=failtccnt+1;
		}
		
		else
		{
			output = "PASS";
			fout.write(("<tr style=\"background-color:#7BF9BA;\">").getBytes());
			passtccnt=passtccnt+1;
			
		}
		System.out.println(testCaseName + " : " + output);
		fout.write(("<td><div style=\"width=200px;overflow:auto;\">").getBytes());
		fout.write(String.valueOf(serialNo).getBytes());
		fout.write(("</div></td>").getBytes());
		
		fout.write(("<td><div style=\"width=200px;overflow:auto;\">").getBytes());
		fout.write(testCaseId.getBytes());
		fout.write(("</div></td>").getBytes());
		
		fout.write(("<td><div style=\"width=200px;overflow:auto;\">").getBytes());
		fout.write(output.getBytes());
		fout.write(("</div></td></tr>").getBytes());
		
//		fout.write((testCaseName + " : " + output).getBytes());
		//fout.write("\n".getBytes());
		/*
		foutWS.write(("<tr"+" style=background-color:#E0E0F8>").getBytes());
		foutWS.write(("<td width=200px colspan=10><div style=\"width=200px;height:1px;\">").getBytes());
//		foutWS.write(output.getBytes());
		foutWS.write(("</div></td>").getBytes());
		*/
		foutWS.flush();
		statusList.clear();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * adds seperator in detailed output to indicate new test sheet.
	 */
	public void addSeperatorInSummaryReport()throws Exception
	{
		OutputStream foutTC = new FileOutputStream(summaryReportLocation, true); // +timestamp
		foutTC.write(("<tr style=\"background-color:#E238EC;\">").getBytes());
		foutTC.write(("<td width=\"200px\" colspan=\"10\">").getBytes());
		foutTC.write(("<a href=\"" + fileName + "\">" + fileName + "</a>").getBytes());
//		foutTC.write(fileName.getBytes());
		foutTC.write(("</td></tr>").getBytes());
		foutTC.flush();
	}
	
	/* prints summary info. like total case passed/ failed in number and percentage.
	 *  
	 */
	public void createFooter()
	{
		try{
		int totalwscases,totaltc,passwsper,failwsper,passtcper,failtcper;
//		OutputStream ws1=new FileOutputStream(detailedReportLocation, true); 
		OutputStream tc1=new FileOutputStream(summaryReportLocation, true);  
//		
		String dtend=getDateTime();
//		ws1.write("End Time=".getBytes());
		tc1.write("</table><span>End Time = ".getBytes());
//		ws1.write(dtend.getBytes());
		tc1.write(dtend.getBytes());
		tc1.write("</span>".getBytes());
		//For WebService Output
		totalwscases=passwscnt+failwscnt;
		
		if(totalwscases > 0)
		{	passwsper=(passwscnt*100/totalwscases);
			failwsper=100-passwsper;
		}
		else
		{
			passwsper = 0;
			failwsper = 0;
		}
			
		//For TestCase Output
		totaltc=passtccnt+failtccnt;
		if(totaltc > 0)
		{
			passtcper=(passtccnt*100/totaltc);
			failtcper=100-passtcper;
		}
		else
		{
			passtcper=0;
			failtcper=0;
		}
		
//		tc1.write("<table width=70% border=1 >".getBytes());
//		tc1.write("<tr><td>".getBytes());
//		tc1.write(("Total Test Cases Executed="+totaltc).getBytes());
//		tc1.write("</td></tr>".getBytes());
//		tc1.write("<tr><td>".getBytes());
//		tc1.write(("Total Cases Passed="+passtccnt+"("+passtcper+"%"+")").getBytes());
//		tc1.write("</td></tr>".getBytes());
//		tc1.write("<tr><td>".getBytes());
//		tc1.write(("Total Cases Failed="+failtccnt+"("+failtcper+"%"+")").getBytes());
//		tc1.write("</td></tr>".getBytes());
//		tc1.write("</TABLE>".getBytes());
		
		StringBuilder sb = new StringBuilder();
		//sb.append("<table id=\"WSTestCount\" width=\"600px\" style=\"border:solid 1px #ccc; font-family:Century Gothic,Verdana;\" cellspacing=\"0\" cellpading=\"0\">");
		sb.append("<table id=\"WSTestCount\" border=\"1\"><th style=\"background-color:#F2ECCB\";scope=\"col\" colspan=\"3\">WebService Version "+ExecutionEngine.webServiceVersion+"</th>");
		sb.append("<tr><th style=\"background-color:#F2ECCB\">Total test cases Executed</th><th style=\"background-color:#D4F2D0\">Total test cases Passed</th><th style=\"background-color:#F2D2D0\">Total test cases Failed</th></tr>");
		sb.append("<tr> <td style=\"background-color:#F2ECCB\">"+totaltc+"</td>");
		sb.append("<td style=\"background-color:#D4F2D0\">"+passtccnt+"</td>");
		sb.append("<td style=\"background-color:#F2D2D0\">"+failtccnt+"</td>");
		//sb.append("<tr><td style=\"text-align: center; width:200px; background-color:#F2ECCB; border-right:solid 1px #ccc; color:#333333;\">");
		//sb.append("<div style=\"padding:10px;\">Total Test Cases Executed<br/><h3 style=\"margin:0;\">" + totaltc + "</h3></div>");
		//sb.append("</td><td style=\"text-align: center; width:200px; background-color:#D4F2D0; border-right:solid 1px #ccc; color:#184A11;\">");
		//sb.append("<div style=\"padding:10px;\">Total Cases Passed<br/><h3 style=\"margin:0;\">" + passtccnt + "</h3>(" + passtcper + "%)</div>");
		//sb.append("</td><td style=\"text-align: center; width:200px; background-color:#F2D2D0; color:#910909\">");
		//sb.append("<div style=\"padding:10px;\">Total Cases Failed<br/><h3 style=\"margin:0;\">" + failtccnt + "</h3>(" + failtcper + "%)</div>");
		sb.append("</tr>");
		sb.append("</table></body></html>");
		
		tc1.write(sb.toString().getBytes());
		
		MailSender mailSender = new MailSender();
		mailSender.sendMail(sb.toString());
		
		System.out.println("Total Test Cases Executed="+totaltc);
		System.out.println("Total Cases Passed="+passtccnt+"("+passtcper+"%"+")");
		System.out.println("Total Cases Failed="+failtccnt+"("+failtcper+"%"+")");
		
		System.out.println("Reporting Over at : " +  getDateTime());
		
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	private static String getDateTime() 
	{
        DateFormat dateFormat = new SimpleDateFormat("EEEE,dd-MMMM-yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

	private String convertXmlInHtml(String actualResponse)
	{
		actualResponse = actualResponse.replaceAll("<", "&lt;");
		actualResponse = actualResponse.replaceAll(">", "&gt;");
		
		return actualResponse;
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
