import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

public class Section13Code {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// Set the Chrome options to allow insecure SSL Certs
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setAcceptInsecureCerts(true);
		// chromeOptions.addExtensions(new File("/path/to/extension.crx"));

		// Add the WebDriver proxy capability.
		Proxy proxy = new Proxy();
		// proxy.setHttpProxy("myhttpproxy:3337");
		// chromeOptions.setCapability("proxy", proxy);

		// Set preferred download directory
		Map<String, Object> preferencesMap = new HashMap<String, Object>();
		preferencesMap.put("download.default_directory", "/Users/shellymutu-grigg/Desktop");

		// Disable pop-ups
		chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		WebDriver webDriver = new ChromeDriver(chromeOptions);

		// Set the Firefox options to allow insecure SSL Certs
		// FirefoxOptions firefoxOptions = new FirefoxOptions();
		// firefoxOptions.setAcceptInsecureCerts(true);

		// WebDriver webDriver = new FirefoxDriver(firefoxOptions);

		// Maximize page
		webDriver.manage().window().maximize();

		// Delete all cookies
		webDriver.manage().deleteAllCookies();

		// Delete named cookie
		webDriver.manage().deleteCookieNamed("cookieName");

		// Navigate to page
		webDriver.get("https://expired.badssl.com/");

		// Print page title
		System.out.println(MessageFormat.format("Page title: {0}", webDriver.getTitle()));

		// Take a screenshot
		File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenshot, new File("//Users//shellymutu-grigg//Desktop//screenshot.png"));

		// Handle broken links/URL
		webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Find all links
		List<WebElement> urlLinksElements = webDriver.findElements(By.cssSelector("li[class='gf-li'] a"));

		// Prevent single link failure stopping test by using soft asserts
		SoftAssert softAssert = new SoftAssert();

		// Iterate through links and determine if response code is successful or not
		for (WebElement link : urlLinksElements) {
			String urlString = link.getAttribute("href");
			String urlTextString = link.getText();
			HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();

			connection.setRequestMethod("HEAD");
			connection.connect();
			int responseCode = connection.getResponseCode();

			// Print link, url & response code
			System.out.println(MessageFormat.format("The link {0} has url {1} and response code {2}", urlTextString,
					urlString, responseCode));

			softAssert.assertTrue(responseCode < 400, MessageFormat
					.format("Error with link {0} returns {1} error response code", urlTextString, responseCode));

		}
		softAssert.assertAll();

	}

}
