package pages;

import java.time.Duration;
import java.util.List;
import keywords.CommonKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    }
  }

  public void clickOnViewProduct(int atProduct){
    WebElement viewProduct = driver.findElements(viewProductlinks).get(atProduct);
    viewProduct.click();
  }

  public void verifyUserIsLandedToProductDetail(String urlOfProductDetail){
    Assert.assertEquals(driver.getCurrentUrl(), urlOfProductDetail);
  }

  public void verifyDetailOfProductIsVisible(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement productName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-information']/h2")));
    WebElement category = driver.findElement(By.xpath("//div[@class='product-information']/p[contains(text(), 'Category')]"));
    WebElement price = driver.findElement(By.xpath("//div[@class='product-information']/span/span"));
    WebElement availability = driver.findElement(By.xpath("//p[b[contains(text(), 'Availability:')]]"));
    WebElement condition = driver.findElement(By.xpath("//p[b[contains(text(), 'Condition:')]]"));
    WebElement brand = driver.findElement(By.xpath("//p[b[contains(text(), 'Brand:')]]"));

    // Assertions
    Assert.assertTrue(productName.isDisplayed(), "Product Name is missing!");
    Assert.assertTrue(category.isDisplayed(), "Category is missing!");
    Assert.assertTrue(price.isDisplayed(), "Price is missing!");
    Assert.assertTrue(availability.isDisplayed(), "Availability detail is missing!");
    Assert.assertTrue(condition.isDisplayed(), "Condition detail is missing!");
    Assert.assertTrue(brand.isDisplayed(), "Brand detail is missing!");

    // Print extracted details to console
    System.out.println("Product Name: " + productName.getText());
    System.out.println("Category: " + category.getText());
    System.out.println("Price: " + price.getText());
    System.out.println("Availability: " + availability.getText());
    System.out.println("Condition: " + condition.getText());
    System.out.println("Brand: " + brand.getText());
  }
}
