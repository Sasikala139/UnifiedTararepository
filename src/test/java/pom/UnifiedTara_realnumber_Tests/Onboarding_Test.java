package pom.UnifiedTara_realnumber_Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.StoreCreation_Page;
import pom.UnifiedTara.pages.add_paymentoption_Page;
import pom.UnifiedTara.util.TMConstants;

public class Onboarding_Test extends BaseTest {

	String testName = "addPayment";

	@Test
	public void Add_PaymentTest() throws InterruptedException, IOException {
		test = rep.startTest(testName);
		test.log(LogStatus.INFO, "Starting addPayment test ");
		launchApp();
		Thread.sleep(4000);
//		OTPread_Page otppage=new OTPread_Page(aDriver, test);
//	
//		otppage.OTPValidationMethod(TMConstants.RealMobileNumber);

		add_paymentoption_Page addpay = new add_paymentoption_Page(aDriver, test);
	//	 addpay.NavigatedTo_BankAccount();
		addpay.AddCommonBankAccount(TMConstants.CommonBankACNO, TMConstants.CommonBankACName);
		//Thread.sleep(5000);
		// Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
//         hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);		
// 	     Thread.sleep(4000);
		//addpay.navigateToSwitchuser();
		StoreCreation_Page sp = new StoreCreation_Page(aDriver, test);
		sp.SwithUser("Merchant");
		sp.create_store();
//    	hm.logout();

	}

}
