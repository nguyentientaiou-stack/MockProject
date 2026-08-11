package keywords;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.TakesScreenshot;

public class CommonKeywords {

  WebDriver driver;

  public CommonKeywords(WebDriver driver) {
    this.driver = driver;
  }

  public WebDriver getDriver(String browser) {
    switch (browser) {
      case "firefox":
        driver = new FirefoxDriver();
      case "chrome": {
        driver = new ChromeDriver();
      }
    }
    return driver;
  }

  @Attachment(value = "Page screenshot", type = "image/png")
  public byte[] screenshot() {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  @Attachment(value = "{0}", type = "text/plain")
  public String log (String message)
  {
    return message;
  }
}
