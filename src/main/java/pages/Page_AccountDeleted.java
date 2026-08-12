package pages;

import io.qameta.allure.Step;
import keywords.CommonKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Page_AccountDeleted {
  WebDriver driver;

  private By accountDeleted_Text = By.xpath("//b[contains(normalize-space(),'Account Deleted!')]");
  private By countinue_Button = By.cssSelector("[data-qa='continue-button']");

  public Page_AccountDeleted(WebDriver driver) {
    this.driver = driver;
  }

  @Step("Verify Account Deleted page is visible.")
  public void verifyAccountDeletedPageIsDisplayed(){

    Assert.assertTrue(driver.findElement(accountDeleted_Text).isDisplayed());
    Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/delete_account");
    CommonKeywords common = new CommonKeywords(driver);
    common.screenshot();
  }

  @Step("Click on Continue.")
  public void clickOnContinue()
  {
    driver.findElement(countinue_Button).click();
  }
}
