import static org.junit.Assert.assertEquals;

import java.text.MessageFormat;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Section11Code_Assignment06 {

	public static void main(String[] args) {
		WebDriver webDriver = new FirefoxDriver();
		WebDriverWait waiting = new WebDriverWait(webDriver, Duration.ofSeconds(5));

		// Navigate to page
		webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Identify any check box in page and select
		WebElement checkboxElement = webDriver.findElement(By.id("checkbox-example"));
		List<WebElement> checkboxLabelsElements = checkboxElement.findElements(By.tagName("label"));

		// Read the text for the selected checkbox text
		String labelString = checkboxLabelsElements.get(checkboxLabelsElements.size() - 1).getText();
		webDriver.findElement(By.xpath("//input[@id='checkBox" + labelString + "']")).click();

		// Select same text from selected checkbox from dropdown list to the left
		Select dropdown = new Select(webDriver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByVisibleText(labelString);

		// Enter text into the Switch to Alert field
		webDriver.findElement(By.id("name")).sendKeys(labelString);

		// Trigger Alert
		webDriver.findElement(By.id("alertbtn")).click();

		// Verify if text is present in alert text
		assertEquals(webDriver.switchTo().alert().getText().contains(labelString), true);
		System.out.println(MessageFormat.format("{0} is present in alert text: {1}", labelString,
				webDriver.switchTo().alert().getText().contains(labelString)));

	}

}
