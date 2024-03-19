import Utility.BaseDriver;
import Utility.eJunkie_POM;
import Utility.sRobot;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TC_308 extends BaseDriver {
    @Test
    public void TC_308() {
        Utility.eJunkie_POM locators = new eJunkie_POM();
        driver.get("https://www.e-junkie.com/");
        //wait till the ad pops up and close it clicking on a blank part of the website.
        wait.until(ExpectedConditions.visibilityOfAllElements(locators.ad));
        for (WebElement element : locators.ad) {                   //ad might not appear everytime test is run so list is included to set the test to run according to any possible scenarios.
            if (element.getText().contains("14-Day FREE Trial")) {
                sRobot.clickBlank("click", 300, 300);
            }
        }
        locators.seeHowItWorks.click();
        Assert.assertEquals("hata", "https://www.e-junkie.com/", driver.getCurrentUrl());

        //reaching the play button utilizing shift function of robot class and entering it.
        sRobot.robots("tab", 15);
        sRobot.robots("enter", 1);

        driver.switchTo().frame(locators.frame);
        //if the info video reachs 10th second we hit the stop button
        while (true) {
            wait.until(ExpectedConditions.visibilityOf(locators.timeDisp));
            int time = Integer.parseInt(locators.timeDisp.getText().substring(2));
            if (time > 9) {
                driver.quit();
                break;
            } else {
                sRobot.clickBlank("dontClick", 1250, 750);
            }
        }
    }
}