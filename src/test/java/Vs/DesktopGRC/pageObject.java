package Vs.DesktopGRC;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class pageObject {

	public static ExtentReports extent;
	public static ExtentSparkReporter htmlReporter;

	// Production Login Locators

	@FindBy(xpath = "(//button[contains(text(),'Login')])[1]")
	public static WebElement prodloginCTA;

	@FindBy(xpath = "//input[@placeholder='Mobile number or Email']")
	public static WebElement produserEmail;

	@FindBy(xpath = "//input[@type='password']")
	public static WebElement produserPassword;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public static WebElement prodcontinueCTA;

	@FindBy(xpath = "//span[contains(text(),'Home')]")
	public static WebElement prodHomepage;

	// QE Login Locators

	@FindBy(xpath = "//input[@placeholder='Mobile number or Email']")
	public static WebElement qeuserEmail;

	@FindBy(xpath = "//p[contains(text(),'Continue')]")
	public static WebElement qecontinueCTA;

	@FindBy(xpath = "//input[@aria-label='Please enter verification code. Digit 1']")
	public static WebElement qeOTP;

	@FindBy(xpath = "(//p[contains(text(),'Login')])[1]")
	public static WebElement qeloginCTA;

	@FindBy(xpath = "//span[contains(text(),'Home')]")
	public static WebElement qeHomepage;

	@FindBy(xpath = "//div[@class='styles_popUp__zs6_I  undefined']")
	public static WebElement personalisePopup;

	@FindBy(xpath = "//img[@alt='closeIcon']")
	public static WebElement personalisePopupclose;

	// Home Page

	@FindBy(xpath = "//span[contains(text(),'Payments')]")
	public static WebElement paymentsPage;

	@FindBy(xpath = "//span[contains(text(),'Compliance calendar')]")
	public static WebElement compliancePage;

	// Signup Flow

	@FindBy(xpath = "//input[@placeholder='Your company name']")
	public static WebElement companyName;

	@FindBy(xpath = "//span[contains(text(),'MEERACLE APPAREL LLP')]")
	public static WebElement selectCompanyName;

	@FindBy(xpath = "//p[contains(text(),'Next')]")
	public static WebElement signupNext;

	@FindBy(xpath = "//p[contains(text(),'Software')]")
	public static WebElement softwarebusinessIndustry;

	@FindBy(xpath = "//img[@alt='edit']")
	public static WebElement editIcon;

	@FindBy(xpath = "//span[contains(text(),'Agriculture / Dairy Farming')]")
	public static WebElement AgribusinessIndustry;

	@FindBy(xpath = "//button[@class='styles_switch__XK30M styles_active__giZl1']")
	public static WebElement companyNameSwitch;

	// Lead Creation

	@FindBy(xpath = "//span[contains(text(),'All services')]")
	public static WebElement qeAllServices;

	@FindBy(xpath = "//input[@placeholder='Search all services']")
	public static WebElement serviceSearch;

	@FindBy(xpath = "//li[contains(text(),'Online Name change')]")
	public static WebElement serviceSelection;

	@FindBy(xpath = "(//p[@class=' text-center leading-[20px]'])[3]")
	public static WebElement getNowCTA;


	@FindBy(xpath = "//p[contains(text(),'Yes, continue')]")
	public static WebElement yescontinueRadio;

	@FindBy(xpath = "//button[@class='styles_continue__MQObn']")
	public static WebElement leadcontinue;

	@FindBy(xpath = "//button[(contains(text(),'Pay')) and (@class='styles_continue__MQObn')]")
	public static WebElement payNowCTA;

	
	//Onboarding bundle payment flow
	
	@FindBy(xpath="(//span[contains(text(),'Proceed to pay')])[1]")
	public static WebElement proceedToPayCTA;
	
	@FindBy(xpath="//a[@id='left-tabs-example-tab-card']")
	public static WebElement leftPaneCardOption;

	// Payment flow
	
	@FindBy(xpath = "//input[@name='cardNumber']")
	public static WebElement CardNumber;

	@FindBy(xpath = "//input[@name='cardExpiry']")
	public static WebElement CardExpiry;

	@FindBy(xpath = "//input[@name='cardCVV']")
	public static WebElement CardCVV;

	@FindBy(xpath = "//button[(@type='submit') and (@class='styles_payment_page_button_active__OA822 undefined')]")
	public static WebElement payAmountCTA;

	@FindBy(xpath = "//input[@type='password']")
	public static WebElement pinCardNumber;

	@FindBy(xpath = "//input[@value ='PAY']")
	public static WebElement payCTA;
	
	//Payment success continue
	
	@FindBy(xpath = "//button[(contains(text(),'Continue')) and (@class='styles_payment_success_button__bwOX4')]")
	public static WebElement continueCTA;	

	// Chat flow

	@FindBy(xpath = "//img[@alt='chat']")
	public static WebElement chatBot;

	@FindBy(xpath = "//div[@id='mck-text-box' and @class='mck-blk-8 mck-text-box mck-text required notranslate']")
	public static WebElement typeQueries;

	@FindBy(xpath = "((//div[@class='blk-lg-2 mck-close-btn'])[1]/child::button)[2]")
	public static WebElement chatClose;

	// Search Messages flow

	@FindBy(xpath = "//span[contains(text(),'Messages')]")
	public static WebElement messagesOption;

	@FindBy(xpath = "//input[@placeholder='Search in mail']")
	public static WebElement searchMail;

	@FindBy(xpath = "(//div[@class='styles_dropdownItemHeader__YA85A'])[1]")
	public static WebElement searchMailListSelection;

	@FindBy(xpath = "(//img[@alt='reply'])[1]")
	public static WebElement messageReply;

	@FindBy(xpath = "//div[@class='ql-editor ql-blank']")
	public static WebElement replyEditor;

	@FindBy(xpath = "//img[@alt='attach']")
	public static WebElement mailAttachFile;

	@FindBy(xpath = "(//button[contains(text(),'Send')])[1]")
	public static WebElement messageSend;

	@FindBy(xpath = "//p[contains(text(),'Forward')]")
	public static WebElement messageForward;

	@FindBy(xpath = "//div[@class='ql-editor']")
	public static WebElement forwardEditor;

	// User Profile Update

	@FindBy(xpath = "//span[contains(text(),'My services')]")
	public static WebElement myServices;

	@FindBy(xpath = "//img[(@alt='Profile Info') and (@src='/_next/static/media/profile.e4e408d6.svg')]")
	public static WebElement profileIcon;

	@FindBy(xpath = "//p[(@class=' text-center leading-[20px]') and (contains(text(),'View Profile'))]")
	public static WebElement viewProfileCTAClick;

	@FindBy(xpath = "//input[@class='styles_input__0YldI']")
	public static WebElement editUserName;

	@FindBy(xpath = "/img[@class='styles_calendarIconBlank__0shh2']")
	public static WebElement calendarDOBiconclick;

	@FindBy(xpath = "//select[@class='react-datepicker__year-select']")
	public static WebElement yearPicker;

	@FindBy(xpath = "//div[@class='react-datepicker__day styles_day__2cTUV react-datepicker__day--001 react-datepicker__day--selected']")
	public static WebElement dateSelection;

	@FindBy(xpath = "//span[contains(text(),'Female')]")
	public static WebElement genderSelection;

	@FindBy(xpath = "//p[contains(text(),'Update Details')]")
	public static WebElement updateDetailsCTA;

	// Add Email
	@FindBy(xpath = "//p[(@class=' text-center leading-[20px]') and (contains(text(),'Add Email'))]")
	public static WebElement addEmailCTAClick;

	@FindBy(xpath = "//input[@placeholder='Enter Email Id']")
	public static WebElement enterEmail;

	@FindBy(xpath = "//p[(@class=' text-center leading-[20px]') and (contains(text(),'Send OTP'))]")
	public static WebElement sendOTPCTAClick;

	@FindBy(xpath = "//a[(@dataindex='1') and (contains(text(),'Verify now'))]")
	public static WebElement emailVerifyNowLink;

	@FindBy(xpath = "//input[@aria-label='Please enter verification code. Character 1']")
	public static WebElement profileOTP;

	@FindBy(xpath = "//p[(@class=' text-center leading-[20px]') and (contains(text(),'Verify'))]")
	public static WebElement verifyIDCTA;

	@FindBy(xpath = "//p[contains(text(),'Got it')]")
	public static WebElement gotItCTA;

	// Add Mobile Number
	@FindBy(xpath = "//p[contains(text(),'Add Mobile')]")
	public static WebElement addMobileNumberCTA;

	@FindBy(xpath = "//input[@class='styles_input__iCHOG']")
	public static WebElement enterMobileNumber;

	// Delete the Mobile Number
	@FindBy(xpath = "//img[@id='menu-btn-1']")
	public static WebElement menuOptionClick;

	@FindBy(xpath = "//p[contains(text(),'Delete')]")
	public static WebElement deleteOption;

	@FindBy(xpath = "//button[@class='styles_confirmButton__9CGfn']")
	public static WebElement yesCTA;

	// Logout the app
	@FindBy(xpath = "//p[contains(text(),'Sign out')]")
	public static WebElement logOutOption;

	// Add Organization
	@FindBy(xpath = "//p[@class='styles_entityName__aO211']")
	public static WebElement selectEntityDropdown;

	@FindBy(xpath = "//a[@class='styles_addBtn__S8RFc']")
	public static WebElement addBusinessCTA;

	@FindBy(xpath = "//p[(@class=' text-center leading-[20px]') and (contains(text(),\"Let's go\"))]")
	public static WebElement letsGetCTA;

	@FindBy(xpath = "//span[@class='styles_dropdownArrow__figM4 ']")
	public static WebElement businessType;

	@FindBy(xpath = "//li[contains(text(),'Trust')]")
	public static WebElement businessTypeDropdown;

	@FindBy(xpath = "(//input[@class='styles_textInput__k8w0C'])[1]")
	public static WebElement businessNameTextField;

	@FindBy(xpath = "(//input[@class='styles_textInput__k8w0C'])[2]")
	public static WebElement PANtextField;

	@FindBy(xpath = "//img[@alt='arrow']")
	public static WebElement continueBusinessCTA;

	@FindBy(xpath = "//span[@class='styles_dropdownArrow__figM4 ']")
	public static WebElement businessIndustry;

	@FindBy(xpath = "//li[contains(text(),'Food & Beverage')]")
	public static WebElement businessIndustryDropdowLlist;

	@FindBy(xpath = "//input[@name='search_name_input']")
	public static WebElement subIndustry;

	@FindBy(xpath = "//li[contains(text(),'Import and Export')]")
	public static WebElement subIndustryDropdownList;

	@FindBy(xpath = "//button[@class='styles_skipBtn__kZWFU']")
	public static WebElement busineessAddressSkip;
	
	
	//Upload Documents
	
	@FindBy(xpath="//h4[contains(text(),'Online Name change')]")
	public static WebElement checkStatus;
	
	@FindBy(xpath="//img[@alt='upload']")
	public static WebElement uploadProcessCTA;
	
	@FindBy(xpath="(//img[@alt='info'])[1]")
	public static WebElement photoInfoIconClick;
	
	@FindBy(xpath="//button[@class='styles_filled__6NyJe false']")
	public static WebElement UploadDocsInfoPopup;
	
	@FindBy(xpath="(//button[@class='styles_outlined__OU5af false' and contains(text(),'Upload')])[1]")
	public static WebElement signatureUploadCTA;
	
	@FindBy(xpath="//img[@alt='arrow']")
	public static WebElement arrowIcon;
	
	@FindBy(xpath="(//button[contains(text(),'View')])[1]")
	public static WebElement viewCTA;
	
	@FindBy(xpath="//img[@alt='replace']")
	public static WebElement replaceCTA;
	
	@FindBy(xpath="//img[@alt='close']")
	public static WebElement closeIcon;
	
	@FindBy(xpath="//img[@alt='delete']")
	public static WebElement deleteIcon;
	
	@FindBy(xpath="//button[@class='styles_filled__i5Pmj undefined  ']")
	public static WebElement yesDeleteCTA;
	
	@FindBy(xpath="(//div[@class='styles_selectPlaceholder__57214'] //child::img[@alt='language'])[2]")
	public static WebElement languageDropdown;
	
	@FindBy(xpath="//li[contains(text(),'Hindi')]")
	public static WebElement translateHindi;
	
	@FindBy(xpath="//li[contains(text(),'English')]")
	public static WebElement translateEnglish;
	
	@FindBy(xpath="//button[contains(text(),'अपलोड करें')]")
	public static WebElement hindiContent;

	public void startReport() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
		
		String reportFilename = "Extentreport " + currentDateTime.format(formatter);
		htmlReporter = new ExtentSparkReporter(
				"\\\\14.140.167.188\\Vakilsearch\\VakilsearchSmokeTesting\\GRC_automation_data\\Output\\Report\\"+ reportFilename +".html");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	// Take and save the screenshot
	public static String takeAndSaveScreenshot(WebDriver driver) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmm");
		String ssFilename = "Screenshot " + RandomStringUtils.random(3, characters) +" "+ currentDateTime.format(formatter);

		if (driver instanceof TakesScreenshot) {
			// Capture the screenshot
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// Define a file path to save the screenshot
			String screenshotPath = "\\\\14.140.167.188\\Vakilsearch\\VakilsearchSmokeTesting\\GRC_automation_data\\Output\\Screenshot\\"
					+ ssFilename + ".png";

			try {
				// Save the screenshot to the specified path
				FileHandler.copy(screenshot, new File(screenshotPath));
				System.out.println(ssFilename + " saved");
				return screenshotPath;
			} catch (Exception e) {
				System.err.println("Failed to save screenshot: " + e.getMessage());
			}
		}
		return null;

	}

	public void stopReport() {
		extent.flush();
	}

}
