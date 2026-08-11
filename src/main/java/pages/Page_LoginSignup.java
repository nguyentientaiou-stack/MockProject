package pages;

import io.qameta.allure.Step;
import keywords.CommonKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Page_LoginSignup {
  WebDriver driver;

  private By newUserSignup_Header = By.xpath("//h2[normalize-space()='New User Signup!']");
  private By newSignUpName_Textbox = By.cssSelector("[data-qa='signup-name']");
  private By newSignUpEmail_Textbox = By.cssSelector("[data-qa='signup-email']");
  private By signUp_Button = By.cssSelector("[data-qa='signup-button']");
  private By enterAccountInformation_Text = By.xpath("//b[normalize-space()='Enter Account Information']");
  private By titleMr_Radiobutton = By.xpath("//input[@id='id_gender1']");
  private By titleMrs_Radiobutton = By.xpath("//input[@id='id_gender2']");
  private By accountInformationName_Textbox = By.xpath("//input[@id='name']");
  private By accountInformationPassword_Textbox = By.xpath("//input[@id='password']");
  private By accountInformationDayOfBirth_Combobox = By.cssSelector("[data-qa='days']");
  private By accountInformationMonthOfBirth_Combobox = By.cssSelector("[data-qa='months']");
  private By accountInformationYearOfBirth_Combobox = By.cssSelector("[data-qa='years']");
  private By signUpForOurNewsletter_Checkbox = By.xpath("//input[@id='newsletter']");
  private By receiveSpecialOffersFromOurPartners_Checkbox = By.xpath("//input[@id='optin']");
  private By addressInformationFirstName_Textbox = By.id("first_name");
  private By addressInformationLastName_Textbox = By.id("last_name");
  private By addressInformationCompany_Textbox = By.id("company");
  private By addressInformationAddress1_Textbox = By.id("address1");
  private By addressInformationAddress2_Textbox = By.id("address2");
  private By addressInformationCountry_Combobox = By.id("country");
  private By addressInformationState_Textbox = By.id("state");
  private By addressInformationCity_Textbox = By.id("city");
  private By addressInformationZipcode_Textbox = By.id("zipcode");
  private By addressInformationMobileNumber_Textbox = By.id("mobile_number");
  private By createAccount_Button = By.xpath("//button[normalize-space()='Create Account']");
  private By loginToYourAccount_Header = By.xpath("//h2[contains(normalize-space(),'Login to your account')]");
  private By loginToAccountEmail_Textbox = By.cssSelector("[data-qa='login-email']");
  private By loginToAccountPassword_Textbox = By.cssSelector("[data-qa='login-password']");
  private By login_Button = By.cssSelector("[data-qa='login-button']");
  private By yourEmailOrPasswordIncorrect_Textbox = By.xpath("//p[normalize-space()='Your email or password is incorrect!']");
  private By emailAlreadyExist_Textbox = By.xpath("//p[contains(normalize-space(),'Email Address already exist!')]");

  public Page_LoginSignup(WebDriver driver) {
    this.driver = driver;
  }

  @Step("Verify that login page is visible.")
  public void verifyLoginPageIsVisible(){
    Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");
  }

  @Step("Verify that New User Sign Up is visible.")
  public void verifyNewUserSignUpIsVisible(){
    driver.findElement(newUserSignup_Header).isDisplayed();
  }

  @Step("Fill user name and email to sign up new account.")
  public void signUpUser(String username, String email) {
    driver.findElement(newSignUpName_Textbox).clear();
    driver.findElement(newSignUpName_Textbox).sendKeys(username);
    driver.findElement(newSignUpEmail_Textbox).clear();
    driver.findElement(newSignUpEmail_Textbox).sendKeys(email);
    driver.findElement(signUp_Button).click();
  }

  @Step("Verify that Enter Account Information is visible")
  public void verifyEnterAccountInformationIsVisible() {
    driver.findElement(enterAccountInformation_Text).isDisplayed();
    CommonKeywords common = new CommonKeywords(driver);
    common.screenshot();
  }

  @Step("Fill account's information")
  public void fillAccountInformation(String title, String name, String email, String password, String DOB_day, String DOB_month, String DOB_year) {
    if (title == "Mr")
    {
      driver.findElement(titleMr_Radiobutton).click();
    }
    else {
      driver.findElement(titleMrs_Radiobutton).click();
    }

    driver.findElement(accountInformationName_Textbox).clear();
    driver.findElement(accountInformationName_Textbox).sendKeys(name);

    String emailInForm = driver.findElement(By.id("email")).getAttribute("value");
    Assert.assertEquals(email, emailInForm);

    driver.findElement(accountInformationPassword_Textbox).clear();
    driver.findElement(accountInformationPassword_Textbox).sendKeys(password);

    Select select_day = new Select(driver.findElement(accountInformationDayOfBirth_Combobox));
    select_day.selectByValue(DOB_day);
    Select select_month = new Select(driver.findElement(accountInformationMonthOfBirth_Combobox));
    select_month.selectByVisibleText(DOB_month);
    Select select_year = new Select(driver.findElement(accountInformationYearOfBirth_Combobox));
    select_year.selectByValue(DOB_year);

    driver.findElement(signUpForOurNewsletter_Checkbox).click();
    driver.findElement(receiveSpecialOffersFromOurPartners_Checkbox).click();
  }

  @Step("Fill address's information.")
  public void fillAddressInformation(String firstName, String lastName, String company, String address, String address_2, String country, String state, String city, String zipcode, String mobileNumber) {
    driver.findElement(addressInformationFirstName_Textbox).clear();
    driver.findElement(addressInformationFirstName_Textbox).sendKeys(firstName);
    driver.findElement(addressInformationLastName_Textbox).clear();
    driver.findElement(addressInformationLastName_Textbox).sendKeys(lastName);
    driver.findElement(addressInformationCompany_Textbox).clear();
    driver.findElement(addressInformationCompany_Textbox).sendKeys(company);
    driver.findElement(addressInformationAddress1_Textbox).clear();
    driver.findElement(addressInformationAddress1_Textbox).sendKeys(address);
    driver.findElement(addressInformationAddress2_Textbox).clear();
    driver.findElement(addressInformationAddress2_Textbox).sendKeys(address_2);
    Select select_country = new Select(driver.findElement(addressInformationCountry_Combobox));
    select_country.selectByValue(country);
    driver.findElement(addressInformationState_Textbox).clear();
    driver.findElement(addressInformationState_Textbox).sendKeys(state);
    driver.findElement(addressInformationCity_Textbox).clear();
    driver.findElement(addressInformationCity_Textbox).sendKeys(city);
    driver.findElement(addressInformationZipcode_Textbox).clear();
    driver.findElement(addressInformationZipcode_Textbox).sendKeys(zipcode);
    driver.findElement(addressInformationMobileNumber_Textbox).clear();
    driver.findElement(addressInformationMobileNumber_Textbox).sendKeys(mobileNumber);
  }

  @Step("Click on Create Account.")
  public void clickOnCreateAccount() {
    driver.findElement(createAccount_Button).click();
  }

  @Step("Verify Login To Your Account is visible.")
  public void verifyLoginToYourAccountIsVisible(){
    driver.findElement(loginToYourAccount_Header).isDisplayed();
    CommonKeywords common = new CommonKeywords(driver);
    common.screenshot();
  }

  @Step("Fill email and password to login")
  public void loginToAccount(String email, String password){
    driver.findElement(loginToAccountEmail_Textbox).clear();
    driver.findElement(loginToAccountEmail_Textbox).sendKeys(email);
    driver.findElement(loginToAccountPassword_Textbox).clear();
    driver.findElement(loginToAccountPassword_Textbox).sendKeys(password);
    driver.findElement(login_Button).click();
  }

  @Step("Verify Your Email Or Password Incorrect notification is visible.")
  public void verifyNotificationYourEmailOrPasswordIncorrectIsVisible(){
    driver.findElement(yourEmailOrPasswordIncorrect_Textbox).isDisplayed();
    CommonKeywords common = new CommonKeywords(driver);
    common.screenshot();
  }

  @Step("Verify Email Already Exist notification is visible.")
  public void verifyNotificationEmailAlreadyExistIsVisible(){
    driver.findElement(emailAlreadyExist_Textbox).isDisplayed();
    CommonKeywords common = new CommonKeywords(driver);
    common.screenshot();
  }
}
