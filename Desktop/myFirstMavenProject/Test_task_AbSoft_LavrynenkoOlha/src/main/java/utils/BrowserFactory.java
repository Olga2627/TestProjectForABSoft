package utils;

import pages.WebDriver;

public enum BrowserFactory {
    CHROME {
        public WebDriver create() {
            // /Users/olhalavrynenko/Desktop/myFirstMavenProject/myFirstMavenProject/src/test/resources/drivers/chromedriver
            System.setProperty("webdriver.chrome.driver", "/Users/olhalavrynenko/Downloads/chromedriver");
            return new ChromeDriver();
        }
//    },
//    EDGE {
//        public WebDriver create() {
//            System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
//            return new EdgeDriver();
//        }
//    },
//    FIREFOX {
//        public WebDriver create() {
//            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
//            return new FirefoxDriver();
//        }
    };
    public WebDriver create() {
        return null;
    }
}
