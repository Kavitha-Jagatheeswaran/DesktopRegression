package Vs.DesktopGRC;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class testRun extends pageObject {
	String[][] data = null;

	@DataProvider(name = "itemsdata")
	public String[][] loginDataProvider() throws IOException, BiffException {
		data = getExcelData();
		return data;
	}

	@BeforeSuite
//To fetch the data from the excel sheet
	public String[][] getExcelData() throws IOException, BiffException {

		FileInputStream excel = new FileInputStream(
				"\\\\14.140.167.188\\Vakilsearch\\Vakilsearch_Smoke_Testing\\Excel\\GRC Automation Data.xls");
		Workbook workbook = Workbook.getWorkbook(excel);
		Sheet sheet = workbook.getSheet("GRC data");
		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();

		String testData[][] = new String[rowCount][columnCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				testData[i][j] = sheet.getCell(j, i).getContents();

			}
		}
		System.out.println(testData.toString());
		return testData;

	}

	public static WebDriver driver;

	@BeforeTest
	public void openBrowser() throws InterruptedException, AWTException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "itemsdata")

	public void GRCRegression(String url, String Email, String password) throws Exception {
		startReport();
		try {/*
				 * // Get URL baseClass base = new baseClass(); base.getURL(driver, url, Email,
				 * password); base.loginSuccess(driver, url, Email, password);
				 * 
				 */
			// Add Organization
			testOrganization newBusiness = new testOrganization();
			newBusiness.addorganization(driver);

			// Home Page - All Menu options available
			testHome Homepage = new testHome();
			Homepage.Payments(driver);
			Homepage.Compliance(driver);

			// Lead Creation
			testLeadCreation LeadCreation = new testLeadCreation();
			LeadCreation.AllServices(driver);
			LeadCreation.ServiceCreation(driver);

			// Payment Flow
			LeadCreation.payNow(driver);

			// Messages Flow
			testMessages Messages = new testMessages();
			Messages.searchMessages(driver);
			Messages.replyMessages(driver);
			// Messages.forwardMessages(driver);

			// User Profile update
			testUserProfile userProfile = new testUserProfile();
			userProfile.viewProfile(driver);
			userProfile.addEmail(driver);
			userProfile.addMobileNumber(driver);

			// Chat
			testChat ChatBot = new testChat();
			ChatBot.chat(driver);

			/*
			 * // Logout Flow userProfile.logout(driver);
			 * 
			 * // Sign-up Flow testSignup signupFlow = new testSignup();
			 * signupFlow.signUp(driver);
			 */

			ExtentTest test = extent.createTest("GRC Execution");
			test.log(Status.PASS, "GRC Execution Successfully",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		} catch (Exception e) {
			ExtentTest test = extent.createTest("GRC Execution");
			System.out.println("GRC Execution Failed");
			Thread.sleep(2000);
			test.log(Status.FAIL, "GRC Execution Failed" + " \n " + e,
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			System.out.println(e);

		}
		stopReport();
	}

	@AfterTest
	public void quite() throws AWTException, EmailException {

		System.out.println("Test completed");
	}

	@AfterSuite
	public void quite1() {
		System.out.println("Quit");
	}

}
