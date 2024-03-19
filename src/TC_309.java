import Utility.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class TC_309 extends BaseDriver {
    @Test
    public void TC_309() throws AWTException, IOException, UnsupportedFlavorException {
        driver.get("https://www.e-junkie.com/wiki/demo/");
        Utility.eJunkie_POM elements = new eJunkie_POM();
        Robot dRob = new Robot();

        // A fixed window size has been set for the correct operation of the robot class.
        Dimension newDim = new Dimension(1280, 720);
        driver.manage().window().setSize(newDim);

        js.executeScript("arguments[0].click();", elements.addToCart);
        driver.switchTo().frame(elements.frame1);
        dAct.click(elements.addToCart2).perform();
        elements.email.sendKeys("testnomads01@gmail.com");
        dAct.sendKeys(elements.emailConfirm, "testnomads01@gmail.com").perform();
        elements.name.sendKeys("Test Nomads");
        dAct.sendKeys(elements.address, "Cumhuriyet Cd. No:7, 06050").perform();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        elements.city.sendKeys("Ankara");
        Select countrySelect = new Select(elements.country);
        countrySelect.selectByValue("TR");
        elements.zipCode.sendKeys("1280");
        dAct.scrollByAmount(0, -500).perform();
        elements.cardNumber.sendKeys("4242 4242 4242 4242 4242");
        dAct.sendKeys(elements.expirationDate, "1224").perform();
        elements.cvc.sendKeys("000");
        js.executeScript("arguments[0].click();", elements.payButton2);
        Assert.assertTrue("Confirm message does not contain the entered name!", elements.message2.getText().contains("Test"));
        dAct.click(elements.download).perform();

        // The downloaded PDF opened in browser.
        dRob.mouseMove(1000, 120);
        Tools.Wait(4); // This command varies depending on the download speed.
        dRob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        dRob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        // The part containing the name in the PDF is copied to the clipboard.
        dRob.mouseMove(470, 210);
        Tools.Wait(1);
        for (int i = 0; i < 3; i++) {
            dRob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            dRob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
        Tools.Wait(1);
        dRob.keyPress(KeyEvent.VK_CONTROL);
        dRob.keyPress(KeyEvent.VK_C);
        dRob.keyRelease(KeyEvent.VK_CONTROL);
        dRob.keyRelease(KeyEvent.VK_C);
        dRob.delay(1000);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String result = (String) clipboard.getData(DataFlavor.stringFlavor);
        Assert.assertTrue("The downloaded PDF does not contain the name entered in the invoice!", result.contains("Test Nomads"));

        WaitAndClose();
    }
}