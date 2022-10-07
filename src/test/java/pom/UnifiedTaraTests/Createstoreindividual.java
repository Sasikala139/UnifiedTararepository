package pom.UnifiedTaraTests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.HomePage;
import pom.UnifiedTara.pages.OTPread_Page;
import pom.UnifiedTara.pages.StoreCreation_Page;
import pom.UnifiedTara.pages.add_paymentoption_Page;
import pom.UnifiedTara.util.TMConstants;

public class Createstoreindividual extends BaseTest {

	@Test
	public void StoreCreation() throws InterruptedException, IOException {
		test = rep.startTest("individualuser");
		test.log(LogStatus.INFO, "Starting the store creation test ");
		launchApp();
		OTPread_Page otppage = new OTPread_Page(aDriver, test);

		if (!otppage.isElementPresent(TMConstants.Mobile_Text1)) {
			otppage.reportFail("login page is not not loaded");
		}
		otppage.OTPValidationMethod(TMConstants.RealIndivMobileNumber);
		Thread.sleep(10000);
		// hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);
		// Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		add_paymentoption_Page addpay = new add_paymentoption_Page(aDriver, test);
		addpay.navigatetomerchantiflareadyuser();
		StoreCreation_Page storecreate = new StoreCreation_Page(aDriver, test);
		// storecreate.SwithUser("IndividualUser");
		storecreate.create_store();
		HomePage hm = new HomePage(aDriver, test);
		hm.logout();
		System.out.println("executed sucessfully");

	}

}
