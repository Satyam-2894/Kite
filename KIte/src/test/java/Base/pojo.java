package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class pojo {

	public WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\eclipse\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	public WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\eclipse\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
		
	}
	}

	
