package stepdefinitions.ui_stepdefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.EditAppointmentPage;
import pages.HomePage;
import pages.SignInPage;
import utilities.ConfigurationReader;
import utilities.Driver;
public class EditAppointmentSteps {

    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();

    EditAppointmentPage editAppointmentPage=new EditAppointmentPage();
    @Given("User is on home page")
    public void user_is_on_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }
    @Given("User navigate to login page")
    public void user_navigate_to_login_page() {
        Driver.waitAndClick(homePage.accountMenu);
        Driver.waitAndClick(homePage.signIn);
    }
    @Given("User provide valid {string} and {string}")
    public void user_provide_valid_and(String username, String password) {
        signInPage.userName.sendKeys(username);
        signInPage.password.sendKeys(password);
    }
    @And("User clicks on My Pages")
    public void userClicksOnMyPages() {
        Driver.waitAndClick(editAppointmentPage.mypages);
    }
    @And("User clicks on My Appointment")
    public void userClicksOnMyAppointment() {
        Driver.waitAndClick(editAppointmentPage.myappointment);
    }
    @And("User Clicks Edit button")
    public void userClicksEditButton() {
        Driver.waitAndClick(editAppointmentPage.edit);
    }
    @Given("user provide status {string}")
    public void user_provide_status(String status) {
        Driver.wait(3);
        Driver.selectByValue(editAppointmentPage.status,status);
//        editAppointment.setStatus(status);
//        Driver.waitAndSendText(editAppointmentPage.status,status);
    }
    @Given("user provide anamnesis {string}")
    public void user_provide_anamnesis(String anamnesis) {
        Driver.wait(2);
        editAppointmentPage.anamnesis.clear();
        Driver.wait(2);
        editAppointmentPage.anamnesis.click();
        Driver.waitAndSendText(editAppointmentPage.anamnesis,anamnesis);
    }
    @Given("user provide treatment {string}")
    public void user_provide_treatment(String treatment) {
        Driver.wait(2);
        editAppointmentPage.treatment.clear();
        Driver.wait(2);
        editAppointmentPage.treatment.click();
        Driver.waitAndSendText(editAppointmentPage.treatment,treatment);
    }
    @Given("user provide diagnosis {string}")
    public void user_provide_diagnosis(String diagnosis) {
        Driver.wait(2);
        editAppointmentPage.diagnosis.clear();
        Driver.wait(2);
        editAppointmentPage.diagnosis.click();
        Driver.waitAndSendText(editAppointmentPage.diagnosis,diagnosis);
    }
    @Given("User click on Save")
    public void user_click_on_save() {
        Driver.waitAndClick(editAppointmentPage.save);
    }
    @Then("User verifies success message {string}")
    public void userVerifiesSuccessMessage(String message) {
        Assert.assertTrue(Driver.waitForVisibility(editAppointmentPage.successmessage,5).isDisplayed());
    }
    @And("User clicks Sign out button")
    public void userClicksSignOutButton() {
        Driver.wait(3);
        Driver.waitAndClick(homePage.accountMenu);
        Driver.waitAndClick(editAppointmentPage.signout);
    }

    @And("User clicks Sign in")
    public void userClicksSignIn() {
        Driver.waitAndClick(signInPage.signIn);
    }
}
