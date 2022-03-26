package stepdefinitions.api_stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigurationReader;
import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class US_16_API_DELETE_StepDefs {

    RequestSpecification spec;
    Response response;
    @When("set the room Base Url")
    public void set_the_room_base_url() {
        spec=new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
        spec.pathParams("1","api","2","rooms","3",37673);
    }
    @When("send the DELETE request and get the response")
    public void send_the_delete_request_and_get_the_response() {
        response = given().spec(spec).headers("Authorization", "Bearer " +generateToken(),
                        "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                when().delete("/{1}/{2}/{3}");
    }
    @Then("validate deleted data")
    public void validate_deleted_data() {
        response.then().statusCode(204);
    }
}
