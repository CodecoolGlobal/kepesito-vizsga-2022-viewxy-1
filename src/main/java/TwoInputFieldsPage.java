import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TwoInputFieldsPage extends BasePage {

    private final String twoInputURL = "https://demo.seleniumeasy.com/basic-first-form-demo.html";
    private final By inputFieldA = By.id("sum1");
    private final By inputFieldB = By.id("sum2");
    private final By totalButton = By.xpath("//*[@id=\"gettotal\"]/button");
    private final By totalResult = By.id("displayvalue");
    private final By popUpExit = By.id("at-cv-lightbox-close");

    public TwoInputFieldsPage(WebDriver driver) {
        super(driver);
    }

    public void clickPopup() {
        driver.findElement(popUpExit).click();
    }

    public void twoInputNavigate() {
        driver.navigate().to(twoInputURL);
    }

    public void fillInputFieldA(String num1) {
        driver.findElement(inputFieldA).sendKeys(num1);
    }

    public void fillInputFieldB(String num2) {
        driver.findElement(inputFieldB).sendKeys(num2);
    }

    public void clickTotalButton() {
        driver.findElement(totalButton).click();
    }

    public String getTotalResult() {
        return driver.findElement(totalResult).getText();
    }
}
