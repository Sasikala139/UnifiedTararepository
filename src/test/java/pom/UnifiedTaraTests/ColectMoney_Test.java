package pom.UnifiedTaraTests;
import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.CollectMoney_Page;
import pom.UnifiedTara.pages.HomePage;
import pom.UnifiedTara.pages.OrderProducts_IndividualUser_Page;
import pom.UnifiedTara.util.TMConstants;


	public class ColectMoney_Test extends BaseTest {

		String testName="collectmoney";
		@Test
		public void ColletMoney() throws InterruptedException, IOException {
			test = rep.startTest(testName);
			test.log(LogStatus.INFO, "Starting the test ");
			launchApp();
			Thread.sleep(4000);
			HomePage hm;
			hm=new HomePage(aDriver, test);
			if(!hm.isElementPresent(TMConstants.Mobile_Text1)){
				hm.reportFail("login page is not not loaded");
			}
			//PageFactory.initElements(aDriver, this);
			Thread.sleep(10000);
			hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);				 
			
			CollectMoney_Page CMP=new CollectMoney_Page(aDriver, test);
			CMP.AddCollectMoney();
			
			OrderProducts_IndividualUser_Page IndiUser=new OrderProducts_IndividualUser_Page(aDriver, test);
			IndiUser.NavigationTo_IndividualUser();
			
			
			
		}	
	
}
