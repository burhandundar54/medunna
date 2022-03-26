package stepdefinitions.ui_stepdefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.US09_SignInPage;
import pages.US14_DoctorPage;
import utilities.ConfigurationReader;
import utilities.Driver;
public class Us14_View_edit_Impatients_byDoctorStepDefs {
    US14_DoctorPage doctorPage = new US14_DoctorPage();
    US09_SignInPage signInPage = new US09_SignInPage();
    @When("user launch the browser")
    public void userLaunchTheBrowser() {
        Driver.getDriver();
    }
    @And("user navigate to home page")
    public void userNavigateToHomePage() {
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("base_url"));
    }
    @And("user verify home page is visible")
    public void userVerifyHomePageIsVisible() {
        String homePageTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("MEDUNNA", homePageTitle);
    }
    @And("user click PersonBox button")
    public void userClickPersonBoxButton() {
        doctorPage.PersonBox.click();
    }
    @And("user click signin button")
    public void userClickSigninButton() {
        Driver.waitAndClick(doctorPage.signinButton);
    }
    @And("user verifies signin to account is visible")
    public void userVerifiesSigninToAccountIsVisible() {
        Driver.wait(2);
        //      Assert.assertTrue(doctorPage.signinPage.isDisplayed());
    }
    @Given("Doctor provide valid {string}")
    public void doctorProvideValid(String username) {
        Driver.waitAndSendText(doctorPage.UserNameTextbox, username);
    }
    @Then("user provide valid {string}")
    public void userProvideValid(String password) {
        Driver.waitAndSendText(doctorPage.PasswordTextbox, password);
    }
    @And("user clicks signinlst button")
    public void userClicksSigninlstButton() {
        Driver.waitAndClick(signInPage.signinlastButton);
    }
    @Then("user verifies that signed in to doctor account")
    public void userVerifiesThatSignedInToDoctorAccount() {
        Driver.wait(2);
        Assert.assertTrue(signInPage.myPagesText.isDisplayed());
    }
    @Given("Doctor clicks on My Pages dropdowns")
    public void doctor_clicks_on_my_pages_dropdown() {
        Driver.waitAndClick(doctorPage.MyPageButton);
    }
    @Given("Doctor clicks on My InpatientButton")
    public void doctor_clicks_on_my_inpatient_button() {
        Driver.waitAndClick(doctorPage.MyInpatientsbutton);
    }
    @When("doctor clicks on from date for impatient box")
    public void doctorClicksOnFromDateForImpatientBox() {
        Driver.waitAndClick(doctorPage.fromDateTextBox);
    }
    @Then("doctor enters valid start date")
    public void doctorEntersValidStartDate() {
        Driver.waitAndSendText(doctorPage.fromDateTextBox,"08.03.2022");
        Driver.wait(2);
    }
    @Then("doctor clicks on end date of inpatient text box")
    public void doctorClicksOnEndDateOfInpatientTextBox() {
        Driver.waitAndClick(doctorPage.toDateTextBox);
    }
    @Then("doctor enters valid end date")
    public void doctorEntersValidEndDate() {
        Driver.waitAndSendText(doctorPage.toDateTextBox,"22.03.2022");
        Driver.wait(7);
    }
    @Then("Doctor should see and verify ID of InPatient information")
    public void doctorShouldSeeAndVerifyIDOfInPatientInformation() {
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.IDofInpatient, 4).isDisplayed());
    }
    @Then("Doctor should see and verify StartDate of InPatient information")
    public void doctorShouldSeeAndVerifyStartDateOfInPatientInformation() {
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.StartDateofInpatient, 3).isDisplayed());
    }
    @Then("Doctor should see and verify EndDate of InPatient information")
    public void doctorShouldSeeAndVerifyEndDateOfInPatientInformation() {
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.EndDateofInpatient, 3).isDisplayed());
    }
    @Then("Doctor should see and verify Status of InPatient information")
    public void doctorShouldSeeAndVerifyStatusOfInPatientInformation() {
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.StatusofInpatient, 3).isDisplayed());
    }
    @Then("Doctor should see and verify Description of InPatient information")
    public void doctorShouldSeeAndVerifyDescriptionOfInPatientInformation() {
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.DescriptionofInpatient, 3).isDisplayed());
    }
    @Then("Doctor should see and verify CreatedDate of InPatient information")
    public void doctorShouldSeeAndVerifyCreatedDateOfInPatientInformation() {
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.CreatedDateofInpatient, 3).isDisplayed());
    }
    @Then("Doctor should see and verify Room of InPatient information")
    public void doctorShouldSeeAndVerifyRoomOfInPatientInformation() {
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.RoomofInpatient, 3).isDisplayed());
    }
    @Then("Doctor should see and verify Appointment of InPatient information")
    public void doctorShouldSeeAndVerifyAppointmentOfInPatientInformation() {
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.AppointmentofInpatient, 3).isDisplayed());
    }
    @Given("Doctor clicks on Edit button for InPatients")
    public void doctor_clicks_on_edit_button_for_in_patients() {
        Driver.waitAndClick(doctorPage.EditButton);
    }
    @Then("Doctor clicks on StartDate text box")
    public void doctorClicksOnStartDateTextBox() {
        Driver.waitAndClick(doctorPage.StartDateTextBox);
    }
    @Then("Doctor provide valid Start date")
    public void doctorProvideValidStartDate() {
        Driver.waitAndSendText(doctorPage.StartDateTextBox,"26.03.2022");
    }
    @Then("doctor clicks on EndDate text box")
    public void doctorClicksOnEndDateTextBox() {
        Driver.waitAndClick(doctorPage.EndDateTextBox);
    }
    @Then("doctor provide valid End date")
    public void doctorProvideValidEndDate() {
        Driver.waitAndSendText(doctorPage.EndDateTextBox,"30.03.2022T0005:00");
    }
    @Then("doctor clicks on CreatedDate textbox")
    public void doctorClicksOnCreatedDateTextbox() {
        Driver.waitAndClick(doctorPage.CreatedDateTextBox);
    }
    @Then("doctor provide valid date")
    public void doctorProvideValidDate() {
        Driver.waitAndSendText(doctorPage.CreatedDateTextBox,"26.03.2022");
    }
    @Then("doctor clicks on Status textbox")
    public void doctorClicksOnStatusTextbox() {
        Driver.waitAndClick(doctorPage.StatusTextBox);
    }
    @Then("doctor provides valid status")
    public void doctorProvidesValidStatus() {
        Driver.selectAnItemFromDropdown(doctorPage.StatusTextBox,"STAYING");
    }
    @Then("doctor clicks Save button")
    public void doctorClicksSaveButton() {
        Driver.waitAndClick(doctorPage.SaveButtonforInpatient);
    }
    @Then("doctor verifies the new information")
    public void doctorVerifiesTheNewInformation() {
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.VerificationofInpatientInfo, 3).isDisplayed());
    }
    @And("doctor clicks room textbox")
    public void doctorClicksRoomTextbox() {
        Driver.waitAndClick(doctorPage.RoomTextBox);
    }
    @Then("doctor selects any Appropriate room")
    public void doctorSelectsAnyAppropriateRoom() {
        Driver.waitAndClick(doctorPage.selectpatientroom);
        // Driver.selectAnItemFromDropdown(doctorPage.RoomTextBox,"297:TWIN FULL-UNAVAILABLE");
    }
}
