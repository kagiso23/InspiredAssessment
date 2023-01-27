package storage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Constants {

    public static final String loginLinkByXpath = "//a[text()='Login']";
    public static final String searchBoxByName = "search";
    public static final String searchButtonByXpath = "//button[@type='submit']";
    public static final String addedToCartTextByXpath = "//*[text()='Added to Cart']";
    public static final String cartButtonByXpath = "//div[@class='badge-button-module_badge-button-outer_1gN1K']";
    public static final String cartTextByXpath = "//h1[text()='Shopping Cart']";
    public static final String addToCartButtonByXpath = "//*[@class='button  expanded add-to-cart-button add-to-cart-button-module_add-to-cart-button_1a9gT ghost']";
    public static final String listOfProductByXpath = "//div[@class='product-card product-card-module_product-card_fdqa8']";
    public static final String listOfAddedProductInTheCartByXpath = "//article";
    public static final String emailAddressFieldById = "customer_login_email";
    public static final String passwordFieldById = "customer_login_password";
    public static final String reCAPTCHACheckBoxByXpath = "//div[@class='recaptcha-checkbox-border']";
    public static final String loginButtonByXpath = "//button[text()='Login']";
    public static final String cookieButtonByXpath = "//button[text()='Got it']";


}
