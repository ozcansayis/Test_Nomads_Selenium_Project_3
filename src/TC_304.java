import Utility.BaseDriver;
import org.junit.Test;

public class TC_304 extends BaseDriver {
    @Test
    public void TC_304() {
        driver.get("https://shopdemo.e-junkie.com/");



        WaitAndClose();
    }
}