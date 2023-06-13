package Section16CodeTestNG;

import java.text.MessageFormat;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Section16CodeTestNG01 {

	@BeforeTest
	public void Setup() {
		String messageString = "Test Setup";
		System.out.println(MessageFormat.format("Message: {0}", messageString));
	}

	// Execution is based on alphabetical order of test names
	@Test(groups = { "Smoke" })
	public void TestNG_01() {
		String messageString = "TestNG_01";
		System.out.println(MessageFormat.format("Message: {0}", messageString));
		Assert.assertTrue(false);
	}

	@Test
	public void TestNG_02() {
		String messageString = "TestNG_02";
		System.out.println(MessageFormat.format("Message: {0}", messageString));

	}

	@AfterTest
	public void Teardown() {
		String messageString = "Test Teardown";
		System.out.println(MessageFormat.format("Message: {0}", messageString));
	}
}
