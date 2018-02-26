package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static infrastructure.Core.WAIT;

public abstract class Page {

    public static Map<String, String> locators = new HashMap<String, String>() {{
        put("Маркет", "//div[@role='navigation']//a[contains(text(), 'Маркет')]");
        put("Электроника", "/html/body/div[1]/div[2]/noindex/ul/li[1]/a");
        put("Наушники", "//html//div[@class='layout-grid__col layout-grid__col_width_2']//div[2]/div[1]/a[1]");
        put("Цена", "//*[@id=\"glf-pricefrom-var\"]");
        put("Beats", "//label[@class='checkbox__label' and contains(text(),'Beats')]/ancestor::a[1]");
        put("Применить", "//button[@class='button button_action_n-filter-apply button_size_s button_pseudo_yes button_theme_pseudo i-bem button_js_inited']");
        put("Первый", "//html//div[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/div[1]/div[4]/div[1]/div[1]");
        put("Поиск", "//*[@id=\"header-search\"]");
        put("Найти", "//span[@class='search2__button']//button[@role='button']");
        put("МОДЕЛЬ", "/html/body/div[1]/div[4]/div[2]/div[2]/div/div[1]/div[1]/h1");
    }};


    public void clickOn(String name){

        buttonOrLink.apply(locators.get(name)).click();

    }


    Function<String, WebElement> textOrField =
            locator -> WAIT.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));


    private Function<String, WebElement> buttonOrLink =
            locator -> WAIT.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
}

