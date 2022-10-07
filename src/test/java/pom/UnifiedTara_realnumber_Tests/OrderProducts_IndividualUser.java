package pom.UnifiedTara_realnumber_Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.OTPread_Page;
import pom.UnifiedTara.pages.OrderProducts_IndividualUser_Page;
import pom.UnifiedTara.util.TMConstants;

public class OrderProducts_IndividualUser extends BaseTest {

	@Test
	public void OrderProducts_IndividualUsr() throws InterruptedException, IOException {
		test = rep.startTest("order_individual");
		test.log(LogStatus.INFO, "Starting the order_individual test ");
		launchApp();
		Thread.sleep(4000);
		OTPread_Page otppage = new OTPread_Page(aDriver, test);
		otppage.OTPValidationMethod(TMConstants.RealMobileNumber);

		// Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
//		add_paymentoption_Page addpay=new add_paymentoption_Page(aDriver, test);
//		addpay.navigatetomerchantiflareadyuser();

		OrderProducts_IndividualUser_Page OrdProd = new OrderProducts_IndividualUser_Page(aDriver, test);
		OrdProd.NavigationTo_IndividualUser();
		OrdProd.OrderProducts_IndividualUsr_Page();

		// addpay.add_creditcard();
		// sp.SwithUser("Merchant");

	}
}
