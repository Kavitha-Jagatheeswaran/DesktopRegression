package Vs.DesktopGRC;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class testOrganization extends pageObject {
	ExtentTest test = extent.createTest("Organization");

	public void addorganization(WebDriver driver) throws InterruptedException {
		try {
			Thread.sleep(8000);
			qeAllServices.click();
			selectEntityDropdown.click();
			addBusinessCTA.click();
			Thread.sleep(4000);
			letsGetCTA.click();
			Thread.sleep(4000);
			businessType.click();
			businessTypeDropdown.click();
			String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			String panNumber = RandomStringUtils.random(5, letters) + RandomStringUtils.randomNumeric(4)
					+ RandomStringUtils.random(1, letters);
			String uniqueBusinessName = RandomStringUtils.random(8, characters) + " Private Limited Company";
			WebDriverWait wait = new WebDriverWait(driver, 40);
			WebElement businessName = wait.until(ExpectedConditions.elementToBeClickable(businessNameTextField));
			businessName.sendKeys(uniqueBusinessName);
			PANtextField.sendKeys(panNumber);
			continueBusinessCTA.click();
			Thread.sleep(5000);
			businessIndustry.click();
			businessIndustryDropdowLlist.click();
			subIndustry.click();
			subIndustryDropdownList.click();
			continueBusinessCTA.click();
			busineessAddressSkip.click();
			qecontinueCTA.click();
			Thread.sleep(3000);
			System.out.println("New Business added successfully");
			test.log(Status.PASS, "New Business added successfully",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			Thread.sleep(3000);
			if ((personalisePopup.isEnabled()) == true) {
				personalisePopupclose.click();
			} else {
				System.out.println("No personal information popup enabled");
			}
			System.out.println("New Business added successfully");

		} catch (Exception e) {
			System.out.println("Unable to add business " + e);
			Thread.sleep(2000);
			test.log(Status.FAIL, "Unable to add business " + e,
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			System.out.println(e);

		}
	}
	
	public void changeOrganization(WebDriver driver) throws InterruptedException {
		try {
			Thread.sleep(6000);
			qeAllServices.click();
			Thread.sleep(2000);
			selectEntityDropdown.click();
			changePVTOrganization.click();
			Thread.sleep(3000);
			System.out.println("Toggled business successfully");
			test.log(Status.PASS, "Toggled business successfully",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			Thread.sleep(1000);
			
		}
		catch(Exception e) {
			System.out.println("Business toggle is not successfully" + e);
			test.log(Status.FAIL, "Business toggle is not successfully " + e,
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			Thread.sleep(1000);
		}
	}
}
