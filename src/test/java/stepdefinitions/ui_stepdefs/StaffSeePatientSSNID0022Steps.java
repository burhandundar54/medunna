package stepdefinitions.ui_stepdefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.Staff0022Page;
import utilities.ConfigurationReader;
import utilities.Driver;

public class StaffSeePatientSSNID0022Steps {

    Staff0022Page staffPage = new Staff0022Page();

    @Given("staff is on the home page")
    public void staff_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }
    @Given("staff navigates on login page")
    public void staff_navigates_on_login_page() {
        Driver.waitAndClick(staffPage.accountMenu);
        Driver.waitAndClick(staffPage.signIn);
    }
    @Given("staff provides valid {string} and {string}")
    public void staff_provides_valid_and(String username1, String password1) {
        staffPage.username.sendKeys(username1);
        staffPage.password.sendKeys(password1);
    }
    @Given("staff clicks Sign in button")
    public void staff_clicks_sign_in_button() {
        Driver.waitAndClick(staffPage.signInButton);
    }
    @Given("staff clicks on my pages dropdown")
    public void staff_clicks_on_my_pages_dropdown() {
        Driver.wait(3);
        staffPage.mypagesstaff.click();
    }
    @Given("staff clicks on search patient")
    public void staff_clicks_on_search_patient() {
        Driver.wait(2);
        Driver.waitAndClick(staffPage.searchpatientstaff);
    }
    @Given("staff clicks on patient SSN box")
    public void staff_clicks_on_patient_ssn_box() {
        Driver.wait(2);
        Driver.waitAndClick(staffPage.patientssnbox);
    }
    @Given("staff provides {string}")
    public void staff_provides(String SSN) {
        staffPage.patientssnbox.sendKeys(SSN);
    }
    @Then("staff verifies patient")
    public void staff_verifies_patient() {
        Driver.wait(2);
        Assert.assertTrue(Driver.waitForVisibility(staffPage.firstrow,3).isDisplayed());
    }
    @Given("staff clicks on show appointments button")
    public void staff_clicks_on_show_appointments_button() {
        Driver.wait(3);
        Driver.waitAndClick(staffPage.showappoitnmentsbuttonstaff);
    }
    @Given("staff clicks on show test button")
    public void staff_clicks_on_show_test_button() {
        Driver.wait(3);
        Driver.waitAndClick(staffPage.showtestsbuttonstaff);
    }
    @Given("staff click on view results button")
    public void staff_click_on_view_results_button() {
        Driver.wait(3);
        Driver.waitAndClick(staffPage.viewresultsbuttonstaff);
    }
    @Given("staff edits test results")
    public void staff_edits_test_results() {
        Driver.wait(3);
        Driver.waitAndClick(staffPage.editbuttonstaff);
        Driver.wait(3);
        staffPage.resultbuttonstaff.clear();
        staffPage.resultbuttonstaff.sendKeys("75");
        staffPage.descriptionbuttonstaff.clear();
        staffPage.descriptionbuttonstaff.sendKeys("fine");
        Driver.waitAndClick(staffPage.savebuttonstaff);
    }
    @Then("staff verifies visibility of test")
    public void staff_verifies_visibility_of_test() {
        Driver.wait(3);
        Assert.assertTrue(Driver.waitForVisibility(staffPage.visibilityrowstaff,2).isDisplayed());
    }
    @Then("staff verifies visibility of test result")
    public void staffVerifiesVisibilityOfTestResult() {
        Driver.wait(3);
        Driver.waitAndClick(staffPage.editbuttonstaff);
        Driver.wait(3);
        Assert.assertTrue(Driver.waitForVisibility(staffPage.testIdboxstaff,2).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(staffPage.testdateboxstaff,2).isDisplayed());
        staffPage.resultbuttonstaff.clear();
        staffPage.resultbuttonstaff.sendKeys("75");
        staffPage.descriptionbuttonstaff.clear();
        staffPage.descriptionbuttonstaff.sendKeys("Fine");
        Assert.assertTrue(Driver.waitForVisibility(staffPage.testcreatedDateboxstaff,2).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(staffPage.testTestItemboxstaff,2).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(staffPage.testTestboxstaff,2).isDisplayed());
    }
    @Then("staff clicks on Sign out button")
    public void staffClicksOnSignOutButton() {
        Driver.wait(3);
        Driver.waitAndClick(staffPage.accountMenu);
        Driver.waitAndClick(staffPage.signOutButton);
        Driver.wait(3);
    }
}