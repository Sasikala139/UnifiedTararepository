package pom.UnifiedTara_realnumber_Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.AddProduct_Page;
import pom.UnifiedTara.pages.OTPread_Page;
import pom.UnifiedTara.pages.StoreCreation_Page;
import pom.UnifiedTara.pages.add_paymentoption_Page;
import pom.UnifiedTara.util.TMConstants;

public class SwitchToUser extends BaseTest {

	@Test
	public void Test1_switchtouser() throws InterruptedException, IOException {
		test = rep.startTest("AddProductFromIndividualAccount");
		test.log(LogStatus.INFO, "Starting the add product test ");
		launchApp();
		Thread.sleep(4000);
		OTPread_Page otppage = new OTPread_Page(aDriver, test);
		otppage.OTPValidationMethod(TMConstants.RealMobileNumber);

		AddProduct_Page addprod = new AddProduct_Page(aDriver, test);
		add_paymentoption_Page addpay = new add_paymentoption_Page(aDriver, test);

		// addpay.add_creditcard();
		StoreCreation_Page sp = new StoreCreation_Page(aDriver, test);
		sp.SwithUser("IndividualUser");
		addpay.navigatetomerchantiflareadyuser();

		addprod.NavigationTo_addProduct();

		addprod.AddProduct();
	}

}
