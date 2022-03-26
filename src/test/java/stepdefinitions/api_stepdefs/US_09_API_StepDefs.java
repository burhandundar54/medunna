package stepdefinitions.api_stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigurationReader;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;

public class US_09_API_StepDefs {

    Response response;
    Map<String,Object> expectedData;

    @When("user sets the Base Url")
    public void set_the_base_url() {
        RequestSpecification spec=new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
        spec.pathParams("1","api","2","patients","3",4860);
    }
    @When("user sends the GET request and get the response")
    public void send_the_get_request_and_get_the_response() {
        response = given().headers("Authorization", "Bearer " +generateToken(),
                        "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).when().
                get(ConfigurationReader.getProperty("patient_endpoint"));
    }
    @When("user sets the expected data")
    public void set_the_expected_data() {
        expectedData=new HashMap<>();
        expectedData.put("firstName","John");
        expectedData.put("lastName","Doe");
        expectedData.put("email","john@doe.com");

    }
    @Then("user does validation")
    public void do_validation() {
        Map<String, String> actualData=response.as(HashMap.class);
        System.out.println(actualData.toString());
        assertEquals(expectedData.get("firstName"),actualData.get("firstName"));
        assertEquals(expectedData.get("lastName"),actualData.get("lastName"));
        assertEquals(expectedData.get("email"),actualData.get("email"));

    }

}
