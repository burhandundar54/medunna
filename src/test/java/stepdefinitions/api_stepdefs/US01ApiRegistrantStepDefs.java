package stepdefinitions.api_stepdefs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.TestCase;
import org.junit.Assert;
import pojos.Registrant;
import utilities.ConfigurationReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.*;
import static utilities.Authentication.generateToken;
import static utilities.ReadTxt.*;
import static utilities.ReadTxt.getAllRegistrants;
import static utilities.WriteToTxt.saveRegistrantData;
import static utilities.WriteToTxt.saveRegistrantDataApi;

public class US01ApiRegistrantStepDefs {

    Registrant registrant=new Registrant();
    Faker faker=new Faker();
    Response response;
    String endpoint;
    Registrant []registrants;


    @Given("user sets the necessary path params")
    public void user_sets_the_necessary_path_params() {
        spec.pathParams("first","api","second","register");
    }

    @Given("user sets the expected data {string} {string} {string} {string} {string} {string} {string}")
    public void user_sets_the_expected_data(String firstname, String lastname, String ssn, String email, String username, String password, String lan) {
        firstname=faker.name().firstName();
        lastname=faker.name().lastName();
        ssn=faker.idNumber().ssnValid();
        email=faker.internet().emailAddress();
        username=faker.name().username();
        password=faker.internet().password(8,15,true,true);

        registrant.setFirstName(firstname);
        registrant.setLastName(lastname);
        registrant.setSsn(ssn);
        registrant.setEmail(email);
        registrant.setLogin(username);
        registrant.setPassword(password);
        registrant.setLangKey(lan);

    }

    @Given("user sends the POST request and gets the response")
    public void user_sends_the_post_request_and_gets_the_response() {
        response=given().spec(spec).contentType(ContentType.JSON).body(registrant).when().post("/{first}/{second}");
    }

    @Given("user saves the api records to correspondent files")
    public void user_saves_the_api_records_to_correspondent_files() {
        saveRegistrantDataApi(registrant);
    }

    @Then("user validates api records")
    public void user_validates_api_records() throws Exception {
        response.then().statusCode(201);
        //response.prettyPrint();

        ObjectMapper obj=new ObjectMapper();
        Registrant actualRegistrant=obj.readValue(response.asString(),Registrant.class);

        //or we can use as() method from Gson like this:
        //Registrant actualRegistrant2=response.as(Registrant.class);

        System.out.println(actualRegistrant);

        assertEquals(registrant.getFirstName(),actualRegistrant.getFirstName());
        assertEquals(registrant.getLastName(),actualRegistrant.getLastName());
        assertEquals(registrant.getSsn(),actualRegistrant.getSsn());

    }

//==========================================GET REQUEST===============================================================




    @Given("user sets the endpoint to get user info with {string}")
    public void user_sets_the_endpoint_to_get_user_info_with(String ssn) {
        endpoint="https://medunna.com/api/user?ssn="+ssn;
    }

    @Given("user sets the expected data as {string} {string} {string} {string} {string} {string}")
    public void user_sets_the_expected_data_as(String firstname, String lastname, String ssn, String email, String username, String password) {
        registrant.setFirstName(firstname);
        registrant.setLastName(lastname);
        registrant.setSsn(ssn);
        registrant.setEmail(email);
        registrant.setLogin(username);
        registrant.setPassword(password);
    }

    @Given("user makes a GET request and gets the response")
    public void user_makes_a_get_request_and_gets_the_response() {
        response=getRequest(generateToken(),endpoint);
    }

    @Then("user validates registrant information using api")
    public void user_validates_registrant_information_using_api() throws IOException {
        response.then().statusCode(200);

        ObjectMapper obj=new ObjectMapper();
        Registrant actualRegistrant=obj.readValue(response.asString(),Registrant.class);

        assertEquals(registrant.getFirstName(),actualRegistrant.getFirstName());
        assertEquals(registrant.getLastName(),actualRegistrant.getLastName());
        assertEquals(registrant.getSsn(),actualRegistrant.getSsn());
        assertEquals(registrant.getLogin(),actualRegistrant.getLogin());
        assertEquals(registrant.getEmail(),actualRegistrant.getEmail());

    }

//============================IBRAHIM HOCANIN POST REQUEST=================================================================

    @Given("user sets the necessary post path params")
    public void user_sets_the_necessary_post_path_params() {
        spec.pathParams("first", "api", "second", "register");
    }
    @Given("user sets the expected data {string}, {string} {string} {string} {string} {string} and {string}")
    public void user_sets_the_expected_data_and(String firstname, String lastname, String ssn, String email, String username, String password, String lan) {

        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        ssn = faker.idNumber().ssnValid();
        email = faker.internet().emailAddress();
        username = faker.name().username();
        password = faker.internet().password(8, 15, true, true);

        registrant.setFirstName(firstname);
        registrant.setLastName(lastname);
        registrant.setSsn(ssn);
        registrant.setEmail(email);
        registrant.setLogin(username);
        registrant.setPassword(password);
        registrant.setLangKey(lan);
//        Map<String ,Object> expectedData = new HashMap<>();
//        expectedData.put("firstName", firstname);

    }
    @Given("user sends POST request and gets the response")
    public void user_sends_post_request_and_gets_the_response() {
        response = given().spec(spec).contentType(ContentType.JSON).body(registrant).when().post("/{first}/{second}");
    }

    @When("user saves api records to correspondent files")
    public void user_saves_api_records_to_correspondent_files() {
        saveRegistrantData(registrant);
    }

    @Then("user validates the api records")
    public void user_validates_the_api_records() throws  Exception{
        response.then().statusCode(201);
        response.prettyPrint();

        ObjectMapper obj = new ObjectMapper();
        Registrant actualRegistrant = obj.readValue(response.asString(), Registrant.class);

        System.out.println(actualRegistrant);
        TestCase.assertEquals(registrant.getFirstName(), actualRegistrant.getFirstName());
        TestCase.assertEquals(registrant.getLastName(), actualRegistrant.getLastName());
        TestCase.assertEquals(registrant.getSsn(), actualRegistrant.getSsn());
    }

//============================IBRAHIM HOCANIN GET REQUESTI=================================================================

    @Given("user sends the get request for users data")
    public void user_sends_the_get_request_for_users_data() {
        response = getRequest(generateToken(), ConfigurationReader.getProperty("registrant_endpoint"));
    }

    @Given("user deserializes data to Java")
    public void user_deserializes_data_to_java()throws Exception {
//        response.prettyPrint();
        ObjectMapper obj = new ObjectMapper();
        registrants = obj.readValue(response.asString(), Registrant[].class);

//        System.out.println(registrants.length);
//        for (int i=0; i< registrants.length; i++){
//            System.out.println("name"+registrants[i].getFirstName());
//        }
    }
    @Given("user saves the users data to correspondent files")
    public void user_saves_the_users_data_to_correspondent_files() {

        List<String> expectedData = getSSNIDs();//ssn numbers stored in database
        saveRegistrantData(registrants);

        List<String> actualSSNIDs = getAPISSNIDs();//ssn number in Api
        List<String > checkList = new ArrayList<>();
        for(int i=actualSSNIDs.size()-1; i>= actualSSNIDs.size()-11;i--){// to check last 10 records
            checkList.add(actualSSNIDs.get(i));//10 records
        }
        System.out.println(actualSSNIDs.size());
        System.out.println(actualSSNIDs);
        Assert.assertTrue(expectedData.containsAll(checkList));
        System.out.println(checkList);

    }

//============================IBRAHIM HOCANIN PUT REQUESTI=================================================================

    @Given("user sets the expected user data")
    public void user_sets_the_expected_user_data() {
        String [] authority = {"USER_ROLE"};
        registrant.setFirstName("userbeybulent23");
        registrant.setLastName("Sensoybeybulent23");
        registrant.setEmail("reybey23bulent@gmail.com");
        registrant.setLogin("beybeybulent23");
        registrant.setSsn("327-37-7060");
        registrant.setLangKey("en");
        registrant.setActivated(true);
        registrant.setAuthorities(authority);

        List<Registrant> registrants = getAllRegistrants();
        registrant.setId(registrants.get(registrants.size()-3).getId());

        System.out.println("User id: "+registrants.get(registrants.size()-3).getId());

    }
    @Given("user makes a put request for users")
    public void user_makes_a_put_request_for_users() {
        putRequest(generateToken(), ConfigurationReader.getProperty("registrant_put_endpoint"), registrant);
    }
    @Given("user validates the updated changes")
    public void user_validates_the_changes() {
    }

//============================IBRAHIM HOCANIN DELETE REQUESTI=================================================================


    @Given("user sends the delete request")
    public void user_sends_the_delete_request() {
        List<Registrant> registrants=getAllRegistrants();
        String targetUser="";
        for (int i=0;i<registrants.size()-1;i++){
            if (registrants.get(i).getSsn().equalsIgnoreCase("454-34-9075")){
                targetUser=registrants.get(i).getLogin();
                break;
            }
        }
        System.out.println(targetUser);
        response = deleteRequest(generateToken(),ConfigurationReader.getProperty("registrant_delete_endpoint")+"/"+targetUser);
    }
    @Then("user validates the deleted user")
    public void user_validates_the_deleted_user() {
        response.then().statusCode(204);
    }




}
