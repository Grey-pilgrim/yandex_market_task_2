package pages;

import static infrastructure.Core.DRIVER;

public class YandexPage extends Page {

    public void goURL(String url) {

        DRIVER.get(url);
    }

}
