import Utility.BaseDriver;
import Utility.Tools;
import Utility.eJunkie_POM;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC_301 extends BaseDriver {
    @Test
    public void TC_301() {
        driver.get("https://shopdemo.e-junkie.com/");
        Utility.eJunkie_POM elements = new eJunkie_POM();
        elements.eBookAdd.click();
        driver.switchTo().frame(elements.frame1);
        Assert.assertTrue("The product was not added to the cart.", Tools.ListContainsString(elements.cartItems, "Demo eBook"));
        wait.until(ExpectedConditions.elementToBeClickable(elements.addPromoCode)).click();
        elements.promoCode.sendKeys("123");
        elements.apply.click();
        Assert.assertNotNull("No error message displayed.", elements.message);
        WaitAndClose();
    }
}