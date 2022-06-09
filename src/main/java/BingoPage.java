import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Thread.sleep;

public class BingoPage {
    WebDriver driver;

    public BingoPage(WebDriver driver) {
        this.driver = driver;
    }

    int carouselElementsSize;
    List<String> allTitle = new ArrayList<>();

    private final By productsHeaderMenuItem = By.xpath("//a[@title='Games']");

    private final By bingoHeaderSubMenuItem = By.xpath("//li[@id='menu-item-11081']/a");
    private final By carouselElementsLocator = By.xpath("//div[@class='slick-track']/div");
    private final By carouselCurrentElementTitleLocator = By.xpath("//div[@class='slick-slide slick-current slick-active']");
    private final By carouselCurrentElementLinkLocator = By.xpath("//div[@class='slick-slide slick-current slick-active']//img");
    private final By carouselNavigateRightIconLocator = By.xpath("//div[@class='right-arrow slick-arrow']");

    public void bingoHeaderSubMenuItemClick() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(productsHeaderMenuItem)).build().perform();
        driver.findElement(bingoHeaderSubMenuItem).click();
    }

    public int getCountOfElementsInCarouselMenu() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)", "");
        List<WebElement> caruselItems = driver.findElements(carouselElementsLocator);
        carouselElementsSize = caruselItems.size();
        return carouselElementsSize;
    }

    public List<String> getElementsOfCarouselMenu() {

//        JavascriptExecutor jse = (JavascriptExecutor) driver;

//        jse.executeScript("window.scrollBy(0,500)", "");
//        List<WebElement> carouselItems = driver.findElements(carouselElementsLocator);
//        caruselElementsSize = carouselItems.size();
//        getCountOfElementsInCarouselMenu();
        for (int i = 1; i <= carouselElementsSize; i++) {
            allTitle.add(driver.findElement(carouselCurrentElementTitleLocator).getText());
            driver.findElement(carouselNavigateRightIconLocator).click();
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }return allTitle;
    }
    public int getDuplicateElementsSize() {
        List<String> duplicateElements = new ArrayList<>();
        Set<String> uniqueElements = new HashSet<>();
        for (String s : allTitle) {
            if (!uniqueElements.add(s)) {
                duplicateElements.add(s);
            }
        }
        return duplicateElements.size();
    }

    public List<String> getElementsLinks() {
        List<String> allLinks = new ArrayList<>();
        for (int i = 1; i <= carouselElementsSize; i++) {
            allLinks.add(driver.findElement(carouselCurrentElementLinkLocator).getText());
            System.out.println(driver.findElement(carouselCurrentElementLinkLocator).getAttribute("src")+"-----------");
            driver.findElement(carouselNavigateRightIconLocator).click();
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }return allLinks; 
    }
}