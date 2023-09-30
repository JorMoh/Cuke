package step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPOM.GuruPOM;
import utils.DataReader;
import utils.Driver;

public class Popups {

	GuruPOM guru = new GuruPOM();
	String homeWindow;
	String homeTitle;

	@Given("I am on the guru popup page")
	public void i_am_on_the_guru_popup_page() {
	  Driver.getDriver().get(DataReader.getData("guruUrl"));
	}
	@Given("I get the page title and store it")
	public void i_get_the_page_title_and_store_it() {
		 homeTitle = Driver.getDriver().getTitle();
	   
	}
	@Given("I click on the CLICK HERE button and switch over to the next window")
	public void i_click_on_the_click_here_button_and_switch_over_to_the_next_window() {
	    guru.clickHereBtn.click();
	    Set<String> windowIDs = Driver.getDriver().getWindowHandles();
	    Iterator<String> iter = windowIDs.iterator();
	    homeWindow = iter.next();
	    String secondWindow = iter.next();
	    Driver.getDriver().switchTo().window(secondWindow);
	}
	
	@Given("I provide an email {string} and click submit")
	public void i_provide_an_email_and_click_submit(String email) {
	    guru.emailIdField.sendKeys(email);
	    guru.submitButton.click();
	}



	@Given("I get the texts of user ID and passwords")
	public void i_get_the_texts_of_user_id_and_passwords() {
	   String userID = Driver.getDriver().findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
	   String password = Driver.getDriver().findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	}
	@Then("I should verify that the text “This access is valid only for20 days is displayed.”")
	public void i_should_verify_that_the_text_this_access_is_valid_only_for20_days_is_displayed() {
	   assertTrue(guru.accessibiltyText.isDisplayed());
	}
	@When("I close the window")
	public void i_close_the_window() {
	   Driver.getDriver().close();
	}
	@When("I go back to the main window, and get the title")
	public void i_go_back_to_the_main_window_and_get_the_title() {
	    Driver.getDriver().switchTo().window(homeWindow);
	}
	@Then("the title should match the stored title above.")
	public void the_title_should_match_the_stored_title_above() {
	    String currentTitle = Driver.getDriver().getTitle();
	    assertEquals(currentTitle, homeTitle);
	}



}
