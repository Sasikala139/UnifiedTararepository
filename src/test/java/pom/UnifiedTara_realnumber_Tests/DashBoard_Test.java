package pom.UnifiedTara_realnumber_Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.Dashboard_Page;

public class DashBoard_Test extends BaseTest {

	@Test
	public void Test1_addproduct() throws InterruptedException, IOException {
		test = rep.startTest("DashBoard Test:");
		test.log(LogStatus.INFO, "Starting the add voucher test ");
		launchApp();
		Thread.sleep(4000);
//		
//		OTPread_Page otppage=new OTPread_Page(aDriver, test);
//		
//		if(!otppage.isElementPresent(TMConstants.Mobile_Text1)){
//			otppage.reportFail("login page is not not loaded");
//		}
//		otppage.OTPValidationMethod(TMConstants.RealMobileNumber);
		Dashboard_Page DP = new Dashboard_Page(aDriver, test);
		DP.Top5InventoryItems();
		DP.Top5Customers();
		DP.TopVouchers();
		DP.PaymentModes();
		DP.inflow();
		DP.OutFlow();

	}

}
