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
import static utilities.Authentication.generateToken;
public class US_16_API_GET_StepDefs {
    Response response;
    Map<String, Object> expectedData;
    @When("set Medunna Base Url")
    public void set_medunna_base_url() {
        RequestSpecification spec=new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
        spec.pathParams("1","api","2","rooms","3",28483);
    }
    @When("send the Get request and get the response")
    public void send_the_get_request_and_get_the_response() {
        response = given().headers("Authorization", "Bearer " +generateToken(),
                        "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).when().
                get(ConfigurationReader.getProperty("room_endpoint"));
    }
    @When("set the room's expected data")
    public void set_the_room_s_expected_data() {
        expectedData=new HashMap<>();
        expectedData.put("roomNumber",1453);
        expectedData.put("roomType","TWIN");
    }
    @Then("do the validation")
    public void do_the_validation() {
        Map<String, Object> actualData=response.as(HashMap.class);
        System.out.println(actualData.toString());
        assertEquals(expectedData.get("roomNumber"),actualData.get("roomNumber"));
        assertEquals(expectedData.get("roomType"),actualData.get("roomType"));
    }
}