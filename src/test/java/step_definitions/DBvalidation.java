package step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import craterPagesPOM.CommonPOM;
import craterPagesPOM.ItemsPOM;
import craterPagesPOM.LoginPOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BrowserUtils;
import utils.DButils;
import utils.DataReader;
import utils.Driver;

public class DBvalidation {
	LoginPOM login = new LoginPOM();
	CommonPOM common = new CommonPOM();
	ItemsPOM items = new ItemsPOM();
	BrowserUtils browser = new BrowserUtils();
	DButils db = new DButils();
	List<String> recordData;
	String item = "Detergent";

//  Scenario: UI to Database Validation

	@Given("I'm On the Crater App homepage")
	public void i_m_on_the_crater_app() {
		Driver.getDriver().get(DataReader.getData("craterUrl"));
		login.craterLogin1();

	}

	@Given("I create an item")
	public void i_create_an_item() {
		common.itemsTab.click();
		items.addItemBtn.click();
		item = item + browser.randomNumber();
		items.nameField.sendKeys(item);
		browser.clearTextOfTheFieldWindows(items.priceField);
		items.priceField.sendKeys("12000");
		items.unitField.click();
		items.unitFieldbox.click();
		items.descriptionField.sendKeys("Persil Detergent");
		items.saveItemBtn.click();

	}

	@When("I go to the database, and query from the Item created")
	public void i_go_to_the_database_and_query_from_the_item_created() {
		 recordData = db.selectArecord("select * from items where name='"+item+"'");
		for(int i=0; i<recordData.size(); i++) {
			System.out.println(recordData.get(i));
		}

	}

	@Then("the retreived data should match the information I have provided on UI")
	public void the_retreived_data_should_match_the_information_i_have_provided_on_ui() {
		assertEquals(recordData.get(1), item);
		assertEquals(recordData.get(3), "12000");

	}

	@When("I update the Item on the UI")
	public void i_update_the_item_on_the_ui() {
		
		WebElement addedItem = Driver.getDriver().findElement(By.xpath("//a[text()='"+item+"']"));
		addedItem.click();
		browser.clearTextOfTheFieldWindows(items.priceField);
		items.priceField.sendKeys("1200");
		items.updateItemBtn.click();

	}

	@Then("if I come back to database the update should be in effect")
	public void if_i_come_back_to_database_the_update_should_be_in_effect() {
		//after update
		recordData = db.selectArecord("select * from items where name='"+item+"'");
		assertEquals(recordData.get(3), "1200");

	}

	@When("delete the Item on the UI")
	public void delete_the_item_on_the_ui() {
		items.threeDotsBtn.click();
		items.ItemDeleteBtn.click();
		items.deleteOkButton.click();
		browser.waitUntilElementVisible(items.itemDeletedMsg);
		assertTrue(items.itemDeletedMsg.isDisplayed());

	}

	@Then("if I come back to database, the Item should no longer exist")
	public void if_i_come_back_to_database_the_item_should_no_longer_exist() {
		recordData = db.selectArecord("select * from items where name='"+item+"'");
		assertTrue(recordData.size()==0);

	}

//  --------------------------------------------------

//	Scenario: Database to UI Validation

	@When("I update the Item on the database")
	public void i_update_the_item_on_the_databas() {
		db.updateRecord("update items set price = 1300 where name ='"+item+"' ");
		

	}

	@Then("if I come back to UI the update should be in effect")
	public void if_i_come_back_to_ui_the_update_should_be_in_effect() {
		Driver.getDriver().navigate().refresh();
		assertEquals(items.addedItemPrice.getText(), "$ 13.00");

	}

	@When("delete the Item on the database")
	public void delete_the_item_on_the_database() {
		db.deleteRecord("delete from items where name='"+item+"'");

	}

	@Then("if I come back to UI, the Item should no longer exist")
	public void if_i_come_back_to_ui_the_item_should_no_longer_exist() {
		Driver.getDriver().navigate().refresh();
		assertEquals(Driver.getDriver().findElements(By.xpath("//a[text()='"+item+"']")).size(), 0);

	}

}
