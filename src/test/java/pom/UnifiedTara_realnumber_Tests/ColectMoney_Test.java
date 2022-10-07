package pom.UnifiedTara_realnumber_Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.CollectMoney_Page;
import pom.UnifiedTara.pages.OrderProducts_IndividualUser_Page;
import pom.UnifiedTara.pages.SendMoney_Page;

public class ColectMoney_Test extends BaseTest {

	String testName = "collectmoney";

	@Test
	public void ColletMoney() throws InterruptedException, IOException {
		test = rep.startTest(testName);
		test.log(LogStatus.INFO, "Starting the test ");
		launchApp();
		Thread.sleep(4000);

//			OTPread_Page otppage=new OTPread_Page(aDriver, test);
//			
//			if(!otppage.isElementPresent(TMConstants.Mobile_Text1)){
//				otppage.reportFail("login page is not not loaded");
//			}
//			otppage.OTPValidationMethod(TMConstants.RealMobileNumber);
		CollectMoney_Page CMP = new CollectMoney_Page(aDriver, test);
		CMP.AddCollectMoney();

		OrderProducts_IndividualUser_Page IndiUser = new OrderProducts_IndividualUser_Page(aDriver, test);
		IndiUser.NavigationTo_IndividualUser();

		SendMoney_Page sp = new SendMoney_Page(aDriver, test);
		sp.SendMoney();

	}

}
