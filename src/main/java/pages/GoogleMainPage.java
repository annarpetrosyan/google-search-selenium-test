package pages;

import helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleMainPage extends BasePage {
    WebDriver driver;
    private String baseUrl = "http://google.com";
    private By searchInputElement = By.id("lst-ib");
    private By searchButton = By.cssSelector("input[name='btnK'][type='submit']");
    private By bakhtsKberiButton = By.cssSelector("input[name='btnI'][type='submit']");



    public GoogleMainPage(WebDriver webDriver){
        super(webDriver);
        goBasePage(baseUrl);
    }

    public void searchText(String value){
        fill(searchInputElement, value);
    }

    public void clickOn(String buttonName){
        switch(buttonName){
            case "Search":{
                click(searchButton);
                break;
            }
            case "Bakhts Kberi":{
                click(bakhtsKberiButton);
                break;
            }
            default:{
                System.out.println("There is no button with" + buttonName + " name!");
            }
        }
    }

}
