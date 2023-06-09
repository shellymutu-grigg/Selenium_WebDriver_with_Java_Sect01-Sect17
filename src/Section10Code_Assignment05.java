import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Section10Code_Assignment05 {

	public static void main(String[] args) {
		WebDriver webDriver = new FirefoxDriver();
		WebDriverWait waiting = new WebDriverWait(webDriver, Duration.ofSeconds(5));

		webDriver.manage().window().maximize();

		// Navigate to page
		webDriver.get("https://the-internet.herokuapp.com");

		// Wait till webpage has rendered
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Nested Frames")));

		// Click on link
		webDriver.findElement(By.linkText("Nested Frames")).click();

		// Switch to the first frame on page using index
		webDriver.switchTo().frame(0);

		// Switch to second child frame
		webDriver.switchTo().frame(1);

		String middleFrameTextString = webDriver.findElement(By.id("content")).getText();
		System.out.println("Middle child frame text:  " + middleFrameTextString);

	}

}
