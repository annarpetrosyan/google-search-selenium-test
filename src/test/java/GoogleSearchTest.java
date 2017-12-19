import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GoogleMainPage;
import pages.ResultPage;
import static org.testng.Assert.assertTrue;


public class GoogleSearchTest {
    // this is wrong
    private WebDriver driver;
    private GoogleMainPage googleMainPage;
    private ResultPage resultPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        googleMainPage = new GoogleMainPage(driver);
        resultPage = new ResultPage(driver);
    }

    @Test
    public void googleSearchTest(){
        googleMainPage.searchText("Հայաստան");
        googleMainPage.clickOn("Search");
        assertTrue(resultPage.getResult().contains("Վիքիպեդիա"), "Test Failed your 1st result is not WIKI");

    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
