package ru.kravchenko.proxycheck;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.proxycheck.api.IProxyService;
import ru.kravchenko.proxycheck.entity.ProxyEntity;
import ru.kravchenko.proxycheck.repository.ProxyRepository;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ProxyServiceTest {

    @Autowired
    IProxyService proxyService;

    @Autowired
    ProxyRepository proxyRepository;

    @Test //TODO пока не работает как надо
    public void startGetWorkProxyTest() {
        proxyService.startGetWorkProxy();
    }

    @Test
    public void getRawListProxyTest() {
        List<ProxyEntity> rawProxyList = proxyService.getRawProxyList();
        //     rawProxyList.forEach(System.out::println);
        Assert.assertNotNull(rawProxyList);
    }

    @Test
    @SneakyThrows
    public void testAsyncMethodGetProxy() {
        for (ProxyEntity proxyEntity : proxyService.getRawProxyList()) {
            proxyService.checkProxyAsync(proxyEntity);
        }

        List<ProxyEntity> cleanProxyList = proxyRepository.findAll();
        while (cleanProxyList.size() < 10) {
            Thread.sleep(500);
        }
        System.out.println("proxyRepository.getSizeMapProxy() " + cleanProxyList.size());
    }

    @Test
    public void testAsyncMethod() {
        proxyService.asyncMethod();
    }

}


