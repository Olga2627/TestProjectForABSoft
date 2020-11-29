package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {

    public static final int DEFAULT_TIME_SECOND = 10;

    public static void explicitWait(WebDriver driver, int seconds, String xpath) {
        (new WebDriverWait(driver, seconds)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void explicitWaitURLToBePresent(WebDriver driver, int seconds, String url) {
        (new WebDriverWait(driver, seconds)).until(ExpectedConditions.urlToBe(url));
    }

    public static boolean isElementPresent(WebDriver driver, int seconds, By element) {
        Boolean result = false;
        try {
            (new WebDriverWait(driver, seconds)).until(ExpectedConditions.presenceOfElementLocated(element));
            result = true;
        } catch (Exception e) {
            System.out.println("element not found");
        }
        return result;
    }
}
