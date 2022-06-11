import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
@RunWith(SerenityRunner.class)
public class WhenBingoPageTests {
    WebDriver driver;
    BingoPage page;
    HomePage homePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.pragmaticplay.com/en/bingo/");
        homePage=new HomePage(driver);
        homePage.acceptAgeButtonClick();
        page = new BingoPage(driver);
    }
// Scroll down to the "Our bingo variants" section and check that there are 9 "Bingo theme"
    @Test
    public void checkCountOfElementsInCarouselMenuEqualsNineTest(){
        int countOfElementsInCarouselMenu=page.getCountOfElementsInCarouselMenu();
        Assert.assertEquals("The count of elements in carousel menu equals "+countOfElementsInCarouselMenu+" elements, versus 9",9,countOfElementsInCarouselMenu);
    }
//Check if the elements are not duplicated.
    @Test
    public void checkDuplicateOfElementsInCarouselMenuTest() {
        page.getCountOfElementsInCarouselMenu();
        int countOfDuplicates=page.getDuplicateElementsSize();
        Assert.assertEquals("In carousel bloc are present "+countOfDuplicates+" duplicates",0, countOfDuplicates);
        }
//Verify that the link to the image contains the name of the theme(like Rock'n'Swing, Bingo Blast, Boombox, etc.).
        @Test
        public void checkIfLinkContainsTheNameOfThemeTest(){
             int countOfElements=page.getCountOfElementsInCarouselMenu();
           for (int i = 0; i <countOfElements ; i++) {
               List<String> allLinks =page.getElementsLinks();
               Assert.assertTrue("The "+allLinks.get(0)+" link  contains wrong title ("+allLinks.get(1)+")",allLinks.get(0).contains(allLinks.get(1)));
            }
                }

    @After
    public void tearDown() {
        driver.quit();
    }
}
