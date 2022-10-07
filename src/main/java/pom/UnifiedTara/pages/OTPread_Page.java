package pom.UnifiedTara.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pom.UnifiedTara.pages.base.BasePage;
import pom.UnifiedTara.util.TMConstants;

public class OTPread_Page extends BasePage {

	@FindBy(xpath = "//android.widget.Button[@index='2']")
	public WebElement Country_Code;

	@FindBy(xpath = "//android.view.View[@index='1']")
	public WebElement Country_Code91;

	@FindBy(xpath = "//android.view.View[@index='0']")
	public WebElement Country_Code62;

	@FindBy(xpath = "//android.widget.EditText[@index='3']")
	public WebElement MobileNumber_Text;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Send SMS\"]")
	public WebElement Send_SMS_Button;

	@FindBy(xpath = "//android.widget.EditText[@index='4']")
	public WebElement OTP_Text_1;

	@FindBy(xpath = "//android.widget.EditText[@index='5']")
	public WebElement OTP_Text_2;

	@FindBy(xpath = "//android.widget.EditText[@index='6']")
	public WebElement OTP_Text_3;

	@FindBy(xpath = "//android.widget.EditText[@index='7']")
	public WebElement OTP_Text_4;

	@FindBy(xpath = "//android.widget.EditText[@index='8']")
	public WebElement OTP_Text_5;

	@FindBy(xpath = "//android.widget.EditText[@index='9']")
	public WebElement OTP_Text_6;

	@FindBy(xpath = "//android.view.View[@index='12']")
	public WebElement Validate_Button;

	@FindBy(xpath = "//android.widget.Button[@index='0']")
	public WebElement mngcalls_allow_button;

	// Display Language change elements

	@FindBy(xpath = "//android.view.View[@content-desc=\"We'll send you a one time password on this mobile number\"]")
	public WebElement English_InDisplay;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Kami akan mengirimkan Anda kata sandi satu kali di nomor ponsel ini\"]")
	public WebElement Indonesia_InDisplay;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Change Language\"]")
	public WebElement ChangeLanguage;

	@FindBy(xpath = "//android.view.View[@index='1']")
	public WebElement English;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Indonesian\"]")
	public WebElement Indonesian;

	@FindBy(xpath = "//android.widget.ImageView[@index='18']")
	public WebElement Logout;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Log Out\"]")
	public WebElement Logout1;

	@FindBy(xpath = "//android.widget.Button[@index='0']")
	public WebElement mngSMS_allow_button;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Profile\"]")
	public WebElement ProfileMenu;

	@FindBy(id = "(//android.view.View[@index='0'])[9]")
	public WebElement StoreSelect;

	// WebElement notification =
	// aDriver.findElementByXPath("//android.view.View[contains(@content-desc,'Clear')]");

	public OTPread_Page(AndroidDriver<AndroidElement> aDriver, ExtentTest test) {
		super(aDriver, test);

	}

	public void OTPread_LoginTest(String MobileNumber) throws InterruptedException {

		if (!isElementDisplayed(English_InDisplay)) {
			test.log(LogStatus.INFO, "Changing display language");
			aDriver.findElementByXPath("//android.view.View[@content-desc=\"Change Language\"]").click();
			aDriver.findElementByXPath("//android.view.View[@content-desc=\"English\"]").click();
			test.log(LogStatus.INFO, "Changed display language to english");
			Thread.sleep(5000);

		}

		aDriver.openNotifications();
		System.out.println("opened notification");
		try {
			WebElement notification = aDriver
					.findElementByXPath("//android.view.View[contains(@content-desc,'Clear')]");

			if (notification.isDisplayed()) {
				notification.click();
				System.out.println("Cleared notification");
			}

			else
				aDriver.navigate().back();

		} catch (Exception e) {
			System.out.println(e);
			aDriver.navigate().back();
		}
		waitForElementforClick(Country_Code, 10);
		waitForElementforClick(Country_Code91, 20);
		waitForElementforClick(MobileNumber_Text, 20);
		typeText(MobileNumber_Text, MobileNumber);
		String mngcalls_locator = "//android.widget.Button[@index='0']";
		if (isElementPresent(mngcalls_locator)) {
			System.out.println("in if block");
			waitForElementforClick(mngcalls_allow_button, 20);
			waitForElementforClick(mngSMS_allow_button, 20);
			System.out.println("clicked on calls allow");
		}

		click(Send_SMS_Button);

		test.log(LogStatus.INFO, "Send SMS");
		Thread.sleep(6000);
		if (isElementDisplayed(OTP_Text_1)) {
			test.log(LogStatus.INFO, "Navigated to OTP Page");
		} else {
			reportFail("Not Navigated to OTP Page");
			Assert.assertEquals(isElementDisplayed(OTP_Text_1), true, "Navigated to OTP Page");
		}

		aDriver.openNotifications();

		WebElement messagele = aDriver.findElementById("android:id/message_text");
		OnlywaitForElement(messagele, 20);
		// String otp =
		// aDriver.findElementByXPath("//*[contains(@text,'is')]").getText().split("code:"
		// )[0];
		String otp = messagele.getText();
		aDriver.navigate().back();
		System.out.println("the otp is1 " + otp);
		String code = otp.substring(17, 22);
		System.out.println("the otp is2 " + code);

		typeText(OTP_Text_1, otp.substring(17));
		typeText(OTP_Text_2, otp.substring(18));

		typeText(OTP_Text_3, otp.substring(19));

		typeText(OTP_Text_4, otp.substring(20));

		typeText(OTP_Text_5, otp.substring(21));

		typeText(OTP_Text_6, otp.substring(17));
		test.log(LogStatus.INFO, "Entered Wrong OTP");

		click(Validate_Button);
		String toastmessage = captureToastmessage();
		if (!toastmessage.toLowerCase().contains("valid OTP".toLowerCase())) {
			reportPass(toastmessage);
			takeScreenshot();
		} else {
			test.log(LogStatus.INFO, toastmessage);
			typeText(OTP_Text_1, otp.substring(17));
			typeText(OTP_Text_2, otp.substring(18));

			typeText(OTP_Text_3, otp.substring(19));

			typeText(OTP_Text_4, otp.substring(20));

			typeText(OTP_Text_5, otp.substring(21));

			typeText(OTP_Text_6, otp.substring(22));
			test.log(LogStatus.INFO, "Entered Valid OTP");
			click(Validate_Button);
			if (isElementPresent(TMConstants.ProceedToAddBank)) {
				reportPass("logged in successfully");
			} else {
				reportFail("logged Failed");
			}
		}

	}

	public void OTPValidationMethod(String MobileNumber) throws InterruptedException {

		if (!isElementDisplayed(English_InDisplay)) {
			test.log(LogStatus.INFO, "Changing display language");
			aDriver.findElementByXPath("//android.view.View[@content-desc=\"Change Language\"]").click();
			aDriver.findElementByXPath("//android.view.View[@content-desc=\"English\"]").click();
			test.log(LogStatus.INFO, "Changed display language to english");
			Thread.sleep(5000);
		}

		aDriver.openNotifications();
		System.out.println("opened notification");

		Thread.sleep(1000);
		WebElement notification = aDriver.findElementByXPath("//android.view.View[contains(@content-desc,'Clear')]");

		if (notification.isDisplayed()) {
			notification.click();

		} else
			aDriver.navigate().back();

		waitForElementforClick(Country_Code, 10);
		waitForElementforClick(Country_Code91, 20);
		waitForElementforClick(MobileNumber_Text, 20);
		typeText(MobileNumber_Text, MobileNumber);
		Thread.sleep(2000);
		//String mngcalls_locator = "//android.widget.Button[@index='0']";
//			if(isElementPresent(mngcalls_locator))
//			{	
//			   System.out.println("in if block");
//			   waitForElementforClick(mngcalls_allow_button, 20);
//			   waitForElementforClick(mngSMS_allow_button, 20);
//     	  	   System.out.println("clicked on calls allow"); 
//			}
		click(Send_SMS_Button);
		Thread.sleep(2000);
		if (isElementDisplayed(OTP_Text_1)) {
			test.log(LogStatus.INFO, "Navigated to OTP Page");
		} else {
			reportFail("Not Navigated to OTP Page");
			Assert.assertEquals(isElementDisplayed(OTP_Text_1), true, "Navigated to OTP Page");
		}

		aDriver.openNotifications();
		Thread.sleep(3000);
		WebElement messagele = aDriver.findElementById("android:id/message_text");

		OnlywaitForElement(messagele, 30);

		// Dimension msgsize = messagele.getSize();

		// System.out.println(msgsize);

		// WebElement
		// messagele1=aDriver.findElementById("(android:id/message_text)["+msgsize-1"]");

		// String otp =
		// aDriver.findElementByXPath("//*[contains(@text,'is')]").getText().split("code:"
		// )[0];
		String otp = messagele.getText();
		// aDriver.navigate().back();
		WebElement notification1 = aDriver.findElementByXPath("//android.view.View[contains(@content-desc,'Clear')]");
		notification1.click();
		System.out.println("the otp is1 " + otp);
		String code = otp.substring(17, 22);
		System.out.println("the otp is2 " + code);

		typeText(OTP_Text_1, otp.substring(17));
		typeText(OTP_Text_2, otp.substring(18));

		typeText(OTP_Text_3, otp.substring(19));

		typeText(OTP_Text_4, otp.substring(20));

		typeText(OTP_Text_5, otp.substring(21));

		typeText(OTP_Text_6, otp.substring(22));

		click(Validate_Button);
		Thread.sleep(2000);

	}
}
