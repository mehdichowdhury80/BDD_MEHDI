package stepsDefination;

import base.TestBase;
import io.cucumber.java.en.Given;
//mport static pages.HomePage.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutoQTest  extends TestBase{

@Given("homepage title is {string}")
public void homepage_title_is(String string) {
	homePage.verifyTitleText(string);
}

@Given("subtitle is {string}")
public void subtitle_is(String string) {
	homePage.verifySubTitleText(string);
}

@Given("footer is {string}")
public void footer_is(String string) {
	homePage.verifyFooterText(string);
}

@When("user click submit button")
public void user_click_submit_button() {
	homePage.clickSubmitBtn();
}

@Then("verify zipcode error message is {string},")
public void verify_zipcode_error_message_is(String string) {
	homePage.verifyErrorMsgText(string);
}

@When("user input zipcode {string}")
public void user_input_zipcode(String string) {
	homePage.inputZipCodeField(string);
}

@Then("verify zipcode length is {string}")
public void verify_zipcode_length_is(String string) {
	homePage.verifyLength(string);
}

@When("user click zipcode field")
public void user_click_zipcode_field() {
	homePage.clickSubmitBtn();
}

}
