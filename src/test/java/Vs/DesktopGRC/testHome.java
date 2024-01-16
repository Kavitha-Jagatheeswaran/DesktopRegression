package Vs.DesktopGRC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class testHome extends pageObject {

	ExtentTest test = extent.createTest("Payment and Compliance Calendar page view access");

	public void Payments(WebDriver driver) throws InterruptedException {
		try {
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement pagePayment = wait.until(ExpectedConditions.elementToBeClickable(paymentsPage));
			pagePayment.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "User can able to view the Payment page",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to access Payment page " + e,
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		}
	}

	public void Compliance(WebDriver driver) throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement complianceMenu = wait.until(ExpectedConditions.elementToBeClickable(compliancePage));
			complianceMenu.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "User can able to view the compliance calendar page ",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to access Compliance calendar page " + e,
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		}

	}
}
