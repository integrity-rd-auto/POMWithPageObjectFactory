package TestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import Base.TestBase;
import Page.HomePage;

public class HomePageTest extends TestBase {

	HomePage homepage;

	@BeforeMethod

	public void setUp() {

		homepage = new HomePage(driver);

	}

	@Test
	public void login() {

		logger.info("########Select New Customer########");

		homepage.selectnewCustomer();

		Assert.assertEquals(driver.getTitle(), "Guru99 Bank New Customer Entry Page");
		logger.info("########New Customer Page Loaded########");

	}

}
