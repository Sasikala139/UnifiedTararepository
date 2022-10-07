package pom.UnifiedTara_realnumber_Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.OTPread_Page;
import pom.UnifiedTara.pages.StoreCreation_Page;
import pom.UnifiedTara.pages.add_paymentoption_Page;
import pom.UnifiedTara.util.TMConstants;

public class Store_creation extends BaseTest {

	String testName = "StoreCreation";

	@Test
	public void StoreCreation() throws InterruptedException, IOException {
		test = rep.startTest(testName);
		test.log(LogStatus.INFO, "Starting the store creation test ");
		launchApp();
		Thread.sleep(4000);
		OTPread_Page otppage = new OTPread_Page(aDriver, test);
		otppage.OTPValidationMethod(TMConstants.RealMobileNumber);
		// Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		add_paymentoption_Page addpay = new add_paymentoption_Page(aDriver, test);
		addpay.navigateToSwitchuser();
		Thread.sleep(3000);
		StoreCreation_Page storecreate = new StoreCreation_Page(aDriver, test);
		storecreate.SwithUser("Merchant");
		storecreate.create_store();
		// hm.logout();
		System.out.println("executed sucessfully");

	}

}
