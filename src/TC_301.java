import Utility.BaseDriver;

import Utility.Tools;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class TC_301 extends BaseDriver {
    @Test
    public void TC_301() {
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement addToCart = driver.findElement(By.xpath("(//*[@class='basicDetails'])[2]/button"));
        addToCart.click();

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='EJIframeV3 EJOverlayV3']")));

        List<WebElement> yourCart = driver.findElements(By.xpath("//div[@class='Col2 Product-Desc']/h5"));

        Assert.assertTrue("The product was not added to the cart.", Tools.ListContainsString(yourCart, "Demo eBook"));

        WebElement addPromoCode = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Add Promo Code']"))));
        addPromoCode.click();

        WebElement promoCode = driver.findElement(By.cssSelector("input[class='Promo-Code-Value']"));
        promoCode.sendKeys("123");

        WebElement apply = driver.findElement(By.xpath("//button[text()='Apply']"));
        apply.click();

        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='SnackBar']/span"), "Invalid promo code"));
        WebElement message = driver.findElement(By.xpath("//div[@id='SnackBar']/span"));
        Assert.assertTrue("No error message displayed.", message.isDisplayed());

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Invalid promo code']")));

        WaitAndClose();
    }
}