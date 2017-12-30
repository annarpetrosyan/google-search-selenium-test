package pages;

import helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverPage extends BasePage{

       private String avatarId = "figure";
    private String avatarDivId = "figcaption";


    public HoverPage(WebDriver webDriver) {
        super(webDriver);
        goBasePage("http://the-internet.herokuapp.com/hovers");
    }

    public void hoverToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void hoverAvatar(){
        hoverToElement(find(By.className(avatarId)));
    }

    public boolean isHeaderDisplayed() {
        return isDisplayed(By.className(avatarDivId));
    }

    public boolean isHeaderNotDisplayed() {
        return isNotDisplayed(find(By.className(avatarDivId)), 5);
    }

    public WebElement getHeader() {
        hoverAvatar();
        return find(By.className(avatarDivId));
    }
}
