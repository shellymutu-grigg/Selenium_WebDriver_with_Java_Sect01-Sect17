import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Section07Code_Assignment01 {

	public static void main(String[] args) {
		WebDriver webDriver = new FirefoxDriver();

		webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Find the first check box in the list, check state, select, check state,
		// deselect, check state
		Assert.assertFalse(webDriver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).isSelected());
		webDriver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).click();
		Assert.assertTrue(webDriver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).isSelected());
		webDriver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).click();
		Assert.assertFalse(webDriver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).isSelected());

		// Verify count of check boxes on page
		Assert.assertEquals(webDriver.findElements(By.cssSelector("input[type='checkbox']")).size(), 3);
		System.out.println("Count of number of check boxes on page: "
				+ webDriver.findElements(By.cssSelector("input[type='checkbox']")).size());

	}

}
