package pom.UnifiedTara_realnumber_Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.Promotion_Page;
import pom.UnifiedTara.pages.voucher_page;

public class AddPromotion_Test extends BaseTest {

	@Test
	public void Test1_AddPromotion() throws InterruptedException, IOException {
		test = rep.startTest("add Promotion Test:");
		test.log(LogStatus.INFO, "Starting the add promotion test ");
		launchApp();
		Thread.sleep(4000);
//		
//		OTPread_Page otppage=new OTPread_Page(aDriver, test);
//		
//		if(!otppage.isElementPresent(TMConstants.Mobile_Text1)){
//			otppage.reportFail("login page is not not loaded");
//		}
//		otppage.OTPValidationMethod(TMConstants.RealMobileNumber);
		voucher_page vou = new voucher_page(aDriver, test);
		vou.NavigationTo_Promotion();
		Promotion_Page pro = new Promotion_Page(aDriver, test);
		pro.addPromotion();

	}
}
