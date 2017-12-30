import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HoverPage;

import static org.testng.Assert.assertTrue;

/**
 * Created by anna.r.petrosyan on 12/30/2017.
 */
public class HoverTest {
    // this is wrong
    private WebDriver driver;
    private HoverPage hoverPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        hoverPage = new HoverPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @Test
    public void dropdownSelect() {
        assertTrue(hoverPage.isHeaderNotDisplayed(), "Header was visible!");
        hoverPage.hoverAvatar();
        assertTrue(hoverPage.isHeaderDisplayed(), "Header was not visible!");

        assertTrue(hoverPage.getHeader().getText().contains("name: user1"),
                "Header text was not correct!");
    }


}
