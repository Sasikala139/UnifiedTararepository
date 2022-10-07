package pom.UnifiedTara.pages.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pom.UnifiedTara.util.TMConstants;

@SuppressWarnings("deprecation")
public class BasePage extends TMConstants {
	public ExtentTest test;
	public AndroidDriver<AndroidElement> aDriver;

//	//int level=0;
//
	public BasePage(AndroidDriver<AndroidElement> aDriver, ExtentTest test) {
		// PageFactory.initElements(new AppiumFieldDecorator(aDriver), this);
		PageFactory.initElements(aDriver, this);

		this.aDriver = aDriver;
		this.test = test;
	}

	public void click(WebElement Element) {
		Element.click();
	}

	public void typeText(WebElement element, String value) {
		element.click();
		element.clear();
		element.sendKeys(value);
	}

	public void selectValuefromDropDown(WebElement element, int value) {
		Select sel = new Select(element);
		sel.selectByIndex(value);
	}

	public boolean isElementDisplayed(WebElement element) {

		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public String captureToastmessage() {

		WebDriverWait wait = new WebDriverWait(aDriver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
		String toastmessage = aDriver.findElementByXPath("/hierarchy/android.widget.Toast").getText();
		System.out.println("toastmessage=" + toastmessage);
		return toastmessage;

	}

	public void runJavaScript(String command) {
		JavascriptExecutor js = (JavascriptExecutor) aDriver;
		js.executeScript(command);
	}

	public void uploadfile(WebElement element, String path) {
		element.sendKeys(path);
	}

	public void OnlywaitForElement(WebElement element, int maxTimeout) {
		WebDriverWait wait = new WebDriverWait(aDriver, maxTimeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitForElementforClick(WebElement element, int maxTimeout) {
		WebDriverWait wait = new WebDriverWait(aDriver, maxTimeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void waitForElementforType(WebElement element, int maxTimeout, String value) {
		WebDriverWait wait = new WebDriverWait(aDriver, maxTimeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		element.clear();
		element.sendKeys(value);
	}

	public boolean isElementPresent(String locator) {

		// test.log(LogStatus.INFO, "Finding presence of element "+locator);
		int s = aDriver.findElements(By.xpath(locator)).size();
		if (s == 0)

			return false;

		else
			return true;
	}

	public boolean verifyText(String locator, String expectedText) {
		return false;
	}

	/*****************************
	 * Reporting functions
	 *****************************************/

	public void reportPass(String passMsg) {
		test.log(LogStatus.PASS, passMsg);
		takeScreenshot();

	}

	public void reportFail(String failureMsg) {
		test.log(LogStatus.FAIL, failureMsg);
		takeScreenshot();

		// Assert.fail(failureMsg);
	}

	// Screen shot
	public void takeScreenshot() {
		// decide the file name
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String path = TMConstants.SCREENSHOT_PATH + screenshotFile;
		// take screenshot
		File scrFile = ((TakesScreenshot) aDriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// add screenshot to report
		test.log(LogStatus.INFO, "Snapshot below: (" + screenshotFile + ")" + test.addScreenCapture(path));
	}

}
