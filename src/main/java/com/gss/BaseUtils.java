package com.gss;

import java.io.File;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;


public class BaseUtils {
public static WebDriver driver;
public void browserLaunch() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aadhav\\Eclipse-Workspace1\\BuildUtils\\src\\main\\resources\\Drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
}
public void getUrl(String url) {
	driver.get(url);
}
public void inputText(WebElement element, String input) {
	element.sendKeys(input);
}
public void clkButton(WebElement element) {
	element.click();
}
public String getWebElementText(WebElement element) {
	return element.getText();
}
public void implicitWait() {
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}

	
public void screenShot() throws IOException {
	TakesScreenshot tk = (TakesScreenshot)driver;
	File source = tk.getScreenshotAs(OutputType.FILE);
	File desti = new File("C:\\Users\\Aadhav\\Eclipse-Workspace1\\BuildUtils\\src\\main\\resources\\Screenshot\\image3.jpeg");
	FileHandler.copy(source, desti);
}
}
