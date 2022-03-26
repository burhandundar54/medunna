package stepdefinitions.database_stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static utilities.DatabaseUtility.createConnection;
import static utilities.DatabaseUtility.getColumnData;

public class US_09_DB_StepDefs {

    List<Object> actualeMailList;

    @Given("user sets a connection with the database")
    public void user_sets_a_connection_with_the_database() {
        createConnection("jdbc:postgresql://medunna.com:5432/medunna_db","medunnadb_user" ,
                "Medunnadb_@129");
    }

    @Given("user selects all email column data")
    public void user_selects_all_email_column_data() {
        actualeMailList=getColumnData("select * from patient where last_name = 'Doe'", "email");
        System.out.println(actualeMailList);
    }

    @Then("user validates patient's eMail with the database")
    public void userValidatesPatientSEMailWithTheDatabase() {

        assertTrue(actualeMailList.contains("john@doe.com"));
    }
}


