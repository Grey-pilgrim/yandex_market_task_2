package steps;
import cucumber.api.DataTable;
import cucumber.api.java.ru.*;
import org.junit.Assert;
import pages.MarketPage;
import pages.YandexPage;

import java.util.HashMap;
import java.util.Map;


public class StepsDefinition {
    private YandexPage yandexPage = new YandexPage();
    private MarketPage marketPage = new MarketPage();
    private Map <String,String> memory = new HashMap<>();



    @Дано("^открыта страница \"([^\"]*)\"$")
    public void openPage (String page) {
        yandexPage.goURL(page);
    }


    @Если("^выбрать в секции \"([^\"]*)\" чек-боксы:$")
    public void clickCheckBox (String section, DataTable checkBox) {
        marketPage.clickCheckBox(section,checkBox.asList(String.class));

    }

    @Если("^нажать на \"([^\"]*)\"$")
    public void clickApply (String name) {
        yandexPage.clickOn(name);

    }

    @Тогда("^проверить что элементов на странице \"([^\"]*)\"$")
    public void checkQuantity (String section) {
        int count = Integer.valueOf(section);
        Assert.assertEquals("количество записей не равно 12",count,marketPage.calcElements());


    }

    @Если("^у первого элемента в списке запомнить \"([^\"]*)\"$")
    public void saveFirstEntry (String name) {
        memory.put(name,marketPage.getFirstElement());

    }

    @Тогда("^заполнить в секции \"([^\"]*)\" поле:$")
    public void insertInSection (String section, DataTable values) {
        if (memory.containsKey("МОДЕЛЬ")) {
            marketPage.inputField(section,memory);
            return;

        }
        marketPage.inputField(section,values.asMap(String.class,String.class));


    }

    @Тогда("^проверить что список содержит \"([^\"]*)\"$")
    public void checkPresence (String name) {
        Assert.assertTrue("Модели не совпадают",memory.get(name).contains(marketPage.getTitleElement(name)));


    }




}

