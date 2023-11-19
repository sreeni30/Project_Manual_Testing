package org.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	// 1
	public static void launchChrome() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	// 2
	public static void winMax() {
		driver.manage().window().maximize();

	}

	// 3
	public static void openUrl(String siteName) {
		driver.get(siteName);

	}

	// 4
	public static void printTitle() {
		String title = driver.getTitle();
		System.out.println(title);

	}

	// 5
	public static void printCurrentUrl() {
		String current = driver.getCurrentUrl();
		System.out.println(current);

	}

	// 6
	public static void fill(WebElement ele, String value) {
		ele.sendKeys(value);

	}

	// 7
	public static void btnClick(WebElement ele) {
		ele.click();

	}

	// 8
	public static void shutTab() {
		driver.close();

	}

	// 9
	public static void printText(WebElement ele) {
		System.out.println(ele.getText());

	}

	// 10
	public static void printAttribute(WebElement ele) {
		System.out.println(ele.getAttribute("value"));

	}

	// 11
	public static void submit(WebElement ele) {
		ele.submit();

	}

	// 12
	public static void waits() throws InterruptedException {
		Thread.sleep(3000);

	}

	// 13
	public static void hover(WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).click().build().perform();

	}

	// 14
	public static void doublecl(WebElement ele) {
		Actions a = new Actions(driver);
		a.doubleClick(ele).build().perform();
	}

	// 15
	public static void rightClick(WebElement ele) {
		Actions a = new Actions(driver);
		a.contextClick(ele).perform();
	}

	// 16
	public static void enter(WebElement ele) {
		Actions a = new Actions(driver);
		a.click(ele).perform();
	}

	// 17
	public static void fillValue(WebElement ele, String value) {
		Actions a = new Actions(driver);
		a.sendKeys(ele, value).build().perform();

	}

	// 18
	public static void pressShiftKey(WebElement ele) {
		Actions a = new Actions(driver);
		a.keyDown(ele, Keys.SHIFT).perform();
	}

	// 19
	public static void releaseShiftKey(WebElement ele) {
		Actions a = new Actions(driver);
		a.keyUp(Keys.SHIFT).perform();
	}

	// 20
	public static void toCopy() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}

	// 21
	public static void toPaste() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

	// 22
	public static void insert() throws AWTException {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_INSERT);
	}

	// 23
	public static void toenter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	// 24
	public static void toTab() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}

	// 25
	public static void toSelectAll() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
	}

	// 26
	public static void downArrow() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	// 27
	public static void upArrow() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_KP_UP);
		r.keyRelease(KeyEvent.VK_KP_UP);
	}

	// 28
	public static void toUndo() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_Z);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_Z);
	}

	// 29
	public static void toSave() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_S);
	}

	// 30
	public static void toDelete() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_DELETE);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_DELETE);
	}

	// 31
	public static void toCut() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);
	}

	// 32
	public static void toSpace() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_SPACE);
		r.keyRelease(KeyEvent.VK_SPACE);
	}

	// 33
	public void toBackSpace() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
	}

	// 34
	public static void capsOn() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CAPS_LOCK);
	}

	// 35
	public static void capsOff() throws AWTException {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_CAPS_LOCK);
	}

	// 36
	public static void clearOff() throws AWTException {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_CLEAR);
	}

	// 37
	public static void acceptAlert(WebElement ele) {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	// 38
	public static void dismissAlert(WebElement ele) {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	// 39
	public static void fillAlert(WebElement ele, String value) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(value);
	}

	// 40
	public static void printAlert(WebElement ele) {
		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
	}

	// 41
	public static void intFrame(int index) {
		driver.switchTo().frame(index);
	}

	// 42
	public static void stringFrame(String nameorid) {
		driver.switchTo().frame(nameorid);
	}

	// 43
	public static void webFrame(WebElement ele) {
		driver.switchTo().frame(ele);
	}

	// 44
	public static void defaultframe() {
		driver.switchTo().defaultContent();
	}

	// 45
	public static void refreshPage() {
		driver.navigate().refresh();
	}

	// 46
	public static void moveBackward() {
		driver.navigate().back();
	}

	// 47
	public static void moveForward() {
		driver.navigate().forward();
	}

	// 48
	public static void display(WebElement ele) {
		System.out.println(ele.isDisplayed());
	}

	// 49
	public static void takeScreen(WebElement ele, String value) throws IOException {
		ele.sendKeys(value);
		TakesScreenshot tk = (TakesScreenshot) driver;

		File src = tk.getScreenshotAs(OutputType.FILE);

		File dsc = new File("D:\\Mathivathani\\Testing\\JavaLearning\\SeleniumDay7\\Screenshot\\test14.png");

		FileUtils.copyFile(src, dsc);
	}

	// 50
	public static void scrollDown(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", ele);
	}

	// 51
	public static void scrollUp(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}

	// 52
	public static void filljs(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', 'Clutch plate')", ele);
	}

	// 53
	public static void clickjs(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);
	}

	// 54
	public static void enabled(WebElement ele) {
		System.out.println(ele.isEnabled());
	}

	// 55
	public static void selected(WebElement ele) {
		System.out.println(ele.isSelected());
	}

	// 56
	public static void valueselect(WebElement ele) {
		Select s = new Select(ele);
		s.selectByValue("DZA");
	}

	// 57
	public static void visibleSelect(WebElement ele) {
		Select s = new Select(ele);
		s.selectByVisibleText("Algeria");
	}

	// 58
	public static void indexSelect(WebElement ele) {
		Select s = new Select(ele);
		s.selectByIndex(4);
	}

	// 59
	public static void multipleSelect(WebElement ele) {
		Select s = new Select(ele);
		s.selectByIndex(4);
		boolean multi = s.isMultiple();
		System.out.println(multi);
	}

	// 60
	public static void getAllvalue(WebElement ele) {
		Select s = new Select(ele);
		List<WebElement> li = s.getOptions();
		for (int i = 0; i < li.size(); i++) {
			WebElement element = li.get(i);
			String text = element.getText();
			System.out.println(text);
		}
	}

	// 61
	public static void firstSelected(WebElement ele) {
		Select s = new Select(ele);
		WebElement element = s.getFirstSelectedOption();
		System.out.println(element.getText());
	}

	// 62
	public static void valuedeselect(WebElement ele) {
		Select s = new Select(ele);
		s.selectByValue("grape");
		s.selectByIndex(1);
		s.selectByVisibleText("Orange");
		s.deselectByValue("grape");

	}

	// 63
	public static void allSelectedoption(WebElement ele) {
		Select s = new Select(ele);
		s.selectByValue("grape");
		s.selectByIndex(1);
		s.selectByVisibleText("Orange");
		List<WebElement> li = s.getAllSelectedOptions();
		for (WebElement x : li) {
			System.out.println(x.getText());
		}
	}

	// 64
	public static void indexdeselect(WebElement ele) {
		Select s = new Select(ele);
		s.selectByValue("grape");
		s.selectByIndex(1);
		s.selectByVisibleText("Orange");
		s.deselectByIndex(1);
	}

	// 65
	public static void visibledeselect(WebElement ele) {
		Select s = new Select(ele);
		s.selectByValue("grape");
		s.selectByIndex(1);
		s.selectByVisibleText("Orange");
		s.deselectByVisibleText("Orange");
	}

	// 66
	public static void alldeselect(WebElement ele) {
		Select s = new Select(ele);
		s.selectByValue("grape");
		s.selectByIndex(1);
		s.selectByVisibleText("Orange");
		s.deselectAll();
	}

	// 67
	public static void toNavigate(String siteName) {
		driver.navigate().to(siteName);
	}

	// 68
	public static void handleWins() {
		String handle = driver.getWindowHandle();
		Set<String> allwindId = driver.getWindowHandles();
		for (String eachId : allwindId) {

			if (!eachId.equals(handle)) {
				driver.switchTo().window(eachId);
			}
		}
	}

	// 69
	public static void handleWin() {
		String handle = driver.getWindowHandle();
	}

	// 70
	public static void waitElementClickable(By locator, int timeoutInSeconds) {
		WebDriverWait w = new WebDriverWait(driver, timeoutInSeconds);
		w.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// 71
	public static void waitElementVisible(By locator, int timeoutInSeconds) {
		WebDriverWait w = new WebDriverWait(driver, timeoutInSeconds);
		w.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// 72
	public static void fluentWait(By locator, int timeoutInSeconds, int pollingIntervalInSeconds) {
		FluentWait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofSeconds(pollingIntervalInSeconds)).ignoring(Throwable.class);
		w.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// 73
	public static void closeBrowser() {
		driver.quit();
	}

	// 74
	public static void webTable(WebElement ele) {
		List<WebElement> datas = driver.findElements(By.tagName("td"));
		for (int i = 0; i < datas.size(); i++) {
			WebElement eachData = datas.get(i);
			System.out.println(eachData.getText());
		}
	}

	// 75
	public static void clean(WebElement ele, String value) {
		ele.clear();
	}

	public static String getData(int rowNumber, int cellNumber) throws IOException {
		File f = new File(
				"D:\\Mathivathani\\Testing\\JavaLearning\\Oct3FrameWork\\target\\TestData\\FrameWork-CodeCademy.xlsx");

		FileInputStream fin = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fin);

		Sheet s = w.getSheet("Login");
		Row r = s.getRow(rowNumber);
		Cell c = r.getCell(cellNumber);
		int cellType = c.getCellType();

		String value = "";
		if (cellType == 1) {
			value = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date d = c.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd,MMM,yyyy");
			value = sim.format(d);
		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			value = String.valueOf(l);
		}
		return value;
	}
}
