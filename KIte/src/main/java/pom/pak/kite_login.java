package pom.pak;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Util;

public class kite_login extends Util {

	@FindBy(xpath = "//input[@id='userid']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='pin']")
	WebElement pin;

	@FindBy(xpath = "//button[text()='Login ']")
	WebElement loginButton;

	@FindBy(xpath = "//button[text()='Continue ']")
	WebElement continueButton;



	public  kite_login (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String sendusername() throws EncryptedDocumentException, IOException {
		String userID = getDataFromSheet(1,0);
		userName.sendKeys(userID);
		return userID;
	}


	public String sendKiteLoginPagePassword() throws EncryptedDocumentException, IOException {
		String pass = getDataFromSheet(1,1);
		password.sendKeys(pass);
		return pass;
	}

	public void clickKiteLoginPageLogin() {
		//boolean result =loginButton.isEnabled();
		loginButton.click();
		//return result;
	}

	public void sendKiteLoginPagePin() throws EncryptedDocumentException, IOException  {
		//pin.sendKeys("893893");
		String code1 = getDataFromFile(1,2);
		pin.sendKeys(code1);
		//return code1;
	}


	public void clickKiteLoginPageContinue() {
		continueButton.click();
	}

}
