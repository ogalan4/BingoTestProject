import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomePageTests {
    WebDriver driver;
    HomePage page;
    public String colourBeforeChanging;
    public String colourAfterChanging;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.pragmaticplay.com/en/");
        page = new HomePage(driver);
        page.acceptAgeButtonClick();
    }

    @Test
    public void checkIfHeaderMenuItemsChangeColorByCursorMoving() {
       List<WebElement> menuElements=page.getMenuElements();
        for (WebElement element:menuElements){
            System.out.println(element.getText());
           colourBeforeChanging= page.getColorItem(element);
           page.mouseOverElement(element);
           colourAfterChanging=page.getColorItem(element);
            Assert.assertNotEquals("The color of "+element.getText()+" was not change after moving over it",colourBeforeChanging,colourAfterChanging);
        }
    }

    @Test
    public void checkBingoSubMenuItemChangesColorByCursorMoving(){
        WebElement bingoItem=page.getBingoItemElement();
        page.selectBingoSubItem();
        colourBeforeChanging=page.getColorItem(bingoItem);
        page.mouseOverElement(bingoItem);
        colourAfterChanging=page.getColorItem(bingoItem);
        Assert.assertNotEquals("The colour of "+bingoItem.getText()+" was not change after moving on it",colourBeforeChanging,colourAfterChanging);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
