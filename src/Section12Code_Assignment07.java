import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Section12Code_Assignment07 {

	public static void main(String[] args) {
		WebDriver webDriver = new FirefoxDriver();
		// WebDriverWait waiting = new WebDriverWait(webDriver, Duration.ofSeconds(5));

		// Navigate to page
		webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Count and print number of rows in table
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

		// Identify number of rows in 1st table
		List<WebElement> tableRows = webDriver.findElements(By.cssSelector(".table-display tr"));
		int numberRows = tableRows.size();
		System.out.println(MessageFormat.format("Number of rows in table 1: {0}", numberRows));

		// Count and print number of columns in table
		// Identify number of rows in 1st table
		List<WebElement> tableColumns = webDriver.findElements(By.cssSelector(".table-display th"));
		int numberColumns = tableColumns.size();
		System.out.println(MessageFormat.format("Number of columns in table 1: {0}", numberColumns));

		// Print second row content
		System.out.println(MessageFormat.format("Data content in row 2: {0}", tableRows.get(1).getText()));

	}

}
