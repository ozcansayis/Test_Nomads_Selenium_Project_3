import Utility.BaseDriver;
import Utility.Tools;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;


import java.util.List;

public class TC_302 extends BaseDriver {
    @Test
    public void TC_302() {

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement addToCart = driver.findElement(By.xpath("(//*[@class='basicDetails'])[2]/button"));
        dAct.moveToElement(addToCart).click().build().perform();

        driver.switchTo().frame(driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']")));

        List<WebElement> validation=driver.findElements(By.cssSelector("[class='Col2 Product-Desc'] h5"));
        Assert.assertTrue("Product couldn't find!",Tools.ListContainsString(validation,"Demo eBook"));

        WebElement payment= driver.findElement(By.cssSelector("[class='Payment-Button CC']"));
        dAct.moveToElement(payment).click().build().perform();

        WebElement email= driver.findElement(By.cssSelector("[placeholder='Email']"));
        Assert.assertTrue("Place holder doesn't exist!",email.isDisplayed());

        WebElement confirmEmail=driver.findElement(By.cssSelector("[placeholder='Confirm Email']"));
        Assert.assertTrue("Confirm place holder doesn't exist!",confirmEmail.isDisplayed());

        WebElement nameOnCard=driver.findElement(By.xpath("//*[@autocomplete='name']"));
        Assert.assertTrue("Name on card doesn't exist!",nameOnCard.isDisplayed());

        driver.switchTo().frame(driver.findElement(By.cssSelector("[name^='__privateStripeFrame']")));

        WebElement cardNumber=driver.findElement(By.xpath("//input[@placeholder='Kart numarası']"));

        Assert.assertTrue(cardNumber.isDisplayed(), "card number doesnt exist");

        WebElement expirationDate = driver.findElement(By.xpath("//input[@placeholder='AA / YY']"));
        Assert.assertNotNull(expirationDate, "date doesnt exist");

        WebElement cvc= driver.findElement(By.cssSelector("input[placeholder='CVC']"));
        Assert.assertNotNull(cvc, "cvc is doesnt exist");

        driver.switchTo().parentFrame();

        WebElement pay= driver.findElement(By.cssSelector("[class='Pay-Button']"));
        dAct.moveToElement(pay).click().build().perform();

        WebElement fail= driver.findElement(By.xpath("//div[@id='SnackBar']/span"));
        Assert.assertTrue(fail.getText().contains("Invalid Email"), "not found");
        Assert.assertTrue(fail.getText().contains("Invalid Billing Name"), "billing not found");

        //System.out.println("fail.getText() = " + fail.getText());


        WaitAndClose();
    }
}