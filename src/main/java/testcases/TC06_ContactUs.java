package testcases;

import keywords.CommonKeywords;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Page_AccountCreated;
import pages.Page_AccountDeleted;
import pages.Page_ContactUs;
import pages.Page_Home;
import pages.Page_LoginSignup;

public class TC06_ContactUs {

  WebDriver driver;

  @BeforeMethod
  public void beforeMethod() {
    CommonKeywords common = new CommonKeywords(driver);
    driver = common.getDriver("chrome");
    driver.manage().window().maximize();
  }

  @Test(description = "Verify user can register new account successfully.")
  public void VerifyUserCanRegisterNewAccount() {
    Page_Home pageHome = new Page_Home(driver);
    Page_ContactUs pageContactUs = new Page_ContactUs(driver);

    // 1. Launch browser
    // 2.Navigate to url 'http://automationexercise.com'
    pageHome.accessHomePage("https://automationexercise.com/");

    // 3. Verify that home page is visible successfully
    pageHome.verifyHomePageIsVisible();

    // 4. Click on 'Contact Us' button
    pageHome.clickContactUs();

    // 5. Verify 'GET IN TOUCH' is visible
    pageContactUs.verifyGetInTouchIsVisible();

    // 6. Enter name, email, subject and message
    pageContactUs.fillGetInTouchInformation("UserTesting", "UserTesting@gmail.com", "Testing", "Testing");

    // 7. Upload file
    pageContactUs.uploadFile("D:\\Maven_Project\\Projects\\MockProject\\New Text Document.txt");

    // 8. Click 'Submit' button
    pageContactUs.clickOnSubmit();

    // 9. Click OK button
    pageContactUs.alertPopUp("OK");

    // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    pageContactUs.verifySuccessMessageIsVisible();

    // 11. Click 'Home' button and verify that landed to home page successfully
    pageContactUs.clickOnHomeButton();
    pageHome.verifyHomePageIsVisible();
  }

  @AfterMethod
  public void afterMethod() {
    driver.close();
  }
}
