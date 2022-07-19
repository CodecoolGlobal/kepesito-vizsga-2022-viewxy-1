import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicSelectPage extends BasePage {

    private final String basicSelectURL = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";
    private final By dropDownList = By.id("select-demo");
    private final By lastDay = By.xpath("//*[@id=\"select-demo\"]/option[last()]");
    private final By selectedDay = By.className("selected-value");

    public BasicSelectPage(WebDriver driver) {
        super(driver);
    }

    public void basicSelectNavigate() {
        driver.navigate().to(basicSelectURL);
    }

    public void clickDropDownList() {
        driver.findElement(dropDownList).click();
    }

    public void clickLastDay() {
        driver.findElement(lastDay).click();
    }

    public String checkSelectedDay() {
        return driver.findElement(selectedDay).getText();
    }
}
