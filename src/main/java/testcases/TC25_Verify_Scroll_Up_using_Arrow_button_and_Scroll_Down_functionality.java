package testcases;

import keywords.CommonKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Page_Home;

public class TC25_Verify_Scroll_Up_using_Arrow_button_and_Scroll_Down_functionality {

  WebDriver driver;

  @BeforeMethod
  public void beforeMethod() {
    CommonKeywords common = new CommonKeywords(driver);
    driver = common.getDriver("chrome");
    driver.manage().window().maximize();
  }

  @Test
  public void verifyScrollUpUsingArrowButtonAndScrollDownFunctionality(){
    Page_Home pageHome = new Page_Home(driver);

    // 1. Launch browser
    // 2.Navigate to url 'http://automationexercise.com'
    pageHome.accessHomePage("https://automationexercise.com/");

    // 3. Verify that home page is visible successfully
    pageHome.verifyHomePageIsVisible();

    // 4. Scroll down page to bottom
    JavascriptExecutor js = (JavascriptExecutor) driver;
    /*WebElement subscriptionHeader = driver.findElement(subscription_Header);

    js.executeScript("arguments[0].scrollIntoView(true);", subscriptionHeader);

    Actions actions = new Actions(driver);
    actions.scrollToElement(pageHome.subscriptionHeader).perform();*/

    js.executeScript("window.scrollTo(0, document.body.scrollHeight);"); //scroll to the bottom of the page

    // 5. Verify 'SUBSCRIPTION' is visible
    pageHome.verifySubscriptionHeaderIsVisible();

    // 6. Scroll up page to top
    pageHome.clickArrowButtonMoveUpward();

    // 7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
    pageHome.verifyFullFledgedPracticeWebsiteForAutomationEngineersIsVisible();
  }

  @AfterMethod
  public void afterMethod() {
    driver.close();
  }

}
