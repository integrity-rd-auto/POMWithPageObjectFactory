package TestCase;

import org.testng.TestNG;

import utility.Reporting;

public class TestRunner {

	static TestNG testng;

	public static void main(String[] args) {

		Reporting extent = new Reporting();

		testng = new TestNG();

		testng.setTestClasses(new Class[] { LoginTest.class });
		
		testng.addListener(extent);

		testng.run();
		
			}

}
