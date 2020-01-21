package ru.kravchenko.proxycheck;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class BoomersServiceTest {

    @Test
    @SneakyThrows
    public void jsoupProxy() {
//        String bookmerUrl = boomers.get("5dimes");
//        for (int i = 1; i < 10; i++) {
//            try {
//                // Document doc = Jsoup.connect("https://www.marathonbet.com").proxy("212.87.248.11", 40762).get();
//                Document doc = Jsoup.connect(bookmerUrl).proxy("187.87.204.210", 45597).get();
//                //     Document doc = Jsoup.connect("https://2ip.ru/").proxy("212.87.248.11", 40762).get();
//                //        Document doc = Jsoup.connect("https://1xbet.com/").proxy("212.87.248.11", 40762).get();
//                System.out.println(doc);
//            } catch (Exception e) {
//                System.out.println("EXCEPTION: " + e.getMessage());
//            }
//            System.out.println("*****************************");
//            System.out.println("COUNT: " + i);
//            System.out.println("*****************************");
//            Thread.sleep(2000);
//        }
    }


}
