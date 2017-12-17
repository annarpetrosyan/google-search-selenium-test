import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver webDriver){
        this.driver=webDriver;
    }

    public void goBasePage(String url){
        driver.get(url);
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public void fill(By locator, String value){
        find(locator).sendKeys(value);
    }

    public void click(By locator){
        find(locator).click();
    }

    public boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }
}
