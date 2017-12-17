package pages;

import helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage extends BasePage{

    private By firstResult = By.cssSelector("#rso div");


    public ResultPage(WebDriver driver){
        super(driver);
    }

    public String getResult(){
        return find(firstResult).getText();
    }
}
