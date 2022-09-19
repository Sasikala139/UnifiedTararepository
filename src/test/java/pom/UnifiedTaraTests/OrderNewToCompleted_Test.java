package pom.UnifiedTaraTests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.AddProduct_Page;
import pom.UnifiedTara.pages.HomePage;
import pom.UnifiedTara.pages.OrderMgt_Page;
import pom.UnifiedTara.pages.POS_Order;
import pom.UnifiedTara.util.TMConstants;

public class OrderNewToCompleted_Test extends BaseTest {


	@Test
	public void ordexceedLimit() throws InterruptedException, IOException {
	test = rep.startTest("Exceed limit test");
	test.log(LogStatus.INFO, "Starting Exceed limit test ");
	launchApp();
	Thread.sleep(4000);
	HomePage hm;
	hm=new HomePage(aDriver, test);
	
	hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);				
	//Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	
	AddProduct_Page addprod=new AddProduct_Page(aDriver, test);
	//sp.SwithUser("Merchant");
	addprod.NavigationTo_addProduct();
	addprod.AddProductforexceedlimit("ProductTestStatus", "1000", "10");
	POS_Order po=new POS_Order(aDriver, test);
	po.SearchProduct("ProductTestStatus");
	po.OrderThroughPos_cash();
	addprod.NavigationTo_Orders();
	OrderMgt_Page OrdMgt=new OrderMgt_Page(aDriver, test);
	OrdMgt.Confirm_Order("ProductTestStatus");
	OrdMgt.Deliver_Order("ProductTestStatus");
	}
	
}
