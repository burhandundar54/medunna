package stepdefinitions.ui_stepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SignInPage;
import pojos.Registrant;
import utilities.ConfigurationReader;
import utilities.Driver;

import static utilities.WriteToTxt.saveRegistrantData;
public class Us_004_StepDef {
    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    Registrant registrant = new Registrant();
    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }
    @Given("User clicks on account icon")
    public void user_clicks_on_account_icon() {
        Driver.waitAndClick(homePage.accountMenu);
    }
    @Given("User clicks  on Sign in")
    public void user_clicks_on_sign_in() {
        Driver.waitAndClick(homePage.signIn);
    }
    @Then("User verifies if user is on the sign in page")
    public void user_verifies_if_user_is_on_the_sign_in_page() {
        Driver.wait(2);
        Assert.assertTrue(signInPage.signInText.isDisplayed());
    }
    @Given("User provides valid {string} and {string}")
    public void user_provides_valid_and(String username, String password) {
        Driver.waitAndSendText(signInPage.userName,username);
        Driver.waitAndSendText(signInPage.password,password);
    }
    @Given("User clicks on Sign in button")
    public void user_clicks_on_sign_in_button() {
        Driver.waitAndClick(signInPage.signIn);
    }
    @Then("User verifies login is success")
    public void user_verifies_login_is_success() {
        Driver.wait(2);
        Assert.assertTrue(signInPage.emreuserText.isDisplayed());
    }
    @Given("User provides valid {string} and invalid {string}")
    public void user_provides_valid_and_invalid(String username, String password) {
        Driver.waitAndSendText(signInPage.userName,username);
        Driver.waitAndSendText(signInPage.password,password);
    }
    @Then("User verifies unsuccessful message")
    public void user_verifies_unsuccessful_message() throws InterruptedException {
        Driver.wait(2);
        String failedMessageText = signInPage.failedMessagePopup.getText();
        Assert.assertEquals("Authentication information not correct.","Authentication information not correct.");
    }
    @Then("User closes the application")
    public void user_closes_the_application() {
        Driver.closeDriver();
    }
    @When("User clicks on cancel button")
    public void user_clicks_on_cancel_button() {
        Driver.waitAndClick(signInPage.cancelButton);
    }
    @Then("User verifies the if cancel button is enable")
    public void user_verifies_the_if_cancel_button_is_enable() {
        Driver.wait(2);
        Assert.assertTrue(homePage.accountMenu.isDisplayed());
    }
    @Then("User verifies if the remember me option is exist and clickable")
    public void user_verifies_if_the_remember_me_option_is_exist_and_clickable() {
        Driver.wait(2);
        Assert.assertTrue(signInPage.rememberMeText.isDisplayed());
        Assert.assertFalse(signInPage.rememberMeBox.isSelected());
        Driver.wait(2);
        Driver.clickWithJS(signInPage.rememberMeBox);
        Driver.wait(2);
        if(signInPage.rememberMeBox.isSelected()){
            Driver.wait(2);
            Driver.clickWithJS(signInPage.rememberMeBox);
        }
        Driver.wait(2);
        Assert.assertFalse(signInPage.rememberMeBox.isSelected());
    }
    @When("User clicks on Did you forget your password? option")
    public void user_clicks_on_did_you_forget_your_password_option() {
        Driver.clickWithJS(signInPage.didYouForgetYourPasswordLink);
    }
    @Then("User verifies the Reset your password text")
    public void user_verifies_the_reset_your_password_text() {
        Driver.wait(2);
        Assert.assertEquals("Reset your password",signInPage.resetYourPasswordText.getText());
    }
    @Then("User provides own email {string}")
    public void user_provides_own_email(String email) {
        Driver.waitAndSendText(signInPage.emailBox,email);
    }
    @Then("User clicks Reset password button")
    public void user_clicks_reset_password_button() {
        Driver.waitAndClick(signInPage.resetPasswordButton);
    }
    @Then("User verifies success message")
    public void user_verifies_success_message() {
        Driver.wait(2);
        Assert.assertTrue(signInPage.successMessageToastContainer.getText().contains("reset your password"));
    }
    @When("User clicks on Register a new account option")
    public void user_clicks_on_register_a_new_account_option() {
        Driver.clickWithJS(signInPage.registerANewAccountLink);
    }
    @When("User provides invalid {string} and valid {string}")
    public void user_provides_invalid_and_valid(String username, String password) {
        Driver.waitAndSendText(signInPage.userName,username);
        Driver.waitAndSendText(signInPage.password,password);
    }
    @When("User provides invalid {string} and invalid {string}")
    public void user_provides_invalid_and_invalid(String username, String password) {
        Driver.waitAndSendText(signInPage.userName,username);
        Driver.waitAndSendText(signInPage.password,password);
    }
    @Then("User clicks and put check mark on remember me option")
    public void user_clicks_and_put_check_mark_on_remember_me_option() {
        Driver.wait(2);
        Driver.clickWithJS(signInPage.rememberMeBox);
        Driver.wait(2);
    }
    @Then("User clicks on Account Menu")
    public void user_clicks_on_account_menu() {
        Driver.waitAndClick(signInPage.emreuserText);
    }
    @Then("User clicks on Sign Out")
    public void user_clicks_on_sign_out() {
        Driver.waitAndClick(signInPage.signOut);
    }
    @Then("User clicks on SIGN IN AGAIN button")
    public void user_clicks_on_sign_in_again_button() {
        Driver.waitAndClick(signInPage.signInAgain);
    }
    @Then("User provides previously provided {string}")
    public void user_provides_previously_provided(String username) {
        Driver.waitAndSendText(signInPage.userName,username);
    }
    @Then("User Verifies if the previously provided password comes automatically")
    public void user_verifies_if_the_previously_provided_password_comes_automatically() {
        String value = signInPage.password.getAttribute("value");
        Assert.assertTrue(value.isEmpty());
        // String value2 = signInPage.password.getText();
        //Assert.assertEquals("1234",value2);
    }
    @Then("User verifies if the user is on registration page")
    public void user_verifies_if_the_user_is_on_registration_page() {
        Assert.assertTrue(registrationPage.registrationText.isDisplayed());
    }
    @Then("User provides the necessary information to register {string},{string},{string},{string},{string},{string}")
    public void user_provides_the_necessary_information_to_register(String ssn, String firstname, String lastname, String username, String email, String password) {
        ssn = faker.idNumber().ssnValid();
        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        username = faker.name().username();
        email = faker.internet().emailAddress();
        password = faker.internet().password();
        registrant.setSsn(ssn);
//        registrant.setFirstName(firstname);
//        registrant.setLastName(lastname);
//        registrant.setUsername(username);
//        registrant.setEmail(email);
//        registrant.setPassword(password);
        Driver.waitAndSendText(registrationPage.ssnTextBox,ssn);
        Driver.waitAndSendText(registrationPage.firstnameTextBox,firstname);
        Driver.waitAndSendText(registrationPage.lastnameTextBox,lastname);
        Driver.waitAndSendText(registrationPage.usernameTextBox,username);
        Driver.waitAndSendText(registrationPage.emailTextbox,email);
        Driver.waitAndSendText(registrationPage.firstPasswordTextBox,password);
        Driver.waitAndSendText(registrationPage.secondPasswordTextBox,password);
    }
    @Then("User clicks on Register button")
    public void user_clicks_on_register_button() {
        Driver.waitAndClick(registrationPage.registerButton);
    }
    @Then("User verifies the register is success")
    public void user_verifies_the_register_is_success() {
        saveRegistrantData(registrant);
        Driver.wait(2);
        Assert.assertTrue(registrationPage.successMessageToastContainer.isDisplayed());
    }
}