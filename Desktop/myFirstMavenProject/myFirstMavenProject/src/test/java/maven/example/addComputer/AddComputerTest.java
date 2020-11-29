package maven.example.addComputer;

import maven.example.BasePageTest;
import maven.pages.computerDatabase.Add_computer_page;
import maven.pages.computerDatabase.Main_page;
import maven.pages.computerDatabase.Search_page;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static maven.pages.computerDatabase.Main_page.JUST_ADDED_COMPUTER;
import static utils.Waiters.DEFAULT_TIME_SECOND;
import static utils.Waiters.isElementPresent;

public class AddComputerTest extends BasePageTest {
    Main_page main_page;
    Add_computer_page add_computer_page;
    Search_page search_page;

    @BeforeMethod
    public void beforeMethod() {
        main_page = new Main_page(getDriver());
        add_computer_page = new Add_computer_page(getDriver());
        search_page = new Search_page(getDriver());
    }

    @Test
    public void addNewComputer() {
        main_page.openSiteMainPage();
        main_page.addComputer();
        add_computer_page.selectTheCompany();
        add_computer_page.fillTheIntroducedField("yyyy-MM-dd", 120);
        add_computer_page.fillTheDiscontinuedField("yyyy-MM-dd");
        add_computer_page.fillTheNameField("Olha");
        add_computer_page.addAComputer();
        main_page.searchComputerAfterAdding("Olha");
        Assert.assertTrue(isElementPresent(getDriver(), DEFAULT_TIME_SECOND, By.xpath(JUST_ADDED_COMPUTER)), "computer not found");
    }
}
