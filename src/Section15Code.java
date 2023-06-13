import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Section15Code {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver webDriver = new FirefoxDriver();

		// Navigate to page
		webDriver.get("https://rahulshettyacademy.com/angularpractice/");

		// Find an element above a given element using a reference
		WebElement nameEditBoxElement = webDriver.findElement(By.cssSelector("[name='name']"));
		String nameFieldName = webDriver.findElement(with(By.tagName("label")).above(nameEditBoxElement)).getText();

		System.out.println(MessageFormat.format("Field name: {0}", nameFieldName));

		// Find an element below a given element using a reference - flex element will
		// be ignored
		WebElement dobEditBoxElement = webDriver.findElement(By.cssSelector("[for='dateofBirth']"));
		webDriver.findElement(with(By.tagName("input")).below(dobEditBoxElement)).click();

		// Find an element to the left of a given element using a reference
		WebElement checkboxElement = webDriver
				.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		webDriver.findElement(with(By.tagName("input")).toLeftOf(checkboxElement)).click();

		// Find an element to the right of a given element using a reference
		WebElement radioElement = webDriver.findElement(By.id("inlineRadio1"));
		String radioLabelString = webDriver.findElement(with(By.tagName("label")).toRightOf(radioElement)).getText();

		System.out.println(MessageFormat.format("Radio button label: {0}", radioLabelString));

		// Navigate to page
		webDriver.get("https://rahulshettyacademy.com/angularpractice/");

		// Populate the Name field using the first course name available on diff page
		webDriver.switchTo().newWindow(WindowType.TAB);

		// Create list of tab names
		Set<String> tabNames = webDriver.getWindowHandles();
		Iterator<String> tabNameIterator = tabNames.iterator();
		String parentTabString = tabNameIterator.next();
		String childTabString = tabNameIterator.next();

		webDriver.switchTo().window(childTabString);

		// Wait for page to load
		Thread.sleep(3000);

		// Navigate to the desired page
		webDriver.get("https://rahulshettyacademy.com/");

		// Get course name from child tab
		String courseName = webDriver
				.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		System.out.println(MessageFormat.format("Course Name: {0}", courseName));

		// Navigate back to parent tab
		webDriver.switchTo().window(parentTabString);

		WebElement name = webDriver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);

		// Take a screenshot of a field
		File screenshotFile = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("//Users//shellymutu-grigg//Desktop//courseName.png"));

		// Find screen height and width UX field details
		double height = name.getRect().getDimension().getHeight();
		System.out.println(MessageFormat.format("Name field height: {0}", height));

		double width = name.getRect().getDimension().getWidth();
		System.out.println(MessageFormat.format("Name field width: {0}", width));

		webDriver.quit();

	}

}
