package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver = null;

	public static Properties prop;

	public static FileInputStream ip;

	public static Logger logger;

	//public static final String testDataExcelFileName = "TestData.xlsx";

	public TestBase() {
		prop = new Properties();

		try {
			ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\Config\\config.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void initialize() {

		if (prop.getProperty("browser").equals("chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver","C://driver/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		// To maximize browser
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// To open site
		driver.get(prop.getProperty("url"));
	}

	@BeforeClass
	public void setup() {

		logger = Logger.getLogger("PTCIntegrity");
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\test-output\\log4j.properties");
		logger.setLevel(Level.DEBUG);

	}

	@AfterSuite
	public void TeardownTest() {
		TestBase.driver.quit();
	}

}