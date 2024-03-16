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

    }
}