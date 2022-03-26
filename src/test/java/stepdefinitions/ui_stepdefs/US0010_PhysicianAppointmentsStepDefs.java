package stepdefinitions.ui_stepdefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.US0010_PhysicianAppointmentsPage;
import pages.US0010_SignInPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
public class US0010_PhysicianAppointmentsStepDefs {
    US0010_SignInPage signInPage= new US0010_SignInPage();
    US0010_PhysicianAppointmentsPage physicianAppointmentsPage = new US0010_PhysicianAppointmentsPage();
    @Given("user is on the homepage")
    public void userIsOnTheHomepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
    }
    @When("user clicks human icon")
    public void userClicksHumanIcon() {
        signInPage.human_icon.click();
    }
    @And("user clicks sigin button")
    public void userClicksSiginButton() {
        signInPage.signin_text.click();
    }
    @Then("user verifies signin page")
    public void userVerifiesSigninPage() {
        Driver.waitForVisibility(signInPage.signinverify,3).isDisplayed();
        // Driver.wait(3);
        // assertTrue(signInPage.signinverify.isDisplayed());
    }
    @And("user is sign in as a physician username {string} and password {string}")
    public void userIsSignInAsAPhysicianUsernameAndPassword(String username, String password) {
        signInPage.username_textbox.sendKeys(username);
        signInPage.password_textbox.sendKeys(password);
        signInPage.signin_button.click();
    }
    @Then("user verifies the physician's page")
    public void userVerifiesThePhysicianSPage() {
        Driver.waitForVisibility(physicianAppointmentsPage.mypages,3).isDisplayed();
        // Driver.wait(3);
        // assertTrue(physicianAppointmentsPage.mypages.isDisplayed());
    }
    @Given("user clicks MyPages and select My Appointments from dropdown")
    public void user_clicks_my_pages_and_select_my_appointments_from_dropdown() {
        Driver.waitAndClick(physicianAppointmentsPage.mypages);
        Driver.waitAndClick(physicianAppointmentsPage.myappointments);
    }
    @Then("user verifies the My Appointments page")
    public void user_verifies_the_my_appointments_page() {
        assertTrue(Driver.getDriver().getCurrentUrl().contains("appointment"));
    }
    @Then("user verifies can see their appointments list and time slots on My Appointments")
    public void user_verifies_can_see_their_appointments_list_and_time_slots_on_my_appointments() {
        Driver.wait(3);
        assertTrue(physicianAppointmentsPage.fromdate.isDisplayed());
        assertTrue(physicianAppointmentsPage.todate.isDisplayed());
        Driver.wait(3);
        assertTrue(physicianAppointmentsPage.appointments_text_verify.isDisplayed());
    }
    @Then("user verifies the user can see patient id, start date, end date, status…")
    public void userVerifiesTheUserCanSeePatientIdStartDateEndDateStatus() {
        List<String > expected_tablelist= Arrays.asList("ID","Start DateTime","End DateTime", "Status","Anamnesis" ,"Treatment","Diagnosis","Prescription","Description","Created Date","Physician","Patient","");
        List<String> actual_tablelist= new ArrayList<>();
        for(WebElement x: physicianAppointmentsPage.table_head_list) {
            actual_tablelist.add(x.getText());
        }
        assertEquals(expected_tablelist,actual_tablelist);
    }
    @And("user closes the page")
    public void userClosesThePage() {
        //Driver.getDriver().close();
    }
}