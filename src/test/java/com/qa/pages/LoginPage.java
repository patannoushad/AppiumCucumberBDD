package com.qa.pages;

import com.qa.utils.CommonUtils;
import com.qa.utils.TestData;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.FileNotFoundException;

public class LoginPage extends BasePage  {

    CommonUtils utils = new CommonUtils();

    @AndroidFindBy(accessibility = "test-Username")
    @iOSXCUITFindBy(id = "test-Username")
    public WebElement usernameTxtFld;

    @AndroidFindBy(accessibility = "test-Password")
    @iOSXCUITFindBy(id = "test-Password")
    public WebElement passwordTxtFld;

    @AndroidFindBy(accessibility = "test-LOGIN")
    @iOSXCUITFindBy(id = "test-LOGIN")
    private WebElement loginBtn;

//    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Error message\"]/child::XCUIElementTypeStaticText")
//    private WebElement errTxt;


    //==================================================

    public LoginPage() {
    }
    public void enterLoginDetails(String testcaseID) throws FileNotFoundException {
        TestData.readTestData(testcaseID);
        typeTextIntoElement(usernameTxtFld,TestData.get("username"));
        passwordTxtFld.sendKeys(TestData.get("password"));
        clickOnElement(loginBtn);
    }

//    @AndroidFindBy(accessibility = "test-Error message")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Username and password do not match any user in this service.']")
    private WebElement errTxt;
    public String getErrTxt() {
        return errTxt.getText();
    }

    public void verifyErrorMsg(String testcaseID)  {
        System.out.println("==========testcaseID===="+testcaseID);
        System.out.println("==========TestData.get(\"errorMsg\")====="+TestData.get("errorMsg"));
        Assert.assertEquals(getErrTxt(),TestData.get("errorMsg"));
    }

//=======================================================
    public void enterUserName(String username) {
        clearText(usernameTxtFld);
        typeTextIntoElement(usernameTxtFld, username, "login with " + username);
    }
    public void enterPassword(String password) {
        clearText(passwordTxtFld);
        typeTextIntoElement(passwordTxtFld, password, "password is " + password);
    }
    public ProductsPage pressLoginBtn() {
        clickOnElement(loginBtn, "press login button");
        return new ProductsPage();
    }

    public ProductsPage login(String username, String password) throws InterruptedException {
        enterUserName(username);
        enterPassword(password);
        return pressLoginBtn();
    }


}
