package pages;

import io.qameta.allure.Step;
import keywords.CommonKeywords;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.File;

public class Page_ContactUs {

  WebDriver driver;

  public Page_ContactUs(WebDriver driver) {
    this.driver = driver;
  }

  private By getInTouch_Header = By.xpath("//h2[normalize-space()='Get In Touch']");
  private By name_Textbox = By.cssSelector("[name='name']");
  private By email_Textbox = By.cssSelector("[name='email']");
  private By subject_Textbox = By.cssSelector("[name='subject']");
  private By message_Textbox = By.cssSelector("#message");
  private By inputFile = By.xpath("//input[@name='upload_file']");
  private By submit_Button = By.cssSelector("[name='submit']");
  private By successMessage_Text = By.xpath("//div[normalize-space()='Success! Your details have been submitted successfully.']");
  private By home_Button = By.cssSelector(".btn.btn-success");

  @Step("Verify Get In Touch is visible.")
  public void verifyGetInTouchIsVisible(){
    driver.findElement(getInTouch_Header).isDisplayed();
    CommonKeywords common = new CommonKeywords(driver);
    common.screenshot();
  }

  @Step("Fill all Get In Touch Information.")
  public void fillGetInTouchInformation(String name, String email, String subject, String message){
    driver.findElement(name_Textbox).sendKeys(name);
    driver.findElement(email_Textbox).sendKeys(email);
    driver.findElement(subject_Textbox).sendKeys(subject);
    driver.findElement(message_Textbox).sendKeys(message);
  }

  @Step("Upload file in Get In Touch.")
  public void uploadFile(String path){
    File file = new File(path);
    String absolutePath = file.getAbsolutePath();
    driver.findElement(inputFile).sendKeys(absolutePath);
  }

  @Step("Click on Submit button.")
  public void clickOnSubmit(){
    driver.findElement(submit_Button).click();
  }

  @Step("Handle alert popup after uploaded the file.")
  public void alertPopUp(String button){
    Alert pompt =  driver.switchTo().alert();
    if (button == "OK")
    {
      pompt.accept();
    }
    else
    {
      pompt.dismiss();
    }
  }

  @Step("Verify success message 'Success! Your details have been submitted successfully' is visible.")
  public void verifySuccessMessageIsVisible(){
    driver.findElement(successMessage_Text).isDisplayed();
    CommonKeywords common = new CommonKeywords(driver);
    common.screenshot();
  }

  @Step("Click on Home Button.")
  public void clickOnHomeButton(){
    driver.findElement(home_Button).click();
  }
}
