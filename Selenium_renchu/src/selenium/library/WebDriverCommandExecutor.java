package selenium.library;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;

import selenium.utilities.ConfigurationReader;
import selenium.utilities.SikuliExecutor;
import selenium.utilities.TestTime;
import selenium.utilities.WebService;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.SeleniumException;

import renchuTool.RenchuTool;

public class WebDriverCommandExecutor extends RenchuTool {
	private static String filename; // Name of image file
	private static WebDriverCommands webDriver = new WebDriverCommands(); // selenium
																			// instatnce
	private static String serverHost = null; // Selenium argument
	private static int serverPort; // Selenium argument
	private static String browserStartCommand = null; // Selenium argument
	private static String browserURL = null; // Selenium argument
	private static String failureReason = null; // failure message

	private static TestTime time;
	private static int visible = 1;
	private static Object selen;
	private static Map object = new HashMap();
	private static int visibleTimeOut; // waitForVisible time out
	static String assertParameters[]; // Splitting action Parameters
	static Object[] args; // used to pass parameters to selenium functions
	static Class SeleniumClass; // finding class
	static int filecount = 1;
	static Exception e; // Exception e
	static String tableelement[]; // to store xpath value
	// used to read xpath properties file
	private static ConfigurationReader configuration;
	private static ConfigurationReader seleniumConf;
	private static String ip, browser; // stores ip address and browser
	static Class[] parameterTypes = null; // for obtaining parameter types of a
											// selenium function
	private static String seleniumMode;
	private static SeleniumServer server;
	static Method seleniumMethods[]; // Getting all declared methods of selenium
										// class
	private static long waitTime;
	public static String waitTimeOut;
	static int totalFunctions; // total no. of functions
	static int totalParameters; // stores total no. of parameters of a selenium
								// function
	private static int sikuli = 0;
	static int j = 0;
	static int count = 0;
	private static String sikuliOnly;
	private static WebService wsCall = new WebService();
	private static ConfigurationReader methodNames;
	private static WebDriver driver;
	private static ConfigurationReader methodDef;
	private static String browserNameVersion;

	public static String startSelenium(String Browser) throws Exception {

		browser = "xx";
		seleniumConf = new ConfigurationReader("ConfigurationFiles/configuration.properties");
		methodNames = new ConfigurationReader("ConfigurationFiles/methodNames.properties");
		methodDef = new ConfigurationReader("ConfigurationFiles/methodDefinition.properties");
		if (Browser == null) {
			browserStartCommand = seleniumConf.getPropertyValue("browserStartCommand");
			pop("browserStartCommand=" + browserStartCommand);
		} else {
			browserStartCommand = Browser;
			pop("browserStartCommand=" + browserStartCommand);
		}

		configuration = new ConfigurationReader(
				seleniumConf.getPropertyValue("uiMap") + "/" + browserStartCommand.replace("*", "") + ".properties");

		/* Initialize selenium server configuration */

		serverHost = seleniumConf.getPropertyValue("serverHost");
		pop("serverHost=" + serverHost);

		serverPort = Integer.parseInt(seleniumConf.getPropertyValue("serverPort"));
		pop("serverPort=" + serverPort);

		browserURL = seleniumConf.getPropertyValue("browserURL");
		pop("browserURL=" + browserURL);

		failureReason = "";
		visibleTimeOut = Integer.parseInt(seleniumConf.getPropertyValue("visTimeOut"));
		visibleTimeOut = visibleTimeOut * 1000;
		waitTimeOut = seleniumConf.getPropertyValue("waitTimeOut");
		waitTimeOut = waitTimeOut + "000";
		seleniumMode = seleniumConf.getPropertyValue("selenium");
		sikuliOnly = seleniumConf.getPropertyValue("sikuliOnly");

		// sikuliOnly=no
		if (sikuliOnly.equalsIgnoreCase("yes")) {
			sikuli = 1;
			ip = "localhost";

		}
		// sikuli=0
		if (sikuli != 1) {
			ip = "localhost";
		}
		if (browserStartCommand.startsWith("*firefox")) {
			driver = webDriver.firefoxDriver(browserURL);
			browser = "FF";
		} else if (browserStartCommand.startsWith("*iexplore")) {
			driver = webDriver.internetExplorerDriver(browserURL);
			browser = "IE";
		} else {
			driver = webDriver.chromeDriver(browserURL);
			browser = "CM";
		}
		browserNameVersion = webDriver.getbrowserNameVersion();
		return ip;

	}

	public static String getBrowser() {
		if (sikuli == 1)

		{
			browser = "sl";
		}
		return browser;

	}

	public static String getBrowserVersion() {
		return browserNameVersion;
	}

	public static void closeSelenium() throws Exception {

		if (sikuli != 1) {
			webDriver.shutDown();

		}

	}

	// Function to execute selenium commands using reflection
	@SuppressWarnings({ "unchecked", "static-access" })
	public static int executeSeleniumCommandUsingReflection(String Testcase, String Step, String Action,
			String UiLocator, String ActionParameter) {
		String uiLoc = UiLocator;
		String actionForVerify = "";
		filename = "";
		failureReason = "";
		int status = 1;
		try {
			SeleniumClass = Class.forName("selenium.library.WebDriverCommands");
			seleniumMethods = SeleniumClass.getDeclaredMethods(); // Getting all
																	// declared
																	// methods
																	// of
																	// selenium
																	// class

			for (Method renchuMethod : seleniumMethods) {
				pop(renchuMethod);
			}

			totalFunctions = seleniumMethods.length; // total no. of functions
			pop("totalFunctions=" + totalFunctions);
			j = 0; // used for looping purpose

			if (Action.equalsIgnoreCase("sikuli")) {
				if (ActionParameter.equalsIgnoreCase("on"))
					sikuli = 1;
				else
					sikuli = 0;
			} else if (sikuli == 1) {
				UiLocator = getUilocator(UiLocator);
				ActionParameter = getUilocator(ActionParameter);
				SikuliExecutor.sikuliCommandExecutor(Action, UiLocator, ActionParameter);
			} else {
				Action = getMethodName(Action);
				actionForVerify = Action;

				// 因为methodDefinition里面配置文件为空，所以Action = getMethodName(Action)不变
				// actionForVerify=maximize 第一次
				pop("actionForVerify=" + actionForVerify);

				if (Action.contains("verify")) {
					Action = Action.replace("verify", "assert");
				}
				if (Action.contains("!")) {
					Action = Action.replace("!", "");
				}

				pop(methodDef.getPropertyValue(Action));
				if (methodDef.getPropertyValue(Action) != null) {
					String methodValue = methodDef.getPropertyValue(Action);

					WebElement element;

					String ActionValue[] = methodValue.split(",");
					element = driver.findElement(webDriver.findBy(UiLocator));

					SeleniumClass = Class.forName("org.openqa.selenium.WebElement");
					seleniumMethods = SeleniumClass.getMethods();

					for (j = 0; j < seleniumMethods.length; j++) // finding the
																	// selenium
																	// function
					{
						if (ActionValue[0].equalsIgnoreCase(seleniumMethods[j].getName())) {
							parameterTypes = seleniumMethods[j].getParameterTypes();
							break;
						}
					}
					totalParameters = parameterTypes.length; // no. of
																// parameters
					UiLocator = getUilocator(UiLocator);
					ActionParameter = getUilocator(ActionParameter);

					if (ActionValue.length == 2)
						args = new Object[] { new String(ActionParameter) };
					else
						args = null;

					selen = seleniumMethods[j].invoke(element, args); // calling
																		// selenium
																		// functions
					if (selen != null)
						object.put(Step, selen);
					pop(selen);

				} else {

					// 循环的次数是WebDriverCommands类中所有方法的个数，一共29个
					// totalFunctions=29
					for (j = 0; j < totalFunctions; j++) // finding the selenium
															// function
					{

						// 遍历selenium.library.WebDriverCommands类中所有的方法
						// 比如现在的Action=maximize,那么就一直找WebDriverCommands类中有没有一个叫maximize的方法
						if (Action.equalsIgnoreCase(seleniumMethods[j].getName())) {

							// 找到了，发现seleniumMethods[j]就是maximize方法
							// 获得该方法的参数类型， maximize是午餐，所以parameterTypes=null
							parameterTypes = seleniumMethods[j].getParameterTypes();

							break;
						}
					}

					// 参数个数， maximize是午餐，所以totalParameters=0
					totalParameters = parameterTypes.length; // no. of
					pop("totalParameters=" + totalParameters); // parameters

					// 对UiLocator进行逻辑处理，比如识别关键字
					UiLocator = getUilocator(UiLocator);
					pop("UiLocator=" + UiLocator);

					// 如果有多个参数，逻辑处理
					if (ActionParameter.contains(";")) {
						String actionParameterSet[] = ActionParameter.split(";");
						for (int i = 0; i < actionParameterSet.length; i++) {
							ActionParameter = ActionParameter.replace(actionParameterSet[i],
									getUilocator(actionParameterSet[i]));
						}
					} else
						// 一个参数，逻辑处理
						ActionParameter = getUilocator(ActionParameter);
					if (totalParameters == 2) // 参数只能为2个，1个或者0个
					{
						args = new Object[] { new String(UiLocator), new String(ActionParameter) };
					} else if (totalParameters == 1)
						if (!UiLocator.equals("")) {
							args = new Object[] { new String(UiLocator) };
						} else
							args = new Object[] { new String(ActionParameter) };
					else
						args = null;

					// 在此使用了反射机制,obj为Commands的引用对象
					selen = seleniumMethods[j].invoke(webDriver, args); // calling
																		// selenium
					// functions

					pop("selen=" + selen);
					pop("status=" + status);
					if (status == 1) {
						if (actionForVerify.contains("!")) {
							throw new AssertionError("Assertion Failed");
						}
					}
					failureReason = (String) selen;

					if (selen != null)
						object.put(Step, selen);
					pop(selen);
				}
			}
		} catch (AssertionError e) {
			status = -1;
			captureScreen(Testcase, Step);
			if (actionForVerify.contains("verify")) {
				status = -2;
			}
			/*** get error description for logging purpose */
			failureReason = e.getMessage();
			failureReason = failureReason.replace(getUilocator(uiLoc), uiLoc);
			pop(e.getMessage());

		} catch (ClassNotFoundException e) {
			status = -1;
			captureScreen(Testcase, Step);
			/*** get error description for logging purpose */
			failureReason = e.getMessage();
			pop(e.getMessage());
		} catch (IllegalAccessException e) {
			status = -1;
			captureScreen(Testcase, Step);
			/*** get error description for logging purpose */
			failureReason = e.getMessage();
			pop(e.getMessage());
		} catch (InvocationTargetException e) {
			status = -1;
			captureScreen(Testcase, Step);

			/*** get error description for logging purpose */
			failureReason = e.getMessage();
			pop(e.getMessage());
			if (failureReason == null) {
				status = -2;
				failureReason = e.getTargetException().getMessage();
				failureReason = failureReason.replace(getUilocator(uiLoc), uiLoc);
				pop(failureReason);

			}

			try {
				throw e.getTargetException();
			} catch (AssertionError e1) {

				status = -1;
				if (actionForVerify.contains("verify")) {
					status = -2;
				}
				if (actionForVerify.contains("!")) {
					status = 1;
				}
				/*** get error description for logging purpose */
				failureReason = e1.getMessage();
				failureReason = failureReason.replace(getUilocator(uiLoc), uiLoc);
				pop(e1.getMessage());

			} catch (TimeoutException e3) {
				status = -1;
				/*** get error description for logging purpose */
				failureReason = e3.getMessage();
				failureReason = failureReason.replace(getUilocator(uiLoc), uiLoc);
				pop(e3.getMessage());
				if (actionForVerify.contains("!")) {
					status = 1;
				}

			}

			catch (Throwable e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		} catch (Exception e) {
			status = -1;
			captureScreen(Testcase, Step);
			/*** get error description for logging purpose */
			failureReason = e.getMessage();
			pop(e.getMessage());
			if (failureReason == null) {
				failureReason = e.getLocalizedMessage();
				if (failureReason != null && failureReason != "")
					failureReason = failureReason.replace(getUilocator(uiLoc), uiLoc);
				pop(failureReason);

			}

			/*** code to log in log4j ***/
		}

		return status;
	}

	public static String getFailureReason() // returns failure message
	{
		return failureReason;
	}

	public static void captureScreen(String test, String step) // captures
																// screenshot
	{

		count++;
		filename = ip + "_" + browser + "_" + test + "_" + step + "_" + count + ".jpg";
		filecount++;
		if (sikuli == 1) {
			try {

				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Dimension screenSize = toolkit.getScreenSize();
				Robot robot = new Robot();
				// Capture the screen shot of the area of the screen defined by
				// the rectangle
				BufferedImage bi = robot.createScreenCapture(new Rectangle(screenSize));
				ImageIO.write(bi, "jpg", new File("Logs/Images/" + filename));

			} catch (AWTException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			String a = webDriver.captureScreenshotToString();
			try {
				byte[] decodedScreenshot = Base64.decodeBase64(a.getBytes());
				FileOutputStream fos = new FileOutputStream(new File("Logs/Images/" + filename));
				fos.write(decodedScreenshot);
				fos.close();

			} catch (Exception e) {
				pop(e.getStackTrace());
			}
		}

	}

	public static String getScreenPath() // returns image file name
	{
		return filename;
	}

	public static String getUilocator(String Locator) // used to fetch actual UI
														// locator value from
														// xpath property file
														// using input sheet
														// value
	{

		if (Locator.startsWith("*") == false)// if locator is normal ui element
		{
			if (configuration.getPropertyValue(Locator) == null)
				return Locator;
			else
				return configuration.getPropertyValue(Locator);
		}
		Locator = Locator.substring(1);
		// if locator is some output from software
		if (Locator.startsWith("step")) {
			Locator = Locator.replaceAll("\\]", "");
			tableelement = Locator.split("\\[");

			Locator = (String) object.get(tableelement[1]);
			return Locator;
		}

		// if locator is a table element
		Locator = Locator.replaceAll("\\]", "");
		tableelement = Locator.split("\\[");
		Locator = configuration.getPropertyValue(tableelement[0]);

		if (tableelement[1].contains("step")) {

			tableelement[1] = (String) object.get(tableelement[2]);
		}
		Locator = Locator.replace("xx", tableelement[1]);
		if (tableelement.length == 3)
			Locator = Locator.replace("yy", tableelement[2]);
		return Locator;

	}

	public static String getMethodName(String Action) {
		if (methodNames.getPropertyValue(Action) == null)
			return Action;
		else
			return methodNames.getPropertyValue(Action);
	}

}