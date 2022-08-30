package test;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.ZerodhaHomePage;
import pom.ZezodhaLoginPage;
import utility.BaseTest;
import utility.Parametrization;

public class HomePageTest  {
		
		WebDriver driver ;
		
		@BeforeMethod
		public void LaunchBrowser() throws EncryptedDocumentException, IOException {
			driver=LaunchBrowser.OpenBrowser();
			ZezodhaLoginPage zerodhaLoginPage = new ZezodhaLoginPage(driver);
	    	String user = Parametrization.getData("TEST", 0, 1);
	    	String pass = Parametrization.getData("TEST", 1, 1);
	    	String pin = Parametrization.getData("TEST", 2, 1);
	    	zerodhaLoginPage.enterUserName(user);
	    	zerodhaLoginPage.enterPassWord(pass);
	    	zerodhaLoginPage.clickOnSubmit();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	    	zerodhaLoginPage.enterPin(pin);
	    	zerodhaLoginPage.clickOnContinue();
	    	
			
	}

	@Test
	public void searchStockTest() {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock("TaTa", driver);
		int number = zerodhaHomePage.getSearchResultNumber();
		Assert.assertTrue(number > 0);
		// System.out.println(number);
	}
		
		@Test(priority=1)
		public void searchStockAndClickBuy() throws InterruptedException {
			ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
			zerodhaHomePage.searchStock("Tata", driver);
			zerodhaHomePage.searchAndSlectDesiredStock(driver,"TATAPOWER");
			zerodhaHomePage.clickOnSearchResultBuy();
			WebElement pra = driver.findElement(By.xpath("(//span[text()='Buy'])[2]"));
			Assert.assertTrue(pra.isDisplayed());
		//	zerodhaHomePage.getBuyStock("2");
		//	pra.click();
		//hread.sleep(10000);
			 zerodhaHomePage.clickOnIntraday();
			
			String name = driver.getTitle();
			System.out.println("GetTitle :"+name);
		}
		
		@Test
		public void dropWaitList() throws InterruptedException {
			ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		//	zerodhaHomePage.searchStock("Tata", driver);
			Thread.sleep(5000);
	//		JavascriptExecutor js = (JavascriptExecutor)driver;
	//		WebElement flag = driver.findElement(By.xpath("//span[@class='nice-name'])[24]"));
	//		js.executeScript("arguments[0].scrollIntoView();",flag);
			zerodhaHomePage.searchDesiredStock(driver, "GRANULES");
			zerodhaHomePage.clickDeleteWaitList();


		}

		//span[text ()['TATASTEEL']
		
		//( //span[text()['TATASTEEL']//span[@class=['nice-name']
		 	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
