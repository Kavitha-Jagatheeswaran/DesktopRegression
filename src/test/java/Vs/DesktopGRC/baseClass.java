package Vs.DesktopGRC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class baseClass extends pageObject {
	ExtentTest test = extent.createTest("Login");

	public void getURL(WebDriver driver, String url, String Email, String password) throws Exception {

		driver.get(url);
		Thread.sleep(3000);
	}

	public void loginSuccess(WebDriver driver, String url, String Email, String password) throws Exception {
		try {
		PageFactory.initElements(driver, pageObject.class);
		qeuserEmail.sendKeys(Email);
		qecontinueCTA.click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		qeOTP.click();
		qeOTP.sendKeys(password);
		Thread.sleep(3000);   
		qeloginCTA.click();
		Thread.sleep(3000);
		System.out.println("Logged-In successfully");
		test.log(Status.PASS, "Logged-In successfully", MediaEntityBuilder
				.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		}
		catch(Exception e) {
			System.out.println("Login failed");
			test.log(Status.FAIL, "Login failed", MediaEntityBuilder
					.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			System.out.println(e);
			System.exit(0); 
			
		}
		
	}

}
