package stepdefinitions.ui_stepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.US17AdminPage;
import pojos.CTestItem;
import utilities.Driver;

import static utilities.DateUtils.getDate;
import static utilities.WriteToTxt.saveDeletedTestItem;
import static utilities.WriteToTxt.saveTestItemInfo;

public class US17UIAdminStepDefs {

    US17AdminPage us17AdminPage=new US17AdminPage();
    Faker faker=new Faker();
    CTestItem cTestItem = new CTestItem();

    @Given("user sign-in as admin")
    public void user_sign_in_as_admin() {
        Driver.waitAndClick(us17AdminPage.accountMenuButton);
        Driver.waitAndClick(us17AdminPage.signinButton);
        Driver.waitAndSendText(us17AdminPage.usernameTextBox,"adminbulent");
        Driver.waitAndSendText(us17AdminPage.passwordTextBox,"12345as");
        Driver.waitAndClick(us17AdminPage.submitButton);
    }

    @Given("user selects test item from items-titles dropdown")
    public void user_selects_test_item_from_items_titles_dropdown() {
        Driver.waitAndClick(us17AdminPage.itemsTitlesButton);
        Driver.waitAndClick(us17AdminPage.testItemButton);
    }

    @Given("user clicks create a new test item button")
    public void user_clicks_create_a_new_test_item_button() {
        Driver.waitAndClick(us17AdminPage.createTestItemButton);
    }

    @Then("user verifies name field is displayed")
    public void user_verifies_name_field_is_displayed() {
        Assert.assertTrue(us17AdminPage.nameLabel.isDisplayed());
    }
    @Then("user provides name")
    public void user_provides_name() {
        String name=faker.name().firstName()+"xtest";
        cTestItem.setName(name);
        Driver.waitAndSendText(us17AdminPage.nameTextBox,name);

    }
    @Then("user verifies description field is displayed")
    public void user_verifies_description_field_is_displayed() {
        Assert.assertTrue(us17AdminPage.descriptionLabel.isDisplayed());
    }
    @Then("user provides description")
    public void user_provides_description() {
        String description="mg/dL";
        cTestItem.setDescription(description);
        Driver.waitAndSendText(us17AdminPage.descriptionTextBox,description);

    }
    @Then("user verifies price field is displayed")
    public void user_verifies_price_field_is_displayed() {
        Assert.assertTrue(us17AdminPage.priceLabel.isDisplayed());
    }
    @Then("user provides price")
    public void user_provides_price() {
        String price=faker.number().numberBetween(20,120)+"";
        cTestItem.setPrice(price);
        Driver.waitAndSendText(us17AdminPage.priceTextBox,price);

    }
    @Then("user verifies min value field is displayed")
    public void user_verifies_min_value_field_is_displayed() {
        Assert.assertTrue(us17AdminPage.defaultValMinLabel.isDisplayed());
    }
    @Then("user provides min value")
    public void user_provides_min_value() {
        String minvalue=faker.number().numberBetween(40,70)+"";
        cTestItem.setDefaultValMin(minvalue);
        Driver.waitAndSendText(us17AdminPage.minValueTextBox,minvalue);
    }
    @Then("user verifies max value field is displayed")
    public void user_verifies_max_value_field_is_displayed() {
        Assert.assertTrue(us17AdminPage.defaultValMaxLabel.isDisplayed());
    }
    @Then("user provides max value")
    public void user_provides_max_value() {
        String maxValue=faker.number().numberBetween(70,200)+"";
        cTestItem.setDefaultValMax(maxValue);
        Driver.waitAndSendText(us17AdminPage.maxValueTextBox,maxValue);
    }
    @Then("user verifies created date field is displayed")
    public void user_verifies_created_date_field_is_displayed() {
        Assert.assertTrue(us17AdminPage.createdDateLabel.isDisplayed());
    }
    @Then("user enters current date")
    public void user_enters_current_date() {
        cTestItem.setCreatedDate(getDate());
        Driver.waitAndSendText(us17AdminPage.createdDateBox,getDate());
    }

    @And("user saves the test item records created with ui")
    public void userSavesTheTestItemRecordsCreatedWithUi() {
        saveTestItemInfo(cTestItem);
    }

    @Then("user clicks save button")
    public void user_clicks_save_button() {
        Driver.waitAndClick(us17AdminPage.saveButton);
    }

    @Then("user verifies that created message is displayed")
    public void verifies_that_created_message_is_displayed() {
        Driver.wait(3);
        Assert.assertTrue(us17AdminPage.createdMessage.isDisplayed());
    }

    @Given("user clicks the view button of an item")
    public void user_clicks_the_view_button_of_an_item() {
        Driver.waitAndClick(us17AdminPage.viewButton);
    }
    @Then("user verifies that item info is displayed")
    public void user_verifies_that_item_info_is_displayed() {
        Driver.wait(3);
        Assert.assertTrue(us17AdminPage.testItemInfoHeader.getText().contains("Test Item"));
    }

    @Given("user clicks the delete button of an item")
    public void user_clicks_the_delete_button_of_an_item() {
        Driver.waitAndClick(us17AdminPage.lastPage);
//        Actions actions = new Actions(Driver.getDriver());
//        actions.sendKeys(Keys.PAGE_UP).perform();
        Driver.wait(3);
        Driver.clickWithJS(us17AdminPage.deleteButton);
        Driver.clickWithJS(us17AdminPage.confirmDeleteButton);
    }

    @Then("user verifies that deleted message is displayed")
    public void user_verifies_that_deleted_message_is_displayed() {
        Driver.wait(3);
        Assert.assertTrue(us17AdminPage.deletedMessage.isDisplayed());
        String message=us17AdminPage.deletedMessage.getText();
        saveDeletedTestItem(message);
    }



}
