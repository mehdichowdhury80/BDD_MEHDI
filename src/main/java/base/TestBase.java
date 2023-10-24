package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import constants.KeyConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import utils.ReadConfig;
import static constants.IBrowserConstant.*;
import java.time.Duration;


public class TestBase {

	static WebDriver driver;
ReadConfig config;
	
	
	public static HomePage homePage;
	
	public static WebDriver getDriver() {
		return driver;
	}
//	public static void beforeClassSetup() {
//		config = new ReadConfig();
//	}
	
	public void setUpDriver(String browserName) {
		config = new ReadConfig();
		driver = initializingBrowser(browserName);
		driver.manage().window().maximize();
		int pageLoadTime = Integer.parseInt(config.getValue(KeyConfig.pageLoadTime));
		int implicitWaitTime = Integer.parseInt(config.getValue(KeyConfig.impliciteWaitLoad));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
		driver.get(config.getValue(KeyConfig.url));
		initObjectClass();
	}
	
	public WebDriver initializingBrowser(String browserName) {
		switch (browserName) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
		case EDGE:
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			return new SafariDriver();
		default:
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		}
	}
	
	public void initObjectClass() {
		homePage = new HomePage(driver);
	}
	
	public void tearUp() {
		driver.quit();
	}
}
