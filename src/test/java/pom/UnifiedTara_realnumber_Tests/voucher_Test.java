package pom.UnifiedTara_realnumber_Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.UnifiedTara.pages.voucher_page;

public class voucher_Test extends BaseTest {

	@Test
	public void Test1_addvocher() throws InterruptedException, IOException {
		test = rep.startTest("Add Vouvher with RP Test:");
		test.log(LogStatus.INFO, "Starting the add voucher test ");
		System.out.println("voucher test started. ");
		launchApp();
		Thread.sleep(4000);
		voucher_page vou = new voucher_page(aDriver, test);
		vou.NavigationTo_voucher();
		Thread.sleep(2000);
		vou.AddVoucherRP();
	}

	@Test
	public void Test3_addvocherPercent() throws InterruptedException, IOException {
		test = rep.startTest("Add Voucher with% Test:");
		test.log(LogStatus.INFO, "adding voucher with % ");
		Thread.sleep(4000);
		voucher_page vou = new voucher_page(aDriver, test);
		vou.AddVoucher_percent();
	}

	@Test
	public void Test2_EditVoucher() throws InterruptedException, IOException {
		test = rep.startTest("Edit Voucher Test:");
		test.log(LogStatus.INFO, "Edititng voucher test ");
		voucher_page vou = new voucher_page(aDriver, test);
		vou.EditVoucher();
	}

	

}
