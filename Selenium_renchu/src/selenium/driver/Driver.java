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
 * Objective: Driver class To drive Test Automation
 * 
 * 
 * Written By: Abhinav Garg
 * Last Updated Date:5-may-2011
 * Objective: Modification in getdatatableParameter function for allowing datatable elements in middle of a xpath
 * 
 * Last Updated Date:12-May-2011 Abhinav Garg
 * Initializing Data Table Object in the start
 * 
 * Last Updated Date:20-July-2011 Abhinav Garg
 * no need to give shared location in images property in configuraqtion file
wait for visible now supports text, it waits untill a text is visible(Need to pass text in Action Parameter)
Resolved a bug due to which browser name is always coming as xx
In firefox5 after login, page does not redirect to home page to resolve this add open home page command in test case after login
Changed Image Format to jpg

Supports IE 9 and Firefox 5 Abhinav Garg

29 aug 2011 Abhinav Garg
1. added a action visible having value 0 and 1
	if 0 verification of an element is visible before performing actions is turned off
	if 1 verification is on
	default value is 1

2. added a action waitForPageToLoadOnFailExit 
	exit current test case if wait for page to load fails

3. Removed JUNIT dependency

4. selenium framework now executes all xml input files
	changing inputFiles value to 'all' in Configuration file will execute all xml files in acsending order(String)

5. Support for Firefox 6

1-sep-2011  Abhinav Garg
Db Cleanup

19 Sep-2011 Abhinav Garg
1. Changes in Loop
2. Implemented Sub loop
3. Implemented Repeate
4. Case Insensitive
 ************************************************************************/
package selenium.driver;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import renchuTool.RenchuTool;
import selenium.utilities.ConfigurationReader;
import selenium.utilities.ParseXMLFile;

import selenium.library.SeleniumCommandExecutor;
import selenium.library.WebDriverCommandExecutor;
import selenium.library.WebDriverCommands;
import selenium.utilities.StatusLogger;
import selenium.utilities.DataTable;
import selenium.utilities.Mail;
import selenium.utilities.TestTime;
import selenium.utilities.Zip;
import selenium.utilities.jacoco;

public class Driver extends RenchuTool {
	public static int count = 1; // used to create loop
	public static int rowcount = 1;// used to store rows of data table
	public static DataTable dt; // datatable object
	public static String data[];// to store data table sheet values
	public static int chkstatus = 1;// used to run loop equals to no. of total
									// rows in the sheet
	public static int loopstatus = 1; // used to run loop equals to parameter
										// given with loop action and from a
										// specified row
	public static int loopcountstatus = 1;// used to access data table element
											// if there is no loop
	public static Mail newmail; // mail object
	public static Zip newzip; // zip object
	public static int totalTest; // total no. of test Cases
	public static int failTest; // total no. of fail tests
	public static int warningTest; // total no. of Warning Test
	public static String logFiles[] = new String[3]; // Stores location+name of
														// log files
	public static String ipAdd; // stores the IP address of RC
	public static String browser; // stores the browser used by RC
	public static String imageFiles = ""; // Stores Image File names

	public static String inputFilesLocation = null;
	public static String[] inputFiles = null;
	public static ParseXMLFile XMLFile = null;
	public static String[] testCaseIdsStr = null;
	public static String testCaseDescStr = null;
	public static int testCaseStatus;
	public static String[] testCaseSteps = null;
	public static String testCaseStepDescStr = null;
	public static String testCaseStepActionStr = null;
	public static String testCaseStepUiLocatorStr = null;
	public static String testCaseStepActionParameterStr = null;
	public static StatusLogger summaryLog = null, detailedLog = null;
	public static String inputStr = null;
	public static int status = 1;

	public static int loopcount = 1; // used to implement loops
	// public static int teststepcount=0; //used to implement loops
	// public static int testcasecount=0; //used to implement loops
	// public static int lengthsteps=0; //used to implement loops
	public static int testcasestepsize = 0; // used to implement loops
	public static String environ = null; // Selenium environment
	public static String inputFilesNames; // Input Files Names
	public static int argsLength; // command line arguments array length
	public static int webDriverMode = 0; // =1就是 selenium2
	static String jacocosuite;
	public static String browserNameVersion = " ";

	public static void main(String[] args) {
		try {
			// newmail.sendMail(100, 1, new String[] { "a", "mail", " test" },
			// 0);
			renchu(new String[] {});
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	public static void renchu(String[] args) throws Throwable

	{
		dt = new DataTable();
		totalTest = 0;
		failTest = 0;
		/*
		 * get configuration settings from
		 * ConfigurationFiles/configuration.properites
		 */
		ConfigurationReader configuration = new ConfigurationReader("ConfigurationFiles/configuration.properties");

		/**** Configuration ReadinEg ******/

		/*
		 * #run java code coverage for webservices #0 not to run #1 run
		 * jacoco=1(default)
		 */
		jacocosuite = configuration.getPropertyValue("jacoco");
		pop("jacocosuite=" + jacocosuite);

		argsLength = args.length; // obtaings args length
		pop("argsLength=" + argsLength);

		int argLoop = 0; // for creating loop upto args length

		// inputFilesNames=2feature.xml,3product.xml,4entitlement.xml,5product2.xml,6customer.xml,7channelPartner.xml,8user.xml,9sreports.xml,10customReport.xml,11cloudProduct.xml,12cloudEntitlement.xml,13concurrentLm.xml,14PrepaidLm.xml,15Namedentitlement.xml,16keyidsearch(3557).xml,17hideFeature(4478).xml,18search(3574).xml,19Userstories(71release).xml,20searchCustomer_5656.xml,21NetLicense_4891.xml,22on-premise.xml,23cloneprotection.xml
		// 拿到配置文件中的字符串列表，里面有要加载文件的名称
		inputFilesNames = configuration.getPropertyValue("inputFiles"); // reading
		pop("inputFilesNames=" + inputFilesNames); // input
		// file
		// name

		/* get inputFilesLocation */

		// inputFilesLocation=InputFiles
		// 读取加载文件在那个目录下
		inputFilesLocation = configuration.getPropertyValue("inputFilesLocation");
		pop("inputFilesLocation=" + inputFilesLocation);

		if (configuration.getPropertyValue("selenium").equalsIgnoreCase(("webDriver"))) {
			webDriverMode = 1;
		}

		if (!inputFilesNames.equals("all")) {

			while (argLoop < argsLength) // reading arguments
			{
				if (args[argLoop].equals("-environment")) // if environment
					environ = args[++argLoop];
				if (args[argLoop].equals("-loop")) // if loop
				{
					int inputFilesCount = Integer.parseInt(args[++argLoop]);
					inputFilesCount--;
					while (inputFilesCount > 0) {
						inputFilesNames = inputFilesNames + "," + configuration.getPropertyValue("inputFiles");
						inputFilesCount--;
					}
				}
				argLoop++;

			}
			/* get input Files To Be Processed */

			// 将字符串变成字符串数组
			inputFiles = inputFilesNames.split(",");
			pop("inputFiles=" + inputFiles);
		} else {

			inputFiles = getFiles(inputFilesLocation);
			pop("inputFiles=" + inputFiles);
		}
		/********** End: Configuration Reading ***********************/

		// Start Selenium
		pop("environ=" + environ);
		pop("webDriverMode=" + webDriverMode);
		if (webDriverMode == 0)
			ipAdd = SeleniumCommandExecutor.startSelenium(environ);
		else
			ipAdd = WebDriverCommandExecutor.startSelenium(environ);

		// summaryLog/detailed Log details
		/**** Create Log Header **********/

		pop("**** Create Log Header **********");
		logFiles[0] = configuration.getPropertyValue("detailedLogFileName");
		pop("logFiles[0]=" + logFiles[0]);

		logFiles[1] = configuration.getPropertyValue("summaryLogFileName");
		pop("logFiles[1]=" + logFiles[1]);

		pop("webDriverMode=" + webDriverMode);
		// webDriverMode=1
		if (webDriverMode == 0)
			browser = SeleniumCommandExecutor.getBrowser();
		else {

			browser = WebDriverCommandExecutor.getBrowser();
			// browser=ff
			browserNameVersion = WebDriverCommandExecutor.getBrowserVersion();
			// browserNameVersion=firefox 7.0.1
		}
		long secondCounter = TestTime.getSeconds();
		logFiles[0] = logFiles[0] + "_" + ipAdd + "_" + browser + "_" + secondCounter + ".html";
		logFiles[1] = logFiles[1] + "_" + ipAdd + "_" + browser + "_" + secondCounter + ".html";

		String summaryLogParam2 = configuration.getPropertyValue("buildReference");
		String summaryLogParam3 = configuration.getPropertyValue("summaryLogTitle");

		pop("summaryLogParam1=" + logFiles[1]);
		pop("summaryLogParam2=" + summaryLogParam2);
		pop("summaryLogParam3=" + summaryLogParam3);

		// StatusLogger(String fileName,String BuildReference,String title )
		// fileName=Logs/summaryLog_localhost_FF_2.html
		// BuildReference=(Selenium Automation Prototype)
		// title=Summary Report
		summaryLog = new StatusLogger((logFiles[1]), summaryLogParam2, summaryLogParam3);

		detailedLog = new StatusLogger((logFiles[0]), configuration.getPropertyValue("buildReference"),
				configuration.getPropertyValue("detailedLogTitle"));

		summaryLog.createSummaryStatusReportHeader();
		detailedLog.createDetailedStatusReportHeader();
		/******* End:Create Log Header **************/
		/* Read XML Input File in sequence */

		pop("inputFiles.length=" + inputFiles.length);
		for (String temp : inputFiles) {
			pop(temp);
		}
		pop("开始1循环");
		for (int currentFileCount = 0; currentFileCount < inputFiles.length; currentFileCount++) {
			/******* restarting browser after every sheet ************/
			WebDriverCommandExecutor.closeSelenium();
			ipAdd = WebDriverCommandExecutor.startSelenium(environ);

			/******* jacoco implementation ************/

			// jacocosuite=1
			pop("jacocosuite=" + jacocosuite);
			if (jacocosuite.equals("1")) {
				pop("这块没看懂，为什么要new jacoco()");
				// jacoco suite = new jacoco();
			}
			/******* Write Input File To Log ************/
			summaryLog.writeInputFileName(inputFiles[currentFileCount], "4");
			detailedLog.writeInputFileName(inputFiles[currentFileCount], "8");
			/******* End: Write Input File To Log ************/

			/** Create an instance of object of class ParseXMLFile **/
			// ParseXMLFile的构造函数遍历了每一个文件（2-23），然后将所有名为ID的子节点存起来
			XMLFile = new ParseXMLFile(inputFilesLocation + "/" + inputFiles[currentFileCount]);
			pop("currentFileCount=" + currentFileCount);
			/****** get TestCaseIds in an array ********/

			// 取出所有ＩＤ的节点
			testCaseIdsStr = XMLFile.getTestCaseIds();
			// 第一次为例子：输出的是2feature.xml含有ＩＤ的节点
			// testCaseIdsStr[0]=TC_Login_2
			// testCaseIdsStr[1]=TC_Feature_1
			// testCaseIdsStr[2]=TC_Feature_2
			// testCaseIdsStr[3]=TC_Feature_3
			// testCaseIdsStr[4]=TC_Feature_4
			// testCaseIdsStr[5]=TC_Feature_5
			// testCaseIdsStr[6]=TC_Feature_6

			// 第一个sheet里面嵌套的循环，这次是2feature.xml含有ＩＤ的节点的个数为次数
			pop("开始2循环");
			for (int testCaseCount = 0; testCaseCount < testCaseIdsStr.length; testCaseCount++) {
				totalTest++;
				testCaseStatus = 1;
				/* get test case id **/
				pop("testCaseIdsStr[" + testCaseCount + "]=" + testCaseIdsStr[testCaseCount]);

				/* get test case description **/
				testCaseDescStr = XMLFile.getTestCaseDescription(testCaseIdsStr[testCaseCount]);
				pop("testCaseDescStr=" + testCaseDescStr);

				/**** get Test Steps in an array ********/
				testCaseSteps = XMLFile.getTestCaseSteps(testCaseIdsStr[testCaseCount]);

				/**** Parse Each Step ******/
				testcasestepsize = testCaseSteps.length;
				pop("testCaseSteps.length=" + testcasestepsize);

				// get size of testcasesteps arrays

				// 第一层循环：2feature.xml
				// 第二层循环： 输出的是2feature.xml含有ＩＤ的节点
				// 第三层循环： 遍历ID节点下面的子节点<Step no="XXXX">
				pop("开始3循环");
				for (int testCaseStepCount = 0; testCaseStepCount < testcasestepsize; testCaseStepCount++) {

					/** get test step no **/
					// 打印节点
					pop("testCaseSteps[" + testCaseStepCount + "]=" + testCaseSteps[testCaseStepCount]);

					/** get test step description **/
					testCaseStepDescStr = XMLFile.getTestStepDescription(testCaseIdsStr[testCaseCount],
							testCaseSteps[testCaseStepCount]);
					pop("testCaseStepDescStr=" + testCaseStepDescStr);

					/*** get test step Action ***/

					testCaseStepActionStr = XMLFile.getTestStepAction(testCaseIdsStr[testCaseCount],
							testCaseSteps[testCaseStepCount]);

					// testCaseStepActionStr=maximize第一次
					pop("testCaseStepActionStr=" + testCaseStepActionStr);

					/*** get test step UiLocator ***/
					testCaseStepUiLocatorStr = XMLFile.getTestStepUILocator(testCaseIdsStr[testCaseCount],
							testCaseSteps[testCaseStepCount]);
					pop("testCaseStepUiLocatorStr=" + testCaseStepUiLocatorStr);

					/*** get test step ActionParameter ***/
					testCaseStepActionParameterStr = XMLFile.getTestStepActionParameter(testCaseIdsStr[testCaseCount],
							testCaseSteps[testCaseStepCount]);
					pop("testCaseStepActionParameterStr" + testCaseStepActionParameterStr);

					if (testCaseStepActionStr.equalsIgnoreCase("Loop")) // checking
																		// if
																		// action
																		// is
																		// loop
																		// or
																		// not
					{

						testCaseStepCount = loop(testCaseStepCount, testCaseCount);

						if (testCaseStepCount == -2)
							break;
						else
							continue;
					}
					if (testCaseStepActionStr.equalsIgnoreCase("repeat")) {
						int testcase = testCaseCount;
						int start = 0;
						int end = 0;
						if (!testCaseStepUiLocatorStr.equals("")) {
							testcase = Integer.parseInt(testCaseStepUiLocatorStr);
							testcase--;
						}
						if (!testCaseStepActionParameterStr.equals("")) {
							String rep[] = testCaseStepActionParameterStr.split(",");
							start = Integer.parseInt(rep[0]);
							end = Integer.parseInt(rep[1]);
							start--;
						}
						status = 1;
						inputStr = "Repeat " + "<BR>" + "Test Case=" + testcase + "<BR>" + "From " + start + "<BR>"
								+ "To" + end;
						detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
								testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status, "", "");
						pop("**开始repeat**");
						repeat(testcase, start, end);
						pop("**结束repeat**");
						continue;

					}
					if (testCaseStepActionStr.equalsIgnoreCase("if")) {
						status = 1;
						inputStr = "Continue if next step " + "<BR>" + testCaseStepActionParameterStr;
						detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
								testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status, "", "");
						status = executeNextStep(testCaseStepCount, testCaseCount);

						if (status < 0 && testCaseStepActionParameterStr.equalsIgnoreCase("fail")) {
							testCaseStepCount++;
							continue;
						}
						if (status > 0 && testCaseStepActionParameterStr.equalsIgnoreCase("pass")) {
							testCaseStepCount++;
							continue;
						}

						testCaseStepCount = callIf(testCaseStepCount, testCaseCount);
						continue;

					}
					if (testCaseStepActionStr.equalsIgnoreCase("endIf")) {
						status = 1;
						inputStr = "EndIf";
						detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
								testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status, "", "");
						continue;
					}
					if (!testCaseStepActionStr.equalsIgnoreCase("Loop")
							&& !testCaseStepActionStr.equalsIgnoreCase("EndLoop")
							&& !testCaseStepActionStr.equalsIgnoreCase("repeat")) {
						while (testCaseStepActionParameterStr.contains("sheet=")) // af
																					// action
																					// parameter
																					// contains
																					// value
																					// form
																					// data
																					// table
						{
							testCaseStepActionParameterStr = getdatatableparameter(testCaseStepActionParameterStr); // getting
																													// parameter
																													// from
																													// datatable

						}
						if (testCaseStepUiLocatorStr.contains("sheet=")) // af
																			// UI
																			// parameter
																			// contains
																			// value
																			// form
																			// data
																			// table
						{
							testCaseStepUiLocatorStr = getdatatableparameter(testCaseStepUiLocatorStr); // getting
																										// parameter
																										// from
																										// datatable

						}
						if (testCaseStepActionStr.contains("sheet=")) // af
																		// action
																		// contains
																		// value
																		// form
																		// data
																		// table
						{
							testCaseStepActionStr = getdatatableparameter(testCaseStepActionStr); // getting
																									// parameter
																									// from
																									// datatable

						}
						if (webDriverMode == 0) {
							status = SeleniumCommandExecutor.executeSeleniumCommandUsingReflection(
									(Integer.toString(totalTest)), testCaseSteps[testCaseStepCount],
									testCaseStepActionStr, testCaseStepUiLocatorStr, testCaseStepActionParameterStr);
						} else {

							// Function to execute selenium commands
							// usingreflection

							/*
							 * String Testcase, String Step, String Action,
							 * String UiLocator, String ActionParameter
							 * param1_Testcase=1 param2_Step=3
							 * param3_Action=maximize param4_UiLocator=
							 * param5_ActionParameter=
							 * 
							 * 
							 */
							// pop("param1_Testcase=" +
							// (Integer.toString(totalTest)));
							// pop("param2_Step=" +
							// testCaseSteps[testCaseStepCount]);
							// pop("param3_Action=" + testCaseStepActionStr);
							// pop("param4_UiLocator=" +
							// testCaseStepUiLocatorStr);
							// pop("param5_ActionParameter=" +
							// testCaseStepActionParameterStr);

							pop("此处开始ExecuteTestCase");
							status = WebDriverCommandExecutor.executeSeleniumCommandUsingReflection(
									(Integer.toString(totalTest)), testCaseSteps[testCaseStepCount],
									testCaseStepActionStr, testCaseStepUiLocatorStr, testCaseStepActionParameterStr);
						}
						// status=SeleniumCommandExecutor.executeSeleniumCommand(testCaseIdsStr[testCaseCount],testCaseSteps[testCaseStepCount],SeleniumCommand.valueOf(testCaseStepActionStr),
						// testCaseStepUiLocatorStr,
						// testCaseStepActionParameterStr);
						pop("Status=" + status);
						if (status < 0) {
							if (status == -1)
								testCaseStatus = -1;
							else if (testCaseStatus != -1 && status == -2)
								testCaseStatus = -2;
						}
						/**** Log the failure to StatusLogger ***/

						inputStr = "Action=" + testCaseStepActionStr + "<BR>" + "UiLocator=" + testCaseStepUiLocatorStr
								+ "<BR>" + "Action Parameter=" + testCaseStepActionParameterStr;
					}

					if (webDriverMode == 0)
						detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
								testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status,
								SeleniumCommandExecutor.getFailureReason(), SeleniumCommandExecutor.getScreenPath());
					else
						detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
								testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status,
								WebDriverCommandExecutor.getFailureReason(), WebDriverCommandExecutor.getScreenPath());
					if (status < 0) {
						if (webDriverMode == 0)
							imageFiles = imageFiles + (SeleniumCommandExecutor.getScreenPath()) + ",";
						else
							imageFiles = imageFiles + (WebDriverCommandExecutor.getScreenPath()) + ",";
					}
					try {
						if (status == -1)
							break;
					} catch (Exception e) {
						pop(e.getStackTrace());
					}
				} /* End of test step execution loop */
				if (testCaseStatus < 0) {
					if (testCaseStatus == -2)
						warningTest++;
					else
						failTest++;
				}
				summaryLog.writeToSummaryStatusReport((Integer.toString(totalTest)), testCaseIdsStr[testCaseCount],
						testCaseDescStr, testCaseStatus);

			} /* End of test case reading loop */

		} /* End of input file reading loop */

		//

		// create detailed log footer
		detailedLog.createDetailedStatusReportFooter();
		summaryLog.createSummaryStatusReportFooter(totalTest, failTest, warningTest, browserNameVersion);
		/******* jacoco implementation ************/
		if (jacocosuite.equals("1")) {
			// jacoco suite = new jacoco();
		}
		// Close selenium
		if (webDriverMode == 0)
			SeleniumCommandExecutor.closeSelenium();
		else
			WebDriverCommandExecutor.closeSelenium();
		// 压缩，发送
		if (configuration.getPropertyValue("mailsend").equalsIgnoreCase("yes")) {
			logFiles[2] = newzip.createZip(imageFiles, ipAdd, browser, secondCounter); // creating
																						// zip
			if (newmail.sendMail(totalTest, failTest, logFiles, warningTest) == false)// sending
																						// mail
			{
				pop("Mail Failure");
			}
		}
		pop("全部测完");

	}/* End of main body */

	// step:<Step no="3">
	// testCaseCount: <TCID id="TC_Login_2">
	// 用来解析inputFiles里面一个文件，loop文件里的每一大项
	public static int loop(int step, int testCaseCount) throws Throwable {

		int startRow = 0;
		int testcasesize = testcasestepsize;

		// 取得TestStepDescription
		testCaseStepDescStr = XMLFile.getTestStepDescription(testCaseIdsStr[testCaseCount], testCaseSteps[step]);

		/*** get test step Action ***/
		testCaseStepActionStr = XMLFile.getTestStepAction(testCaseIdsStr[testCaseCount], testCaseSteps[step]);

		/*** get test step UiLocator ***/
		// testCaseStepUiLocatorStr=XMLFile.getTestStepUILocator(testCaseIdsStr[testCaseCount],
		// testCaseSteps[step]);

		/*** get test step ActionParameter ***/
		testCaseStepActionParameterStr = XMLFile.getTestStepActionParameter(testCaseIdsStr[testCaseCount],
				testCaseSteps[step]);
		int stepCount = 1;

		int rowCount = 0;
		int start = 1;

		// 解析参数个数，参数用；隔开，滋瓷1-3
		if (!testCaseStepActionParameterStr.equals("")) {
			String loopParam[] = testCaseStepActionParameterStr.split(";");
			if (loopParam.length == 1) {
				if (loopParam[0].startsWith("end=")) {
					rowCount = getRowCount(loopParam[0]);
				}
			} else if (loopParam.length == 2) {
				if (loopParam[0].startsWith("start=")) {
					loopParam[0] = loopParam[0].replace("start=", "");
					start = Integer.parseInt(loopParam[0]);
					rowCount = getRowCount(loopParam[1]);

				} else if (loopParam[0].startsWith("end=")) {
					rowCount = getRowCount(loopParam[0]);
					loopParam[1] = loopParam[1].replace("incCount=", "");
					stepCount = Integer.parseInt(loopParam[1]);
				}
			} else if (loopParam.length == 3) {
				loopParam[0] = loopParam[0].replace("start=", "");
				start = Integer.parseInt(loopParam[0]);
				rowCount = getRowCount(loopParam[1]);
				loopParam[2] = loopParam[2].replace("incCount=", "");
				stepCount = Integer.parseInt(loopParam[2]);
			}

		}

		// 开始第一次循环，
		pop("开始loop循环");
		for (int count = start; count <= rowCount; count = count + stepCount) {
			pop("count=" + count);
			pop("rowCount=" + rowCount);
			pop("count=count + stepCount=" + count);
			pop("开始loop子循环");
			for (int testCaseStepCount = step; testCaseStepCount <= testcasesize; testCaseStepCount++) {
				pop("testCaseStepCount=" + testCaseStepCount);
				pop("testCaseStepCount=" + testCaseStepCount);
				pop("testCaseStepCount=" + testCaseStepCount);

				/** get test step no **/
				pop(testCaseSteps[testCaseStepCount]);

				/** get test step description **/
				testCaseStepDescStr = XMLFile.getTestStepDescription(testCaseIdsStr[testCaseCount],
						testCaseSteps[testCaseStepCount]);
				pop(testCaseStepDescStr);

				/*** get test step Action ***/
				testCaseStepActionStr = XMLFile.getTestStepAction(testCaseIdsStr[testCaseCount],
						testCaseSteps[testCaseStepCount]);
				pop(testCaseStepActionStr);

				/*** get test step UiLocator ***/
				testCaseStepUiLocatorStr = XMLFile.getTestStepUILocator(testCaseIdsStr[testCaseCount],
						testCaseSteps[testCaseStepCount]);
				pop(testCaseStepUiLocatorStr);

				/*** get test step ActionParameter ***/
				testCaseStepActionParameterStr = XMLFile.getTestStepActionParameter(testCaseIdsStr[testCaseCount],
						testCaseSteps[testCaseStepCount]);
				pop(testCaseStepActionParameterStr);

				if (testCaseStepActionStr.equalsIgnoreCase("if")) {
					status = 1;
					inputStr = "Continue if next step " + "<BR>" + testCaseStepActionParameterStr;
					detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
							testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status, "", "");
					status = executeNextStep(testCaseStepCount, testCaseCount, count, loopcount);

					if (status < 0 && testCaseStepActionParameterStr.equalsIgnoreCase("fail")) {
						testCaseStepCount++;
						continue;
					}
					if (status > 0 && testCaseStepActionParameterStr.equalsIgnoreCase("pass")) {
						testCaseStepCount++;
						continue;
					}

					testCaseStepCount = callIf(testCaseStepCount, testCaseCount);
					continue;

				}
				if (testCaseStepActionStr.equalsIgnoreCase("endIf")) {
					status = 1;
					inputStr = "EndIf";
					detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
							testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status, "", "");
					continue;
				}
				if (testCaseStepActionStr.equalsIgnoreCase("subLoop")) {

					testCaseStepCount = subloop(testCaseStepCount, testCaseCount, count);
					if (testCaseStepCount == -2)
						break;
					else
						continue;
				}
				if (testCaseStepActionStr.equalsIgnoreCase("repeat")) {
					int testcase = testCaseCount;
					int start1 = 0;
					int end1 = 0;
					if (!testCaseStepUiLocatorStr.equals("")) {
						testcase = Integer.parseInt(testCaseStepUiLocatorStr);
						testcase--;
					}
					if (!testCaseStepActionParameterStr.equals("")) {
						String rep[] = testCaseStepActionParameterStr.split(",");
						start1 = Integer.parseInt(rep[0]);
						end1 = Integer.parseInt(rep[1]);
						start1--;
					}
					status = 1;
					inputStr = "Repeat " + "<BR>" + "Test Case=" + testcase + "<BR>" + "From " + start1 + "<BR>" + "To"
							+ end1;
					detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
							testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status, "", "");
					repeat(testcase, start1, end1);
					continue;

				}
				if (!testCaseStepActionStr.equalsIgnoreCase("Loop")
						&& !testCaseStepActionStr.equalsIgnoreCase("EndLoop")) {
					while (testCaseStepActionParameterStr.contains("sheet=")) // af
																				// action
																				// parameter
																				// contains
																				// value
																				// form
																				// data
																				// table
					{
						testCaseStepActionParameterStr = getdatatableparameter(testCaseStepActionParameterStr, count,
								stepCount, startRow); // getting parameter from
														// datatable

					}
					if (testCaseStepUiLocatorStr.contains("sheet=")) // af UI
																		// parameter
																		// contains
																		// value
																		// form
																		// data
																		// table
					{
						testCaseStepUiLocatorStr = getdatatableparameter(testCaseStepUiLocatorStr, count, stepCount,
								startRow); // getting parameter from datatable

					}
					if (testCaseStepActionStr.contains("sheet=")) // af action
																	// contains
																	// value
																	// form data
																	// table
					{
						testCaseStepActionStr = getdatatableparameter(testCaseStepActionStr, count, stepCount,
								startRow); // getting parameter from datatable

					}

					if (webDriverMode == 0)
						status = SeleniumCommandExecutor.executeSeleniumCommandUsingReflection(
								(Integer.toString(totalTest)), testCaseSteps[testCaseStepCount], testCaseStepActionStr,
								testCaseStepUiLocatorStr, testCaseStepActionParameterStr);
					else
						status = WebDriverCommandExecutor.executeSeleniumCommandUsingReflection(
								(Integer.toString(totalTest)), testCaseSteps[testCaseStepCount], testCaseStepActionStr,
								testCaseStepUiLocatorStr, testCaseStepActionParameterStr);

					// status=SeleniumCommandExecutor.executeSeleniumCommand(testCaseIdsStr[testCaseCount],testCaseSteps[testCaseStepCount],SeleniumCommand.valueOf(testCaseStepActionStr),
					// testCaseStepUiLocatorStr,
					// testCaseStepActionParameterStr);
					pop("Status=" + status);
					if (status < 0) {
						if (status == -1)
							testCaseStatus = -1;
						else if (testCaseStatus != -1 && status == -2)
							testCaseStatus = -2;
					}
					inputStr = "Action=" + testCaseStepActionStr + "<BR>" + "UiLocator=" + testCaseStepUiLocatorStr
							+ "<BR>" + "Action Parameter=" + testCaseStepActionParameterStr;
				}

				if (testCaseStepActionStr.equalsIgnoreCase("Loop")) // if Action
																	// is end
																	// loop
				{

					inputStr = "Loop " + count + "<BR>" + " Total Loop Count = " + rowCount + "<BR>" + " Step = "
							+ stepCount;
					status = 1;

				}
				if (testCaseStepActionStr.equalsIgnoreCase("EndLoop")) {
					inputStr = "End Loop " + count;
					status = 1;
					testcasesize = testCaseStepCount;
				}
				if (webDriverMode == 0)
					detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
							testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status,
							SeleniumCommandExecutor.getFailureReason(), SeleniumCommandExecutor.getScreenPath());
				else
					detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
							testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status,
							WebDriverCommandExecutor.getFailureReason(), WebDriverCommandExecutor.getScreenPath());
				if (status < 0) {
					if (webDriverMode == 0)
						imageFiles = imageFiles + (SeleniumCommandExecutor.getScreenPath()) + ",";
					else
						imageFiles = imageFiles + (WebDriverCommandExecutor.getScreenPath()) + ",";
				}
				try {
					if (status == -1)
						return -2;
				} catch (Exception e) {
					pop(e.getStackTrace());
				}

			}
			startRow++;
		}
		return testcasesize;
	}

	// e.g 3 product
	// <Step no="16">
	// <Description>SubLoop</Description>
	// <Action>subLoop</Action>
	// .....
	// <Step no="21">
	// <Description>EndSubLoop</Description>
	// <Action>endSubLoop</Action>

	public static int subloop(int step, int testCaseCount, int loopCount) throws Throwable {

		int startRow = 0;
		int testcasesize = testcasestepsize;
		testCaseStepDescStr = XMLFile.getTestStepDescription(testCaseIdsStr[testCaseCount], testCaseSteps[step]);

		/*** get test step Action ***/
		testCaseStepActionStr = XMLFile.getTestStepAction(testCaseIdsStr[testCaseCount], testCaseSteps[step]);

		/*** get test step UiLocator ***/
		// testCaseStepUiLocatorStr=XMLFile.getTestStepUILocator(testCaseIdsStr[testCaseCount],
		// testCaseSteps[step]);

		/*** get test step ActionParameter ***/
		testCaseStepActionParameterStr = XMLFile.getTestStepActionParameter(testCaseIdsStr[testCaseCount],
				testCaseSteps[step]);
		int stepCount = 1;

		int rowCount = 0;
		int start = 1;
		if (testCaseStepActionParameterStr.contains("loopCount")) {
			testCaseStepActionParameterStr = testCaseStepActionParameterStr.replaceAll("loopCount",
					Integer.toString(count));
		}
		if (!testCaseStepActionParameterStr.equals("")) {
			String loopParam[] = testCaseStepActionParameterStr.split(";");
			if (loopParam.length == 1) {
				if (loopParam[0].startsWith("end=")) {
					rowCount = getRowCount(loopParam[0]);
				}
			} else if (loopParam.length == 2) {
				if (loopParam[0].startsWith("start=")) {
					loopParam[0] = loopParam[0].replace("start=", "");
					start = Integer.parseInt(loopParam[0]);
					rowCount = getRowCount(loopParam[1]);

				} else if (loopParam[0].startsWith("end=")) {
					rowCount = getRowCount(loopParam[0]);
					loopParam[1] = loopParam[1].replace("incCount=", "");
					stepCount = Integer.parseInt(loopParam[1]);
				}
			} else if (loopParam.length == 3) {
				loopParam[0] = loopParam[0].replace("start=", "");
				start = Integer.parseInt(loopParam[0]);
				rowCount = getRowCount(loopParam[1]);
				loopParam[2] = loopParam[2].replace("incCount=", "");
				stepCount = Integer.parseInt(loopParam[2]);
			}
		}

		for (int count = start; count <= rowCount; count = count + stepCount) {
			for (int testCaseStepCount = step; testCaseStepCount <= testcasesize; testCaseStepCount++) {

				/** get test step no **/
				pop(testCaseSteps[testCaseStepCount]);

				/** get test step description **/
				testCaseStepDescStr = XMLFile.getTestStepDescription(testCaseIdsStr[testCaseCount],
						testCaseSteps[testCaseStepCount]);
				pop(testCaseStepDescStr);

				/*** get test step Action ***/
				testCaseStepActionStr = XMLFile.getTestStepAction(testCaseIdsStr[testCaseCount],
						testCaseSteps[testCaseStepCount]);
				pop(testCaseStepActionStr);

				/*** get test step UiLocator ***/
				testCaseStepUiLocatorStr = XMLFile.getTestStepUILocator(testCaseIdsStr[testCaseCount],
						testCaseSteps[testCaseStepCount]);
				pop(testCaseStepUiLocatorStr);

				/*** get test step ActionParameter ***/
				testCaseStepActionParameterStr = XMLFile.getTestStepActionParameter(testCaseIdsStr[testCaseCount],
						testCaseSteps[testCaseStepCount]);
				pop(testCaseStepActionParameterStr);
				if (testCaseStepActionStr.equalsIgnoreCase("if")) {
					status = 1;
					inputStr = "Continue if next step " + "<BR>" + testCaseStepActionParameterStr;
					detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
							testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status, "", "");
					status = executeNextStep(testCaseStepCount, testCaseCount, count, loopCount);

					if (status < 0 && testCaseStepActionParameterStr.equalsIgnoreCase("fail")) {
						testCaseStepCount++;
						continue;
					}
					if (status > 0 && testCaseStepActionParameterStr.equalsIgnoreCase("pass")) {
						testCaseStepCount++;
						continue;
					}

					testCaseStepCount = callIf(testCaseStepCount, testCaseCount);
					continue;

				}
				if (testCaseStepActionStr.equalsIgnoreCase("endIf")) {
					status = 1;
					inputStr = "EndIf";
					detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
							testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status, "", "");
					continue;
				}
				if (testCaseStepActionStr.equalsIgnoreCase("repeat")) {
					int testcase = testCaseCount;
					int start1 = 0;
					int end1 = 0;
					if (!testCaseStepUiLocatorStr.equals("")) {
						testcase = Integer.parseInt(testCaseStepUiLocatorStr);
						testcase--;
					}
					if (!testCaseStepActionParameterStr.equals("")) {
						String rep[] = testCaseStepActionParameterStr.split(",");
						start1 = Integer.parseInt(rep[0]);
						end1 = Integer.parseInt(rep[1]);
						start1--;
					}
					status = 1;
					inputStr = "Repeat " + "<BR>" + "Test Case=" + testcase + "<BR>" + "From " + start1 + "<BR>" + "To"
							+ end1;
					detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
							testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status, "", "");
					repeat(testcase, start1, end1);
					continue;

				}
				if (!testCaseStepActionStr.equalsIgnoreCase("subLoop")
						&& !testCaseStepActionStr.equalsIgnoreCase("EndSubLoop")) {
					while (testCaseStepActionParameterStr.contains("sheet=")) // af
																				// action
																				// parameter
																				// contains
																				// value
																				// form
																				// data
																				// table
					{
						if (testCaseStepActionParameterStr.contains("loopCount")) {
							testCaseStepActionParameterStr = testCaseStepActionParameterStr.replaceAll("loopCount",
									Integer.toString(loopCount));
						}
						testCaseStepActionParameterStr = getdatatableparameter(testCaseStepActionParameterStr, count,
								stepCount, startRow); // getting parameter from
														// datatable

					}
					if (testCaseStepUiLocatorStr.contains("sheet=")) // af UI
																		// parameter
																		// contains
																		// value
																		// form
																		// data
																		// table
					{
						if (testCaseStepUiLocatorStr.contains("loopCount")) {
							testCaseStepUiLocatorStr = testCaseStepUiLocatorStr.replaceAll("loopCount",
									Integer.toString(loopCount));
						}
						testCaseStepUiLocatorStr = getdatatableparameter(testCaseStepUiLocatorStr, count, stepCount,
								startRow); // getting parameter from datatable

					}
					if (testCaseStepActionStr.contains("sheet=")) // af action
																	// contains
																	// value
																	// form data
																	// table
					{
						if (testCaseStepActionStr.contains("loopCount")) {
							testCaseStepActionStr = testCaseStepActionStr.replaceAll("loopCount",
									Integer.toString(loopCount));
						}
						testCaseStepActionStr = getdatatableparameter(testCaseStepActionStr, count, stepCount,
								startRow); // getting parameter from datatable

					}
					if (webDriverMode == 0)
						status = SeleniumCommandExecutor.executeSeleniumCommandUsingReflection(
								(Integer.toString(totalTest)), testCaseSteps[testCaseStepCount], testCaseStepActionStr,
								testCaseStepUiLocatorStr, testCaseStepActionParameterStr);
					else
						status = WebDriverCommandExecutor.executeSeleniumCommandUsingReflection(
								(Integer.toString(totalTest)), testCaseSteps[testCaseStepCount], testCaseStepActionStr,
								testCaseStepUiLocatorStr, testCaseStepActionParameterStr);

					// status=SeleniumCommandExecutor.executeSeleniumCommand(testCaseIdsStr[testCaseCount],testCaseSteps[testCaseStepCount],SeleniumCommand.valueOf(testCaseStepActionStr),
					// testCaseStepUiLocatorStr,
					// testCaseStepActionParameterStr);
					pop("Status=" + status);
					if (status < 0) {
						if (status == -1)
							testCaseStatus = -1;
						else if (testCaseStatus != -1 && status == -2)
							testCaseStatus = -2;
					}
					inputStr = "Action=" + testCaseStepActionStr + "<BR>" + "UiLocator=" + testCaseStepUiLocatorStr
							+ "<BR>" + "Action Parameter=" + testCaseStepActionParameterStr;
				}

				if (testCaseStepActionStr.equalsIgnoreCase("subLoop")) // if
																		// Action
																		// is
																		// end
																		// loop
				{

					inputStr = "Sub Loop " + count + "<BR>" + " Total Loop Count = " + rowCount + "<BR>" + " Step = "
							+ stepCount;
					status = 1;

				}
				if (testCaseStepActionStr.equalsIgnoreCase("EndsubLoop")) {
					inputStr = "End Sub Loop " + count;
					status = 1;
					testcasesize = testCaseStepCount;
				}
				if (webDriverMode == 0)
					detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
							testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status,
							SeleniumCommandExecutor.getFailureReason(), SeleniumCommandExecutor.getScreenPath());
				else
					detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
							testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status,
							WebDriverCommandExecutor.getFailureReason(), WebDriverCommandExecutor.getScreenPath());
				if (status < 0) {
					if (webDriverMode == 0)
						imageFiles = imageFiles + (SeleniumCommandExecutor.getScreenPath()) + ",";
					else
						imageFiles = imageFiles + (WebDriverCommandExecutor.getScreenPath()) + ",";
				}
				try {
					if (status == -1)
						return -2;
				} catch (Exception e) {
					pop(e.getStackTrace());
				}

			}
			startRow++;
		}
		return testcasesize;
	}

	public static int callIf(int testCaseStep, int testCaseCount) throws Throwable {
		for (int testCaseStepCount = testCaseStep; testCaseStepCount < testcasestepsize; testCaseStepCount++) {

			/*** get test step Action ***/
			testCaseStepActionStr = XMLFile.getTestStepAction(testCaseIdsStr[testCaseCount],
					testCaseSteps[testCaseStepCount]);
			pop(testCaseStepActionStr);
			if (testCaseStepActionStr.equalsIgnoreCase("endIf")) {
				testCaseStepCount--;

				return testCaseStepCount;
			}
		}

		return testCaseStep;
	}

	public static int executeNextStep(int testCaseStep, int testCaseCount) throws Throwable {
		testCaseStep++;
		pop(testCaseSteps[testCaseStep]);

		/** get test step description **/
		String testCaseStepDescStr = XMLFile.getTestStepDescription(testCaseIdsStr[testCaseCount],
				testCaseSteps[testCaseStep]);
		pop(testCaseStepDescStr);

		/*** get test step Action ***/
		String testCaseStepActionStr = XMLFile.getTestStepAction(testCaseIdsStr[testCaseCount],
				testCaseSteps[testCaseStep]);
		pop(testCaseStepActionStr);

		/*** get test step UiLocator ***/
		String testCaseStepUiLocatorStr = XMLFile.getTestStepUILocator(testCaseIdsStr[testCaseCount],
				testCaseSteps[testCaseStep]);
		pop(testCaseStepUiLocatorStr);

		/*** get test step ActionParameter ***/
		String testCaseStepActionParameterStr = XMLFile.getTestStepActionParameter(testCaseIdsStr[testCaseCount],
				testCaseSteps[testCaseStep]);
		pop(testCaseStepActionParameterStr);

		while (testCaseStepActionParameterStr.contains("sheet=")) // af action
																	// parameter
																	// contains
																	// value
																	// form data
																	// table
		{
			testCaseStepActionParameterStr = getdatatableparameter(testCaseStepActionParameterStr); // getting
																									// parameter
																									// from
																									// datatable

		}
		if (testCaseStepUiLocatorStr.contains("sheet=")) // af UI parameter
															// contains value
															// form data table
		{
			testCaseStepUiLocatorStr = getdatatableparameter(testCaseStepUiLocatorStr); // getting
																						// parameter
																						// from
																						// datatable

		}
		if (testCaseStepActionStr.contains("sheet=")) // af action contains
														// value form data table
		{
			testCaseStepActionStr = getdatatableparameter(testCaseStepActionStr); // getting
																					// parameter
																					// from
																					// datatable

		}
		if (webDriverMode == 0)
			status = SeleniumCommandExecutor.executeSeleniumCommandUsingReflection((Integer.toString(totalTest)),
					testCaseSteps[testCaseStep], testCaseStepActionStr, testCaseStepUiLocatorStr,
					testCaseStepActionParameterStr);
		else
			status = WebDriverCommandExecutor.executeSeleniumCommandUsingReflection((Integer.toString(totalTest)),
					testCaseSteps[testCaseStep], testCaseStepActionStr, testCaseStepUiLocatorStr,
					testCaseStepActionParameterStr);

		// status=SeleniumCommandExecutor.executeSeleniumCommand(testCaseIdsStr[testCaseCount],testCaseSteps[testCaseStepCount],SeleniumCommand.valueOf(testCaseStepActionStr),
		// testCaseStepUiLocatorStr, testCaseStepActionParameterStr);
		pop("Status=" + status);

		inputStr = "Action=" + testCaseStepActionStr + "<BR>" + "UiLocator=" + testCaseStepUiLocatorStr + "<BR>"
				+ "Action Parameter=" + testCaseStepActionParameterStr;

		if (webDriverMode == 0)
			detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
					testCaseSteps[testCaseStep], testCaseStepDescStr, inputStr, status,
					SeleniumCommandExecutor.getFailureReason(), SeleniumCommandExecutor.getScreenPath());
		else
			detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
					testCaseSteps[testCaseStep], testCaseStepDescStr, inputStr, status,
					WebDriverCommandExecutor.getFailureReason(), WebDriverCommandExecutor.getScreenPath());
		if (status < 0) {
			if (webDriverMode == 0)
				imageFiles = imageFiles + (SeleniumCommandExecutor.getScreenPath()) + ",";
			else
				imageFiles = imageFiles + (WebDriverCommandExecutor.getScreenPath()) + ",";
		}
		return status;

	}

	public static int executeNextStep(int testCaseStep, int testCaseCount, int count, int loopCount) throws Throwable {
		testCaseStep++;
		pop(testCaseSteps[testCaseStep]);

		/** get test step description **/
		String testCaseStepDescStr = XMLFile.getTestStepDescription(testCaseIdsStr[testCaseCount],
				testCaseSteps[testCaseStep]);
		pop(testCaseStepDescStr);

		/*** get test step Action ***/
		String testCaseStepActionStr = XMLFile.getTestStepAction(testCaseIdsStr[testCaseCount],
				testCaseSteps[testCaseStep]);
		pop(testCaseStepActionStr);

		/*** get test step UiLocator ***/
		String testCaseStepUiLocatorStr = XMLFile.getTestStepUILocator(testCaseIdsStr[testCaseCount],
				testCaseSteps[testCaseStep]);
		pop(testCaseStepUiLocatorStr);

		/*** get test step ActionParameter ***/
		String testCaseStepActionParameterStr = XMLFile.getTestStepActionParameter(testCaseIdsStr[testCaseCount],
				testCaseSteps[testCaseStep]);
		pop(testCaseStepActionParameterStr);

		while (testCaseStepActionParameterStr.contains("sheet=")) // af action
																	// parameter
																	// contains
																	// value
																	// form data
																	// table
		{
			if (testCaseStepActionParameterStr.contains("loopCount")) {
				testCaseStepActionParameterStr = testCaseStepActionParameterStr.replaceAll("loopCount",
						Integer.toString(count));
			}
			testCaseStepActionParameterStr = getdatatableparameter(testCaseStepActionParameterStr, count, 1, 1); // getting
																													// parameter
																													// from
																													// datatable

		}
		if (testCaseStepUiLocatorStr.contains("sheet=")) // af UI parameter
															// contains value
															// form data table
		{
			if (testCaseStepUiLocatorStr.contains("loopCount")) {
				testCaseStepUiLocatorStr = testCaseStepUiLocatorStr.replaceAll("loopCount", Integer.toString(count));
			}
			testCaseStepUiLocatorStr = getdatatableparameter(testCaseStepUiLocatorStr, count, 1, 1); // getting
																										// parameter
																										// from
																										// datatable

		}
		if (testCaseStepActionStr.contains("sheet=")) // af action contains
														// value form data table
		{
			if (testCaseStepActionStr.contains("loopCount")) {
				testCaseStepActionStr = testCaseStepActionStr.replaceAll("loopCount", Integer.toString(count));
			}
			testCaseStepActionStr = getdatatableparameter(testCaseStepActionStr, count, 1, 1); // getting
																								// parameter
																								// from
																								// datatable

		}
		if (webDriverMode == 0)
			status = SeleniumCommandExecutor.executeSeleniumCommandUsingReflection((Integer.toString(totalTest)),
					testCaseSteps[testCaseStep], testCaseStepActionStr, testCaseStepUiLocatorStr,
					testCaseStepActionParameterStr);
		else
			status = WebDriverCommandExecutor.executeSeleniumCommandUsingReflection((Integer.toString(totalTest)),
					testCaseSteps[testCaseStep], testCaseStepActionStr, testCaseStepUiLocatorStr,
					testCaseStepActionParameterStr);

		// status=SeleniumCommandExecutor.executeSeleniumCommand(testCaseIdsStr[testCaseCount],testCaseSteps[testCaseStepCount],SeleniumCommand.valueOf(testCaseStepActionStr),
		// testCaseStepUiLocatorStr, testCaseStepActionParameterStr);
		pop("Status=" + status);

		inputStr = "Action=" + testCaseStepActionStr + "<BR>" + "UiLocator=" + testCaseStepUiLocatorStr + "<BR>"
				+ "Action Parameter=" + testCaseStepActionParameterStr;

		if (webDriverMode == 0)
			detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
					testCaseSteps[testCaseStep], testCaseStepDescStr, inputStr, status,
					SeleniumCommandExecutor.getFailureReason(), SeleniumCommandExecutor.getScreenPath());
		else
			detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
					testCaseSteps[testCaseStep], testCaseStepDescStr, inputStr, status,
					WebDriverCommandExecutor.getFailureReason(), WebDriverCommandExecutor.getScreenPath());
		if (status < 0) {
			if (webDriverMode == 0)
				imageFiles = imageFiles + (SeleniumCommandExecutor.getScreenPath()) + ",";
			else
				imageFiles = imageFiles + (WebDriverCommandExecutor.getScreenPath()) + ",";
		}
		return status;

	}

	public static int getRowCount(String loopParam) throws Throwable {

		int rowCount = 0;
		loopParam = loopParam.replace("end=", "");
		String sheet[] = loopParam.split(",");
		if (sheet.length == 1) {
			try {
				rowCount = Integer.parseInt(sheet[0]);
			} catch (NumberFormatException e) {
				rowCount = dt.getRowCount(sheet[0]);
			}

		} else if (sheet.length == 2) {
			rowCount = dt.getRowCount(sheet[0], sheet[1]);

		} else if (sheet.length == 3) {
			rowCount = Integer.parseInt(dt.getParameterValue(sheet[0], sheet[1], Integer.parseInt(sheet[2])));
		}

		return rowCount;

	}

	private static String getdatatableparameter(String actionparam) throws Throwable // function
																						// to
																						// get
																						// parameter
																						// from
																						// data
																						// table
	{

		int start, end;
		String temp1;
		temp1 = actionparam;
		start = actionparam.indexOf("sheet=");
		end = actionparam.indexOf(";", start);

		actionparam = actionparam.substring(start, end);
		actionparam = actionparam.replace("sheet=", "");
		actionparam = actionparam.replace("column=", "");
		actionparam = actionparam.replace("row=", "");
		data = actionparam.split(",");
		actionparam = dt.getParameterValue(data[0], data[1], Integer.parseInt(data[2]));
		actionparam = temp1.substring(0, start) + actionparam + temp1.substring(++end);
		return actionparam;

	}

	private static void repeat(int testcase, int start, int end) throws Throwable {
		for (int testCaseCount = testcase; testCaseCount <= testcase; testCaseCount++) {

			pop("*****************************" + testCaseCount + "***********************************************");
			testCaseStatus = 1;
			/* get test case id **/
			pop(testCaseIdsStr[testCaseCount]);

			/* get test case description **/
			testCaseDescStr = XMLFile.getTestCaseDescription(testCaseIdsStr[testCaseCount]);
			pop(testCaseDescStr);

			/**** get Test Steps in an array ********/
			String testCaseSteps[] = XMLFile.getTestCaseSteps(testCaseIdsStr[testCaseCount]);
			/**** Parse Each Step ******/
			int testcasestepsize;
			if (start == 0 && end == 0) {
				start = 0;
				testcasestepsize = testCaseSteps.length;
			} else {
				testcasestepsize = end;
			}

			// get size of testcasesteps arrays
			for (int testCaseStepCount = start; testCaseStepCount < testcasestepsize; testCaseStepCount++) {

				/** get test step no **/
				pop(testCaseSteps[testCaseStepCount]);

				/** get test step description **/
				testCaseStepDescStr = XMLFile.getTestStepDescription(testCaseIdsStr[testCaseCount],
						testCaseSteps[testCaseStepCount]);
				pop(testCaseStepDescStr);

				/*** get test step Action ***/
				testCaseStepActionStr = XMLFile.getTestStepAction(testCaseIdsStr[testCaseCount],
						testCaseSteps[testCaseStepCount]);
				pop(testCaseStepActionStr);

				/*** get test step UiLocator ***/
				testCaseStepUiLocatorStr = XMLFile.getTestStepUILocator(testCaseIdsStr[testCaseCount],
						testCaseSteps[testCaseStepCount]);
				pop(testCaseStepUiLocatorStr);

				/*** get test step ActionParameter ***/
				testCaseStepActionParameterStr = XMLFile.getTestStepActionParameter(testCaseIdsStr[testCaseCount],
						testCaseSteps[testCaseStepCount]);
				pop(testCaseStepActionParameterStr);

				if (testCaseStepActionStr.equalsIgnoreCase("Loop")) // checking
																	// if action
																	// is loop
																	// or not
				{
					if (testCaseStepUiLocatorStr.contains("sheet=")) // af UI
																		// parameter
																		// contains
																		// value
																		// form
																		// data
																		// table
					{
						testCaseStepUiLocatorStr = getdatatableparameter(testCaseStepUiLocatorStr); // getting
																									// parameter
																									// from
																									// datatable

					}
					testCaseStepCount = loop(testCaseStepCount, testCaseCount);
					continue;
				}
				if (testCaseStepActionStr.equalsIgnoreCase("if")) {
					status = 1;
					inputStr = "Continue if next step " + "<BR>" + testCaseStepActionParameterStr;
					detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
							testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status, "", "");
					status = executeNextStep(testCaseStepCount, testCaseCount);

					if (status < 0 && testCaseStepActionParameterStr.equalsIgnoreCase("fail")) {
						testCaseStepCount++;
						continue;
					}
					if (status > 0 && testCaseStepActionParameterStr.equalsIgnoreCase("pass")) {
						testCaseStepCount++;
						continue;
					}

					testCaseStepCount = callIf(testCaseStepCount, testCaseCount);
					continue;

				}
				if (testCaseStepActionStr.equalsIgnoreCase("endIf")) {
					status = 1;
					inputStr = "EndIf";
					detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
							testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status, "", "");
					continue;
				}
				if (!testCaseStepActionStr.equalsIgnoreCase("Loop")
						&& !testCaseStepActionStr.equalsIgnoreCase("EndLoop")) {
					while (testCaseStepActionParameterStr.contains("sheet=")) // af
																				// action
																				// parameter
																				// contains
																				// value
																				// form
																				// data
																				// table
					{
						testCaseStepActionParameterStr = getdatatableparameter(testCaseStepActionParameterStr); // getting
																												// parameter
																												// from
																												// datatable

					}
					if (testCaseStepUiLocatorStr.contains("sheet=")) // af UI
																		// parameter
																		// contains
																		// value
																		// form
																		// data
																		// table
					{
						testCaseStepUiLocatorStr = getdatatableparameter(testCaseStepUiLocatorStr); // getting
																									// parameter
																									// from
																									// datatable

					}
					if (testCaseStepActionStr.contains("sheet=")) // af action
																	// contains
																	// value
																	// form data
																	// table
					{
						testCaseStepActionStr = getdatatableparameter(testCaseStepActionStr); // getting
																								// parameter
																								// from
																								// datatable

					}
					if (webDriverMode == 0)
						status = SeleniumCommandExecutor.executeSeleniumCommandUsingReflection(
								(Integer.toString(totalTest)), testCaseSteps[testCaseStepCount], testCaseStepActionStr,
								testCaseStepUiLocatorStr, testCaseStepActionParameterStr);
					else
						status = WebDriverCommandExecutor.executeSeleniumCommandUsingReflection(
								(Integer.toString(totalTest)), testCaseSteps[testCaseStepCount], testCaseStepActionStr,
								testCaseStepUiLocatorStr, testCaseStepActionParameterStr);

					// status=SeleniumCommandExecutor.executeSeleniumCommand(testCaseIdsStr[testCaseCount],testCaseSteps[testCaseStepCount],SeleniumCommand.valueOf(testCaseStepActionStr),
					// testCaseStepUiLocatorStr,
					// testCaseStepActionParameterStr);
					pop("Status=" + status);
					if (status < 0) {
						if (status == -1)
							testCaseStatus = -1;
						else if (testCaseStatus != -1 && status == -2)
							testCaseStatus = -2;
					}
					inputStr = "Action=" + testCaseStepActionStr + "<BR>" + "UiLocator=" + testCaseStepUiLocatorStr
							+ "<BR>" + "Action Parameter=" + testCaseStepActionParameterStr;
				}

				if (webDriverMode == 0)
					detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
							testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status,
							SeleniumCommandExecutor.getFailureReason(), SeleniumCommandExecutor.getScreenPath());
				else
					detailedLog.writeToDetailedStatusReport(testCaseIdsStr[testCaseCount], testCaseDescStr,
							testCaseSteps[testCaseStepCount], testCaseStepDescStr, inputStr, status,
							WebDriverCommandExecutor.getFailureReason(), WebDriverCommandExecutor.getScreenPath());
				if (status < 0) {
					if (webDriverMode == 0)
						imageFiles = imageFiles + (SeleniumCommandExecutor.getScreenPath()) + ",";
					else
						imageFiles = imageFiles + (WebDriverCommandExecutor.getScreenPath()) + ",";
				}
				if (status == -1)
					break;
			} /* End of test step execution loop */
		}
	}

	private static String getdatatableparameter(String actionparam, int loopCount, int stepCount, int startRow)
			throws Throwable // function to get parameter from data table
	{

		int start, end;
		int loopstatus = 1;

		String temp1;
		temp1 = actionparam;
		start = actionparam.indexOf("sheet=");
		end = actionparam.indexOf(";", start);
		actionparam = actionparam.substring(start, end);
		actionparam = actionparam.replace("sheet=", "");
		actionparam = actionparam.replace("column=", "");
		if (actionparam.contains("startrow"))
			actionparam = actionparam.replace("startrow=", "");
		else if (actionparam.contains("row")) {
			actionparam = actionparam.replace("row=", "");
			loopstatus = 0;

		}
		data = actionparam.split(",");

		if (data.length == 3 && loopstatus == 0)// start row
		{
			loopCount = Integer.parseInt(data[2]);

		}
		if (data.length == 3 && loopstatus == 1) {
			loopCount = Integer.parseInt(data[2]) + stepCount * startRow;

		}
		actionparam = dt.getParameterValue(data[0], data[1], loopCount);

		actionparam = temp1.substring(0, start) + actionparam + temp1.substring(++end);

		return actionparam;

	}

	public static String[] getFiles(String dirName) {
		File inputFolder = new File(dirName);
		int noOfFiles = inputFolder.listFiles().length;
		String temp[] = inputFolder.list();

		List<String> files = new ArrayList<String>();

		for (int i = 0; i < noOfFiles; i++) {
			if (temp[i].contains(".xml"))
				files.add(temp[i]);

		}
		String fileNames[] = files.toArray(new String[0]);
		pop(fileNames.toString());
		return (fileNames);
	}

}/* End of class body */