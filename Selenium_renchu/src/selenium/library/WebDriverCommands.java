package selenium.library;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import renchuTool.RenchuTool;
import selenium.utilities.C2VDecoder;
import selenium.utilities.ConfigurationReader;
import selenium.utilities.DatabaseSetup;
import selenium.utilities.TestTime;

public class WebDriverCommands extends RenchuTool {

	WebDriver driver;
	WebElement element;
	static String UiLocator;
	String ActionParamter;
	String baseUrl;
	int waitFailtRetryCount;
	int waitFailCurrentCount = 0;
	ConfigurationReader conf = new ConfigurationReader("ConfigurationFiles/configuration.properties");
	int visibleTimeOut;
	int implicitWait;
	TestTime time;
	String browserNameVersion;

	WebDriver firefoxDriver(String base) throws Exception {
		driver = new FirefoxDriver();
		baseUrl = base;
		visibleTimeOut = Integer.parseInt(conf.getPropertyValue("visTimeOut"));
		implicitWait = Integer.parseInt(conf.getPropertyValue("ImplicitWait"));
		waitFailtRetryCount = Integer.parseInt(conf.getPropertyValue("waitFailRetryCount"));
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		// driver.manage().deleteAllCookies();
		org.openqa.selenium.Capabilities seleniumCap = ((RemoteWebDriver) driver).getCapabilities();
		browserNameVersion = seleniumCap.getBrowserName();
		browserNameVersion = browserNameVersion + " " + seleniumCap.getVersion();
		driver.manage().window().maximize();
		return driver;
	}

	WebDriver chromeDriver(String base) throws Exception {
		ChromeOptions Chromeoptions = new ChromeOptions();
		// Chromeoptions.addArguments("disable-application-cache");
		Chromeoptions.addArguments("disk-cache-size=0");
		driver = new ChromeDriver(Chromeoptions);

		// driver = new ChromeDriver();
		baseUrl = base;
		visibleTimeOut = Integer.parseInt(conf.getPropertyValue("visTimeOut"));
		implicitWait = Integer.parseInt(conf.getPropertyValue("ImplicitWait"));
		waitFailtRetryCount = Integer.parseInt(conf.getPropertyValue("waitFailRetryCount"));
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		// driver.manage().deleteAllCookies();
		org.openqa.selenium.Capabilities seleniumCap = ((RemoteWebDriver) driver).getCapabilities();
		browserNameVersion = seleniumCap.getBrowserName();
		browserNameVersion = browserNameVersion + " " + seleniumCap.getVersion();
		driver.manage().window().maximize();
		return driver;
	}

	WebDriver internetExplorerDriver(String base) throws Exception {
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		ieCapabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
		ieCapabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
		ieCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
		ieCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		// ieCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true);
		ieCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "dismiss");

		// add
		File file = new File("lib/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

		driver = new InternetExplorerDriver(ieCapabilities);
		baseUrl = base;
		visibleTimeOut = Integer.parseInt(conf.getPropertyValue("visTimeOut"));
		implicitWait = Integer.parseInt(conf.getPropertyValue("ImplicitWait"));
		waitFailtRetryCount = Integer.parseInt(conf.getPropertyValue("waitFailRetryCount"));
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		// driver.manage().deleteAllCookies();
		org.openqa.selenium.Capabilities seleniumCap = ((RemoteWebDriver) driver).getCapabilities();
		browserNameVersion = seleniumCap.getBrowserName();
		browserNameVersion = browserNameVersion + " " + seleniumCap.getVersion();
		driver.manage().window().maximize();
		return driver;
	}

	String captureScreenshotToString() {
		String source;
		try {
			// WebDriver augmentedDriver = new Augmenter().augment(driver);
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			;
		} catch (Exception e) {
			source = "Failed to capture screenshot: " + e.getMessage();
		}
		return source;

	}

	void shutDown() throws Exception {
		driver.quit();
	}

	String getbrowserNameVersion() {
		return browserNameVersion;
	}

	@SuppressWarnings("rawtypes")
	static By findBy(String UiLocator) throws Exception {
		By by = null;
		Class findBy = null;
		Method method = null;
		try {
			findBy = Class.forName("org.openqa.selenium.By");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String methodName;

		// Method methods[] = findBy.getDeclaredMethods();

		// Xpath查找
		if (UiLocator.startsWith("xpath=")) {
			methodName = "xpath";
			UiLocator = UiLocator.replace("xpath=", "");
		} else if (UiLocator.contains("//"))
			methodName = "xpath";
		// css选择器
		else if (UiLocator.startsWith("css=")) {
			methodName = "cssSelector";
			UiLocator = UiLocator.replace("css=", "");
		}
		// link查找
		else if (UiLocator.startsWith("link=")) {
			methodName = "linkText";
			UiLocator = UiLocator.replace("link=", "");
		} else
		// 如果写明 methodName=什么，那么就支持这种查找方法
		// 如果没写，默认就是id=
		{
			try {
				methodName = UiLocator.substring(0, UiLocator.indexOf("="));
				UiLocator = UiLocator.replace(methodName + "=", "");
			} catch (Exception e) {
				methodName = "id";
			}
		}
		Object args = new String(UiLocator);
		try {
			// 找到对应方法
			method = findBy.getMethod(methodName, String.class);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			// 回调该方法
			by = (By) method.invoke(By.class, args);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return by;

	}

	void click(String UiLocator) throws Exception {
		mouseOver(UiLocator);
		element = driver.findElement(findBy(UiLocator));

		element.click();
	}

	void type(String UiLocator, String ActionParameter) throws Exception {

		element = driver.findElement(findBy(UiLocator));
		element.sendKeys(ActionParameter);
	}

	void open(String ActionParameter) throws Exception {

		driver.get(baseUrl + ActionParameter);
	}

	void select(String UiLocator, String ActionParameter) throws Exception {
		Select select = new Select(driver.findElement(findBy(UiLocator)));

		select.selectByVisibleText(ActionParameter);

	}

	String waitForVisible(String UiLocator, String ActionParameter) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, (visibleTimeOut));
		long waitTime = time.gettimemillis();

		try {
			if (!UiLocator.equals("") && !ActionParameter.equals("")) {
				element = driver.findElement(findBy(UiLocator));
				Boolean vis = wait.until(ExpectedConditions.textToBePresentInElement(element, ActionParameter));
				if (vis == false) {
					throw new AssertionError("Element " + UiLocator + ActionParameter + " not found");
				}
			} else if (!UiLocator.equals("")) {
				element = wait.until(ExpectedConditions.presenceOfElementLocated(findBy(UiLocator)));

			} else if (ActionParameter != "") {
				Boolean vis = wait
						.until(ExpectedConditions.textToBePresentInElement(By.tagName("body"), ActionParameter));
				if (vis == false) {
					throw new AssertionError("Element " + UiLocator + ActionParameter + " not found");
				}
			}
		} catch (Exception e) {
			waitFailCurrentCount++;
			if (waitFailCurrentCount <= waitFailtRetryCount) {
				waitForVisible(UiLocator, ActionParameter);
			} else {
				waitFailCurrentCount = 0;
				throw e;
			}
		}
		waitTime = (time.gettimemillis() - waitTime);
		waitFailCurrentCount = 0;
		return String.valueOf(waitTime);
	}

	String wait(String ActionParameter) {
		try {
			Thread.sleep(Long.parseLong(ActionParameter));

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ActionParameter;
	}

	void assertTitle(String ActionParameter) throws Exception {
		if (!driver.getTitle().equals(ActionParameter))
			throw new AssertionError("Expected " + ActionParameter + " but saw " + driver.getTitle() + " instead");

	}

	void assertVisible(String UiLocator) throws Exception {
		element = driver.findElement(findBy(UiLocator));
		if (!element.isDisplayed()) {
			throw new AssertionError("element " + UiLocator + " not visible");
		}
	}

	void assertText(String UiLocator, String ActionParameter) throws Exception {
		try {
			element = driver.findElement(findBy(UiLocator));
		} catch (Exception e) {
			throw new AssertionError(e.getStackTrace());
		}
		if (!element.getText().equals(ActionParameter)) {
			throw new AssertionError("Expected " + ActionParameter + " but saw " + element.getText());

		}
	}

	void assertValue(String UiLocator, String ActionParameter) throws Exception {
		try {
			element = driver.findElement(findBy(UiLocator));
		} catch (Exception e) {
			throw new AssertionError(e.getStackTrace());
		}
		if (!element.getAttribute("value").equals(ActionParameter)) {
			throw new AssertionError("Expected " + ActionParameter + " but saw " + element.getText());

		}
	}

	void assertTextPresent(String ActionParameter) {
		if ((driver.findElement(By.cssSelector("BODY")).getText().matches(ActionParameter)) == false) {
			throw new AssertionError(ActionParameter + " not visible");
		}
	}

	void assertEditable(String UiLocator) throws Exception {
		element = driver.findElement(findBy(UiLocator));
		if (!element.isEnabled()) {
			throw new AssertionError(UiLocator + " not Enabled and Editable");
		}

	}

	void execute(String ActionParameter) throws InterruptedException, IOException {
		if (ActionParameter.contains(".exe"))
			Runtime.getRuntime().exec(ActionParameter).waitFor();
		else if (ActionParameter.contains(".bat")) {
			Runtime.getRuntime().exec(new String[] { "cmd.exe", "/c", ActionParameter }).waitFor();

		} else {
			throw new AssertionError("Error: " + ActionParameter + "is not a valid exe/bat file");
		}
		Thread.sleep(5000);
	}

	String getText(String UiLocator) throws Exception {
		element = driver.findElement(findBy(UiLocator));
		return element.getText();
	}

	String waitForPageToLoad(String UiLocator, String ActionParameter) throws Exception {
		long waitTime = time.gettimemillis();
		try {
			WebDriverWait wait = new WebDriverWait(driver, (Integer.parseInt(ActionParameter)) / 1000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(findBy(UiLocator)));

		} catch (TimeoutException e) {
			waitFailCurrentCount++;
			if (waitFailCurrentCount <= waitFailtRetryCount) {
				waitForPageToLoad(UiLocator, ActionParameter);
			} else {
				waitFailCurrentCount = 0;
				throw e;
			}
		}
		waitTime = (time.gettimemillis() - waitTime);
		waitFailCurrentCount = 0;
		return String.valueOf(waitTime);
	}

	void maximize() throws Exception {
		driver.manage().window().maximize();
		pop("maximize()被调用了");
	}

	void mouseOver(String UiLocator) throws Exception {
		element = driver.findElement(findBy(UiLocator));

		Actions builder = new Actions(driver);
		builder.moveToElement(element).build().perform();
	}

	void clear(String UiLocator) throws Exception {

		element = driver.findElement(findBy(UiLocator));
		element.clear();

	}

	void clearAndType(String UiLocator, String ActionParameter) throws Exception {
		element = driver.findElement(findBy(UiLocator));
		element.clear();
		element.sendKeys(ActionParameter);
	}

	void refresh() {
		driver.navigate().refresh();
	}

	void executeJavaScript(String UiLocator, String ActionParameter) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (!UiLocator.equals(""))
			js.executeScript(UiLocator);
		else
			js.executeScript(ActionParameter);

	}

	void decodeAndCompare(String UiLocator, String ActionParameter) throws Exception {
		// 获得DB对象
		DatabaseSetup emsDatabase = new DatabaseSetup();

		// 从DOM中获得STRING
		String keyId = getText(UiLocator);

		// 获得DB中KEYID对应的C2V
		String sqlQuery = "SELECT FutureC2V  FROM [EMSDB].[dbo].[T_TARGET] Where HASPId=" + keyId;
		String c2v = emsDatabase.executeSQLScript(sqlQuery);

		String decodedC2V = C2VDecoder.decodeC2V(c2v);
		if (ActionParameter.contains(";")) {
			String actionParameterSet[] = ActionParameter.split(";");
			String errorMessage = "";
			for (int i = 0; i < actionParameterSet.length; i++) {
				if (!decodedC2V.contains(actionParameterSet[i]))
					errorMessage = errorMessage + actionParameterSet[i] + " not found in decoded C2V ";

			}
			if (!errorMessage.equals(""))
				throw new AssertionError(errorMessage);

		} else {
			if (!decodedC2V.contains(ActionParameter))
				throw new AssertionError(ActionParameter + " not found in decoded C2V");
		}
	}
	// newly added for checkbox and radio buttons
	/*
	 * void uncheck(String UiLocator) throws Exception { element =
	 * driver.findElement(findBy(UiLocator)); if (element.isSelected()) {
	 * element.click(); } } void check(String UiLocator) throws Exception {
	 * element = driver.findElement(findBy(UiLocator)); if
	 * (!element.isSelected()) { element.click(); } }
	 */

}
