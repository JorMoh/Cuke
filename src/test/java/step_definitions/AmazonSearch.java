package step_definitions;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pagesPOM.AmazonHomePOM;
import utils.DataReader;
import utils.Driver;

public class AmazonSearch {
	AmazonHomePOM home = new AmazonHomePOM();
	
	
	@Given("I am on Amazon Website homepage")
	public void i_am_on_amazon_website_homepage() {
	    Driver.getDriver().get(DataReader.getData("amazonUrl"));
	}
	@Given("I enter a search item {string} in the search box")
	public void i_enter_a_search_item_in_the_search_box(String Item) {
	   home.homeSearchBox.sendKeys(Item);
	}
	@Given("I click on the search button")
	public void i_click_on_the_search_button() {
	   home.searchBtn.click();
	}
	@Then("I should see the searched item {string} on the results page")
	public void i_should_see_the_searched_item_on_the_results_page(String Item) {
		String searchedItem = home.searchedItemText.getText().substring(1, Item.length()+1);
	   assertEquals(searchedItem, Item);
	}




}
