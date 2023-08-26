package com.basePackage;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	//	driver=new ChromeDriver(options);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	
	public void tearDown() {
		driver.quit();
	}
	
	public static void takeSnapShot(String filename) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		Thread.sleep(3000);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		//String filepath="./target/ReportsExtent/Screenshots/"+filename+".png";
		File DestFile=new File("./target/ReportsExtent/Screenshots/"+filename+".png");
		//File DestFile=new File("./target/ReportsExtent/Screenshots/"+filename+".png");
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);

		}

}
