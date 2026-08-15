package practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import keywords.DBKeywords;
import keywords.DBTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;

public class Actors_Test {
    @Test
    public void SC001_actors_table_is_not_empty() {
      //Arrange
      DBKeywords dbKeywords = new DBKeywords();
      Connection connection = dbKeywords.createConnection(DBTypes.MYSQL, "127.0.0.1", "3306", "sakila", "root", "@Darksoul1234560");

      //Act
      ResultSet resultSet = dbKeywords.executeQuery(connection, "SELECT * FROM actor");
      List<String> actorIds = dbKeywords.getCellValues(resultSet, "actor_id");

      //Assert
      Assertions.assertNotEquals(0, actorIds.size());
    }

    @Test
    public void SC002_actors_found_records(){
      DBKeywords dbKeywords = new DBKeywords();
      Connection connection = dbKeywords.createConnection(DBTypes.MYSQL, "127.0.0.1", "3306", "sakila", "root", "@Darksoul1234560");
      ResultSet resultSet = dbKeywords.executeQuery(connection, "SELECT * FROM actor");
      List<String> actorIds = dbKeywords.getCellValues(resultSet, "actor_id");
      List<String> firstName = dbKeywords.getCellValues(resultSet, "first_name");
      List<String> lastName = dbKeywords.getCellValues(resultSet, "last_name");

      String actualActorId = actorIds.get(2);
      String actualFirstName = firstName.get(2);
      String actualLastName = lastName.get(2);

      Assert.assertEquals(actualActorId, "3");
      Assert.assertEquals(actualFirstName, "ED");
      Assert.assertEquals(actualLastName, "CHASE");


    }
}
