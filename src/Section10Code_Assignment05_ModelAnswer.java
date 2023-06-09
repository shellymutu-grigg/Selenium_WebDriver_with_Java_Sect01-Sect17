import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Section10Code_Assignment05_ModelAnswer {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("http://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Nested Frames")).click();

		driver.switchTo().frame("frame-top");

		driver.switchTo().frame("frame-middle");

		System.out.println(driver.findElement(By.id("content")).getText());

	}
}
