import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Section10Code_Assignment04 {

	public static void main(String[] args) {

		WebDriver webDriver = new FirefoxDriver();
		WebDriverWait waiting = new WebDriverWait(webDriver, Duration.ofSeconds(5));

		webDriver.manage().window().maximize();

		// Navigate to page
		webDriver.get("https://the-internet.herokuapp.com");

		// Wait till webpage has rendered
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Multiple Windows")));

		// Click on link
		webDriver.findElement(By.linkText("Multiple Windows")).click();

		// Wait till webpage has rendered
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Click Here")));

		// Click on link
		webDriver.findElement(By.linkText("Click Here")).click();

		// Navigate to child tab
		Set<String> windowSet = webDriver.getWindowHandles();
		Iterator<String> iterate = windowSet.iterator();
		String parent = iterate.next();
		String child = iterate.next();
		webDriver.switchTo().window(child);

		// Wait till webpage has rendered
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='example']//h3")));

		String childWindowText = webDriver.findElement(By.xpath("//div[@class='example']//h3")).getText();

		System.out.println("Window Text: " + childWindowText);

		// Navigate to parent tab
		webDriver.switchTo().window(parent);

		// Wait till webpage has rendered
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='example']//h3")));

		String parentWindowText = webDriver.findElement(By.xpath("//div[@class='example']//h3")).getText();

		System.out.println("Window Text: " + parentWindowText);

	}

}
