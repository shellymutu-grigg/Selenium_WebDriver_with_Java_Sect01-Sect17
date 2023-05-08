import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Section06Code {
	public static void main(String[] args) throws InterruptedException {
		// Initiate Firefox - new SeleniumManager prevent need for next line
		// System.setProperty("webwebDriver.geckowebDriver.driver",
		// "/Users/shellymutu-grigg/firefoxdriver_mac_aarch64/geckodriver");
		WebDriver webDriver = new FirefoxDriver();

		String name = "rahul";

		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String password = getPassword(webDriver);

		webDriver.get("https://rahulshettyacademy.com/locatorspractice/");
		webDriver.findElement(By.id("inputUsername")).sendKeys(name);
		webDriver.findElement(By.name("inputPassword")).sendKeys(password);
		webDriver.findElement(By.className("signInBtn")).click();

		Thread.sleep(2000);

		System.out.println(webDriver.findElement(By.tagName("p")).getText());

		Assert.assertEquals(webDriver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(webDriver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
				"Hello " + name + ",");

		webDriver.findElement(By.xpath("//*[text()='Log Out']")).click();

		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		webDriver.get("https://rahulshettyacademy.com/locatorspractice/");
		webDriver.findElement(By.id("inputUsername")).sendKeys("rahul");
		webDriver.findElement(By.name("inputPassword")).sendKeys("hello123");
		webDriver.findElement(By.className("signInBtn")).click();
		System.out.println(webDriver.findElement(By.cssSelector("p.error")).getText());
		webDriver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);//
		webDriver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		webDriver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
		webDriver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		webDriver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
		webDriver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");
		webDriver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		System.out.println(webDriver.findElement(By.cssSelector("form p")).getText());

		webDriver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

		Thread.sleep(1000);

		webDriver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		webDriver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		webDriver.findElement(By.id("chkboxOne")).click();
		webDriver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Identify sibling elements
		System.out.println(
				webDriver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());

		// Identify parent elements
		System.out.println(webDriver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());

		// Manipulating window commands
		webDriver.manage().window().maximize();
		webDriver.get("http://google.com");
		webDriver.navigate().to("https://rahulshettyacademy.com");
		webDriver.navigate().back();
		webDriver.navigate().forward();

		webDriver.close();
	}

	public static String getPassword(WebDriver webDriver) throws InterruptedException {

		webDriver.get("https://rahulshettyacademy.com/locatorspractice/");
		webDriver.findElement(By.linkText("Forgot your password?")).click();

		Thread.sleep(1000);

		webDriver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = webDriver.findElement(By.cssSelector("form p")).getText();

		// Please use temporary password 'rahulshettyacademy' to Login.
		String[] passwordArray = passwordText.split("'");

		// String[] passwordArray2 = passwordArray[1].split("'");
		// passwordArray2[0]

		String password = passwordArray[1].split("'")[0];
		return password;

		// 0th index - Please use temporary password
		// 1st index - rahulshettyacademy' to Login.
		// 0th index - rahulshettyacademy
		// 1st index - to Login.
	}
}
