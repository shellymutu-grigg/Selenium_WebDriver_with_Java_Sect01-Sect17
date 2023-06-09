import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Section10Code {

	public static void main(String[] args) {
		WebDriver webDriver = new FirefoxDriver();
		webDriver.manage().window().maximize();
		webDriver.get("https://www.amazon.com");
		Actions action = new Actions(webDriver);

		WebElement element = webDriver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

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

	}

}
