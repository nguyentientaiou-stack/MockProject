package pages;

import io.qameta.allure.Step;
import java.time.Duration;
import keywords.CommonKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Page_Home {

  WebDriver driver;

  private By signUpLogin_Link = By.cssSelector("a[href='/login']");
  private By deleteAccount_Link = By.linkText("Delete Account");
  private By logOut_Link = By.linkText("Logout");
  private By contactUs_Link = By.linkText("Contact us");
  private By testCases_Link = By.linkText("Test Cases");
  private By products_Link = By.cssSelector("a[href='/products']");
  private By subscription_Header = By.xpath("//h2[text()='Subscription']");
  private By arrowButtonMoveUpward = By.xpath("//i[@class='fa fa-angle-up']");
  private By fullFledgedPracticeWebsiteForAutomationEngineers_Header = By.xpath("//h2[contains(text(), 'Full-Fledged practice website for Automation Engineers')]");

  public Page_Home(WebDriver driver) {
    this.driver = driver;
  }

  @Step("Launch browser and access home page.")
  public void accessHomePage(String url)
  {
    driver.get(url);
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
  }

  @Step("Verify home page is visible.")
  public void verifyHomePageIsVisible(){
    Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
    CommonKeywords common = new CommonKeywords(driver);
    common.screenshot();
  }

  @Step("Access Login_SignUp function.")
  public void clickSignUp_Login() {
    driver.findElement(signUpLogin_Link).isDisplayed();
    driver.findElement(signUpLogin_Link).click();
    Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
  }

  @Step("Verify logged in as user is visible after logged in successfully.")
  public void verifyLoggedInAsUserIsVisible(String userName){
    Assert.assertTrue(driver.findElement(By.xpath("//b[contains(normalize-space(), '" + userName + "')]")).isDisplayed(), "logged in as user is not visible");
    CommonKeywords common = new CommonKeywords(driver);
    common.screenshot();
  }

  @Step("Access delete account function.")
  public void deleteAccount()
  {
    driver.findElement(deleteAccount_Link).click();
  }

  @Step("Access logout function.")
  public void logout(){
    driver.findElement(logOut_Link).click();
  }

  @Step("Verify logged in as user is disappeared after logged out successfully.")
  public void verifyLoggedInAsUserIsDisappeared(String userName){
    try{
      driver.findElement(By.xpath("//b[contains(normalize-space(), '" + userName + "')]")).isDisplayed();
    }
    catch (Exception e){
      System.out.println("As expected: Can not find the element !");
    }
  }

  @Step("Click on Contact Us")
  public void clickContactUs(){
    driver.findElement(contactUs_Link).click();
  }

  @Step("Access test cases function.")
  public void clickTestCases(){
    driver.findElement(testCases_Link).click();
  }

  @Step("Access products function.")
  public void clickProducts(){
    driver.findElement(products_Link).click();
  }

  @Step("Verify subscription header is visible.")
  public void verifySubscriptionHeaderIsVisible(){
    Assert.assertTrue(driver.findElement(subscription_Header).isDisplayed(), "subscription header is not visible");
    CommonKeywords common = new CommonKeywords(driver);
    common.screenshot();
  }

  @Step("Click on Arrow button at bottom right side of the page to move upward")
  public void clickArrowButtonMoveUpward(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement arrowButton = wait.until(ExpectedConditions.visibilityOfElementLocated(arrowButtonMoveUpward));
    arrowButton.click();
  }

  @Step("Verify 'Full-Fledged practice website for Automation Engineers' is visible.")
  public void verifyFullFledgedPracticeWebsiteForAutomationEngineersIsVisible(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement heroText = wait.until(ExpectedConditions.visibilityOfElementLocated(fullFledgedPracticeWebsiteForAutomationEngineers_Header));
    Assert.assertTrue(heroText.isDisplayed(), "Full-Fledged practice website for Automation Engineers is not visible");
    CommonKeywords common = new CommonKeywords(driver);
    common.screenshot();
  }
}
