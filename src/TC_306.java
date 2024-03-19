import Utility.BaseDriver;
import Utility.eJunkie_POM;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC_306 extends BaseDriver {
    @Test
    public void TC_306() {
        driver.get("https://shopdemo.e-junkie.com/");
        Utility.eJunkie_POM elements = new eJunkie_POM();

        elements.ContactUs.click();
        elements.namee.sendKeys("Test Nomads");
        elements.emaill.sendKeys("testnomads01@gmail.com");
        elements.sender.sendKeys("test subjest");
        elements.messagee.sendKeys("Test Message Area");
        elements.butonn.submit();

        wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "Recaptcha didn't match");
        driver.switchTo().alert().accept();

        WaitAndClose();
    }
}