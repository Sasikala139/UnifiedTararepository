package pom.UnifiedTara.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pom.UnifiedTara.pages.base.BasePage;

public class SendMoney_Page extends BasePage {
	
	
	 @FindBy(xpath="//android.widget.ImageView[@content-desc=\"Send Money\"]")
	    public WebElement SendMoney; 
	    
	    @FindBy(xpath="(//android.widget.ImageView[@content-desc=\"Pay Now\"])[1]")
		public WebElement PayNow;
	    
	
	    
  
	    public SendMoney_Page(AndroidDriver<AndroidElement> aDriver, ExtentTest test){
	         super(aDriver,test);
	           
	        }
	

	    
	    public void SendMoney() {
	    	
  	        waitForElementforClick(SendMoney, 20);
  	        waitForElementforClick(PayNow, 20);
   
 	
	    	
	    }
}
