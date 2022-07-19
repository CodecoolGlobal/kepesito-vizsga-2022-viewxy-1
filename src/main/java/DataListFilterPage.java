import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataListFilterPage extends BasePage {
    private final String dataListFilterURL = "https://demo.seleniumeasy.com/data-list-filter-demo.html";
    private final By nameCards = By.xpath("//*[@class=\"searchable-container\"]");
    private final By names = By.xpath(".//h4");
    private final By titles = By.xpath(".//p");

    public DataListFilterPage(WebDriver driver) {
        super(driver);
    }

    public void dataListFilterNavigate() {
        driver.navigate().to(dataListFilterURL);
    }

    public String[] getNames() {

        List<Map<String, String>> retList = new ArrayList<Map<String, String>>();
        List<WebElement> nameList = driver.findElements(nameCards);
        List<WebElement> names = driver.findElements(By.xpath("//*[@class=\"info-block block-info clearfix\"]//h4"));
        String[] nameArray = new String[names.size()];
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i).getText().replace("Name: ", "");
            nameArray[i] = name;
        }
        return nameArray;
    }
}
