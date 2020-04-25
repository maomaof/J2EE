/***********************************************************************
 * (C) Copyright 2011 SafeNet, Inc. All rights reserved. This software
 * contains proprietary information, which shall not be reproduced or
 * transferred to other documents and shall not be disclosed to others
 * or used for manufacturing or any other purpose without prior written
 * permission of SafeNet, Inc.
 **********************************************************************/
/*******************Revision History*************************************
 * Written By: Debasish Pradhan
 * Last Updated Date: 15-Feb-2011
 * Objective: Class to log testcase/step status to log
 ************************************************************************/
package selenium.utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import selenium.utilities.TestTime;
import selenium.utilities.ConfigurationReader;
public class StatusLogger 
{	private String screenpath;
	private FileOutputStream fileRef;
	private String buildReference;
	private String title;
	private TestTime datetime;
	private static long time;
	private static int hour,min,sec;
	private static ConfigurationReader conf=new ConfigurationReader("ConfigurationFiles/configuration.properties");
	private static int minWaitTime=(Integer.parseInt(conf.getPropertyValue("minWaitTime")))*1000;
	private static ArrayList failureList = new ArrayList();
	
	private String chktestid = null; //change made to check test cases are different or not
	public StatusLogger(String fileName,String BuildReference,String title )
	{	
		
		try 
		{
			File file1=new File(fileName);
			if(file1.exists())
			{
				file1.delete();
			}
			this.fileRef=new FileOutputStream(fileName,true);
			this.buildReference=BuildReference;
			this.title=title;
			
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 
	public void createSummaryStatusReportHeader() throws Throwable
	 {
		fileRef.write(("<!DOCTYPE html><html>").getBytes());
		 	fileRef.write(("<script type=text/javascript>function filter2 (phrase, _id){var words = phrase.value.toLowerCase().split(\" \");var table = document.getElementById(\"summary\");var ele;for (var r = 1; r < table.rows.length; r++){ele = table.rows[r].innerHTML.replace(/<[^>]+>/g,\"\"); var displayStyle = 'none'; for (var i = 0; i < words.length; i++) { if (ele.toLowerCase().indexOf(words[i])>=0)	displayStyle = ''; else {displayStyle = 'none'; break;   } }table.rows[r].style.display = displayStyle;}}</script>").getBytes());
		 	fileRef.write(("<form><input name=\"filter\" onkeyup=\"filter2(this, 'summary','1')\" type=\"text\"></form>").getBytes());
		 	fileRef.write(("Start Time : "+datetime.getCurrentTime()).getBytes());
		    time=datetime.gettimemillis();
			fileRef.write( "<TABLE WIDTH=100% BORDER=1 id=summary >".getBytes());
			fileRef.write( ("<TR style=" + "background-color:#7BF9BA" + "><TD COLSPAN=" + "4" + "><DIV ALIGN=" + "CENTER" + ">" + title + buildReference  +"</DIV></TD></TR>").getBytes());
			fileRef.write( ("<TR style=" + "background-color:#7BF9BA" + "><TD>Serial Number</TD><TD>Test Case ID</TD><TD>Test Case Description</TD><TD>Status</TD></TR>").getBytes());
			
	 }
	 public void createDetailedStatusReportHeader() throws Throwable
	 {	 fileRef.write(("Start Time : "+datetime.getCurrentTime()).getBytes());
		 fileRef.write( "<TABLE WIDTH=100% BORDER=1 >".getBytes());
		 fileRef.write(( "<TR style=" + "background-color:#7BF9BA" + "><TD COLSPAN=" + "8" + "><DIV ALIGN=" + "CENTER" + ">" + title + buildReference  +"</DIV></TD></TR>").getBytes());
		 fileRef.write(( "<TR style=" + "background-color:#7BF9BA" + "><TD>Test Case Id</TD><TD>Test Case Description</TD><TD>Step</TD><TD>Step Description</TD><TD>Input</TD><TD>Status</TD><TD>Failure Reason</TD><TD>Screen Shot</TD></TR>").getBytes());
	 }
	 public void createDetailedStatusReportFooter() throws Throwable
	 {	time = datetime.gettimemillis()-time;
	 	time=time/1000;
	 	
	 	hour=(int)time/(60*60);
	 	min= (int)(time-hour*60*60)/60;
	 	sec=(int)(time-(hour*60*60+min*60));
		 fileRef.write(("</TABLE>").getBytes());
		 fileRef.write(("End Time : "+datetime.getCurrentTime()).getBytes());
		 fileRef.write(("<br>"+"Total Execution Time(HH:MM:SS) : "+hour+":"+min+":"+sec).getBytes());
	 }
	 public void createSummaryStatusReportFooter(int totalTest,int failTest, int warningTest,String browserNameVersion) throws Throwable
	 {   long passPerc=(long)(((totalTest-failTest)*100)/totalTest);
		 fileRef.write(("</TABLE>").getBytes());
		 fileRef.write(("End Time : "+datetime.getCurrentTime()).getBytes());
		 //fileRef.write(("<div id=\"div1\">").getBytes());
		  //fileRef.write(("<br>Total Test Cases : "+totalTest+"<br><font color = green>Pass Test Cases : "+(totalTest-failTest)+"</font>").getBytes());
		 //fileRef.write(("<br><font color = red>Fail Test Cases : "+failTest+"</font><br><font color = green>Pass Percentage : "+passPerc+"</font>").getBytes());
		 //fileRef.write(("<br><font color = gold>Pass with warning Test Cases : "+warningTest).getBytes());
		 //fileRef.write(("<table id=\"GUITestCount\" width=\"900px\" style=\"border:solid 1px #ccc; font-family:Century Gothic,Verdana;\" >").getBytes());
		 //fileRef.write(("<tbody><tr><td style=\"text-align: center; width:200px; background-color:#FFFFFF; border-right:solid 1px #ccc; color:#333333;\">").getBytes());
		 fileRef.write(("<table id=\"GUITestCount\"border=\"1\"><tbody><tr><th colspan=\"3\" style=\"background-color:#F2ECCB\">"+browserNameVersion+"</th></tr>").getBytes());
		 fileRef.write(("<tr><th style=\"background-color:#F2ECCB\">Total Test Cases Executed : " + totalTest + "</th>").getBytes());
		 fileRef.write(("<th style=\"background-color:#D4F2D0\">Total test cases Passed</th><th style=\"background-color:#F2D2D0\">Total test cases Failed</th>").getBytes());
		 //fileRef.write(("</td><td style=\"text-align: center; width:200px; background-color:#D4F2D0; border-right:solid 1px #ccc; color:#184A11;\">").getBytes());
		 fileRef.write(("<tr><td style=\"background-color:#F2ECCB\">"+totalTest+"</td>").getBytes());
		 fileRef.write(("<td style=\"background-color:#D4F2D0\">"+(totalTest-failTest)+"</td>").getBytes());
		 fileRef.write(("<td style=\"background-color:#F2D2D0\">"+failTest+"</td>").getBytes());
		 //fileRef.write(("<div style=\"padding:10px;\">Total Cases Passed<br/><h3 style=\"margin:0;\">" +(totalTest-failTest) + "</h3>(" + passPerc+ "%)</div>").getBytes());
		 //fileRef.write(("</td><td style=\"text-align: center; width:200px; background-color:#F2D2D0; color:#910909\">").getBytes());
		 //fileRef.write(("<div style=\"padding:10px;\">Total Cases Failed<br/><h3 style=\"margin:0;\">" + failTest + "</h3>(" + (100-passPerc) + "%)</div>").getBytes());
		 fileRef.write(("</tr></tbody>").getBytes());
		 fileRef.write(("</table>").getBytes());
		 fileRef.write(("<br><font color = gold>Pass with warning Test Cases : "+warningTest).getBytes());
		 fileRef.write(("<br>"+"Total Execution Time(HH:MM:SS) : "+hour+":"+min+":"+sec).getBytes());
		 if(!failureList.isEmpty())
		 {
			 
		 fileRef.write( "<br><TABLE WIDTH=100% BORDER=1 >".getBytes());
		 fileRef.write(( "<TR style=" + "background-color:#D3D3D3" + "><TD><DIV ALIGN=" + "CENTER" + ">Failure Reasons</DIV></TD></TR>").getBytes());
		 Set fail = new HashSet(failureList);
		 failureList.clear();
		 failureList.addAll(fail);
		 int size = failureList.size();
		 if(size>100)
			 size=100;
		 for(int i =0;i<size;i++)
		 {
			 fileRef.write(( "<TR style=" + "background-color:#D3D3D3" + "><TD>"+failureList.get(i)+"</TD></TR>").getBytes());
		 }
		 fileRef.write(("</TABLE>").getBytes());
		if(failureList.size()>100)
		{
			 fileRef.write(("<br>"+"Please Refer to Detailed Log for more Failure Reasons").getBytes());
		}
			
		 }
		 fileRef.write(("</html>").getBytes());
	 }
			
	 public void writeInputFileName(String inputFileName,String NumberOfCols) throws Throwable
	 {
		 fileRef.write(( "<TR style=" + "background-color:#ADA96E" + "><TD COLSPAN=" + NumberOfCols + "><DIV ALIGN=" + "CENTER" + ">" + inputFileName + "</div></TD></TR>").getBytes());
	 }
	 public void writeToSummaryStatusReport(String SerialNo,String TestCaseId,String TestCaseDescription,int Status) throws Throwable 
	 {
		 String backgroundColor=null,statusStr=null;
		 if(Status<0)
		 {
			 if(Status==-2)
			 {	backgroundColor="#fcd116";
			 	statusStr="Warning*********";
			 }
			 else
			 {
			 backgroundColor="#ffcc99";
			 statusStr="Fail*********";
			 }
		 }
		 	
		 else
		 {
			 backgroundColor="#7BF9BA";
			 statusStr="Pass";
		 }
			 
			 fileRef.write(( "<TR style=" + "background-color:"+ backgroundColor + "><TD>" + SerialNo  + "</TD><TD>" + TestCaseId  + "</TD><TD>" + TestCaseDescription + "</TD><TD>"+ statusStr +"</TD></TR>").getBytes());
		 
		 
	 }
	
	 
	 public void writeToDetailedStatusReport(String TestCaseId,String TestCaseDescription,String Step,String StepDescription,String Input,int Status,String FailureReason, String file) throws Throwable
	 {
		 String backgroundColor=null,statusStr=null;
		 screenpath="";
		 if(Status<0)
		 {	 if(FailureReason!=null&&FailureReason!="")
		 	{
			 if(FailureReason.contains("not found"))
			 	failureList.add(FailureReason);
		 	}
			 if(Status==-2)
			 {	backgroundColor="#fcd116";
			 	statusStr="Warning*********";
			 
			 	screenpath = "<a href =Images/"+file+"><img src=Images/" + file + " height =40 width = 40></img></a>";
			 }
		 	else
		 	{	backgroundColor="#ffcc99";
		 	statusStr="Fail*********";
		 
		 	screenpath = "<a href =Images/"+file+"><img src=Images/" + file + " height =40 width = 40></img></a>";
		 	}
		 	
		 }
		 	
		 else
		 {
			 if(Input.contains("wait"))
			 {
				 if(FailureReason.contains("Loading Time"))
				 {	String time = FailureReason.replace("Loading Time : ","");
				 	time = time.replace(" ms","");
				 	int totalTime=Integer.parseInt(time);
				 	if(totalTime>minWaitTime)
				 		backgroundColor="#FFEBCD";
				 	else
				 		 backgroundColor="#7BF9BA"; 
				 }
				 else
					 backgroundColor="#7BF9BA"; 
			 }
			 else
			 {
				 backgroundColor="#7BF9BA";
			 }
			 
			 statusStr="Pass";
		 }
		 // changes made
		 if(TestCaseId!=chktestid)
		 {
			 fileRef.write(( "<TR style=" + "background-color:"+ backgroundColor + "><TD>" + TestCaseId  + "</TD><TD>" + TestCaseDescription +"</TD><TD>" + Step  + "</TD><TD>"+ StepDescription + "</TD><TD>"+ Input +"</TD><TD>" + statusStr + "</TD><TD>" + FailureReason + "</TD><TD>"+ screenpath +"</TD></TR>").getBytes());
			 chktestid=TestCaseId;
		 }
		 else
			 fileRef.write(( "<TR style=" + "background-color:"+ backgroundColor + "><TD></TD><TD></TD><TD>" + Step  + "</TD><TD>"+ StepDescription + "</TD><TD>"+ Input +"</TD><TD>" + statusStr + "</TD><TD>" + FailureReason + "</TD><TD>"+ screenpath +"</TD></TR>").getBytes());
			 
	 }
 }
 


