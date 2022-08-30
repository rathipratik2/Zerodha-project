package test;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.ZezodhaLoginPage;
import utility.BaseTest;
import utility.Parametrization;
import utility.Reports;

@Listeners(utility.Listeners.class)

public class LoginPageTest extends BaseTest {
//WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void addReports() {
		reports=Reports.generateReports();
	}

    @BeforeMethod
    public void LaunchBrowser() {
    	driver = LaunchBrowser.OpenBrowser();
    	
    	
    }
    
    @Test
    public void ZerodhaLoginTest() throws EncryptedDocumentException, IOException, InterruptedException {
    	test = reports.createTest("ZeroshaLoginTest");
    	ZezodhaLoginPage zerodhaLoginPage = new ZezodhaLoginPage(driver);
    	String user = Parametrization.getData("TEST", 0, 1);
    	String pass = Parametrization.getData("TEST", 1, 1);
    	String pin = Parametrization.getData("TEST", 2, 1);
    	zerodhaLoginPage.enterUserName(user);
    	zerodhaLoginPage.enterPassWord(pass);
    	zerodhaLoginPage.clickOnSubmit();
    	Thread.sleep(5000);
        zerodhaLoginPage.enterPin(pin);
    	zerodhaLoginPage.clickOnContinue();
    	Assert.assertTrue(false);
    
    
    	
    	
    }
    
    @Test
    public void ZerodhaForgot() throws InterruptedException {
    	test= reports.createTest("validateZerodhaForgotLink");
    	ZezodhaLoginPage zerodhaLoginPage = new ZezodhaLoginPage(driver);
    	zerodhaLoginPage.clickOnForgot();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@id='container']/div/div/form/div[1]/div[2]/label")).click();
   
    }
    
    @AfterMethod
    public void postTest(ITestResult result) {
    	if(result.getStatus() == ITestResult.FAILURE)
    	{
    		test.log(Status.FAIL, result.getName());
    	}
    	if(result.getStatus() == ITestResult.SUCCESS)
    	{
    		test.log(Status.PASS, result.getName());
    	}
    	else
    	{
    		test.log(Status.SKIP, result.getName());
    	}
    }
    
    @AfterTest
    public void flushReports() {
    	reports.flush();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
		
		
	

}
