package stepdefinitions.api_stepdefs;

import com.github.javafaker.Faker;
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
public class US_16_API_POST_StepDefs {
    Map<String, Object> expectedData;
    RequestSpecification spec;
    Faker faker=new Faker();
    Response response;
    @When("set  Base Url")
    public void set_base_url() {
        spec=new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
        spec.pathParams("1","api","2","rooms");
    }
    @When("set expected data")
    public void set_expected_data() {
        /*
      {
    "createdBy": "adminrecep",
    "createdDate": "2022-03-16T09:59:14.677746Z",
    "roomNumber": 2049,
    "roomType": "DAYCARE",
    "status": true,
    "price": 100.00,
    "description": ""
}
         */
        expectedData=new HashMap<>();
        expectedData.put("createdBy","adminrecep");
        expectedData.put("roomNumber",faker.number().numberBetween(100,10000));
        expectedData.put("roomType","DAYCARE");
        expectedData.put("createdDate","2022-03-16T09:59:14.677746Z");
        expectedData.put("status",true);
        expectedData.put("price",100.00);
        expectedData.put("description","critical");
    }
    @When("send the POST request and get the response")
    public void send_the_post_request_and_get_the_response() {
        response = given().spec(spec).headers("Authorization", "Bearer " +generateToken(),
                        "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                body(expectedData).
                when().post("/{1}/{2}");
    }
    @Then("validate data")
    public void validate_data() {
        Map<String ,Object> actualData=response.as(HashMap.class);
        System.out.println("expectedData: "+expectedData.toString());
        System.out.println("actualData: "+actualData.toString());
        assertEquals(expectedData.get("roomNumber"),actualData.get("roomNumber"));
    }
}