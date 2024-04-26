package com.qa.stepdef;

import com.qa.pages.BasePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    @When("I enter username as {string}")
    public void iEnterUsernameAs(String username) {
//        loginPage.usernameTxtFld.clear();
//        loginPage.usernameTxtFld.sendKeys(username);
        //or
//        basePage.clearText(loginPage.usernameTxtFld);
//        basePage.typeTextIntoElement(loginPage.usernameTxtFld, username);
        new LoginPage().enterUserName(username);
    }

    @When("I enter password as {string}")
    public void iEnterPasswordAs(String password) {
        new LoginPage().enterPassword(password);
    }

    @When("I login")
    public void iLogin() {
        new LoginPage().pressLoginBtn();
    }

    @Then("login should fail with an error {string}")
    public void loginShouldFailWithAnError(String err) {
       // Assert.assertEquals(new LoginPage().getErrTxt(), err);
        Assert.assertEquals(err,new LoginPage().getErrTxt());
        System.out.println("=print ==================="+new LoginPage().getErrTxt());
    }

    @Then("I should see Products page with title {string}")
    public void iShouldSeeProductsPageWithTitle(String title) {
        Assert.assertEquals(new ProductsPage().getTitle(), title);
    }
}
