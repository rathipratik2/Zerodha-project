package pom;

import org.apache.xmlbeans.impl.xpath.XPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZezodhaLoginPage {

	@FindBy (xpath = "//input[@id='userid']") private WebElement userName;
	@FindBy (xpath = "//input[@id='password']") private WebElement password;
	@FindBy (xpath = "//button[@class='button-orange wide']") private WebElement submit;
	@FindBy (xpath = "//a[text ()='Forgot user ID or password?']") private WebElement forgot;
	@FindBy (xpath = "//a[text ()=\"Don't have an account? Signup now!\"]") private WebElement signup;
	@FindBy (xpath = "//input[@id='pin']") private WebElement pin;
	@FindBy (xpath = "//button[@type='submit']") private WebElement submitpin;
	
	
	public ZezodhaLoginPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);	
	}
	
	public void enterUserName(String user) {
		userName.sendKeys(user);
	}
	
	public void enterPassWord(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnSubmit() {
		submit.click();
	}
	
	public void clickOnForgot() {
		forgot.click();
	}
	
	public void clickOnSignUp() {
		signup.click();
	}
	
	public void enterPin(String pinNumber) {
		pin.sendKeys(pinNumber);
	}
	
	public void clickOnContinue() {
		submitpin.click();
	}
	
	
	

}
