import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BingoPageTests {
    WebDriver driver;
    BingoPage page;
    HomePage homePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.pragmaticplay.com/en/bingo/");
        homePage=new HomePage(driver);
        homePage.acceptAgeButtonClick();
        page = new BingoPage(driver);
        page.bingoHeaderSubMenuItemClick();
    }

    @Test
    public void checkCountOfElementsInCarouselMenuEqualsNineTest(){
        int countOfElementsInCaruselMenu=page.getCountOfElementsInCarouselMenu();
        Assert.assertEquals("The count of elements in carusel menu equals "+countOfElementsInCaruselMenu+" elements, versus 9",9,countOfElementsInCaruselMenu);
    }

    @Test
    public void checkDuplicateOfElementsInCarouselMenuTest() {
        page.getCountOfElementsInCarouselMenu();
        page.getElementsOfCarouselMenu();
        int countOfDuplicatdes=page.getDuplicateElementsSize();
        Assert.assertEquals("In carusell bloc are present "+countOfDuplicatdes+" duplicates",0, countOfDuplicatdes);
        }

        @Test
        public void checkIfLinkContainsTheNameOfThemeTest(){
            List<String>titles=new ArrayList<>();
            List<String>links=new ArrayList<>();
            page.getCountOfElementsInCarouselMenu();
           titles= page.getElementsOfCarouselMenu();
            links=page.getElementsLinks();
            f
        }

    @After
    public void tearDown() {
        driver.quit();
    }
}
