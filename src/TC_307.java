import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TC_307 extends BaseDriver {
    @Test
    public void TC_307() {

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement e_junkie=driver.findElement(By.linkText("E-commerce by E-junkie"));
        dAct.moveToElement(e_junkie).click().build().perform();

        WebElement logo= driver.findElement(By.xpath("//*[@href='/']"));
        dAct.moveToElement(logo).click().build().perform();

        //Assert.assertTrue(logo.getText().toLowerCase().equals("https://www.e-junkie.com/"));

        Assert.assertFalse(driver==logo, "Hata mesajı alındı");

        WaitAndClose();
    }
}