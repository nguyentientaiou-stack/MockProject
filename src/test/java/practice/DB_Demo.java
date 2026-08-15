package practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import keywords.DBKeywords;
import keywords.DBTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DB_Demo {

  public static final Logger LOGGER = LoggerFactory.getLogger(DB_Demo.class);

  public static void main(String[] args) {
    DBKeywords dbKeywords = new DBKeywords();
    Connection connection = dbKeywords.createConnection(DBTypes.MYSQL, "127.0.0.1", "3306", "sakila", "root", "@Darksoul1234560");
    ResultSet resultSet = dbKeywords.executeQuery(connection, "SELECT * FROM actor LIMIT 10");
    /*showResultSet(resultSet);*/
    List<String> firstNames = dbKeywords.getCellValues(resultSet, "first_name");
    for (String firstName : firstNames)
    {
      LOGGER.info(firstName);
    }

    String firstName = dbKeywords.getStringCellValue(resultSet, 6, "first_name");
    LOGGER.info(firstName);

    dbKeywords.closeConnection(connection);


  }

  public static void showResultSet(ResultSet resultSet) {
    try {
      var metaData = resultSet.getMetaData();
      var columnCount = metaData.getColumnCount();
      for (int i = 1; i <= columnCount; i++) {
        LOGGER.info("{}", metaData.getColumnName(i));
        while (resultSet.next()) {
          for (int j = 1; j <= columnCount; j++) {
            LOGGER.info("{}", resultSet.getObject(j));
          }
        }
      }
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
  }
}
