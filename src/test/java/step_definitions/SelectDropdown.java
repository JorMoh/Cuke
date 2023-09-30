package step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPOM.AmazonHomePOM;
import utils.DataReader;
import utils.Driver;

public class SelectDropdown {
	AmazonHomePOM amazon = new AmazonHomePOM();
	 List<WebElement> options;
	 Select select;
	

//	Scenario: Verify list elements number
	@Given("I'm on Amazon Website")
	public void i_m_on_amazon_website() {
	   Driver.getDriver().get(DataReader.getData("amazonUrl"));
	}
	@Given("I get all the options in the dropdown")
	public void i_get_all_the_options_in_the_dropdown() {
	   select = new Select(amazon.departmentsDropdown);
	   options = select.getOptions();
	}
	@Given("I print them out")
	public void i_print_them_out() {
	  for(int i=0; i<options.size(); i++) {
		  System.out.println(options.get(i).getText());
	  }
	}
	@Then("there should be a total of 56 departments")
	public void there_should_be_a_total_of_departments() {
	  assertEquals(options.size(), 56);
	}

//---------------------------------------------------	
//  Scenario: Verify list elements
	@Then("the default dropdown value should be “All Departments”")
	public void the_default_dropdown_value_should_be_all_departments() {
		 select = new Select(amazon.departmentsDropdown);
		String defDropVal = select.getFirstSelectedOption().getText();
	   assertEquals(defDropVal, "All Departments");
	}
	@When("I select department “Amazon Devices”")
	public void i_select_department_home_kitchen() {
	   select.selectByVisibleText("Amazon Devices");
	}
	
	@When("I search for a {string}")
	public void i_search_for_a(String item) {
		amazon.homeSearchBox.sendKeys(item+Keys.ENTER);
	}
	
	@Then("I should be on the {string} search page")
	public void i_should_be_on_the_search_page(String item) throws InterruptedException {
	  String srchdItemTxt = amazon.searchedItemText.getText().substring(1, item.length()+1);
	  assertEquals(srchdItemTxt, item);
	
	}

	@Then("I should be in the “Amazon Devices” department")
	public void i_should_be_in_the_home_kitchen_department() {
	   assertEquals(select.getFirstSelectedOption().getText(), "Amazon Devices");
	}
}
