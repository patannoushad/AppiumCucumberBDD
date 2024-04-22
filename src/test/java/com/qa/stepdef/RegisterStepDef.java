package com.qa.stepdef;

import com.qa.pages.LoginPage;
import com.qa.utils.TestData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.io.FileNotFoundException;

public class RegisterStepDef {

    @Given("User opens the Applications")
    public void   GivenUserOpensTheApplications(){
    }
    @When("^User enter (.*) in field$")
    public void User_enter_Condition_in_field(String testcaseID) throws FileNotFoundException {
        new LoginPage().enterLoginDetails(testcaseID);
    }
    @Then("^User should get a warning message about credential mismatch (.*)$")
    public void user_should_get_a_warning_message_about_credential_mismatch(String testcaseID) throws FileNotFoundException {
       TestData.readTestData(testcaseID);
    }
}
