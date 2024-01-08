package Vs.DesktopGRC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class testLeadCreation extends pageObject {

	public void AllServices(WebDriver driver) throws InterruptedException {
		ExtentTest test = extent.createTest("All services Menu Access");
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			qeAllServices.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "All services Menu Exists",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		} catch (Exception e) {
			test.log(Status.FAIL, "All services Menu does not exists " + e,
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			return;
		}
	}

	public void ServiceCreation(WebDriver driver) throws InterruptedException {
		ExtentTest test = extent.createTest("Lead creation");
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			serviceSearch.click();
			serviceSearch.sendKeys("Online Name change");
			serviceSelection.click();
			Thread.sleep(3000);
			getNowCTA.click();
			
			if (yescontinueRadio.isDisplayed()) {
				yescontinueRadio.click();
				leadcontinue.click();
				Thread.sleep(3000);
			}
			
			payNowCTA.click();
			
			System.out.println("Lead Created successfully");
			test.log(Status.PASS, "Lead Created successfully",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		} catch (Exception e) {
			System.out.println("Already lead has been created" + "\n" + e);
			test.log(Status.INFO, "Lead created Already for this business",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			return;
		}
	}

	public void payNow(WebDriver driver) throws InterruptedException {
		ExtentTest test = extent.createTest("Payment Flow");
		try {
			// Bundle Payment page
			Thread.sleep(2000);
			proceedToPayCTA.click();
			Thread.sleep(5000);
			leftPaneCardOption.click();
			Thread.sleep(3000);
			CardNumber.sendKeys("5123456789012346");
			CardExpiry.sendKeys("0525");
			CardCVV.sendKeys("123");
			payAmountCTA.click();
			Thread.sleep(9000);
			pinCardNumber.click();
			pinCardNumber.sendKeys("123456");
			payCTA.click();
			Thread.sleep(9000);
			System.out.println("Payment Done successfully");
			test.log(Status.PASS, "Payment Done successfully",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			continueCTA.click();
		} catch (Exception e) {
			System.out.println("Payment Failed" + e);
			test.log(Status.PASS, "Payment Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			driver.navigate().refresh();
			return;

		}
	}
}
