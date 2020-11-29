package maven.pages.computerDatabase;

import maven.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.*;

public class Main_page extends BasePage {
    public static final String MAIN_SITE_LINK = "http://computer-database.gatling.io/computers";
    public static final String ADD_BUTTON = "//*[@id='add']";
    public static final String SEARCH_COMPUTER_FIELD = "//*[@id='actions']//*[@action='/computers']//*[@id='searchbox']";
    public static final String SEARCH_BUTTON = "//*[@id='actions']//*[@class='btn primary']";
    public static final String JUST_ADDED_COMPUTER = "//td/a[text()='Olha']";

    public Main_page(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ADD_BUTTON)
    private WebElement addButton;

    @FindBy(xpath = SEARCH_COMPUTER_FIELD)
    private WebElement searchComputerField;

    @FindBy(xpath = SEARCH_BUTTON)
    private WebElement searchButton;

    public Main_page openSiteMainPage() {
        driver.get(MAIN_SITE_LINK);
        return this;
    }

    //Click the "Add a new computer" button
    public Add_computer_page addComputer() {
        addButton.click();
        return new Add_computer_page(driver);
    }

    //Enter in the search filter computer name and click the "Filter by name" button. Then assert that computer name is in the table.
    public Search_page searchComputerAfterAdding(String computerName) {
        explicitWaitURLToBePresent(driver, DEFAULT_TIME_SECOND, MAIN_SITE_LINK);
        searchComputerField.click();
        explicitWait(driver, DEFAULT_TIME_SECOND, SEARCH_COMPUTER_FIELD);
        searchComputerField.sendKeys(computerName);
        searchButton.click();
        return new Search_page(driver);
    }
}
