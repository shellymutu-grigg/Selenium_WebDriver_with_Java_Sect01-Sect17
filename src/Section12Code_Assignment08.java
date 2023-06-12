import java.text.MessageFormat;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Section12Code_Assignment08 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		WebDriver webDriver = new FirefoxDriver();

		String countryString = "New Zealand";
		// Navigate to page
		webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Navigate to suggestion class example field and enter first three chars
		webDriver.findElement(By.id("autocomplete")).sendKeys("new");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Move mouse and select country
		int count = webDriver.findElements(By.cssSelector("ul[id='ui-id-1'] li")).size();

		// Scroll within the Web Table Fixed Header Table
		for (int i = 0; i < count; i++) {
			String choice = webDriver.findElements(By.cssSelector("ul[id='ui-id-1'] li")).get(i).getText();
			if (choice.equalsIgnoreCase(countryString)) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				webDriver.findElements(By.cssSelector("ul[id='ui-id-1'] li")).get(i).click();
				System.out.println(MessageFormat.format("Option selected: {0}", choice));
				break;
			}
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Verify country name has been populated in textbox
		String textBoxTextString = webDriver.findElement(By.id("autocomplete")).getAttribute("value");
		Assert.assertEquals(countryString, textBoxTextString);
		System.out.println(MessageFormat.format("Text in textfield: {0}", textBoxTextString));
	}

}
