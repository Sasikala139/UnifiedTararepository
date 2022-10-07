package pom.UnifiedTara_realnumber_Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.HomePage;

public class ChangeLanguage_Test extends BaseTest {

	String testName = "ChangeLaguage";

	@Test
	public void ChangeLanguage() throws InterruptedException, IOException {
		test = rep.startTest(testName);
		test.log(LogStatus.INFO, "Starting the Change Laguage test ");
		launchApp();
		HomePage hm;
		hm = new HomePage(aDriver, test);
		hm.changeLanguage();
		Thread.sleep(6000);
		hm.changeLanguage();

	}
}