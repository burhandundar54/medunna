package stepdefinitions.ui_stepdefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.Registration_Password_US003;
import utilities.ConfigurationReader;
import utilities.Driver;
import java.util.Arrays;

public class Registration_Password_US003_StepDefs {
    Registration_Password_US003 registrationPasswordUs003 = new Registration_Password_US003();
    @When("user launches the browser")
    public void user_launches_the_browser() {
        Driver.getDriver();
    }
    @When("user navigates to home page")
    public void user_navigates_to_home_page() {
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("medunna_login_url"));
    }
    @When("user verifies home page is visible")
    public void user_verifies_home_page_is_visible() {
        Assert.assertEquals("https://medunna.com/",Driver.getDriver().getCurrentUrl());
    }
    @When("user clicks account_menu")
    public void user_clicks_account_menu() {
        registrationPasswordUs003.accountMenuButton.click();
    }
    @When("user clicks register button")
    public void user_clicks_register_button() {
        registrationPasswordUs003.registerMenuButton.click();
    }
    @When("user verifies registration title is visible")
    public void user_verifies_registration_title_is_visible() {
        Assert.assertTrue(registrationPasswordUs003.registrationTitle.isDisplayed());
    }
    @Given("user enter registration password {string}")
    public void user_Enter_Registration_Password(String string) {
        registrationPasswordUs003.firstPasswordBox.sendKeys(string);
    }
    @And("user verifies fifth strength bar colour add {string}")
    public void user_Verifies_Fifth_Strength_Bar_Colour_Add(String string) {
        String fifthBarColourBefore = registrationPasswordUs003.fifthStrengthBar.getAttribute("style");
        registrationPasswordUs003.firstPasswordBox.sendKeys(string);
        String fifthBarColourAfter = registrationPasswordUs003.fifthStrengthBar.getAttribute("style");
        Assert.assertEquals("background-color: rgb(0, 255, 0);", fifthBarColourAfter);
        Assert.assertNotEquals(fifthBarColourBefore,fifthBarColourAfter);
    }
    @And("user verifies all strengths bar colour add {string}")
    public void user_Verifies_All_Strengths_Bar_Colour_Add(String string) {
        int sizeOfBar = registrationPasswordUs003.strengthsBar.size();
        String[] coloursOfStrengthBefore = new String[sizeOfBar];
        String[] coloursOfStrengthAfter = new String[sizeOfBar];
        for (int i=0; i<sizeOfBar;i++){
            coloursOfStrengthBefore[i] = registrationPasswordUs003.strengthsBar.get(i).getAttribute("style");
        }
        registrationPasswordUs003.firstPasswordBox.sendKeys(string);
        for (int i=0; i<sizeOfBar;i++){
            coloursOfStrengthAfter[i] = registrationPasswordUs003.strengthsBar.get(i).getAttribute("style");
        }
        Assert.assertFalse(Arrays.equals(coloursOfStrengthBefore, coloursOfStrengthAfter));
    }
    @And("user verifies registration password required")
    public void user_Verifies_Registration_Password_Required() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ENTER).perform();
        Assert.assertEquals("Your password is required.", registrationPasswordUs003.passwordInvalidRequired.getText());
    }
    @And("user verifies registration password 4char")
    public void user_Verifies_Registration_Password_4char() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ENTER).perform();
        Assert.assertEquals("Your password is required to be at least 4 characters.", registrationPasswordUs003.passwordInvalid4Char.getText());
    }
    @And("user verifies negative fifth strength bar colour add {string}")
    public void user_Verifies_Negative_Fifth_Strength_Bar_Colour_Add(String string) {
        String fifthBarColourBefore = registrationPasswordUs003.fifthStrengthBar.getAttribute("style");
        registrationPasswordUs003.firstPasswordBox.sendKeys(string);
        String fifthBarColourAfter = registrationPasswordUs003.fifthStrengthBar.getAttribute("style");
        Assert.assertEquals("background-color: rgb(221, 221, 221);", fifthBarColourAfter);
        Assert.assertEquals(fifthBarColourBefore,fifthBarColourAfter);
    }
    @And("user verifies negative all strengths bar colour add {string}")
    public void user_Verifies_Negative_All_Strengths_Bar_Colour_Add(String string) {
        int sizeOfBar = registrationPasswordUs003.strengthsBar.size();
        String[] coloursOfStrengthBefore = new String[sizeOfBar];
        String[] coloursOfStrengthAfter = new String[sizeOfBar];
        for (int i=0; i<sizeOfBar;i++){
            coloursOfStrengthBefore[i] = registrationPasswordUs003.strengthsBar.get(i).getAttribute("style");
        }
        registrationPasswordUs003.firstPasswordBox.sendKeys(string);
        for (int i=0; i<sizeOfBar;i++){
            coloursOfStrengthAfter[i] = registrationPasswordUs003.strengthsBar.get(i).getAttribute("style");
        }
        Assert.assertTrue(Arrays.equals(coloursOfStrengthBefore, coloursOfStrengthAfter));
    }
}
