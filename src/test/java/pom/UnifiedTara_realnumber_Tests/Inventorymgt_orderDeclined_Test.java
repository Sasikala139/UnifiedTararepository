package pom.UnifiedTara_realnumber_Tests;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.AddProduct_Page;
import pom.UnifiedTara.pages.OrderMgt_Page;
import pom.UnifiedTara.pages.POS_Order;

public class Inventorymgt_orderDeclined_Test extends BaseTest {

	@Test
	public void Test1_OrderDeclained() throws InterruptedException, IOException {
		test = rep.startTest("Product count check when Order declined");
		test.log(LogStatus.INFO, "Starting inventory mgt test ");
		System.out.println("order decline test started   ");

		launchApp();
		Thread.sleep(4000);

//			OTPread_Page otppage=new OTPread_Page(aDriver, test);
//			
//			if(!otppage.isElementPresent(TMConstants.Mobile_Text1)){
//				otppage.reportFail("login page is not not loaded");
//			}
//			otppage.OTPValidationMethod(TMConstants.RealMobileNumber);		
		// Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
//			add_paymentoption_Page addpay=new add_paymentoption_Page(aDriver, test);
//			addpay.navigatetomerchantiflareadyuser();
		// addpay.add_creditcard();
		AddProduct_Page addprod = new AddProduct_Page(aDriver, test);
		// sp.SwithUser("Merchant");
		addprod.NavigationTo_addProduct();
		addprod.AddProductfororder("ProdOrderdeclined", "1000", "10");
		Thread.sleep(5000);
		addprod.SearchProduct("ProdOrderdeclined");
		WebElement productstirng = aDriver
				.findElementByXPath("//android.view.View[contains(@content-desc,\"ProdOrderdeclined\")]");
		String beforeorderquantity = productstirng.getTagName();
		aDriver.navigate().back();

		POS_Order pos = new POS_Order(aDriver, test);
		Thread.sleep(4000);
		pos.SearchProduct("ProdOrderdeclined");
		pos.OrderThroughPos_cash();

		// Declining order
		addprod.NavigationTo_Orders();
		Thread.sleep(3000);
		// WebElement
		// productToDeclineele=aDriver.findElementByXPath("//android.widget.ImageView[contains(@content-desc,'TestProductforOrderdeclined')]");
		OrderMgt_Page ordpage = new OrderMgt_Page(aDriver, test);
		ordpage.Decline_Order("ProdOrderdeclined");
		Thread.sleep(2000);
		aDriver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Inventory\"]").click();

		// addprod.NavigationTo_addProduct();
		Thread.sleep(6000);
		addprod.SearchProduct("ProdOrderdeclined");
		WebElement productstirng1 = aDriver
				.findElementByXPath("//android.view.View[contains(@content-desc,\"ProdOrderdeclined\")]");
		String afterrderquantity = productstirng1.getTagName();

		// spliting beforequantity
		String datasplit[];
		datasplit = beforeorderquantity.split("\\n");

		System.out.println(" split by new line" + Arrays.toString(datasplit));
		String datasplit1[];
		datasplit1 = datasplit[1].split(":");
		String val_str = datasplit1[1].trim();
		int befor_quantity = Integer.parseInt(val_str);
		test.log(LogStatus.INFO, "Before Order quantity of product is " + befor_quantity);

		System.out.println(" beforequantity" + befor_quantity);

		// spliting after decline

		String afterdatasplit1[];
		afterdatasplit1 = afterrderquantity.split("\\n");

		System.out.println(" split by new line" + Arrays.toString(datasplit));
		String afterdatasplit2[];
		afterdatasplit2 = afterdatasplit1[1].split(":");
		String val_str1 = afterdatasplit2[1].trim();
		int after_quantity = Integer.parseInt(val_str1);
		test.log(LogStatus.INFO, "After Order quantity of product is " + after_quantity);

		System.out.println(" after quantity" + after_quantity);
		// test.log(LogStatus.INFO,"quantity is "+val_str1);

		if (after_quantity == befor_quantity) {

			test.log(LogStatus.PASS, "TestPass: Count is not changed ");

		} else {

			test.log(LogStatus.FAIL, "Ooops! Count is changed ");

		}

		System.out.println("order decline test ended successfully  ");
		Thread.sleep(2000);

	}

}
