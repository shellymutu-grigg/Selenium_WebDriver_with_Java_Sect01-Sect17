package Section16CodeTestNG;

import java.text.MessageFormat;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Section16CodeTestNG02 {

	@BeforeSuite
	public void SuiteSetup() {
		String messageString = "Suite Setup";
		System.out.println(MessageFormat.format("Message: {0}", messageString));
	}

	// Set test to timeout after 4000ms
	@Parameters({ "URL", "APIKey/username" })
	@Test(timeOut = 4000)
	public void TestNG_03(String url, String key) {
		String messageString = "TestNG_03";
		System.out.println(MessageFormat.format("Message: {0}", messageString));
		System.out.println(MessageFormat.format("URL parameter: {0}", url));
		System.out.println(MessageFormat.format("APIKey parameter: {0}", key));
	}

	// Run test with all test data (3 sets)
	@Test(groups = { "Smoke" }, dataProvider = "dataSetup")
	public void TestNG_04(String username, String password) {
		String messageString = "TestNG_04";
		System.out.println(MessageFormat.format("Message: {0}", messageString));
		System.out.println(MessageFormat.format("Username parameter: {0}", username));
		System.out.println(MessageFormat.format("Password parameter: {0}", password));
	}

	@AfterSuite
	public void SuiteTeardown() {
		String messageString = "Suite Teardown";
		System.out.println(MessageFormat.format("Message: {0}", messageString));
	}

	@DataProvider
	public Object dataSetup() {
		// 1st scenario - username & password - good credit history
		// 2nd scenario - username & password - no credit history
		// 3rd scenario - username & password - fraudulent credit history

		Object[][] data = new Object[3][2];

		// 1st scenario data
		data[0][0] = "first_username";
		data[0][1] = "first_password";

		// 2nd scenario data
		data[1][0] = "second_username";
		data[1][1] = "second_password";

		// 3rd scenario data
		data[2][0] = "third_username";
		data[2][1] = "third_password";

		return data;

	}
}
