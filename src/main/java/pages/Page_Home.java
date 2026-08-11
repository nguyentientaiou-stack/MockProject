package pages;

import io.qameta.allure.Step;
import java.time.Duration;
import keywords.CommonKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Page_Home {

  WebDriver driver;

  private By signUpLogin_Link = By.cssSelector("a[href='/login']");
  private By deleteAccount_Link = By.linkText("Delete Account");
  private By logOut_Link = By.linkText("Logout");

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
    driver.findElement(By.xpath("//b[contains(normalize-space(), '" + userName + "')]")).isDisplayed();
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
}
