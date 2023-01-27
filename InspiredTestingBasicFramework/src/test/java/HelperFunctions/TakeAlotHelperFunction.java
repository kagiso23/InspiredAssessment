package HelperFunctions;

import Pages.TakeAlotPage;
import Pages.TestBase;
import Utilities.JsonUtil;
import com.google.gson.JsonObject;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import storage.Constants;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TakeAlotHelperFunction extends TestBase {

    public static final String loginDetailsJsonFilePath ="resources/LoginDetails.json" ;
     static TakeAlotPage takeAlotPage;


    public static void getLoginDetails() throws Exception {
        takeAlotPage = new TakeAlotPage(driver);
        JsonObject login = JsonUtil.readJSON("LoginDetails",loginDetailsJsonFilePath);
        String valueEmail = String.valueOf(login.get("emailAddress"));
        String valuePassword = String.valueOf(login.get("password"));
        String emailAddress =  valueEmail.substring(1, valueEmail.length() - 1);
        takeAlotPage.field_emailAddress.sendKeys(emailAddress);
        String password = valuePassword.substring(1, valuePassword.length() - 1);
        takeAlotPage.field_Password.sendKeys(password);
    }
    public static String getScreenshot(WebDriver driver, String ScreenShotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = "C:\\paymentsendtoenduitests\\screenshots\\" + ScreenShotName + " " + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    public static void addProductToTheCart()
    {
        List<WebElement> listProducts = driver.findElements(By.xpath(Constants.listOfProductByXpath));
        List<WebElement> listAddToCart = driver.findElements(By.xpath(Constants.addToCartButtonByXpath));

        if(listProducts != null)
        {
            if(listAddToCart!=null){
                listAddToCart.get(1).click();
            }
        }
    }
    public static void verifyIfProductIsInTheCart()
    {
        List<WebElement> listProducts = driver.findElements(By.xpath(Constants.listOfAddedProductInTheCartByXpath));
        if(listProducts != null)
        {
            logger.createNode("The product is added to the Cart successfully");
        }
    }

}
