package stepdefinitions.ui_stepdefs;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.US05_AppointmentPage;
import pojos.Appointment;
import utilities.Driver;
import static utilities.WriteToTxt.saveAppointData;

public class US05_AppStepDefs {
    Appointment appointment = new Appointment();
    Faker faker = new Faker();
    Response response;
    //US09_SignInPage signInPage=new US09_SignInPage();
    US05_AppointmentPage appointmentPage=new US05_AppointmentPage();
    private String email2;
    //    @When("user launches the browser")
//    public void userLaunchesTheBrowser() {
//        Driver.getDriver();
//    }
//
//    @And("user navigates to home page")
//    public void userNavigatesToHomePage() {
//
//        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("base_url"));
//
//    }
//
//    @And("user verifies home page is visible")
//    public void userVerifiesHomePageIsVisible() {
//
//        String homePageTitle=Driver.getDriver().getTitle();
//        Assert.assertEquals("MEDUNNA",homePageTitle);
//
//    }
    @And("user clicks MakeAnAppointment button")
    public void userClicksMakeAnAppointmentButton() {
        appointmentPage.MakeAnAppointmentButton.click();
    }
    @And("user verifies Appointment page is visible")
    public void userVerifiesAppointmentPageIsVisible() {
        appointmentPage.MakeAnAppointmentHeader.isDisplayed();
    }
    @And("user sets the expected data {string}, {string} {string} {string} {string} {string}")
    public void userSetsTheExpectedData(String firstname, String lastname, String ssn, String email, String phonenumber, String date) {
//        firstname = faker.name().firstName();
//        lastname = faker.name().lastName();
//        ssn = faker.idNumber().ssnValid();
//        email = faker.internet().emailAddress();
//        phonenumber = "234-123-9873";
//        date = "11.03.2022";
        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        ssn = faker.idNumber().ssnValid();
        email = faker.internet().emailAddress();
        email2= faker.internet().emailAddress();
        phonenumber = "416-208-6412";
        date = "13.05.2022";
        appointment.setFirstname(firstname);
        appointment.setLastname(lastname);
        appointment.setSsn(ssn);
        appointment.setEmail(email);
        appointment.setEmail2(email2);
        appointment.setPhoneNumber(phonenumber);
        appointment.setDate(date);
    }
    @And("user clicks FirstName TextBox")
    public void userClicksFirstNameTextBox() {
        Driver.clickWithJS(appointmentPage.firstnameTextbox);
    }
    @Then("user enters valid FirstName")
    public void userEntersValidFirstName() {
        appointmentPage.firstnameTextbox.sendKeys(appointment.getFirstname());
    }
    @And("user clicks LastName TextBox")
    public void userClicksLastNameTextBox() {
        Driver.waitAndClick(appointmentPage.lastnameTextbox);
    }
    @Then("user enters valid LastName")
    public void userEntersValidLastName() {
        appointmentPage.lastnameTextbox.sendKeys(appointment.getLastname());
    }
    @And("user clicks SSN TextBox")
    public void userClicksSSNTextBox() {
        Driver.waitAndClick(appointmentPage.ssnTextbox);
    }
    @Then("user enters valid SSN")
    public void userEntersValidSSN() {
        appointmentPage.ssnTextbox.sendKeys(appointment.getSsn());
    }
    @And("user clicks Email TextBox")
    public void userClicksEmailTextBox() {
        Driver.waitAndClick(appointmentPage.emailTextbox);
    }
    @Then("user enters valid Email")
    public void userEntersValidEmail() {
        appointmentPage.emailTextbox.sendKeys(appointment.getEmail());
    }
    @And("user clicks Phone TextBox")
    public void userClicksPhoneTextBox() {
        Driver.waitAndClick(appointmentPage.phoneTextbox);
    }
    @Then("user enters valid Phone")
    public void userEntersValidPhone() {
        appointmentPage.phoneTextbox.sendKeys(appointment.getPhoneNumber());
    }
    @And("user clicks AppDateTime TextBox")
    public void userClicksAppDateTimeTextBox() {
        Driver.waitAndClick(appointmentPage.dateTextbox);
    }
    @Then("user enters valid AppDateTime")
    public void userEntersValidAppDateTime() {
        appointmentPage.dateTextbox.sendKeys(appointment.getDate());
    }
    @Then("user clicks SendAnAppRequest button")
    public void userClicksSendAnAppRequestButton() {
        Driver.clickWithJS(appointmentPage.requestButton);
        Driver.wait(1);
    }
    @Then("user validates application")
    public void userValidatesApplication() {
        Driver.wait(2);
        Assert.assertTrue(appointmentPage.successMessageToastContainer.isDisplayed());
    }
    @Then("user saves the records corresponding file")
    public void userSavesTheRecordsCorrespondingFile() {
        saveAppointData(appointment);
    }
    @Then("user clicks AccountMenu button")
    public void userClicksAccountMenuButton() {
        Driver.clickWithJS(appointmentPage.accountmenu);
    }
    @When("user clicks Register button")
    public void userClicksRegisterButton() {
        Driver.wait(1);
        Driver.waitAndClick(appointmentPage.registerButton);
        // Driver.selectAnItemFromDropdown(appointmentPage.accountmenu,"Register");
        Driver.wait(1);
        // Assert.assertTrue(appointmentPage.MakeAnAppointmentHeader.isDisplayed());
    }
    @And("user clicks SSN TextBox at Registration page")
    public void userClicksSSNTextBoxAtRegistrationPage() {
        Driver.waitAndClick(appointmentPage.ssnTextboxRegP);
    }
    @And("user enters SSN")
    public void userEntersSSN() {
        appointmentPage.ssnTextboxRegP.sendKeys(appointment.getSsn());
    }
    @And("user clicks FirstName TextBox at Registration page")
    public void userClicksFirstNameTextBoxAtRegistrationPage() {
        Driver.waitAndClick(appointmentPage.firstnameTextboxRegP);
    }
    @And("user enters any firstname")
    public void userEntersanyFirstname() {
        appointmentPage.firstnameTextboxRegP.sendKeys(appointment.getFirstname());
    }
    @Then("user clicks LastName TextBox at Registration page")
    public void userClicksLastNameTextBoxAtRegistrationPage() {
        Driver.waitAndClick(appointmentPage.lastnameTextboxRegP);
    }
    @And("user enters any lastname")
    public void userEntersanyLastname() {
        appointmentPage.lastnameTextboxRegP.sendKeys(appointment.getLastname());
    }
    @Then("user clicks username TextBox at Registration page")
    public void userClicksUsernameTextBoxAtRegistrationPage() {
        Driver.waitAndClick(appointmentPage.usernameTextboxRegP);
    }
    @And("user enters username")
    public void userEntersUsername() {
        appointmentPage.usernameTextboxRegP.sendKeys(appointment.getFirstname());
    }
    @Then("user clicks email TextBox at Registration page")
    public void userClicksEmailTextBoxAtRegistrationPage() {
        Driver.waitAndClick(appointmentPage.emailTextboxRegP);
    }
    @And("user enters email")
    public void userEntersEmail() {
//        appointmentPage.emailTextboxRegP.sendKeys(appointment.getEmail());
        appointmentPage.emailTextboxRegP.sendKeys(email2);
    }
    @Then("user clicks newpassword TextBox at Registration page")
    public void userClicksNewpasswordTextBoxAtRegistrationPage() {
        Driver.waitAndClick(appointmentPage.firstPassTextboxRegP);
    }
    @And("user enters newpassword")
    public void userEntersNewpassword() {
        appointmentPage.firstPassTextboxRegP.sendKeys("12345678");
    }
    @Then("user clicks passwordconfirm TextBox at Registration page")
    public void userClicksPasswordconfirmTextBoxAtRegistrationPage() {
        Driver.waitAndClick(appointmentPage.secondPassTextboxRegP);
    }
    @And("user enters passwordconfirm")
    public void userEntersPasswordconfirm() {
        appointmentPage.secondPassTextboxRegP.sendKeys("12345678");
    }
    @Then("user clicks Register button at Registration page")
    public void userClicksRegisterButtonAtRegistrationPage() {
        Driver.waitAndClick(appointmentPage.registerButtonRegP);
    }
    @And("user validates registration")
    public void userValidatesRegistration() {
        Driver.wait(2);
        Assert.assertTrue(appointmentPage.successMessageToastContainerRegP.isDisplayed());
    }
}