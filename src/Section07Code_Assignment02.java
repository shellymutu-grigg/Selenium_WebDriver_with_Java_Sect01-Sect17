import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Section07Code_Assignment02 {

	public static void main(String[] args) {
		WebDriver webDriver = new FirefoxDriver();

		// Navigate
		webDriver.get("https://rahulshettyacademy.com/angularpractice/");

		// Maximize window
		webDriver.manage().window().maximize();

		// Populate input fields
		webDriver.findElement(By.name("name")).sendKeys("Shelly Mutu-Grigg");
		webDriver.findElement(By.name("email")).sendKeys("shellymutugrigg@gmail.com");
		webDriver.findElement(By.id("exampleInputPassword1")).sendKeys("password12345");

		// Verify if check box is selected, click and re-check state
		Assert.assertFalse(webDriver.findElement(By.id("exampleCheck1")).isSelected());
		webDriver.findElement(By.id("exampleCheck1")).click();
		Assert.assertTrue(webDriver.findElement(By.id("exampleCheck1")).isSelected());

		// Select gender dropdown
		WebElement staticDropdownElement = webDriver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(staticDropdownElement);
		dropdown.selectByVisibleText("Female");

		// Select student radio button
		webDriver.findElement(By.id("inlineRadio1")).click();
		Assert.assertTrue(webDriver.findElement(By.id("inlineRadio1")).isSelected());

		// Enter date of birth
		webDriver.findElement(By.name("bday")).sendKeys("1901-01-01");

		// Submit page details
		webDriver.findElement(By.cssSelector("input[value='Submit']")).click();

		// Compile success message
		String success = webDriver.findElement(By.xpath("//strong[contains(text(),'Success!')]")).getText();
		String submission = webDriver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"))
				.getText().split(success)[1];
		String successText = success + submission;

		// Verify success message is as expected
		String expected = "Success! The Form has been submitted successfully!.";
		Assert.assertEquals(successText, expected);

		// Output success message to console
		System.out.printf(successText);

	}

}
