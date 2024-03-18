import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.Message;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC_306 extends BaseDriver {
    @Test
    public void TC_306() {
        driver.get("https://shopdemo.e-junkie.com/");

        driver.findElement(By.linkText("Contact Us")).click();

        driver.findElement(By.xpath("//*[@name='sender_name']")).sendKeys("Test Nomads");
        driver.findElement(By.cssSelector("[name='sender_email']")).sendKeys("testnomads01@gmail.com");
        driver.findElement(By.id("sender_subject")).sendKeys("Test Subject");
        driver.findElement(By.id("sender_message")).sendKeys("Test Message Area");
        driver.findElement(By.id("send_message_button")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        String alertMessage = driver.switchTo().alert().getText();

        Assert.assertEquals(alertMessage,"Recaptcha didn't match");

        driver.switchTo().alert().accept();


        WaitAndClose();
    }
}