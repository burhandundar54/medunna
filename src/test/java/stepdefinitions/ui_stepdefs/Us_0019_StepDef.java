package stepdefinitions.ui_stepdefs;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPages;
import pages.SignInPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import java.security.Key;
import java.util.List;
public class Us_0019_StepDef {
    CommonPages commonPages = new CommonPages();
    SignInPage signInPage = new SignInPage();
    @Then("User verifies login is success as admin")
    public void user_verifies_login_is_success_as_admin() {
        Driver.wait(2);
        Assert.assertTrue(commonPages.administration.isDisplayed());
    }
    @Then("User clicks on items&titles")
    public void user_clicks_on_items_titles() {
        Driver.wait(2);
        Driver.waitAndClick(commonPages.itemtAnditles);
    }
    @Then("User clicks on staff")
    public void user_clicks_on_staff() {
        Driver.wait(2);
        Driver.waitAndClick(commonPages.staff);
    }
    @Then("User clicks on Create a new Staff button")
    public void user_clicks_on_create_a_new_staff_button() {
        Driver.wait(2);
        Driver.waitAndClick(commonPages.createANewStaff);
    }
    @Then("User provides SSN of registered person {string}")
    public void user_provides_ssn_of_registered_person(String ssn) {
        Driver.wait(2);
        Driver.waitAndSendText(commonPages.ssnTextBox, ssn);
    }
    @Then("User clicks and puts check mark on Use Search checkbox")
    public void user_clicks_and_puts_check_mark_on_use_search_checkbox() {
        Driver.wait(2);
        Driver.waitAndClick(commonPages.useSearchCheckBox);
    }
    @Then("User clicks on Search User button")
    public void user_clicks_on_search_user_button() {
        Driver.wait(2);
        Driver.waitAndClick(commonPages.searchUserButton);
    }
    @Then("User verifies User found with search SSN message")
    public void user_verifies_user_found_with_search_ssn_message() {
        Driver.wait(2);
        Assert.assertEquals("User found with search SSN",commonPages.successMessageToast.getText());
    }
    @Then("user clicks user dropdown and verifies if user can select user from the existing users")
    public void user_clicks_user_dropdown_and_verifies_if_user_can_select_user_from_the_existing_users() {
        Select userdrop = new Select(commonPages.userDropdown);
        Driver.wait(2);
        Driver.selectByVisibleText(commonPages.userDropdown,"useremre");
        Driver.wait(2);
        System.out.println(userdrop.getFirstSelectedOption().getText());
        Driver.wait(2);
        Assert.assertTrue(userdrop.getFirstSelectedOption().getText().equals("useremre"));
    }
    @Then("User should proceed to second page")
    public void user_should_proceed_to_second_page() {
        String url = "https://www.medunna.com/staff?page=2&sort=id,asc";
        Driver.wait(1);
        Driver.getDriver().navigate().to(url);
        Driver.wait(1);
        signInPage.userName.sendKeys("admemre");
        Driver.wait(1);
        signInPage.password.sendKeys("1234");
        Driver.wait(1);
        signInPage.signIn.click();
    }
    @Then("User clicks on edit button")
    public void user_clicks_on_edit_button() {
        Driver.wait(1);
        Driver.waitAndClick(commonPages.stafEmreEditButton);
    }
    @Then("User edits description")
    public void user_provides_description() {
        Driver.wait(2);
        if(commonPages.descriptionTextBox.getAttribute("value").isEmpty()){
            Driver.wait(2);
            commonPages.descriptionTextBox.sendKeys("technician");
        }else{
            Driver.wait(2);
            if(commonPages.descriptionTextBox.getAttribute("value").equals("nurse")){
                Driver.wait(2);
                commonPages.descriptionTextBox.clear();
                Driver.wait(2);
                commonPages.descriptionTextBox.sendKeys("technician");
            }else{
                Driver.wait(2);
                commonPages.descriptionTextBox.clear();
                Driver.wait(2);
                commonPages.descriptionTextBox.sendKeys("nurse");
            }
        }
    }
    @Then("User clicks save button and verify success message")
    public void user_clicks_save_button_and_verify_success_message() {
        Actions actions = new Actions(Driver.getDriver());
        Driver.wait(2);
        int i;
        for( i=1; i<=10; i++){
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        Driver.wait(2);
        Driver.waitAndClick(commonPages.saveButton);
        Driver.wait(2);
        Assert.assertTrue(commonPages.editSuccessMessage.isDisplayed());
    }
    @Then("User deletes description")
    public void user_deletes_description() {
        Driver.wait(2);
        if (commonPages.descriptionTextBox.getAttribute("value").isEmpty()) {
            Driver.wait(2);
            commonPages.descriptionTextBox.sendKeys("technician");
            Driver.wait(2);
            Driver.waitAndClick(commonPages.saveButton);
            Driver.wait(5);
            Driver.waitAndClick(commonPages.stafEmreEditButton);
            Driver.wait(2);
            commonPages.descriptionTextBox.clear();
//            Driver.wait(2);
//            Driver.waitAndClick(commonPages.saveButton);
//            Driver.wait(2);
//            Assert.assertTrue(commonPages.editSuccessMessage.isDisplayed());
        }else {
            Driver.wait(2);
            commonPages.descriptionTextBox.clear();
//            Driver.waitAndClick(commonPages.saveButton);
//            Driver.wait(2);
//            Assert.assertTrue(commonPages.editSuccessMessage.isDisplayed());
        }
    }
}
