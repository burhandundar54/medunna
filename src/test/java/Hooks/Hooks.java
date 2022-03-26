package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigurationReader;
import utilities.Driver;

import static utilities.DatabaseUtility.createConnection;

public class Hooks {

    public static RequestSpecification spec;

    @Before(value = "@ApiRegistrant")
    public void setUp(){
        spec=new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
    }

    @Before(value = "@AdminUI")
    public void navigateToLoginPage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }

    @Before( value = "@ApiPostRegistrant")
    public void setup(){
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
    }

    @Before(order=1, value = "@UIRegistration")
    public void navigateToRegistrationPage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_registration_url"));
    }

    @Before( value = "@EndToEnd")
    public void createNewDBConnection(){
        createConnection(ConfigurationReader.getProperty("db_credentials_url"),
                ConfigurationReader.getProperty("db_username"),
                ConfigurationReader.getProperty("db_password"));
    }

    @Before( value = "@DBUsers")
    public void createNewDBUserConnection(){
        createConnection(ConfigurationReader.getProperty("db_credentials_url"),
                ConfigurationReader.getProperty("db_username"),
                ConfigurationReader.getProperty("db_password"));
    }


    @Before(order = 1, value = "@Appointment")
    public void navigateToLandingPage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_appointment_url"));
    }

    @Before( value = "@AppointmentPostApi")
    public void postAppointmentSetup(){
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
    }

    @Before( value = "@AppointmentGetApi")
    public void getAppointmentSetup(){
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
    }

    @Before( value = "@TestItemApi")
    public void postTestItemSetup(){
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
    }

    @Before( value = "@PutUserRequest")
    public void putApiSetup(){
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();

    }


    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png","screenshots");
        }
        Driver.closeDriver();
    }

}
