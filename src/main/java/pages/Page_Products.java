package pages;

import java.util.List;
import keywords.CommonKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Page_Products {

  WebDriver driver;

  By allProducts_Header = By.xpath("//h2[normalize-space()='All Products']");
  By products = By.xpath("//div[@class='col-sm-4]");
  By viewProductlinks = By.linkText("View Product");


  public Page_Products(WebDriver driver) {
    this.driver = driver;
  }

  public void verifyProductsPageIsVisible() {
    Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
    CommonKeywords common = new CommonKeywords(driver);
    common.screenshot();
  }

  public void verifyProductsListIsVisible() {
    try {
      driver.findElement(allProducts_Header).isDisplayed();

      //Retrieve all product items and verify the list is not empty
      List<WebElement> productsList = driver.findElements(products);
      Assert.assertTrue(productsList.size() > 0, "No products found on the page.");

      System.out.println("Verification successful! Total products visible: " + productsList.size());

      // Verify individual products are displayed
      for (WebElement product : productsList) {
        Assert.assertTrue(product.isDisplayed(), "A product item is not visible in the list.");
      }

    } catch (Exception e) {
      System.err.println("Verification failed: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public void clickOnViewProduct(int atProduct){
    WebElement viewProduct = driver.findElements(viewProductlinks).get(atProduct);
    viewProduct.click();
  }

  public void verifyUserIsLandedToProductDetail(String urlOfProductDetail){
    Assert.assertEquals(driver.getCurrentUrl(), urlOfProductDetail);
  }
}
