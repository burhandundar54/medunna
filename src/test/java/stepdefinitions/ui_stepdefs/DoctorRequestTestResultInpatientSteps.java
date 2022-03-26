package stepdefinitions.ui_stepdefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DoctorPage;
import pages.HomePage;
import pages.SignInPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.io.IOException;
public class DoctorRequestTestResultInpatientSteps {
    DoctorPage doctorPage = new DoctorPage();
    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();
    @Given("Doctor is on home page")
    public void doctor_is_on_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }
    @Given("Doctor navigate to login page")
    public void doctor_navigate_to_login_page() {
        Driver.waitAndClick(homePage.accountMenu);
        Driver.waitAndClick(homePage.signIn);
    }
    @Then("capture the screenshot")
    public void capture_the_screenshot() throws IOException {
        ReusableMethods.getScreenshot("screenshots");
    }
    @Given("Doctor provide valid {string} and {string}")
    public void doctor_provide_valid_and(String username, String password) {
        signInPage.userName.sendKeys(username);
        signInPage.password.sendKeys(password);
    }
    @Then("Doctor clicks on the sign in button")
    public void doctor_clicks_on_the_sign_in_button() {
        Driver.waitAndClick(signInPage.signIn);
    }
    @Then("Doctor clicks on My Pages dropdown")
    public void doctor_clicks_on_my_pages_dropdown() {
        Driver.wait(2);
        Driver.waitAndClick(doctorPage.mypages);
    }
    @Then("Doctor clicks on My Appointments")
    public void doctor_clicks_on_my_appointments() {
        Driver.wait(2);
        Driver.waitAndClick(doctorPage.myappointment);
    }
    @Then("Doctor clicks on Edit for patient button")
    public void doctor_clicks_on_edit_for_patient_button() {
        Driver.wait(2);
        Driver.waitAndClick(doctorPage.edit);
    }
    @Then("Doctor clicks on Show Test Result button")
    public void doctor_clicks_on_show_test_result_button() {
        Driver.wait(3);
        Driver.waitAndClick(doctorPage.showTestResult);
    }
    @Then("Doctor clicks on View Result button")
    public void doctor_clicks_on_view_result_button() {
        Driver.wait(3);
        Driver.waitAndClick(doctorPage.viewResultButton);
    }
    @Then("Doctor should see and verify all test information")
    public void doctor_should_see_and_verify_all_test_information() throws IOException {
        Driver.wait(3);
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.ID,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.Name,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.DefaultMinValue,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.DefaultMaxValue,3).isDisplayed());
//        Assert.assertTrue(Driver.waitForVisibility(doctorPage.Test,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.Description,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.Date,3).isDisplayed());
        ReusableMethods.getScreenshot("Row is visible");
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.IdColumn,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.NameColumn,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.DefaultMinValueColumn,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.DefaultMaxValueColumn,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.TestColumn,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.DescriptionColumn,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.DateColumn,3).isDisplayed());
    }
    @And("Doctor clicks on Request Impatient button")
    public void doctorClicksOnRequestImpatientButton() {
        Driver.wait(3);
        Driver.waitAndClick(doctorPage.RequestInpatientButton);
    }
    @Then("Doctor Verifies message {string}")
    public void doctorVerifiesMessage(String message) {
        Driver.wait(3);
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.message,3).isDisplayed());
    }
    @Then("Doctor clicks on Sign out button")
    public void doctorClicksOnSignOutButton() {
        Driver.wait(3);
        Driver.waitAndClick(homePage.accountMenu);
        Driver.waitAndClick(doctorPage.signout);
        Driver.wait(3);
    }
}
