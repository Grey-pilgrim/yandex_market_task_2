package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Map;

import static infrastructure.Core.DRIVER;

public class MarketPage extends Page {

    public void inputField(String field, Map<String,String> values) {
        if (values.containsKey("МОДЕЛЬ")) {
            new Actions(DRIVER).sendKeys(textOrField.apply(locators.get(field)),values.get("МОДЕЛЬ")).build().perform();
            return;

        }
        textOrField.apply(locators.get(field)).sendKeys(values.get(field));
    }

    public void clickCheckBox(String section,List<String> values){

        for (int i=0;i<values.size();i++) {
            textOrField.apply(locators.get(values.get(i))).click();
        }

    }

    public int calcElements() {
        return DRIVER.findElements(By.xpath("//div[contains(@class, 'n-snippet-list')]//div[@class='n-snippet-cell2__title']//a")).size();
    }

    public String getFirstElement() {
        return DRIVER.findElements(By.xpath("//div[contains(@class, 'n-snippet-list')]//div[@class='n-snippet-cell2__title']//a")).get(1).getText();
    }
    public String getTitleElement(String title) {
        return textOrField.apply(locators.get(title)).getText();
    }



}
