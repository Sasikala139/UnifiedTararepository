package pom.UnifiedTara.pages;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TopMenu {
	public AndroidDriver<AndroidElement> aDriver;
	public ExtentTest test;
	
	public TopMenu(AndroidDriver<AndroidElement> aDriver, ExtentTest test) {
		this.aDriver=aDriver;
		this.test=test;
	}

	public void gotoCart(){
		// code
	}
	
	public void search(){
		
	}
	
}
