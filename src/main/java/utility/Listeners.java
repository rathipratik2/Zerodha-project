package utility;

import java.io.IOException;
import utility.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseTest implements ITestListener {
	
	public void onTestStrat(ITestResult result) {
		System.out.println("Test Started"+ result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success"+ result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
			    try {
					Screenshot.page( driver, result.getName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
    
	
	public  void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped"+ result.getName());
	}

}
