import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Section09Code_Assignment03 {

	public static void main(String[] args) {
		WebDriver webDriver = new ChromeDriver();

		// Explicit Wait
		WebDriverWait waiting = new WebDriverWait(webDriver, Duration.ofSeconds(10));

		webDriver.get("https://rahulshettyacademy.com/loginpagePractise/");

		// Populate Username, Password & select type of user
		webDriver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		webDriver.findElement(By.id("password")).sendKeys("learning");
		webDriver.findElement(By.xpath("//input[@value='user']")).click();

		// Handle pop-up window
		waiting.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='okayBtn']")));
		webDriver.findElement(By.xpath("//button[@id='okayBtn']")).click();

		// Select user dropdown
		WebElement staticDropdownElement = webDriver.findElement(By.xpath("//select[@data-style='btn-info']"));
		Select dropdown = new Select(staticDropdownElement);
		dropdown.selectByVisibleText("Consultant");

		// Agree to terms
		webDriver.findElement(By.xpath("//input[@name='terms']")).click();

		// Submit form
		webDriver.findElement(By.id("signInBtn")).click();

		// Use an explicit wait to wait for next page to load
		waiting.until(ExpectedConditions.elementToBeClickable(By.linkText("iphone X")));

		addItems(webDriver);

		// Click on checkout button in navbar
		webDriver.findElement(By.partialLinkText("Checkout")).click();

		// Click on Checkout button on cart page
		webDriver.findElement(By.xpath("//button[@class='btn btn-success']")).click();

		// Populate delivery location, agree to terms and select Purchase
		webDriver.findElement(By.id("country")).sendKeys("New Zealand");
		waiting.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='checkbox checkbox-primary']")));
		webDriver.findElement(By.xpath("//div[@class='checkbox checkbox-primary']")).click();

		webDriver.findElement(By.xpath("//input[@value='Purchase']")).click();

		// Compile success message
		String success = webDriver.findElement(By.xpath("//strong[contains(text(),'Success!')]")).getText();
		String submission = webDriver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"))
				.getText().split(success)[1];
		String successText = success + submission;

		// Verify success message is as expected
		String expected = "Success! Thank you! Your order will be delivered in next few weeks :-).";
		Assert.assertEquals(successText, expected);

		webDriver.quit();

	}

	public static void addItems(WebDriver webDriver)

	{
		List<WebElement> products = webDriver.findElements(By.xpath("//div[@class='card-body']//a"));

		for (int i = 0; i < products.size(); i++) {

			// click on Add button for item
			webDriver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();

		}
	}
}
