package pom.UnifiedTara_realnumber_Tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.AddProduct_Page;
import pom.UnifiedTara.pages.POS_Order;
import pom.UnifiedTara.pages.base.BasePage;

public class OutOfStock_Test extends BaseTest {

	@Test
	public void Test1_OutOfStock() throws InterruptedException, IOException {
		test = rep.startTest("Out of stock test");
		test.log(LogStatus.INFO, "Starting Out of stock test ");
		Thread.sleep(4000);
		launchApp();
		Thread.sleep(7000);
//		OTPread_Page otppage=new OTPread_Page(aDriver, test);
//		otppage.OTPValidationMethod(TMConstants.RealMobileNumber);

		// Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

		AddProduct_Page addprod = new AddProduct_Page(aDriver, test);
		// sp.SwithUser("Merchant");
		addprod.NavigationTo_addProduct();
		addprod.AddProductfororderoutofstock("TestOutOfStock", "1000", "10");
		POS_Order po = new POS_Order(aDriver, test);
		po.SearchProduct("TestOutOfStock");
		// ord.orderthroughPos();
		Thread.sleep(11000);
		WebElement outStockproduct = aDriver
				.findElementByXPath("//android.widget.ImageView[contains(@content-desc,'TestOutOfStock')]");
		Thread.sleep(2000);
		String producttext = outStockproduct.getTagName();
		BasePage BP = new BasePage(aDriver, test);
		if (producttext.contains("Out of stock")) {
			BP.reportPass("Testpass:outofstock is displayed");
		} else {
			BP.reportFail("outofstock is not displayed");
		}

	}

}
