import org.openqa.selenium.WebDriver;

public class TwoInputFieldsPage extends BasePage{

    private final String twoInputURL = "https://demo.seleniumeasy.com/basic-first-form-demo.html";

    public TwoInputFieldsPage(WebDriver driver) {
        super(driver);
    }

    public void twoInputNavigate() {
        driver.navigate().to(twoInputURL);

    }
}
