import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;


public class SeleniumTest extends TestBase {
    TwoInputFieldsPage twoInputFieldsPage;
    BasicSelectPage basicSelectPage;
    BootstrapModalPage bootstrapModalPage;
    DataListFilterPage dataListFilterPage;
    TableDataDownloadPage tableDataDownloadPage;
    Util util;

    /*
    Tölts be a böngészőbe az alábbi oldalt: https://demo.seleniumeasy.com/basic-first-form-demo.html
    Írj tesztesetet két szám összegének ellenőrzésére a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. Az oldalon, a Two Input Fields” szekcióban két beviteli mezőjét töltsd ki tetszőleges számokkal, majd végezd el a számok összeadásának ellenőrzését kiolvasva az oldalon megjelenő összeget.
    Használj tetszőleges tesztadatot
     */
    @Test
    public void TestInput() {
        twoInputFieldsPage = new TwoInputFieldsPage(driver);
        twoInputFieldsPage.twoInputNavigate();
        twoInputFieldsPage.clickPopup();
        twoInputFieldsPage.fillInputFieldA("15");
        twoInputFieldsPage.fillInputFieldB("3");
        twoInputFieldsPage.clickTotalButton();

        String expected = "18";
        String actual = twoInputFieldsPage.getTotalResult();

        Assertions.assertEquals(expected, actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: zhttps://demo.seleniumeasy.com/basic-select-dropdown-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet a következők szerint: a Select List Demo szekció lenyíló mezőjében válaszd ki a hét utolsó napját és ellenőrizd, hogy az oldalon helyesen jelenik meg a kiválasztott érték
    Tesztadatként használd az hét utolsó napját
     */
    @Test
    public void SelectDayTest() {
        basicSelectPage = new BasicSelectPage(driver);
        basicSelectPage.basicSelectNavigate();
        basicSelectPage.clickDropDownList();
        basicSelectPage.clickLastDay();

        String expected = "Day selected :- Saturday";
        String actual = basicSelectPage.checkSelectedDay();

        Assertions.assertEquals(expected, actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/bootstrap-modal-demo.html#
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A tesztesetben ellenőrizd a modal alert ablak szöveges tartalmát összahasonlítva egy általad definiált elvárt eredménnyel. Nyisd meg a Single Modal ablakot, tárolt el az ablakon megjelenő szöveget egy változóba és zárd be az ablakot a bezárás gombbal
     */
    @Test
    public void AlertTest() throws InterruptedException {
        bootstrapModalPage = new BootstrapModalPage(driver);
        bootstrapModalPage.bootstrapModalNavigate();
        bootstrapModalPage.clickLaunchModalButton();
        String expected = "";
        String actual = bootstrapModalPage.getAlertResult();
        Thread.sleep(500);
        bootstrapModalPage.clickCloseButton();

        Assertions.assertEquals(expected, actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/data-list-filter-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A teszteset ellenőrizze a névjegykártyák tartalmát.Olvasd ki a neveket a megjelenő névjegykártyákról és ellenőrzésként hasonlítsd össze egy elvárt eredményként megadott listával.
    Használj relatív útvonalat a névjegykártya név elemeinek kiolvasásához.
     */
    @Test
    public void NamecardTest() {
        dataListFilterPage = new DataListFilterPage(driver);
        dataListFilterPage.dataListFilterNavigate();
        String[] expected = {"Tyreese Burn",
                "Brenda Tree",
                "Glenn Pho shizzle",
                "Brian Hoyies",
                "Glenn Pho shizzle",
                "Arman Cheyia"};
        String[] actual = dataListFilterPage.getNames();

        Assertions.assertArrayEquals(expected, actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/table-data-download-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A tesztesetet ellenőrizze a táblázatból a neveket, amelyeket a táblázat első oszlop tartalmaz. Gyűjtsd össze a neveket és tárold le a names.txt fájlba majd a tesztesetben a fájl tartalmát hasonlítsd össze egy elvárt eredménnyel.
     */
    @Test
    public void TableTest() {
        util = new Util();
        String testFileName = "names.txt";

        tableDataDownloadPage = new TableDataDownloadPage(driver);
        tableDataDownloadPage.tableDataDownloadNavigate();

        util.setFileName(testFileName);


        for (String actual : tableDataDownloadPage.getNames()) {
            util.write(actual, "\r\n");
        }
        String expected = "Tiger Nixon\r\n" +
                "Garrett Winters\r\n" +
                "Ashton Cox\r\n" +
                "Cedric Kelly\r\n" +
                "Airi Satou\r\n" +
                "Brielle Williamson\r\n" +
                "Herrod Chandler\r\n" +
                "Rhona Davidson\r\n" +
                "Colleen Hurst\r\n" +
                "Sonya Frost\r\n" +
                "Jena Gaines\r\n" +
                "Quinn Flynn\r\n" +
                "Charde Marshall\r\n" +
                "Haley Kennedy\r\n" +
                "Tatyana Fitzpatrick\r\n" +
                "Michael Silva\r\n" +
                "Paul Byrd\r\n" +
                "Gloria Little\r\n" +
                "Bradley Greer\r\n" +
                "Dai Rios\r\n" +
                "Jenette Caldwell\r\n" +
                "Yuri Berry\r\n" +
                "Caesar Vance\r\n" +
                "Doris Wilder\r\n" +
                "Angelica Ramos\r\n" +
                "Gavin Joyce\r\n" +
                "Jennifer Chang\r\n" +
                "Brenden Wagner\r\n" +
                "Fiona Green\r\n" +
                "Shou Itou\r\n" +
                "Michelle House";

        Assertions.assertEquals(expected, util.read());
    }
}
