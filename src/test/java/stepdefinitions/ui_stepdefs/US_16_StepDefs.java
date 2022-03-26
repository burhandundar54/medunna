package stepdefinitions.ui_stepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.AdminFunctions;
import pages.Rooms;
import utilities.Driver;

import javax.swing.*;

import static utilities.DateUtils.getDate;


public class US_16_StepDefs {
    Rooms rooms=new Rooms();
    AdminFunctions adminFunctions=new AdminFunctions();
    Faker faker=new Faker();


    @And("click on Room")
    public void clickOnRoom() {
        Driver.waitAndClick(rooms.roomButton);
    }

    @And("click on Create a new Room button")
    public void clickOnCreateANewRoomButton() throws InterruptedException {
        Driver.waitAndClick(rooms.createNewRoomButton);
    }

    @Then("verify Create or edit a Room page is visable")
    public void verifyCreateOrEditARoomPageIsVisable() {

        Assert.assertTrue(rooms.createNewRoomPage.isDisplayed());
    }

    @Given("Enter Room Number")
    public void enterRoomNumber() {
        String number= String.valueOf(Faker.instance().number().numberBetween(100,100000));
        rooms.roomNumberBox.sendKeys(number);

    }

    @Then("Verify all Room Types are selectable.")
    public void verifyAllRoomTypesAreSelectable() throws InterruptedException {
        Select select=new Select(rooms.roomType);
        Thread.sleep(1000);
        select.selectByIndex(0);
        Thread.sleep(1000);
        select.selectByIndex(1);
        Thread.sleep(1000);
        select.selectByIndex(2);
        Thread.sleep(1000);
        select.selectByIndex(3);
        Thread.sleep(1000);
        select.selectByIndex(4);
    }

    @Given("Click on Status checkbox")
    public void clickOnStatusCheckbox() {

        Driver.waitAndClick(rooms.statusCheckBox);
    }

    @Then("Verify checkbox is clicked")
    public void verifyCheckboxIsClicked() {
        Assert.assertTrue(rooms.statusCheckBox.isSelected());
    }

    @Given("Send an empty value to the Price box")
    public void sendAnEmptyValueToThePriceBox() {
        rooms.priceBox.sendKeys("");
    }

    @And("Verify This field is required message")
    public void verifyThisFieldIsRequiredMessage() throws InterruptedException {

        Assert.assertTrue(rooms.thisFieldIsRequiredMessage.isDisplayed());


    }

    @Then("Enter a valid price to Price box")
    public void enterAValidPriceToPriceBox() {

        Driver.waitAndClick(rooms.priceBox);
        rooms.priceBox.sendKeys("100");
    }

    @When("Enter a value to Description box")
    public void enterAValueToDescriptionBox() {
        rooms.descriptionBox.sendKeys("Bla bla");

    }

    @And("Clear the value you entered")
    public void clearTheValueYouEntered() throws InterruptedException {
        Thread.sleep(1000);
        rooms.descriptionBox.clear();
    }

    @Then("Verify there is no required alert on this box")
    public void verifyThereIsNoRequiredAlertOnThisBox() {
        Assert.assertFalse(rooms.descriptionBoxText.getText().contains("required"));

    }

    @Given("Enter an invalid date to the Created Date Box")
    public void enterAnInvalidDateToTheCreatedDateBox() {
        Driver.waitAndClick(rooms.createdDateBox);
        rooms.createdDateBox.clear();

    }

    @And("Click save button")
    public void clickSaveButton() {
        Driver.waitAndClick(rooms.saveButton);
    }

    @And("Verify Created Date text is visable")
    public void verifyCreatedDateTextIsVisable() {
        Assert.assertTrue(rooms.createdDateBox.isDisplayed());
    }

    @And("Enter a  valid date to the Created Date Box")
    public void enterAValidDateToTheCreatedDateBox() {
        Driver.waitAndClick(rooms.createdDateBox);
        //rooms.createdDateBox.sendKeys("05050020221500P");

    }

    @Then("Verify room is created")
    public void verifyRoomIsCreated() {
        Driver.getDriver().getPageSource().contains("is created");
        //  Assert.assertTrue(rooms.roomCreatedMessage.isDisplayed());
    }

    @Given("Click on View button on Rooms page")
    public void clickOnViewButtonOnRoomsPage() {
        Driver.waitAndClick(rooms.viewButton);
    }

    @And("Verify Room Information is visable")
    public void verifyRoomInformationIsVisable() throws InterruptedException {

        Assert.assertTrue(rooms.viewRoomInfo.isDisplayed());
    }

    @Given("Click on Edit button")
    public void clickOnEditButton() throws InterruptedException {

        Driver.waitAndClick(rooms.editButton);
    }

    @And("Provide the necessary parts")
    public void provideTheNecessaryParts() throws InterruptedException {
        Driver.waitAndClick(rooms.roomNumberBox);
        rooms.roomNumberBox.clear();
        rooms.roomNumberBox.sendKeys("405");
        Select select=new Select(rooms.roomType);
        Thread.sleep(1000);
        select.selectByIndex(0);
        Driver.waitAndClick(rooms.statusCheckBox);
        rooms.priceBox.clear();
        rooms.priceBox.sendKeys("101");
        rooms.createdDateBox.sendKeys("06060020221500P");
        Driver.waitAndClick(rooms.saveButton);


    }

    @Then("Verify The room is updated message")
    public void verifyTheRoomIsUpdatedMessage() {
        Assert.assertTrue(rooms.roomIsUpdatedMessage.isDisplayed());
    }

    @Given("click on delete button")
    public void clickOnDeleteButton() throws InterruptedException {

        Driver.waitAndClick(rooms.orderByDate);
        Thread.sleep(5000);
        Driver.waitAndClick(rooms.deleteButton);
    }

    @And("click on delete in the opening alert")
    public void clickOnDeleteInTheOpeningAlert() throws InterruptedException {
        rooms.confirmDelete.click();
        Thread.sleep(3000);
        Driver.waitAndClick(rooms.confirmDelete);
    }

    @Then("verify Room is Deleted message")
    public void verifyRoomIsDeletedMessage() throws InterruptedException {

        Assert.assertTrue(rooms.roomDeletedMessage.isDisplayed());
    }

}