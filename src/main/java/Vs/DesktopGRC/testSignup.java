package Vs.DesktopGRC;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class testSignup extends pageObject {
	ExtentTest test = extent.createTest("Signup Flow");

	public void signUp(WebDriver driver) throws NullPointerException, InterruptedException {
		try {
		PageFactory.initElements(driver, pageObject.class);
		WebDriverWait wait = new WebDriverWait(driver, 20); // Wait for a maximum of 20 seconds
		String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
		String uniqueUserName = "vsautotest_" + RandomStringUtils.random(2, characters);
		int numberOfSignups = 2;
		for (int signup = 1; signup <= numberOfSignups; signup++) {
			String signupEmail = uniqueUserName+"_"+ signup + "@gmail.com";
			WebElement yourEmail = wait.until(ExpectedConditions.elementToBeClickable(qeuserEmail));
			yourEmail.click();
			yourEmail.clear();
			yourEmail.sendKeys(signupEmail);
			Thread.sleep(3000);
			qecontinueCTA.click();

			if (signup == 1) {

				WebElement newCompanyName = wait.until(ExpectedConditions.elementToBeClickable(companyName));

				newCompanyName.sendKeys("MEERACLE");
				Thread.sleep(5000);
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				Actions action = new Actions(driver);
				action.click(selectCompanyName).perform();
				signupNext.click();
				Thread.sleep(5000);
				softwarebusinessIndustry.click();
				signupNext.click();
				Thread.sleep(5000);
				editIcon.click();
			}
			if (signup == 2) {
				Thread.sleep(5000);
				// companyNameSwitch.click();
				signupNext.click();
				Thread.sleep(5000);
				softwarebusinessIndustry.click();
				signupNext.click();
			}
		}
		Thread.sleep(5000);
		qeOTP.sendKeys("000000");
		Thread.sleep(3000);
		qeloginCTA.click();
		System.out.println("User Signup flow successful");
		Thread.sleep(3000);
		test.log(Status.PASS, "Signup successfully", MediaEntityBuilder
				.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
	}
		catch(Exception e) {
			System.out.println("Signup failed");
			Thread.sleep(3000);
			test.log(Status.FAIL, "Signup failed", MediaEntityBuilder
					.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			System.out.println(e);
			driver.navigate().refresh();
			
		}
	}
	
}
