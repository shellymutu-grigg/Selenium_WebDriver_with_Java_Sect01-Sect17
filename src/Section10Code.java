import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Section10Code {

	public static void main(String[] args) {
		WebDriver webDriver = new FirefoxDriver();
		webDriver.manage().window().maximize();
		webDriver.get("https://www.amazon.com");
		Actions action = new Actions(webDriver);

		WebElement element = webDriver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

		WebDriverWait waiting = new WebDriverWait(webDriver, Duration.ofSeconds(5));

		// Locate element, enter text in capitals and double click to select entire word
		action.moveToElement(webDriver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
				.sendKeys("hello").doubleClick().build().perform();

		// Move to a specific element and expose right click menu
		action.moveToElement(element).contextClick().build().perform();

		webDriver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		webDriver.findElement(By.cssSelector(".blinkingText")).click();

		// Get all window/tab ids, iterate through them & switch to child tab
		Set<String> windowSet = webDriver.getWindowHandles();
		Iterator<String> iterate = windowSet.iterator();
		String parent = iterate.next();
		String child = iterate.next();
		webDriver.switchTo().window(child);

		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".im-para.red")));

		// Use a breakpoint and RC watch to determine values
		String emailAddress = webDriver.findElement(By.cssSelector(".im-para.red")).getText().split(" at ")[1]
				.split(" ")[0];

		System.out.println("Email Address: " + emailAddress);

		// Switch to parent tab
		webDriver.switchTo().window(parent);
		webDriver.findElement(By.id("username")).sendKeys(emailAddress);

	}

}
