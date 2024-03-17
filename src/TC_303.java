import Utility.BaseDriver;
import Utility.Tools;
import Utility.eJunkie_POM;
import org.junit.Assert;
import org.junit.Test;


public class TC_303 extends BaseDriver {
    @Test
    public void TC_303() {
        driver.get(" https://shopdemo.e-junkie.com/");
        Utility.eJunkie_POM elements= new eJunkie_POM();

        elements.eBookAdd.click();
        driver.switchTo().frame(elements.frame1);
        Assert.assertTrue("Item couldn't find in cart", Tools.ListContainsString(elements.cartItems,"Demo eBook"));
        elements.debirCard.click();
        elements.email.sendKeys("testnomads01@gmail.com");
        elements.emailConfirm.sendKeys("testnomads01@gmail.com");
        elements.name.sendKeys("Test Nomads");
        driver.switchTo().frame(elements.frame2);
        elements.cardNumber.sendKeys("1111 1111 1111 1111");
        driver.switchTo().parentFrame();
        elements.payButton.click();
        Assert.assertNotNull("\"Your card number is invalid.\" couldn't displayed",elements.invalidCardNumber);

        WaitAndClose();
    }
}