package Vs.DesktopGRC;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class slack extends pageObject {
	public WebDriver driver;
	SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
	String Date = dateFormat.format(new Date());

	public void slackMessageTest(WebDriver driver) throws AWTException, InterruptedException, IOException {
		ExtenScreenshot(driver);
		loginToSlack(driver);
		sendMessageInSlack(driver);

	}

	public void loginToSlack(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			driver.get("https://slack.com/intl/en-in");
			WebElement signInLink = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'Sign in')])[1]")));
			signInLink.click();
			WebElement signInWithGoogle = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//span[contains(text(),'Sign In With Google')]")));
			signInWithGoogle.click();
			// Add login steps here
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys("kavitha.jagatheeswaran@vakilsearch.com");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']"))).click();
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Kavitha@123");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]"))).click();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("(//div[@class='p-workspace_info__title' and contains(text(),'Vakilsearch')])[2]")))
					.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("Error in Slack login " + e);
		}
	}

	private void sendMessageInSlack(WebDriver driver) throws InterruptedException, AWTException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			Robot robot = new Robot();
			Thread.sleep(5000);
			Set<String> handles = driver.getWindowHandles();
			// Switch to the second tab
			for (String handle : handles) {
				driver.switchTo().window(handle);
			}

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			WebElement channelElement = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("(//span[contains(text(),'automation-testing-reports')])[1]/parent::span/parent::div")));
			channelElement.click();
			WebElement messageInput = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ql-placeholder']")));
			messageInput.sendKeys("GRC Regression Testing Report for upload document");
			WebElement uploadButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//button[@class='c-button-unstyled c-icon_button c-icon_button--size_small c-wysiwyg_container__button c-wysiwyg_container__button--shortcuts p-shortcuts_menu_trigger_button--composer_ia c-icon_button--default']")));
			uploadButton1.click();

			WebElement uploadButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//span[contains(text(),'Upload from your computer')]")));
			uploadButton.click();
			Thread.sleep(6000);
			// Add HTML file path or make it configurable
			String filePath = "\\\\14.140.167.188\\Vakilsearch\\VakilsearchSmokeTesting\\GRC_automation_data\\Output\\Report\\Extentreport "
					+ Date + ".html";
			Thread.sleep(1000);
			StringSelection stringSelection = new StringSelection(filePath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);

			robot.delay(1000); // Adjust delay if needed

			// Use robot to perform paste action (Ctrl + V)
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			robot.delay(1000); // Adjust delay if needed

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(4000); // Adjust sleep duration based on your scenario

			// Add IMG file path or make it configurable
			WebElement uploadButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//button[@class='c-button-unstyled c-icon_button c-icon_button--size_small c-wysiwyg_container__button c-wysiwyg_container__button--shortcuts p-shortcuts_menu_trigger_button--composer_ia c-icon_button--default']")));
			uploadButton2.click();

			WebElement uploadButton3 = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//span[contains(text(),'Upload from your computer')]")));
			uploadButton3.click();
			String filePath1 = "\\\\14.140.167.188\\Vakilsearch\\VakilsearchSmokeTesting\\GRC_automation_data\\Output\\Screenshot\\ExtentreportScreenshot " + Date + ".png";
			Thread.sleep(1000);
			StringSelection stringSelection1 = new StringSelection(filePath1);
			Clipboard clipboard1 = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard1.setContents(stringSelection1, null);

			robot.delay(1000); // Adjust delay if needed

			// Use robot to perform paste action (Ctrl + V)
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			robot.delay(1000); // Adjust delay if needed

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(4000); // Adjust sleep duration based on your scenario
			Thread.sleep(4000);
			WebElement sendButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Send now']")));
			sendButton.click();
		} catch (Exception e) {
			System.out.println("Error in sending message" + e);
		}
	}

	public void ExtenScreenshot(WebDriver driver) throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String filename = "\\\\14.140.167.188\\Vakilsearch\\VakilsearchSmokeTesting\\GRC_automation_data\\Output\\Report\\Extentreport "
				+ Date + ".html";
		driver.get(filename);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-bar-chart']"))).click();
		Thread.sleep(4000);
		TakesScreenshot screenshot1 = ((TakesScreenshot) driver);
		File srcFile1 = screenshot1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile1, new File(
				"\\\\14.140.167.188\\Vakilsearch\\VakilsearchSmokeTesting\\GRC_automation_data\\Output\\Screenshot\\ExtentreportScreenshot "
						+ Date + ".png"));

	}

}
