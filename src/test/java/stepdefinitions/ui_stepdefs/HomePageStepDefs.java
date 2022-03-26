package stepdefinitions.ui_stepdefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.HomePage;
import pages.SettingsPage;
import pages.SignInPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class HomePageStepDefs {
    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();
    SettingsPage settingsPage = new SettingsPage();
    @Given("User is on the main page")
    public void user_is_on_the_main_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }
    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
        Driver.waitAndClick(homePage.accountMenu);
        Driver.waitAndClick(homePage.signIn);
    }
    @Then("Verify if user is on the sign in page")
    public void verify_if_user_is_on_the_sign_in_page() {
        Driver.wait(2);
        assertTrue(signInPage.signInText.isDisplayed());
    }
    @Given("User provides valid as {string} and {string}")
    public void user_provides_valid_and(String username, String password) {
        Driver.waitAndSendText(signInPage.userName,username);
        Driver.waitAndSendText(signInPage.password,password);
    }
    @Given("User click Sign in button")
    public void user_click_sign_in_button() {
        Driver.waitAndClick(signInPage.signIn);
    }
    @When("User clicks on account menu")
    public void user_clicks_on_account_menu() {
        Driver.waitAndClick(homePage.accountMenu);
    }
    @When("User clicks on settings")
    public void user_clicks_on_settings() {
        Driver.waitAndClick(settingsPage.settings);
    }
    @When("User clicks on firstnamebox and clears")
    public void user_clicks_on_firstnamebox_and_clears() {
        Driver.waitAndClick(settingsPage.firstNameBox);
        Driver.wait(1);
        settingsPage.firstNameBox.clear();
    }
    @When("User updates firstname as {string}")
    public void user_updates_name_as(String firstname) {
        Driver.waitAndSendText(settingsPage.firstNameBox,firstname);
    }
    @When("User clicks on save button")
    public void user_clicks_on_save_button() {
        Driver.waitAndClick(settingsPage.saveButton);
    }
    @When("User verifies the Settings saved! message")
    public void user_verifies_the_settings_saved_message() {
        Driver.wait(3);
        assertTrue(settingsPage.settingsSavedMsg.isDisplayed());
    }
    @When("User clicks on lastnamebox and clears")
    public void user_clicks_on_lastnamebox_and_clears() {
        Driver.waitAndClick(settingsPage.lastNameBox);
        Driver.wait(1);
        settingsPage.lastNameBox.clear();
    }
    @When("User updates lastname as {string}")
    public void user_updates_lastname_as(String lastname) {
        Driver.waitAndSendText(settingsPage.lastNameBox,lastname);
    }
    @Then("Close the application")
    public void close_the_application() {
        Driver.wait(3);
        Driver.closeDriver();
    }
    @When("User clicks on emailbox and clears")
    public void user_clicks_on_emailbox_and_clears() {
        Driver.wait(3);
        settingsPage.emailBox.clear();
    }
    @When("User updates email as {string}")
    public void user_updates_email_as(String email) {
        Driver.waitAndSendText(settingsPage.emailBox,email);
    }
    @When("User verifies the Your first name is required. message")
    public void user_verifies_the_your_first_name_is_required_message() {
        Driver.wait(3);
        assertTrue(settingsPage.firstNameRequiredMessage.isEnabled());
    }
    @When("User verifies the Your last name is required. message")
    public void user_verifies_the_your_last_name_is_required_message() {
        Driver.wait(3);
        assertTrue(settingsPage.lastNameRequiredMessage.isEnabled());
    }
    @When("User verifies This field is invalid message")
    public void user_verifies_this_field_is_invalid_message() {
        Driver.wait(3);
        assertTrue(settingsPage.thisFieldInvalidMsgForEmail.isEnabled());
    }
    @Then("user clicks make an appointment button")
    public void user_clicks_make_an_appointment_button() {
        Driver.waitAndClick(homePage.makeAppointmentButton);
    }
    @Then("user clear the date box and enters a valid date")
    public void user_clear_the_date_box_and_enters_a_valid_date() {
        Driver.waitAndClick(homePage.dateBox);
        homePage.dateBox.clear();
        homePage.dateBox.sendKeys(Keys.ARROW_RIGHT);
        homePage.dateBox.clear();
        homePage.dateBox.sendKeys(Keys.ARROW_RIGHT);
        homePage.dateBox.clear();
        //homePage.dateBox.sendKeys(Keys.ARROW_RIGHT);
        homePage.dateBox.sendKeys(Keys.ARROW_LEFT);
        homePage.dateBox.sendKeys(Keys.ARROW_LEFT);
        //Driver.wait(2);
        Driver.waitAndSendText(homePage.dateBox,"20042022");
    }
    @Then("verifies that the invalid date message does not appear")
    public void verifies_that_the_invalid_date_message_does_not_appear() {
        Driver.wait(5);
//        Assert.assertEquals("",homePage.appoinmentDateCanNotBePastMessage.getText());
//        Assert.assertTrue(homePage.appoinmentDateCanNotBePastMessage == null);
//        Assert.assertFalse(homePage.appoinmentDateCanNotBePastMessage.isEnabled());
        String pageSource = Driver.getDriver().getPageSource();
        boolean result = pageSource.contains("Appointment date can not be past date!");
//        assertTrue(result == false);
        assertFalse(result);
    }
    @Then("user clear the date box and enters a past date")
    public void user_clear_the_date_box_and_enters_a_past_date() {
        Driver.waitAndClick(homePage.dateBox);
        homePage.dateBox.clear();
        homePage.dateBox.sendKeys(Keys.ARROW_RIGHT);
        homePage.dateBox.clear();
        homePage.dateBox.sendKeys(Keys.ARROW_RIGHT);
        homePage.dateBox.clear();
        homePage.dateBox.sendKeys(Keys.ARROW_RIGHT);
        homePage.dateBox.sendKeys(Keys.ARROW_LEFT);
        homePage.dateBox.sendKeys(Keys.ARROW_LEFT);
        Driver.wait(2);
        Driver.waitAndSendText(homePage.dateBox,"05052020");
    }
    @And("verifies that the invalid date message visible")
    public void verifiesThatTheInvalidDateMessageVisible() {
        Driver.wait(3);
        assertTrue(homePage.appoinmentDateCanNotBePastMessage.isDisplayed());
    }
    @Then("the order of date should be mm_dd_yyyy format")
    public void the_order_of_date_should_be_mm_dd_yyyy_format() {
        Driver.waitAndClick(homePage.dateBox);
        homePage.dateBox.clear();
        homePage.dateBox.sendKeys(Keys.ARROW_RIGHT);
        homePage.dateBox.clear();
        homePage.dateBox.sendKeys(Keys.ARROW_RIGHT);
        homePage.dateBox.clear();
        homePage.dateBox.sendKeys(Keys.ARROW_RIGHT);
        homePage.dateBox.sendKeys(Keys.ARROW_LEFT);
        homePage.dateBox.sendKeys(Keys.ARROW_LEFT);
        Driver.wait(2);
        String dateFormat = homePage.dateBox.getText();
        Driver.wait(2);
        Assert.assertEquals(dateFormat,"mm/dd/yyyy");
    }
}