package maven.pages.computerDatabase;

import maven.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static utils.Waiters.*;

public class Add_computer_page extends BasePage {
    public Add_computer_page(WebDriver driver) {
        super(driver);
    }

    public static final String ADD_COMPUTER_PAGE = "http://computer-database.gatling.io/computers/new";
    public static final String NAME_FIELD = "//*[@class='input']//*[@id='name']";
    public static final String INTRODUCED_FIELD = "//*[@id='introduced']";
    public static final String DISCONTINUED_FIELD = "//*[@id='discontinued']";
    public static final String COMPANY_FIELD = "//*[@id='company']";
    public static final String COMPANY_APPLE_FIELD = "//*[@id='company']//*[@value='1']";
    public static final String CREATE_COMPUTER_BUTTON = "//*[@class='btn primary']";

    @FindBy(xpath = NAME_FIELD)
    private WebElement nameField;

    @FindBy(xpath = INTRODUCED_FIELD)
    private WebElement introducedField;

    @FindBy(xpath = DISCONTINUED_FIELD)
    private WebElement discontinuedField;

    @FindBy(xpath = COMPANY_FIELD)
    private WebElement companySelector;

    @FindBy(xpath = COMPANY_APPLE_FIELD)
    private WebElement selectedAppleCompany;

    @FindBy(xpath = CREATE_COMPUTER_BUTTON)
    private WebElement createComputerButton;

    //Click on the "Computer name" field and set the value
    public Add_computer_page fillTheNameField(String text) {
        explicitWaitURLToBePresent(driver, DEFAULT_TIME_SECOND, ADD_COMPUTER_PAGE);
        explicitWait(driver, DEFAULT_TIME_SECOND, NAME_FIELD);
        nameField.click();
        nameField.sendKeys(text);
        return this;
    }

    //Set the value in  the "Introduced" field (10 years early)
    public Add_computer_page fillTheIntroducedField(String dataFormat, int minusMonths) {
        String date = DateTimeFormatter.ofPattern(dataFormat).format(LocalDateTime.now().minusMonths(minusMonths));
        explicitWait(driver, DEFAULT_TIME_SECOND, INTRODUCED_FIELD);
        introducedField.sendKeys(date);
        return this;
    }

    //Set the value in  the "Discontinued" field (today date)
    public Add_computer_page fillTheDiscontinuedField(String dataFormat) {
        String date = DateTimeFormatter.ofPattern(dataFormat).format(LocalDateTime.now());
        explicitWait(driver, DEFAULT_TIME_SECOND, DISCONTINUED_FIELD);
        discontinuedField.sendKeys(date);
        return this;
    }

    //Select the company in the "Company" selector and click on it
    public Add_computer_page selectTheCompany() {
        companySelector.click();
        selectedAppleCompany.click();
        return this;
    }

    //Click on the "Create this computer" button
    public Add_computer_page addAComputer() {
        createComputerButton.click();
        return this;
    }
}
