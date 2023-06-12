import java.text.MessageFormat;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Section11Code {

	public static void main(String[] args) {

		WebDriver webDriver = new FirefoxDriver();
		WebDriverWait waiting = new WebDriverWait(webDriver, Duration.ofSeconds(5));

		// Navigate to page
		webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Count number of links on entire page
		int countAll = webDriver.findElements(By.tagName("a")).size();

		System.out.println("Count of links on page: " + countAll);

		// Count number links in the footer
		// Limit driver scope to only footer
		WebElement footerElement = webDriver.findElement(By.id("gf-BIG"));
		int countFooter = footerElement.findElements(By.tagName("a")).size();

		System.out.println("Count of links in footer: " + countFooter);

		// Count number links in the footer
		// Limit driver scope to only footer left column
		WebElement footerColumnElement = footerElement.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

		int countFooterLeftCol = footerColumnElement.findElements(By.tagName("a")).size();

		System.out.println("Count of links in footer left column: " + countFooterLeftCol);

		// Open each link in column in new tab
		for (int i = 1; i < footerColumnElement.findElements(By.tagName("a")).size(); i++) {
			String linkTabString = Keys.chord(Keys.COMMAND, Keys.RETURN);
			footerColumnElement.findElements(By.tagName("a")).get(i).sendKeys(linkTabString);

			// Wait till web page has rendered
			try {
				Thread.sleep(5000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Iterate through tabs and print title
		Set<String> tabNames = webDriver.getWindowHandles();
		Iterator<String> iterateIterator = tabNames.iterator();
		while (iterateIterator.hasNext()) {
			webDriver.switchTo().window(iterateIterator.next());
			String currentTabNameString = webDriver.getTitle();
			System.out.println(MessageFormat.format("Tab title: {0}", currentTabNameString));
		}

	}

}
