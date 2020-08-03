package Base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utilities.Initializations;
import Utilities.Properties;

public class TestBaseSetup implements Initializations, Properties {

    public WebDriver driver;
    // static String driverPath = "D:\\chromedriver\";
    // static String driverPath = "/Users/sorchanian/Automation/";
    private String datapath;

    public WebDriver getDriver() {
	return driver;
    }

    //TODO:  Externalize the getDriver & new BasePage(driver)
    
    private void setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
    }

    private static WebDriver initChromeDriver(String appURL) { 
		System.out.println("Launching Google Chrome (headlessly) with new profile from directory:");

		System.setProperty("webdriver.chrome.driver", driverPathJenkins + "chromedriver");
		System.out.println(driverPathJenkins + "chromedriver");

		// WebDriverManager.chromedriver().setup();
		// Set chrome options to use Chrome in headless mode
		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("--headless","--window-size=1920,1200","--ignore-certificate-errors","user-data-dir=/Users/sorchanian/Library/Application\Support/Google/Chrome/Default/");

		try {
			//WebDriver driver = new ChromeDriver();
		    	Dimension d = new Dimension(1936,1176);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-dev-shm-usage");
			//chromeOptions.addArguments("--window-size=1382,784");
			chromeOptions.addArguments("--disable-infobars");
			chromeOptions.addArguments("--ignore-certificate-errors");
			//chromeOptions.addArguments("--start-maximized");
			WebDriver driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
			driver.manage().window().setSize(d);
			System.out.println(d);
			//driver.manage().window().fullscreen();
			driver.navigate().to(appURL);
			return driver;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
    }

    private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser");
		System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
    }

    @Parameters({ "browserType", "appURL" })
    @BeforeClass
    public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(browserType, appURL);
		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
			e.printStackTrace();
		}
    }

    @AfterClass
    public void tearDown() {
		driver.close();
		driver.quit();
    }

    @Override
    public void method1() {
	// TODO Auto-generated method stub

    }

    @Override
    public void method2() {
	// TODO Auto-generated method stub

    }

}
