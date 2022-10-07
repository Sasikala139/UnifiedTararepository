package pom.UnifiedTara.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pom.UnifiedTara.pages.base.BasePage;
import pom.UnifiedTara.util.TMConstants;

public class AddProduct_Page extends BasePage {

	@FindBy(xpath = "//android.widget.ImageView[@index='0']")
	public WebElement ProductImage;

	@FindBy(xpath = "//android.widget.EditText[@index='1']")
	public WebElement ProductName;

	@FindBy(xpath = "//android.widget.EditText[@index='2']")
	public WebElement ProductPrice;

	@FindBy(xpath = "//android.widget.EditText[@index='3']")
	public WebElement DiscountPrice;

	@FindBy(xpath = "//android.widget.EditText[@index='4']")
	public WebElement ItemCount;

	@FindBy(xpath = "//android.view.View[@index='0']")
	public WebElement Currently_showstock;

	@FindBy(xpath = "//android.view.View[@index='6']")
	public WebElement Category;

	@FindBy(xpath = "//android.view.View[@index='3']")
	public WebElement category_item;

	@FindBy(xpath = "//android.widget.ImageView[@index='1']")
	public WebElement category_item_DoneButton;

	@FindBy(xpath = "//android.widget.EditText[@index='7' or @index='6']")
	public WebElement Description;

	@FindBy(xpath = "//android.widget.ImageView[@index='2']")
	public WebElement Done_Button;

	@FindBy(xpath = "//android.view.View[index='0']")
	public WebElement AddAnother_Button;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Inventory\"]")
	public WebElement Inventory_menu;

	@FindBy(xpath = "//android.widget.ImageView[@index='9']")
	public WebElement Delevery_settings;

	@FindBy(xpath = "//android.widget.ImageView[@index='6']")
	public WebElement sellerInventory_menu;

	// @FindBy(xpath= "//android.view.View[@content-desc=\"ADD PRODUCT\"]")
	@FindBy(xpath = "(//*[@class='android.view.View' and@index='3'])[1]")
	public WebElement Addproduct_Button;

	@FindBy(xpath = "(//*[@class='android.widget.ImageView' and @index='6'])[2]")
	public WebElement SellerProfileMenu;

	@FindBy(xpath = "//android.widget.ImageView[@index='2']")
	public WebElement Addproduct_Button_afterstore;

	@FindBy(xpath = "//android.widget.ImageView[@index='1']")
	public WebElement EditProduct_Button;

	@FindBy(xpath = "//android.widget.Button[@index='0']")
	public WebElement access_allow_button;

	// uplode image Elements
	@FindBy(xpath = "(//android.widget.ImageView[@index='0'])[2]")
	public WebElement Gallery;

	@FindBy(id = "com.google.android.documentsui:id/icon_thumb")
	public WebElement Select_img;

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	public WebElement Permission;

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Done\"]")
	public WebElement Done;

	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"Crop\"]")
	public WebElement Crop;

	// delete element
	@FindBy(xpath = "(//android.view.View[@index='2'])[2]")
	public WebElement delete_icon;

	// search elements
	@FindBy(xpath = "//android.widget.EditText[@index='0']")
	public WebElement searchText;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Orders\"]")
	public WebElement Orders_menu;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc='POS']")
	public WebElement POS;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Show out of stock\"]")
	public WebElement OutOfStocks;

	@FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,\"Out of stock\")]")
	public WebElement OutOfStocksMsg;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Upload CSV\"]")
	public WebElement uploadCSVele;
	@FindBy(xpath = "//android.view.View[@content-desc=\"Upload\"]")
	public WebElement uploadButtonele;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Upload CSV\"]")
	public WebElement uploadCSV;

	public AddProduct_Page(AndroidDriver<AndroidElement> aDriver, ExtentTest test) {
		super(aDriver, test);

	}

	public void NavigationTo_addProduct() throws InterruptedException {
		try {
			Thread.sleep(2000);
			waitForElementforClick(SellerProfileMenu, 50);

			TouchAction action = new TouchAction(aDriver);

			// int endy=aDriver.manage().window().getSize().getHeight()/7;
			int x = aDriver.manage().window().getSize().getWidth() / 2;
			int y = aDriver.manage().window().getSize().getHeight() / 2;
			action.longPress(x, y).moveTo(x, y - (y)).release().perform();
			Thread.sleep(4000);
			waitForElementforClick(Inventory_menu, 50);
			Thread.sleep(2000);
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Inventory Navigation error");

		}
	}

	public void NavigationTo_Orders() throws InterruptedException {

		waitForElementforClick(SellerProfileMenu, 20);

		waitForElementforClick(Orders_menu, 20);
	}

	public void AddProduct() throws InterruptedException {

		try {
			System.out.println("in addproduct block");
			waitForElementforClick(Addproduct_Button, 20);
			test.log(LogStatus.INFO, "Adding Product");
//Adding image
			waitForElementforClick(ProductImage, 20);
			waitForElementforClick(Gallery, 20);
			waitForElementforClick(Select_img, 20);
			waitForElementforClick(Crop, 20);
			// waitForElement(Permission, 20);
			System.out.println("Image uploaded successfully");
			Thread.sleep(4000);

			waitForElementforType(ProductName, 20, "Orange1");
			Thread.sleep(2000);
			waitForElementforType(ProductPrice, 20, "200");
			waitForElementforType(DiscountPrice, 20, "150");
			aDriver.hideKeyboard();
			waitForElementforType(ItemCount, 20, "10");

			aDriver.hideKeyboard();
			Thread.sleep(2000);
			click(Category);
			Thread.sleep(2000);
			waitForElementforClick(category_item, 20);
			waitForElementforClick(category_item_DoneButton, 20);

			aDriver.hideKeyboard();

			Thread.sleep(2000);
			// action1.tap(948,2152).perform();

			// action.longPress(954, 2084).release().perform();
			waitForElementforType(Description, 20, "description");

			aDriver.hideKeyboard();
			// action1.tap(990,2150).perform();
			waitForElementforClick(Done_Button, 10);
			String toastmessage = captureToastmessage();
			if (toastmessage.toLowerCase().contains("Added Successfully".toLowerCase())) {
				reportPass(toastmessage);
				takeScreenshot();
			} else {
				reportFail("Product not added failed");
				aDriver.navigate().back();
			}

		} catch (Exception e) {

			test.log(LogStatus.INFO, "adding product error");
			reportFail("addProduct gone wrong");

		}

	}

	public void EditProduct() throws InterruptedException {

		try {
			test.log(LogStatus.INFO, "Editing Product");
			System.out.println("Editing Product");
			waitForElementforClick(EditProduct_Button, 10);
			waitForElementforType(ProductName, 20, "OrangeEdited");
			Thread.sleep(2000);
			typeText(ProductPrice, "300");
			typeText(DiscountPrice, "250");
			aDriver.hideKeyboard();

			typeText(ItemCount, "20");
			aDriver.hideKeyboard();
			Thread.sleep(1000);
			typeText(Description, "description of product edited");
			aDriver.hideKeyboard();
			waitForElementforClick(Done_Button, 10);
			String toastmessageEdit = captureToastmessage();
			System.out.println("toastmessage=" + toastmessageEdit);
			if (toastmessageEdit.toLowerCase().contains("Successfully".toLowerCase())) {
				reportPass(toastmessageEdit);
			} else {
				reportFail("Product Edit failed");
				aDriver.navigate().back();
			}
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Edit product error");
			reportFail("edit product gone wrong");

		}

	}

	// DeleteProduct
	public void DeleteProduct() throws InterruptedException {

		try {
			System.out.println("deleting product");
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Clicking delete product icon");
			waitForElementforClick(delete_icon, 20);
			WebElement Yesele = aDriver.findElementByXPath("//android.view.View[@content-desc='Yes']");
			waitForElementforClick(Yesele, 20);
			String toastmessage = captureToastmessage();
			Thread.sleep(2000);
			if (toastmessage.toLowerCase().contains("deleted successfully".toLowerCase())) {
				reportPass(toastmessage);
			} else {
				reportFail("Product delete failed");

				Thread.sleep(4000);
			}

		}

		catch (Exception e) {

			test.log(LogStatus.INFO, "Delete product error");
			reportFail("delete product gone wrong");

		}

	}

	public void uploadCSVFile() throws InterruptedException {

		try {
			Thread.sleep(2000);
			System.out.println("Uploading CSV");
			waitForElementforClick(uploadCSVele, 20);

			test.log(LogStatus.INFO, "clicked on upload CSV");
			try {

				waitForElementforClick(uploadCSV, 20);

				WebDriverWait wait = new WebDriverWait(aDriver, 10);
				wait.until(ExpectedConditions.alertIsPresent());
				Alert simpleAlert = aDriver.switchTo().alert();
				simpleAlert.accept();
				System.out.println("Unexpected alert accepted");
			} catch (Exception e) {
				System.out.println("unexpected alert not present");
			}
			Thread.sleep(2000);
			aDriver.findElementById("com.google.android.documentsui:id/item_root").click();
			// aDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout").click();
			test.log(LogStatus.INFO, "Selected file");

			waitForElementforClick(uploadButtonele, 20);

			Thread.sleep(3000);
			String toastmessagenamerequired = captureToastmessage();
			test.log(LogStatus.INFO, toastmessagenamerequired);
			if (!toastmessagenamerequired.toLowerCase().contains("CSV successfully".toLowerCase())) {

				reportPass("Uploaded CSV successfully");
			} else {
				reportFail("Uploaded CSV Failed");
				aDriver.navigate().back();
			}
		} catch (Exception e) {

			test.log(LogStatus.INFO, "upload CSV error");
			reportFail("upload CSV gone wrong");

		}

	}
	// // aDriver.pushFile("/storage/emulated/0/Download/sample_updated1.csv", new
	// File("C:\\Users\\SasikalaMukkara\\Downloads\\sample_updated1.csv"));
//        //Add a simple assertion
//        By nextPageHeader = By.cssSelector("h1");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(nextPageHeader));
//        Assert.assertTrue(driver.findElement(nextPageHeader).getText().equals("File Upload Results"));

	public void AddProductWithoutName() throws InterruptedException {

		try {
			waitForElementforClick(Addproduct_Button, 40);
			System.out.println("Adding product without name");
			test.log(LogStatus.INFO, "Adding Product with out product name");
			Thread.sleep(2000);
			waitForElementforType(ProductPrice, 20, "200");
			aDriver.hideKeyboard();
			waitForElementforType(DiscountPrice, 30, "150");
			aDriver.hideKeyboard();
			waitForElementforType(ItemCount, 20, "10");
			aDriver.hideKeyboard();
			waitForElementforClick(Category, 20);
			waitForElementforClick(category_item, 20);
			waitForElementforClick(category_item_DoneButton, 10);
			aDriver.hideKeyboard();
			waitForElementforType(Description, 20, "description of productname1");
			aDriver.hideKeyboard();
			waitForElementforClick(Done_Button, 10);

			String toastmessagenamerequired = captureToastmessage();
			test.log(LogStatus.INFO, toastmessagenamerequired);
			if (!toastmessagenamerequired.toLowerCase().contains("name is required".toLowerCase())) {
				reportFail("Test Failed: Should ask for procut Name");
			} else {
				reportPass("Not allowed adding product without product Name");
			}
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Adding more discount than price");

			waitForElementforType(DiscountPrice, 20, "350");
			aDriver.hideKeyboard();

			waitForElementforType(ProductName, 20, "Orange1");

			aDriver.hideKeyboard();
			waitForElementforClick(Done_Button, 10);

			String toastmessage = captureToastmessage();
			test.log(LogStatus.INFO, toastmessage);
			if (!toastmessage.toLowerCase().contains("Discounted price cannot be greater than MRP".toLowerCase())) {
				reportFail("Test Failed: Discounted price cannot be greater than MRP");

			} else {
				reportPass("Not allowed as Discounted price is greater than MRP");

			}
			Thread.sleep(9000);
		} catch (Exception e) {

			test.log(LogStatus.INFO, "add product  error");
			reportFail("upload CSV gone wrong");

		}
	}

	public void AddproductmoreDiscountthanprice() throws InterruptedException {
		System.out.println("adding product with more discount than price");

		waitForElementforClick(Addproduct_Button, 10);
		test.log(LogStatus.INFO, "Adding Product with more discount than price");
		Thread.sleep(2000);
		waitForElementforClick(ProductName, 20);
		ProductName.sendKeys("mango");
		waitForElementforType(ProductPrice, 20, "250");
		waitForElementforType(DiscountPrice, 20, "350");

		aDriver.hideKeyboard();
		waitForElementforType(ItemCount, 20, "10");

		aDriver.hideKeyboard();
		Thread.sleep(2000);
		waitForElementforClick(Category, 20);
		waitForElementforClick(category_item, 20);
		waitForElementforClick(category_item_DoneButton, 20);

		aDriver.hideKeyboard();
		Thread.sleep(2000);
		waitForElementforType(Description, 20, "description");

		aDriver.hideKeyboard();
		Thread.sleep(2000);

		waitForElementforClick(Done_Button, 10);
		String toastmessage = captureToastmessage();
		test.log(LogStatus.INFO, toastmessage);
		if (!toastmessage.toLowerCase().contains("Discounted price cannot be greater than MRP".toLowerCase())) {
			reportFail("Test Failed: Discounted price cannot be greater than MRP");

		} else {
			reportPass("Not allowed as Discounted price is greater than MRP");

		}
		aDriver.navigate().back();
		Thread.sleep(2000);

	}

	public void SearchProduct(String serarchprod) throws InterruptedException {
		System.out.println("Searching  product ");

		test.log(LogStatus.INFO, "Searching for the Product");
		Thread.sleep(4000);
		typeText(searchText, serarchprod);
		aDriver.hideKeyboard();
		if (aDriver.getPageSource().toLowerCase().contains(serarchprod.toLowerCase())) {
			reportPass("search product successfully");
		} else {
			reportFail("Found search product error.");
		}

	}

	public void AddProductfororder(String productname, String price, String quantity) throws InterruptedException {

		try {
			waitForElementforClick(Addproduct_Button, 20);
			test.log(LogStatus.INFO, "Adding Product");

			Thread.sleep(4000);
			waitForElementforClick(ProductName, 20);
			ProductName.sendKeys(productname);

			waitForElementforType(ProductPrice, 20, price);
			aDriver.hideKeyboard();

			waitForElementforType(ItemCount, 20, quantity);
			aDriver.hideKeyboard();

			Thread.sleep(2000);
			waitForElementforClick(Category, 20);
			waitForElementforClick(category_item, 20);
			waitForElementforClick(category_item_DoneButton, 20);

			aDriver.hideKeyboard();
			Thread.sleep(2000);
//		String countis=ItemCount.getText();
//		System.out.println("Product quantity befor ordering is "+countis);

//		test.log(LogStatus.INFO, "product quantity before ordering "+ItemCount.getText());

			waitForElementforClick(Done_Button, 10);

		} catch (Exception e) {

			test.log(LogStatus.INFO, "adding product error");

		}

	}

	public void AddProductfororderoutofstock(String productname, String price, String quantity)
			throws InterruptedException {

		try {

			waitForElementforClick(Addproduct_Button, 40);
			test.log(LogStatus.INFO, "Adding Product with out of stock");

			test.log(LogStatus.INFO, "Adding Product");

			Thread.sleep(4000);
			waitForElementforClick(ProductName, 20);
			ProductName.sendKeys(productname);
			// waitForElementforType(ProductName, 20, productname);
			aDriver.hideKeyboard();

			waitForElementforType(ProductPrice, 20, price);
			aDriver.hideKeyboard();

			waitForElementforType(ItemCount, 20, quantity);
			aDriver.hideKeyboard();
			waitForElementforClick(OutOfStocks, 10);
			aDriver.hideKeyboard();

			Thread.sleep(2000);
			waitForElementforClick(Category, 20);
			waitForElementforClick(category_item, 20);
			waitForElementforClick(category_item_DoneButton, 20);

			aDriver.hideKeyboard();

//    String countis=ItemCount.getText();
//    System.out.println("Product quantity befor ordering is "+countis);

//    test.log(LogStatus.INFO, "product quantity before ordering "+ItemCount.getText());

			waitForElementforClick(Done_Button, 20);
			Thread.sleep(4000);
			aDriver.navigate().back();
			waitForElementforClick(POS, 30);
			test.log(LogStatus.INFO, "Opened POS");

			Thread.sleep(2000);

		} catch (Exception e) {

			test.log(LogStatus.INFO, "adding product error");

		}
	}

	public void AddProductforexceedlimit(String productname, String price, String disprice, String quantity)
			throws InterruptedException {

		try {
			waitForElementforClick(Addproduct_Button, 20);
			test.log(LogStatus.INFO, "Adding Product to check exceed limit");
			Thread.sleep(4000);
			waitForElementforClick(ProductName, 20);
			ProductName.sendKeys(productname);
			aDriver.hideKeyboard();
			waitForElementforType(ProductPrice, 20, price);
			aDriver.hideKeyboard();
			waitForElementforType(DiscountPrice, 20, disprice);
			aDriver.hideKeyboard();
			waitForElementforType(ItemCount, 20, quantity);
			aDriver.hideKeyboard();
			Thread.sleep(3000);
			waitForElementforClick(Category, 40);
			Thread.sleep(2000);

			waitForElementforClick(category_item, 50);
			waitForElementforClick(category_item_DoneButton, 20);
			aDriver.hideKeyboard();
			Thread.sleep(2000);
			waitForElementforClick(Done_Button, 10);
			Thread.sleep(3000);
			aDriver.navigate().back();
		//	waitForElementforClick(POS, 30);
		//	Thread.sleep(2000);
		} catch (Exception e) {

			test.log(LogStatus.INFO, "adding product error");
			reportFail("addProduct gone wrong");

		}

	}

	public void AddProductpractice() throws InterruptedException {

		System.out.println("in addproduct block");
		waitForElementforClick(Addproduct_Button, 20);
		test.log(LogStatus.INFO, "Adding Product");
//Adding image
		// waitForElementforClick(ProductImage, 20);
		uploadfile(ProductImage, TMConstants.Img_PATH);

//		waitForElementforClick(Gallery, 20);
//		waitForElementforClick(Select_img, 20);
//		waitForElementforClick(Crop, 20);
		// waitForElement(Permission, 20);
		System.out.println("Image uploaded successfully");
		Thread.sleep(4000);

		waitForElementforType(ProductName, 20, "Orange1");
		Thread.sleep(2000);
		waitForElementforType(ProductPrice, 20, "200");
		waitForElementforType(DiscountPrice, 20, "150");
		aDriver.hideKeyboard();
		waitForElementforType(ItemCount, 20, "10");

		aDriver.hideKeyboard();
		Thread.sleep(2000);
		click(Category);
		Thread.sleep(2000);
		waitForElementforClick(category_item, 20);
		waitForElementforClick(category_item_DoneButton, 20);

		aDriver.hideKeyboard();

		Thread.sleep(2000);
		// action1.tap(948,2152).perform();

		// action.longPress(954, 2084).release().perform();
		waitForElementforType(Description, 20, "description");

		aDriver.hideKeyboard();
		// action1.tap(990,2150).perform();
		waitForElementforClick(Done_Button, 10);
		String toastmessage = captureToastmessage();
		if (toastmessage.toLowerCase().contains("Added Successfully".toLowerCase())) {
			reportPass(toastmessage);
			takeScreenshot();
		} else {
			reportFail("Product not added failed");
			aDriver.navigate().back();
		}
	}

	public void PracticeuploadCSVFile() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Uploading CSV");
		waitForElementforClick(uploadCSVele, 20);

		test.log(LogStatus.INFO, "clicked on upload CSV");

		uploadfile(uploadCSV, TMConstants.CSV_PATH);

		Thread.sleep(6000);

		waitForElementforClick(uploadButtonele, 20);

		Thread.sleep(3000);
		String toastmessagenamerequired = captureToastmessage();
		test.log(LogStatus.INFO, toastmessagenamerequired);
		if (!toastmessagenamerequired.toLowerCase().contains("CSV successfully".toLowerCase())) {

			reportPass("Uploaded CSV successfully");
		} else {
			reportFail("Uploaded CSV Failed");
			aDriver.navigate().back();
		}

	}

}
