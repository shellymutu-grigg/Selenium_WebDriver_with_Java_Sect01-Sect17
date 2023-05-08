import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Section07Code {
	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webwebDriver.geckowebDriver.driver",
		// "/Users/shellymutu-grigg/firefoxdriver_mac_aarch64/geckodriver");
		WebDriver webDriver = new FirefoxDriver();

		webDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Static dropdown manipulation
		WebElement staticDropdownElement = webDriver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select dropdownSelect = new Select(staticDropdownElement);
		dropdownSelect.selectByIndex(3);
		System.out.println("Display currency at index 3: " + dropdownSelect.getFirstSelectedOption().getText());
		dropdownSelect.selectByVisibleText("AED");
		System.out.println("Display currency AED: " + dropdownSelect.getFirstSelectedOption().getText());
		dropdownSelect.selectByValue("INR");
		System.out.println("Display currency INR: " + dropdownSelect.getFirstSelectedOption().getText());

		webDriver.findElement(By.id("divpaxinfo")).click();

		Thread.sleep(1000L);

		int count = 1;
		while (count < 4) {
			webDriver.findElement(By.id("hrefIncAdt")).click(); // Add adult
			count++;
		}

		for (int counter = 1; counter < 2; counter++) {
			webDriver.findElement(By.id("hrefIncAdt")).click(); // Add adult
		}

		webDriver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println("Passengers: " + webDriver.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(webDriver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

		// Dynamic dropdowns

		webDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		webDriver.findElement(By.xpath("//a[@value='BKK']")).click();
		System.out.println("Origin selected: " + webDriver
				.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).getText());

		Thread.sleep(1000L);

		// webDriver.findElement(By.xpath("(//a[@value='DXB'])[2]")).click();
		webDriver
				.findElement(
						By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='DXB']"))
				.click();

		// Calendar manipulation - select current date
		webDriver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();

		// Auto suggestion dropdowns
		webDriver.findElement(By.id("autosuggest")).sendKeys("new");

		Thread.sleep(1000L);

		List<WebElement> options = webDriver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("New Zealand")) {
				option.click();
				break;
			}
		}

		// Check boxes
		// Count number of check boxes
		System.out.println(
				"Count of check boxes: " + webDriver.findElements(By.cssSelector("input[type=checkbox]")).size());

		Assert.assertFalse(webDriver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		System.out.println("Friends & Family check box is selected: "
				+ webDriver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		webDriver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		System.out.println("Friends & Family check box is selected: "
				+ webDriver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		Assert.assertTrue(webDriver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

		// Validating if elements are disabled on enabled based on other elements states
		// Radio button - One way
		webDriver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

		// Because the element is not really disabled just the opacity has been changed
		// it returns true
		System.out.println(
				"Is return date enabled?: " + webDriver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		if (webDriver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}

		System.out.println("Is return date ACTUALLY enabled?: "
				+ webDriver.findElement(By.id("Div1")).getAttribute("style").contains("1"));

		// Initiate search
		webDriver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

		// webDriver.quit();
	}
}
