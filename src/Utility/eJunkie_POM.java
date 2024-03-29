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
    public WebElement debitCard;

    @FindBy(css = "input[type='email']")
    public WebElement email;

    @FindBy(css = "input[placeholder='Confirm Email']")
    public WebElement emailConfirm;

    @FindBy(xpath = "//input[@autocomplete='name']")
    public WebElement name;

    @FindBy(xpath = "//iframe[contains(@name,'__privateStripeFrame')]")
    public WebElement frame2;

    @FindBy(xpath = "//*[@autocomplete='cc-number']")
    public WebElement cardNumber;

    @FindBy(css = "[class='Pay-Button']")
    public WebElement payButton;

    @FindBy(xpath = "//div[@id='SnackBar']//span")
    public WebElement message;

    @FindBy(xpath = "//button[text()='Add Promo Code']")
    public WebElement addPromoCode;

    @FindBy(css = "input[class='Promo-Code-Value']")
    public WebElement promoCode;

    @FindBy(xpath = "//button[text()='Apply']")
    public WebElement apply;

    @FindBy(xpath = "//input[@autocomplete='cc-exp']")
    public WebElement expirationDate;

    @FindBy(css = "input[autocomplete='cc-csc']")
    public WebElement cvc;

    @FindBy(xpath = "//p[@class='Billing-Phone Inline']/input")
    public WebElement phoneNo;

    @FindBy(xpath = "//p[@class='Billing-Company']/input")
    public WebElement company;

    @FindBy(xpath = "//p[@class='BuyerNotes']/textarea")
    public WebElement note;

    @FindBy(xpath = "//span[contains(text(), 'your order is confirmed. Thank you!')]")
    public WebElement message2;

    @FindBy(xpath = "//*[text()='Add to Cart']")
    public WebElement addToCart;

    @FindBy(css = "[data-option='CC']")
    public WebElement addToCart2;

    @FindBy(css = "[autocomplete='address-1']")
    public WebElement address;

    @FindBy(css = "[placeholder='City']")
    public WebElement city;

    @FindBy(css = "[autocomplete='country']")
    public WebElement country;

    @FindBy(xpath = "//div[@class='Billing-Form Form']/p[11]/input")
    public WebElement zipCode;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement payButton2;

    @FindBy(linkText = "Download")
    public WebElement download;

    @FindBy(css = "div[class='wrapper']")
    public List<WebElement> ad;

    @FindBy(css = "div[class='ytp-time-display notranslate'] span span:nth-child(1)")
    public WebElement timeDisp;

    @FindBy(css = "[onclick='toggleYoutubeModal(true)']")
    public WebElement seeHowItWorks;

    @FindBy(css = "div[class='modal youtube-modal is-active'] iframe")
    public WebElement frame;

    @FindBy(linkText = "E-commerce by E-junkie")
    public WebElement eCommerce;

    @FindBy(xpath = "//*[@href='/']")
    public WebElement eJunkieLogo;

    @FindBy(linkText = "Contact Us")
    public WebElement ContactUs;

    @FindBy(xpath = "//*[@name='sender_name']")
    public WebElement namee;

    @FindBy(css = "[name='sender_email']")
    public WebElement emaill;

    @FindBy(id = "sender_subject")
    public WebElement sender;

    @FindBy(id = "sender_message")
    public WebElement messagee;

    @FindBy(id = "send_message_button")
    public WebElement butonn;

    @FindBy(css = "[class='col-md-6 col-sm-6 col-xs-6 text-right']>span")
    public WebElement total;

    @FindBy(xpath = "//span[text()='Download']")
    public WebElement download2;
}