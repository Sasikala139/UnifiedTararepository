package pom.UnifiedTaraTests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.Dashboard_Page;
import pom.UnifiedTara.pages.HomePage;
import pom.UnifiedTara.util.TMConstants;

public class DashBoard_Test extends BaseTest {

	@Test
	public void Test1_addproduct() throws InterruptedException, IOException {
		test = rep.startTest("DashBoard Test:");
		test.log(LogStatus.INFO, "Starting the add voucher test ");
		launchApp();
		Thread.sleep(4000);
		HomePage hm;
		hm=new HomePage(aDriver, test);
		//hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);		
		hm.OTP(TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);
	    Dashboard_Page DP=new Dashboard_Page(aDriver, test);
        DP.Top5InventoryItems();
        DP.Top5Customers();
        DP.TopVouchers();
        DP.PaymentModes();
        DP.inflow();
        DP.OutFlow();
        
      
      
      
	}
	
	
}
