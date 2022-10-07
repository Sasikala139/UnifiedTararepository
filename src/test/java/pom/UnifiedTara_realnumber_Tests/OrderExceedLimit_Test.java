package pom.UnifiedTara_realnumber_Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.AddProduct_Page;
import pom.UnifiedTara.pages.POS_Order;

public class OrderExceedLimit_Test extends BaseTest {

	@Test
	public void ordexceedLimit() throws InterruptedException, IOException {
		test = rep.startTest("Exceed limit test");
		test.log(LogStatus.INFO, "Starting Exceed limit test ");
		System.out.println("Starting Exceed limit test ");
		launchApp();
		Thread.sleep(4000);
//	OTPread_Page otppage=new OTPread_Page(aDriver, test);
//	otppage.OTPValidationMethod(TMConstants.RealMobileNumber);
		// Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		AddProduct_Page addprod = new AddProduct_Page(aDriver, test);
		// sp.SwithUser("Merchant");
		addprod.NavigationTo_addProduct();
		addprod.AddProductforexceedlimit("pdcexceedlimit", "1000", "1000", "1");
		POS_Order po = new POS_Order(aDriver, test);
		po.SearchProduct("pdcexceedlimit");
		po.OrderThroughPosexceedlimit();
		System.out.println("Exeed limit test started ended successfully  ");

	}

}