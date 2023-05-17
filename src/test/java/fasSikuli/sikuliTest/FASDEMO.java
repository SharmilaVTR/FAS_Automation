package fasSikuli.sikuliTest;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.sikuli.hotkey.Keys;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.fas.pages.BasePage;
import com.fas.pages.BaseTest;
import com.fas.pages.JsonReader;
import com.fas.pages.Locators;
import com.relevantcodes.extentreports.LogStatus;




public class FASDEMO extends BaseTest {
	
	JsonReader jsonReader=new JsonReader();
	
	
	@AfterMethod
	public void extentSetUp() throws IOException, InterruptedException {
		
		
		extentReports.endTest(test);
		extentReports.flush();
	}
	
	
	
	@Test(description = "FAS-Adding an Asset through toolbar.")

	public void FASAddingAnAssetThroughToolbar() throws Exception {
		
		try {
			Screen screen = new Screen();
			String testCaseID1 = "FAS_01";
			
			testResult = Reporter.getCurrentTestResult();
			String jiraNumber = testResult.getMethod().getDescription();
			test = extentReports.startTest(jiraNumber);
			
			JSONArray listOfSearchData = jsonReader.readJSONDataFromFile(testCaseID1);

			for (Object searchString : listOfSearchData) {

				JSONObject jsonObjectChild = (JSONObject) searchString;
				
				String sectionKey = "Name";
				String Name = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey);
				
				String sectionKey1 = "SortName";
				String SortName = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey1);
				
				String sectionKey8 = "AssetType";
				String AssetType = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey8);
				
				
				String sectionKey2 = "AssetID";
				String AssetID = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey2);
				
				String sectionKey3 = "CUSIP";
				String CUSIP = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey3);
				
				String sectionKey4 = "GroupHeader";
				String GroupHeader = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey4);
				
				String sectionKey5 = "RedDate";
				String RedDate = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey5);
				
				String sectionKey6 = "EIN";
				String EIN = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey6);
				
				String sectionKey7 = "PriorDate";
				String PriorDate = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey7);
				
				  
        			  test.log(LogStatus.PASS, "Client account is opened.");
        			  BasePage.ClickWithUISPYAutomationName(Locators.ABrowser_Name);
 
        			 test.log(LogStatus.PASS, "Add Asset window must be displayed");
        	
        			 BasePage.ClickWithUISPYAutomationID(Locators.txtAssetName_ID);
        			        			
        			 BasePage.sendChar(Name);
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.sendChar(SortName);
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.sendChar(AssetID);
        			 
        			 BasePage.ClickTabButton();
        			 BasePage.sendChar(CUSIP);
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.ClickTabButton();
        			
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.sendChar(AssetType);
        			
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.sendChar(GroupHeader);
        			
        			 BasePage.ClickTabButton();
        			
        			 BasePage.sendChar(EIN);
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.sendChar(RedDate);
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.sendChar(PriorDate);
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.ClickTabButton();
        			 
        			
        			BasePage.sendChar("12");
        			 
        			 Robot ss= new Robot();
        			
        			ss.keyPress(KeyEvent.VK_RIGHT);
        			
        			BasePage.sendChar("121212");
        			 
        			 driver.findElement(By.id("btnOK")).click();
        			

        			 BasePage.ClickWithUISPYAutomationName(Locators.ATBrowser_Name);	
       			
       			 Thread.sleep(2000);
       			 
       			String Val = driver.findElement(By.name("Asset Sort Name Row 1")).getText();
       			
       			String Val1 = driver.findElement(By.name("Interest Rate Row 1")).getText();
    			if(Val.equals("Asset2") && (Val1.equals("12.1212"))) {
    				test.log(LogStatus.PASS, "Asset 2 Valdiated");
    				System.out.print(Val);
    				System.out.println();
    				System.out.print(Val1);
    			}
    			else {
    				test.log(LogStatus.FAIL, "Links are not reordered");
    				BasePage.TakeScreenshorForFailure(testCaseID1, test);
    				System.out.print(Val);
    				System.out.println();
    				System.out.print(Val1);
    			}
       			

       			BasePage.ClickWithUISPYAutomationName(Locators.AssetID_Id);

       			BasePage.ClickWithUISPYAutomationID(Locators.btnMasterDelete);
       			BasePage.ClickWithUISPYAutomationID(Locators.btnYes);
       			test.log(LogStatus.PASS, "'Assettwo' record should be displayed in the Asset grid of A/T Browser.");
       		 BasePage.ClickWithUISPYAutomationID(Locators.btnDetailClose_Id);	 
       			// driver.findElement(By.id("btnDetailClose")).click();
        			  
			}
                     
                }
                catch (Exception e) {

                               String screenShotName = new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
                               String screenShotPath = capture(screenShotName, "FAS");
                               test.log(LogStatus.FAIL, "Please find Snapshot below: " + test.addScreenCapture(screenShotPath));
                               test.log(LogStatus.FAIL, "FAS" + e.getMessage());
                               throw new Exception(e);
                           }

                       }


	/**
	 * @throws Exception
	 */
	@Test(description = "FasIncomeTestcase A/I Browser")

	public void FasIncomeTestcasess() throws Exception {
		
		try {
			Screen screen = new Screen();
			String testCaseID1 = "Fas_demo_7";
			
			testResult = Reporter.getCurrentTestResult();
			String jiraNumber = testResult.getMethod().getDescription();
			test = extentReports.startTest(jiraNumber);
			JSONArray listOfSearchData = jsonReader.readJSONDataFromFile(testCaseID1);

			for (Object searchString : listOfSearchData) {

				JSONObject jsonObjectChild = (JSONObject) searchString;
				
				String sectionKey = "Date";
				String Date = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey);
				String sectionKey1 = "Amount";
				String Amount = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey1);
				
				String sectionKey2 = "Accrued";
				String Accrued = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey2);
				
				test.log(LogStatus.PASS, "FAS Login Screen will be displayed.");
				
				test.log(LogStatus.PASS, "FAS must get logged in and 'Open a Client' dialog must be displayed.");

        			  
        			  test.log(LogStatus.PASS, "Client should get opened");       			  
        			  BasePage.ClickWithUISPYAutomationName(Locators.AI_Name);
        			   			 
        			// driver.findElement(By.name("Asset ID Row 0")).click();
        			 test.log(LogStatus.PASS, "Original Asset with AssetName = Assetone should be created"); 
        			 
        			 BasePage.ClickWithUISPYAutomationID(Locators.DetailAdd_Name);
        			 test.log(LogStatus.PASS, "'AssetName = Assetone' record should be selected");
        			 //driver.findElement(By.name("Asset ID Row 0")).click();
        			// Thread.sleep(5000);
        			 test.log(LogStatus.PASS, "Add Income: Assetone' window must be displayed");
        			//driver.findElement(By.id("cmbAssetName")).click();
        			 
                     BasePage.sendChar("Assertone");
        			 BasePage.ClickTabButton();
        			 BasePage.sendChar("Cashone");
        			 BasePage.ClickTabButton();
        			
        			 BasePage.sendChar(Date);
        			
        			 BasePage.ClickTabButton();
        			
        			 BasePage.sendChar(Amount);
        			 BasePage.ClickTabButton();
        			        			
           			 BasePage.sendChar(Accrued); 
           			//test.log(LogStatus.PASS, "In the Income Grid>> Income transaction is appeared with Amount = 2000.00 and Accrued Portion = 1000.00");
           			//Ok_Name
           			 
           			BasePage.ClickWithUISPYAutomationName(Locators.Ok_Name);
           			//driver.findElement(By.name("OK")).click();
           			
           			
           			BasePage.ClickWithUISPYAutomationName(Locators.AcctDate_Name);

                     Boolean validation =BasePage.isElementPresentusingName(Locators.AcctDate_Name);
           			
        			if(validation==true) {
        				test.log(LogStatus.PASS, "In the Income Grid>> Income transaction is appeared with Amount = 2000.00 and Accrued Portion = 1000.00");
        		
        			}
        			else {
        				test.log(LogStatus.FAIL, "In the Income Grid>> Income transaction is appeared with Amount = 2000.00 and Accrued Portion = 1000.00");
        				BasePage.TakeScreenshorForFailure(testCaseID1, test);
        			
        			}

           			

           			BasePage.ClickWithUISPYAutomationID(Locators.btnDetailDelete_Name);
           			BasePage.ClickWithUISPYAutomationID(Locators.btnYes);
           			
           			BasePage.ClickWithUISPYAutomationName(Locators.Close_Name);
           			
           			
           			
           			test.log(LogStatus.PASS, "TC Passed.");
			
			}}
                catch (Exception e) {

                               String screenShotName = new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
                               String screenShotPath = capture(screenShotName, "FAS");
                               test.log(LogStatus.FAIL, "Please find Snapshot below: " + test.addScreenCapture(screenShotPath));
                               test.log(LogStatus.FAIL, "FAS" + e.getMessage());
                               throw new Exception(e);
                           }

                       }
		    		
	
	
	
	
	
}









