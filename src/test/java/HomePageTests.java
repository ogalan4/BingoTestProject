import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HomePageTests {
    WebDriver driver;
    HomePage page;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.pragmaticplay.com/en/");
    }

    @Test
    public void checkIfHeaderMenuItemsChangeColorByCursorMoving() {
        page = new HomePage(driver);
        page.acceptAgeButtonClick();
        page.checkChangingColorHomeItemByMouseover();
            Assert.assertNotEquals(page.colourBeforeChanging,page.colourAfterChanging);
            page.checkChangingColorProductsItemByMouseover();
            Assert.assertEquals(page.colourBeforeChanging,page.colourAfterChanging);
            page.checkChangingColorClientHubItemByMouseover();
            Assert.assertNotEquals(page.colourBeforeChanging,page.colourAfterChanging);
            page.checkChangingColorCompanyItemByMouseover();
            Assert.assertEquals(page.colourBeforeChanging,page.colourAfterChanging);
            page.checkChangingColorNewsItemByMouseover();
            Assert.assertNotEquals(page.colourBeforeChanging,page.colourAfterChanging);
            page.checkChangingColorContactItemByMouseover();
            Assert.assertNotEquals(page.colourBeforeChanging,page.colourAfterChanging);

    page.checkChangingColorBingoSubItem();
    Assert.assertNotEquals(page.colourBeforeChanging,page.colourAfterChanging);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
