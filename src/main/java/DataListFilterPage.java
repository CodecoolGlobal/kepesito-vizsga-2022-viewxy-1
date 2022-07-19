import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class DataListFilterPage extends BasePage {
    private final String dataListFilterURL = "https://demo.seleniumeasy.com/data-list-filter-demo.html";
    private final By nameCards = By.xpath("//*[@class=\"info-block block-info clearfix\"]");
    private final By names = By.xpath(".//h4");

    public DataListFilterPage(WebDriver driver) {
        super(driver);
    }

    public void dataListFilterNavigate() {
        driver.navigate().to(dataListFilterURL);
    }

    public String[] getNames() {
        List<WebElement> nameList = driver.findElements(nameCards);
        String[] nameArray = new String[nameList.size()];
        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i).findElement(names).getText().replace("Name: ", "");
            nameArray[i] = name;
        }
        return nameArray;
    }
}
