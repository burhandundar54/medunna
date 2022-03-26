package stepdefinitions.database_stepdefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DatabaseUtility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US0010_Physician_Appointment_Db_Step {
    List<Map<String, Object>> allPhysicianResult;
    List<Map<String, Object>> actualResult;
    @Given("user connect to DB")
    public void userConnectToDB() {
        DatabaseUtility.createConnection("jdbc:postgresql://medunna.com:5432/medunna_db","medunnadb_user" , "Medunnadb_@129");
    }
    @And("user gets {string} from {string} table")
    public void userGetsFromTable(String column, String table) {
        String query = "Select " + column + " from "+ table + " WHERE physician_id = '10505'";
        DatabaseUtility.executeQuery(query);
        allPhysicianResult = DatabaseUtility.getQueryResultMap(query);
        // System.out.println(allPhysicianResult.get(0).get("id"));
        // System.out.println(allPhysicianResult.get(1).get("id"));
        // System.out.println(allPhysicianResult.get(2).get("id"));
        // System.out.println(allPhysicianResult.get(3).get("id"));
    }
    @And("user reads all of the {string} column data")
    public void userReadsAllOfTheColumnData(String arg0) {
        List<Object> actualList= new ArrayList<>();
        for(int i=0;i<allPhysicianResult.size();i++){
            actualList.add(allPhysicianResult.get(i).get("id").toString());
        }
        List<Object> expectedList= Arrays.asList("11856", "10446", "11401", "10449", "11409");
        //assertTrue(actualList.contains(expectedList));
    }
    @Then("close the database connection")
    public void closeTheDatabaseConnection() {
        DatabaseUtility.closeConnection();
    }
}