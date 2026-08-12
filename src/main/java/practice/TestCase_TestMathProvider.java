package practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_TestMathProvider {

  @ParameterizedTest
  @CsvFileSource(resources = "/Data.csv", numLinesToSkip = 1)
  public void MP001_Add_two_number_successfully(int number_1, int number_2){
    MathProvider mathProvider = new MathProvider();
    int actualSum = mathProvider.add(number_1, number_2);
    Assert.assertEquals(actualSum, number_1 +  number_2);
  }
}
