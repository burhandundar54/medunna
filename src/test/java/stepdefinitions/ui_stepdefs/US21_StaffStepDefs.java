package stepdefinitions.ui_stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.US21_StaffPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class US21_StaffStepDefs {

    US21_StaffPage us21_StaffPage =new US21_StaffPage();

    @Given("user is on the main page")
    public void userIsOnTheHomepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
    }

    @Given("user sign-in as staff")
    public void user_sign_in_as_admin() {
        Driver.waitAndClick(us21_StaffPage.accountMenuButton);
        Driver.waitAndClick(us21_StaffPage.signinButton);
        Driver.waitAndSendText(us21_StaffPage.usernameTextBox,"staffbulent");
        Driver.waitAndSendText(us21_StaffPage.passwordTextBox,"St.bulent");
        Driver.waitAndClick(us21_StaffPage.submitButton);
    }

    @Given("user selects Search Patient option from MYPAGES dropdown")
    public void user_selects_Search_Patient_option_from_MYPAGES_dropdown() {
        Driver.waitAndClick(us21_StaffPage.myPagesButton);
        Driver.waitAndClick(us21_StaffPage.searchPatientButton);
    }

    @Given("user clicks show appointments button")
    public void user_clicks_show_appointments_button() {
        Driver.waitAndClick(us21_StaffPage.showAppointmentsButton);
    }
    @Then("user verifies that there is no Delete button")
    public void user_verifies_that_there_is_no_delete_button() {
        Driver.wait(3);
        for (WebElement each:us21_StaffPage.allButtons){
            String s=each.getText();
            System.out.println(s);
            Assert.assertFalse(each.getText().equalsIgnoreCase("Delete"));
        }
    }


    @Given("user clicks edit button")
    public void user_clicks_edit_button() {
        Driver.waitAndClick(us21_StaffPage.editButton);
    }
    @Given("user clicks status dropdown")
    public void user_clicks_status_dropdown() {
        Driver.waitAndClick(us21_StaffPage.statusDropdown);
    }
    @Then("user verifies UNAPPROVED PENDING and CANCELLED options are selectable")
    public void user_verifies_unapproved_pending_and_cancelled_options_are_selectable() {
        Driver.wait(1);
        Driver.selectByValue(us21_StaffPage.statusDropdown,"UNAPPROVED");
        Assert.assertTrue(us21_StaffPage.unapprovedOption.isSelected());

        Driver.wait(2);
        Driver.selectByValue(us21_StaffPage.statusDropdown,"PENDING");
        Assert.assertTrue(us21_StaffPage.pendingOption.isSelected());

        Driver.wait(2);
        Driver.selectByValue(us21_StaffPage.statusDropdown,"CANCELLED");
        Assert.assertTrue(us21_StaffPage.canceledOption.isSelected());

    }
    @Then("user verifies COMPLETED option is not selectable")
    public void user_verifies_completed_option_is_not_selectable() {
        Driver.wait(2);
        Driver.selectByValue(us21_StaffPage.statusDropdown,"COMPLETED");
        Assert.assertTrue(!us21_StaffPage.completedOption.isSelected());
    }

    @Given("user leaves Anamnesis Treatment and Diagnosis fields {string}")
    public void user_leaves_anamnesis_treatment_and_diagnosis_fields(String string) {
        Driver.waitAndSendText(us21_StaffPage.anamnesisTextBox,string);
        Driver.wait(1);
        Driver.waitAndSendText(us21_StaffPage.treatmentTextBox,string);
        Driver.wait(1);
        Driver.waitAndSendText(us21_StaffPage.diagnosisTextBox,string);
    }

    @Then("user clicks-on save button")
    public void user_clicks_on_save_button() {
        Driver.wait(1);
        Driver.waitAndClick(us21_StaffPage.saveButton);
    }


    @Then("user verifies updated message")
    public void user_Verifies_Updated_Message() {
        Driver.wait(3);
        Assert.assertTrue(us21_StaffPage.updatedMessage.isDisplayed());
    }

    @Given("user clicks physician dropdown")
    public void user_clicks_physician_dropdown() {
       Driver.waitAndClick(us21_StaffPage.physicianDropdown);
    }
    @Given("user selects physician from dropdown menu")
    public void user_selects_physician_from_dropdown_menu() {
        Driver.selectByIndex(us21_StaffPage.physicianDropdown,3);
    }
    @Then("user verifies physician is selected")
    public void user_verifies_physician_is_selected() {
        Driver.wait(2);
        Assert.assertTrue(us21_StaffPage.doctor79.isSelected());
    }

    @Given("user clicks show tests button")
    public void user_clicks_show_tests_button() {
        Driver.waitAndClick(us21_StaffPage.showTestsButton);
    }

    @Then("user verifies Tests page is displayed")
    public void user_verifies_tests_page_is_displayed() {
        Driver.wait(3);
        Assert.assertTrue(us21_StaffPage.testsPage.isDisplayed());
    }









}
