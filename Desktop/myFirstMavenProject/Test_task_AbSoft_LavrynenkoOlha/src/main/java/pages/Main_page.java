package pages;

public class Main_page extends Base_page{
    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public static final String SITE_LINK_ELEMENT = "Contact Us - AUTODOC";
    public static final String URL_AUTODOC = "https://www.autodoc.co.uk/services/contact";

    @FindBy(partialLinkText = SITE_LINK_ELEMENT)
    private WebElement siteLink;

    public void openUrlByName() {
        siteLink.click();
    }
}
