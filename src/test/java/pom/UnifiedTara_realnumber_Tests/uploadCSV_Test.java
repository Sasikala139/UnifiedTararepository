package pom.UnifiedTara_realnumber_Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.AddProduct_Page;

public class uploadCSV_Test extends BaseTest {

	String testName = "UploadCSV";

	@Test
	public void Test1_UploadCSV() throws InterruptedException, IOException {
		test = rep.startTest(testName);
		test.log(LogStatus.INFO, "Starting the test ");
		launchApp();
		Thread.sleep(4000);
//		OTPread_Page otppage=new OTPread_Page(aDriver, test);
//		otppage.OTPValidationMethod(TMConstants.RealMobileNumber);
		AddProduct_Page addprod = new AddProduct_Page(aDriver, test);
		addprod.NavigationTo_addProduct();
		addprod.uploadCSVFile();
	}

}
