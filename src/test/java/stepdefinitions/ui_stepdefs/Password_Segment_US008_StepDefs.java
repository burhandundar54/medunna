package stepdefinitions.ui_stepdefs;
import pages.Password_Segment_US008;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.Driver;

import java.util.Arrays;

public class Password_Segment_US008_StepDefs {

    Password_Segment_US008 passwordSegmentUs008 = new Password_Segment_US008();

    @Given("user clicks sign_in_menu")
    public void user_clicks_sign_in_menu() {
        passwordSegmentUs008.signInMenuButton.click();
    }

    @Then("user verifies sign_in_title")
    public void user_verifies_sign_in_title() {
        Driver.wait(1);
        Assert.assertTrue(passwordSegmentUs008.signInTitleText.isDisplayed());
    }

    @And("user enter username as {string}")
    public void userEnterUsernameAs(String username) {
        passwordSegmentUs008.usernameBox.sendKeys(username);
    }

    @And("user enter password as {string}")
    public void userEnterPasswordAs(String password) {
        passwordSegmentUs008.passwordBox.sendKeys(password);
    }

    @Then("user clicks sign_in_button")
    public void user_clicks_sign_in_button() {
        passwordSegmentUs008.signInSubmitButton.click();
    }

    @Then("user verifies name is visible on homepage")
    public void user_verifies_name_is_visible_on_homepage() {
        Driver.wait(3);
        Assert.assertTrue(passwordSegmentUs008.adminNameHomePage.isDisplayed());
    }

    @Then("user clicks password_menu")
    public void user_clicks_password_menu() {
        passwordSegmentUs008.passwordMenuButton.click();
    }


    @Then("user verifies password for username title")
    public void user_verifies_password_for_username_title() {
        Driver.wait(2);
        Assert.assertTrue(passwordSegmentUs008.passwordTitleText.isDisplayed());
    }

    @When("user enter current password as {string}")
    public void userEnterCurrentPasswordAs(String currentPassword) {
        passwordSegmentUs008.currentPasswordBox.sendKeys(currentPassword);
    }

    @And("user enter new password as {string}")
    public void userEnterNewPasswordAs(String newPassword) {
        passwordSegmentUs008.newPasswordBox.sendKeys(newPassword);
    }

    @And("user enter password confirmation as {string}")
    public void userEnterPasswordConfirmationAs(String confirmationPassword) {
        passwordSegmentUs008.confirmPasswordBox.sendKeys(confirmationPassword);
    }

    @Then("user clicks save submit button")
    public void user_clicks_save_submit_button() {
        passwordSegmentUs008.saveSubmitButton.click();
    }

    @And("user verifies password changed message")
    public void userVerifiesPasswordChangedMessage() {
        Driver.wait(2);
        String passwordMessage = passwordSegmentUs008.passwordChangedMessage.getText();
        Assert.assertEquals("Password changed!", passwordMessage);
    }

    @And("user verifies last strength bar colour add {string}")
    public void userVerifiesLastStrengthBarColourAdd(String character) {
        String fifthBarColourBefore = passwordSegmentUs008.fifthStrengthBar.getAttribute("style");
        passwordSegmentUs008.newPasswordBox.sendKeys(character);
        String fifthBarColourAfter = passwordSegmentUs008.fifthStrengthBar.getAttribute("style");
        Assert.assertEquals("background-color: rgb(0, 255, 0);", fifthBarColourAfter);
        Assert.assertNotEquals(fifthBarColourBefore,fifthBarColourAfter);
    }

    @And("user verifies total strengths bar colour add {string}")
    public void userVerifiesTotalStrengthsBarColourAdd(String character) {
        int sizeOfBar = passwordSegmentUs008.strengthsBar.size();
        String[] coloursOfStrengthBefore = new String[sizeOfBar];
        String[] coloursOfStrengthAfter = new String[sizeOfBar];
        for (int i=0; i<sizeOfBar;i++){
            coloursOfStrengthBefore[i] = passwordSegmentUs008.strengthsBar.get(i).getAttribute("style");
        }
        passwordSegmentUs008.newPasswordBox.sendKeys(character);
        for (int i=0; i<sizeOfBar;i++){
            coloursOfStrengthAfter[i] = passwordSegmentUs008.strengthsBar.get(i).getAttribute("style");
        }
        Assert.assertFalse(Arrays.equals(coloursOfStrengthBefore, coloursOfStrengthAfter));
    }

    @And("user clicks sign_out_menu")
    public void userClicksSign_out_menu() {
        passwordSegmentUs008.signOutMenuButton.click();
    }

    @And("user verifies password should be confirmation")
    public void user_Verifies_Password_Should_Be_Confirmation() {
        Assert.assertTrue(passwordSegmentUs008.passwordShouldBeConfirmMessage.isDisplayed());
    }

    @And("user verifies password not more four char message")
    public void user_Verifies_Password_Not_More_Four_Char_Message() {
        Assert.assertTrue(passwordSegmentUs008.passwordMoreThanFourMessage.isDisplayed());
    }

    @And("user verifies password not match message")
    public void user_Verifies_Password_Not_Match_Message() {
        Assert.assertTrue(passwordSegmentUs008.passwordNotMatchMessage.isDisplayed());
    }

    @And("user verifies password not changed message")
    public void user_Verifies_Password_Not_Changed_Message() {
        Driver.wait(2);
        Assert.assertTrue(passwordSegmentUs008.passwordNotChangedMessage.isDisplayed());
    }
    @And("user verifies password is required message")
    public void user_Verifies_Password_Is_Required_Message() {
        Assert.assertEquals("Your password is required.",passwordSegmentUs008.passwordIsRequiredMessage.getText());
    }

    @Then("user verifies authentication incorrect message")
    public void user_Verifies_Authentication_Incorrect_Message() {
        Driver.wait(2);
        Assert.assertEquals("Authentication information not correct.",passwordSegmentUs008.passwordInformationIncorrectMessage.getText());
    }
}