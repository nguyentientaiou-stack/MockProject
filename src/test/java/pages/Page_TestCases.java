package pages;

import io.qameta.allure.Step;
import keywords.CommonKeywords;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Page_TestCases {
  WebDriver driver;

  public Page_TestCases(WebDriver driver) {
    this.driver = driver;
  }

  @Step("Verify that page test cases is visible.")
  public void verifyTestCasesPageIsVisible(){
    Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/test_cases");
    CommonKeywords common = new CommonKeywords(driver);
    common.screenshot();
  }
}
