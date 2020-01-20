package ru.kravchenko.proxycheck.service;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.kravchenko.proxycheck.api.IProxyService;
import ru.kravchenko.proxycheck.entity.ProxyEntity;
import ru.kravchenko.proxycheck.repository.ProxyRepository;

import javax.net.ssl.SSLHandshakeException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Roman Kravchenko
 */

@Service
public class ProxyService implements IProxyService {

    private final String url = "https://free-proxy-list.net/";

    @Autowired
    ProxyRepository proxyRepository;

    List<ProxyEntity> cleanProxyList;

    @SneakyThrows
    public List<ProxyEntity> getRawProxyList() {
        List<ProxyEntity> result = new ArrayList<>();
        String htmlProxyPage = Jsoup.connect(url).get().html();
        Document doc = Jsoup.parse(htmlProxyPage);

        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("tr");

        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            ProxyEntity proxyEntity = new ProxyEntity();
            proxyEntity.setIp(row.getElementsByTag("td").eq(0).text()); // ip
            proxyEntity.setPort(row.getElementsByTag("td").eq(1).text()); // port
            proxyEntity.setCode(row.getElementsByTag("td").eq(2).text()); // code
            proxyEntity.setCountry(row.getElementsByTag("td").eq(1).text()); // country
            proxyEntity.setAnonymity(row.getElementsByTag("td").eq(1).text()); // anonymity

            result.add(proxyEntity);
        }
        return result;
    }

    @Async("threadPoolTaskExecutor")
    public void asyncMethod() {
        System.out.println("AsyncComponent");
        System.out.println("Thread.currentThread().getId() " + Thread.currentThread().getId());
        System.out.println("Thread.currentThread().getName() " + Thread.currentThread().getName());
    }

    @Async
    @SneakyThrows
    public void checkProxyAsync(ProxyEntity proxyEntity) {
        try {
            System.getProperties().put("proxySet", "true");
            System.getProperties().put("https.proxyHost", proxyEntity.getIp());
            System.getProperties().put("https.proxyPort", proxyEntity.getPort());
            HttpURLConnection conn = (HttpURLConnection) new URL("https://www.google.com").openConnection();
            System.out.println("Thread.currentThread().getId() " + Thread.currentThread().getId());
            conn.getContent();
            if (conn.getResponseCode() == 200) {
                proxyEntity.setCheckFlag(1);
                System.out.println("ProxyEntity id: " + proxyEntity.getId());
                System.out.println("ResponseCode: " + conn.getResponseCode());
                System.out.println("Rejoice brothers and sisters!!!!");
                System.out.println("proxyRepository.findAll().size(): " + proxyRepository.findAll().size());
                proxyRepository.save(proxyEntity);
            }
            conn.disconnect();
        } catch (SocketException | SSLHandshakeException e) {
            System.out.println(e);
        }
    }

    @SneakyThrows
    public void startGetWorkProxy() {
        List<ProxyEntity> rawListProxy = getRawProxyList();
        for (ProxyEntity p : rawListProxy) {
            checkProxyAsync(p);
        }
        cleanProxyList = proxyRepository.findAll();
        while (cleanProxyList.size() < 10) {
            Thread.sleep(500);
        }
        System.out.println("WORK IS DONE!!");
        System.out.println("cleanProxyList.size() " + cleanProxyList.size());
    }

}

