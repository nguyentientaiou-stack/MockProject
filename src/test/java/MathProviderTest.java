import practice.MathProvider;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathProviderTest {

  @Test
  public void MP001_add_two_numbers_successfully() {
    // 3A = Arrange, Act, Assert
    // Arrange = Pre-condition
    MathProvider m = new MathProvider();
    // Act = Test steps
    int actualSum = m.add(30, 20);
    // Assert = Expected Result
    assertEquals(50, actualSum);
  }

  @Test
  public void MP002_sub_two_numbers_successfully() {
    // 3A = Arrange, Act, Assert
    // Arrange = Pre-condition
    MathProvider m = new MathProvider();
    // Act = Test steps
    int actualSum = m.sub(30, 20);
    // Assert = Expected Result
    assertEquals(10, actualSum);
  }
}
