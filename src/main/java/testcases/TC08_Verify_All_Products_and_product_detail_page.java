package testcases;

import keywords.CommonKeywords;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Page_Home;
import pages.Page_Products;

public class TC08_Verify_All_Products_and_product_detail_page {
  WebDriver driver;

  @BeforeMethod
  public void beforeMethod() {
    CommonKeywords common = new CommonKeywords(driver);
    driver = common.getDriver("chrome");
    driver.manage().window().maximize();
  }

  @Test(description = "Verify all products and product detail pages.")
  public void verifyAllProductsAndProductDetailPages()
  {
    Page_Home pageHome = new Page_Home(driver);
    Page_Products pageProducts = new Page_Products(driver);

    // 1. Launch browser
    // 2.Navigate to url 'http://automationexercise.com'
    pageHome.accessHomePage("https://automationexercise.com/");

    // 3. Verify that home page is visible successfully
    pageHome.verifyHomePageIsVisible();

    // 4. Click on 'Products' button
    pageHome.clickProducts();

    // 5. Verify user is navigated to ALL PRODUCTS page successfully
    pageProducts.verifyProductsPageIsVisible();

    // 6. The products list is visible
    pageProducts.verifyProductsListIsVisible();

    // 7. Click on 'View Product' of first product
    pageProducts.clickOnViewProduct(0);

    // 8. User is landed to product detail page
    pageProducts.verifyUserIsLandedToProductDetail("https://automationexercise.com/product_details/1");

  }

  @AfterMethod
  public void afterMethod() {
    driver.close();
  }
}
