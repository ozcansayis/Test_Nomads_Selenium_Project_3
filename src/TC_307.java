import Utility.*;
import org.junit.*;

public class TC_307 extends BaseDriver {
    @Test
    public void TC_307() {
        driver.get("https://shopdemo.e-junkie.com/");
        Utility.eJunkie_POM elements = new eJunkie_POM();

        dAct.moveToElement(elements.eCommerce).click().build().perform();
        dAct.moveToElement(elements.eJunkieLogo).click().build().perform();
        String newUrl=driver.getCurrentUrl();
        Assert.assertTrue("Wrong URL!",newUrl.contains("https://www.e-junkie.com/"));

        WaitAndClose();
    }
}