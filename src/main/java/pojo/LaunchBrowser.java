package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static WebDriver OpenBrowser() {
		
	//	System.setProperty("webdriver.chrome.driver","C:\\Users\\I COMPUTER\\eclipse-workspace\\selen\\chromedriver_win32\\chromedriver.exe");
        
		ChromeOptions options= new ChromeOptions();
	    options.addArguments("--disable-notifications");
		
	    WebDriverManager.chromedriver().setup();
	    
	    WebDriver driver = new ChromeDriver(options);
	    
	    driver.get("https://kite.zerodha.com/");
	    driver.manage().window().maximize();
	    return driver;
		

	}

}
