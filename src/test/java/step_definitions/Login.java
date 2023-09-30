package step_definitions;

import static org.testng.Assert.assertTrue;

import org.codehaus.groovy.runtime.powerassert.AssertionRenderer;

import craterPagesPOM.DashboardPOM;
import craterPagesPOM.LoginPOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Data;
import utils.DataReader;
import utils.Driver;

public class Login {
	LoginPOM login = new LoginPOM();
	DashboardPOM dash = new DashboardPOM();
	String username;
	String password;
	
//  Scenario: Successful login
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	 Driver.getDriver().get(DataReader.getData("craterUrl"));
	}
	
	@When("user enters valid username {string} and password {string}")
	public void user_enters_valid_username_and_password(String username, String password) {
	   login.userEmailField.sendKeys(username);
	   login.passwordField.sendKeys(password);
	   
	}
	
	@When("click login button")
	public void click_login_button() {
		login.loginButton.click();
	}
	
	@Then("user should be on the dashboard page")
	public void user_should_be_on_the_dashboard_page() {
	    assertTrue(dash.settingsText.isDisplayed());
	}
	
// ------------------------------------------------	
	
//  Scenario Outline: Unsuccessful login
	
	@When("user enters invalid username {string} and password {string}")
	public void user_enters_invalid_username_and_password(String username, String password) {
		login.userEmailField.sendKeys(username);
		login.passwordField.sendKeys(password);
		login.loginButton.click();
		this.username = username;
		this.password = password;
	}   
	
	@Then("an error message should appear")
	public void an_error_message_should_appear() {
	  if(username.isBlank() || password.isBlank()) {
		  assertTrue(login.fieldRequiredMsg.isDisplayed());
	  }else {
		  assertTrue(login.credsDoNotMatchrError.isDisplayed());
	  }
	}
	@Then("user stays on the login page")
	public void user_is_still_on_the_login_page() {
	    assertTrue(login.loginButton.isDisplayed());
	}







}
