import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Section12Code {

	public static void main(String[] args) {
		WebDriver webDriver = new FirefoxDriver();
		// WebDriverWait waiting = new WebDriverWait(webDriver, Duration.ofSeconds(5));

		// Navigate to page
		webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Scroll down the Page
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,500)");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Scroll within the Web Table Fixed Header Table
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		// Identify column values in 2nd table
		List<WebElement> tableCellsElements02 = webDriver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

		int sum02 = 0;

		// Iterate over elements and sum the values
		for (int i = 0; i < tableCellsElements02.size(); i++) {
			int value = Integer.parseInt(tableCellsElements02.get(i).getText());
			System.out.println(MessageFormat.format("Value for element {0}: {1}", i, value));
			sum02 = sum02 + Integer.parseInt(tableCellsElements02.get(i).getText());

		}
		System.out.println(MessageFormat.format("Total sum of column values in 2nd table: {0}", sum02));

		// Identify integer in text
		List<String> totalTextList = Arrays
				.asList(webDriver.findElement(By.cssSelector(".totalAmount")).getText().split(" "));

		int textTotal = Integer.parseInt(totalTextList.get(totalTextList.size() - 1));

		Assert.assertEquals(textTotal, sum02);
		System.out
				.println(MessageFormat.format("Total in text matches column sum of table 02: {0}", textTotal == sum02));

		// Identify column values in 1st table
		List<WebElement> tableCellsElements01 = webDriver
				.findElements(By.cssSelector(".table-display td:nth-child(3)"));

		int sum01 = 0;

		// Iterate over elements and sum the values
		for (int i = 0; i < tableCellsElements01.size(); i++) {
			int value = Integer.parseInt(tableCellsElements01.get(i).getText());
			System.out.println(MessageFormat.format("Value for element {0}: {1}", i, value));
			sum01 = sum01 + Integer.parseInt(tableCellsElements01.get(i).getText());

		}
		System.out.println(MessageFormat.format("Total sum of column values: {0}", sum01));
	}

}
