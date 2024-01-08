package Vs.DesktopGRC;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class testUserProfile extends pageObject {
	ExtentTest test = extent.createTest("User Profile");

//Navigate to User Profile page from Home Page
	public void viewProfile(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		try {
			qeAllServices.click();
			WebDriverWait wait = new WebDriverWait(driver, 50);
			WebElement profileIconClick = wait.until(ExpectedConditions.elementToBeClickable(profileIcon));
			profileIconClick.click();
			Thread.sleep(3000);
			viewProfileCTAClick.click();
			Thread.sleep(6000);
			editUserName.click();
			editUserName.clear();
			String characters = "abcdefghijklmnopqrstuvwxyz";
			String uniqueUserName = "Test User " + RandomStringUtils.random(5, characters);
			editUserName.sendKeys(uniqueUserName);
			if ((updateDetailsCTA.isDisplayed()) == true) {
				updateDetailsCTA.click();
				System.out.println("User details added successfully");
				test.log(Status.PASS, "User details added successfully", MediaEntityBuilder
						.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			} else {
				driver.navigate().refresh();
				System.out.println("No user details to update");
				test.log(Status.FAIL, "No user details to update", MediaEntityBuilder
						.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());

			}
		} catch (Exception e) {
			driver.navigate().refresh();
			System.out.println("User details update failed");
			test.log(Status.FAIL, "User details update failed",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			System.out.println(e);
		}
	}

	// Add Email-ID in User Profile
	public void addEmail(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addEmailCTAClick);
			addEmailCTAClick.click();
			Thread.sleep(3000);
			String uniqueUserName = "abcdefghijklmnopqrstuvwxyz";
			String uniqueEmailID = RandomStringUtils.random(6, uniqueUserName) + "@yopmail.com";
			enterEmail.sendKeys(uniqueEmailID);
			sendOTPCTAClick.click();
			Thread.sleep(6000);
			emailVerifyNowLink.click();
			profileOTP.sendKeys("000000");
			verifyIDCTA.click();
			Thread.sleep(2000);
			gotItCTA.click();
			Thread.sleep(3000);
			System.out.println("Added and Verified E-Mail ID Screenshot");
			test.log(Status.PASS, "E-Mail added and verified successfully",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());

			if ((menuOptionClick.isEnabled()) == true) {
				menuOptionClick.click();
				Thread.sleep(3000);
				deleteOption.click();
				yesCTA.click();
				Thread.sleep(2000);
				System.out.println("E-Mail ID Deleted successfully");
				test.log(Status.PASS, "E-Mail deleted successfully", MediaEntityBuilder
						.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());

			}
		} catch (Exception e) {
			System.err.println(e.getMessage() + "Added Email ID Missing");
			driver.navigate().refresh();
			test.log(Status.FAIL, "Added Email ID Missing",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());

		}
	}

	// Add Mobile Number in User Profile
	public void addMobileNumber(WebDriver driver) throws InterruptedException {
		try {
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			long initialPageHeight;
			long newPageHeight;
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			do {
				initialPageHeight = (long) js.executeScript("return document.body.scrollHeight");
				// Scroll down a bit
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(2000);
				newPageHeight = (long) js.executeScript("return document.body.scrollHeight");
			} while (newPageHeight > initialPageHeight);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addMobileNumberCTA);
			addMobileNumberCTA.click();
			Thread.sleep(3000);
			String number = "1234567890";
			String uniqueMobileNumber = "9" + RandomStringUtils.random(9, number);
			enterMobileNumber.sendKeys(uniqueMobileNumber);
			sendOTPCTAClick.click();
			profileOTP.sendKeys("000000");
			verifyIDCTA.click();
			gotItCTA.click();
			Thread.sleep(2000);
			System.out.println("Mobile Number added and verified successfully");
			Thread.sleep(3000);
			test.log(Status.PASS, "Mobile Number added and verified successfully",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			pageObject.takeAndSaveScreenshot(driver);

			if ((menuOptionClick.isEnabled()) == true) {
				menuOptionClick.click();
				Thread.sleep(3000);
				deleteOption.click();
				yesCTA.click();
				System.out.println("Mobile Number Deleted successfully");
				Thread.sleep(3000);
				test.log(Status.PASS, "Mobile Number Deleted successfully", MediaEntityBuilder
						.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			}
		} catch (Exception e) {
			driver.navigate().refresh();
			System.out.println("Added Mobile Number Missing");
			test.log(Status.FAIL, "Added Mobile Number Missing",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		}
	}

	public void logout(WebDriver driver) throws InterruptedException {
		ExtentTest test = extent.createTest("Logout");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			WebElement profileIconClick = wait.until(ExpectedConditions.elementToBeClickable(profileIcon));
			profileIconClick.click();
			Thread.sleep(3000);
			logOutOption.click();
			System.out.println("Logout success");
			Thread.sleep(3000);
			test.log(Status.PASS, "Logout success",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		} catch (Exception e) {
			driver.navigate().refresh();
			System.out.println("Profile icon is missing");
			Thread.sleep(3000);
			test.log(Status.FAIL, "Profile icon is Missing",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		}
	}
}
