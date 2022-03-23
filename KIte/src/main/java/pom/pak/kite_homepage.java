package pom.pak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class kite_homepage {

	@FindBy (xpath = "//span[text() ='Dashboard']")
	WebElement dashboard;

	@FindBy (xpath = "//span[text() ='Orders']")
	WebElement orders;

	@FindBy (xpath = "//span[text() ='Holdings']")
	WebElement holdings;

	@FindBy (xpath = "//span[text() ='Positions']")
	WebElement positions;

	@FindBy (xpath = "//span[text() ='Funds']")
	WebElement funds;

	@FindBy (xpath = "//span[text() ='Apps']")
	WebElement apps;

	@FindBy (xpath = "//span[@class='user-id']")
	WebElement accounts;

	@FindBy (xpath = "//a[@target='_self']")
	WebElement Logout;

	private WebDriver driver;



	public kite_homepage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String verifyKiteHomePageDashboardlink() {
		dashboard.click();
		return driver.getCurrentUrl();

	}

	public String verifyKiteHomePageOrderslink() {
		orders.click();
		return driver.getCurrentUrl();
	}

	public String verifyKiteHomePagePositionslink() {
		positions.click();
		return driver.getCurrentUrl();
	}


	public String verifyKiteHomePageHoldingslink() {
		holdings.click();
		return driver.getCurrentUrl();
	}

	public String verifyKiteHomePageFundslink() {
		funds.click();
		return driver.getCurrentUrl();
	}

	public String verifyKiteHomePageAppslink() {
		apps.click();
		return driver.getCurrentUrl();
	}

	public void clickOnKiteHomePageLogout() throws InterruptedException{
		accounts.click();
		Thread.sleep(2000);
		By ele = By.xpath("//a[@target='_self']");
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
		logoutButton.click();		
	}
}
