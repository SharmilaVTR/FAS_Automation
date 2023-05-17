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




public class FAS extends BaseTest {

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
				test.log(LogStatus.PASS, "In the Income Grid>> Income transaction is appeared with Amount = 2000.00 and Accrued Portion = 1000.00");
				//Ok_Name

				BasePage.ClickWithUISPYAutomationName(Locators.Ok_Name);
				//driver.findElement(By.name("OK")).click();


				BasePage.ClickWithUISPYAutomationName(Locators.AcctDate_Name);

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







	@Test(description = "FasIncomeTestcase A/T sale Transaction")

	public void FasIncomeTestcaseATsaleTransaction() throws Exception {

		try {
			Screen screen = new Screen();
			String testCaseID1 = "Fas_demo_10";

			testResult = Reporter.getCurrentTestResult();
			String jiraNumber = testResult.getMethod().getDescription();
			test = extentReports.startTest(jiraNumber);
			
		

			
		    	test.log(LogStatus.PASS, "FAS Login Screen will be displayed.");

		    	Thread.sleep(1000);
				// driver.findElement(By.name("Cancel")).click();

				test.log(LogStatus.PASS, "FAS must get logged in and 'Open a Client' dialog must be displayed.");
				Thread.sleep(1000);
				test.log(LogStatus.PASS, "Client should get opened");       			  
				BasePage.ClickWithUISPYAutomationName(Locators.ATBrowser_Name);
				
				BasePage.ClickWithUISPYAutomationName(Locators.AssertID_Name);
				
				test.log(LogStatus.PASS, "Original Asset with AssetName = Assetone should be created"); 
				BasePage.ClickWithUISPYAutomationID(Locators.DetailAdd_Name);
				
				BasePage.ClickWithUISPYAutomationName(Locators.SaleRedeemCollect);
				//BasePage.ClickWithUISPYAutomationName(Locators.DetailAdd_Name);
				
				BasePage.ClickWithUISPYAutomationID(Locators.btnOK_Id);

				



				test.log(LogStatus.PASS, "'AssetName = Assetone' record should be selected");
				//driver.findElement(By.name("Asset ID Row 0")).click();
				// Thread.sleep(5000);
				test.log(LogStatus.PASS, "Add Income: Assetone' window must be displayed");
				
				BasePage.ClickWithUISPYAutomationID(Locators.cmbAssetName);

				BasePage.ClickWithUISPYAutomationName(Locators.Assertone);


				BasePage.ClickWithUISPYAutomationID(Locators.cmbDepositTo);

				

				Thread.sleep(2000);
				BasePage.sendChar("Cashone");
				// driver.findElement(By.name("Cashone")).click();

				/// driver.findElement(By.id("txtDate")).sendKeys(Date);
				BasePage.ClickWithUISPYAutomationID(Locators.dtpSettlementDate);
				

				// driver.findElement(By.id("txtDate")).click();

				Actions action = new Actions(driver);
				Thread.sleep(2000);
				action.moveByOffset(66,-14).perform();
				Thread.sleep(1000);

				action.click().perform();
				Thread.sleep(1000);
				action.click().perform();
				Thread.sleep(1000);
				action.click().perform();
				
				BasePage.ClickWithUISPYAutomationID(Locators.dtpTaxDate);

				Thread.sleep(2000);
				action.moveByOffset(66,-14).perform();

				action.click().perform();
				Thread.sleep(1000);
				action.click().perform();
				Thread.sleep(1000);
				action.click().perform();
				Thread.sleep(1000);
				action.click().perform();
				Thread.sleep(1000);

				BasePage.ClickWithUISPYAutomationID(Locators.chkOverrideInventoryValue);
				

				Thread.sleep(2000);
				action.moveByOffset(-45,0).perform();
				action.doubleClick().perform();
				BasePage.sendChar("200");
				BasePage.ClickWithUISPYAutomationID(Locators.chkOverrideInventoryValue);
				BasePage.ClickWithUISPYAutomationID(Locators.chkOverrideInventoryValue);


				action.moveByOffset(45,0).perform();
				action.doubleClick().perform();
				BasePage.sendChar("1500");

				// BasePage.ClickTabButton(Keys.TAB);

				BasePage.ClickWithUISPYAutomationID(Locators.txtNarrative);
				

				BasePage.sendChar("Hello");

				// Actions action = new Actions(driver);
				WebElement ss= driver.findElement(By.name("Save & Continue"));
				action.moveToElement(ss).perform();


				action.moveByOffset(0,-55).perform();
				action.doubleClick().perform();

				BasePage.sendChar("1200");


				//				Double d=  1200.10;
				//				String str = Double.toString(d);
				//				action.sendKeys("1").perform();
				//				action.sendKeys(org.openqa.selenium.Keys.ARROW_RIGHT);
				//				action.sendKeys("1").perform();
				//BasePage.sendChar(str);
				
				BasePage.ClickWithUISPYAutomationID(Locators.btnOK_Id);
				BasePage.clickonEnterKey();

				//BasePage.ClickWithUISPYAutomationID(Locators.btnOK_Id);
						
				test.log(LogStatus.PASS, "TC Passed.");

			}
		catch (Exception e) {

			String screenShotName = new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
			String screenShotPath = capture(screenShotName, "FAS");
			test.log(LogStatus.FAIL, "Please find Snapshot below: " + test.addScreenCapture(screenShotPath));
			test.log(LogStatus.FAIL, "FAS" + e.getMessage());
			throw new Exception(e);
		}

	}






	@Test(description = "FasIncomeTestcase B/D Browser")

	public void FasIncomeTestcaseBDBrowser() throws Exception {

		try {
			Screen screen = new Screen();
			String testCaseID1 = "Fas_demo_17";

			testResult = Reporter.getCurrentTestResult();
			String jiraNumber = testResult.getMethod().getDescription();
			test = extentReports.startTest(jiraNumber);
				
				test.log(LogStatus.PASS, "FAS Login Screen will be displayed.");
				Thread.sleep(1000);
				
				Thread.sleep(1000);
				// driver.findElement(By.name("Cancel")).click();

				test.log(LogStatus.PASS, "FAS must get logged in and 'Open a Client' dialog must be displayed.");


				test.log(LogStatus.PASS, "Client should get opened");       			  
				BasePage.ClickWithUISPYAutomationName(Locators.BD_Name);
				BasePage.ClickWithUISPYAutomationID(Locators.btnMasterAdd);

				
			   test.log(LogStatus.PASS, "Original Asset with AssetName = Assetone should be created"); 
			   
			   BasePage.ClickWithUISPYAutomationID(Locators.txtFirstName);

				
				BasePage.sendChar("one");
				 BasePage.ClickWithUISPYAutomationID(Locators.txtLastName);
				BasePage.sendChar("Bene");
				Robot rrr = new Robot();
				 BasePage.ClickWithUISPYAutomationID(Locators.txtSortName);
				

				rrr.keyPress(KeyEvent.VK_TAB);
				//				driver.findElement(By.id("txtSSN")).click();
				//				Robot rrr = new Robot();
				//				for (int i = 0 ; i<8;i++) {
				//										rrr.keyPress(KeyEvent.VK_BACK_SPACE);
				//				}
				//				
				BasePage.sendChar("987654321");
				 BasePage.ClickWithUISPYAutomationID(Locators.txtAddress1);
					
				
				BasePage.sendChar("Adressone");
				
				
				 BasePage.ClickWithUISPYAutomationID(Locators.txtCity);
				
				BasePage.sendChar("Newyork");
				 BasePage.ClickWithUISPYAutomationID(Locators.txtCity);
				 
				BasePage.ClickWithUISPYAutomationID(Locators.cmbStates);
				BasePage.sendChar("NY");
				
				// BasePage.ClickWithUISPYAutomationID(Locators.NY);		
				 BasePage.ClickTabButton();

				//	driver.findElement(By.id("txtZip")).click();
				BasePage.sendChar("998998998");


				rrr.keyPress(KeyEvent.VK_TAB);

				BasePage.sendChar("0401234567");
				BasePage.ClickWithUISPYAutomationID(Locators.cmbRelations);

				
				BasePage.sendChar("Cousin");
				driver.findElement(By.name("Cousin")).click();

				 BasePage.ClickTabButton();
				BasePage.ClickWithUISPYAutomationID(Locators.chkInterestedParty);
				
				BasePage.ClickWithUISPYAutomationID(Locators.txtNatureOfInterest);
				
				BasePage.sendChar("Hello Interested");
				
				BasePage.ClickWithUISPYAutomationID(Locators.btnOK_Id);
				BasePage.ClickWithUISPYAutomationName(Locators.Close_Name);
				
				BasePage.ClickWithUISPYAutomationName(Locators.BD_Name);
				
				Thread.sleep(3000);
				//BasePage.ClickWithUISPYAutomationID(Locators.btnOK_Id);
				BasePage.ClickWithUISPYAutomationID(Locators.btnMasterDelete);
				BasePage.ClickWithUISPYAutomationID(Locators.btnYes);
				

				BasePage.ClickWithUISPYAutomationName(Locators.Close_Name);

				test.log(LogStatus.PASS, "B/D Browser TC Passed.");

			}
		catch (Exception e) {

			String screenShotName = new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
			String screenShotPath = capture(screenShotName, "FAS");
			test.log(LogStatus.FAIL, "Please find Snapshot below: " + test.addScreenCapture(screenShotPath));
			test.log(LogStatus.FAIL, "FAS" + e.getMessage());
			throw new Exception(e);
		}

	}






	@Test(description = "FasIncomeTestcase L/T Browser")

	public void FasIncomeTestcaseLTBrowser() throws Exception {

		try {
			Screen screen = new Screen();
			String testCaseID1 = "Fas_demo_20";

			testResult = Reporter.getCurrentTestResult();
			String jiraNumber = testResult.getMethod().getDescription();
			test = extentReports.startTest(jiraNumber);
			JSONArray listOfSearchData = jsonReader.readJSONDataFromFile(testCaseID1);

			for (Object searchString : listOfSearchData) {

				JSONObject jsonObjectChild = (JSONObject) searchString;

				String sectionKey = "LiabilityName";
				String LiabilityName = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey);
				String sectionKey1 = "Liability1";
				String Liability1 = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey1);


				String sectionKey3 = "GroupHeader";
				String GroupHeader = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey3);

				String sectionKey4 = "LiabilityID";
				String LiabilityID = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey4);

				String sectionKey5 = "ReceivedDate";
				String ReceivedDate = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey5);

				String sectionKey6 = "InterestRate";
				String InterestRate = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey6);


				String sectionKey7 = "RedemptionDate";
				String RedemptionDate = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey7);

				String sectionKey8 = "InventoryValue";
				String InventoryValue = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey8);

				String sectionKey9 = "AccruedAmount";
				String AccruedAmount = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey9);

				String sectionKey10 = "narrative";
				String narrative = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey10);

				Robot rrr = new Robot();

				
				test.log(LogStatus.PASS, "FAS Login Screen will be displayed.");

				

				test.log(LogStatus.PASS, "FAS must get logged in and 'Open a Client' dialog must be displayed.");


				
				test.log(LogStatus.PASS, "Client should get opened");       			  
				driver.findElement(By.name("L/T")).click();
				driver.findElement(By.name("L")).click();


				test.log(LogStatus.PASS, "Original Asset with AssetName = Assetone should be created"); 
				//driver.findElement(By.id("txtLiabilityName")).click();
				BasePage.sendChar(LiabilityName);

				rrr.keyPress(KeyEvent.VK_TAB);
				BasePage.sendChar(Liability1);

				//driver.findElement(By.id("cmbLiabilityType")).click();
				rrr.keyPress(KeyEvent.VK_TAB);
				BasePage.sendChar("Liens");
				rrr.keyPress(KeyEvent.VK_TAB);
				//driver.findElement(By.id("cmbGroupHeader")).click();
				BasePage.sendChar(GroupHeader);			
				rrr.keyPress(KeyEvent.VK_TAB);	
				//driver.findElement(By.name("1")).click();
				//	driver.findElement(By.id("txtLiabilityID")).click();
				//	driver.findElement(By.id("txtLiabilityID")).click();
				BasePage.sendChar(LiabilityID);

				driver.findElement(By.id("rdoIncome")).click();

				rrr.keyPress(KeyEvent.VK_TAB);



				BasePage.sendChar(ReceivedDate);
				rrr.keyPress(KeyEvent.VK_TAB);

				BasePage.sendChar(InterestRate);
				rrr.keyPress(KeyEvent.VK_TAB);
				BasePage.sendChar(RedemptionDate);
				rrr.keyPress(KeyEvent.VK_TAB);								
				BasePage.sendChar(InventoryValue);

				rrr.keyPress(KeyEvent.VK_TAB);
				rrr.keyRelease(KeyEvent.VK_TAB);
				rrr.keyPress(KeyEvent.VK_TAB);
				rrr.keyRelease(KeyEvent.VK_TAB);
				rrr.keyPress(KeyEvent.VK_TAB);
				rrr.keyRelease(KeyEvent.VK_TAB);
				rrr.keyPress(KeyEvent.VK_TAB);
				rrr.keyRelease(KeyEvent.VK_TAB);
				rrr.keyPress(KeyEvent.VK_TAB);	

				BasePage.sendChar(AccruedAmount);

				driver.findElement(By.id("txtAddDeathTaxNarrative")).click();
				BasePage.sendChar(narrative);


				driver.findElement(By.id("btnOK")).click(); 


				driver.findElement(By.id("btnDetailDelete")).click(); 

				driver.findElement(By.id("btnYes")).click(); 


				driver.findElement(By.id("btnMasterDelete")).click(); 
				driver.findElement(By.id("btnYes")).click(); 
				driver.findElement(By.name("Close (Alt -X)")).click();

				test.log(LogStatus.PASS, "L/T Browser TC Passed.");

			}}
		catch (Exception e) {

			String screenShotName = new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
			String screenShotPath = capture(screenShotName, "FAS");
			test.log(LogStatus.FAIL, "Please find Snapshot below: " + test.addScreenCapture(screenShotPath));
			test.log(LogStatus.FAIL, "FAS" + e.getMessage());
			throw new Exception(e);
		}

	}
	@Test(description = "FasIncomeTestcase Close Client And Exit Application")

	public void zasIncomeTestcaseCloseClientAndExitApplication() throws Exception {

		try {
			Screen screen = new Screen();
			String testCaseID1 = "Fas_demo";

			testResult = Reporter.getCurrentTestResult();
			String jiraNumber = testResult.getMethod().getDescription();
			test = extentReports.startTest(jiraNumber);

			Robot rrr = new Robot();
	    test.log(LogStatus.PASS, "FAS Login Screen will be displayed.");
		test.log(LogStatus.PASS, "FAS must get logged in and 'Open a Client' dialog must be displayed.");
     	test.log(LogStatus.PASS, "ClientID = FAS123 should get closed");       			  
			driver.findElement(By.name("File")).click();

			driver.findElement(By.name("Close Client")).click();
			test.log(LogStatus.PASS, "Original Asset with AssetName = Assetone should be created");
			Thread.sleep(2000);

			test.log(LogStatus.PASS, " 'AssetName = Assetone' record should be selected");
			test.log(LogStatus.PASS, " 'Add Income: Assetone' window must be displayed");
			test.log(LogStatus.PASS, "  When selected Deposit To = Cashone, below pop up is appeared");
			driver.findElement(By.name("File")).click();
			driver.findElement(By.name("Exit")).click();

			driver.findElement(By.id("btnYes")).click(); 

			test.log(LogStatus.PASS, "FAS Application should successfully closed");

		}
		catch (Exception e) {

			String screenShotName = new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
			String screenShotPath = capture(screenShotName, "FAS");
			test.log(LogStatus.FAIL, "Please find Snapshot below: " + test.addScreenCapture(screenShotPath));
			test.log(LogStatus.FAIL, "FAS" + e.getMessage());
			throw new Exception(e);
		}

	}



	@Test(description = "To validate the functionality of 'Save &Cont' in 'Add asset' in A/T Browser")

	public void ToValidateTheFunctionalityOfSaveContInAddAssetInATBrowser() throws Exception {

		try {
			Screen screen = new Screen();
			String testCaseID1 = "FAS_85";

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

				String sectionKey8 = "SortName1";
				String SortName1 = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey8);

				String sectionKey2 = "AssetID";
				String AssetID = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey2);

				String sectionKey3 = "CUSIP";
				String CUSIP = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey3);

				String sectionKey4 = "GroupHeader";
				String GroupHeader = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey4);

				String sectionKey5 = "State";
				String State = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey5);

				String sectionKey6 = "EIN";
				String EIN = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey6);

				String sectionKey7 = "InterestRate";
				String InterestRate = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey7);

				Double D= 5.10;

				driver.findElement(By.name("A/T")).click();

				test.log(LogStatus.PASS, "'Add Original/Subsequent Asset' window is displayed.");

				driver.findElement(By.id("btnMasterAdd")).click();
				Thread.sleep(2000); 

				BasePage.sendChar(Name);

				BasePage.ClickTabButton();

				BasePage.sendChar(SortName);

				driver.findElement(By.id("cmbAssetType")).click();

				driver.findElement(By.name("Annuities")).click();

				driver.findElement(By.id("btnSaveClose")).click();

				test.log(LogStatus.PASS, " 'Add Original/Subsequent Asset: Cashone' is autopopulated and Accrued Amount = 459.99 appears.");


				//After Save And Continue

				driver.findElement(By.id("txtAssetName")).click();

				BasePage.sendChar(Name);

				BasePage.ClickTabButton();

				BasePage.sendChar(SortName1);

				BasePage.ClickTabButton();

				BasePage.sendChar(AssetID);

				BasePage.ClickTabButton();
				BasePage.sendChar(CUSIP);

				BasePage.ClickTabButton();

				BasePage.ClickTabButton();

				BasePage.sendChar(State);

				BasePage.ClickTabButton();

				BasePage.ClickTabButton();

				BasePage.sendChar("Annuities");

				BasePage.ClickTabButton();

				BasePage.sendChar(GroupHeader);

				BasePage.ClickTabButton();

				BasePage.sendChar(EIN);

				BasePage.ClickTabButton();

				BasePage.ClickTabButton();

				BasePage.sendChar("04/13/2023");

				BasePage.ClickTabButton();

				BasePage.sendChar("04/13/2023");

				BasePage.ClickTabButton();

				BasePage.ClickTabButton();

				BasePage.ClickTabButton();


				BasePage.sendChar("50");

				Robot ss= new Robot();

				ss.keyPress(KeyEvent.VK_RIGHT);

				BasePage.sendChar("10");

				driver.findElement(By.id("btnOK")).click();


				test.log(LogStatus.PASS, "'Cashone' record is displayed in the Asset grid of A/I Browser and A/T Browser.");



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


	@Test(description = "FAS-Adding an Expenses in C/E Browser ")

	public void FASAddingAnExpensesInCEBrowser() throws Exception {

		try {
			Screen screen = new Screen();
			String testCaseID1 = "FAS_17";

			testResult = Reporter.getCurrentTestResult();
			String jiraNumber = testResult.getMethod().getDescription();
			test = extentReports.startTest(jiraNumber);

			JSONArray listOfSearchData = jsonReader.readJSONDataFromFile(testCaseID1);

			for (Object searchString : listOfSearchData) {

				JSONObject jsonObjectChild = (JSONObject) searchString;

				String sectionKey = "PrincipalAmt";
				String PrincipalAmt = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey);

				String sectionKey1 = "Date";
				String Date = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey1);

				String sectionKey8 = "Check";
				String Check = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey8);

				String sectionKey2 = "Narrative";
				String Narrative = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey2);



				Actions action = new Actions(driver);

				test.log(LogStatus.PASS, "FAS Login Screen will be displayed.");
	         // driver.findElement(By.name("Cancel")).click();
				test.log(LogStatus.PASS, "FAS must get logged in and 'Open a Client' dialog must be displayed.");

				

				test.log(LogStatus.PASS, "Client should get opened.");
                BasePage.ClickWithUISPYAutomationName(Locators.CEBrowser);
				
                BasePage.ClickWithUISPYAutomationID(Locators.DetailAdd_Name);
				

				test.log(LogStatus.PASS, "'Expenses/Debts' window must be displayed.");

				 BasePage.ClickWithUISPYAutomationID(Locators.cmbExpenseDebtType);
				
				 BasePage.ClickWithUISPYAutomationName(Locators.AttorneyFees);
				

				BasePage.ClickTabButton();

				BasePage.sendChar(PrincipalAmt);
				 BasePage.ClickWithUISPYAutomationID(Locators.txtDate);
				

				BasePage.sendChar(Date);
				
				BasePage.ClickTabButton();
				BasePage.sendChar("Cashone");
				BasePage.ClickTabButton();
				 BasePage.ClickWithUISPYAutomationID(Locators.txtCheck);

				BasePage.sendChar(Check);
				 BasePage.ClickWithUISPYAutomationID(Locators.txtNarrative);
				

				BasePage.sendChar(Narrative);

				 BasePage.ClickWithUISPYAutomationID(Locators.radTaxable);
				
				 BasePage.ClickWithUISPYAutomationID(Locators.btnOK_Id);
				

				test.log(LogStatus.PASS, "Expense record with 'Attorney Fees' expense type must be appeared in the C/E Browser >> Payment grid.");



				test.log(LogStatus.PASS, "TC Passed.");



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
	


	@Test(description = "Add 'Adjustment to Inventory: Gain/Loss' through toolbar")

	public void FASInWBrowser() throws Exception {

		try {
			Screen screen = new Screen();
			String testCaseID1 = "Fas_demo_18";
			//String testCaseID = "FAS_17";

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

				String sectionKey2 = "unit";
				String unit = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey2);


				String sectionKey3 = "Assertone";
				String Assertone = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey3);



				test.log(LogStatus.PASS, "FAS Login Screen will be displayed.");




				Thread.sleep(1000);
				// driver.findElement(By.name("Cancel")).click();
				test.log(LogStatus.PASS, "FAS must get logged in and 'Open a Client' dialog must be displayed.");


				test.log(LogStatus.PASS, "Client should get opened.");
				BasePage.ClickWithUISPYAutomationName(Locators.WBrowser);

				test.log(LogStatus.PASS, "Retire/Expiration'window must be displayed");
				BasePage.sendChar(Assertone);

				BasePage.ClickTabButton();
				BasePage.ClickTabButton();


				BasePage.sendChar(Date);


				BasePage.ClickTabButton();
				BasePage.ClickTabButton();
				BasePage.ClickTabButton();

				BasePage.sendChar(Amount);
				BasePage.ClickTabButton();
				BasePage.sendChar(unit);

				BasePage.ClickWithUISPYAutomationName(Locators.Ok_Name);



				test.log(LogStatus.PASS, "The newly added 'Retire as Worthless' record should be appeared in the A/T browser>> Transaction grid.");



				BasePage.ClickWithUISPYAutomationName(Locators.ATBrowser_Name);


				BasePage.ClickWithUISPYAutomationID(Locators.btnDetailDelete_Name);
				BasePage.ClickWithUISPYAutomationID(Locators.btnYes);

				BasePage.ClickWithUISPYAutomationName(Locators.Close_Name);





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

	
	
	

	@Test(description = "Add 'Adjustment to Inventory: Gain/Loss' through toolbar")

	public void AddAdjustmenttoInventoryGainLossthroughtoolbars() throws Exception {

		try {
			Screen screen = new Screen();
			String testCaseID1 = "Fas_demo_18";
			//String testCaseID = "FAS_17";

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

				String sectionKey2 = "unit";
				String unit = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey2);


				String sectionKey3 = "Assertone";
				String Assertone = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey3);

				String sectionKey4 = "units";
				String units = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey4);




				test.log(LogStatus.PASS, "FAS Login Screen will be displayed.");




				Thread.sleep(1000);
				// driver.findElement(By.name("Cancel")).click();
				test.log(LogStatus.PASS, "FAS must get logged in and 'Open a Client' dialog must be displayed.");


				test.log(LogStatus.PASS, "Client should get opened.");
				BasePage.ClickWithUISPYAutomationName(Locators.AIBrowser);

				test.log(LogStatus.PASS, "Retire/Expiration'window must be displayed");
				BasePage.sendChar(Assertone);

				BasePage.ClickTabButton();
				BasePage.ClickTabButton();


				BasePage.sendChar(Date);


				BasePage.ClickTabButton();
				BasePage.ClickTabButton();
				

				BasePage.sendChar(Amount);
			
				BasePage.ClickWithUISPYAutomationID(Locators.Narrative);

				BasePage.sendChar(units);

				BasePage.ClickWithUISPYAutomationName(Locators.Ok_Name);




				BasePage.ClickWithUISPYAutomationName(Locators.ATBrowser_Name);

				test.log(LogStatus.PASS, "The newly added 'Adjustment to Inventory:Gain/Loss' record should be appeared in theA/T browser>> Transaction grid");



				BasePage.ClickWithUISPYAutomationID(Locators.btnDetailDelete_Name);
				BasePage.ClickWithUISPYAutomationID(Locators.btnYes);

				BasePage.ClickWithUISPYAutomationName(Locators.Close_Name);





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

	
	
	
	
	
	
	@Test(description = "FAS-Adding a 'Incurred Liability' through toolbar")

	public void FASAddingaIncurredLiabilitythroughtoolbar() throws Exception {

		try {
			Screen screen = new Screen();
			String testCaseID1 = "Fas_demo_19";

			testResult = Reporter.getCurrentTestResult();
			String jiraNumber = testResult.getMethod().getDescription();
			test = extentReports.startTest(jiraNumber);

			

				Actions action = new Actions(driver);

				test.log(LogStatus.PASS, "FAS Login Screen will be displayed.");
	         // driver.findElement(By.name("Cancel")).click();
				test.log(LogStatus.PASS, "FAS must get logged in and 'Open a Client' dialog must be displayed.");

				

				test.log(LogStatus.PASS, "Client should get opened.");
                BasePage.ClickWithUISPYAutomationName(Locators.IL_Browser);			
				

				BasePage.sendChar("Liabilityone");
				
				BasePage.ClickTabButton();
				BasePage.sendChar("Liability1");

				BasePage.ClickTabButton();

				BasePage.sendChar("1234");
				
				BasePage.ClickTabButton();
				BasePage.sendChar("Liabilities");
				BasePage.ClickTabButton();

				BasePage.sendChar("Cashone");
				BasePage.ClickTabButton();
				BasePage.ClickTabButton();

				test.log(LogStatus.PASS, "'Incurred Liability'window must be displayed");

				BasePage.sendChar("30");
				BasePage.ClickTabButton();
				BasePage.sendChar("30");
				BasePage.ClickTabButton();
				BasePage.sendChar("5/17/2023");

				 BasePage.ClickWithUISPYAutomationID(Locators.btnOK_Id);
				
				  BasePage.ClickWithUISPYAutomationName(Locators.LT_Browser);		
				test.log(LogStatus.PASS, "The newly added 'Incurred Liability' record should be appeared in theL/T browser>> Transaction grid");

				BasePage.ClickWithUISPYAutomationID(Locators.btnDetailDelete_Name);
				BasePage.ClickWithUISPYAutomationID(Locators.btnYes);

				BasePage.ClickWithUISPYAutomationName(Locators.Close_Name);




				test.log(LogStatus.PASS, "TC Passed.");



			

		}
		catch (Exception e) {

			String screenShotName = new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
			String screenShotPath = capture(screenShotName, "FAS");
			test.log(LogStatus.FAIL, "Please find Snapshot below: " + test.addScreenCapture(screenShotPath));
			test.log(LogStatus.FAIL, "FAS" + e.getMessage());
			throw new Exception(e);
		}

	}
	


	
	@Test(description = "FAS-Adding a 'Return of Principal' through toolbar.")

	public void FASAddingAReturnOfPrincipalThroughToolbar() throws Exception {
		
		try {
			Screen screen = new Screen();
			String testCaseID1 = "FAS_03";
			
			testResult = Reporter.getCurrentTestResult();
			String jiraNumber = testResult.getMethod().getDescription();
			test = extentReports.startTest(jiraNumber);
			
			JSONArray listOfSearchData = jsonReader.readJSONDataFromFile(testCaseID1);

			for (Object searchString : listOfSearchData) {

				JSONObject jsonObjectChild = (JSONObject) searchString;
				
				String sectionKey = "Name";
				String Name = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey);
				
				String sectionKey1 = "DepositTo";
				String DepositTo = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey1);
				
				String sectionKey5 = "AccountingDate";
				String AccountingDate = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey5);
				
				String sectionKey6 = "Proceeds";
				String Proceeds = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey6);
				
				String sectionKey7 = "Narrative";
				String Narrative = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey7);
				
				
				test.log(LogStatus.PASS, "FAS Login Screen is displayed.");
				
				test.log(LogStatus.PASS, "FAS must get logged in and 'Open a Client' dialog must be displayed.");
				  
        			  test.log(LogStatus.PASS, "Client account is opened.");
        			  BasePage.ClickWithUISPYAutomationName(Locators.RBrowser_Name);
        			  
        			  BasePage.sendChar(Name);
 
        			 test.log(LogStatus.PASS, "'Return of Principal' window must be displayed.");
        			 
        			 BasePage.ClickTabButton();
        	
        			 BasePage.sendChar(DepositTo);
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.sendChar(AccountingDate);
        			 
        			 BasePage.ClickTabButton();
        			 BasePage.sendChar(Proceeds);
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.ClickTabButton();
        			
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.sendChar(Narrative);
        			
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.ClickWithUISPYAutomationName(Locators.Ok_Name);
        			 
        			 BasePage.ClickWithUISPYAutomationName(Locators.ATBrowser_Name);	
       			
       			 Thread.sleep(2000);
       			 

       			BasePage.ClickWithUISPYAutomationName(Locators.EntryRow0_Name);

       			BasePage.ClickWithUISPYAutomationID(Locators.btnDetailDelete_Name);
       			BasePage.ClickWithUISPYAutomationID(Locators.btnYes);
       			test.log(LogStatus.PASS, "The added 'Return of Principal' must be appeared in the A/T browser>> Transaction grid.");
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
	

	
	@Test(description = "FAS-Adding a 'Capital Gain Distribution' through toolbar.")

	public void FASAddingACapitalGainDistributionThroughToolbar() throws Exception {
		
		try {
			Screen screen = new Screen();
			String testCaseID1 = "FAS_04";
			
			testResult = Reporter.getCurrentTestResult();
			String jiraNumber = testResult.getMethod().getDescription();
			test = extentReports.startTest(jiraNumber);
			
			JSONArray listOfSearchData = jsonReader.readJSONDataFromFile(testCaseID1);

			for (Object searchString : listOfSearchData) {

				JSONObject jsonObjectChild = (JSONObject) searchString;
				
				String sectionKey = "Name";
				String Name = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey);
				
				String sectionKey1 = "DepositTo";
				String DepositTo = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey1);
				
				String sectionKey5 = "AccountingDate";
				String AccountingDate = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey5);
				
				String sectionKey6 = "Proceeds";
				String Proceeds = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey6);
				
				String sectionKey7 = "Narrative";
				String Narrative = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey7);
				
				
				test.log(LogStatus.PASS, "FAS Login Screen is displayed.");
				
				test.log(LogStatus.PASS, "FAS must get logged in and 'Open a Client' dialog must be displayed.");
				  
        			  test.log(LogStatus.PASS, "Client account is opened.");
        			  BasePage.ClickWithUISPYAutomationName(Locators.CBrowser_Name);
        			  
        			  BasePage.sendChar(Name);
 
        			 test.log(LogStatus.PASS, "'Capital gain Distribution' window must be displayed.");
        			 
        			 BasePage.ClickTabButton();
        	
        			 BasePage.sendChar(DepositTo);
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.sendChar(AccountingDate);
        			 
        			 BasePage.ClickTabButton();
        			 BasePage.sendChar(Proceeds);
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.ClickTabButton();
        			
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.sendChar(Narrative);
        			
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.ClickWithUISPYAutomationID(Locators.LongTerm_ID);
        			 
        			
        			 BasePage.ClickWithUISPYAutomationName(Locators.Ok_Name);
        			 
        			 BasePage.ClickWithUISPYAutomationName(Locators.ATBrowser_Name);	
       			
       			 Thread.sleep(2000);
       			 

       			BasePage.ClickWithUISPYAutomationName(Locators.EntryRow0_Name);

       			BasePage.ClickWithUISPYAutomationID(Locators.btnDetailDelete_Name);
       			BasePage.ClickWithUISPYAutomationID(Locators.btnYes);
       			test.log(LogStatus.PASS, "The added 'Capital gain Distribution' must be appeared in the A/T browser>> Transaction grid");
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
	

	@Test(description = "FAS-Adding an Asset/Purchase through toolbar.")

	public void FASAddingAnAssetPurchaseThroughToolbar() throws Exception {
		
		try {
			Screen screen = new Screen();
			String testCaseID1 = "FAS_05";
			
			testResult = Reporter.getCurrentTestResult();
			String jiraNumber = testResult.getMethod().getDescription();
			test = extentReports.startTest(jiraNumber);
			
			JSONArray listOfSearchData = jsonReader.readJSONDataFromFile(testCaseID1);

			for (Object searchString : listOfSearchData) {

				JSONObject jsonObjectChild = (JSONObject) searchString;
				
				String sectionKey1 = "AccruedPaid";
				String AccruedPaid = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey1);
				
				String sectionKey5 = "SettlementDate";
				String SettlementDate = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey5);
				
				String sectionKey6 = "Units";
				String Units = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey6);
				
				String sectionKey7 = "PurchasePrice";
				String PurchasePrice = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey7);
				
				
				test.log(LogStatus.PASS, "FAS Login Screen is displayed.");
				
				test.log(LogStatus.PASS, "FAS must get logged in and 'Open a Client' dialog must be displayed.");
				  
        			  test.log(LogStatus.PASS, "Client account is opened.");
        			  BasePage.ClickWithUISPYAutomationName(Locators.PBrowser_Name);
        			  
        			  test.log(LogStatus.PASS, "'Add Asset/Purchase' window must be displayed.");
        			  
        			  BasePage.ClickWithUISPYAutomationID(Locators.AddAssetDropdown_ID);
        			  
        			  BasePage.clickonDownArrow();
        			  
        			  BasePage.clickonEnterKey();
        			  
        			  BasePage.ClickWithUISPYAutomationID(Locators.PrincipalRadioButton_ID);
        			  
        			  BasePage.ClickTabButton();
        			 
        			  BasePage.sendChar(SettlementDate);
 
        			 BasePage.ClickTabButton();
        	
        			 BasePage.sendChar(Units);
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.sendChar(PurchasePrice);
        			 
        			 BasePage.ClickTabButton();
        			
        			 BasePage.sendChar(AccruedPaid);
        			
        			 BasePage.ClickWithUISPYAutomationName(Locators.Ok_Name);
        			 
        			 BasePage.ClickWithUISPYAutomationName(Locators.Ok_Name);
        			 
        			 BasePage.ClickWithUISPYAutomationName(Locators.ATBrowser_Name);	
       			
       			 Thread.sleep(2000);
       			 
       			BasePage.ClickWithUISPYAutomationID(Locators.btnDetailDelete_Name);
       			BasePage.ClickWithUISPYAutomationID(Locators.btnYes);
       			test.log(LogStatus.PASS, "The newly added Purchase record should be appeared in the  A/T browser>> Transaction grid.");
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
	

	@Test(description = "FAS-Adding a Stock Split through toolbar.")

	public void FASAddingAStockSplitThroughToolbar() throws Exception {
		
		try {
			Screen screen = new Screen();
			String testCaseID1 = "FAS_06";
			
			testResult = Reporter.getCurrentTestResult();
			String jiraNumber = testResult.getMethod().getDescription();
			test = extentReports.startTest(jiraNumber);
			
			JSONArray listOfSearchData = jsonReader.readJSONDataFromFile(testCaseID1);

			for (Object searchString : listOfSearchData) {

				JSONObject jsonObjectChild = (JSONObject) searchString;
				
				String sectionKey1 = "Name";
				String Name = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey1);
				
				String sectionKey5 = "SettlementDate";
				String SettlementDate = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey5);
				
				String sectionKey6 = "Units";
				String Units = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey6);
				
				String sectionKey7 = "Narrative";
				String Narrative = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey7);
				
				
				test.log(LogStatus.PASS, "FAS Login Screen is displayed.");
				
				test.log(LogStatus.PASS, "FAS must get logged in and 'Open a Client' dialog must be displayed.");
				  
        			  test.log(LogStatus.PASS, "Client account is opened.");
        			  BasePage.ClickWithUISPYAutomationName(Locators.STBrowser_Name);
        			  
        			  test.log(LogStatus.PASS, "'Stock Split' window must be displayed.");
        			  
        			  BasePage.sendChar(Name);
 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.ClickTabButton();
        	
        			 BasePage.sendChar(Units);
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.sendChar(SettlementDate);
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.ClickTabButton();
        			
        			 BasePage.sendChar(Narrative);
        			
        			 BasePage.ClickWithUISPYAutomationName(Locators.Ok_Name);
        			 
        			 BasePage.ClickWithUISPYAutomationName(Locators.Ok_Name);
        			 
        			 BasePage.ClickWithUISPYAutomationName(Locators.ATBrowser_Name);	
       			
       			 Thread.sleep(2000);
       			 
       			BasePage.ClickWithUISPYAutomationID(Locators.btnDetailDelete_Name);
       			BasePage.ClickWithUISPYAutomationID(Locators.btnYes);
       			test.log(LogStatus.PASS, "The newly added Stock Split record should be appeared in the  A/T browser>> Transaction grid.");
       		 BasePage.ClickWithUISPYAutomationID(Locators.btnDetailClose_Id);	 
       			
        			  
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
	


	@Test(description = "FAS-Adding a Spin Off through toolbar.")

	public void FASAddingASpinOffThroughToolbar() throws Exception {
		
		try {
			Screen screen = new Screen();
			String testCaseID1 = "FAS_07";
			
			testResult = Reporter.getCurrentTestResult();
			String jiraNumber = testResult.getMethod().getDescription();
			test = extentReports.startTest(jiraNumber);
			
			JSONArray listOfSearchData = jsonReader.readJSONDataFromFile(testCaseID1);

			for (Object searchString : listOfSearchData) {

				JSONObject jsonObjectChild = (JSONObject) searchString;
				
				String sectionKey1 = "Name";
				String Name = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey1);
				
				String sectionKey5 = "DispositionDate";
				String DispositionDate = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey5);
				
				String sectionKey6 = "Narrative";
				String Narrative = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey6);
				
				String sectionKey7 = "MarketShare";
				String MarketShare = jsonReader.readKeyValueFromJsonObject(jsonObjectChild, sectionKey7);
				
				
				test.log(LogStatus.PASS, "FAS Login Screen is displayed.");
				
				test.log(LogStatus.PASS, "FAS must get logged in and 'Open a Client' dialog must be displayed.");
				  
        			  test.log(LogStatus.PASS, "Client account is opened.");
        			  BasePage.ClickWithUISPYAutomationName(Locators.SPBrowser_Name);
        			  
        			  test.log(LogStatus.PASS, "'SpinOff/Exchange' window must be displayed.");
        			  
        			  BasePage.sendChar(Name);
        			  
        			  BasePage.ClickTabButton();
        			  
        			  BasePage.ClickWithUISPYAutomationID(Locators.Date_ID);
 
        			 BasePage.sendChar(DispositionDate);
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.sendChar(MarketShare);
        			 
        			 BasePage.ClickTabButton();
        			 
        			 BasePage.clickonEnterKey();
        			 
        			 BasePage.ClickWithUISPYAutomationID(Locators.Asset_ID);
        			 
        			 BasePage.sendChar(Name);
        			 
        			 BasePage.clickonEnterKey();
        			 
        			 BasePage.ClickWithUISPYAutomationName(Locators.Ok_Name);
        			 
        			 BasePage.ClickWithUISPYAutomationID(Locators.Narrative_ID);
        			 
        			 BasePage.sendChar(Narrative);
        			 
        			 BasePage.ClickWithUISPYAutomationName(Locators.Ok_Name);
        			 
        			 BasePage.ClickWithUISPYAutomationName(Locators.ATBrowser_Name);	
       			
       			 Thread.sleep(2000);
       			 
       			/*BasePage.ClickWithUISPYAutomationID(Locators.btnDetailDelete_Name);
       			
       			BasePage.ClickWithUISPYAutomationID(Locators.btnYes);
       			
       			BasePage.ClickWithUISPYAutomationID(Locators.btnDetailDelete_Name);
       			
       			BasePage.ClickWithUISPYAutomationID(Locators.btnYes);*/
       			test.log(LogStatus.PASS, "The newly added SpinOff record should be appeared in the  A/T browser>> Transaction grid.");
       		 BasePage.ClickWithUISPYAutomationID(Locators.btnDetailClose_Id);	 
       			
        			  
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
	
	
	

	
	


}









