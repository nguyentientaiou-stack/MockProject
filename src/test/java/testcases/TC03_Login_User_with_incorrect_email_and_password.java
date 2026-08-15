package testcases;

import keywords.CommonKeywords;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Page_LoginSignup;
import pages.Page_Home;

public class TC03_Login_User_with_incorrect_email_and_password {

  WebDriver driver;

  @BeforeMethod
  public void beforeMethod() {
    CommonKeywords common = new CommonKeywords(driver);
    driver = common.getDriver("chrome");
    driver.manage().window().maximize();
  }

  @Test(description = "Verify user can't login with incorrect email and password.")
  public void Login_User_with_incorrect_email_and_password() {
    Page_Home pageHome = new Page_Home(driver);
    Page_LoginSignup pageLoginSignup = new Page_LoginSignup(driver);

    // 1. Launch browser
    // 2.Navigate to url 'http://automationexercise.com'
    pageHome.accessHomePage("https://automationexercise.com/");

    // 3. Verify that home page is visible successfully
    pageHome.verifyHomePageIsVisible();

    // 4. Click on 'Signup / Login' button
    pageHome.clickSignUp_Login();

    // 5. Verify 'Login to your account' is visible
    pageLoginSignup.verifyLoginToYourAccountIsVisible();

    // 6. Enter incorrect email address and password
    // 7. Click 'login' button
    pageLoginSignup.loginToAccount("TestingUser3@gmail.com", "@Darksoul1234560");

    //8. Verify error 'Your email or password is incorrect!' is visible
    pageLoginSignup.verifyNotificationYourEmailOrPasswordIncorrectIsVisible();
  }

  @AfterMethod
  public void afterMethod() {
    driver.close();
  }
}
