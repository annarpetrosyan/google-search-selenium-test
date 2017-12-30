package pages;

import helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ComboboxPage extends BasePage{
    private  String comboboxId = "dropdown";

    public ComboboxPage(WebDriver webDriver) {
        super(webDriver);
        goBasePage("http://the-internet.herokuapp.com/dropdown");
    }

    public WebElement getCombobox(){
        return find(By.id(comboboxId));
    }

    /*
    get all elemnts by tag name
     */
    public List<WebElement> getComboxOptions(){
        return getCombobox().findElements(By.tagName("option"));
    }

    public void selectValue(String valueName){
        List<WebElement> values = getComboxOptions();
        for (WebElement value:values){
            if(value.getText().equals(valueName)){
                value.click();
            }
        }
    }

    public String getSelectedValue(){
        List<WebElement> values = getComboxOptions();
        for (WebElement value:values){
            if(value.isSelected()){
                return  value.getText();
            }
        }
        return null;
    }



    public void forceAlert() {
        ((JavascriptExecutor) driver).executeScript("alert('Hello! I am an alert box!!');");
    }
    public void closeAlert() {
        driver.switchTo().alert().accept();
    }


}
