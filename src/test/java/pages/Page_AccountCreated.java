package pages;

import io.qameta.allure.Step;
import keywords.CommonKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Page_AccountCreated {
  WebDriver driver;

  private By accountCreated_Text = By.xpath("//b[contains(normalize-space(),'Account Created!')]");
  private By continue_Button = By.cssSelector("[data-qa='continue-button']");

  public Page_AccountCreated(WebDriver driver) {
    this.driver = driver;
  }

  @Step("Verify Account Created page is visible.")
  public void verifyAccountCreatedIsVisible(){
    Assert.assertTrue(driver.findElement(accountCreated_Text).isDisplayed(), "Account Created page is not visible.");
    Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/account_created");
    CommonKeywords common = new CommonKeywords(driver);
    common.screenshot();
  }

  @Step("Click on Continue.")
  public void clickOnContinue(){
    driver.findElement(continue_Button).click();
  }
}
