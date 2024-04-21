package com.qa.pages;

import com.qa.utils.GlobalParams;
import com.qa.utils.CommonUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage {

	CommonUtils utils = new CommonUtils();
	
//	@AndroidFindBy (xpath = "//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]/preceding-sibling::android.view.ViewGroup/android.widget.TextView")
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='PRODUCTS']")
	@iOSXCUITFindBy (xpath ="//XCUIElementTypeOther[@name=\"test-Toggle\"]/parent::*[1]/preceding-sibling::*[1]")
	private WebElement titleTxt;

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"test-PRODUCTS\"]/XCUIElementTypeScrollView")
	private WebElement iOSSCrollView;

	public String getTitle() {
		return getText(titleTxt, "product page title is - ");
	}

	public String getProductTitle(String title) throws Exception {
		switch(new GlobalParams().getPlatformName()){
			case "Android":
				return getText(andScrollToElementUsingUiScrollable("text", title), "product title is: " + title);
			case "iOS":
				return getText(iOSScrollToElementUsingMobileScrollParent(iOSSCrollView, "label == '"+ title +"'"),
						"product title is: " + title);
			default:
				throw new Exception("Invalid platform name");
		}
	}

	public By defProductPrice(String title) throws Exception {
		switch(new GlobalParams().getPlatformName()){
			case "Android":
				return By.xpath("//*[@text=\"" + title + "\"]/following-sibling::*[@content-desc=\"test-Price\"]");
			case "iOS":
				return By.xpath("//XCUIElementTypeOther[@name=\"" + title + "\"]/following-sibling::*[1]/child::XCUIElementTypeStaticText[@name=\"test-Price\"]");
			default:
				throw new Exception("Invalid platform name");
		}
	}

/*	public String getProductPrice(String title, String price) throws Exception {
		return getText(scrollToElement(defProductPrice(title), "up"), "product price is: " + price);
	}*/

	public ProductDetailsPage pressProductTitle(String title) throws Exception {
		switch(new GlobalParams().getPlatformName()){
			case "Android":
				clickOnElement(andScrollToElementUsingUiScrollable("text", title), "press " + title + " link");
				return new ProductDetailsPage();
			case "iOS":
				clickOnElement(iOSScrollToElementUsingMobileScrollParent(iOSSCrollView, "label == '"+ title +"'"), "press " + title + " link");
				return new ProductDetailsPage();
			default:
				throw new Exception("Invalid platform name");
		}
	}
}
