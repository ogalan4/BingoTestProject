import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By acceptAgeButton = By.xpath("//span[contains(text(),'18 years or older')]");

    private final By homeHeaderMenuItem = By.xpath("//a[@title='Home']");
    private final By productsHeaderMenuItem = By.xpath("//a[@title='Games']");
    private final By clientHubHeaderMenuItem = By.xpath("//li[@id='menu-item-23582']/a");
    private final By companyHeaderMenuItem = By.xpath("//li[@id='menu-item-57201']/a");
    private final By newsHeaderMenuItem = By.xpath("//li[@id='menu-item-9841']/a");
    private final By contactHeaderMenuItem = By.xpath("//li[@id='menu-item-1820']/a");

    private final By bingoHeaderSubMenuItem = By.xpath("//li[@id='menu-item-11081']/a");

//    public List<By> changedItems = new ArrayList();
//    public List<By> notChangedItems = new ArrayList();
    public String colourBeforeChanging;
    public String colourAfterChanging;

    public void acceptAgeButtonClick() {
        driver.findElement(acceptAgeButton).click();
    }

    public void checkChangingColorHomeItemByMouseover() {
        colourBeforeChanging = Color.fromString(driver.findElement(homeHeaderMenuItem).getCssValue("color")).asHex();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(homeHeaderMenuItem)).build().perform();
        colourAfterChanging = Color.fromString(driver.findElement(homeHeaderMenuItem).getCssValue("color")).asHex();
    }

    public void checkChangingColorProductsItemByMouseover() {
        colourBeforeChanging = Color.fromString(driver.findElement(productsHeaderMenuItem).getCssValue("color")).asHex();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(productsHeaderMenuItem)).build().perform();
        colourAfterChanging = Color.fromString(driver.findElement(productsHeaderMenuItem).getCssValue("color")).asHex();
    }

    public void checkChangingColorClientHubItemByMouseover() {
        colourBeforeChanging = Color.fromString(driver.findElement(clientHubHeaderMenuItem).getCssValue("color")).asHex();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(clientHubHeaderMenuItem)).build().perform();
        colourAfterChanging = Color.fromString(driver.findElement(clientHubHeaderMenuItem).getCssValue("color")).asHex();
    }

    public void checkChangingColorCompanyItemByMouseover() {
        colourBeforeChanging = Color.fromString(driver.findElement(companyHeaderMenuItem).getCssValue("color")).asHex();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(companyHeaderMenuItem)).build().perform();
        colourAfterChanging = Color.fromString(driver.findElement(companyHeaderMenuItem).getCssValue("color")).asHex();
    }

    public void checkChangingColorNewsItemByMouseover() {
        colourBeforeChanging = Color.fromString(driver.findElement(newsHeaderMenuItem).getCssValue("color")).asHex();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(newsHeaderMenuItem)).build().perform();
        colourAfterChanging = Color.fromString(driver.findElement(newsHeaderMenuItem).getCssValue("color")).asHex();
    }

    public void checkChangingColorContactItemByMouseover() {
        colourBeforeChanging = Color.fromString(driver.findElement(contactHeaderMenuItem).getCssValue("color")).asHex();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(contactHeaderMenuItem)).build().perform();
        colourAfterChanging = Color.fromString(driver.findElement(contactHeaderMenuItem).getCssValue("color")).asHex();
    }

    public void checkChangingColorBingoSubItem() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(productsHeaderMenuItem)).build().perform();
        colourBeforeChanging = Color.fromString(driver.findElement(bingoHeaderSubMenuItem).getCssValue("color")).asHex();
        actions.moveToElement(driver.findElement(bingoHeaderSubMenuItem)).build().perform();
        colourAfterChanging = Color.fromString(driver.findElement(bingoHeaderSubMenuItem).getCssValue("color")).asHex();
    }
}
