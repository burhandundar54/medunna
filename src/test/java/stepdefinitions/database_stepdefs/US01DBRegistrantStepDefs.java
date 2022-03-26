package stepdefinitions.database_stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.DatabaseUtility.createConnection;
import static utilities.DatabaseUtility.getColumnData;

public class US01DBRegistrantStepDefs {

    List<Object> actualSsnList;


    @Given("user sets a connection with database")
    public void user_sets_a_connection_with_database() {
        createConnection("jdbc:postgresql://medunna.com:5432/medunna_db","medunnadb_user" , "Medunnadb_@129");
    }

    @Given("user selects all {string} column data")
    public void user_selects_all_column_data(String string) {
        actualSsnList=getColumnData("select * from jhi_user", string);
        System.out.println(actualSsnList);
    }

    @Then("user validates registrant {string} ids with the database")
    public void user_validates_registrant_ids_with_the_database(String string) {
        assertTrue(actualSsnList.contains(string));
    }





}
