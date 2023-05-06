import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_First {

	public static void main(String[] args) {
		
		//Initiate Chrome browser 
		System.setProperty("webdriver.chrome.driver", "/Users/shellymutu-grigg/chromedriver_mac_arm64/chromedriver");
		WebDriver chromeDriver = new ChromeDriver();
		
		
		chromeDriver.get("https://shellymutugrigg.com");
		System.out.println("Chrome Webpage title: " + chromeDriver.getTitle());
		System.out.println("Chrome Webpage URL: " +chromeDriver.getCurrentUrl());
		chromeDriver.close(); //This will only close the initial window opened by Selenium
		chromeDriver.quit(); //This will close all windows opened during test
		
		//Initiate Edge 
		System.setProperty("webdriver.edge.driver", "/Users/shellymutu-grigg/edgedriver_mac_M1/msedgedriver");
		WebDriver edgeDriver = new EdgeDriver();
		
		edgeDriver.get("https://shellymutugrigg.com");
		System.out.println("Edge Webpage title: " + edgeDriver.getTitle());
		System.out.println("Edge Webpage URL: " + edgeDriver.getCurrentUrl());
		edgeDriver.close(); //This will only close the initial window opened by Selenium
		edgeDriver.quit(); //This will close all windows opened during test
		
		//Initiate Firefox 
		System.setProperty("webdriver.geckodriver.driver", "/Users/shellymutu-grigg/firefoxdriver_mac_aarch64/geckodriver");
		WebDriver firefoxDriver = new FirefoxDriver();
		
		firefoxDriver.get("https://shellymutugrigg.com");
		System.out.println("Firefox Webpage title: " + firefoxDriver.getTitle());
		System.out.println("Firefox Webpage URL: " +firefoxDriver.getCurrentUrl());
		firefoxDriver.close(); //This will only close the initial window opened by Selenium
		firefoxDriver.quit(); //This will close all windows opened during test
		

	}

}
