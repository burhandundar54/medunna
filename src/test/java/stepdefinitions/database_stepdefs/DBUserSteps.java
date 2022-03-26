package stepdefinitions.database_stepdefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DatabaseUtility;

import java.util.List;
import java.util.Map;

public class DBUserSteps {

    @Given("user sends the {string} to DB")
    public void user_sends_the_to_db(String query) {
        List<Map<String,Object>> actualData = DatabaseUtility.getQueryResultMap(query);
        System.out.println("actualData = " + actualData);
        List<String> columnNames =DatabaseUtility.getColumnNames(query);
        //   System.out.println("columnNames = " + columnNames);
        for (int j=0; j<columnNames.size();j++){
            //id  // first_name
            for (int i=0; i<actualData.size();i++){
                // I am expecting to see all ids , all firstname together
                //    System.out.println( actualData.get(i).get(columnNames.get(j)));
            }
        }
    }
    @Given("user saves data in correspondent files")
    public void user_saves_data_in_correspondent_files() {

    }

}