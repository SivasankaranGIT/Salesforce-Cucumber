/***********************************************************************************
	 WebConnector:  Initialize Properties file
	 				Logging
	 				Selenium Commands (Application Independent & Dependent Functions)	 				
	  				Singleton
 ***********************************************************************************/
package com.mhe.salesforce.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.apache.commons.io.FileUtils;
//import org.hamcrest.Matcher;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.util.Calendar;
import java.util.Date;

import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
//import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class WebConnector {

	Properties OR = null;
	Properties TestData = null;
	Properties isTestExecutable = null;
	public static String USER_DIR = System.getProperty("user.dir");
	public String SALESFORCE_PATH = USER_DIR + "/src/main/java/com/mhe/salesforce/";
	public String OR_PATH = SALESFORCE_PATH + "config/OR.properties";
	public String TESTDATA_PATH = SALESFORCE_PATH + "config/TestData.properties";
	public String ISTESTEXECUTABLE_PATH = SALESFORCE_PATH + "config/isTestExecutable.properties";
	public String CHROME_DRIVER_PATH = USER_DIR + "/drivers/chromedriver.exe";
	public String CHROME_DRIVER_LINUX_PATH = "//local//software//chrome-106.0.5249.91.1//chromedriver";
	public String IE_DRVER_PATH = USER_DIR + "/drivers/IEDriverServer.exe";
	public static String REPORTS_PATH = USER_DIR + "//Report//";	//Extent Report
	public static String REPORTS_PATH1 = USER_DIR + "//target//cucumber-reports//";		//Cucumber Report
	public static String REPORTS_PATH2 = USER_DIR + "//data//";		//Cucumber Report
	public static String REPORTS_PATH_E2C = USER_DIR + "//data//E2C//";
	String userInterface = null;
	WebDriver driver = null; // changed to public so that it can be accessed from test classes also -- sayan
								// halder
	WebDriver chDriver = null;
	WebDriver ieDriver = null;
	static WebConnector wb = null;
	public String testCaseName = null;
	public String INTLNewContact = null;
	public String browserName = null;
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test = null;
	WebDriverWait wait = null;
	public static final String DATA_XL_PATH = USER_DIR + "/data/Data.xlsx";
	public static final String DATA_XL_PATH_E2C_1 = USER_DIR + "/data/E2C/Data_E2CJob1.xlsx";
	public static final String DATA_XL_PATH_E2C_2 = USER_DIR + "/data/E2C/Data_E2CJob2.xlsx";
	public static final String DATA_XL_PATH_E2C_3 = USER_DIR + "/data/E2C/Data_E2CJob3.xlsx";
	public static final String DATA_XL_PATH_E2C_4 = USER_DIR + "/data/E2C/Data_E2CJob4.xlsx";
	public static final String DATA_XL_PATH_E2C_A3K = USER_DIR + "/data/E2C/Data_E2CA3K.xlsx";
//	public static final String DATA_XL_PATH_E2C_Functionalities = USER_DIR + "/data/E2C/Data_E2CFunctionalities.xlsx";
	public Xls_Reader xls = null;
	public Xls_Reader xlsE2C_1 = null;
	public Xls_Reader xlsE2C_2 = null;
	public Xls_Reader xlsE2C_3 = null;
	public Xls_Reader xlsE2C_4 = null;
	public Xls_Reader xlsE2C_A3K = null;
//	public Xls_Reader xlsE2C_Funtionalities = null;
	public String TESTCASES_SHEET = "TestCases";
	public String TESTDATA_SHEET = "TestData";
	public String TESTDROPDOWNVALUES_SHEET = "TestDropDownValues";
	public static String ACC_NAME_RANDOM = null;
	public static final String TC_NAME = "CreateAccountTest";
	public static final String TC_COLUMN_NAME = "Dynamic";
	public static final boolean GRID_RUN = false;
	public String opportunity = WebConnector.ACC_NAME_RANDOM + " "
			+ "Hazardous Waste; Chemical Engineering; E 2018 New Omitted";
	public String Parentwin = null;
	public String Currentwin = null;
	public String casenumber = null;
	public String LeadURl = null;
	public String newMHEQuoteURl = null;
	public String newQuoteURL=null;
	public String leadUrl_new = null;
	public String Eventtitle = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Event/";
	public String NewSEGOpp = null;
	public String task= null;
	public String taskNew="https://mh--uat.sandbox.lightning.force.com/lightning/r/Task/00T8b00007Ctt4xEAB/view";
	public String campaign= null;
	public String contacts= null;
	public String newContacts= null;
	public String url =null;
	public String strategy= null;
	public String oppURL=null;
	public String accountURL=null;
	public String convertedContactName="test auto28072021213811";
	public String eventURL=null;
	public String opportunityURL=null;
	public String oppContactURL1= null;
	public String taskURL=null;
	public String MHECourseURL=null;
	public String lastName=null;
	public String caseNumber = null;
	public String NewCaseNum=null;
	public String NewMHHETypeOppURL=null;
	public String MarketingUserNewOppURL=null;
	public String SEGSalesRepUserNewOppURL=null;
	public String QuoteNewOppURL=null;
	public String QuoteNewOppURL1=null;
	public String text=null;
	public String PostSalesWorkOrderURL = null;
	public String NewOppURLForSamplesTest= null;
	public String SamplesWithProdAndContact=null;
	public String NewOppURLForClosePurchaseDateTest=null;
	public String NewOppURLForVerifyDaysToCloseTest=null; //"https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/006DY000002QwWDYA0/view";
	public String NewOppURLForQuotesTest=null;
	public String MHHENewOppURL=null;
	public String MHENewOppURL=null;
	public String MHHENewOppURLForSingleClone=null;
	public String MHHENewOppURLToVerifyEvergreenField=null;
	public String MHHEOppWithPastYear=null;
	public String MHHEOppWithFutureYear=null;
	public String MHHEOppToTestEditorialSection=null;
	public String EnterprisePPLOppURL=null;
	public String INTLOppURL=null;
	public String OppPIUAddDeleteURL=null;
	public String DTSCaseURL=null;
	public String NewSampleURL=null;
	public String ValidTrig="https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068H000006FghrQAC/view";
	public String INTLDigital="https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y000017nynpAAA/view";
	public String opportunity_expected=null;
	public String opty_expected=null;
	public String opportunity_name=null;
	public String newopportunity_name=null;
	public String newQuoteName=null;
	public String newQuoteNumber=null;
	public String newQuoteNum=null;
	public String newCampaignURL=null;
	public String newQuoteUniqueName=null;
	public String FirstOppContactRecord=null;
	public String cloneOppULR=null;
	public String firstWindowHandle = null;
	public String newOppCreatedViaPostponeClone=null;
	public String newOppULR=null;
	public String randomString=null;
	public String contactEmail=null;
	public String JobStartDate1,JobEndDate1,Status1,tooltip1 = null;
	public String JobStartDate2,JobEndDate2,Status2,tooltip2 = null;
	public String JobStartDate3,JobEndDate3,Status3,tooltip3 = null;
	public String JobStartDate4,JobEndDate4,Status4,tooltip4 = null;
	public String JobStartDate5,JobEndDate5,Status5,tooltip5 = null;
	public String newA3KCase = null;	//"https://mh--uat.sandbox.lightning.force.com/lightning/r/Case/500DY000001ST6DYAW/view";
	public String contactURLForSampling = null;
	public String newlyGeneratedQuoteName = null;
	public String SEGSalesRepValidateInActiveOppcontactURL = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/006DY000002Qwk0YAC/view";
	public String SampleTestingURL = null; //"https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068b00001TNDUgAAP/view";
	public String CSOMCaseURL = null;
	public String CXGCaseURL = null;
	public String ArticleURL = null;
	public String DFCRequest = null;
	public String newE2CaseURL = null;
	public String new_QuoteURL = null;
	public String new_QuoteOppURL = null;
	public String DiscountPercentage = "15";
	public String ServiceAppointmentURL = null;
	public String SAURL = null;
	public String SA_Num = null;
	public String NewCXGCase = null;
	public String NewALEKSCase = null;
	public String MHES_Contact_URL = null;
	public String OppWithLostStage = null;
	public SessionId sessionDriver;
	public int failed_tc_count = 0;
	public int total_tc_count = 0;
	public int failedCases = 0;
	public int totalCases = 0;
	static String excelColumnName;

	static {
		String RANDOMCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder randomString = new StringBuilder();
		Random rnd = new Random();
		while (randomString.length() <= 8) { // length of the random string.
			int index = (int) (rnd.nextFloat() * RANDOMCHARS.length());
			randomString.append(RANDOMCHARS.charAt(index));

			Long.toHexString(Double.doubleToLongBits(Math.random()));
		}
		ACC_NAME_RANDOM = randomString.toString();

	}

	private WebConnector() {
		if (OR == null & xls == null & TestData == null & isTestExecutable == null) {
			try {
				OR = new Properties();
				FileInputStream locatorFile = new FileInputStream(OR_PATH);
				OR.load(locatorFile);

				TestData = new Properties();
				FileInputStream locatorFile2 = new FileInputStream(TESTDATA_PATH);
				TestData.load(locatorFile2);

				isTestExecutable = new Properties();
				FileInputStream locatorFile3 = new FileInputStream(ISTESTEXECUTABLE_PATH);
				isTestExecutable.load(locatorFile3);

				xls = new Xls_Reader(DATA_XL_PATH);
				browserName = getExcelValue("LoginTest").get(0).get("Browser");				
				xlsE2C_1 = new Xls_Reader(DATA_XL_PATH_E2C_1);
				browserName = getExcelValue("LoginTest").get(0).get("Browser");				
				xlsE2C_2 = new Xls_Reader(DATA_XL_PATH_E2C_2);
				browserName = getExcelValue("LoginTest").get(0).get("Browser");				
				xlsE2C_3 = new Xls_Reader(DATA_XL_PATH_E2C_3);
				browserName = getExcelValue("LoginTest").get(0).get("Browser");
				xlsE2C_4 = new Xls_Reader(DATA_XL_PATH_E2C_4);
				browserName = getExcelValue("LoginTest").get(0).get("Browser");
				xlsE2C_A3K = new Xls_Reader(DATA_XL_PATH_E2C_A3K);
				browserName = getExcelValue("LoginTest").get(0).get("Browser");
//				xlsE2C_Funtionalities = new Xls_Reader(DATA_XL_PATH_E2C_Functionalities);
//				browserName = getExcelValue("LoginTest").get(0).get("Browser");

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error while initializing the properties file");
			}
		}
	}

	/***********************
	 * Singleton
	 *************************************************/
	public static WebConnector getInstance() {
		if (wb == null)
			wb = new WebConnector();
		return wb;
	}

	public void closeSubTabs() {
		System.out.println("Closing case tabs..");
		Boolean subtab = isElementPresentFast("closeCaseTabs");
		int counter = 0; // Initialize counter
		while (subtab == true && counter < 10) { // Check condition for both subtab existence and counter limit
			clickLoop("closeCaseTabs");
			waitingTime(3000);
			subtab = isElementPresentFast("closeCaseTabs");
			counter++; // Increment counter
		}
	}
	
	public void closeAllNotificationPopups_nonEnglish() {
		System.out.println("Closing notification popups..");
		Boolean notificationpopup = isElementPresentFast("CloseNotificatioinPopups");
		while (notificationpopup == true) {
			clickLoop("CloseNotificatioinPopups");
			waitingTime(3000);
			notificationpopup = isElementPresentFast("CloseNotificatioinPopups");
		}
	}
	
	public void deleteruntimeopp() {
	Boolean oppdatapresent = isElementPresentFast("ShowOptionsDwnArrow");
	while (oppdatapresent == true)
	{
		waitForElementToBeClickable("ShowOptionsDwnArrow");
		click("ShowOptionsDwnArrow");
		waitingTime(1000);
		waitForElementToBeClickable("DeleteRecord");
		jsClick("DeleteRecord");
		waitingTime(1000);
		waitForElementToBeClickable("deleteBtn");
		jsClick("deleteBtn");
		waitingTime(8000);
		oppdatapresent = isElementPresentFast("ShowOptionsDwnArrow");
	}
	}

	public void closeCurrentWindow() {
		System.out.println("Current URL: " + driver.getCurrentUrl());
		driver.close();

	}

	/***********************************************************************************
	 ***************** Application Independent Functions *********************
	 ***********************************************************************************/

	public void openBrowser() {
		System.out.println("In opening browser..");
		String osname = System.getProperty("os.name");
		test.log(LogStatus.INFO, "Operating System: " + osname);
		test.log(LogStatus.INFO, "Opening Browser: " + browserName);

		if (!GRID_RUN) {
			System.out.println("Opening browser in Grid mode disabled.");
			if (browserName.equalsIgnoreCase("Chrome") && chDriver == null) {
				System.out.println("in open browser...333");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("--disable-notifications");
				options.addArguments("--disable-web-security");
//				options.addArguments("disable-popup-blocking");
//				options.setCapability("httpKeepAliveTimeout", 60);//Error occurred java.util.concurrent.TimeoutException
				options.setAcceptInsecureCerts(true);
				System.out.println("Accepted Chrome SSL Certification");
				if (osname.contains("Windows")) {
					System.out.println("OS is Windows. Browser launching...");
//					System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
					WebDriverManager.chromedriver().setup();
				} else {
					System.out.println("OS is Linux. Browser launching...");
					System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LINUX_PATH);
					options.addArguments("--start-maximized");
					options.addArguments("headless");
					options.addArguments("window-size=1920,1080");
					options.addArguments("disable-dev-shm-usage");
					options.addArguments("no-sandbox");
					options.addArguments("--disable-extensions");
					options.addArguments("--dns-prefetch-disable");
					options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
					options.addArguments("--disable-gpu");

				}
				driver = new ChromeDriver(options);
//				Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
//				String browserName = caps.getBrowserName();
//				System.out.println("Browser Name is:" + browserName);
//				String browserVersion = caps.getBrowserVersion();
//				System.out.println("Browser Version is:" + browserVersion);
				chDriver = driver;
				driver.manage().window().maximize();
				setDefaultImplicitWait();
				sessionDriver = ((ChromeDriver) driver).getSessionId();
				System.out.println("Chrome Driver Session id: " + sessionDriver.toString());
				test.log(LogStatus.PASS, "Browser Opened successfully");
				sessionDriver = ((ChromeDriver) driver).getSessionId();
				System.out.println("Driver Session Id::: " + sessionDriver);
			} else if (browserName.equalsIgnoreCase("IE") && ieDriver == null) {
				// System.setProperty("webdriver.ie.driver", IE_DRVER_PATH);
				InternetExplorerOptions ieoptions = new InternetExplorerOptions();
				ieoptions.setCapability(CapabilityType.BROWSER_NAME, "IE");
				ieoptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				ieoptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
				System.setProperty("webdriver.ie.driver", IE_DRVER_PATH);
				driver = new InternetExplorerDriver(ieoptions);
				ieDriver = driver;

				driver.manage().window().maximize();
				setDefaultImplicitWait();
				test.log(LogStatus.PASS, "Browser Opened successfully");
			}
		}

		else {
			System.out.println("Opening browser in Grid mode enabled.");
			ChromeOptions options = new ChromeOptions();
			// DesiredCapabilities cap = null;
			options.setAcceptInsecureCerts(true);

//			options.addArguments("headless");
//			options.addArguments("window-size=1920,1080");
//			options.addArguments("disable-dev-shm-usage");
//			options.addArguments("no-sandbox");
//			options.addArguments("window-size=1280,720");

			if (browserName.equalsIgnoreCase("Chrome")) {
				// cap = DesiredCapabilities.chrome();
				// cap.setBrowserName("chrome");
				// cap.setPlatform(org.openqa.selenium.Platform.LINUX);
			}
			try {
				driver = new RemoteWebDriver(new URL("https://10.242.139.37/ui/"), options); // UserName: Selenium_User
																								// Password:
																								// Selenium_Pass
//			driver = new RemoteWebDriver(new URL("http://ew1inbl6892.emhe.mhc:8000/wd/hub"), options);
//			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
				// driver = new
				// RemoteWebDriver(newURL("http://ew1inbl6892.emhe.mhc:8888/wd/hub"), cap);
				chDriver = driver;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Inside Open Browser catch");
				e.printStackTrace();
			}

			setDefaultImplicitWait();
			// driver.manage().window().maximize();
			Dimension d = new Dimension(1440, 900);
			driver.manage().window().setSize(d);
			sessionDriver = ((RemoteWebDriver) driver).getSessionId();
			System.out.println("Remote Driver Session id: " + sessionDriver.toString());

		}

	}

	public void setDefaultImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
	}

	public void setImplicitWait(long time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
		System.out.println("Setting current testcase name to => " + testCaseName);
	}

	public String getTestCaseName() {
		return this.testCaseName;
	}

	public String getBrowserName() {
		return this.browserName;
	}

	public void printLastTestResult(boolean isSuccess) {
		if (isSuccess)
			test.log(LogStatus.PASS, "Test Case Passed!");
		else
			reportFailure("Test Case Failed");
	}

	public void navigateTo(String testCaseName, String url) {
		String loginUrl = getExcelValue(testCaseName).get(0).get(url);
		System.out.println("Navigating to: " + url);
		test.log(LogStatus.INFO, "Navigating to: " + url);
		driver.navigate().to(loginUrl);
	}

	public void navigateTo_propertiesFile(String url) {
		String URL = getPropertiesFileData(url);
		System.out.println("Navigating to: " + URL);
		test.log(LogStatus.INFO, "Navigating to: " + URL);
		driver.navigate().to(URL);
	}

	public String getPropertiesFileData(String key) {
		String value = TestData.getProperty(key);
		return value;
	}

	public void navigateToURL(String url) {
		test.log(LogStatus.INFO, "Navigating to: " + url);
		System.out.println("Navigating to: " + url);
		driver.navigate().to(url);

	}

	public void navigateToURL_propertiesFile(String prop_data) {
		String url = getTestDataFromPropertiesFile(prop_data);
		test.log(LogStatus.INFO, "Navigating to: " + url);
		System.out.println("Navigating to: " + url);
		driver.navigate().to(url);
	}
	
	public void clickOnClearAllNotification()
	{
		if (isElementPresentFast("clearAllLink")) {
			System.out.println("Notification popup appearing.. so clearning it..");
			waitForElementToBeClickable("clearAllLink");
			click("clearAllLink");
			waitingTime(1000);
		} 
	}
	
	public void captureScreenShot()	{
	}

	public void takeScreenShot() {
		try {
			if (driver != null && sessionDriver != null) {
//        System.out.println("Inside takeScreenShot");
				Date d = new Date();
				String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
				String filePath = REPORTS_PATH + "screenshots//" + screenshotFile;
				// store screenshot in that file
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(filePath));

				test.log(LogStatus.INFO, test.addScreenCapture("screenshots//" + screenshotFile));
				waitingTime(2000);
			}
		}
//        catch(org.openqa.selenium.NoSuchSessionException e) {
//            System.out.println("In catch block..NoSuchSessionException");
//              waitingTime(2000);
//              setTestCaseName("LoginTest");
//              resetDriver();
//              openBrowser();
//              doDefaultLogin();
//              getUI();
//              check_Change_UserInterface();
//              waitingTime(2000);
//              setTestCaseName(testCaseName);
//        }
		catch (Exception e) {
			System.out.println("In catch block..final");
			e.printStackTrace();
//            refresh();
			waitingTime(8000);
			setTestCaseName("LoginTest");
			resetDriver();
			openBrowser();
			doDefaultLogin();
			getUI();
			check_Change_UserInterface();
			waitingTime(2000);
			setTestCaseName(testCaseName);
		}
	}

	public void getCurrentServerTime() {
		Date date = new Date();
		System.out.println(date.toString());
	}

	public void reportFailure(String failureMessage) {
		getCurrentServerTime();
		failed_tc_count++;
		System.out.println("Fail Test Count::: " + failed_tc_count);
		test.log(LogStatus.FAIL, failureMessage);
		System.out.println(failureMessage);
		takeScreenShot();
		Assert.fail(failureMessage);
		maximizeBrowserWindow(); // Adding this to maximize the browser window to avoid small window resolution issues
		checkFlowInterruptedPopup();
		closeOminiChannelPopup();
		closeUserSessionEndedPopup();
	}
	
	public void closeOminiChannelPopup()
	{
		if(isElementPresentFast("OmniChannelPopup"))
		{
			waitForElementToBeClickable("OmniChannelPopupClose");
			click("OmniChannelPopupClose");
			waitingTime(4000);
		}
	}
	
	public void closeUserSessionEndedPopup()
	{
		if(isElementPresentFast("UserSessionEndedPopupCloseBtn"))
		{
			waitForElementToBeClickable("UserSessionEndedPopupCloseBtn");
			click("UserSessionEndedPopupCloseBtn");
			waitingTime(4000);
		}
	}

	public WebElement getElement(String objectRepoElement) {
		return driver.findElement(By.xpath(OR.getProperty(objectRepoElement)));
	}

	public String getTestDataFromPropertiesFile(String value) {
		return TestData.getProperty(value);
	}

	public String getTestcaseExecutableStatusFromPropertiesFile(String value) {
		return isTestExecutable.getProperty(value);
	}

	public boolean isTestExecutable(String testCaseName) {
		String runmode = getTestcaseExecutableStatusFromPropertiesFile(testCaseName);
		if (runmode.equals("Y"))
			return true;
		else
			return false;
	}

	public WebElement getXpathElement(String xpath) {
		test.log(LogStatus.INFO, "Returning " + xpath);
		return driver.findElement(By.xpath(xpath));
	}

	public List<WebElement> getElements(String objectRepoElement) {
		return driver.findElements(By.xpath(OR.getProperty(objectRepoElement)));
	}

	public List<WebElement> getXpathElements(String objectRepoElement) {
		return driver.findElements(By.xpath(objectRepoElement));
	}

	public void type(String objectRepoElement, String excelColumn) {
		String text = getExcelValue(getTestCaseName()).get(0).get(excelColumn);
		System.out.println(excelColumn);
		if (!text.equals("")) {
			waitingTime(2000);
			getElement(objectRepoElement).clear();
			waitingTime(2000);
			getElement(objectRepoElement).sendKeys(text);
			test.log(LogStatus.INFO, "Value entered in " + objectRepoElement + " : " + text);
			System.out.println("Value entered in " + objectRepoElement + " : " + text);
		}
	}

	public void type_propertiesFile(String objectRepoElement, String prop_data) {
		String value = getTestDataFromPropertiesFile(prop_data);
		if (!value.equals("")) {
			getElement(objectRepoElement).clear();
			getElement(objectRepoElement).sendKeys(value);
			test.log(LogStatus.INFO, "Value entered in " + objectRepoElement + " : " + value);
			System.out.println("Value entered in " + objectRepoElement + " : " + value);
		}
	}

//	public void inputValue(String objectRepoElement) {
//		getElement(objectRepoElement).clear();
//		waitingTime(2000);
//		//driver.findElement(By.xpath(OR.getProperty(objectRepoElement))).sendKeys();
//		getElement(objectRepoElement).sendKeys();
//		System.out.println("ISBN inserted successfully");
//		//String text = getExcelValue(getTestCaseName()).get(0).get(excelColumn);
//		//System.out.println(excelColumn);
//		//if (!text.equals("")) {
//		//	test.log(LogStatus.INFO, "Value entered in " + objectRepoElement + " : " + text);
//		//	System.out.println("Value entered in " + objectRepoElement + " : " + text);
//		//}
//	}

	public void typeData(String objectRepoElement, String data) {
		if (!data.equals("")) {
			getElement(objectRepoElement).clear();
			getElement(objectRepoElement).sendKeys(data);
			test.log(LogStatus.INFO, "Value entered in " + objectRepoElement + " : " + data);
			System.out.println("Value entered in " + objectRepoElement + " : " + data);
		}
	}
	
	
	public void selectAllandReplaceText(String objectRepoElement, String data) {
		if (!data.equals("")) {
			getElement(objectRepoElement).sendKeys(Keys.CONTROL + "a");
			getElement(objectRepoElement).sendKeys(data);
		}
	}
	

	
	public void dragAnddrop(String SourceobjectRepoElement, String DestinationobjectRepoElement)
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(getElement(SourceobjectRepoElement), getElement(DestinationobjectRepoElement)).build().perform();
	}

	public void enterData(String objectRepoElement, String excelColumn) {
		String text = getExcelValue(getTestCaseName()).get(0).get(excelColumn);
		if (!text.equals("")) {
			waitingTime(2000);
			getElement(objectRepoElement).click();
			getElement(objectRepoElement).sendKeys(text);
			test.log(LogStatus.INFO, "Value entered in " + objectRepoElement + " : " + text);
		}
	}

	public void enterData_propertiesFile(String objectRepoElement, String prop_data) {
		String text = getTestDataFromPropertiesFile(prop_data);
		if (!text.equals("")) {
			waitingTime(2000);
			getElement(objectRepoElement).click();
			getElement(objectRepoElement).sendKeys(text);
			test.log(LogStatus.INFO, "Value entered in " + objectRepoElement + " : " + text);
		}
	}

	public void typeRandomstring(String objectRepoElement, String accountname) {

		if (!accountname.equals("")) {
			getElement(objectRepoElement).clear();
			waitingTime(2000);
			getElement(objectRepoElement).sendKeys(accountname);
			test.log(LogStatus.INFO, "Value entered in " + objectRepoElement + " : " + accountname);
		}
	}

	public void pressEnter(String objectRepoElement) {
		try {
			System.out.println("Pressing ENTER Key..");
			getElement(objectRepoElement).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			System.out.println("Inside pressEnter catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
		}
	}

	public void multiSelect(String field, String data) {
		WebElement listBoxXpath = getElement(field);
		String[] selectedvalues = getTestDataFromPropertiesFile(data).split(",");

		Actions actions = new Actions(driver);

		// Perform multi-select based on the values from TestData.properties file.
		for (String value : selectedvalues) {
			System.out.println(value);
			System.out.println("Picklist value is: " + getDynamicXpath_data("Text_Span", value, "end"));
			actions.keyDown(Keys.CONTROL)
					.click(listBoxXpath
							.findElement(By.xpath(OR.getProperty("Text_Span") + value + OR.getProperty("end"))))
					.keyUp(Keys.CONTROL).perform();
		}
	}

	public void click(String objectRepoElement) {
		try {
			test.log(LogStatus.INFO, "Clicking on " + objectRepoElement);
			System.out.println("Clicking on " + objectRepoElement);
			waitForElementToBeClickable(objectRepoElement);
			getElement(objectRepoElement).click();
		} catch (Exception e) {
			System.out.println("Inside click catch");
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void click2(String objectRepoElement) {
		try {
			test.log(LogStatus.INFO, "Clicking on " + objectRepoElement);
			System.out.println("Clicking on " + objectRepoElement);
			waitForElementToBeClickable(objectRepoElement);
			getElement(objectRepoElement).click();
		} catch (Exception e) {
			System.out.println("Inside click2 catch");
		}
	}

	public void clickHeader(String objectRepoElement) {
		try {
			test.log(LogStatus.INFO, "Clicking on " + objectRepoElement);
			waitForElementToBeClickable(objectRepoElement);
			jsClick(objectRepoElement);

		} catch (Exception e) {
			System.out.println("Inside clickHeader catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
//			reportFailure(objectRepoElement + " could not be clicked");
		}
	}

	public  String getCurrentDate(int daysToAdd) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, daysToAdd);
		Date futureDate = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");
		String formattedDate = dateFormat.format(futureDate);
		System.out.println("->"+formattedDate);
		return formattedDate;
	}

	public void clickXpath(String xpath) {
		try {
			test.log(LogStatus.INFO, "Clicking on " + xpath);
			System.out.println("Clicking on " + xpath);
			waitForXpathElementToBeClickable(xpath);
			getXpathElement(xpath).click();
		} catch (Exception e) {
			System.out.println("Inside clickXpath catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
		}
	}

	public void clickLoop(String objectRepoElement) {
		try {

			for (int i = 0; i < getElements(objectRepoElement).size(); i++) {
				System.out.println(getElements(objectRepoElement).size());
				if (getElements(objectRepoElement).get(i).isDisplayed()
						& getElements(objectRepoElement).get(i).isEnabled()) {
					getElements(objectRepoElement).get(i).click();
				}
			}
			test.log(LogStatus.PASS, "Element clicked: " + objectRepoElement);
			System.out.println("Element clicked: " + objectRepoElement);
		} catch (Exception e) {
			System.out.println("Inside clickLoop catch");
//			e.printStackTrace();
//			test.log(LogStatus.FAIL, "Test Case Failed");
//			reportFailure("Test Case Failed" + e.getMessage());
			return;		//to break the for loop exeuction
		}

	}

	public void clickLoopXpath(String xpath) {
		try {
			for (int i = 0; i < getXpathElements(xpath).size(); i++) {
				System.out.println(getXpathElements(xpath).size());
				if (getXpathElements(xpath).get(i).isDisplayed() & getXpathElements(xpath).get(i).isEnabled()) {
					getXpathElements(xpath).get(i).click();
				}
			}
			test.log(LogStatus.PASS, "Element clicked: " + xpath);
		} catch (Exception e) {
			System.out.println("Inside clickLoopXpath catch");
//			e.printStackTrace();
//			test.log(LogStatus.FAIL, "Test Case Failed");
//			reportFailure("Test Case Failed" + e.getMessage());
		}

	}

	public void waitAndClick(String objectRepoElement) {
		try {
			test.log(LogStatus.INFO, "Clicking on " + objectRepoElement);
			waitForElementToBeClickable(objectRepoElement);
			getElement(objectRepoElement).click();
		} catch (Exception e) {
			System.out.println("Inside waitAndclick catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			// reportFailure(objectRepoElement + " could not be clicked");
		}
	}

	public void isCheck(String objectRepoElement) {
		for (int i = 0; i < getElements(objectRepoElement).size() - 1; i++) {
			if (getElements(objectRepoElement).get(i).isDisplayed()
					& getElements(objectRepoElement).get(i).isEnabled()) {
				getElements(objectRepoElement).get(i).click();
				test.log(LogStatus.INFO, "Clicking on " + objectRepoElement);
			} else {
				System.out.println("No such element");
			}
		}

	}

	public void waitForElementToDisappear(String objectRepoElement) {
//		wait = new WebDriverWait(driver, 100);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40, 1));
		wait.until(ExpectedConditions.invisibilityOf(getElement(objectRepoElement)));
	}
	
	public void waitForElementToDisappearForLongtime(String objectRepoElement) {
//		wait = new WebDriverWait(driver, 100);
		wait = new WebDriverWait(driver, Duration.ofSeconds(300, 1));//5min
		wait.until(ExpectedConditions.invisibilityOf(getElement(objectRepoElement)));
	}

	public String getText(String objectRepoElement) {
		String text = null;
		try {
			test.log(LogStatus.INFO, "getting value from " + objectRepoElement);
			waitForElementToBeVisible(objectRepoElement);
			text = getElement(objectRepoElement).getText();
		} catch (Exception e) {
			if (isElementPresentsuperFast("DiscardChanges"))
			{
				click("DiscardChanges");
				waitingTime(5000);
			}
			System.out.println("Inside getText catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
//			reportFailure(objectRepoElement + " value could not be fetched");
		}
		return text;
	}

	public String openURLinNewTab(String URL) {
		// String text = null;
		try {
			driver.switchTo().newWindow(WindowType.TAB);
			driver.navigate().to(URL);
		} catch (Exception e) {
			System.out.println("Inside openURLinNewTab catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
//			reportFailure(" value could not be fetched");
		}
		return URL;
	}

	public String getAttribute(String objectRepoElement) {
		String text = null;
		try {
			test.log(LogStatus.INFO, "getting value from " + objectRepoElement);
			waitForElementToBeVisible(objectRepoElement);
			text = getElement(objectRepoElement).getAttribute("value");
			test.log(LogStatus.INFO, "Value Fetched in " + objectRepoElement + " : " + text);
		} catch (Exception e) {
			System.out.println("Inside getAttribute catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			// reportFailure(objectRepoElement + " value could not be fetched");
		}
		return text;
	}

	public String forecastOrderDate(String objectRepoElement) {
		String OrderDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		GregorianCalendar gc = new GregorianCalendar();

		try {
			String closedate = getAttribute(objectRepoElement);
			Date d = sdf.parse(closedate);
			gc.setTime(d);
			int dayBefore = gc.get(Calendar.DAY_OF_YEAR);
			gc.roll(Calendar.DAY_OF_YEAR, -1);
			int dayAfter = gc.get(Calendar.DAY_OF_YEAR);
			if (dayAfter > dayBefore) {
				gc.roll(Calendar.YEAR, -1);
			}
			gc.get(Calendar.DATE);
			Date yesterday = gc.getTime();
			OrderDate = sdf.format(yesterday);

		} catch (Exception e) {
			System.out.println("Inside foreCastOderdate catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			// reportFailure(objectRepoElement + " value could not be fetched");
		}
		return OrderDate;
	}

	public String frsdOrderDate(String objectRepoElement) {
		String OrderDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		GregorianCalendar gc = new GregorianCalendar();

		try {
			String priordate = getAttribute(objectRepoElement);
			Date d = sdf.parse(priordate);
			gc.setTime(d);

			/*
			 * int dayBefore = gc.get(Calendar.DAY_OF_YEAR); gc.roll(Calendar.DAY_OF_YEAR,
			 * +1); int dayAfter = gc.get(Calendar.DAY_OF_YEAR); if(dayAfter < dayBefore) {
			 * gc.roll(Calendar.YEAR, +1); } gc.get(Calendar.DATE); Date yesterday =
			 * gc.getTime(); gc.setTime(yesterday);
			 */

			gc.add(Calendar.YEAR, 6);
			Date prioryear = gc.getTime();
			OrderDate = sdf.format(prioryear);

		} catch (Exception e) {
			System.out.println("Inside frsOrderDate catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			// reportFailure(objectRepoElement + " value could not be fetched");
		}
		return OrderDate;
	}

	public String frsdOrderYear(String objectRepoElement) {
		String OrderDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		GregorianCalendar gc = new GregorianCalendar();

		try {
			String priordate = getAttribute(objectRepoElement);
			Date d = sdf.parse(priordate);
			gc.setTime(d);

			/*
			 * int dayBefore = gc.get(Calendar.DAY_OF_YEAR); gc.roll(Calendar.DAY_OF_YEAR,
			 * -1); int dayAfter = gc.get(Calendar.DAY_OF_YEAR); if(dayAfter > dayBefore) {
			 * gc.roll(Calendar.YEAR, -1); } gc.get(Calendar.DATE); Date yesterday =
			 * gc.getTime(); gc.setTime(yesterday);
			 */

			gc.add(Calendar.YEAR, -6);
			Date prioryear = gc.getTime();
			OrderDate = sdf.format(prioryear);

		} catch (Exception e) {
			System.out.println("Inside frsOrderYear catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			// reportFailure(objectRepoElement + " value could not be fetched");
		}
		return OrderDate;
	}

	public String getTextLoop(String objectRepoElement) {
		String text = null;
		for (int i = 0; i < getElements(objectRepoElement).size(); i++) {
			if (getElements(objectRepoElement).get(i).isDisplayed() & getElements(objectRepoElement).get(i).isEnabled())
				text = getElements(objectRepoElement).get(i).getText();
		}
		return text;
	}

	public String getDynamicXpath(String locator1, String excelColumnName, String locator2) {
		String objectRepoElement = OR.getProperty(locator1)
				+ getExcelValue(getTestCaseName()).get(0).get(excelColumnName) + OR.getProperty(locator2);
		return objectRepoElement;
	}

	public String getDynamicXpath_data(String locator1, String data, String locator2) {
		String objectRepoElement = OR.getProperty(locator1) + data + OR.getProperty(locator2);
		return objectRepoElement;
	}

	public String getDynamicXpath_propertiesFile(String locator1, String prop_data, String locator2) {
		String objectRepoElement = OR.getProperty(locator1) + getTestDataFromPropertiesFile(prop_data)
				+ OR.getProperty(locator2);
		return objectRepoElement;
	}

	public String getDynamicXpathForDropdownSelection(String locator1, String excelColumnName, String locator2) {
		String objectRepoElement = OR.getProperty(locator1)
				+ getExcelValueForDropdownValidation(getTestCaseName()).get(0).get(excelColumnName)
				+ OR.getProperty(locator2);
		return objectRepoElement;
	}

	public String getDynamicXpathForDropdownSelection_propertiesFile(String locator1, String prop_data,
			String locator2) {
		String objectRepoElement = OR.getProperty(locator1)
				+ getExcelValueForDropdownValidation(getTestDataFromPropertiesFile(prop_data))
				+ OR.getProperty(locator2); // NEED TO CORRECT
		return objectRepoElement;
	}

//	public String getDynamicXpathIndexed(String locator1, String excelColumnName, String locator2,int i) {
//		String objectRepoElement = "("+OR.getProperty(locator1)
//				+ getExcelValue(getTestCaseName()).get(0).get(excelColumnName) + OR.getProperty(locator2)+")["+i+"]";
//		return objectRepoElement;
//	}

	public String getDynamicXpath(String locator1, String excelColumnName1, String locator2, String excelColumnName2,
			String locator3) {
		String objectRepoElement = OR.getProperty(locator1)
				+ getExcelValue(getTestCaseName()).get(0).get(excelColumnName1) + OR.getProperty(locator2)
				+ getExcelValue(getTestCaseName()).get(0).get(excelColumnName2) + OR.getProperty(locator3);
		return objectRepoElement;
	}

	public String getDynamicXpath_propertiesFile(String locator1, String prop_data1, String locator2, String prop_data2,
			String locator3) {
		String objectRepoElement = OR.getProperty(locator1) + getTestDataFromPropertiesFile(prop_data1)
				+ OR.getProperty(locator2) + getTestDataFromPropertiesFile(prop_data2) + OR.getProperty(locator3);
		return objectRepoElement;
	}

	public String getDynamicXpathData(String locator1, String data, String locator2, String excelColumnName2,
			String locator3) {
		String objectRepoElement = OR.getProperty(locator1) + data + OR.getProperty(locator2)
				+ getExcelValue(getTestCaseName()).get(0).get(excelColumnName2) + OR.getProperty(locator3);
		return objectRepoElement;
	}

	public String getDynamicXpathData_propertiesFile(String locator1, String data, String locator2, String prop_data,
			String locator3) {
		String objectRepoElement = OR.getProperty(locator1) + data + OR.getProperty(locator2)
				+ getTestDataFromPropertiesFile(prop_data) + OR.getProperty(locator3);
		return objectRepoElement;
	}

//	public String getXpath(String locator1, String excelColumnName1, String excelColumnName2, String locator2) {
//		String objectRepoElement = OR.getProperty(locator1)
//				+ getExcelValue(getTestCaseName()).get(0).get(excelColumnName1) + " "
//				+ getExcelValue(getTestCaseName()).get(0).get(excelColumnName2) + OR.getProperty(locator2);
//		return objectRepoElement;
//	}

	public String getDynamicXpathData(String locator1, String data, String locator2) {
		String objectRepoElement = OR.getProperty(locator1) + data + OR.getProperty(locator2);
		return objectRepoElement;
	}

	public String getDynamicXpathData_propertiesFile(String locator1, String prop_data, String locator2) {
		String objectRepoElement = OR.getProperty(locator1) + getTestDataFromPropertiesFile(prop_data)
				+ OR.getProperty(locator2);
		return objectRepoElement;
	}

	public void clickDynamic(String locator1, String excelColumnName, String locator2) {
		String xpath = null;
		try {
			waitingTime(6000);
			xpath = OR.getProperty(locator1) + getExcelValue(getTestCaseName()).get(0).get(excelColumnName)
					+ OR.getProperty(locator2);
			test.log(LogStatus.INFO, "Clicking on " + xpath);
			waitingTime(4000);
			jsClickXpath(xpath);
		} catch (Exception e) {
			System.out.println("Inside clickDynamic catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			// reportFailure(xpath + " could not be clicked");
		}
	}

	public void clickDynamic_propertiesFile(String locator1, String prop_data, String locator2) {
		String xpath = null;
		try {
			waitingTime(6000);
			xpath = OR.getProperty(locator1) + getTestDataFromPropertiesFile(prop_data) + OR.getProperty(locator2);
			test.log(LogStatus.INFO, "Clicking on " + xpath);
			waitingTime(4000);
			jsClickXpath(xpath);
		} catch (Exception e) {
			System.out.println("Inside clickDynamic_propertiesFile catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			// reportFailure(xpath + " could not be clicked");
		}
	}

	public void clickDynamicData(String locator1, String data, String locator2) {
		String xpath = null;
		try {
			waitingTime(6000);
			xpath = OR.getProperty(locator1) + data + OR.getProperty(locator2);
			test.log(LogStatus.INFO, "Clicking on " + xpath);
			waitingTime(4000);
			jsClickXpath(xpath);
		} catch (Exception e) {
			System.out.println("Inside clickDynamicDataFile catch");
			xpath = OR.getProperty(locator1) + data + OR.getProperty(locator2);
			test.log(LogStatus.INFO, "Clicking on " + xpath);
			waitingTime(4000);
			jsClickXpath(xpath);
			e.printStackTrace();
//			test.log(LogStatus.FAIL, "Test Case Failed");
//			reportFailure("Test Case Failed" + e.getMessage());
		}
	}

	public void clickDynamicOpportunity(String locator1, String excelColumnName, String locator2) {
		String xpath = null;
		try {
			waitingTime(4000);
			xpath = OR.getProperty(locator1) + getExcelValue(getTestCaseName()).get(0).get(excelColumnName)
					+ OR.getProperty(locator2);
			test.log(LogStatus.INFO, "Clicking on " + xpath);
			jsClickXpath(xpath);
		} catch (Exception e) {
			System.out.println("Inside clickDynamicOpportunity catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			// reportFailure(xpath + " could not be clicked");
		}
	}

	public void clickDynamicOpportunity_propertiesFile(String locator1, String prop_data, String locator2) {
		String xpath = null;
		try {
			waitingTime(4000);
			xpath = OR.getProperty(locator1) + getTestDataFromPropertiesFile(prop_data) + OR.getProperty(locator2);
			test.log(LogStatus.INFO, "Clicking on " + xpath);
			jsClickXpath(xpath);
		} catch (Exception e) {
			System.out.println("Inside clickDynamicOpportunity_propertiesFile catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			// reportFailure(xpath + " could not be clicked");
		}
	}

	public void clickDynamicXpath(String locator1, String excelColumnName, String locator2) {
		String xpath = null;
		try {
			waitingTime(4000);
			xpath = OR.getProperty(locator1) + getExcelValue(getTestCaseName()).get(0).get(excelColumnName)
					+ OR.getProperty(locator2);
			test.log(LogStatus.INFO, "Clicking on " + xpath);
			jsClickXpath(xpath);

		} catch (Exception e) {
			System.out.println("Inside clickDynamicXpath catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
		}
	}

	public void clickDynamicXpath_propertiesFile(String locator1, String prop_data, String locator2) {
		String xpath = null;
		try {
			waitingTime(4000);
			xpath = OR.getProperty(locator1) + getTestDataFromPropertiesFile(prop_data) + OR.getProperty(locator2);
			test.log(LogStatus.INFO, "Clicking on " + xpath);
			jsClickXpath(xpath);

		} catch (Exception e) {
			System.out.println("Inside clickDynamicXpath_propertiesFile catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			// reportFailure(xpath + " could not be clicked");
		}
	}
	
	public void clickDynamicXpath_data(String locator1, String data, String locator2) {
		String xpath = null;
		try {
			waitingTime(4000);
			xpath = OR.getProperty(locator1) + data + OR.getProperty(locator2);
			test.log(LogStatus.INFO, "Clicking on " + xpath);
			jsClickXpath(xpath);

		} catch (Exception e) {
			System.out.println("Inside clickDynamicXpath_propertiesFile catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			// reportFailure(xpath + " could not be clicked");
		}
	}

	public void clickDynamicUsingAccName(String locator1, String data, String locator2) {
		String xpath = null;
		try {
			waitingTime(2000);
			xpath = OR.getProperty(locator1) + data + OR.getProperty(locator2);
			test.log(LogStatus.INFO, "Clicking on " + xpath);
			jsClickXpath(xpath);
		} catch (Exception e) {
			System.out.println("Inside clickDynamicUsingAccName catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			// reportFailure(xpath + " could not be clicked");
		}
	}

	public void jsClickXpath(String xpath) {
		for (int i = 0; i < getXpathElements(xpath).size(); i++) {
			if (getXpathElements(xpath).get(i).isDisplayed() & getXpathElements(xpath).get(i).isEnabled()) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", getXpathElements(xpath).get(i));
			}
		}

	}

	public void jsClick(String objectRepoElement) {
		test.log(LogStatus.INFO, "Clicking on " + objectRepoElement);
		System.out.println("Clicking on " + objectRepoElement);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(objectRepoElement));
	}

	public void jsClickNewTab() {
		((JavascriptExecutor) driver).executeScript("window.open();");
	}
	
	public void openURLonSameWindow(String URL) {
		// Execute JavaScript to open a new URL in the same tab
        ((JavascriptExecutor) driver).executeScript("window.location.href='" + URL + "';");
	}

	public boolean isElementPresent(String objectRepoElement) {
		try {
			waitingTime(5000);
			int count = getElements(objectRepoElement).size();
			if (count == 0)
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void close() {
		driver.close();
//		System.out.println("Browser is closed successfully!!!");
	}

	public void dropdownListClick(String objectRepoElement) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(objectRepoElement)).click().perform();
	}

	public void pressEscapeKey() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();
	}

	public void pressDownKey() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).perform();
	}
	
	public void pressUpKey() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_UP).perform();
	}
	
	public void pressEnterKey() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}

	public void moveTab(String objectRepoElement) {
		getElement(objectRepoElement).sendKeys(Keys.TAB);

	}

	public boolean isTextPresent(String objectRepoElement, String excelColumn) {

		try {
			String text = getExcelValue(testCaseName).get(0).get(excelColumn);
			if (getTextLoop(objectRepoElement).contains(text))
				return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public boolean isTextPresent_propertiesFile(String objectRepoElement, String prop_data) {

		try {
			String text = getTestDataFromPropertiesFile(prop_data);
			if (getTextLoop(objectRepoElement).contains(text))
				return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public boolean isElementPresentXpath(String xpathExpression) {
		try {
			int count = driver.findElements(By.xpath(xpathExpression)).size();
			if (count == 0)
				return false;
			else
				return true;
		} catch (Exception e) {
			System.out.println("Inside isElementPresentXpath catch");
			e.printStackTrace();
//			takeScreenShot();
			return false;
		}
	}
	
	public boolean isElementPresentXpathFast(String xpathExpression) {
		try {
			setImplicitWait(5);
			int count = driver.findElements(By.xpath(xpathExpression)).size();
			setDefaultImplicitWait();
			if (count == 0)
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementPresentFast(String objectRepoElement) {
		try {
			setImplicitWait(5);
			int count = getElements(objectRepoElement).size();
			setDefaultImplicitWait();
			if (count == 0)
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementPresentsuperFast(String objectRepoElement) {
		try {
			setImplicitWait(2);
			int count = getElements(objectRepoElement).size();
			// setDefaultImplicitWait();
			if (count == 0)
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean waitForElementToBeVisible(String objectRepoElement) {
//		wait = new WebDriverWait(driver, 90);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20, 1));
		try {
			wait.until(ExpectedConditions.visibilityOf(getElement(objectRepoElement)));
			test.log(LogStatus.PASS, "Element is visible");
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean retryingWait(String objectRepoElement) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitForElementToBeVisible(objectRepoElement);
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void waitForElementsToBeVisible(String objectRepoElement) {
		int noOfElements = getElements(objectRepoElement).size();
		try {
			for (int i = 0; i < noOfElements; i++) {
				if (getElements(objectRepoElement).get(i).isDisplayed()
						& getElements(objectRepoElement).get(i).isEnabled()) {
//					wait = new WebDriverWait(driver, 30);
					wait = new WebDriverWait(driver, Duration.ofSeconds(20, 1));
					wait.until(ExpectedConditions.visibilityOf(getElements(objectRepoElement).get(i)));
				}
			}
		} catch (Exception e) {
			System.out.println("Inside waitForElementsToBeVisible catch");
			System.out.println("Waiting for element to be visible");
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	
	public int getElementCount(String objectRepoElement) {
			int noOfElements = getElements(objectRepoElement).size();
			return noOfElements;
	}

	public boolean waitForElementToBeClickable(String objectRepoElement) {
//		wait = new WebDriverWait(driver, 90);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20, 1));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(getElement(objectRepoElement)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean waitForElementToBeClickableLongerDuration(String objectRepoElement) {
//		wait = new WebDriverWait(driver, 90);
		wait = new WebDriverWait(driver, Duration.ofSeconds(180, 1));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(getElement(objectRepoElement)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean waitForXpathElementToBeClickable(String objectRepoElement) {
//		wait = new WebDriverWait(driver, 40);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40, 1));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(getXpathElement(objectRepoElement)));
			return true;
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getMessage());
			return false;
		}
	}

	public boolean waitForXpathElementToBeVisible(String xpath) {
//		wait = new WebDriverWait(driver, 30);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40, 1));
		try {
			wait.until(ExpectedConditions.visibilityOf(getXpathElement(xpath)));
			return true;
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getMessage());
			return false;
		}
	}

	public void waitingTime(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds);
		} catch (Exception e) {

		}
	}
	
	public void checkFlowInterruptedPopup()
	{
		System.out.println("I am inside checkFlowInterruptedPopup method");
		try {
			if (isElementPresentFast("loginPopUpNew")) {
				System.out.println("Flow interrupted popup exit..");
				click2("loginPopUpNew");
				waitingTime(2000);
		}
		}
		catch(Exception e)
		{
			System.out.println("I am inside checkFlowInterruptedPopup catch block");
			clickLoop("loginPopUpNew");
			waitingTime(2000);
		}
	}
	
	public void checkOmniChannelPopup() {
		System.out.println("I am inside OmniChannelPopup method");
		if(isElementPresentFast("OmniChannelPopup"))
		{
			System.out.println("OmniChannelPopup exist..");
			waitForElementToBeClickable("OmniChannelPopupClose");
			click("OmniChannelPopupClose");
			waitingTime(2000);
		}
	}

	public void quit() {
		if (driver != null)
			driver.quit();
	}

	public void navigateBack() {
		driver.navigate().back();

	}

	public void maximizeBrowserWindow() {
		System.out.println("Maximizing the browser window..");
		driver.manage().window().maximize();
	}

	public void switchToFrame(String objectRepoElement) {
		try {
			System.out.println("Inside switchToFrame");
			driver.switchTo().frame(getElement(objectRepoElement));
		} catch (Exception e) {
			System.out.println("Inside switchToFrame catch");
//			switchOutOfFrame();
//			test.log(LogStatus.FAIL, "Test Case Failed");
//			reportFailure("Test Case Failed" + e.getMessage());
		}
	}

	public void switchToMultipleFrame(String objectRepoElement) {
		System.out.println("Inside switchToMultipleFrame method");
		for (int i = 0; i < getElements(objectRepoElement).size(); i++) {
			try {
				if (getElements(objectRepoElement).get(i).isDisplayed()
						& getElements(objectRepoElement).get(i).isEnabled()) {
					driver.switchTo().frame(getElements(objectRepoElement).get(i));
				}
			} catch (Exception e) {
				System.out.println("Inside switchToMultipleFrame catch");
				e.printStackTrace();
				test.log(LogStatus.FAIL, "Test Case Failed");
				reportFailure("Test Case Failed" + e.getMessage());
			}
		}
	}

	public void switchOutOfFrame() {
		try {
			System.out.println("Inside switchOutOfFrame");	
			driver.switchTo().parentFrame();
		}
		catch(Exception e)
		{
			System.out.println("Inside switchOutOfFrame catch");
			e.printStackTrace();
		}
	}

	public void selectDropdownText(String objectRepoElement, String excelCoulumn) {
		String text = getExcelValue(testCaseName).get(0).get(excelCoulumn);
		if (!text.isEmpty()) {
			test.log(LogStatus.INFO, "Searching text: " + text + " in " + objectRepoElement + " dropdown");
			Select dropdown = new Select(getElement(objectRepoElement));
			waitingTime(4000);
			dropdown.selectByVisibleText(text);
			test.log(LogStatus.PASS, "Selected option: " + text);
		}
	}
	
	public void selectDropdownText_Data(String objectRepoElement, String data) {
		String text = data;
		if (!text.isEmpty()) {
			test.log(LogStatus.INFO, "Searching text: " + text + " in " + objectRepoElement + " dropdown");
			Select dropdown = new Select(getElement(objectRepoElement));
			waitingTime(4000);
			dropdown.selectByVisibleText(text);
			test.log(LogStatus.PASS, "Selected option: " + text);
		}
	}

	public void selectDropdownText_propertiesFile(String objectRepoElement, String prop_data) {
		String text = getTestDataFromPropertiesFile(prop_data);
		if (!text.isEmpty()) {
			test.log(LogStatus.INFO, "Searching text: " + text + " in " + objectRepoElement + " dropdown");
			Select dropdown = new Select(getElement(objectRepoElement));
			waitingTime(4000);
			dropdown.selectByVisibleText(text);
			test.log(LogStatus.PASS, "Selected option: " + text);
		}
	}

	public void selectDropdown(String objectRepoElement, String excelCoulumn) {
		String text = getExcelValue(testCaseName).get(0).get(excelCoulumn);
		if (!text.isEmpty()) {
			test.log(LogStatus.INFO, "Searching text: " + text + " in " + objectRepoElement + " dropdown");
			click(objectRepoElement);
			waitingTime(2000);
			String dropdown = getDynamicXpathData("anchorText", text, "end");
			clickXpath(dropdown);
			test.log(LogStatus.PASS, "Selected option: " + text);
		}
	}

	public void selectDropdown_propertiesFile(String objectRepoElement, String prop_data) {
		String text = getTestDataFromPropertiesFile(prop_data);
		if (!text.isEmpty()) {
			test.log(LogStatus.INFO, "Searching text: " + text + " in " + objectRepoElement + " dropdown");
			click(objectRepoElement);
			waitingTime(2000);
			String dropdown = getDynamicXpathData("anchorText", text, "end");
			clickXpath(dropdown);
			test.log(LogStatus.PASS, "Selected option: " + text);
		}
	}

//	public void selectDropdownNewXpath(String objectRepoElement, String excelCoulumn) {
//		String text = getExcelValue(testCaseName).get(0).get(excelCoulumn);
//		if (!text.isEmpty()) {
//			test.log(LogStatus.INFO, "Searching text: " + text + " in " + objectRepoElement + " dropdown");
//			click(objectRepoElement);
//			waitingTime(2000);
//			String dropdown = getDynamicXpathData("anchorTextNew", text, "endNew");
//			clickXpath(dropdown);
//			test.log(LogStatus.PASS, "Selected option: " + text);
//		}
//	}

	@SuppressWarnings("unchecked")
	public ArrayList<Hashtable<String, String>> getExcelValue(String testCaseName) {

		Object[][] data = DataUtil.getData(xls, testCaseName, TESTDATA_SHEET);
		ArrayList<Hashtable<String, String>> dataList = null;
		for (int i = 0; i < data.length; i++) {
			dataList = new ArrayList<Hashtable<String, String>>();
			dataList.add((Hashtable<String, String>) data[i][0]);
		}
		return dataList;

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Hashtable<String, String>> getExcelValueForDropdownValidation(String testCaseName) {

		Object[][] data = DataUtil.getData(xls, testCaseName, TESTDROPDOWNVALUES_SHEET);
		ArrayList<Hashtable<String, String>> dataList = null;
		for (int i = 0; i < data.length; i++) {
			dataList = new ArrayList<Hashtable<String, String>>();
			dataList.add((Hashtable<String, String>) data[i][0]);
		}
		return dataList;

	}

	public String getValueByColumnName(String columnName) {
		return getExcelValue(testCaseName).get(0).get(columnName);
	}

	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(1000);
	}

	public String getRandomString() {
		String RANDOMCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder randomString = new StringBuilder();
		Random rnd = new Random();
		while (randomString.length() <= 8) { // length of the random string.
			int index = (int) (rnd.nextFloat() * RANDOMCHARS.length());
			randomString.append(RANDOMCHARS.charAt(index));
		}
		String ranStr = randomString.toString();
		return ranStr;
	}

	public void selectCheckbox(String objectRepoElement, String testCaseName) {
		String doSelect = getExcelValue(testCaseName).get(0).get(objectRepoElement);
		if (doSelect.equals("Y")) {
			click(objectRepoElement);
			test.log(LogStatus.PASS, "Checkbox selected for " + objectRepoElement);
		}
	}

	public void hoverAndClick(String objectRepoElement) {
		Actions mouse = new Actions(driver);
		mouse.moveToElement(getElement(objectRepoElement)).click().build().perform();
	}

	public void scrollToElement(String objectRepoElement) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				getElement(objectRepoElement));
		waitingTime(1000);
	}

	public void scrollToXpathElement(String xpath) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getXpathElement(xpath));
		waitingTime(1000);
	}

	public void ScrollTillPageEnd() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		waitingTime(1000);
	}

	public void navigateToSetupPage(String URL) {
		driver.navigate().to(URL);
	}

	public void switchToLastWindow() {
		System.out.println("Switching To Last Window..");
		Set<String> windowIds = driver.getWindowHandles();

		Iterator<String> it = windowIds.iterator();
		String parentWinID = it.next();
		String childWinID = null;
		while (it.hasNext()) {
			if (childWinID != parentWinID)
				childWinID = it.next();
		}
		driver.switchTo().window(childWinID);
	}
	
	public String getFirstWindow() {
		System.out.println("Getting First Window Detail..");
		Set<String> windowIds = driver.getWindowHandles();
		String firstWindowHandle = (String) windowIds.toArray()[0];
		return firstWindowHandle;
	}

	public void switchToFirstWindow() {
		/*System.out.println("Switching To First Window..");
		Set<String> windowIds = driver.getWindowHandles();
		String firstWindowHandle = (String) windowIds.toArray()[0];*/
		driver.switchTo().window(getFirstWindow());
	}
	
	public String getFirstWin() {
		System.out.println("Getting First Window Detail..");
		Set<String> windowIds = driver.getWindowHandles();
		String firstWindowHandle = (String) windowIds.toArray()[0];
		return firstWindowHandle;
	}

	public void switchToFirstWin(String firstWindowHandle) {
		/*System.out.println("Switching To First Window..");
		Set<String> windowIds = driver.getWindowHandles();
		String firstWindowHandle = (String) windowIds.toArray()[0];*/
		driver.switchTo().window(firstWindowHandle);
	}
	
	public void closeAllWinExceptFirstWin() {
		System.out.println("Closeing all child window except current active window");
	    String originalHandle = driver.getWindowHandle();
	    for(String handle : driver.getWindowHandles()) {
	        if (!handle.equals(originalHandle)) {
	            driver.switchTo().window(handle);
	            driver.close();
	        }
	    }
	    driver.switchTo().window(originalHandle);
	}

//	public void closeAllChildWindows() {
//
//	    String originalHandle = driver.getWindowHandle();
//
//	    for(String handle : driver.getWindowHandles()) {
//	        if (!handle.equals(originalHandle)) {
//	            driver.switchTo().window(handle);
//	            driver.close();
//	        }
//	    }
//	    System.out.println("Closed all child windows");
//	    driver.switchTo().window(originalHandle);
//	}

	/***********************************************************************************
	 ***************** Application Dependent Functions ***********************
	 ***********************************************************************************/

	public void doDefaultLogin() {
		try {
			System.out.println("doing default login..");
			navigateTo_propertiesFile("loginUrl");
			type_propertiesFile("loginUsername", "UserName");
			type_propertiesFile("loginPassword", "Password");
			click("loginButton");
			check_Change_UserInterface();
		} catch (Exception e) {
			System.out.println("Inside toDefaultLogin catch");
			e.printStackTrace();
//			test.log(LogStatus.FAIL, "Test Case Failed");
//			reportFailure("Test Case Failed" + e.getMessage());
		}
	}

	public void doDefaultUATLogin() {
		try {
			System.out.println("Doing default UAT login");
			waitingTime(5000);
			waitForElementToBeVisible("loginUsername");
			type_propertiesFile("loginUsername", "UserName");
			type_propertiesFile("loginPassword", "Password");
			click("loginButton");
			waitingTime(10000);
			checkFlowInterruptedPopup();
			check_Change_UserInterface();
		} catch (Exception e) {
			System.out.println("Inside doDefaultUATLogin catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
		}
	}

	public void check_Change_UserInterface() {
//		takeScreenShot();
		test.log(LogStatus.INFO, "Checking the user interface");
		System.out.println("Checking the user interface");
		if (getUI().contains("Lightning")) {
			test.log(LogStatus.INFO, "UI value in the TestData properties file: " + getUI());
			test.log(LogStatus.INFO, "Checking the currently logged in UI");
			if (browserName.equalsIgnoreCase("IE"))
				waitingTime(5000);
			boolean isLightning = isElementPresent("searchTextL");
			if (!isLightning) {
				test.log(LogStatus.INFO, "Classic Detected! Switching to Lightning");
				if (isElementPresent("lightning")) {
					click("lightning");
				} else {
//					takeScreenShot();
					click("loginSalesrep");
				}
				test.log(LogStatus.INFO, "Clicked on the Lightning link");
				isLightning = isElementPresent("searchTextL");
				if (isLightning) {
					test.log(LogStatus.PASS, "Successfully switched to the lightning view");
				} else {
					test.log(LogStatus.FAIL, "Test Case Failed");
					reportFailure("Error faced while switching to the lightning view");
				}

			}
		} else if (getUI().contains("Classic")) {
			test.log(LogStatus.INFO, "UI value in the TestData properties file: " + getUI());
			test.log(LogStatus.INFO, "Checking the currently logged in UI");
			boolean isClassic = isElementPresent("searchTextC");
			if (!isClassic) {
				test.log(LogStatus.INFO, "Lightning Detected! Switching to Classic");
				waitForElementToBeVisible("userIcon");
				click("userIcon");
				test.log(LogStatus.INFO, "Clicked on the User Logo");
				waitingTime(2000);
				if (getBrowserName().equalsIgnoreCase("IE"))
					jsClick("classic");
				else
					getElement("classic").click();
				test.log(LogStatus.INFO, "Clicked on Classic link");
				waitForElementToBeVisible("searchTextC");
				isClassic = isElementPresent("searchTextC");
				if (isClassic)
					test.log(LogStatus.PASS, "Successfully switched to the classic view");
				else
					test.log(LogStatus.FAIL, "Test Case Failed");
				reportFailure("Error faced while switching to the classic view");
			}
		} else {
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("User Interface should either be Classic or Lightning");
		}
		setImplicitWait(5);

		checkFlowInterruptedPopup();
		setDefaultImplicitWait();
	}

	public void switchTo_Classic_UserInterface() {
		waitingTime(10000);
		boolean isLightningMode = isElementPresent("searchTextL");
		if (isLightningMode) {
			test.log(LogStatus.INFO, "Lightning Detected! Switching to Classic");
			System.out.println("Lightning Detected! Switching to Classic");
			waitingTime(25000);
			waitForElementToBeVisible("userIcon");
			click("userIcon");
			waitForElementToBeVisible("classic");
			jsClick("classic");
			waitingTime(5000);
		} else {
			System.out.println("Already in classic mode...");
		}
	}

	public String getUI() {
//		String ui = getExcelValue("LoginTest").get(0).get("User Interface");
		String ui = getTestDataFromPropertiesFile("User_Interface");
		if (!ui.isEmpty()) {
			this.userInterface = getExcelValue("LoginTest").get(0).get("User Interface");
//			this.userInterface = getTestDataFromPropertiesFile("User_Interface");
		} else {
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed");
			// reportFailure("User Interface value should either be Classic or Lightning");
		}
		return userInterface;
	}

	public void search(String excelColumnName) {
		String excelValue = getExcelValue(getTestCaseName()).get(0).get(excelColumnName);
		{
			getElement("globalSearch").click();
			waitingTime(2000);
			getElement("globalsearchadvance").sendKeys(excelValue);
			waitingTime(3000);
//			takeScreenShot();
			waitingTime(3000);
			getElement("globalsearchadvance").sendKeys(Keys.ENTER);
			waitingTime(6000);
		}
	}

	public void search_propertiesFile(String prop_data) {
		String value = getTestDataFromPropertiesFile(prop_data);
		{
			getElement("globalSearch").click();
			waitingTime(2000);
			getElement("globalsearchadvance").sendKeys(value);
			waitingTime(3000);
//			takeScreenShot();
			waitingTime(3000);
			getElement("globalsearchadvance").sendKeys(Keys.ENTER);
			waitingTime(6000);
		}
	}

	public void search_data(String caseDetails) {
		System.out.println("Value to put in Global Search " + caseDetails);
		waitingTime(5000);
		getElement("globalSearch").click();
		waitingTime(2000);
		getElement("globalsearchadvance").sendKeys(caseDetails);
		waitingTime(3000);
//		takeScreenShot();
		waitingTime(3000);
		getElement("globalsearchadvance").sendKeys(Keys.ENTER);
		waitingTime(6000);
	}

	public void searchForAcc() {
		getElement("globalSearch").sendKeys(WebConnector.ACC_NAME_RANDOM);
		waitingTime(4000);
		getElement("globalSearch").sendKeys(Keys.ENTER);
		waitingTime(4000);
		getElement("globalSearch").sendKeys(Keys.TAB);
	}

	public void searchForOpp() {
		try {
			String excelValue = getExcelValue(getTestCaseName()).get(0).get("opportunity name"); // IGNORE THIS
			getElement("searchTextL").sendKeys(excelValue);
			waitingTime(4000);
			getElement("searchTextL").sendKeys(Keys.ENTER);
			waitingTime(4000);
		} catch (Exception e) {
			System.out.println("Inside searchForOpp catch");
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
		}
	}

	public void loginAsSalesrep() {
		// search("Sales Rep");
		if (getUI().equalsIgnoreCase("Classic")) {
			String xpath = getDynamicXpath("salesrepUser", "Sales Rep", "end");
			scrollToXpathElement(xpath);
			getXpathElement(xpath).click();
			click("userActionMenu");
			click("userDetail");
			click("loginSalesrep");
		} else if (getUI().equalsIgnoreCase("Lightning")) {
			try {
				// getElement("globalSearch").sendKeys("Emily Park");
				type("globalSearch", "Sales Rep");
				waitingTime(2000);
				click("salesrepsearch");
				// getElement("globalSearch").sendKeys(Keys.ENTER);
				waitingTime(8000);
				// click("showMore_uat");
				// scrollToElement("people_uat");
				click("people_uat");
				waitingTime(2000);
				String xpath = getDynamicXpath("salesrepUserL", "Sales Rep", "end");
				getXpathElement(xpath).click();
				waitingTime(3000);
				jsClick("userDetail");
				waitingTime(3000);
				retryingWait("setup");
				waitingTime(3000);
				switchToFrame("newAccountFrame");
				click("loginSalesrep");
				waitingTime(3000);
				switchOutOfFrame();
				waitingTime(3000);
				// waitForElementToBeVisible("uatLoginbutton");
				// click("uatLoginbutton");
				driver.navigate().refresh();
				waitingTime(5000);
				// waitForElementToBeVisible("loginDetails");

			} catch (Exception e) {
				System.out.println("Inside loginAsSalesRep catch");

				e.printStackTrace();
				test.log(LogStatus.FAIL, "Test Case Failed");
				reportFailure("Test Case Failed" + e.getMessage());
			}
		}

	}

	private void get(String string) {
		// TODO Auto-generated method stub

	}

	public void logoutOfSalesrep() {
		// search("Sales Rep");
		if (getUI().equalsIgnoreCase("Classic")) {
			/*
			 * String xpath = getDynamicXpath("salesrepUser", "Sales Rep", "end");
			 * scrollToXpathElement(xpath); getXpathElement(xpath).click();
			 * click("userActionMenu"); click("userDetail"); click("loginSalesrep");
			 */
		} else if (getUI().equalsIgnoreCase("Lightning")) {
			try {
				click("logoutsalesrep");
				waitingTime(3000);
				click("userIcon");
				waitingTime(2000);
				String xpath = getDynamicXpath("spanTitle", "Username", "end");
				getXpathElement(xpath).click();
				waitingTime(3000);
				driver.navigate().refresh();
				waitingTime(3000);

			} catch (Exception e) {
				System.out.println("Inside logoutOfSalesRep catch");

				e.printStackTrace();
				test.log(LogStatus.FAIL, "Test Case Failed");
				reportFailure("Test Case Failed" + e.getMessage());
			}
		}

	}

	public void isDuplicate() {
		String excelValue = getExcelValue(this.testCaseName).get(0).get("Is Duplicate"); // IGNORE THIS
		boolean isSelected = false;
		if (getUI().contains("Lightning"))
			scrollToElement("isDuplicate");
		else if (getUI().contains("Classic"))
			scrollToElement("isDuplicateC");
		try {
			setImplicitWait(0);
			isSelected = getElement("isDuplicate").isSelected();
			setDefaultImplicitWait();
		} catch (Exception e) {
			System.out.println("Inside isDuplicate catch");
			isSelected = false;
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
		}

		if (excelValue.contains("Y") & getUI().contains("Lightning") & !isSelected)
			jsClick("isDuplicate");
		else if (excelValue.contains("Y") & getUI().contains("Classic") & !isSelected)
			jsClick("isDuplicateC");
		else if (excelValue.contains("N") & getUI().contains("Lightning") & isSelected)
			jsClick("isDuplicate");
		else if (excelValue.contains("N") & getUI().contains("Classic") & isSelected)
			jsClick("isDuplicate");
	}

	public void selectFromLookUp(String lookupName, String excelColumnName) {
		try {
			System.out.println("Inside selectFromLookUp method");
//			takeScreenShot();
			waitingTime(2000);
			String Parentwindow = driver.getWindowHandle();
			Parentwin = Parentwindow;
			waitingTime(2000);
			String lookupIcon = getDynamicXpathData("lookup", lookupName, "endContains");
			waitingTime(2000);
			clickLoopXpath(lookupIcon);
			waitingTime(5000);
			switchToLastWindow();
			waitingTime(5000);
			switchToFrame("searchFrame");
			waitingTime(2000);
			waitForElementsToBeVisible("globalSearch1");
			waitingTime(2000);
			type("globalSearch1", excelColumnName);
			waitingTime(2000);
			pressEnter("globalSearch1");
			waitingTime(2000);
			waitForElementsToBeVisible("globalSearch1");
			driver.switchTo().defaultContent();
			waitingTime(2000);
			switchToFrame("resultsFrame");
			waitingTime(5000);
			String lookupResult = getDynamicXpath("anchorText", excelColumnName, "end");
//			if (getBrowserName().equalsIgnoreCase("IE"))
			System.out.println("lookupResult" + lookupResult);
			waitingTime(5000);
			takeScreenShot();
			waitingTime(2000);
			clickXpath(lookupResult);
			waitingTime(5000);
			driver.switchTo().window(Parentwindow);
		} catch (Exception e) {
			System.out.println("Inside selectFromLookUp catch");
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			driver.switchTo().window(Parentwin);
			navigateTo("LoginTest", "Url");
		}
	}

	public void selectFromLookUp_propertiesFile(String lookupName, String prop_data) {
		try {
			String Parentwindow = driver.getWindowHandle();
			Parentwin = Parentwindow;
			String lookupIcon = getDynamicXpathData("lookup", lookupName, "endContains");
			clickLoopXpath(lookupIcon);
			waitingTime(2000);
			switchToLastWindow();
			waitingTime(2000);
			switchToFrame("searchFrame");
			waitForElementsToBeVisible("globalSearch1");
			waitingTime(2000);
			type_propertiesFile("globalSearch1", prop_data);
			waitingTime(2000);
			pressEnter("globalSearch1");
			waitingTime(2000);
			waitForElementsToBeVisible("globalSearch1");
			driver.switchTo().defaultContent();
			waitingTime(2000);
			switchToFrame("resultsFrame");
			String lookupResult = getDynamicXpath_propertiesFile("anchorText", prop_data, "end");
//			if (getBrowserName().equalsIgnoreCase("IE"))
				waitingTime(2000);
			clickXpath(lookupResult);
			waitingTime(5000);
			driver.switchTo().window(Parentwindow);
		} catch (Exception e) {
			System.out.println("Inside selectFromLookUp_propertiesFile catch");
//			takeScreenShot();
			driver.switchTo().window(Parentwin);
			navigateTo("LoginTest", "Url");
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
		}
	}

	public void selectFromLookUp2(String lookupName, String excelColumnName) {
		try {
			String Parentwindow = driver.getWindowHandle();
			Parentwin = Parentwindow;
			String lookupIcon = getDynamicXpathData("lookup", lookupName, "endContains");
			clickLoopXpath(lookupIcon);
			waitingTime(2000);
			switchToLastWindow();
			waitingTime(2000);
			switchToFrame("searchFrame");
			waitForElementsToBeVisible("globalSearch1");
			waitingTime(2000);
			type("globalSearch1", excelColumnName);
			pressEnter("globalSearch1");
			waitForElementsToBeVisible("globalSearch1");
			driver.switchTo().defaultContent();
			switchToFrame("resultsFrame");
			String lookupResult = getDynamicXpath("anchorTextcontains", excelColumnName, "endContains");
			System.out.println(lookupResult);
			if (getBrowserName().equalsIgnoreCase("IE"))
				waitingTime(2000);
			clickXpath(lookupResult);
			driver.switchTo().window(Parentwindow);
		} catch (Exception e) {
			System.out.println("Inside selectFromLookUp2 catch");
//			takeScreenShot();
			driver.switchTo().window(Parentwin);
			navigateTo("LoginTest", "Url");
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
		}
	}

	public void selectFromLookUp2_propertiesFile(String lookupName, String prop_data) {
		try {
			String Parentwindow = driver.getWindowHandle();
			Parentwin = Parentwindow;
			String lookupIcon = getDynamicXpathData("lookup", lookupName, "endContains");
			System.out.println(lookupIcon);
			clickLoopXpath(lookupIcon);
			waitingTime(5000);
			switchToLastWindow();
			waitingTime(10000);
			switchToFrame("searchFrame");
			waitForElementsToBeVisible("globalSearch1");
			waitingTime(2000);
			type_propertiesFile("globalSearch1", prop_data);
			pressEnter("globalSearch1");
			waitForElementsToBeVisible("globalSearch1");
			driver.switchTo().defaultContent();
			switchToFrame("resultsFrame");
			String lookupResult = getDynamicXpath_propertiesFile("anchorTextcontains", prop_data, "endContains");
			System.out.println(lookupResult);
			if (getBrowserName().equalsIgnoreCase("IE"))
				waitingTime(2000);
			clickXpath(lookupResult);
			driver.switchTo().window(Parentwindow);
		} catch (Exception e) {
			System.out.println("Inside selectFromLookUp2_propertiesFile catch");
//			takeScreenShot();
			driver.switchTo().window(Parentwin);
			navigateTo("LoginTest", "Url");
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
		}
	}

	public void selectFromLookUpDynamicValue(String lookupName, String data) {
		try {
			String Parentwindow = driver.getWindowHandle();
			Parentwin = Parentwindow;
			String lookupIcon = getDynamicXpathData("lookup", lookupName, "endContains");
			System.out.println(lookupIcon);
			clickLoopXpath(lookupIcon);
			waitingTime(5000);
			switchToLastWindow();
			waitingTime(10000);
			switchToFrame("searchFrame");
			waitForElementsToBeVisible("globalSearch1");
			waitingTime(2000);
			typeRandomstring("globalSearch1", data);
			pressEnter("globalSearch1");
			waitingTime(5000);
			waitForElementsToBeVisible("globalSearch1");
			driver.switchTo().defaultContent();
			switchToFrame("resultsFrame");
			String lookupResult = getDynamicXpathData("anchorTextcontains", data, "endContains");
			System.out.println(lookupResult);
			if (getBrowserName().equalsIgnoreCase("IE"))
				waitingTime(2000);
			clickXpath(lookupResult);
			waitingTime(5000);
			driver.switchTo().window(Parentwindow);
		} catch (Exception e) {
//			takeScreenShot();
			System.out.println("Inside selectFromLookUpDynamicValue catch");
			driver.switchTo().window(Parentwin);
			navigateTo("LoginTest", "Url");
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
		}

	}

	public void switchToChildWindow() {
		waitingTime(4000);
		Set<String> windowIds = driver.getWindowHandles();

		Iterator<String> it = windowIds.iterator();
		String parentWinID = it.next();
		String childWinID = null;
		while (it.hasNext()) {
			if (childWinID != parentWinID)
				childWinID = it.next();
		}
		driver.switchTo().window(childWinID);
	}

	public void switchBackToParentWindow() {
		System.out.println("Switching back to parent window..");
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> it = windowIds.iterator();
		String parentWinID = it.next();
		driver.switchTo().window(parentWinID);
	}

	public void pressBackspace(String objectRepoElement) {
		getElement(objectRepoElement).sendKeys(Keys.BACK_SPACE);
	}

	public void acceptAlert() {
		// Switching to Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void assertMessage(String objectRepoElement, String excelColumn) {
		String expected = getExcelValue(getTestCaseName()).get(0).get(excelColumn);
		String actual = getElement(objectRepoElement).getText();
		Assert.assertEquals(actual, expected);

	}

	public void assertMessage_propertiesFile(String objectRepoElement, String prop_data) {
		String expected = getTestDataFromPropertiesFile(prop_data);
		String actual = getElement(objectRepoElement).getText();
		Assert.assertEquals(actual, expected);

	}

	public void selectResult(String locator1, String excelColumn, String locator2) {
		String opportunities = getExcelValue(getTestCaseName()).get(0).get(excelColumn);
		int Totalopportunities = (int) Double.parseDouble((opportunities));
		for (int i = 1; i <= Totalopportunities; i++) {

			String objectRepoElement = OR.getProperty(locator1) + i + OR.getProperty(locator2);

			driver.findElement(By.xpath(objectRepoElement)).click();
		}
	}

	public void selectResult_propertiesFile(String locator1, String prop_data, String locator2) {
		String opportunities = getTestDataFromPropertiesFile(prop_data);
		int Totalopportunities = (int) Double.parseDouble((opportunities));
		for (int i = 1; i <= Totalopportunities; i++) {

			String objectRepoElement = OR.getProperty(locator1) + i + OR.getProperty(locator2);

			driver.findElement(By.xpath(objectRepoElement)).click();
		}
	}

	public void defaultframe() {

		driver.switchTo().defaultContent();
		System.out.println("Switched to default content");
		test.log(LogStatus.PASS, "Switched to default content");
	}

	public void clearText(String objectRepoElement) {
		getElement(objectRepoElement).clear();
	}

	public void isDuplicateOpportunity() { // IGNORE THIS
		String excelValue = getExcelValue(this.testCaseName).get(0).get("Is Duplicate");
		boolean isSelected = false;
		scrollToElement("isDuplicateC");
		try {
			setImplicitWait(0);
			isSelected = getElement("isDuplicateC").isSelected();
			setDefaultImplicitWait();
		} catch (Exception e) {
			System.out.println("Inside isDuplicateOpportunity catch");
			isSelected = false;
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
		}

		if (excelValue.contains("Y") & getUI().contains("Lightning") & !isSelected)
			jsClick("isDuplicateC");
		else if (excelValue.contains("Y") & getUI().contains("Classic") & !isSelected)
			jsClick("isDuplicateC");
		else if (excelValue.contains("N") & getUI().contains("Lightning") & isSelected)
			jsClick("isDuplicateC");
		else if (excelValue.contains("N") & getUI().contains("Classic") & isSelected)
			jsClick("isDuplicateC");
	}

	public String getDynamicText(String xpath) {

		return driver.findElement(By.xpath(xpath)).getText();

	}

	public String getLastTextLoop(String objectRepoElement) {
		String text = null;
		int Last = getXpathElements(objectRepoElement).size() - 1;
		{
			if (getXpathElements(objectRepoElement).get(Last).isDisplayed()
					& getXpathElements(objectRepoElement).get(Last).isEnabled()) {
				text = getXpathElements(objectRepoElement).get(Last).getText();
			} else {
				reportFailure("Text not Found");
			}
			return text;
		}
	}
	
    public String getIPAddress() {
        try {
            // Getting the localhost address
            InetAddress localhost = InetAddress.getLocalHost();
            return localhost.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	public void scrolldown(int scroll) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + scroll + ")");
	}

	public void scrolldownFile() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public String getDynamicAccountXpath(String locator1, String data, String locator2) {
		String objectRepoElement = OR.getProperty(locator1) + data + OR.getProperty(locator2);
		return objectRepoElement;
	}

	public String getAttributeclass(String objectRepoElement) {
		String text = null;
		try {
			test.log(LogStatus.INFO, "getting value from " + objectRepoElement);
			waitForElementToBeVisible(objectRepoElement);
			text = getElement(objectRepoElement).getAttribute("class");
			test.log(LogStatus.INFO, "Value Fetched in " + objectRepoElement + " : " + text);
		} catch (Exception e) {
			System.out.println("Inside getAttributeclass catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			reportFailure(objectRepoElement + " value could not be fetched");
		}
		return text;
	}

	public String getDynamicRandomOpp(String locator1, String data, String locator2) {
		String objectRepoElement = OR.getProperty(locator1) + data + OR.getProperty(locator2);
		return objectRepoElement;
	}

	public void refresh() {
		System.out.println("Refreshing the page..");
		driver.navigate().refresh();
	}

	public WebElement getElementTag(String objectRepoElement) {
		return driver.findElement(By.tagName(OR.getProperty(objectRepoElement)));
	}

	public void zoom(String objectRepoElement) {
		getElementTag(objectRepoElement).sendKeys(Keys.chord(Keys.CONTROL, "0"));
	}

//	public void staticDropdown(String objectRepoElement, String excelCoulumn) {
//		String text = getExcelValue(testCaseName).get(0).get(excelCoulumn);
//		if (!text.isEmpty()) {
//			test.log(LogStatus.INFO, "Searching text: " + text + " in " + objectRepoElement + " dropdown");
//			click(objectRepoElement);
//			waitingTime(2000);
//			Select dropdown = new Select(getElement(objectRepoElement));
//			dropdown.selectByVisibleText(text);
//			test.log(LogStatus.PASS, "Selected option: " + text);
//		}
//	}

	public void autoSuggestiveDropdown(String objectRepoElement, String excelColumn) throws InterruptedException {

		String text = getExcelValue(getTestCaseName()).get(0).get(excelColumn);
		System.out.println("address is" + text);
		getElement(objectRepoElement).sendKeys(text);
		waitingTime(6000);
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		waitingTime(2000);
		getElement(objectRepoElement).sendKeys(Keys.DOWN);
		// getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(4000);
		getElement(objectRepoElement).sendKeys(Keys.ENTER);
		test.log(LogStatus.INFO, "Value entered in " + objectRepoElement + " : " + text);

	}

	public void autoSuggestiveDropdown_propertiesFile(String objectRepoElement, String prop_data)
			throws InterruptedException {

		String text = getTestDataFromPropertiesFile(prop_data);
		System.out.println("address is" + text);
		getElement(objectRepoElement).sendKeys(text);
		waitingTime(6000);
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		waitingTime(2000);
		getElement(objectRepoElement).sendKeys(Keys.DOWN);
		// getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(4000);
		getElement(objectRepoElement).sendKeys(Keys.ENTER);
		test.log(LogStatus.INFO, "Value entered in " + objectRepoElement + " : " + text);

	}

	public void autoSuggestiveDropdoWithOneDown(String objectRepoElement, String excelColumn)
			throws InterruptedException {

		String text = getExcelValue(getTestCaseName()).get(0).get(excelColumn);
		System.out.println("address is" + text);
		getElement(objectRepoElement).sendKeys(text);
		Thread.sleep(2000);
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
//		getElement(objectRepoElement).sendKeys(Keys.DOWN);
		// getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		getElement(objectRepoElement).sendKeys(Keys.ENTER);
		test.log(LogStatus.INFO, "Value entered in " + objectRepoElement + " : " + text);

	}

	public void autoSuggestiveDropdoWithOneDown_propertiesFile(String objectRepoElement, String prop_data)
			throws InterruptedException {

		String text = getTestDataFromPropertiesFile(prop_data);
		System.out.println("address is" + text);
		getElement(objectRepoElement).sendKeys(text);
		Thread.sleep(2000);
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
//		getElement(objectRepoElement).sendKeys(Keys.DOWN);
		// getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		getElement(objectRepoElement).sendKeys(Keys.ENTER);
		test.log(LogStatus.INFO, "Value entered in " + objectRepoElement + " : " + text);

	}

	public void loginAsMarketingSalesRep() {

		if (getUI().equalsIgnoreCase("Classic")) {
			String xpath = getDynamicXpath("salesrepUser", "Sales Rep", "end");
			scrollToXpathElement(xpath);
			getXpathElement(xpath).click();
			click("userActionMenu");
			click("userDetail");
			click("loginSalesrep");
		} else if (getUI().equalsIgnoreCase("Lightning")) {
			try {

				type("globalSearch", "Sales Rep");
				waitingTime(2000);
				click("salesrepsearch");
				waitingTime(8000);
				click("people_uat");
				waitingTime(2000);
				String xpath = getDynamicXpath("salesrepUserL", "Sales Rep", "end");
				getXpathElement(xpath).click();
				waitingTime(3000);
				jsClick("userDetail");
				waitingTime(3000);
				retryingWait("setup");
				waitingTime(3000);
				switchToFrame("newAccountFrame");
				click("loginSalesrep");
				waitingTime(2000);
				switchOutOfFrame();
				waitingTime(2000);

			} catch (Exception e) {
				System.out.println("Inside loginAsMarketingSalesRep catch");

				e.printStackTrace();
				test.log(LogStatus.FAIL, "Test Case Failed");
				reportFailure("Test Case Failed" + e.getMessage());
			}
		}

	}

	public void autoSuggestiveDropdownWithoutText(String objectRepoElement) throws InterruptedException {
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		waitingTime(2000);
		getElement(objectRepoElement).sendKeys(Keys.DOWN);
		// getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		waitingTime(2000);
		getElement(objectRepoElement).sendKeys(Keys.ENTER);

	}

	public void selectOptionFromDropDownByValue(String objectRepoElement, String value) throws InterruptedException {
		Select dropdown_value = new Select(getElement(objectRepoElement));
		dropdown_value.selectByValue(value);
	}

	public void autoSuggestiveDropdownOne(String objectRepoElement, String excelColumn) throws InterruptedException {
		String text = getExcelValue(getTestCaseName()).get(0).get(excelColumn);
		System.out.println("Excel data is" + text);
		getElement(objectRepoElement).sendKeys(text);
		Thread.sleep(4000);
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		// getElement(objectRepoElement).sendKeys(Keys.DOWN);
		// getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(4000);
		getElement(objectRepoElement).sendKeys(Keys.ENTER);
		test.log(LogStatus.INFO, "Value entered in " + objectRepoElement + " : " + text);

	}

	public void autoSuggestiveDropdownOne_propertiesFile(String objectRepoElement, String prop_data)
			throws InterruptedException {
		String text = getTestDataFromPropertiesFile(prop_data);
		System.out.println("Excel data is" + text);
		getElement(objectRepoElement).sendKeys(text);
		Thread.sleep(4000);
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		// getElement(objectRepoElement).sendKeys(Keys.DOWN);
		// getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(4000);
		getElement(objectRepoElement).sendKeys(Keys.ENTER);
		test.log(LogStatus.INFO, "Value entered in " + objectRepoElement + " : " + text);

	}

	public void autoSuggestiveDropdownWithoutText1(String objectRepoElement) throws InterruptedException {
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);

		// getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		getElement(objectRepoElement).sendKeys(Keys.ENTER);

	}

	public void autoSuggestiveDropdownWithoutText2(String objectRepoElement) throws InterruptedException {
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		// getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		getElement(objectRepoElement).sendKeys(Keys.ENTER);

	}

	public void autoSuggestiveDropdownWithoutTextTwo(String objectRepoElement) throws InterruptedException {
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		// getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		getElement(objectRepoElement).sendKeys(Keys.ENTER);

	}

//	public void autoSuggestiveDropdownTab(String objectRepoElement, String excelColumn) throws InterruptedException {
//		String text = getExcelValue(getTestCaseName()).get(0).get(excelColumn);
//		System.out.println("value is" + text);
//		getElement(objectRepoElement).sendKeys(text);
//		Thread.sleep(2000);
//		getElement(objectRepoElement).sendKeys(Keys.TAB);
//		getElement(objectRepoElement).sendKeys(Keys.TAB);
//		// getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
//
//		getElement(objectRepoElement).sendKeys(Keys.ENTER);
//		test.log(LogStatus.INFO, "Value entered in " + objectRepoElement + " : " + text);
//
//	}

	public void loginAsCSOMUser() {

		if (getUI().equalsIgnoreCase("Classic")) {
			String xpath = getDynamicXpath("salesrepUser", "Sales Rep", "end");
			scrollToXpathElement(xpath);
			getXpathElement(xpath).click();
			click("userActionMenu");
			click("userDetail");
			click("loginSalesrep");
		} else if (getUI().equalsIgnoreCase("Lightning")) {
			try {

				type("globalSearch", "Sales Rep");
				waitingTime(2000);
				click("salesrepsearch");
				waitingTime(8000);
				click("people_uat");
				waitingTime(2000);
				String xpath = getDynamicXpath("salesrepUserL", "Sales Rep", "end");
				getXpathElement(xpath).click();
				waitingTime(3000);
				jsClick("userDetail");
				waitingTime(3000);
				retryingWait("setup");
				waitingTime(3000);
				switchToFrame("newAccountFrame");
				click("loginSalesrep");
				waitingTime(2000);
				switchOutOfFrame();
				waitingTime(2000);
				getUI();
				check_Change_UserInterface();
				waitingTime(2000);

			} catch (Exception e) {
				System.out.println("Inside loginAsCSOMuser catch");

				e.printStackTrace();
				test.log(LogStatus.FAIL, "Test Case Failed");
				reportFailure("Test Case Failed" + e.getMessage());
			}
		}

	}

	public void loginAsCXGUser() {

		if (getUI().equalsIgnoreCase("Classic")) {
			String xpath = getDynamicXpath("salesrepUser", "Sales Rep", "end");
			scrollToXpathElement(xpath);
			getXpathElement(xpath).click();
			click("userActionMenu");
			click("userDetail");
			click("loginSalesrep");
		} else if (getUI().equalsIgnoreCase("Lightning")) {
			try {

				type("globalSearch", "Sales Rep");
				waitingTime(2000);
				click("salesrepsearch");
				waitingTime(8000);
				click("people_uat");
				waitingTime(2000);
				String xpath = getDynamicXpath("salesrepUserL", "Sales Rep", "end");
				getXpathElement(xpath).click();
				waitingTime(3000);
				jsClick("userDetail");
				waitingTime(3000);
				retryingWait("setup");
				waitingTime(3000);
				switchToFrame("newAccountFrame");
				click("loginSalesrep");
				waitingTime(2000);
				switchOutOfFrame();
				waitingTime(2000);
				getUI();
				check_Change_UserInterface();
				waitingTime(2000);

			} catch (Exception e) {
				System.out.println("Inside loginAsCXGuser catch");

				e.printStackTrace();
				test.log(LogStatus.FAIL, "Test Case Failed");
				reportFailure("Test Case Failed" + e.getMessage());
			}
		}

	}

	public void loginAsAdminUser() {

		if (getUI().equalsIgnoreCase("Classic")) {
			String xpath = getDynamicXpath("salesrepUser", "Sales Rep", "end");
			scrollToXpathElement(xpath);
			getXpathElement(xpath).click();
			click("userActionMenu");
			click("userDetail");
			click("loginSalesrep");
		} else if (getUI().equalsIgnoreCase("Lightning")) {
			try {

				type("globalSearch", "Sales Rep");
				waitingTime(2000);
				click("salesrepsearch");
				waitingTime(8000);
				click("people_uat");
				waitingTime(2000);
				String xpath = getDynamicXpath("salesrepUserL", "Sales Rep", "end");
				getXpathElement(xpath).click();
				waitingTime(3000);
				jsClick("userDetail");
				waitingTime(3000);
				retryingWait("setup");
				waitingTime(3000);
				switchToFrame("newAccountFrame");
				click("loginSalesrep");
				waitingTime(2000);
				switchOutOfFrame();
				waitingTime(2000);
				getUI();
				check_Change_UserInterface();
				waitingTime(2000);

			} catch (Exception e) {
				System.out.println("Inside loginAsAdminUser catch");

				e.printStackTrace();
				test.log(LogStatus.FAIL, "Test Case Failed");
				reportFailure("Test Case Failed" + e.getMessage());
			}
		}

	}

	public void logoutFromAnyUser() {
		if (getUI().equalsIgnoreCase("Classic")) {
			click("UserProfileArrowClassic");
			waitingTime(2000);
			click("UserLogoutClassic");
			waitingTime(8000);
			takeScreenShot();
		} else if (getUI().equalsIgnoreCase("Lightning")) {
			try {
				jsClick("userLogoutLink");
				waitingTime(10000);
				driver.navigate().refresh();
				waitingTime(8000);
				takeScreenShot();
			} catch (Exception e) {
				System.out.println("Inside logoutFromAnyUser catch");
				e.printStackTrace();
				test.log(LogStatus.FAIL, "Test Case Failed");
				reportFailure("Test Case Failed" + e.getMessage());
			}
		}

	}
	
	public void logoutFromAnyUserClassic() {
		if(isElementPresentFast("UserProfileArrowClassic"))
		{
			waitForElementsToBeVisible("UserProfileArrowClassic");
			click("UserProfileArrowClassic");
			waitForElementsToBeVisible("UserLogoutClassic");
			click("UserLogoutClassic");
			waitingTime(5000);
		}
	}

	public void selectFromProductLookUp(String lookupName, String excelColumnName) {
		try {
			String lookupResult = null;
			String Parentwindow = driver.getWindowHandle();
			Parentwin = Parentwindow;
			String lookupIcon = getDynamicXpathData("lookup", lookupName, "endContains");
			clickLoopXpath(lookupIcon);
			waitingTime(2000);
			switchToLastWindow();
			waitingTime(2000);
			switchToFrame("searchFrame");
			waitingTime(2000);
			waitForElementsToBeVisible("globalSearch1");
			waitingTime(2000);
			type("globalSearch1", excelColumnName);
			pressEnter("globalSearch1");
			waitForElementsToBeVisible("globalSearch1");
			driver.switchTo().defaultContent();
			switchToFrame("resultsFrame");
			if (getTestCaseName().contains("Course")) {
				lookupResult = getDynamicXpath("anchorTextNew", excelColumnName, "endNew");
			} else
				lookupResult = getDynamicXpath("anchorTextNew", excelColumnName, "endLookup");
			clickXpath(lookupResult);
			waitingTime(2000);
			driver.switchTo().window(Parentwin);
			// driver.switchTo().defaultContent();
			waitingTime(2000);
			switchOutOfFrame();
			waitingTime(2000);
		} catch (Exception e) {
			System.out.println("Inside selectFromProductLookup catch");
//			takeScreenShot();
			driver.switchTo().window(Parentwin);
			navigateTo("LoginTest", "Url");
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
		}
	}

	public void selectFromProductLookUp_propertiesFile(String lookupName, String prop_data) {
		try {
			String lookupResult = null;
			String Parentwindow = driver.getWindowHandle();
			Parentwin = Parentwindow;
			String lookupIcon = getDynamicXpathData("lookup", lookupName, "endContains");
			clickLoopXpath(lookupIcon);
			waitingTime(2000);
			switchToLastWindow();
			waitingTime(2000);
			switchToFrame("searchFrame");
			waitingTime(2000);
			waitForElementsToBeVisible("globalSearch1");
			waitingTime(2000);
			type_propertiesFile("globalSearch1", prop_data);
			pressEnter("globalSearch1");
			waitForElementsToBeVisible("globalSearch1");
			driver.switchTo().defaultContent();
			switchToFrame("resultsFrame");
			if (getTestCaseName().contains("Course")) {
				lookupResult = getDynamicXpath_propertiesFile("anchorTextNew", prop_data, "endNew");
			} else
				lookupResult = getDynamicXpath_propertiesFile("anchorTextNew", prop_data, "endLookup");
			clickXpath(lookupResult);
			waitingTime(2000);
			driver.switchTo().window(Parentwin);
			// driver.switchTo().defaultContent();
			waitingTime(2000);
			switchOutOfFrame();
			waitingTime(2000);
		} catch (Exception e) {
			System.out.println("Inside selectFromProductLookUp_PropertiesFile catch");
//			takeScreenShot();
			driver.switchTo().window(Parentwin);
			navigateTo("LoginTest", "Url");
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
		}
	}

	public void iterateTableAndCheckData(String locator1, String locator2, String excelColName) {

		// for (int j = 4; j >= 1; j--) {

		// String table = OR.getProperty(locator1) + j + OR.getProperty(locator2);
		String table = OR.getProperty(locator1) + getExcelValue(getTestCaseName()).get(0).get(excelColName)
				+ OR.getProperty(locator2);
		System.out.println("Table xpath is :" + table);
		WebElement table1 = getXpathElement(table);
		// scrollToElement(table);
		List<WebElement> rowsList = table1.findElements(By.tagName("tr"));
		List<WebElement> columnsList = null;
		for (WebElement row : rowsList) {
			columnsList = row.findElements(By.tagName("td"));
			WebElement column = columnsList.get(1);
			System.out.print(column.getText());
			if (column.getText() != null) {
				test.log(LogStatus.INFO, "Product course: " + column.getText());
			}
			break;

		}
		test.log(LogStatus.INFO, "All the documents tied to product are listed");

	}

	public void iterateTableAndCheckData_propertiesFile(String locator1, String locator2, String prop_data) {

		// for (int j = 4; j >= 1; j--) {

		// String table = OR.getProperty(locator1) + j + OR.getProperty(locator2);
		String table = OR.getProperty(locator1) + getTestDataFromPropertiesFile(prop_data) + OR.getProperty(locator2);
		System.out.println("Table xpath is :" + table);
		WebElement table1 = getXpathElement(table);
		// scrollToElement(table);
		List<WebElement> rowsList = table1.findElements(By.tagName("tr"));
		List<WebElement> columnsList = null;
		for (WebElement row : rowsList) {
			columnsList = row.findElements(By.tagName("td"));
			WebElement column = columnsList.get(1);
			System.out.print(column.getText());
			if (column.getText() != null) {
				test.log(LogStatus.INFO, "Product course: " + column.getText());
			}
			break;

		}
		test.log(LogStatus.INFO, "All the documents tied to product are listed");

	}

	public void getTabNamesFromExcel(String tabLocator1, String excelColName, String tabLocator2) {
		String objectRepoElement = OR.getProperty(tabLocator1)
				+ getExcelValue(getTestCaseName()).get(0).get(excelColName) + OR.getProperty(tabLocator2);
		getXpathElement(objectRepoElement).click();
	}

	public void getTabNamesFromPropertiesFile(String tabLocator1, String prop_data, String tabLocator2) {
		String objectRepoElement = OR.getProperty(tabLocator1) + getTestDataFromPropertiesFile(prop_data)
				+ OR.getProperty(tabLocator2);
		getXpathElement(objectRepoElement).click();
	}

	public void iterateTableAndCheckData1(String locator1, String locator2, String tabLocator1, String tabLocator2) {

		for (int j = 4; j >= 1; j--) {

			List<String> tabList = Arrays.asList("Area", "Discipline", "Course", "Product");
			for (String tab : tabList) {

				String categoryTab = OR.getProperty(tabLocator1) + tab + OR.getProperty(tabLocator2);
				getXpathElement(categoryTab).click();
				waitingTime(2000);
				String table = OR.getProperty(locator1) + j + OR.getProperty(locator2);
				WebElement table1 = getXpathElement(table);
				List<WebElement> rowsList = table1.findElements(By.tagName("tr"));
				List<WebElement> columnsList = null;
				for (WebElement row : rowsList) {
					columnsList = row.findElements(By.tagName("td"));
					WebElement column = columnsList.get(1);
					System.out.print(column.getText());
					if (column.getText() != null) {
						test.log(LogStatus.INFO, "Product course: " + column.getText());
					}
					break;

				}
				test.log(LogStatus.INFO, "All the documents tied to product are listed");
				break;
			}

		}

	}

	public void verifyLibraryItems(String locator1, String excelColName, String locator2, String locator3,
			String excelColName1, String locator4) {
		int count = 0;
		ArrayList tabs = new ArrayList(driver.getWindowHandles());
		System.out.println(tabs.size());
		int tabsize = tabs.size();
		driver.switchTo().window((String) tabs.get(tabsize - 1));

		try {
			WebElement table = getElement("productandCoursesTable");
			List<WebElement> rowsList = table.findElements(By.tagName("tr"));
			List<WebElement> columnsList = null;
			for (WebElement row : rowsList) {
				columnsList = row.findElements(By.tagName("td"));
				WebElement column = columnsList.get(1);
				System.out.print(column.getText());
				test.log(LogStatus.INFO, "Product course: " + column.getText());
				count++;

			}
			test.log(LogStatus.INFO, "Total no. of library items=" + count);
			clickDynamic("anchorValue", "Library Name", "end");
			waitingTime(5000);
			switchOutOfFrame();

			String parentWindow = driver.getWindowHandle();
			driver.switchTo().window(parentWindow);

			boolean page = isElementPresent("accessibilityXpath");
			boolean content = isElementPresentXpath("(//table[@class='outer'])[2]//table[@id='documentListTable']");
			boolean member = isElementPresentXpath("(//table[@class='outer'])[2]//form[@id='workspaceViewMembers']");
			if (content == true && member == true) {
				test.log(LogStatus.INFO, "Library item page is opened");

//				 parentWindow = driver.getWindowHandle();
//
//				for(String childWindow:driver.getWindowHandles())
//				if(!childWindow.equals(parentWindow))
//				    driver.switchTo().window(childWindow);

				close();
				switchBackToParentWindow();
				switchOutOfFrame();
			} else {
				reportFailure("Test Case Failed");
			}

		} catch (Exception e) {
			System.out.println("Inside verifyLibraryItems catch");
			switchOutOfFrame();
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			// reportFailure("Test Case Failed");
		}

	}

	public void verifyLibraryItems_propertiesFile(String locator1, String prop_data, String locator2, String locator3,
			String prop_data1, String locator4) {
		int count = 0;
		ArrayList tabs = new ArrayList(driver.getWindowHandles());
		System.out.println(tabs.size());
		int tabsize = tabs.size();
		driver.switchTo().window((String) tabs.get(tabsize - 1));

		try {
			WebElement table = getElement("productandCoursesTable");
			List<WebElement> rowsList = table.findElements(By.tagName("tr"));
			List<WebElement> columnsList = null;
			for (WebElement row : rowsList) {
				columnsList = row.findElements(By.tagName("td"));
				WebElement column = columnsList.get(1);
				System.out.print(column.getText());
				test.log(LogStatus.INFO, "Product course: " + column.getText());
				count++;

			}
			test.log(LogStatus.INFO, "Total no. of library items=" + count);
			clickDynamic("anchorValue", "Library Name", "end");
			waitingTime(5000);
			switchOutOfFrame();

			String parentWindow = driver.getWindowHandle();
			driver.switchTo().window(parentWindow);

			boolean page = isElementPresent("accessibilityXpath");
			boolean content = isElementPresentXpath("(//table[@class='outer'])[2]//table[@id='documentListTable']");
			boolean member = isElementPresentXpath("(//table[@class='outer'])[2]//form[@id='workspaceViewMembers']");
			if (content == true && member == true) {
				test.log(LogStatus.INFO, "Library item page is opened");

//				 parentWindow = driver.getWindowHandle();
//
//				for(String childWindow:driver.getWindowHandles())
//				if(!childWindow.equals(parentWindow))
//				    driver.switchTo().window(childWindow);

				close();
				switchBackToParentWindow();
				switchOutOfFrame();
			} else {
				reportFailure("Test Case Failed");
			}

		} catch (Exception e) {
			System.out.println("Inside verifyLibraryItems_PropertiesFile catch");
			switchOutOfFrame();
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			// reportFailure("Test Case Failed");
		}

	}

	public String getURL() {
		String strUrl = driver.getCurrentUrl();
		return strUrl;
	}

	public void selectFromSalesrepLookUp(String lookupName, String excelColumnName) { // IGNORE THIS
		try {
			String lookupResult = null;
			String Parentwindow = driver.getWindowHandle();
			Parentwin = Parentwindow;
			String lookupIcon = getDynamicXpathData("lookup", lookupName, "endContains");
			clickLoopXpath(lookupIcon);
			waitingTime(2000);
			switchToLastWindow();
			waitingTime(2000);
			switchToFrame("searchFrame");
			waitForElementsToBeVisible("globalSearch1");
			waitingTime(2000);
			type("globalSearch1", excelColumnName);
			pressEnter("globalSearch1");
			waitForElementsToBeVisible("globalSearch1");
			driver.switchTo().defaultContent();
			switchToFrame("resultsFrame");
			lookupResult = getDynamicXpath("anchorText", excelColumnName, "end");
			clickXpath(lookupResult);
			driver.switchTo().window(Parentwindow);
			waitForElementToBeVisible("newAccountFrame");
			switchToFrame("newAccountFrame");
			// driver.switchTo().defaultContent();
			// switchOutOfFrame();
		} catch (Exception e) {
			System.out.println("Inside selectFromSalesRepLookUp catch");
//			takeScreenShot();
			driver.switchTo().window(Parentwin);
			navigateTo("LoginTest", "Url");
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
		}
	}

//	public void navigateToURL(String url) {
//		driver.navigate().to(url);

	public void verifyCustomLinks() {

		try {
			ArrayList tabs = new ArrayList(driver.getWindowHandles());
			System.out.println(tabs.size());
//			driver.switchTo().window((String) tabs.get(1));
			int tabsize = tabs.size();
			driver.switchTo().window((String) tabs.get(tabsize - 1));

			switchToFrame("reportsPageFrame");
			waitForElementToBeVisible("reportNameGetText");
			String reportName = getText("reportNameGetText").toString();
			test.log(LogStatus.INFO, "Report Name is:  " + reportName);

			if (getExcelValue(testCaseName).get(0).get("User").equalsIgnoreCase("MHES")) {

				click("filterBtn");
				click("removeFilterBtn");
				waitingTime(10000);
			}
			// waitUntilProcessing();
			// waitForElementToDisappear("loaderProcessor");
			retryingWaitForVisibility("reportsTable");
			waitingTime(6000);
			WebElement table = getElement("reportsTable");
			List<WebElement> rowsList = table.findElements(By.tagName("tr"));
			List<WebElement> columnsList = null;
			for (WebElement row : rowsList) {
				// columnsList = row.findElements(By.tagName("td"));
				columnsList = row.findElements(By.xpath("//td"));
				WebElement column = columnsList.get(2);
				if (column.getText() != null) {
					test.log(LogStatus.INFO, "Reports are displayed: " + column.getText());
				}
				continue;

			}
			close();
			switchBackToParentWindow();
			test.log(LogStatus.INFO, "All the report details tied to account are listed");

		} catch (Exception e) {
			System.out.println("Inside verifyCustomLinks catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			// reportFailure("Test Case Failed");
		}

	}

//	public void urlTitle() {
//		LeadURl = driver.getCurrentUrl();
//	}

	public void check_Switch_UserInterface() {
		test.log(LogStatus.INFO, "Checking the user interface");
		System.out.println("Checking the user interface");
		boolean isLightning = isElementPresentFast("searchTextL");
		System.out.println("Lightning Mode:::" + isLightning);
		if (!isLightning) {
			System.out.println("Could not find searchText field. Refresing the page..");
			refresh();
			waitingTime(8000);
			isLightning = isElementPresentFast("searchTextL");
			System.out.println("Lightning Mode:::" + isLightning);
			if (!isLightning) {
				test.log(LogStatus.INFO, "Classic Detected! Switching to Lightning");
				System.out.println("Classic Detected! Switching to Lightning");
				click("lightning");
				test.log(LogStatus.INFO, "Clicked on the Lightning link");
				isLightning = isElementPresentFast("searchTextL");
				System.out.println("Lightning Mode:::" + isLightning);
				if (isLightning) {
					test.log(LogStatus.PASS, "Successfully switched to the lightning view");
					waitingTime(5000);
				} else {
					reportFailure("Error faced while switching to the lightning view");
				}
			}
		} else {
			System.out.println("Current UI is Lightning...");
		}

//		setImplicitWait(5);		
		checkFlowInterruptedPopup();
		setDefaultImplicitWait();
	}

	public void autoSuggestiveDrpDownSelectOption(String objectRepoElement, String excelColumn)
			throws InterruptedException {

		String text = getExcelValue(getTestCaseName()).get(0).get(excelColumn);
		System.out.println("address is" + text);
		getElement(objectRepoElement).sendKeys(text);
		Thread.sleep(4000);
		getElement(objectRepoElement).sendKeys(Keys.ARROW_UP);
		// getElement(objectRepoElement).sendKeys(Keys.DOWN);
		Thread.sleep(4000);
		getElement(objectRepoElement).sendKeys(Keys.ENTER);
		test.log(LogStatus.INFO, "Value entered in " + objectRepoElement + " : " + text);

	}

	public void autoSuggestiveDrpDownSelectOption_propertiesFile(String objectRepoElement, String prop_data)
			throws InterruptedException {

		String text = getTestDataFromPropertiesFile(prop_data);
		System.out.println("address is" + text);
		getElement(objectRepoElement).sendKeys(text);
		Thread.sleep(4000);
		getElement(objectRepoElement).sendKeys(Keys.ARROW_UP);
		// getElement(objectRepoElement).sendKeys(Keys.DOWN);
		Thread.sleep(4000);
		getElement(objectRepoElement).sendKeys(Keys.ENTER);
		test.log(LogStatus.INFO, "Value entered in " + objectRepoElement + " : " + text);

	}

	public void autoSuggestiveDrpDownSelectOptionTwo(String objectRepoElement, String excelColumn)
			throws InterruptedException {

		String text = getExcelValue(getTestCaseName()).get(0).get(excelColumn);
		System.out.println("address is" + text);
		getElement(objectRepoElement).sendKeys(text);
		Thread.sleep(2000);
		// getElement(objectRepoElement).sendKeys(Keys.ARROW_UP);
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		getElement(objectRepoElement).sendKeys(Keys.ENTER);
		test.log(LogStatus.INFO, "Value entered in " + objectRepoElement + " : " + text);

	}

	public void autoSuggestiveDrpDownSelectOptionTwo_propertiesFile(String objectRepoElement, String prop_data)
			throws InterruptedException {

		String text = getTestDataFromPropertiesFile(prop_data);
		System.out.println("address is" + text);
		getElement(objectRepoElement).sendKeys(text);
		Thread.sleep(2000);
		// getElement(objectRepoElement).sendKeys(Keys.ARROW_UP);
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		getElement(objectRepoElement).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		getElement(objectRepoElement).sendKeys(Keys.ENTER);
		test.log(LogStatus.INFO, "Value entered in " + objectRepoElement + " : " + text);

	}

	public void waitUntilLoaderLoads() {
		for (int i = 0; i <= 100; i++) {
			if (isElementPresent("processingLoader")) {
				System.out.println("Still Processing...");
				i++;
			} else {
				break;
			}

		}

	}

	public void selectCourseFromProductLookUp(String lookupName, String excelColumnName) {

		try {

			String lookupResult = null;

			String Parentwindow = driver.getWindowHandle();
			waitingTime(2000);
			Parentwin = Parentwindow;

			String lookupIcon = getDynamicXpathData("lookup", lookupName, "endContains");
			waitingTime(4000);
			clickLoopXpath(lookupIcon);

			waitingTime(10000);

			switchToLastWindow();

			waitingTime(10000);

			switchToFrame("searchFrame");
			waitingTime(2000);

			waitForElementsToBeVisible("globalSearch1");

			waitingTime(2000);

			type("globalSearch1", excelColumnName);
			waitingTime(2000);
			pressEnter("globalSearch1");
			waitingTime(2000);
			waitForElementsToBeVisible("globalSearch1");
			waitingTime(2000);
			driver.switchTo().defaultContent();
			waitingTime(2000);
			switchToFrame("resultsFrame");
			waitingTime(2000);
			// lookupResult = getDynamicXpath("anchorTextNew", excelColumnName, "endNew");
			lookupResult = getDynamicXpath("anchorText", excelColumnName, "end");
			waitingTime(2000);
			clickXpath(lookupResult);
			waitingTime(2000);
			driver.switchTo().window(Parentwin);
			waitingTime(2000);
			switchOutOfFrame();
			waitingTime(2000);
		} catch (Exception e) {
			System.out.println("Inside courseFromProductLookUp Catch");
//			takeScreenShot();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			String Currentwindow = driver.getWindowHandle();
			waitingTime(2000);
			Currentwin = Currentwindow;
			System.out.println("Parentwin is : " + Parentwin + "  Currentwin is : " + Currentwin);
			if (Parentwin.equalsIgnoreCase(Currentwin)) {
				System.out.println("It is a parent window. So, not closing it!");
			} else {
				System.out.println("It is a child window. So, closing it!");
				close();
			}

			switchBackToParentWindow();
			switchOutOfFrame();

			// navigateTo("LoginTest", "Url");

		}

	}

	public void selectCourseFromProductLookUp_propertiesFile(String lookupName, String prop_data) {

		try {

			String lookupResult = null;

			String Parentwindow = driver.getWindowHandle();
			waitingTime(2000);
			Parentwin = Parentwindow;

			String lookupIcon = getDynamicXpathData("lookup", lookupName, "endContains");
			waitingTime(4000);
			clickLoopXpath(lookupIcon);

			waitingTime(10000);

			switchToLastWindow();

			waitingTime(10000);

			switchToFrame("searchFrame");
			waitingTime(2000);

			waitForElementsToBeVisible("globalSearch1");

			waitingTime(2000);

			type_propertiesFile("globalSearch1", prop_data);

			pressEnter("globalSearch1");

			waitForElementsToBeVisible("globalSearch1");

			driver.switchTo().defaultContent();

			switchToFrame("resultsFrame");

			// lookupResult = getDynamicXpath("anchorTextNew", excelColumnName, "endNew");
			lookupResult = getDynamicXpath_propertiesFile("anchorText", prop_data, "end");

			clickXpath(lookupResult);

			driver.switchTo().window(Parentwin);

			switchOutOfFrame();

		} catch (Exception e) {
			System.out.println("Inside selectCourseFromProductLookUp_propertiesFile Catch");
//			takeScreenShot();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			String Currentwindow = driver.getWindowHandle();
			waitingTime(2000);
			Currentwin = Currentwindow;
			System.out.println("Parentwin is : " + Parentwin + "  Currentwin is : " + Currentwin);
			if (Parentwin.equalsIgnoreCase(Currentwin)) {
				System.out.println("It is a parent window. So, not closing it!");
			} else {
				System.out.println("It is a child window. So, closing it!");
				close();
			}

			switchBackToParentWindow();
			switchOutOfFrame();

			// navigateTo("LoginTest", "Url");

		}

	}

//	public void EventTitle() {
//		Eventtitle = driver.getCurrentUrl();
//	}

//	public void selectFromLookUpCourse(String lookupName, String excelColumnName) {
//		try {
//
//			String Parentwindow = driver.getWindowHandle();
//			Parentwin = Parentwindow;
//			String lookupIcon = getDynamicXpathData("lookup", lookupName, "endContains");
//			clickLoopXpath(lookupIcon);
//			waitingTime(2000);
//			switchToLastWindow();
//			waitingTime(2000);
//			switchToFrame("searchFrame");
//			waitForElementsToBeVisible("globalSearch1");
//			waitingTime(2000);
//			type("globalSearc1h", excelColumnName);
//			pressEnter("globalSearch1");
//			waitForElementsToBeVisible("globalSearch1");
//			driver.switchTo().defaultContent();
//			switchToFrame("resultsFrame");
//
//			click("mheCOurseproductcatalog");
//			if (getBrowserName().equalsIgnoreCase("IE"))
//				waitingTime(2000);
//			// clickXpath(lookupResult);
//			driver.switchTo().window(Parentwindow);
//
//		} catch (Exception e) {
//			takeScreenShot();
//			driver.switchTo().window(Parentwin);
//			navigateTo("LoginTest", "Url");
//		}
//	}

	public boolean fetchValueFromDropdown(String objectRepoElement, String excelColumn) {
		boolean flag = false;
		String text = getExcelValue(getTestCaseName()).get(0).get(excelColumn);
		Select dropdown = new Select(getElement(objectRepoElement));
		WebElement value = dropdown.getFirstSelectedOption();
		String selectedoption = value.getText();
		System.out.println("Selected element: " + selectedoption);
		if (selectedoption.equalsIgnoreCase(text)) {
			flag = true;
			test.log(LogStatus.INFO, "Value selected" + selectedoption);

		}
		return flag;

	}

	public boolean fetchValueFromDropdown_propertiesFile(String objectRepoElement, String prop_data) {
		boolean flag = false;
		String text = getTestDataFromPropertiesFile(prop_data);
		Select dropdown = new Select(getElement(objectRepoElement));
		WebElement value = dropdown.getFirstSelectedOption();
		String selectedoption = value.getText();
		System.out.println("Selected element: " + selectedoption);
		if (selectedoption.equalsIgnoreCase(text)) {
			flag = true;
			test.log(LogStatus.INFO, "Value selected" + selectedoption);

		}
		return flag;

	}

	public String getDynamicXpathProperty(String locator1, String name, String locator2) {
		String objectRepoElement = OR.getProperty(locator1) + name + OR.getProperty(locator2);
		return objectRepoElement;
	}

	public void waitUntilOpportunityClones() {
		for (int i = 0; i <= 50; i++) {
			if (isElementPresent("cloningOpportunityLoader")) {
				System.out.println("Cloning Opportunity under Process...");
				i++;
			} else {
				break;
			}

		}

	}

	public void selectDropdownByIndex(String objectRepoElement, String excelCoulumn) {
		String text = getExcelValue(testCaseName).get(0).get(excelCoulumn);
		int index = Integer.parseInt(text);
		if (!text.isEmpty()) {
			test.log(LogStatus.INFO, "Searching text: " + text + " in " + objectRepoElement + " dropdown");
			Select dropdown = new Select(getElement(objectRepoElement));
			dropdown.selectByIndex(index);
			test.log(LogStatus.PASS, "Selected option: " + text);
		}
	}

	public void selectDropdownByIndex_propertiesFile(String objectRepoElement, String prop_data) {
		String text = getTestDataFromPropertiesFile(prop_data);
		int index = Integer.parseInt(text);
		if (!text.isEmpty()) {
			test.log(LogStatus.INFO, "Searching text: " + text + " in " + objectRepoElement + " dropdown");
			Select dropdown = new Select(getElement(objectRepoElement));
			dropdown.selectByIndex(index);
			test.log(LogStatus.PASS, "Selected option: " + text);
		}
	}

	public void selectDropdownByValue(String objectRepoElement, String excelCoulumn) {
		String text = getExcelValue(testCaseName).get(0).get(excelCoulumn);
		// int index= Integer.parseInt(text);
		if (!text.isEmpty()) {
			test.log(LogStatus.INFO, "Searching text: " + text + " in " + objectRepoElement + " dropdown");
			Select dropdown = new Select(getElement(objectRepoElement));
			dropdown.selectByValue(text);
			test.log(LogStatus.PASS, "Selected option: " + text);
		}
	}

	public void selectDropdownByValue_propertiesFile(String objectRepoElement, String prop_data) {
		String text = getTestDataFromPropertiesFile(prop_data);
		// int index= Integer.parseInt(text);
		if (!text.isEmpty()) {
			test.log(LogStatus.INFO, "Searching text: " + text + " in " + objectRepoElement + " dropdown");
			Select dropdown = new Select(getElement(objectRepoElement));
			dropdown.selectByValue(text);
			test.log(LogStatus.PASS, "Selected option: " + text);
		}
	}

	public void waitUntilLoaderLoadsOne() {
		for (int i = 0; i <= 90; i++) {
			if (isElementPresent("loaderForOpportunityList")) {
				System.out.println("Still Processing...");
				i++;
			} else {
				break;
			}

		}

	}

	public void selectDropdownIndex(String objectRepoElement) {

		Select dropdown = new Select(getElement(objectRepoElement));
		dropdown.selectByIndex(4);
	}

	public String fetchTextFromDropdown(String objectRepoElement) {

		Select dropdown = new Select(getElement(objectRepoElement));
		WebElement value = dropdown.getFirstSelectedOption();
		String selectedoption = value.getText();
		System.out.println("Selected element: " + selectedoption);
		return selectedoption;

	}

	public void handleAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}

	public void lastRowFetchingFromTable(String objectRepoElement, String loc1, String loc2) {
		WebElement table = getElement(objectRepoElement);
		List<WebElement> rowsList = table.findElements(By.tagName("tr"));
		int lastRow = rowsList.size() - 1;
		String val = String.valueOf(lastRow);

		String xpath = getDynamicXpathData(loc1, val, loc2);
		clickXpath(xpath);

	}

	/**
	 * @author Sayan Halder start -----
	 **/
//	public Boolean waitTillElementEnabled(String strElementXPATH, String strObjectName, int intWaitTime)
//			throws Exception {
//		try {
//			(new WebDriverWait(this.driver, (long) intWaitTime))
//					.until(ExpectedConditions.elementToBeClickable(By.xpath(strElementXPATH)));
//			return true;
//		} catch (Exception e) {
//			test.log(LogStatus.FAIL, "Error while waiting for the element " + strObjectName
//					+ " with xpath=>" + strElementXPATH.replace("\"", "'") + " to be enabled. Error message=>"
//					+ e.getMessage());
//			return false;
//		}
//	}

	public boolean pressEnterKeyUsingActionBuilder(int intNoOfTimes) throws Exception {
		try {
			Actions actions = new Actions(driver);

			for (int intCount = 0; intCount < intNoOfTimes; ++intCount) {
				// actions.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
				actions.sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(100L);

			}
			test.log(LogStatus.PASS, "Enter key pressed " + intNoOfTimes + " times using action builder");
			return true;
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to press Enter key " + intNoOfTimes
					+ " times using action builder. Error => " + e.getMessage());
			return false;
		}
	}

	public Boolean switchiFrame() throws Exception {
		try {
			this.driver.switchTo().frame(0);
			test.log(LogStatus.PASS, "Switched to iframe in browser");
			System.out.println("Switched to iframe in browser");
			return true;
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed in switching to iframe in browser => " + e.getMessage());
			System.out.println("Failed in switching to iframe in browser => " + e.getMessage());
			return false;
		}
	}

	public Boolean switchiFrame(int intIndex) throws Exception {
		try {
			this.driver.switchTo().frame(intIndex - 1);
			test.log(LogStatus.PASS, "Switched to iframe " + intIndex + " in browser");
			return true;
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed in switching to iframe " + intIndex + " in browser => " + e.getMessage());
			return false;
		}
	}

	public void waiting(int seconds) throws InterruptedException {
		Thread.sleep((long) (seconds * 1000));
	}

	public void waiting(double seconds) throws InterruptedException {
		Thread.sleep((long) (seconds * 1000.0D));
	}
	
	public boolean IsCheckBoxSelected(String objectRepoElement) throws Exception {	
		WebElement checkboxElement = getElement(objectRepoElement);
			boolean isCheckboxSelected = (boolean) ((JavascriptExecutor) driver)
	                .executeScript("return window.getComputedStyle(arguments[0], '::after').getPropertyValue('content') !== 'none'", checkboxElement);
			return isCheckboxSelected;
		}

	public boolean checkElementIsSelected(String objectRepoElement) throws Exception {
		boolean isObjSelected = false;
		try {
			if (getElement(objectRepoElement).isSelected()) {
				isObjSelected = true;
				test.log(LogStatus.PASS, "Element " + objectRepoElement
						+ " => Expected: should be selected => Actual: element is selected");
				System.out.println("Element " + objectRepoElement
						+ " => Expected: should be selected => Actual: element is selected");
				return isObjSelected;
			} else {
				isObjSelected = false;
//				test.log(LogStatus.FAIL,
//						"Element " + objectRepoElement + " is expected to be selected but not selected");
				System.out.println("Element " + objectRepoElement + " is not selected");
				return isObjSelected;
			}
		} catch (Exception e) {
			System.out.println("Inside checkElementIsSelected Catch");
			isObjSelected = false;
//			test.log(LogStatus.FAIL,
//					"Failed whiled checking element " + objectRepoElement + " is selected or not " + e.getMessage());
			System.out.println(
					"Failed whiled checking element " + objectRepoElement + " is selected or not " + e.getMessage());
			return isObjSelected;
		}

	}

	public boolean checkElementIsSelectedorNot(String objectRepoElement) throws Exception {
		boolean isObjSelected = false;
		try {
			if (getElement(objectRepoElement).isSelected()) {
				isObjSelected = true;
				test.log(LogStatus.INFO, "Element " + objectRepoElement
						+ " => Expected: should be selected => Actual: element is selected");
				System.out.println("Element " + objectRepoElement
						+ " => Expected: should be selected => Actual: element is selected");
				return isObjSelected;
			} else {
				isObjSelected = false;
				test.log(LogStatus.INFO,
						"Element " + objectRepoElement + " is expected to be selected but not selected");
				System.out.println("Element " + objectRepoElement + " is not selected");
				return isObjSelected;
			}
		} catch (Exception e) {
			System.out.println("Inside checkElementIsSelected Catch");
			isObjSelected = false;
			test.log(LogStatus.FAIL,
					"Failed whiled checking element " + objectRepoElement + " is selected or not " + e.getMessage());
			System.out.println(
					"Failed whiled checking element " + objectRepoElement + " is selected or not " + e.getMessage());
			return isObjSelected;
		}

	}
	
	public boolean checkObjectWithXpathExists(String objectRepoXpathElement, String objStrName) throws Exception {
		if (waitForXpathElementToBeClickable(objectRepoXpathElement)) {
			test.log(LogStatus.PASS, "Element " + objStrName + " is visible");
			System.out.println("PASS");
			System.out.println("Element " + objStrName + " is visible");
			return true;
		} else {
			test.log(LogStatus.FAIL, "Element " + objStrName + " is not visible but it is expected to be displayed");
			System.out.println("FAIL");
			System.out.println("Element " + objStrName + " is not visible but it is expected to be displayed");
			return false;
		}
	}

	public boolean checkObjectExists(String objectRepoElement, String objStrName) throws Exception {
		if (waitForElementToBeVisible(objectRepoElement)) {
			test.log(LogStatus.PASS, "Element " + objStrName + " is visible");
			System.out.println("Element " + objStrName + " is visible");
			return true;
		} else {
			test.log(LogStatus.FAIL, "Element " + objStrName + " is not visible but it is expected to be displayed");
			System.out.println("Element " + objStrName + " is not visible but it is expected to be displayed");
			return false;
		}
	}

	public boolean verifyTextEquals(String expectedTitle, String actualTitle) throws Exception {
		if (expectedTitle.equals(actualTitle)) {
			test.log(LogStatus.PASS, "New Calendar Event Page Title Matched => Actual => " + actualTitle
					+ " Expected => " + expectedTitle);
			System.out.println("New Calendar Event Page Title Matched => Actual => " + actualTitle + " Expected => "
					+ expectedTitle);
			return true;
		} else {
			test.log(LogStatus.FAIL, "New Calendar Event Page Title Not Matched => Actual => " + actualTitle
					+ " Expected => " + expectedTitle);
			System.out.println("New Calendar Event Page Title Not Matched => Actual => " + actualTitle + " Expected => "
					+ expectedTitle);
			return false;
		}
	}

	public String getCurrentDateTimeString(String dateTimeFormatStr) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateTimeFormatStr);
		Date date = new Date();
		return formatter.format(date);
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public Properties getPropertiesObj() {
		return this.OR;
	}

	public Properties getPropertiesObj2() {
		return this.TestData;
	}

	public Properties getPropertiesObj3() {
		return this.isTestExecutable;
	}

	public String fetchSelectedOptionFromDropdown(String objectRepoElement) {
		Select dropdown = new Select(getElement(objectRepoElement));
		WebElement value = dropdown.getFirstSelectedOption();
		String selectedoption = value.getText();
		return selectedoption;
	}

	public void clickDynamicUsingXpath(String locator1, String data, String locator2) {
		String xpath = null;
		try {
			waitingTime(2000);
			xpath = OR.getProperty(locator1) + data + OR.getProperty(locator2);
			test.log(LogStatus.INFO, "Clicking on " + xpath);
			waitingTime(2000);
			clickLoopXpath(xpath);
		} catch (Exception e) {
			System.out.println("Inside clickDynamicUsingXpath Catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			reportFailure(xpath + " could not be clicked");
		}
	}

	public void mouseHover(String objectRepoElement) {
		Actions mouse = new Actions(driver);
		mouse.moveToElement(getElement(objectRepoElement)).build().perform();
	}
	
	public void mouseHoverAndClick(String objectRepoElement) {
		Actions mouse = new Actions(driver);
		mouse.moveToElement(getElement(objectRepoElement)).click().build().perform();
	}

	public boolean retryingWaitForVisibility(String objectRepoElement) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 6) {
			try {
				result = waitForElementToBeVisible(objectRepoElement);
				if (result == true) {
					System.out.println("Element visible now");
					break;
				}

			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void searchGlobal(String excelColumnName) {
		String excelValue = getExcelValue(getTestCaseName()).get(0).get(excelColumnName);
		getElement("searchTextL").sendKeys(excelValue);
		waitingTime(4000);
		click("searchTextL");
		getElement("searchTextL").sendKeys(Keys.ENTER);
		waitingTime(4000);
	}

	public void searchGlobal_propertiesFile(String prop_data) {
		String value = getTestDataFromPropertiesFile(prop_data);
		getElement("searchTextL").sendKeys(value);
		waitingTime(4000);
		click("searchTextL");
		getElement("searchTextL").sendKeys(Keys.ENTER);
		waitingTime(4000);
	}

	public boolean waitForAlertToBeVisible() {
//		wait = new WebDriverWait(driver, 90);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40, 1));
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			test.log(LogStatus.PASS, "Element is visible");
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickNew(String objectRepoElement) {

		test.log(LogStatus.INFO, "Clicking on " + objectRepoElement);
		System.out.println("Clicking on " + objectRepoElement);
		waitForElementToBeClickable(objectRepoElement);
		getElement(objectRepoElement).click();

	}

	public void searchString(String name) {
		getElement("searchTextL").sendKeys(name);
		waitingTime(4000);
		click("searchTextL");
		getElement("searchTextL").sendKeys(Keys.ENTER);
		waitingTime(6000);
	}

	public String getCurrentUSDate(String format) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(format);
		df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
		System.out.println("Date and time in Madrid: " + df.format(date));
		return df.format(date);
	}

	public void clickLastXpath(String objectRepoElement) {
		try {
			int eleSize = getElements(objectRepoElement).size();
			String elementSize = Integer.toString(eleSize);
			String xpath = "(" + getPropertiesObj().getProperty(objectRepoElement) + ")[" + elementSize + "]";
			test.log(LogStatus.INFO, "Clicking on " + xpath);
			System.out.println("Clicking on " + xpath);
			waitForXpathElementToBeVisible(xpath);
			getXpathElement(xpath).click();
		} catch (Exception e) {
			System.out.println("Inside clickLastXpath Catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			reportFailure(objectRepoElement + " could not be clicked");
		}
	}

	public String getLastXpath(String objectRepoElement) {
		String xpath = null;
		try {
			int eleSize = getElements(objectRepoElement).size();
			String elementSize = Integer.toString(eleSize);
			xpath = "(" + getPropertiesObj().getProperty(objectRepoElement) + ")[" + elementSize + "]";
			test.log(LogStatus.INFO, "Xpath " + xpath);
			waitForXpathElementToBeVisible(xpath);

		} catch (Exception e) {
			System.out.println("Inside getLastXpath Catch");
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Test Case Failed");
			reportFailure("Test Case Failed" + e.getMessage());
			reportFailure(objectRepoElement + " could not found");
		}
		return xpath;
	}

	public void resetDriver() {
		chDriver = null;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	public void acceptAlertPopup() {
		System.out.println("accepting alert");
		driver.switchTo().alert().accept();
	}

	@SuppressWarnings("unchecked")
	public void dynamicIDvalues() {

		int rownumber = xls.getRowCount("ID");

		for (int rownum = 2; rownum <= 209; rownum++) {
			try {
				String orderStage = xls.getCellData("ID", "Order Stage", rownum).trim();
				String requestReason = xls.getCellData("ID", "Request Reason", rownum).trim();
				String subReason = xls.getCellData("ID", "Sub Reason", rownum).trim();
				String action = xls.getCellData("ID", "Action", rownum).trim();
				// String internalDescription = xls.getCellData("ID", "Internal Description
				// Header Template", rownum).trim();

				waitForElementToBeClickable("internalDescription1text");
				waitingTime(4000);
				jsClick("internalDescription1text");
				System.out.println("inside ID1");
				waitingTime(4000);

				jsClick("OrderStagebtn");
				System.out.println("inside first order stage");
				waitingTime(4000);
				jsClickXpath(getDynamicAccountXpath("spanTitle", orderStage, "end"));
				waitingTime(4000);

				jsClick("ReasonCodebtn");
				System.out.println("inside first request reason");
				waitingTime(4000);
				jsClickXpath(getDynamicAccountXpath("spanTitle", requestReason, "end"));
				waitingTime(4000);

				boolean enabled = checkElementIsEnabled("SubReasonbtn");
				if (enabled == true) {
					clickNew("SubReasonbtn");
					System.out.println("inside first sub reason");
					waitingTime(4000);
					jsClickXpath(getDynamicAccountXpath("spanTitle", subReason, "end"));
					waitingTime(4000);
				}

				jsClick("Actionbtn");
				System.out.println("inside first action");
				waitingTime(4000);
				jsClickXpath(getDynamicAccountXpath("spanTitle", action, "end"));
				waitingTime(4000);

				waitForElementToBeClickable("internalDescription2text");
				waitingTime(4000);
				jsClick("internalDescription2text");
				System.out.println("inside ID2");
				waitingTime(4000);

				jsClick("OrderStage2btn");
				System.out.println("inside second order stage");
				waitingTime(4000);
				jsClickXpath(getDynamicAccountXpath("spanTitle", orderStage, "end"));
				waitingTime(4000);

				jsClick("ReasonCode2btn");
				System.out.println("inside second request reason");
				waitingTime(4000);
				jsClickXpath(getDynamicAccountXpath("spanTitle", requestReason, "end"));
				waitingTime(4000);

				boolean enabled2 = checkElementIsEnabled("SubReason2btn");
				if (enabled2 == true) {
					clickNew("SubReason2btn");
					System.out.println("inside second sub reason");
					waitingTime(4000);
					jsClickXpath(getDynamicAccountXpath("spanTitle", subReason, "end"));
					waitingTime(4000);
				}

				jsClick("Action2btn");
				System.out.println("inside second action");
				waitingTime(4000);
				jsClickXpath(getDynamicAccountXpath("spanTitle", action, "end"));
				waitingTime(4000);

				xls.setCellData("ID", "Pass/Fail", rownum, "Pass");
				System.out.println("Passed row number is:" + rownum);

			} catch (Exception e) {

				xls.setCellData("ID", "Pass/Fail", rownum, "Fail");
				System.out.println("Failed row number is:" + rownum);

			}
		}
	}

	public boolean checkElementIsEnabled(String objectRepoElement) throws Exception {
		boolean isObjEnabled = false;

		if (getElement(objectRepoElement).isEnabled()) {
			isObjEnabled = true;
			return isObjEnabled;
		} else {
			isObjEnabled = false;
			return isObjEnabled;
		}

	}

	public void checkObjectHistory() {
		try {
			test.log(LogStatus.INFO, "Checking Object History Link in Page Layout");
			if (isElementPresentFast("ObjectHistoryLink")) {
				test.log(LogStatus.FAIL, "Object History link is present in the page layout!");
				reportFailure("Object History link is present in the page layout!");
//				takeScreenShot();
				waitingTime(2000);
				System.out.println("FAIL");
			} else {
				test.log(LogStatus.PASS, "Object History link is not present in the page layout!");
				System.out.println("PASS");
//				takeScreenShot();
				waitingTime(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			reportFailure("Error while verifying object hisotry link in page layout!");
		}
	}

	public void createCaseAndValidateCategory() {
		List<String> invalidCat1OptionsList = new ArrayList<>();
		Map<String, List<String>> invalidCat2Options = new HashMap<String, List<String>>();
		boolean dataIsValid = true;
		boolean cat1IsValid = true;
		boolean cat2IsValid = true;
		boolean cat3IsValid = true;
		int rowNumber = xls.getRowCount("CaseCategoryFields");
		String previousRecordType = "";
		String category1PreviousValue = "";
		String category2PreviousValue = "";
		String category3PreviousValue = "";
		for (int currentRow = 2; currentRow <= rowNumber; currentRow++) {
			try {
				String recordType = xls.getCellData("CaseCategoryFields", "Record Type", currentRow).trim();
				String category1Value = xls.getCellData("CaseCategoryFields", "Category 1", currentRow).trim();
				String category2Value = xls.getCellData("CaseCategoryFields", "Category 2", currentRow).trim();
				String category3Value = xls.getCellData("CaseCategoryFields", "Category 3", currentRow).trim();
				List<String> invalidCat2OptionsList = invalidCat2Options.get(category1Value);
				boolean cat2ValueIsInList = invalidCat2OptionsList == null ? false
						: invalidCat2OptionsList.contains(category2Value);

				if (!previousRecordType.equals(recordType)) {
					if (!previousRecordType.equals("")) {
						System.out.println("Cancelling current Case");
						click("CancelButton");
						navigateToCasesTab();
					}
					createNewCaseFromCasesTab(recordType);
					previousRecordType = recordType;
					invalidCat1OptionsList.clear();
					invalidCat1OptionsList.clear();
					invalidCat2Options.clear();
				}

				cat1IsValid = (!invalidCat1OptionsList.contains(category1Value))
						? clickOnCasePicklist("Category 1", category1Value, category1PreviousValue)
						: false;
				cat2IsValid = cat1IsValid && !cat2ValueIsInList
						? clickOnCasePicklist("Category 2", category2Value, category2PreviousValue)
						: false;
				cat3IsValid = cat2IsValid ? clickOnCasePicklist("Category 3", category3Value, category3PreviousValue)
						: false;

				if (cat1IsValid && cat2IsValid && cat3IsValid) {
					xls.setCellData("CaseCategoryFields", "Test Result", currentRow, "Passed");
					System.out.println("Passed row number:" + currentRow);
				} else {
					xls.setCellData("CaseCategoryFields", "Test Result", currentRow, "FAILED! C1 valid:" + cat1IsValid
							+ " C2 valid:" + cat2IsValid + " C3 valid:" + cat3IsValid);
					System.out.println("FAILED! C1 valid:" + cat1IsValid + " C2 valid:" + cat2IsValid + " C3 valid:"
							+ cat3IsValid);
					System.out.println("Failed row number:" + currentRow);
					dataIsValid = false;
					if (!cat1IsValid && !invalidCat1OptionsList.contains(category1Value)) {
						invalidCat1OptionsList.add(category1Value);
						System.out.println("Adding value to invalid list: " + category1Value);
					}
					if (cat1IsValid && !cat2IsValid && !cat2ValueIsInList) {
						if (invalidCat2OptionsList == null)
							invalidCat2OptionsList = new ArrayList<String>();
						invalidCat2OptionsList.add(category2Value);
						invalidCat2Options.put(category1Value, invalidCat2OptionsList);
						System.out.println("Adding value to " + category1Value + " invalid list: " + category2Value);
					}
				}
				category1PreviousValue = category1Value;
				category2PreviousValue = category2Value;
				category3PreviousValue = category3Value;

			} catch (Exception e) {
				xls.setCellData("CaseCategoryFields", "Test Result", currentRow, "Failed: " + e.getMessage());
				System.out.println("Failed row (" + currentRow + "): " + e.getMessage());
				dataIsValid = false;
			}
		}
		if (!dataIsValid) {
			test.log(LogStatus.FAIL, "Category fields verification failed.");
			reportFailure("Category fields verification failed.");
		}
	}

	public void navigateToCasesTab() {
		waitForElementToBeClickable("menuDots");
		click("menuDots");
		waitingTime(3000);
		waitForElementToBeVisible("searchItemsTextField");
		typeData("searchItemsTextField", "Cases");
		waitForElementToBeClickable("casesOptionMenuDots");
		jsClick("casesOptionMenuDots");
		System.out.println("Navigated successfully to Cases Tab");
		waitingTime(3000);
	}

	public void createNewCaseFromCasesTab(String recordTypeData) {
		System.out.println("Creating New Case of Record Type: " + recordTypeData);
		waitingTime(5000);
		click("NewButtonToAdd");
		waitingTime(5000);
		clickXpath(getDynamicXpathData("RecordTypeText", recordTypeData, "end"));
		click("nextBtn");
		System.out.println("Navigated successfully to New Case Page");
		waitingTime(5000);
	}

	public boolean clickOnCasePicklist(String picklistName, String picklistValue, String previousValue) {
		boolean rowIsValid = true;
		String picklistXpath = getDynamicXpathData("CasePicklistText", picklistName, "CasePicklistEnd");
		String picklistValueXpath = getDynamicXpathData("anchorTitleLabelSafe", picklistValue, "endLabelSafe");
		String picklistNameXpath = getDynamicXpathData("Text_Span", picklistName, "end");
		if (picklistValue.equals("") || picklistValue.equals(previousValue)) {
			System.out.println("Not clicking " + picklistName
					+ " field since value is empty or same as previous value: " + picklistValue);
			return rowIsValid;
		}
		try {
			waitingTime(1000);
			clickXpath(picklistXpath);
			waitingTime(1000);
			clickXpath(picklistValueXpath);
		} catch (AssertionError ae) {
			rowIsValid = false;
			test.log(LogStatus.INFO, "Error while clicking " + picklistName + " field: " + ae.getMessage());
			System.out.println("Error while clicking " + picklistName + " field: " + ae.getMessage());
			clickXpath(picklistNameXpath);
		}
		return rowIsValid;
	}

	public void dynamicvalues() {
		waitingTime(3000);
		// String caseTabXpath = "//a[text()='Cases']";
		// String caseTabXpath = "//li[@id='Case_Tab']/a";
		// String newBtnXpath = "//input[@title='New']";
		// String RTDD = "//select[@id=\"p3\"]";
		// String RTDD_val= "//option[text()=\"SEG Product Support\"]";
		// WebElement caseTab = driver.findElement(By.xpath("//a[text()='Cases']"));
		// click("CloseBtn_case");
		click("caseTabXpath");
		click("newBtnXpath");
		click("RTDD");
		click("RTDD_val");
		click("continueBtn");

		waitingTime(5000);
		// int rownumber=xls.getRowCount("TestDropDownValues");
		System.out.println("Start picklist selection...");
		for (int rownum = 2; rownum <= 381; rownum++) {
			System.out.println("current row.. " + rownum);

			try {

				String inquiryType = xls.getCellData("AllFails", "Inquirytype Value", rownum).trim();
				String productType = xls.getCellData("AllFails", "Producttype Value", rownum).trim();
				String productValue = xls.getCellData("AllFails", "Product Value", rownum).trim();
				String incidentValue = xls.getCellData("AllFails", "Incident Value", rownum).trim();
				String subincidentValue = xls.getCellData("AllFails", "SubIncident Value", rownum).trim();
				String reportedIssue = xls.getCellData("AllFails", "Reported Issue", rownum).trim();
				String resolutionType = xls.getCellData("AllFails", "Resolution Type", rownum).trim();

				// String inquiryType =xls.getCellData("TestDropDownValues", "Inquirytype
				// Value", rownum).trim();
				// String productType = xls.getCellData("TestDropDownValues", "Producttype
				// Value", rownum).trim();
				// String productValue = xls.getCellData("TestDropDownValues","Product Value",
				// rownum).trim();
				// String incidentValue = xls.getCellData("TestDropDownValues", "Incident
				// Value", rownum).trim();
				// String subincidentValue =xls.getCellData("TestDropDownValues", "SubIncident
				// Value", rownum).trim();
				// String reportedIssue = xls.getCellData("TestDropDownValues", "Reported
				// Issue", rownum).trim();
				// String resolutionType = xls.getCellData("TestDropDownValues", "Resolution
				// Type", rownum).trim();

				// waitForElementToBeClickable("InquiryType");
				// waitingTime(2000);
				// jsClick("InquiryType");
				// click("InquiryType");
				// waitingTime(2000);
				selectDropdownTextNew("InquiryType_case", inquiryType);
				waitingTime(500);
				selectDropdownTextNew("ProductType_case", productType);
				waitingTime(500);
				selectDropdownTextNew("Product_case", productValue);
				waitingTime(500);
				selectDropdownTextNew("Incident_case", incidentValue);
				waitingTime(500);
				selectDropdownTextNew("SubIncident_case", subincidentValue);
				waitingTime(500);
				selectDropdownTextNew("ReportedIssue_case", reportedIssue);
				waitingTime(500);
				selectDropdownTextNew("ResolutionType_case", resolutionType);
				waitingTime(500);

				// selectDropdownText(getDynamicAccountXpath("anchorTitle", inquiryType, "end"))
				// click(getDynamicAccountXpath("anchorTitle", inquiryType, "end"));
				// jsNewClickXpath(getDynamicAccountXpath("anchorTitle", inquiryType, "end"));

				// waitForElementToBeClickable("ProductType");
				// waitingTime(2000);
				/*
				 * click("ProductType");
				 *
				 * waitingTime(4000);
				 * //waitForElementToBeClickable(getDynamicAccountXpath("anchorTitle",
				 * productType, "end")); jsNewClickXpath(getDynamicAccountXpath("anchorTitle",
				 * productType, "end"));
				 *
				 *
				 * //waitForElementToBeClickable("Product"); //waitingTime(2000);
				 * jsClick("Product"); waitingTime(4000);
				 * //waitForElementToBeClickable(getDynamicAccountXpath("anchorTitle",
				 * productValue, "end")); jsNewClickXpath(getDynamicAccountXpath("anchorTitle",
				 * productValue, "end"));
				 *
				 * //waitForElementToBeClickable("Incident"); //waitingTime(2000);
				 * jsClick("Incident"); waitingTime(4000);
				 * //waitForElementToBeClickable(getDynamicAccountXpath("anchorTitle",
				 * incidentValue, "end")); jsNewClickXpath(getDynamicAccountXpath("anchorTitle",
				 * incidentValue, "end"));
				 *
				 * //waitForElementToBeClickable("SubIncident"); //waitingTime(2000);
				 * jsClick("SubIncident"); waitingTime(4000);
				 * //waitForElementToBeClickable(getDynamicAccountXpath("anchorTitle",
				 * subincidentValue, "end"));
				 * jsNewClickXpath(getDynamicAccountXpath("anchorTitle", subincidentValue,
				 * "end"));
				 *
				 * //waitForElementToBeClickable("ReportedIssue"); //waitingTime(2000);
				 * jsClick("ReportedIssue"); waitingTime(4000);
				 * //waitForElementToBeClickable(getDynamicAccountXpath("anchorTitle",
				 * reportedIssue, "end")); jsNewClickXpath(getDynamicAccountXpath("anchorTitle",
				 * reportedIssue, "end"));
				 *
				 * //waitForElementToBeClickable("ResolutionType"); //waitingTime(2000);
				 * jsClick("ResolutionType"); waitingTime(4000);
				 * //waitForElementToBeClickable(getDynamicAccountXpath("anchorTitle",
				 * resolutionType, "end"));
				 * jsNewClickXpath(getDynamicAccountXpath("anchorTitle", resolutionType,
				 * "end"));
				 */

				xls.setCellData("AllFails", "Pass/Fail", rownum, "Pass");
				// xls.setCellData("TestDropDownValues", "Pass/Fail", rownum, "Pass");
				System.out.println(rownum + " : Pass");

			} catch (Exception e) {

				xls.setCellData("AllFails", "Pass/Fail", rownum, "Fail");
				xls.setCellData("AllFails", "Failed_Data", rownum, excelColumnName);
				// xls.setCellData("TestDropDownValues", "Pass/Fail", rownum, "Fail");
				// xls.setCellData("TestDropDownValues", "Failed_Data", rownum,
				// excelColumnName);
				System.out.println(rownum + " : Fail");

			}
			// System.out.println(rownum);
		}
	}

	public String getDynamicXpath_featurefile(String locator1, String featurefile_data, String locator2) {
		String objectRepoElement = OR.getProperty(locator1) + getTestDataFromPropertiesFile(featurefile_data)
				+ OR.getProperty(locator2);
		return objectRepoElement;
	}

	public void selectDropdownTextNew(String objectRepoElement, String excelCoulumn) {
		// String text = getExcelValue(testCaseName).get(0).get(excelCoulumn);
		// if (!text.isEmpty()) {
		// test.log(LogStatus.INFO, "Searching text: " + text + " in " +
		// objectRepoElement + " dropdown");
		excelColumnName = excelCoulumn;
		Select dropdown = new Select(getElement(objectRepoElement));
		dropdown.selectByVisibleText(excelCoulumn);
		test.log(LogStatus.PASS, "Selected option: " + excelCoulumn);
		// }
	}

	public void dropdownvalues() {
		waitingTime(3000);
		System.out.println("Start picklist selection...");
		scrollToElement("ProductGroupPicklist");
		System.out.println("Reached picklist element");
		for (int rownum = 2; rownum <= 67; rownum++) {
			System.out.println("current row.. " + rownum);

			try {

				String productGroupPicklist = xls.getCellData("ProductGroup", "ProductGroup Value", rownum).trim();
				System.out.println(productGroupPicklist);
				String PicklistValues = getDynamicXpathData("Text_Span", productGroupPicklist, "end");
				jsClickXpath(PicklistValues);
				if (isElementPresentXpath(PicklistValues)) {
					waitingTime(2000);

					test.log(LogStatus.PASS, "Selected option: " + productGroupPicklist);
					System.out.println("This is PASS");

					xls.setCellData("ProductGroup", "Pass/Fail", rownum, "Pass");
					System.out.println(rownum + " : Pass");
				} else {
					xls.setCellData("ProductGroup", "Pass/Fail", rownum, "Fail");
					System.out.println(rownum + " : Fail");
				}
			}

			catch (Exception e) {
				System.out.println(e.getMessage());

			}
		}
	}

	public String ExtractTextWithinSingleQuotes(String input) {
		System.out.println("Input msg is: " + input);
		String extractedText = null;
		// Define the regular expression pattern
		Pattern pattern = Pattern.compile("'([^']*)'");

		// Match the pattern against the input string
		Matcher matcher = pattern.matcher(input);

		// Check if a match is found
		if (matcher.find()) {
			// Extract the text within single quotes
			extractedText = matcher.group(1);

			// Print the extracted text
			System.out.println("Extracted text is :" + extractedText);
			return extractedText;
		}
		return extractedText;
	}

	public String getFutureDate(int daysToAdd) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, daysToAdd);
		Date futureDate = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
		String formattedDate = dateFormat.format(futureDate);
		System.out.println("->" + formattedDate);
		return formattedDate;
	}

	public int getRowCountFromSpecificSheet(String sheetName) {
		return xls.getRowCount(sheetName);
	}	
	
	public int getRowCountFromSpecificSheetE2C(String sheetName, Xls_Reader xlName) {
		return xlName.getRowCount(sheetName);
	}	
	
	public String getCellDataFromSpecificSheet(String sheetName, String columnName, int rowNumber) {
		return xls.getCellData(sheetName, columnName, rowNumber).trim();
	}	
	
	public String getCellDataFromSpecificSheetE2C(String sheetName, String columnName, int rowNumber, Xls_Reader xlName) {
		return xlName.getCellData(sheetName, columnName, rowNumber).trim();
	}
	
	
	public void setCellDataOnSpecificSheet(String sheetName, String columnName, int rowNumber, String data) {
		xls.setCellData(sheetName, columnName, rowNumber, data);
	}	

	public void setCellDataOnSpecificSheetE2C(String sheetName, String columnName, int rowNumber, String data, Xls_Reader xlName) {
		xlName.setCellData(sheetName, columnName, rowNumber, data);
	}
}
