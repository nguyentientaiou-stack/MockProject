package testcases;

import keywords.CommonKeywords;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Page_Home;
import pages.Page_LoginSignup;

public class TC05_Register_User_with_existing_email {

  WebDriver driver;

  @BeforeMethod
  public void beforeMethod() {
    CommonKeywords common = new CommonKeywords(driver);
    driver = common.getDriver("chrome");
    driver.manage().window().maximize();
  }

  @Test(description = "Verify user can't register new account with existing email")
  public void RegisterUserWithExistingEmail() {
    Page_Home pageHome = new Page_Home(driver);
    Page_LoginSignup pageLoginSignup = new Page_LoginSignup(driver);

    // 1. Launch browser
    // 2.Navigate to url 'http://automationexercise.com'
    pageHome.accessHomePage("https://automationexercise.com/");

    // 3. Verify that home page is visible successfully
    pageHome.verifyHomePageIsVisible();

    // 4. Click on 'Signup / Login' button
    pageHome.clickSignUp_Login();

    // 5. Verify 'New User Signup!' is visible
    pageLoginSignup.verifyNewUserSignUpIsVisible();

    // 6. Enter name and email address
    // 7. Click 'Signup' button
    pageLoginSignup.signUpUser("TestingUser", "TestingUser@gmail.com");

    // 8. Verify error 'Email Address already exist!' is visible
    pageLoginSignup.verifyNotificationEmailAlreadyExistIsVisible();
  }

  @AfterMethod
  public void afterMethod() {
    driver.close();
  }
}
