package pom.UnifiedTara_realnumber_Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.OTPread_Page;
import pom.UnifiedTara.util.TMConstants;

public class Login_Test extends BaseTest {

	String testName = "LoginTest";

	@Test
	public void logintest() throws InterruptedException, IOException {
		test = rep.startTest(testName);
		test.log(LogStatus.INFO, "Starting the test ");
		System.out.println("Starting Login test");
		launchApp();

		OTPread_Page otppage = new OTPread_Page(aDriver, test);
		otppage.OTPread_LoginTest(TMConstants.RealMobileNumber);

		// hm.logout();
		// Runtime.getRuntime().exec("taskkill /F /IM appium");
		// Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		// System.out.println("appium server closed successfully");

	}

}
