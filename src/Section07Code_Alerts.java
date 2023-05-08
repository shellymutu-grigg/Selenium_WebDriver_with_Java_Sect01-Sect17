import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Section07Code_Alerts {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/shellymutu-grigg/chromedriver_mac_arm64/chromedriver");
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("https://rahulshettyacademy.com/AutomationPractice/"); // URL in the browser

		// Populate field and trigger alert
		String text = "Shelly";
		webDriver.findElement(By.id("name")).sendKeys(text);
		webDriver.findElement(By.cssSelector("[id='alertbtn']")).click();

		// Verify text displayed and click OK
		System.out.println("Alert text: " + webDriver.switchTo().alert().getText());
		webDriver.switchTo().alert().accept();

		// Trigger confirm button & click cancel
		webDriver.findElement(By.id("confirmbtn")).click();
		System.out.println("Alert text: " + webDriver.switchTo().alert().getText());
		webDriver.switchTo().alert().dismiss();

	}

}
