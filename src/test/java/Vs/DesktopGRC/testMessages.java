package Vs.DesktopGRC;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.*;

public class testMessages extends pageObject {
	ExtentTest test = extent.createTest("Messages");

	public void searchMessages(WebDriver driver) throws InterruptedException, StaleElementReferenceException {
		try {
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			driver.get("https://qe-grc.vakilsearch.com");
			Thread.sleep(6000);
			messagesOption.click();
			Thread.sleep(3000);
			searchMail.click();
			searchMail.sendKeys("Name");
			Thread.sleep(3000);
			System.out.println("Message searched successfully");
			test.log(Status.PASS, "Message searched successfully",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			searchMailListSelection.click();
			Thread.sleep(6000);
		} catch (Exception e) {
			System.out.println("Message search failed " + e);
			test.log(Status.FAIL, "Message search failed " + e,
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			System.out.println(e);
		}
	}

	public void replyMessages(WebDriver driver) throws InterruptedException, IOException, AWTException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			messageReply.click();
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", replyEditor);
			replyEditor.click();
			replyEditor.sendKeys("Testing purpose");
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mailAttachFile);

			WebElement attachFile = wait.until(ExpectedConditions.elementToBeClickable(mailAttachFile));
			attachFile.click();

			// Set the file path to the clipboard
			String filePath = "\\\\14.140.167.188\\Vakilsearch\\VakilsearchSmokeTesting\\GRC_automation_data\\Upload_Files\\Men.jpg";
			StringSelection stringSelection = new StringSelection(filePath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);

			// Paste the file path from the clipboard
			try {
				Robot robot = new Robot();
				robot.delay(2000); // Delay to allow the file dialog to open

				// Press Ctrl+V to paste the file path
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);

				// Press Enter to confirm the file selection
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			} catch (Exception e) {
				e.printStackTrace();
			}
			messageSend.click();
			Thread.sleep(1000);
			System.out.println("Message Replied successfully");
			test.log(Status.PASS, "Message Replied successfully",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		} catch (Exception e) {
			System.out.println("Message reply failed " + e);
			test.log(Status.FAIL, "Message reply failed " + e,
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			System.out.println(e);
		}
	}

	public void forwardMessages(WebDriver driver) throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			Thread.sleep(6000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			long initialPageHeight;
			long newPageHeight;

			messageForward.click();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", forwardEditor);
			WebElement forwardEdit = wait.until(ExpectedConditions.elementToBeClickable(forwardEditor));
			forwardEdit.click();
			forwardEdit.sendKeys("Testing purpose");
			do {
				initialPageHeight = (long) js.executeScript("return document.body.scrollHeight");

				// Scroll down a bit
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

				// Wait for a short time to let content load
				try {
					Thread.sleep(2000); // Adjust the sleep time as needed
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				newPageHeight = (long) js.executeScript("return document.body.scrollHeight");
			} while (newPageHeight > initialPageHeight);
			WebElement forwardmailSend = wait.until(ExpectedConditions.elementToBeClickable(messageSend));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", forwardmailSend);
			forwardmailSend.click();
			Thread.sleep(1000);
			System.out.println("Message Forwarded successfully");
			test.log(Status.PASS, "Message Forwarded successfully",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		} catch (Exception e) {
			System.out.println("Message Forward failed " + e);
			test.log(Status.FAIL, "Message Forward failed " + e,
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			System.out.println(e);
		}
	}

}
