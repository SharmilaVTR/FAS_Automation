package com.fas.pages;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.fas.configration.PropertiesRepository;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest  {
	public String UserName; 
	public String Password;
	String reportPath;
	protected ExtentReports extentReports;
	protected static ExtentTest test;
	public ITestResult testResult;
	public static WiniumDriver driver;
	
	public static String Envirnomentundertest;
	@BeforeTest(alwaysRun = true)
	public void setUp() throws Exception {

	reportPath = "./" + "FAS_TestReport" + ".html";
	extentReports = new ExtentReports(reportPath,false);

	}
	
	@BeforeSuite(alwaysRun = true)
	public static void DelOldReport () {
	
		try {
		
		
		String FilePath=System.getProperty("user.dir");
		File folder2 = new File(FilePath);
		
		
		File[] listOfFiles2 = folder2.listFiles();
		if(listOfFiles2!=null) 
		{
		for(File file1 : listOfFiles2){
		if(file1.getName().contains("FAS_TestReport")) {
		file1.delete();
		System.out.println("Previous report is deleted");
		}
		}
		}
		
	
		}
		catch(Throwable e) 
		{
		System.out.println("Previous report is not deleted");
		
		
		}
		
		
		}
	
	
	
	
	@BeforeClass(alwaysRun = true)
	@Parameters({ "Environment",})
	public static void setup(@Optional String environment)
			throws Exception {
		PropertiesRepository.appendProperties("TestConfig.properties");

		PropertiesRepository.appendProperties("log4j.properties");
		/* Implemented log4j ,Just enable below comments and use the feature */
		

		if (environment != null && !environment.isEmpty())
			Envirnomentundertest = environment;
		else
			Envirnomentundertest = PropertiesRepository.getString("com.cnb.environmentToTest");

		
		
		if(Envirnomentundertest.contains("local")) {
			
			System.out.println("local");
			
			Screen screen = new Screen();
			DesktopOptions option=new DesktopOptions();
			
			option.setApplicationPath("C:\\FPS\\FAS706\\FAS\\FAS.exe");
			
			
		    driver=new WiniumDriver(new URL("http://localhost:9999"), option);
			System.out.println(driver);
			Thread.sleep(10000);
			 driver.findElement(By.name("Run as Demo")).click();
             Thread.sleep(2000);

 			 BasePage.SendKeysById("txtPassword", "Password@123");
 			 Thread.sleep(2000);
 			 			
 			 
 			 BasePage.clickonEnterKey();
 			// BasePage.ClickWithUISPYAutomationName(Locators.Login);
 			// driver.findElement(By.name("l")).click();
 			 Thread.sleep(7000);
 			// driver.findElement(By.name("Cancel")).click();
 			 
 			
 			  driver.findElement(By.name("Client ID Row 0")).click();
 			  
 			  
 			  driver.findElement(By.name("OK")).click();
 			  Thread.sleep(7000);
			
			
		}

        else if(Envirnomentundertest.contains("client")) {

            System.out.println("client");

            Screen screen = new Screen();
            DesktopOptions option=new DesktopOptions();

            option.setApplicationPath("C:\\FPS\\FAS706\\FAS\\FAS.exe");
           

            driver=new WiniumDriver(new URL("http://localhost:9999"), option);
            System.out.println(driver);
            Thread.sleep(30000);
            driver.findElement(By.name("OK")).click();
            Thread.sleep(6000);
          //  BasePage.ClickWithUISPYAutomationName(Locators.zCalc);

        }
		
	}
	
	public static String capture(String screenShotName,String Jiranum) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+Jiranum+"\\"+screenShotName+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);                                
        return dest;
    }	
}