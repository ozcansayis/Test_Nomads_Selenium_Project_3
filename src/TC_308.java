import Utility.BaseDriver;
import Utility.Tools;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class TC_308 extends BaseDriver {
    @Test
    public void TC_308() throws AWTException {
        Robot robocop = new Robot();
        driver.get("https://www.e-junkie.com/");

        //wait till the ad pops up and close it clicking on a blank part of the website.
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class='wrapper']"))));
        Tools.robot.mouseMove(300, 300);
        Tools.robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Tools.robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        WebElement seeHowItWorks = driver.findElement(By.cssSelector("[onclick='toggleYoutubeModal(true)']"));
        seeHowItWorks.click();
        Assert.assertEquals("hata", "https://www.e-junkie.com/", driver.getCurrentUrl());

        //reaching the play button utilizing shift function of robot class and entering it.
        for (int i = 0; i < 15; i++) {
            Tools.WaitDouble(1);
            robocop.keyPress(KeyEvent.VK_TAB);
            robocop.keyRelease(KeyEvent.VK_TAB);
        }

        Tools.robot.keyPress(KeyEvent.VK_ENTER);
        Tools.robot.keyRelease(KeyEvent.VK_ENTER);
        //muted the vid.
        Tools.robot.keyPress(KeyEvent.VK_M);
        Tools.robot.keyRelease(KeyEvent.VK_M);

        WebElement frame = driver.findElement(By.cssSelector("div[class='modal youtube-modal is-active'] iframe"));
        driver.switchTo().frame(frame);

        //if the info video reachs 10th second we hit the stop button
        WebElement timeDisp = driver.findElement(By.cssSelector("div[class='ytp-time-display notranslate'] span span:nth-child(1)"));
        while (true) {
            String time = timeDisp.getText();
            if (time.equals("0:10")) {
                Tools.robot.keyPress(KeyEvent.VK_ENTER);
                Tools.robot.keyRelease(KeyEvent.VK_ENTER);
                break;
            }
        }
        WaitAndClose();
    }
}