package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public enum BrowserFactory {

    CHROME {
        public WebDriver create() {
            System.setProperty("webdriver.chrome.driver", "/Users/olhalavrynenko/Downloads/chromedriver");
            return new ChromeDriver();
        }
    };

    public WebDriver create() {
        return null;
    }
}



