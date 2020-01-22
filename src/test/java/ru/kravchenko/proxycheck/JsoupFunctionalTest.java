package ru.kravchenko.proxycheck;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class JsoupFunctionalTest {

    @Test
    @SneakyThrows
    public void getHtmlAnyPage() {
        Document doc = Jsoup.connect("http://mail.ru/").get(); //TODO изучить возможные настройки Jsoup запросов
        System.out.println(doc);
    }

}
