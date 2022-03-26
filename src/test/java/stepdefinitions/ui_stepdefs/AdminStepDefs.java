package stepdefinitions.ui_stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AdminPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminStepDefs {

    AdminPage adminPage = new AdminPage();
    @When("admin clicks administration button")
    public void admin_clicks_administration_button() {
        Driver.waitAndClick(adminPage.administrationButton);
//       Driver.clickWithJS(adminPage.administrationButton);
    }
    @When("admin clicks user management")
    public void admin_clicks_user_management() {
        // Write code here that turns the phrase above into concrete actions
        Driver.waitAndClick(adminPage.userManagement);
    }
    @When("admin verifies that she can view registered people info as firstname, lastname, email etc.")
    public void admin_verifies_that_she_can_view_registered_people_info_as_firstname_lastname_email_etc() {
        List<String > expectedList= Arrays.asList("ID","Login","SSN","Email","Language","Profiles","Createddate","Modifiedby","Modifieddate");
        List<String> actualList= new ArrayList<>();
        Driver.wait(5);
        for(WebElement x: adminPage.titles) {
            actualList.add(x.getText().replaceAll(" ",""));
        }
        System.out.println(actualList);
        Assert.assertTrue(actualList.containsAll(expectedList));
//        assertEquals(actualList,expectedList);
    }
    ////////////////////////////////////////////////////////////////
    ///////////////ADMIN UPDATE AND DELETE /////////////////////////
    @When("admin goes the last page")
    public void admin_goes_the_last_page() {
        Driver.waitForPageToLoad(3);
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Driver.waitAndClick(adminPage.lastPageArrow);
    }
    @When("admin finds the registrant")
    public void admin_finds_the_registrant() {
        List<String> rowElements = new ArrayList<>();
        Driver.wait(4);
        for (WebElement x : adminPage.tugbaRow) {
            rowElements.add(x.getText());
        }
        Driver.wait(3);
        System.out.println(rowElements);
    }
    @When("admin actives the user")
    public void admin_actives_the_user() {
        Driver.wait(3);
        Driver.clickWithJS(adminPage.tugbaRow.get(4));
        //Driver.waitAndClick(adminPage.tugbaRow.get(4));
//        for (WebElement x : adminPage.tugbaRow){
////            if(x.getText().equals("Deactivated")){
//                System.out.println(x.getText());
//                Driver.wait(5);
//                Driver.waitAndClick(x);
//                Driver.clickWithJS(x);
    }
    @Then("verifies the updated message")
    public void verifies_the_updated_message() {
        Driver.wait(5);
        assertTrue(adminPage.userUpdatedMessage.isDisplayed());
    }
    @When("admin gives physician role to the user")
    public void admin_gives_physician_role_to_the_user() {
        Driver.wait(3);
        Driver.clickWithJS(adminPage.lastNumber);
        //Driver.waitAndClick(adminPage.lastNumber);
        Driver.wait(3);
        Driver.clickWithJS(adminPage.lastPageArrow);
        //Driver.waitAndClick(adminPage.lastPageArrow);
        Driver.wait(5);
        Driver.clickWithJS(adminPage.editTugbaButton);
        //Driver.waitAndClick(adminPage.editTugbaButton);
        Driver.wait(3);
        Driver.clickWithJS(adminPage.assignAsPhysician);
        //Driver.waitAndClick(adminPage.assignAsPhysician);
        Driver.wait(2);
        Driver.clickWithJS(adminPage.saveButton);
        //Driver.waitAndClick(adminPage.saveButton);
    }
    @When("admin verifies the message")
    public void admin_verifies_the_message() {
        Driver.wait(3);
        assertTrue(adminPage.userUpdatedMessage.isDisplayed());
    }
    @When("admin gives staff role to the physician")
    public void admin_gives_staff_role_to_the_physician() {
        Driver.wait(3);
        Driver.clickWithJS(adminPage.lastNumber);
        //Driver.waitAndClick(adminPage.lastNumber);
        Driver.wait(3);
        Driver.clickWithJS(adminPage.lastPageArrow);
        //Driver.waitAndClick(adminPage.lastPageArrow);
        Driver.wait(5);
        Driver.clickWithJS(adminPage.editTugbaButton);
        //Driver.waitAndClick(adminPage.editTugbaButton);
        Driver.wait(3);
        Driver.clickWithJS(adminPage.assignAsStaff);
        //Driver.waitAndClick(adminPage.assignAsStaff);
        Driver.wait(2);
        Driver.clickWithJS(adminPage.saveButton);
        //Driver.waitAndClick(adminPage.saveButton);
    }
    @When("admin deletes the user")
    public void admin_deletes_the_user() {
        Driver.wait(3);
        Driver.clickWithJS(adminPage.lastNumber);
        //Driver.waitAndClick(adminPage.lastNumber);
        Driver.wait(3);
        Driver.clickWithJS(adminPage.lastPageArrow);
        //Driver.waitAndClick(adminPage.lastPageArrow);
        Driver.wait(5);
        Driver.clickWithJS(adminPage.deleteTugbaButton);
        //Driver.waitAndClick(adminPage.deleteTugbaButton);
        Driver.wait(3);
        Driver.clickWithJS(adminPage.confirmDelete);
        //Driver.waitAndClick(adminPage.confirmDelete);
        Driver.wait(3);
        Assert.assertTrue(adminPage.userDeletedMessage.isDisplayed());
        Driver.wait(3);
    }
    @Then("close the application")
    public void close_the_application() {
        Driver.wait(5);
        Driver.closeDriver();
    }


}
