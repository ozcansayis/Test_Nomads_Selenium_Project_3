package Utility;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Tools {
    public static void Wait(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int RandomGenerator(int max, int min) {
        return (int) (Math.random() * (max - min + 1));
    }

    public static boolean ListContainsString(List<WebElement> list, String string) {
        boolean condition = false;
        for (WebElement e : list) {
            if (e.getText().equalsIgnoreCase(string))
                condition = true;
        }
        return condition;
    }
}