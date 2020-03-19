package TestCase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Page.LoginPage;

public class LoginTest extends TestBase {

	LoginPage loginpage;

	@BeforeMethod
	public void setUp() {
		initialize();
		loginpage = new LoginPage(driver);
	}

	@Test
	public void login() {

		logger.info("######## Login ########");

		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
		logger.info("########Login Done Successfully########");

	}

}
