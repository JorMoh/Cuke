package step_definitions;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPOM.SauceDemoPOM;
import utils.DataReader;
import utils.Driver;

public class SauceLogins {
	SauceDemoPOM sauce = new SauceDemoPOM();
	


	@Given("I am on SauceDemo website login page")
	public void i_am_on_sauce_demo_website_login_page() {
		Driver.getDriver().get(DataReader.getData("sauceDemoUrl"));
	}
	@Given("I enter a valid password {string}")
	public void i_enter_a_valid_password(String password) {
		 sauce.passwordField.sendKeys(password);
	}
	@When("I enter a valid user {string}")
	public void i_enter_a_valid_user(String username) {
		 sauce.usernameField.sendKeys(username);
	}
	@When("I click the login button")
	public void i_click_the_login_button() {
		 sauce.loginBtn.click();
	}
	@Then("I shoud be logged in successfully")
	public void i_shoud_be_logged_in_successfully() {
		assertTrue(sauce.productsText.isDisplayed());
	}
	
//----------------------------------------------	

	@When("I enter an invalid username {string}")
	public void i_enter_an_invalid_username(String username) {
		sauce.usernameField.sendKeys(username);
	}
	
	@Then("I should not be logged in")
	public void i_should_not_be_logged_in() {
		assertTrue(sauce.loginBtn.isDisplayed());
	   	}
	@Then("I should get the creds. don't match error message")
	public void i_should_get_the_creds_don_t_match_error_message() {
		 assertTrue(sauce.credentialsDontMatchError.isDisplayed());
	}
	
//-----------------------------------------------	
	


	@When("I enter a locked out username {string}")
	public void i_enter_a_locked_out_username(String username) {
		  sauce.usernameField.sendKeys(username);
	}
	
	@Then("I should get the locked out user error message")
	public void i_should_get_the_locked_out_user_error_message() {
		assertTrue(sauce.lockedOutUserError.isDisplayed());
	}
















}
