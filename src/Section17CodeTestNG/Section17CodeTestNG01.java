package Section17CodeTestNG;

import java.text.MessageFormat;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Section17CodeTestNG01 {

	@BeforeTest
	public void Sect17_TestNG_Before() {
		String messageString = "Sect17_TestNG_Before";
		System.out.println(MessageFormat.format("Message: {0}", messageString));
	}

	@Test
	public void Sect17_TestNG_01() {
		String messageString = "Sect17_TestNG_01";
		System.out.println(MessageFormat.format("Message: {0}", messageString));
	}

	@AfterTest
	public void After() {
		String messageString = "Sect17_TestNG_After";
		System.out.println(MessageFormat.format("Message: {0}", messageString));
	}
}
