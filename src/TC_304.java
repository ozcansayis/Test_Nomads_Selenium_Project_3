import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_304 extends BaseDriver {
    @Test
    public void TC_304() {
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement addToCart = driver.findElement(By.xpath("//*[@id='products']/div[1]/div/div[2]/a/div/div[2]/button"));
        addToCart.click();

        driver.switchTo().frame(driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']")));

        WebElement PaymentButton = driver.findElement(By.cssSelector("[data-option='CC']"));
        PaymentButton.click();

        WebElement email = driver.findElement(By.cssSelector("[placeholder='Email']"));
        email.sendKeys("Nomads@gmail.com");

        WebElement confirmEmail = driver.findElement(By.cssSelector("[placeholder='Confirm Email']"));
        confirmEmail.sendKeys("Nomads@gmail.com");

        WebElement name = driver.findElement(By.cssSelector("[placeholder='Name On Card']"));
        name.sendKeys("Nomads");

        WebElement phone = driver.findElement(By.xpath("//p[@class='Billing-Phone Inline']/input"));
        phone.sendKeys("0531 531 53 53");

        WebElement Company = driver.findElement(By.xpath("//p[@class='Billing-Company']/input"));
        Company.sendKeys("NOMADS OF TURKEY");

        WebElement not = driver.findElement(By.xpath("//p[@class='BuyerNotes']/textarea"));
        not.sendKeys("I LOVE MY COUNTRY");

        driver.switchTo().frame(driver.findElement(By.cssSelector("[name^='__privateStripeFrame']")));

        WebElement CartNo = driver.findElement(By.name("cardnumber"));
        CartNo.sendKeys("4242 4242 4242 4242");

        WebElement Data = driver.findElement(By.name("exp-date"));
        Data.sendKeys("12/24");

        WebElement CVC = driver.findElement(By.name("cvc"));
        CVC.sendKeys("000");

        driver.switchTo().parentFrame();

        WebElement PayButton = driver.findElement(By.cssSelector("button[class='Pay-Button']"));
        PayButton.click();

        WebElement msg = driver.findElement(By.xpath("//span[text()=' your order is confirmed. Thank you!']"));
        Assert.assertTrue("Incorrect message!", msg.getText().contains("your order is confirmed. Thank you!"));

        WaitAndClose();
    }
}