import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.os.WindowsUtils;

public class Section08Code {
	public static void main(String[] args) throws IOException {

		// System.setProperty("webwebDriver.chrome.driver",
		// "/Users/shellymutu-grigg/chromedriver_mac_arm64/chromedriver");

		// webwebDriver.manage().window().maximize();
		// webwebDriver.manage().deleteAllCookies();

		// WindowsUtils.killByName("excel.exe");

		// webDriver.manage().deleteCookieNamed("sessionKey");

		// click on any link
		// login page- verify login url

		/*
		 * webDriver.get("http://google.com");
		 * 
		 * File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFile(src,new File("C:\\Users\\rahul\\screenshot.png"));
		 */

		WebDriver webDriver = new ChromeDriver();
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };

		webDriver.get("https://rahulshettyacademy.com/seleniumPractise/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		addItems(webDriver, itemsNeeded);
	}

	public static void addItems(WebDriver webDriver, String[] itemsNeeded)

	{
		int j = 0;
		List<WebElement> products = webDriver.findElements(By.cssSelector("h4.product-name"));
		System.out.println("Number of products: " + products.size());
		for (int i = 0; i < products.size(); i++) {

			String formattedName = products.get(i).getText().split("-")[0].trim();
			System.out.println("Product name: " + formattedName);
			// format it to get actual vegetable name
			// convert array into array list for easy search
			// check whether name you extracted is present in arrayList or not-
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName)) {
				j++;
				// click on Add to cart
				webDriver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
	}
}
