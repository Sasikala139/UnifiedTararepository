package pom.UnifiedTara.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pom.UnifiedTara.pages.base.BasePage;

public class SendMoney_Page extends BasePage {

	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Send Money\"]")
	public WebElement SendMoney;

	@FindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Pay Now\"])[1]")
	public WebElement PayNow;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Payment Options \"]")
	public WebElement PaymentOptions;

	public SendMoney_Page(AndroidDriver<AndroidElement> aDriver, ExtentTest test) {
		super(aDriver, test);

	}

	public void SendMoney() throws InterruptedException {

		waitForElementforClick(SendMoney, 20);
		waitForElementforClick(PayNow, 20);

		Thread.sleep(3000);
		String titleOfPaymentPage = aDriver.getTitle();
		System.out.println(titleOfPaymentPage);

		if (isElementDisplayed(PaymentOptions))

			reportPass("Navigated to payment Options page");

		else

			reportPass("Not Navigated to payment Options page");

	}

}
