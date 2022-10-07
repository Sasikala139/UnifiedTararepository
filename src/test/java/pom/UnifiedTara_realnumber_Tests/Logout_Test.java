package pom.UnifiedTara_realnumber_Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.HomePage;
import pom.UnifiedTara.pages.OTPread_Page;
import pom.UnifiedTara.util.TMConstants;

public class Logout_Test extends BaseTest {

	@Test
	public void Test1_Logout_as_seller() throws InterruptedException, IOException {
		test = rep.startTest("Logout test");
		test.log(LogStatus.INFO, "Starting the Logout test ");
		System.out.println("Starting Logout test ");

		launchApp();
		Thread.sleep(4000);
		OTPread_Page otppage = new OTPread_Page(aDriver, test);
		otppage.OTPValidationMethod(TMConstants.RealMobileNumber);
		HomePage hm = new HomePage(aDriver, test);
		hm.logout();

	}

//	@Test
//	public void Test2_Logout_as_individualuser() throws InterruptedException, IOException {
//		test = rep.startTest("Logout test");
//		test.log(LogStatus.INFO, "Starting the Logout test ");
//		System.out.println("Starting Logout test ");
//
//		launchApp();
//		Thread.sleep(4000);
//		OTPread_Page otppage=new OTPread_Page(aDriver, test);
//		otppage.OTPValidationMethod(TMConstants.RealMobileNumber);
//		HomePage hm=new HomePage(aDriver, test);
//		hm.logout();
//	
//}

}
