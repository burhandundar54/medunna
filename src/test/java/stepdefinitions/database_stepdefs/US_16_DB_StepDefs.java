package stepdefinitions.database_stepdefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static utilities.DatabaseUtility.createConnection;
import static utilities.DatabaseUtility.getColumnData;

public class US_16_DB_StepDefs {
    List<Object> actualRoomList;
    @Given("set connection with database")
    public void set_connection_with_database() {
        createConnection("jdbc:postgresql://medunna.com:5432/medunna_db","medunnadb_user" ,
                "Medunnadb_@129");
    }
    @Given("select id column data")
    public void select_id_column_data() {
        actualRoomList=getColumnData("select * from room where id=28483", "room_number");
        System.out.println(actualRoomList);
    }
    @Then("validate room's number with the database")
    public void validate_room_s_number_with_the_database() {
        assertTrue(actualRoomList.contains(1453));
    }

}

