import Utility.BaseDriver;
import Utility.Tools;
import Utility.eJunkie_POM;
import org.junit.Assert;
import org.junit.Test;

public class TC_302 extends BaseDriver {
    @Test
    public void TC_302() {
        driver.get("https://shopdemo.e-junkie.com/");

        Utility.eJunkie_POM elements = new eJunkie_POM();

        elements.eBookAdd.click();
        driver.switchTo().frame(elements.frame1);
        Assert.assertTrue("Product couldn't find!", Tools.ListContainsString(elements.cartItems, "Demo eBook"));
        elements.debitCard.click();
        Assert.assertTrue("Place holder doesn't exist!", elements.email.isDisplayed());
        Assert.assertTrue("Confirm place holder doesn't exist!", elements.emailConfirm.isDisplayed());
        Assert.assertTrue("Name on card doesn't exist!", elements.name.isDisplayed());
        driver.switchTo().frame(elements.frame2);
        Assert.assertTrue("Card number doesn't exist!", elements.cardNumber.isDisplayed());
        Assert.assertNotNull("Date doesn't exist!", elements.expirationDate);
        Assert.assertNotNull("CVC is doesn't exist!", elements.cvc);
        driver.switchTo().parentFrame();
        dAct.moveToElement(elements.payButton).click().build().perform();
        Assert.assertTrue("Not found!", elements.message.getText().contains("Invalid Email"));
        Assert.assertTrue("Billing name not found!", elements.message.getText().contains("Invalid Billing Name"));

        WaitAndClose();
    }
}