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
import static utilities.Authentication.generateToken;
public class US_16_API_PUT_StepDefs {
    Map<String,Object> expectedData;
    Response response;
    RequestSpecification spec;
    @When("set the Medunna Base Url")
    public void setTheMedunnaBaseUrl() {
        spec=new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
        spec.pathParams("1","api","2","rooms");
    }
    @When("set updated expected data")
    public void set_updated_expected_data() {
        /*
        {
  "createdBy": "string",
  "createdDate": "2022-03-16T10:47:44.686Z",
  "description": "string",
  "id": 28483,
  "price": 500,
  "roomNumber": 1453,
  "roomType": "TWIN",
  "status": true
}
         */
        expectedData=new HashMap<>();
        expectedData.put("createdBy","adminrecep");
        expectedData.put("createdDate","2022-03-16T10:47:44.686Z");
        expectedData.put("description","Sickness");
        expectedData.put("id",30338);
        expectedData.put("price",555);
        expectedData.put("roomNumber",1239);
        expectedData.put("roomType","TWIN");
        expectedData.put("status",true);
    }
    @When("send the PUT request and get the response")
    public void send_the_put_request_and_get_the_response() {
        response = given().spec(spec).headers("Authorization", "Bearer " +generateToken(),
                        "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                body(expectedData).when().put("/{1}/{2}");
    }
    @Then("validate updated data")
    public void validate_updated_data() {
        Map<String,Object> actualData=response.as(HashMap.class);
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
