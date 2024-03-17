package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class eJunkie_POM {
    public eJunkie_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "(//button[@class='view_product'])[2]")
    public WebElement eBookAdd;

    @FindBy(css = "[class='EJIframeV3 EJOverlayV3']")
    public WebElement frame1;

    @FindBy(css = "div[class='Col2 Product-Desc']>h5")
    public List<WebElement> cartItems;

    @FindBy(css = "button[data-option='CC']")
    public WebElement debirCard;

    @FindBy(css = "input[type='email']")
    public WebElement email;

    @FindBy(css = "input[placeholder='Confirm Email']")
    public WebElement emailConfirm;

    @FindBy(xpath = "//input[@autocomplete='name']")
    public WebElement name;

    @FindBy(xpath = "//iframe[contains(@name,'__privateStripeFrame')]")
    public WebElement frame2;

    @FindBy(xpath = "//*[@name='cardnumber']")
    public WebElement cardNumber;

    @FindBy(css = "[class='Pay-Button']")
    public WebElement payButton;

    @FindBy(xpath = "//div[@id='SnackBar']//span")
    public WebElement invalidCardNumber;
}