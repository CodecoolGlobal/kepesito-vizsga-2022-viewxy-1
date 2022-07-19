import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableDataDownloadPage extends BasePage {

    private final String tableDataDownloadURL = "https://demo.seleniumeasy.com/table-data-download-demo.html";
    private final By tableRows = By.xpath("//*[@id=\"example\"]/tbody/tr");
    private final By cell = By.xpath(".//td");

    public TableDataDownloadPage(WebDriver driver) {
        super(driver);
    }

    public void tableDataDownloadNavigate() {
        driver.navigate().to(tableDataDownloadURL);
    }

    public String[] getNames() {
        List<WebElement> tableRowsList = driver.findElements(tableRows);

        String[] names = new String[tableRowsList.size()];

        for (int i = 0; i < tableRowsList.size(); i++) {
            names[i] = tableRowsList.get(i).findElement(cell).getText();
        }
        return names;
    }
}
