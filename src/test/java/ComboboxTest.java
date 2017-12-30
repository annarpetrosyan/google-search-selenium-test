import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ComboboxPage;

import static org.testng.Assert.assertEquals;


public class ComboboxTest {
    // this is wrong
    private WebDriver driver;
    private ComboboxPage comboboxPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        comboboxPage = new ComboboxPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @Test
    public void dropdownSelect() {
        comboboxPage.selectValue("Option 1");
        assertEquals(comboboxPage.getSelectedValue(), "Option 1");
        comboboxPage.forceAlert();
        comboboxPage.closeAlert();
    }

//    @Test
//    public void alertTest() {
//        comboboxPage.forceAlert();
//        comboboxPage.closeAlert();
//    }


}
