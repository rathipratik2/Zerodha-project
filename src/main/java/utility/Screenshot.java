package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public static void page(WebDriver driver, String name) throws IOException {
		TakesScreenshot tc=((TakesScreenshot)driver);
		File source = tc.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\I COMPUTER\\eclipse-workspace\\Javaprogrm\\KiteZerodha\\Screenshot\\fail.png");
        FileHandler.copy(source, destination);	

	}

}
