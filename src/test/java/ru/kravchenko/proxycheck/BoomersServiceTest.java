package ru.kravchenko.proxycheck;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.proxycheck.entity.ProxyEntity;
import ru.kravchenko.proxycheck.repository.BoomersRepository;
import ru.kravchenko.proxycheck.repository.ProxyRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class BoomersServiceTest {

    @Autowired
    BoomersRepository boomersRepository;

    @Autowired
    ProxyRepository proxyRepository;

    private List<ProxyEntity> cleanProxy;

    @Before
    public void setUp() {
        cleanProxy = proxyRepository.findAll();
    }

    @Test
    @SneakyThrows
    public void jsoupProxy() {
        ProxyEntity proxyEntity = cleanProxy.get(1);
        String bookmerUrl = boomersRepository.findByShortName("10Bet").getUrl();
        System.out.println("bookmerUr l" + bookmerUrl);
        for (int i = 1; i < 10; i++) {
            try {
                // Document doc = Jsoup.connect("https://www.marathonbet.com").proxy("212.87.248.11", 40762).get();
                Document doc = Jsoup.connect(bookmerUrl).proxy(proxyEntity.getIp(), Integer.parseInt(proxyEntity.getPort())).get();
                //     Document doc = Jsoup.connect("https://2ip.ru/").proxy("212.87.248.11", 40762).get();
                //        Document doc = Jsoup.connect("https://1xbet.com/").proxy("212.87.248.11", 40762).get();
                System.out.println(doc);
            } catch (Exception e) {
                System.out.println("EXCEPTION: " + e.getMessage());
            }
            System.out.println("*****************************");
            System.out.println("COUNT: " + i);
            System.out.println("*****************************");
            Thread.sleep(2000);
        }
    }

}
