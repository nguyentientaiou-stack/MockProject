package testcases;

import keywords.CommonKeywords;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Page_ContactUs;
import pages.Page_Home;
import pages.Page_TestCases;

public class TC07_VerifyTestCasesPage {

  WebDriver driver;

  @BeforeMethod
  public void beforeMethod() {
    CommonKeywords common = new CommonKeywords(driver);
    driver = common.getDriver("chrome");
    driver.manage().window().maximize();
  }

  @Test(description = "Verify user can register new account successfully.")
  public void VerifyTestCasesPage() {
    Page_Home pageHome = new Page_Home(driver);
    Page_ContactUs pageContactUs = new Page_ContactUs(driver);
    Page_TestCases pageTestCases = new Page_TestCases(driver);

    // 1. Launch browser
    // 2.Navigate to url 'http://automationexercise.com'
    pageHome.accessHomePage("https://automationexercise.com/");

    // 3. Verify that home page is visible successfully
    pageHome.verifyHomePageIsVisible();

    // 4. Click on 'Test Cases' button
    pageHome.clickTestCases();

    // 5. Verify user is navigated to test cases page successfully
    pageTestCases.verifyTestCasesPageIsVisible();
  }

  @AfterMethod
  public void afterMethod() {
    driver.close();
  }
}
