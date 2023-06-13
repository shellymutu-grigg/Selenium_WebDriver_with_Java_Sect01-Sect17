package Section16CodeTestNG;

import java.text.MessageFormat;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section16CodeTestNG04 {

	@BeforeClass
	public void ClassSetup() {
		String messageString = "Class Setup";
		System.out.println(MessageFormat.format("Message: {0}", messageString));
	}

	// Skip test
	@Test(enabled = false)
	public void TestNGWebLoginHomeLoan_08() {
		String messageString = "WebLoginHomeLoan_08";
		System.out.println(MessageFormat.format("Message: {0}", messageString));

	}

	@Test(groups = { "Smoke" })
	public void TestNGMobileLoginHomeLoan_09() {
		String messageString = "MobileLoginHomeLoan_09";
		System.out.println(MessageFormat.format("Message: {0}", messageString));

	}

	// Ensure the following method will only be executed after _09
	@Test(dependsOnMethods = { "TestNGMobileLoginHomeLoan_09" })
	public void TestNGAPILoginHomeLoan_10() {
		String messageString = "APILoginHomeLoan_10";
		System.out.println(MessageFormat.format("Message: {0}", messageString));

	}

	@AfterClass
	public void ClassTeardown() {
		String messageString = "Class Teardown";
		System.out.println(MessageFormat.format("Message: {0}", messageString));
	}
}
