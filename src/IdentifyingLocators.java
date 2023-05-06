import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IdentifyingLocators {

	public static void main(String[] args) {
		// Initiate Firefox
		System.setProperty("webdriver.geckodriver.driver",
				"/Users/shellymutu-grigg/firefoxdriver_mac_aarch64/geckodriver");
		WebDriver webDriver = new FirefoxDriver();

		webDriver.get("https://www.shellymutugrigg.com/");

		// Verify title & URL
		System.out.println("Firefox Webpage title: " + webDriver.getTitle());
		System.out.println("Firefox Webpage URL: " + webDriver.getCurrentUrl());

		// Validate first carousel item
		System.out.println("Confirm Name Slide Text: " + webDriver.findElement(By.id("owl-item-name")).getText());

		// Navigate to second carousel item
		webDriver.findElement(By.id("next_button")).click();

		// Validate second carousel item
		System.out.println(
				"Github link is displayed: " + webDriver.findElement(By.linkText("shellymutu-grigg")).isDisplayed());

		// Navigate to third carousel item
		webDriver.findElement(By.id("next_button")).click();

		// Validate third carousel item
		System.out.println(
				"LinkedIn link is displayed: " + webDriver.findElement(By.linkText("shellymutugrigg")).isDisplayed());

		// Navigate to fourth carousel item
		webDriver.findElement(By.id("next_button")).click();

		// Example of how to wait for page display
		// firefoxDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
		WebElement firstResult = new WebDriverWait(webDriver, Duration.ofSeconds(5))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
						"//div[@class='owl-item active']//h2[@class='divider clients-divider'][normalize-space()='Previous Clients']")));
		System.out.println("Confirm Previous Client Slide after WebDriverWait: " + firstResult.getText());

		// Validate fourth carousel item
		System.out.println("Confirm Previous Client Slide Text using ID: "
				+ webDriver.findElement(By.id("owl-item-previous-clients")).isDisplayed()); // Don't know why not
																							// working
		System.out.println("Confirm Previous Client Slide Text using Xpath: " + webDriver.findElement(By.xpath(
				"//div[@class='owl-item active']//h2[@class='divider clients-divider'][normalize-space()='Previous Clients']"))
				.getText());

		// Navigate to fifth carousel item
		webDriver.findElement(By.id("next_button")).click();

		// Validate fifth carousel item
		System.out.println("Contact details are displayed: "
				+ webDriver.findElement(By.linkText("shellymutugrigg@gmail.com")).isDisplayed());

		// Kill session
		webDriver.quit(); // This will close all windows opened during test

	}

}
