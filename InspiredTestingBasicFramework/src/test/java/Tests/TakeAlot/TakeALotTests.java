package Tests.TakeAlot;
import HelperFunctions.TakeAlotHelperFunction;
import Pages.*;
import Utilities.WebDriverAdapter;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import storage.Constants;

public class TakeALotTests extends TestBase {
    TakeAlotPage takeAlotPage;

    @BeforeTest
    public void before() throws Exception {
        super.before();
        takeAlotPage = new TakeAlotPage(driver);
    }

    @Test
    public void addProductToCart() throws Exception {
        logger = extent.createTest("[" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
        try {
            logger.createNode("Step : opening takealot webiste");
            driver.get(aut_url);
            WebDriverAdapter.waitUntilObjectVisible(driver, By.name(Constants.searchBoxByName));
            logger.createNode("Step : Search for a product");
            takeAlotPage.btn_Cookie.click();
            takeAlotPage.box_Search.sendKeys("ECCO 32 LED HD Ready TV LH32");
            takeAlotPage.btn_Search.click();
            WebDriverAdapter.waitUntilObjectVisible(driver, By.xpath(Constants.addToCartButtonByXpath));
            logger.createNode("Step : Add a product to a cart");
            TakeAlotHelperFunction.addProductToTheCart();
            takeAlotPage.btn_AddToCart.click();
            Assert.assertEquals(takeAlotPage.txt_AddedToCart.getText(),"Added to Cart");
            logger.createNode(takeAlotPage.txt_AddedToCart.getText());

        } catch (Exception e) {
            e.printStackTrace();
            TakeAlotHelperFunction.getScreenshot(driver, "Unable to Add product to a cart");
            logger.log(Status.FAIL, "Unable to Add product to a cart");
        }
    }
    //TC002
    @Test
    public void viewAddedProduct() throws Exception {
        logger = extent.createTest("[" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
        try {
            logger.createNode("Step : opening takealot webiste");
            driver.get(aut_url);
            WebDriverAdapter.waitUntilObjectVisible(driver, By.name(Constants.searchBoxByName));
            logger.createNode("Step : Search for a product");
            takeAlotPage.btn_Cookie.click();
            takeAlotPage.box_Search.sendKeys("ECCO 32 LED HD Ready TV LH32");
            takeAlotPage.btn_Search.click();
            WebDriverAdapter.waitUntilObjectVisible(driver, By.xpath(Constants.addToCartButtonByXpath));
            logger.createNode("Step : Add a product to a cart");
            TakeAlotHelperFunction.addProductToTheCart();
            takeAlotPage.btn_AddToCart.click();
            Assert.assertEquals(takeAlotPage.txt_AddedToCart.getText(),"Added to Cart");
            logger.createNode(takeAlotPage.txt_AddedToCart.getText());
            takeAlotPage.btn_Cart.click();
            WebDriverAdapter.waitUntilObjectVisible(driver, By.xpath(Constants.cartTextByXpath));
            Assert.assertEquals(takeAlotPage.txt_Cart.getText(),"Shopping Cart");
            TakeAlotHelperFunction.verifyIfProductIsInTheCart();

        } catch (Exception e) {
            e.printStackTrace();
            TakeAlotHelperFunction.getScreenshot(driver, "Unable to view added product on the cart");
            logger.log(Status.FAIL, "Unable to view added product on the cart");
        }
    }

}