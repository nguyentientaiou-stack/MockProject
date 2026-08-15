package testcases;

import keywords.CommonKeywords;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Page_AccountCreated;
import pages.Page_AccountDeleted;
import pages.Page_LoginSignup;
import pages.Page_Home;

public class TC01_RegisterUser {

  WebDriver driver;

  @BeforeMethod
  public void beforeMethod() {
    CommonKeywords common = new CommonKeywords(driver);
    driver = common.getDriver("chrome");
    driver.manage().window().maximize();
  }

  @Test(description = "Verify user can register new account successfully.")
  public void RegisterUser() {
    Page_Home pageHome = new Page_Home(driver);
    Page_LoginSignup pageLoginSignup = new Page_LoginSignup(driver);
    Page_AccountCreated pageAccountCreated = new Page_AccountCreated(driver);
    Page_AccountDeleted pageAccountDeleted = new Page_AccountDeleted(driver);

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
    pageLoginSignup.signUpUser("TestingUser2", "TestingUser2@gmail.com");

    // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    pageLoginSignup.verifyEnterAccountInformationIsVisible();

    // 9. Fill details: Title, Name, Email, Password, Date of birth
    // 10. Select checkbox 'Sign up for our newsletter!'
    // 11. Select checkbox 'Receive special offers from our partners!'
    pageLoginSignup.fillAccountInformation("Mr", "TestingUser2", "TestingUser2@gmail.com", "@Darksoul1234560", "16", "March", "1999");

    // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    pageLoginSignup.fillAddressInformation("Tai", "Nguyen", "Company A", "123 Business Road, Suite 400", "123 Business Road, Suite 401",
        "Canada", "British Columbia", "British Columbia", "123456789", "123456789");

    // 13. Click 'Create Account button'
    pageLoginSignup.clickOnCreateAccount();

    // 14. Verify that 'ACCOUNT CREATED!' is visible
    pageAccountCreated.verifyAccountCreatedIsVisible();

    // 15. Click 'Continue' button
    pageAccountCreated.clickOnContinue();

    // 16. Verify that 'Logged in as username' is visible
    pageHome.verifyLoggedInAsUserIsVisible("TestingUser2");

    // 17. Click 'Delete Account' button
    pageHome.deleteAccount();

    // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    pageAccountDeleted.verifyAccountDeletedPageIsDisplayed();
    pageAccountDeleted.clickOnContinue();
  }

  @AfterMethod
  public void afterMethod() {
    driver.close();
  }
}
