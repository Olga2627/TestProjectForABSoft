package maven.example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.BrowserFactory;

import java.util.concurrent.TimeUnit;

import static utils.Waiters.DEFAULT_TIME_SECOND;

public class BasePageTest {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public static void setUP() {
        try {
            driver = BrowserFactory.CHROME.create();
            driver.manage().timeouts().implicitlyWait(DEFAULT_TIME_SECOND, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some problems with drivers");
        }
    }

    @AfterSuite
    public static void tearDown() {
        driver.quit();
    }
}

