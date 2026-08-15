package practice;

import io.qameta.allure.Step;

public class MathProvider {

  @Step("Add two numbers {0}, {1}")
  public int add(int a, int b) {
    return a + b;
  }

  @Step("Sub two numbers {0}, {1}")
  public int sub(int a, int b) {
    return a - b;
  }

  @Step("Multi two numbers {0}, {1}")
  public int mul(int a, int b) {
    return a * b;
  }

  @Step("Divide two numbers {0}, {1}")
  public int div(int a, int b) {
    return a / b;
  }
}
