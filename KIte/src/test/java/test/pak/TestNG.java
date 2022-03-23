package test.pak;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import Base.pojo;
import Utility.Util;
import pom.pak.kite_homepage;
import pom.pak.kite_login;

public class TestNG extends pojo  {

	private WebDriver driver;
	private kite_login KiteLogin;
	private kite_homepage KiteHomePage;
	private int testID;

	@BeforeTest()
	@Parameters("browser")
	public void Lauchbrowser(String browser) {

		if(browser.equals("Chrome"))
		{
			driver= openChromeBrowser();
		}
		if(browser.equals("Firefox"))
		{
			driver= openFirefoxBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@BeforeClass
	public void beforeclassmethod() throws EncryptedDocumentException, IOException {

		KiteLogin = new kite_login(driver);
		KiteHomePage = new kite_homepage(driver);
		driver.get("https://kite.zerodha.com/");
		KiteLogin.sendusername();
		
		


	}

	@BeforeMethod
	public void beforemethod() throws EncryptedDocumentException, IOException, InterruptedException {

//		SoftAssert soft = new SoftAssert();
//		KiteLogin.sendKiteLoginPagePassword("uniquemachine");
//		boolean result= KiteLogin.clickKiteLoginPageLogin();
//		soft.assertEquals(result, true);
		
		KiteLogin.sendKiteLoginPagePassword();
		KiteLogin.clickKiteLoginPageLogin();
		Thread.sleep(2000);
		KiteLogin.sendKiteLoginPagePin();
		KiteLogin.clickKiteLoginPageContinue();
		//	soft.assertAll();
	}


	@Test
	public void testA() {
		KiteHomePage.verifyKiteHomePageDashboardlink();
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url,"https://kite.zerodha.com/dashboard");
		String url2=driver.getCurrentUrl();

	}

	@Test
	public void testB(){
		testID=100;
		KiteHomePage.verifyKiteHomePageOrderslink();	
	}

	@Test
	public void testC() {
		testID=101;
		KiteHomePage.verifyKiteHomePageHoldingslink();
	}

	@Test
	public void testD() {
		testID=102;
		KiteHomePage.verifyKiteHomePagePositionslink();
	}
	@Test
	public void testE() {
		testID=103;
		KiteHomePage.verifyKiteHomePageFundslink();
	}
	@Test 
	public void testF() {
		testID=104;
		KiteHomePage.verifyKiteHomePageAppslink();

	}



	@AfterMethod
	public void aftermethod() throws InterruptedException, IOException {
		Util.saveScreenshot(driver,testID);
		KiteHomePage.clickOnKiteHomePageLogout();
	}

	@AfterClass
	public void afterclassmethod() {
		//driver.close();
		System.out.println("End");
	}

}
