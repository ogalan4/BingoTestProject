import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By acceptAgeButton = By.xpath("//span[contains(text(),'18 years or older')]");

    private final By headerMenuItem = By.xpath("//ul[@id='menu-top-menu']/li/a[text()]");
    //    private final By homeHeaderMenuItem = By.xpath("//a[@title='Home']");
    private final By productsHeaderMenuItem = By.xpath("//a[@title='Games']");

    private final By bingoHeaderSubMenuItem = By.xpath("//li[@id='menu-item-11081']/a");

    public void acceptAgeButtonClick() {
        driver.findElement(acceptAgeButton).click();
    }

    public List<WebElement> getMenuElements() {
        List<WebElement> locators;
        locators = driver.findElements(headerMenuItem);
        return locators;
    }

    public String getColorItem(WebElement element) {
        String color;
        color = Color.fromString(element.getCssValue("color")).asHex();
        return color;
    }

    public void mouseOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void selectBingoSubItem() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(productsHeaderMenuItem)).build().perform();
    }

    public WebElement getBingoItemElement() {
        return driver.findElement(bingoHeaderSubMenuItem);
    }
}
