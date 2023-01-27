package Pages;

import Utilities.JsonUtil;
import com.google.gson.JsonObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import storage.Constants;

public class TakeAlotPage extends TestBase {


    @FindBy(xpath = Constants.loginLinkByXpath)
    public WebElement link_Login;
    @FindBy(id = Constants.emailAddressFieldById)
    public WebElement field_emailAddress;
    @FindBy(id = Constants.passwordFieldById)
    public WebElement field_Password;
    @FindBy(xpath = Constants.reCAPTCHACheckBoxByXpath)
    public WebElement checkBox_reCAPTCHA;
    @FindBy(xpath = Constants.loginButtonByXpath)
    public WebElement btn_Login;
    @FindBy(xpath = Constants.addedToCartTextByXpath)
    public WebElement txt_AddedToCart;
    @FindBy(xpath = Constants.addToCartButtonByXpath)
    public WebElement btn_AddToCart;
    @FindBy(xpath = Constants.cartButtonByXpath)
    public WebElement btn_Cart;
    @FindBy(xpath = Constants.cartTextByXpath)
    public WebElement txt_Cart;
    @FindBy(name = Constants.searchBoxByName)
    public WebElement box_Search;
    @FindBy(xpath = Constants.searchButtonByXpath)
    public WebElement btn_Search;
    @FindBy(xpath = Constants.cookieButtonByXpath)
    public WebElement btn_Cookie;


    public TakeAlotPage(WebDriver driver) throws Exception {

        PageFactory.initElements(new AjaxElementLocatorFactory(driver,60),this);
    }
}
