package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;

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
        fill(find(locator),value);
//        find(locator).sendKeys(value);
    }

    public void fill(WebElement element, String value){
        element.sendKeys(value);
    }

    public void fill(String cssSelector, String text){
        fill(find(cssSelector), text);
    }

    public void click(By locator){
//        find(locator).click();
        click(find(locator));
    }

    public void click(WebElement element){
        element.click();
    }

    public WebElement find(String cssSelector){
        return find(By.cssSelector(cssSelector));
    }

    public void click(String cssSelector){
        click(find(cssSelector));
//        click(find(By.cssSelector(cssSelector)));
    }

    public boolean isDisplayed(String cssSelector){
        return isDisplayed(find(cssSelector));
//        return find(locator).isDisplayed();
    }


    public boolean isDisplayed(By locator){
        return isDisplayed(find(locator));
//        return find(locator).isDisplayed();
    }

    public boolean isDisplayed(WebElement element) {
       try {
            return element.isDisplayed();
        } catch (NoSuchFieldError e) {
            return false;
        }
    }

    public boolean isNotDisplayed(WebElement element, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

}
