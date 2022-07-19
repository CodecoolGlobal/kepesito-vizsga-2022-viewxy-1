import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BootstrapModalPage extends BasePage {

    private final String bootstrapModalURL = "https://demo.seleniumeasy.com/bootstrap-modal-demo.html#";
    private final By launchModalButton = By.xpath("//*[@href=\"#myModal0\"]");
    private final By alertResult = By.xpath("//*[@id=\"myModal0\"]/div/div/div[3]");
    private final By closeButton = By.xpath("//*[@id=\"myModal0\"]/div/div/div[4]/a[1]");

    public BootstrapModalPage(WebDriver driver) {
        super(driver);
    }

    public void bootstrapModalNavigate() {
        driver.navigate().to(bootstrapModalURL);
    }

    public void clickLaunchModalButton() {
        driver.findElement(launchModalButton).click();
    }

    public String getAlertResult() {
        return driver.findElement(alertResult).getText();
    }

    public void clickCloseButton() {
        driver.findElement(closeButton).click();
    }
}
