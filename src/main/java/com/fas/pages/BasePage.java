package com.fas.pages;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.winium.WiniumDriver;
import org.sikuli.script.Screen;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage extends BaseTest {
	static Screen screen = new Screen();
	

	public static void clickFunction(double Time, Pattern Image) throws Exception {
		try {
			Screen screen = new Screen();
			screen.wait(Time);
			screen.click(Image);
			Thread.sleep(5000);
		} catch (Throwable e) {
			throw new Exception(e);
		}
	};

	// Click with Automation id
	

		public static void ClickWithUISPYAutomationID(String ID) {
			try {
				driver.findElement(By.id(ID)).click();
				Thread.sleep(1000);
			} catch (Exception e) {
				
				System.out.println("ClickWithUISPYAutomationID  " + e.toString());
				test.log(LogStatus.FAIL, "Element " + ID +" "+ "Not Found "
						+ "");
			}
		}

		// Click with Automation Name

		public static void ClickWithUISPYAutomationName(String Name) {
			try {

				driver.findElement(By.name(Name)).click();
				Thread.sleep(2000);
			} catch (Exception e) {
				
				System.out.println("ClickWithUISPYAutomationName  " + e.toString());
				test.log(LogStatus.FAIL, "Element " + Name+" "+ "Not Found "
						+ "");
			}
		}
		
		
		// SendKeys By ID
		public static void SendKeysById(String Id,String value) {
			try {

				driver.findElement(By.id(Id)).sendKeys(value);
				Thread.sleep(2000);

			} catch (Exception e) {
				System.out.println("ClickWithUIName  " + e.toString());
				
				test.log(LogStatus.FAIL, "Element " + Id+ " "+"Not Found "
						+ "");
			}
		}



		// SendKeys By name
		public static void SendKeysByName(String name,String value) {
			try {

				driver.findElement(By.name(name)).sendKeys(value);
				Thread.sleep(2000);

			} catch (Exception e) {
				System.out.println("ClickWithUIName  " + e.toString());
				
				test.log(LogStatus.FAIL, "Element " + name+ "Not Found "
						+ "");
			}
		}
//VALIDATE VALUE
		public static boolean isElementPresentusingName(String Name) {
			boolean flag = false;
			try {
				Thread.sleep(1000);
				return driver.findElement(By.name(Name)).isDisplayed();

			} catch (Exception e) {
				flag = false;
				System.out.println("isElementPresentusingName  " + e.toString());

			}
			return flag;
		}
		// Reset code at end of tc
		public static void openNewClient() throws InterruptedException {
			try { 
			driver.findElement(By.name("File")).click();
		       Thread.sleep(5000);
		       
		       driver.findElement(By.name("Open Client")).click();
		       Thread.sleep(5000);
		     
		       driver.findElement(By.id("1148")).sendKeys("zCalcTB_Sample");
		       Thread.sleep(5000);
		       
		       
		       driver.findElement(By.name("Open")).submit();
		       Thread.sleep(5000);
		       driver.findElement(By.name("No")).click();
		       Thread.sleep(5000);
			}
			catch (Exception e) {
				
				System.out.println("openNewClient  " + e.toString());

			}

		}
		public static void ClickOnInput2() {
			try {  
	        Pattern input2 = new Pattern(System.getProperty("user.dir")
	                + "\\src\\test\\resources\\Images\\Commonimages\\Input2.PNG");
	        
	        screen.click(input2);
	        }
             catch (Exception e) {
				
				System.out.println("ClickOnInput2  " + e.toString());

			}
		}

			public static void ClickOnInput3()  {
				try {  
		        Pattern input3 = new Pattern(System.getProperty("user.dir")
		                + "\\src\\test\\resources\\Images\\Commonimages\\Input3.PNG");
		        
		        screen.click(input3);}
	             catch (Exception e) {
					
					System.out.println("ClickOnInput3  " + e.toString());

				}
			}
				public static void ClickOnInput4()   {
					try {  
			        Pattern input4 = new Pattern(System.getProperty("user.dir")
			                + "\\src\\test\\resources\\Images\\Commonimages\\Input4.PNG");
			        
			        screen.click(input4);}
		             catch (Exception e) {
						
						System.out.println("ClickOnInput4  " + e.toString());

					}
			
		}
				
				
				public static void clickonESC() throws AWTException {
					 Robot robo = new Robot();
				      
				       robo.keyPress(KeyEvent.VK_ESCAPE);
				       
				}
				
		
				
	public static void clickonPageDown() throws AWTException {
		 Robot robo = new Robot();
	      
	       robo.keyPress(KeyEvent.VK_PAGE_DOWN);
	       
	}
	
	
public static void clickonPageUP() throws AWTException {
	 Robot robo = new Robot();
      
	 robo.keyPress(KeyEvent.VK_PAGE_UP);
       
}


public static void clickonEnterKey() throws AWTException {
	 Robot robo = new Robot();
      
	 robo.keyPress(KeyEvent.VK_ENTER);
	 robo.keyRelease(KeyEvent.VK_ENTER);
       
}



//checks if element is displayed
public static boolean isElementPresentusingXpath(String Name) {
  boolean flag = false;
  try {
      Thread.sleep(3000);
      return driver.findElement(By.name(Name)).isDisplayed();

} catch (Exception e) {
      flag = false;
      System.out.println("isElementPresentusingID  " + e.toString());

}
  return flag;
}



//taking Screenshot for Failure Test Case
	public static void TakeScreenshorForFailure(String JiraNumber, ExtentTest test) {
		try {
			String screenShotName = new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
			String screenShotPath = capture(screenShotName, JiraNumber);
			test.log(LogStatus.FAIL, "Please find Snapshot below  : " + test.addScreenCapture(screenShotPath));
		} catch (Exception e) {
			System.out.println("TakeScreenshorForFailure  " + e.toString());

		}
	}


public static void ClickOnFile() throws InterruptedException {
	try {  
		Thread.sleep(2000);
		driver.findElement(By.name("File")).click();
		Thread.sleep(1000);
	}
	 catch (Exception e) {
			
			System.out.println("Click on File" + e.toString());

		}
	}


//checks if element is displayed
public static boolean isElementPresentusingID(String Id) {
boolean flag = false;
try {
  Thread.sleep(3000);
  return driver.findElement(By.id(Id)).isDisplayed();

} catch (Exception e) {
  flag = false;
  System.out.println("isElementPresentusingID  " + e.toString());

}
return flag;
}

public static void ImageClick(String Name) {
try {
 Pattern Name1 = new Pattern(System.getProperty("user.dir")+ Name);
 screen.click(Name1);
 Thread.sleep(3000);
} catch (Exception e) 
{
	System.out.println("ImageClick  " + e.toString());
}
}




public static void  ImageHover(String Name) {

try {
 
  Pattern Name1 = new Pattern(System.getProperty("user.dir")+ Name);
	screen.hover(Name1);
	 Thread.sleep(3000);
	
} catch (Exception e) {
 
  System.out.println("ImageHover  " + e.toString());

}

}


public static void AltF4() throws AWTException, InterruptedException {
	 Robot robo = new Robot();
     
	 robo.keyPress(KeyEvent.VK_ALT);
	 Thread.sleep(1000);
	 robo.keyPress(KeyEvent.VK_F4);
	 
      
}

public static void sendChar(String value) throws InterruptedException
{
	
	try
	{
	// WebElement element =	driver.findElement(By.id("txtAsset));
  //element.clear();
//	 WebElement ss =driver.findElement(By.id(id)); 
//	 ss.click();
	 Thread.sleep(1000);
	 //Thread.sleep(4000);
  for (int i = 0; i < value.length(); i++){
	  Actions action = new Actions(driver);

      char c = value.charAt(i);
      String s = new StringBuilder().append(c).toString();
      action.sendKeys(s).perform();
  } 
	}
	 catch (Exception e) {
		 
		 System.out.println("Tab not pressed.");
		

		}
  
}




public static void ClickTabButton() throws AWTException, InterruptedException {
		
	
	try
	{
		Robot robo = new Robot();
	
	
	robo.keyPress(KeyEvent.VK_TAB);
	robo.keyRelease(KeyEvent.VK_TAB);
	Thread.sleep(1000);
	}
	catch (Exception e) {
		 
		 System.out.println("Tab not pressed.");

		}
}


	


public static void CLICKONAmountinAIBrowser(String value) throws AWTException, InterruptedException {
	 driver.findElement(By.id("txtDate")).click();
	 Actions action = new Actions(driver);
	      action.moveByOffset(0,55).perform();
	    
	 action.doubleClick().perform();
	
		 BasePage.sendChar(value);
		
		 
		 
      
}
	

public static void CLICKONSaleOnIncomeATBrowser(String value) throws AWTException, InterruptedException {
	 Actions action = new Actions(driver);
	 WebElement ss= driver.findElement(By.name("Save & Continue"));
		action.moveToElement(ss).perform();


		action.moveByOffset(0,-55).perform();
		action.doubleClick().perform();
		
		BasePage.sendChar(value);
		
		 
		 
      
}	



public static void CLICKONAccruedAIBrowser(String value) throws AWTException, InterruptedException {
	
	 Actions action = new Actions(driver);
	    
		 Thread.sleep(2000);
		      action.moveByOffset(75,0).perform();
		   
		 action.doubleClick().perform();
		 BasePage.sendChar(value); 
}
	

public static void ClickOnNetATBrowser(String value) throws AWTException, InterruptedException {
	
	Actions action = new Actions(driver);
	 WebElement ss= driver.findElement(By.id("chkOverrideInventoryValue"));
		action.moveToElement(ss).perform();
Thread.sleep(1000);
		action.moveByOffset(-45,0).perform();
		action.doubleClick().perform();
		
		
		BasePage.sendChar(value);
		
		 
		 
      
}	


public static void ClickOnOverRideValueATBrowser(String value) throws AWTException, InterruptedException {
	
	Actions action = new Actions(driver);
	 WebElement ss= driver.findElement(By.id("chkOverrideInventoryValue"));
		action.moveToElement(ss).perform();
		Thread.sleep(1000);
		action.moveByOffset(45,0).perform();
		action.doubleClick().perform();

		
		BasePage.sendChar(value);
		
		 
		 
      
}	


public static void clickonDownArrow() throws AWTException, InterruptedException {
	 Robot robo = new Robot();
     
	 robo.keyPress(KeyEvent.VK_DOWN);
	 robo.keyRelease(KeyEvent.VK_DOWN);
    Thread.sleep(1000);  
}

	

}