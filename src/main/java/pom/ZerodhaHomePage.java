 package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaHomePage {

	@FindBy (xpath = "//input[@type='text']") private WebElement search;
	@FindBy (xpath = "//span[@class='tradingsymbol']") private List<WebElement> searchResult;
	@FindBy (xpath = "//button[@data-balloon=\"Buy\"]") private WebElement searchBuy;
	@FindBy (xpath = "//input[@autofocus='autofocus']") private WebElement stockBuy;
	@FindBy (xpath = "//span[@class='nice-name']") private List<WebElement> waitlist;
    @FindBy (xpath = "//span[@class='icon icon-trash']") private WebElement delete;
    @FindBy (xpath = "//label[@for='radio-181']") private WebElement intraday;

	
	public ZerodhaHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void searchStock(String stock,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(1000));
		wait.until(ExpectedConditions.visibilityOf(search));
		search.sendKeys(stock);
	}
	
	public int getSearchResultNumber() {
		int listsize = searchResult.size();
		return listsize;
	}
	
	public void searchAndSlectDesiredStock(WebDriver driver, String Requiredstock) {
		for(int a = 0;a<searchResult.size();a++) {
			WebElement s=searchResult.get(a);
			String StockName= s.getText();
			if(StockName.equals(Requiredstock))
			{
				Actions action = new Actions(driver);
				action.moveToElement(s);
				action.perform();
				break;
				
			}
		}
			
		
	}
	
	public void clickOnSearchResultBuy() {
		searchBuy.click();
	}
	
	public void getBuyStock( String number) {
		stockBuy.sendKeys(number);
	}
	
	public int getWaitList() {
		int waitlist1 = waitlist.size();
		return waitlist1;
	}
	
	public void searchDesiredStock(WebDriver driver, String Requiredstoc) {
		for(int a = 0;a<waitlist.size();a++) {
			WebElement p=waitlist.get(a);
			String StockNam= p.getText();
			if(StockNam.equals(Requiredstoc))
			{
				Actions action = new Actions(driver);
				action.moveToElement(p);
				action.perform();
				break;
				
			}
		}
			
		
	}
	
	public void clickDeleteWaitList() {
		delete.click();
	}
	
    public void scrolldown(WebDriver driver) {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(2000,5000)","");
    }
	
    public void clickOnIntraday() {
		intraday.click();
	}
	
	

}
