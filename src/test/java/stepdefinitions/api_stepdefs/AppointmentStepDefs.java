package stepdefinitions.api_stepdefs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.AppointmentOuter;
import pojos.Patient;
import utilities.ConfigurationReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;
import static utilities.WriteToTxt.savePatientAppointment;

public class AppointmentStepDefs {

    Faker faker=new Faker();
    Response response;
    Patient patient=new Patient();

//=================================POST REQUEST==============================================================================

    @Given("user sets the path params")
    public void user_sets_the_path_params() {
        spec.pathParams("first","api","second","appointments","third","request");
    }

    @Given("user sets expected data {string} {string} {string} {string} {string} {string}")
    public void user_sets_expected_data(String firstname, String lastname, String ssn, String email, String phone, String startDate) {
        firstname=faker.name().firstName();
        lastname=faker.name().lastName();
        ssn=faker.idNumber().ssnValid();
        email=faker.internet().emailAddress();

        patient.setFirstName(firstname);
        patient.setLastName(lastname);
        patient.setSsn(ssn);
        patient.setEmail(email);
        patient.setPhone(phone);
        patient.setStartDate(startDate);

    }

    @Given("user send Post request and gets response")
    public void user_send_post_request_and_gets_response() {
        response=given().spec(spec).contentType(ContentType.JSON).body(patient).when().post("/{first}/{second}/{third}");
        response.prettyPrint();
    }
    @Given("user saves the records")
    public void user_saves_the_records() {
        savePatientAppointment(patient);
    }

    @Then("user validates record with Api")
    public void user_validates_record_with_api() throws IOException {
        response.then().statusCode(201);
        //response.prettyPrint();


        ObjectMapper obj=new ObjectMapper();
        AppointmentOuter actualAppointmentOuter=obj.readValue(response.asString(),AppointmentOuter.class);

        System.out.println(actualAppointmentOuter);

        assertEquals(patient.getFirstName(),actualAppointmentOuter.getPatient().getFirstName());
        assertEquals(patient.getLastName(),actualAppointmentOuter.getPatient().getLastName());
        assertEquals(patient.getSsn(),actualAppointmentOuter.getPatient().getUser().getSsn());
        assertEquals(patient.getStartDate(),actualAppointmentOuter.getStartDate().substring(0,10));
        assertEquals(patient.getEmail(),actualAppointmentOuter.getPatient().getEmail());


    }


//===================================GET REQUEST==================================================================================



    @Given("user sends the get request for appointments data")
    public void user_sends_the_get_request_for_appointments_data() {
        response = getRequest(generateToken(), ConfigurationReader.getProperty("appointments_endpoint"));
    }

    @Then("user deserializes data to Java and validates {string} {string} {string} {string} and {string}")
    public void user_deserializes_data_to_Java_and_validates(String firstname, String lastname, String ssn, String email, String phone) throws IOException {

        //1.way:
//        JsonPath json=response.jsonPath();
//        String patients=json.getList("patient").toString();
//
//        Assert.assertTrue(patients.contains(firstname));
//        Assert.assertTrue(patients.contains(lastname));
//        Assert.assertTrue(patients.contains(ssn));
//        Assert.assertTrue(patients.contains(email));
//        Assert.assertTrue(patients.contains(phone));

        //2.way:
        ObjectMapper obj=new ObjectMapper();
        AppointmentOuter [] appointmentOuters=obj.readValue(response.asString(),AppointmentOuter[].class);
        List<Object> appointmentList=new ArrayList<>(Arrays.asList(appointmentOuters));
        String appointments=appointmentList.toString();

        assertTrue(appointments.contains(firstname));
        assertTrue(appointments.contains(lastname));
        assertTrue(appointments.contains(ssn));
        assertTrue(appointments.contains(email));
        assertTrue(appointments.contains(phone));




    }




}
