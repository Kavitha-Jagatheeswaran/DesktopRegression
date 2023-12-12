//package Vs.DesktopGRC;
//
//import java.awt.AWTException;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class App {
//	public static WebDriver driver;
//
//	@BeforeTest
//	public void openBrowser() throws InterruptedException, AWTException {
//
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//
//	}
//
//	@Test
//	public void login() {
//		String excelFilePath = "C:\\Users\\Vakilsearch\\eclipse-workspace\\DesktopGRC\\input\\testInput.xlsx";
//		FileInputStream inputStream = null;
//		Workbook workbook = null;
//		try {
//			inputStream = new FileInputStream(excelFilePath);
//			workbook = new XSSFWorkbook(inputStream);
//			Sheet sheet = workbook.getSheetAt(0);
//			String[] cellValues = new String[3];
//			for (int i = 0; i < 3; i++) {
//				Row row = sheet.getRow(i);
//				if (row != null) {
//					Cell cell = row.getCell(0); // Column A (0-based index)
//					if (cell.getCellType() == CellType.STRING) {
//                        cellValues[i] = cell.getStringCellValue();
//                    } else if (cell.getCellType() == CellType.NUMERIC) {
//                        // Handle numeric cells (e.g., format as a string)
//                        cellValues[i] = String.valueOf(cell.getNumericCellValue());
//                    } else {
//                        cellValues[i] = ""; // Other cell types (blank or formula)
//                    }
//				}
//			}
//			for (int i = 0; i < 3; i++) {
//				driver.get(cellValues[i]);
//				System.out.println("Cell"+(i + 1) +": "+ cellValues[i]);
//				if (i == 2) {
//					WebElement userEmail = driver
//							.findElement(By.xpath("//input[@placeholder='Mobile number or Email']"));
//					userEmail.sendKeys(cellValues[i]);
//				}
//				if (i == 3) {
//					driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
//					WebDriverWait wait = new WebDriverWait(driver, 20); // Wait for a maximum of 20 seconds
//					WebElement userPassword = wait
//							.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']")));
//					userPassword.click();
//					userPassword.sendKeys(cellValues[i]);
//					driver.findElement(By.xpath("(//button[contains(text(),'Login')])[1]")).click();
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (workbook != null) {
//					workbook.close();
//				}
//				if (inputStream != null) {
//					inputStream.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//}
