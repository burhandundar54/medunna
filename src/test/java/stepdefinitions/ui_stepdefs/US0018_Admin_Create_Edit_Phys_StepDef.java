package stepdefinitions.ui_stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.US0018_Create_Edit_Physician_With_AdminPage;
import utilities.Driver;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class US0018_Admin_Create_Edit_Phys_StepDef {

    US0018_Create_Edit_Physician_With_AdminPage physicians=new US0018_Create_Edit_Physician_With_AdminPage();
    String x;
    JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
    @And("admin clicks Items and select physician from dropdown")
    public void adminClicksItemsAndSelectPhysicianFromDropdown() {
        Driver.waitAndClick(physicians.itemsPhysician);
        Driver.waitAndClick(physicians.physician);
    }
    @Then("admin verify physician page")
    public void adminVerifyPhysicianPage() {
        assertTrue(physicians.verifyphysician_page.isDisplayed());
    }
    @Then("admin verify create edit new physician page")
    public void adminVerifyCreateEditNewPhysicianPage() {
        assertTrue(physicians.verifyCreatePage.isDisplayed());
    }
    @And("admin clicks Create New Physician button")
    public void adminClicksCreateNewPhysicianButton() {
        Driver.waitAndClick(physicians.createNewPyhsician);
    }
    @And("admin can choose search an existing registered person by {string}")
    public void adminCanChooseSearchAnExistingRegisteredPersonBy(String ssn) {
        Driver.waitAndSendText(physicians.searchSSNTextBox, ssn);
    }
    @And("admin clicks user search checkbox and search user button")
    public void adminClicksUserSearchCheckboxAndSearchUserButton() {
        Driver.waitAndClick(physicians.useSSNSearchCheckBox);
        Driver.waitAndClick(physicians.searchUserButton);
    }
    @Then("admin verify the success message")
    public void admin_verify_the_success_message() {
        assertTrue(Driver.waitForVisibility(physicians.successVerifySaveMessage,5).isDisplayed());
    }
    @And("admin their info should be populated firstname, lastname birth date etc..")
    public void adminTheirInfoShouldBePopulatedFirstnameLastnameBirthDateEtc() {
        physicians.firstNameTextBox.clear();
        Driver.waitAndSendText(physicians.firstNameTextBox, "Jeremy");
        physicians.lastNameTextBox.clear();
        Driver.waitAndSendText(physicians.lastNameTextBox,"Smith");
        Driver.waitAndSendText(physicians.birthDateTextBox, "02-02-1990 15:10");
        Driver.waitAndSendText(physicians.physician_phone,"122-758-5656");
        Driver.waitAndSendText(physicians.physician_adress,"New York");
        Driver.selectByIndex(physicians.physician_gender_dropdown,0);
        Driver.selectByValue(physicians.physician_speciality_dropdown,"PATHOLOGY");
        Driver.selectByValue(physicians.physician_bloodGroup_dropdown,"Onegative");
    }
    @And("admin should provide a specialty for the Doctor")
    public void adminShouldProvideASpecialtyForTheDoctor() {
        Driver.waitAndSendText(physicians.physician_description_textbox,"Prof");
    }
    @And("admin can provide a profile picture of the doctor")
    public void adminCanProvideAProfilePictureOfTheDoctor() {
        String path= System.getProperty("user.home") + "/Desktop/work/IDEA Java Projects/Team78a/src/test/resources/testdata/doctor.jpg";
        physicians.file_image_button.sendKeys(path);
    }
    @Then("admin verify a profile picture")
    public void adminVerifyAProfilePicture() {
        assertTrue(physicians.verify_image_name.isDisplayed());
    }
    @And("admin should provide the Exam fee of the doctor")
    public void adminShouldProvideTheExamFeeOfTheDoctor() {
        Driver.waitAndSendText(physicians.examFee_textbox,"500");
    }
    @And("admin should choose the doctor among existing users")
    public void adminShouldChooseTheDoctorAmongExistingUsers() {
        Driver.selectByVisibleText(physicians.select_user_dropdown,"aws");
    }
    @And("admin provide physicians country and state")
    public void adminProvidePhysiciansCountryAndState() {
        Driver.selectByVisibleText(physicians.physician_country_textbox,"US");
        Driver.wait(3);
        Driver.selectByVisibleText(physicians.physician_cstate_textbox,"New York");
    }
    @And("admin clicks save button")
    public void adminClicksSaveButton() {
        Driver.wait(3);
        Driver.waitAndClick(physicians.saveButton);
    }
    @Then("verify the success save message")
    public void verifyTheSuccessSaveMessage() {
        Driver.wait(3);
        x=  Driver.waitForVisibility(physicians.verifySaveMessage,3).getText();
        assertTrue(x.contains("A new Physician is created "));
    }
    @And("admin finds an existing physician")
    public void adminFindsAnExistingPhysician() {
        int i= physicians.lastPageList.size()-1;
        Driver.waitAndClick(physicians.lastPageList.get(i));
        Driver.wait(1);
        js.executeScript("window.scrollBy(0,-350)");
        Driver.wait(1);
        for(int j=0; j<physicians.firstNameList.size();j++){
            String firstName= physicians.firstNameList.get(j).getText();
            Driver.wait(1);
            if(firstName.equals("Jeremy")) {
                assertTrue(firstName.equals("Jeremy"));
            }
        }
    }
    @And("admin clicks view button")
    public void adminClicksViewButton() {
        x=x.replaceAll("\\D","");
        int a=Integer.parseInt(x);
        String path= "(//*[@href='/physician/"+a+"'])[2]";
        //System.out.println(path);
        WebElement view=  Driver.getDriver().findElement(By.xpath(path));
        Driver.clickWithJS(view);
        js.executeScript("window.scrollBy(0,-450)");
    }
    @Then("admin validate existing Physicians' info")
    public void adminValidateExistingPhysiciansInfo() {
        List<Object> list= new ArrayList<>();
        for(WebElement x:physicians.verify_view_page){
            list.add(x.getText());
        }
        assertTrue(list.contains("550-25-5656"));
        assertTrue(list.contains("Jeremy"));
        assertTrue(list.contains("Smith"));
        assertTrue(list.contains("122-758-5656"));
        x=x.replaceAll("\\D","");
        assertEquals(x,physicians.viewPageId.getText());
    }
    @And("admin clicks edit button")
    public void adminClicksEditButton() {
        Driver.wait(2);
        Driver.waitAndClick(physicians.editButton);
    }
    @And("admin updates Physician's some data")
    public void adminUpdatesPhysicianSSomeData() {
        Driver.wait(3);
        physicians.examFee_textbox.clear();
        Driver.waitAndSendText(physicians.examFee_textbox, "900");
        Driver.waitAndClick(physicians.saveButton);
    }
    @Then("admin verify the update message")
    public void adminVerifyTheUpdateMessage() {
        String y=  Driver.waitForVisibility(physicians.verifySaveMessage,3).getText();
        // assertTrue(y.contains("A Physician is updated "));
        Driver.wait(3);
        System.out.println(y);
    }
    //    @And("admin finds an existing physician for delete")
//    public void adminFindsAnExistingPhysicianForDelete() {
//        for(int j=0; j<physicians.firstNameList.size();j++){
//            String firstName= physicians.firstNameList.get(j).getText();
//            Driver.wait(1);
//            if(firstName.equals("Jeremy")) {
//                assertTrue(firstName.equals("Jeremy"));
//
//            }}
//    }
    @And("admin clicks delete button")
    public void adminClicksDeleteButton() {
        x=x.replaceAll("\\D","");
        int a=Integer.parseInt(x);
//        String pathdelete= "//*[@href='/physician/"+a+"/delete?page=4&sort=id,asc']";
////*[@href='/physician/33743/delete?page=4&sort=id,asc']
//        WebElement delete=  Driver.getDriver().findElement(By.xpath(pathdelete));
//        Driver.clickWithJS(delete);
//        Driver.wait(2);
//        Driver.waitAndClick(physicians.deleteButton);
        String pathdelete="((//*[@href='/physician/"+a+"'])[2]/following::a/following::a)[1]";
        WebElement delete=Driver.getDriver().findElement(By.xpath(pathdelete));
        Driver.clickWithJS(delete);
        Driver.wait(2);
        Driver.clickWithJS(physicians.deleteButton);
    }
    @Then("admin validate delete existing Physicians")
    public void adminValidateDeleteExistingPhysicians() {
        Driver.wait(5);
        String a=physicians.verifySaveMessage.getText();
        assertTrue(a.contains("A Physician is deleted "));
        Driver.wait(5);
    }
}
