package stepdefinitions.ui_stepdefs;
import com.github.javafaker.Faker;
import pages.US015_Create_Edit_Patient;
import pojos.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US015_Create_Edit_Patient;
import pojos.US015_Create_Edit_Patient_Pojo;
import pojos.US015_InnerCStatePojo;
import pojos.US015_InnerCountryPojo;
import pojos.US015_InnerUserPojo;
import utilities.ConfigurationReader;
import utilities.DatabaseUtility;
import utilities.Driver;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.ApiUtils.getRequest;
import static utilities.ApiUtils.postRequestPatient;
import static utilities.Authentication.generateToken;
//import static utilities.WriteToTxt.saveUS015PatientData;

public class US015_Create_Edit_Patient_Steps {

    Faker faker=new Faker();
    US015_Create_Edit_Patient pageObject = new US015_Create_Edit_Patient();
    Response response;
    US015_Create_Edit_Patient_Pojo pojoObject = new US015_Create_Edit_Patient_Pojo();
    US015_InnerUserPojo pojoInnerUser = new US015_InnerUserPojo();
    US015_InnerCountryPojo pojoInnerCountry = new US015_InnerCountryPojo();
    US015_InnerCStatePojo pojoInnerCState = new US015_InnerCStatePojo();
    String id_token;
    US015_Create_Edit_Patient_Pojo []patientArray;

    @When("user clicks ItemsTitles menu")
    public void user_clicks_items_titles_menu() {
        Driver.waitAndClick(pageObject.itemsTitlesMenu,2);
    }

    @When("user clicks Patient menu")
    public void user_clicks_patient_menu() {
        Driver.waitAndClick(pageObject.patientMenuInItems,2);
    }

    @When("user verifies create_a_new_patient button")
    public void user_verifies_create_a_new_patient_button() {
        Driver.waitForVisibility(pageObject.createANewPatientVerify,4);
        Assert.assertTrue(pageObject.createANewPatientVerify.isDisplayed());
    }

    @And("user clicks view information of first patient")
    public void user_Clicks_View_Information_Of_First_Patient() {
        Driver.waitAndClick(pageObject.viewButtonOfFirstPatient,2);
    }

    @And("user verifies all patient information title")
    public void user_Verifies_All_Patient_Information_Title() {
        Assert.assertTrue(pageObject.ssnTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.firstNameTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.lastNameTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.birthDateTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.phoneTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.genderTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.bloodGroupTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.addressTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.descriptionTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.createdDateTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.userTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.countryTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.stateCityTitleVerify.isDisplayed());
    }

    @And("user verifies id item added for edit patient")
    public void user_Verifies_Id_Item_Added_For_Edit_Patient() {
        List<String> viewElements = new ArrayList<>();
        List<String> editElements = new ArrayList<>();

        for (int i =0; i<pageObject.patientInformationInView.size();i++){
            viewElements.add(pageObject.patientInformationInView.get(i).getText());
        }

        Driver.waitAndClickElement(pageObject.editButtonOfFirstPatient,2);
        Driver.wait(2);

        for (int i =0; i<pageObject.patientInformationInEdit.size();i++){
            editElements.add(pageObject.patientInformationInEdit.get(i).getText());
        }

        Assert.assertFalse(viewElements.contains("ID"));
        Assert.assertTrue(editElements.contains("ID"));
    }

    @And("user enter patient values with Pojo {string}, {string}, {string}, {string}, {string}")
    public void user_Enter_Patient_Values_With_Pojo(String firstName, String lastName, String phone, String email, String userId) {
        pojoObject.setFirstName(firstName);
        pojoObject.setLastName(lastName);
        pojoObject.setPhone(phone);
        pojoObject.setEmail(email);
        pojoInnerUser.setId(Integer.parseInt(userId));
        pojoInnerCountry.setId(1201);
        pojoInnerCountry.setName("US");
        pojoInnerCState.setId(1255);
        pojoInnerCState.setName("California");

        pojoInnerCState.setCountry(pojoInnerCountry);
        pojoObject.setUser(pojoInnerUser);
        pojoObject.setCountry(pojoInnerCountry);
        pojoObject.setCstate(pojoInnerCState);
    }

    @And("user create a new patient with POST and API and Pojo")
    public void user_Create_A_New_Patient_With_POST_And_API_And_Pojo() {
        id_token = generateToken();
        spec.pathParams("first", "api", "second", "patients");
        response = given().headers(
                        "Authorization",
                        "Bearer " + id_token,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                spec(spec).body(pojoObject).when().post("/{first}/{second}");
        response.then().statusCode(201);


    }

    @And("user saves the API records with writeToText")
    public void user_Saves_The_API_Records_With_WriteToText() {
        //saveUS015PatientData(pojoObject);
    }

    @And("user validate patient info with DB")
    public void user_Validate_Patient_Info_With_DB() {
        DatabaseUtility.createConnection("jdbc:postgresql://medunna.com:5432/medunna_db","medunnadb_user" , "Medunnadb_@129");
        String query = "SELECT * FROM patient where email ='"+pojoObject.getEmail()+"'";
        //DatabaseUtility.executeQuery(query);

        List<Map<String, Object>> patientInformation = DatabaseUtility.getQueryResultMap(query);

        Assert.assertEquals(pojoObject.getPhone(),patientInformation.get(0).get("phone"));
        Assert.assertEquals(pojoObject.getFirstName(),patientInformation.get(0).get("first_name"));
        Assert.assertEquals(pojoObject.getLastName(),patientInformation.get(0).get("last_name"));
    }

    @And("user validate patient info with API")
    public void user_Validate_Patient_Info_With_API() throws Exception {
        response = getRequest(generateToken(),"https://medunna.com/api/patients/search?ssn=545-85-5485");

        ObjectMapper obj = new ObjectMapper();
        patientArray = obj.readValue(response.asString(), US015_Create_Edit_Patient_Pojo[].class);

        Assert.assertEquals(pojoObject.getPhone(),patientArray[0].getPhone());
        Assert.assertEquals(pojoObject.getFirstName(),patientArray[0].getFirstName());
        Assert.assertEquals(pojoObject.getLastName(),patientArray[0].getLastName());
        Assert.assertEquals(pojoObject.getEmail(),patientArray[0].getEmail());
    }

    @And("admin can delete any patient")
    public void admin_Can_Delete_Any_Patient() {
        Driver.waitAndClick(pageObject.itemsTitlesMenu,2);
        Driver.waitAndClick(pageObject.patientMenuInItems,2);
        Driver.wait(3);
        Driver.waitAndClick(pageObject.createdDateTitleVerify,2);
        Driver.wait(3);

        for(int i =0; i<pageObject.userInformationInTable.size();i++){
            if(pageObject.userInformationInTable.get(i).getText().equals("adminrecep")){
                Driver.wait(4);
                pageObject.deleteButtonInTable.get(i).click();
                Driver.wait(4);
                Driver.waitAndClick(pageObject.deleteButtonForAPatient,3);
                break;
            }else{
                Driver.wait(3);
                Driver.clickWithJS(pageObject.pageNumberGoNext);
            }
        }
        Driver.wait(2);
        Assert.assertTrue(pageObject.deleteVerifyMessage.isDisplayed());
    }

}