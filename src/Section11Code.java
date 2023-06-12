import java.text.MessageFormat;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

		// Count number links in the footer // Limit driver scope to only footer
		WebElement footerElement = webDriver.findElement(By.id("gf-BIG"));
		int countFooter = footerElement.findElements(By.tagName("a")).size();

		System.out.println("Count of links in footer: " + countFooter);

		// Count number links in the footer
		// Limit driver scope to only footer left
		WebElement footerColumnElement = footerElement.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

		int countFooterLeftCol = footerColumnElement.findElements(By.tagName("a")).size();

		System.out.println("Count of links in footer left column: " + countFooterLeftCol);

		// Open each link in column in new tab
		for (int i = 1; i < footerColumnElement.findElements(By.tagName("a")).size(); i++) {
			String linkTabString = Keys.chord(Keys.COMMAND, Keys.RETURN);
			footerColumnElement.findElements(By.tagName("a")).get(i).sendKeys(linkTabString);

			// Wait till web page has rendered
			try {
				Thread.sleep(2000L);
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

		// Navigate to page
		webDriver.get("https://www.path2usa.com/travel-companion/");
		webDriver.manage().window().maximize();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Scroll down the Page
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,1200)");

		// Click on the Date field
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Find calendar field
		WebElement Date = webDriver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']"));

		// Click on calendar field
		Date.click();

		// Scroll through months
		while (!webDriver.findElement(By.xpath("//div[@class='flatpickr-month']")).getText().contains("July")) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			webDriver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
		}

		// Count the number of days
		int count = webDriver.findElements(By.xpath("//span[@class='flatpickr-day ']")).size();
		for (int i = 0; i < count; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String text = webDriver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();

			// Only click on 26
			if (text.equalsIgnoreCase("26")) {
				webDriver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();
				System.out.println("The selected day is: " + text);
				break;
			}
		}

		// Verify the date selected
		String date = webDriver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).getAttribute("value");
		System.out.println("The selected date is: " + date);
	}

}
