package Section16CodeTestNG;

import java.text.MessageFormat;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Section16CodeTestNG03 {

	@BeforeMethod
	public void MethodSetup() {
		String messageString = "Method Setup";
		System.out.println(MessageFormat.format("Message: {0}", messageString));
	}

	@Test
	public void TestNGWebLoginCarLoan_05() {
		// Selenium
		String messageString = "WebLoginCarLoan_05";
		System.out.println(MessageFormat.format("Message: {0}", messageString));
	}

	@Test
	public void TestNGMobileLoginCarLoan_06() {
		// Appium
		String messageString = "MobileLoginCarLoan_06";
		System.out.println(MessageFormat.format("Message: {0}", messageString));
	}

	@Parameters({ "URL" })
	@Test(groups = { "Smoke" })
	public void TestNGAPILoginCarLoan_07(String urlName) {
		// Rest API automation
		String messageString = "APILoginCarLoan_07";
		System.out.println(MessageFormat.format("Message: {0}", messageString));
		System.out.println(MessageFormat.format("URL Parameter: {0}", urlName));
	}

	@AfterMethod
	public void MethodTeardown() {
		String messageString = "Method Teardown";
		System.out.println(MessageFormat.format("Message: {0}", messageString));
	}
}
