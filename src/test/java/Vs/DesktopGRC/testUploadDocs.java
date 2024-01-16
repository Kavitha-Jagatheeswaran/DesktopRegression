package Vs.DesktopGRC;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class testUploadDocs extends pageObject {
	ExtentTest test = extent.createTest("Upload Documents");

	public void uploadDocsPageRedirect(WebDriver driver) throws InterruptedException, StaleElementReferenceException {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		try {
			Thread.sleep(5000);
			myServices.click();
			WebElement serviceStatusPage = wait.until(ExpectedConditions.elementToBeClickable(checkStatus));
			serviceStatusPage.click();
			Thread.sleep(3000);
			uploadProcessCTA.click();
			System.out.println("Upload Document Page Viewed");
			test.log(Status.PASS, "Upload Document Page Viewed",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());

		} catch (Exception e) {
			System.out.println("Upload Document Page is not redirected " + e);
			test.log(Status.FAIL, "Upload Document Page is not redirected " + e,
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		}
	}

	public void uploadFiles(WebDriver driver) {
		try {
			Thread.sleep(3000);
			photoInfoIconClick.click();
			UploadDocsInfoPopup.click();

			// Set the file path to the clipboard [for Passport size photograph]
			String filePath = "\\\\14.140.167.188\\Vakilsearch\\VakilsearchSmokeTesting\\GRC_automation_data\\Upload_Files\\Men.jpg";
			StringSelection stringSelection = new StringSelection(filePath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);

			// Paste the file path from the clip board
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
				System.out.println("First Document Uploaded");
				test.log(Status.PASS, "First Document Uploaded", MediaEntityBuilder
						.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			} catch (Exception e) {
				e.printStackTrace();
			}
			Thread.sleep(3000);
			signatureUploadCTA.click();
			UploadDocsInfoPopup.click();

			// Set the file path to the clip board [for Signature]
			String filePath1 = "\\\\14.140.167.188\\Vakilsearch\\VakilsearchSmokeTesting\\GRC_automation_data\\Upload_Files\\Signature.png";
			StringSelection stringSelection1 = new StringSelection(filePath1);
			Clipboard clipboard1 = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard1.setContents(stringSelection1, null);

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
				System.out.println("Second Document Uploaded");
				test.log(Status.PASS, "Second Document Uploaded", MediaEntityBuilder
						.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("Document Upload Fails" + e);
			test.log(Status.FAIL, "Document Upload Fails" + e,
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		}
	}

	public void replaceFile(WebDriver driver) throws InterruptedException {
		try {
			driver.navigate().refresh();
			Thread.sleep(3000);
			arrowIcon.click();
			viewCTA.click();
			replaceCTA.click();
			// Set the file path to the clip board [for Signature]
			String filePath1 = "\\\\14.140.167.188\\Vakilsearch\\VakilsearchSmokeTesting\\GRC_automation_data\\Upload_Files\\Female.jpg";
			StringSelection stringSelection1 = new StringSelection(filePath1);
			Clipboard clipboard1 = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard1.setContents(stringSelection1, null);

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
				System.out.println("Document replaced");
				test.log(Status.PASS, "Document replaced", MediaEntityBuilder
						.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			} catch (Exception e) {
				e.printStackTrace();
			}
			Thread.sleep(3000);
			viewCTA.click();
			closeIcon.click();
		} catch (Exception e) {
			System.out.println("Document not replaced " + e);
			test.log(Status.FAIL, "Document not replaced " + e,
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		}

	}

	public void deleteFile(WebDriver driver) throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		try {
			arrowIcon.click();
			deleteIcon.click();
			yesDeleteCTA.click();
			Thread.sleep(3000);	
			arrowIcon.click();
			deleteIcon.click();
			
			yesDeleteCTA.click();
			System.out.println("Deleted Documents");
			test.log(Status.PASS, "Deleted Documents",
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		} catch (Exception e) {
			System.out.println("Documents Not Deleted " + e);
			test.log(Status.FAIL, "Documents Not Deleted" + "\n" + e,
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		}
	}

	public void languageTranslate(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		try {
			languageDropdown.click();
			translateHindi.click();
			WebDriverWait wait = new WebDriverWait(driver, 50);
			WebElement hindiContentTranslate = wait.until(ExpectedConditions.elementToBeClickable(hindiContent));
			if (hindiContentTranslate.isDisplayed()) {
				System.out.println("Language Translate Functional");
				test.log(Status.PASS, "Language Translate Functional", MediaEntityBuilder
						.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
			} else {
				System.out.println("Language is not translated to Hindi");
			}
			Thread.sleep(4000);
			languageDropdown.click();
			translateEnglish.click();
			Thread.sleep(2000);

		} catch (Exception e) {
			System.out.println("Language Translate is not functional " + e);
			test.log(Status.FAIL, "Language Translate is not functional " + "\n" + e,
					MediaEntityBuilder.createScreenCaptureFromPath(pageObject.takeAndSaveScreenshot(driver)).build());
		}
	}
}
