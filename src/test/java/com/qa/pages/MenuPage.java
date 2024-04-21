package com.qa.pages;

import com.qa.utils.CommonUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends BasePage{
	AppiumDriver driver;


	@AndroidFindBy (xpath="//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView\n" +
			"")
	@iOSXCUITFindBy (xpath="//XCUIElementTypeOther[@name=\"test-Menu\"]/XCUIElementTypeOther")
	private WebElement settingsBtn;

	public SettingsPage pressSettingsBtn() {
		clickOnElement(settingsBtn,"press Settings button");
		return new SettingsPage();
	}

}
