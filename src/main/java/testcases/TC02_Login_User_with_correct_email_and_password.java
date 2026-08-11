package testcases;

import keywords.CommonKeywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Page_AccountDeleted;
import pages.Page_LoginSignup;
import pages.Page_Home;

public class TC02_Login_User_with_correct_email_and_password {

  WebDriver driver;

  @BeforeMethod
  public void beforeMethod() {
    CommonKeywords common = new CommonKeywords(driver);
    driver = common.getDriver("chrome");
    driver.manage().window().maximize();
  }

  @Test(description = "Verify user can login with correct email and password.")
  public void Login_Userwith_correct_email_and_password(){
    Page_Home pageHome = new Page_Home(driver);
    Page_LoginSignup pageLoginSignup = new Page_LoginSignup(driver);
    Page_AccountDeleted pageAccountDeleted = new Page_AccountDeleted(driver);

    // 1. Launch browser
    // 2.Navigate to url 'http://automationexercise.com'
    pageHome.accessHomePage("https://automationexercise.com/");

    // 3. Verify that home page is visible successfully
    pageHome.verifyHomePageIsVisible();

    // 4. Click on 'Signup / Login' button
    pageHome.clickSignUp_Login();

    // 5. Verify 'Login to your account' is visible
    pageLoginSignup.verifyLoginToYourAccountIsVisible();

    // 6. Enter correct email address and password
    // 7. Click 'login' button
    pageLoginSignup.loginToAccount("TestingUser@gmail.com", "@Darksoul1234560");

    // 8. Verify that 'Logged in as username' is visible
    pageHome.verifyLoggedInAsUserIsVisible("TestingUser");

    /*// 9. Click 'Delete Account' button
    pageMain.deleteAccount();

    // 10. Verify that 'ACCOUNT DELETED!' is visible
    pageAccountDeleted.verifyAccountDeletedPageIsDisplayed();
    pageAccountDeleted.clickOnContinue();*/

  }

  @AfterMethod
  public void afterMethod() {
    driver.close();
  }
}
