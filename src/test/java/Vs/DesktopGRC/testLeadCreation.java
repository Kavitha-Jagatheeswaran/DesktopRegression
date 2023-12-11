package Vs.DesktopGRC;

import java.util.concurrent.TimeUnit;
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
			serviceSearch.sendKeys("Online Company Registration");
			serviceSelection.click();
			Thread.sleep(3000);
			if (getNowCTA.isDisplayed() == true) {
				getNowCTA.click();
				// Query: Are you interested in service?
				yescontinueRadio.click();
				leadcontinue.click();
				Thread.sleep(3000);
				System.out.println("Lead Created successfully");
				test.log(Status.PASS, "Lead Created successfully", MediaEntityBuilder
						.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			} else if (alreadyLeadCreated.isDisplayed() == true) {
				System.out.println("PVT Lead created already for this customer");
				test.log(Status.INFO, "PVT service already exists", MediaEntityBuilder
						.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
				alreadyLeadCreated.click();
				Thread.sleep(3000);
				driver.navigate().refresh();
			}
		} catch (Exception e) {
			System.out.println("Lead creation error");
			test.log(Status.FAIL, "Lead creation error",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			driver.navigate().refresh();
			return;
		}
	}

	public void payNow(WebDriver driver) throws InterruptedException {
		ExtentTest test = extent.createTest("Payment Flow");
		try {
			payNowCTA.click();
			Thread.sleep(5000);
			if (CardNumber.isDisplayed() == true) {
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				CardNumber.sendKeys("5123456789012346");
				CardExpiry.sendKeys("0525");
				CardCVV.sendKeys("123");
				payAmountCTA.click();
				Thread.sleep(9000);
				pinCardNumber.click();
				pinCardNumber.sendKeys("123456");
				payCTA.click();
				System.out.println("Payment Done successfully");
				test.log(Status.PASS, "Payment Done successfully", MediaEntityBuilder
						.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
				driver.navigate().refresh();
			}
		} catch (Exception e) {
			System.out.println("Payment Failed");
			test.log(Status.PASS, "Payment Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			driver.navigate().refresh();
			return;

		}
	}
}
