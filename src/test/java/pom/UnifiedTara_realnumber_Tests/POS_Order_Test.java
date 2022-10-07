package pom.UnifiedTara_realnumber_Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.AddProduct_Page;
import pom.UnifiedTara.pages.OTPread_Page;
import pom.UnifiedTara.pages.POS_Order;
import pom.UnifiedTara.util.TMConstants;

public class POS_Order_Test extends BaseTest {

	String testName = "posOrdering";

	@Test(priority = 1)

	public void POS_Order_Cash() throws InterruptedException, IOException {
		test = rep.startTest(testName);
		test.log(LogStatus.INFO, "Starting the test ");

		launchApp();
		Thread.sleep(4000);
		OTPread_Page otppage = new OTPread_Page(aDriver, test);
		otppage.OTPValidationMethod(TMConstants.RealMobileNumber);

		// Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

		// adding product to create order.
		AddProduct_Page addprod = new AddProduct_Page(aDriver, test);
		// sp.SwithUser("Merchant");
		addprod.NavigationTo_addProduct();
		addprod.AddProductfororder("product1", "1000", "10");

		Thread.sleep(5000);
		aDriver.navigate().back();
		POS_Order pos = new POS_Order(aDriver, test);

		Thread.sleep(4000);
		pos.SearchProduct("product1");
		pos.OrderThroughPos_cash();

	}

	@Test(priority = 2)
	public void POS_Order_Link() throws InterruptedException, IOException {

		test = rep.startTest("POS order with generated Link ");
		test.log(LogStatus.INFO, "Starting POS order with generated Link test ");
		POS_Order pos = new POS_Order(aDriver, test);

		pos.SearchProduct("product1");
		pos.OrderThroughPos_Link();

	}

}
