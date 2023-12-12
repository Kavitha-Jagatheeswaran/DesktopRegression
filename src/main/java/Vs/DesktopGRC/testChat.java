package Vs.DesktopGRC;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class testChat extends pageObject {
	ExtentTest test = extent.createTest("Chat");
	public void chat(WebDriver driver) throws InterruptedException, AWTException {
		try {
		Thread.sleep(9000);
		driver.get("https://qe-grc.vakilsearch.com");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		myServices.click();
		chatBot.click();
		Thread.sleep(3500);
		String a = "Testing Purpose";
		Robot robot = new Robot();
		for (char c : a.toCharArray()) {
			int Keycode1 = KeyEvent.getExtendedKeyCodeForChar(c);
			robot.keyPress(Keycode1);
			robot.keyRelease(Keycode1);
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(6000);
		driver.switchTo().frame(0);
		chatClose.click();
		System.out.println("Chat Added Successfully");
		Thread.sleep(3000);
		test.log(Status.PASS, "Chat Added Successfully", MediaEntityBuilder
				.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		}
		catch(Exception e) {
			System.out.println("Chat feature is not functional");
			Thread.sleep(2000);
			test.log(Status.FAIL, "Chat feature is not functional", MediaEntityBuilder
					.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			System.out.println(e);
			return;
		}
		
	}
}
