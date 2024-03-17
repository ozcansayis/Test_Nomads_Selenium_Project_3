import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_307 extends BaseDriver {
    @Test
    public void TC_307() {

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement e_junkie=driver.findElement(By.linkText("E-commerce by E-junkie"));
        dAct.moveToElement(e_junkie).click().build().perform();

        WebElement logo= driver.findElement(By.xpath("//*[@href='/']"));
        dAct.moveToElement(logo).click().build().perform();



        WaitAndClose();
    }
}