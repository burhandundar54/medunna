package stepdefinitions.api_stepdefs;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.US10_Appointment;
import utilities.ConfigurationReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;
import static utilities.Authentication.generateToken2;

public class US0010_Physician_Appointments_Api_Step_Defs {
    US10_Appointment[] appointments1;
    US10_Appointment[] appointments2;
    Response response;
    Response response2;
    List<US10_Appointment> list= new ArrayList<>();
    List<Integer> list2= new ArrayList<>();
    @Given("user sends the get request for physician_appointments data")
    public void userSendsTheGetRequestForPhysician_appointmentsData() {
        response = given().headers("Authorization",
                        "Bearer " + generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).when().
                get(ConfigurationReader.getProperty("physician_appointment_url"));
    }
    @And("user deserializes physician_appointments data to java")
    public void userDeserializesPhysician_appointmentsDataToJava() throws IOException {
        ObjectMapper obj = new ObjectMapper();
        appointments1 = obj.readValue(response.asString(), US10_Appointment[].class);
        for(US10_Appointment x:appointments1){
            if(x.getPhysician()!=null){
                if(x.getPhysician().getFirstName().equals("Johny")){
                    list.add(x);
                }
            }
        }
    }
    @And("user saves the users physician_appointments data to correspondent files")
    public void userSavesTheUsersPhysician_appointmentsDataToCorrespondentFiles() {
        //System.out.println(list);
        //saveApiPhysicianAppointment(list);
    }
    @Then("user validates physician appointment records")
    public void userValidatesPhysicianAppointmentRecords()  {
        response.then().statusCode(200);
        assertEquals(list.size(),5);
        response.then().body("id",hasItems(11409, 11856, 10446, 10449, 11401),
                "physician.firstName",hasItem("Johny"));
    }

    @Given("user sends the get request for physician_appointments with data {string} and {string} and {string}")
    public void userSendsTheGetRequestForPhysician_appointmentsWithDataAndAnd(String fromdate, String todate, String id) {
        String queryparams="?fromDate="+fromdate+"&toDate="+todate+"&userId="+id;
        String endpoint="https://medunna.com/api/appointments/bydateandId"+queryparams;

        response2= getRequest(generateToken2(),endpoint);
        //response2.prettyPrint();
    }

    @And("user deserializes physician_appointments with date data to java")
    public void userDeserializesPhysician_appointmentsWithDateDataToJava() throws IOException {
        ObjectMapper obj= new ObjectMapper();
        appointments2= obj.readValue(response2.asString(),US10_Appointment[].class);

        for(US10_Appointment x:appointments2){
            if(x.getId()!=0){
                list2.add(x.getId());
            }
        }
    }

    @And("user saves the users physician_appointments with date data to correspondent files")
    public void userSavesTheUsersPhysician_appointmentsWithDateDataToCorrespondentFiles() {
        //saveApiPhysicianAppointment(list2);
    }

    @Then("user validates physician appointment with date records")
    public void userValidatesPhysicianAppointmentWithDateRecords() {
        response2.then().statusCode(200);
        // assertEquals(list2.size(),5);
        System.out.println(list2);

//        response2.then().body("id",hasItems(11409, 11856, 10446, 10449, 11401),
//                                "physician.firstName",hasItem("Johny"));

        response2.then().body("id",hasItems(11856),
                "physician.firstName",hasItem("Johny"));
    }

}