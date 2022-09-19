package pom.UnifiedTaraTests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.AddProduct_Page;
import pom.UnifiedTara.pages.HomePage;
import pom.UnifiedTara.pages.StoreCreation_Page;
import pom.UnifiedTara.pages.add_paymentoption_Page;
import pom.UnifiedTara.util.TMConstants;

public class SwitchToUser extends BaseTest {


	@Test
	public void Test1_switchtouser() throws InterruptedException, IOException {
		test = rep.startTest("AddProductFromIndividualAccount");
		test.log(LogStatus.INFO, "Starting the add product test ");
		launchApp();
		Thread.sleep(4000);
		HomePage hm;
		hm=new HomePage(aDriver, test);
		if(!hm.isElementPresent(TMConstants.Mobile_Text1)){
			hm.reportFail("login page is not not loaded");
		}
		hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);
		//Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		add_paymentoption_Page addpay=new add_paymentoption_Page(aDriver, test);
		
		//addpay.add_creditcard();
		AddProduct_Page addprod=new AddProduct_Page(aDriver, test);
		StoreCreation_Page sp=new StoreCreation_Page(aDriver, test);
		sp.SwithUser("IndividualUser");
		addpay.navigatetomerchantiflareadyuser();

		addprod.NavigationTo_addProduct();
		
		addprod.AddProduct();
	}
	
}
