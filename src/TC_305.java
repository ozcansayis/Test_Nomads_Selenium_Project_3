import Utility.BaseDriver;
import Utility.eJunkie_POM;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class TC_305 extends BaseDriver {
    @Test
    public void TC_305() {
        driver.get("https://shopdemo.e-junkie.com/");
        Utility.eJunkie_POM element= new eJunkie_POM();

        element.eBookAdd.click();
        driver.switchTo().frame(element.frame1);
        element.debitCard.click();
        element.email.sendKeys("Nomads@gmail.com");
        element.emailConfirm.sendKeys("Nomads@gmail.com");
        element.name.sendKeys("Nomads");
        element.phoneNo.sendKeys("0531 531 53 53");
        element.company.sendKeys("Nomads Of Turkey");
        element.note.sendKeys("This İs My Country");
        driver.switchTo().frame(element.frame2);
        element.cardNumber.sendKeys("4242 4242 4242 4242");
        element.expirationDate.sendKeys("12/24");
        element.cvc.sendKeys("000");
        driver.switchTo().parentFrame();
        element.payButton.click();
        Assert.assertTrue("Confirmation message could not be displayed!", element.message2.getText().contains("your order is confirmed. Thank you!"));
        Assert.assertTrue("Total amount is not same as the price of the e-book!", element.total.getText().contains("0.50"));
        dAct.click(element.download2).perform();

        WaitAndClose();
    }
}