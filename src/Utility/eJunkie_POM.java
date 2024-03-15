package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class eJunkie_POM {
    public eJunkie_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(linkText = "example")
    public List<WebElement> example;
}