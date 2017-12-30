import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.WindowsPage;

/**
 * Created by anna.r.petrosyan on 12/30/2017.
 */
public class MultiWindowTest {

    private ChromeDriver driver;
    private WindowsPage windowsPage;


    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        windowsPage = new WindowsPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @Test
    public void changeWindow(){
        windowsPage.clickLink();
        windowsPage.switchToWindow(0);
    }

}
