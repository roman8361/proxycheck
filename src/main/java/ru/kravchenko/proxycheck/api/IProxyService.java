package ru.kravchenko.proxycheck.api;

import ru.kravchenko.proxycheck.entity.ProxyEntity;

import java.util.List;

/**
 * @author Roman Kravchenko
 */
public interface IProxyService {

    List<ProxyEntity> getRawProxyList();

    void asyncMethod();

    void checkProxyAsync(ProxyEntity proxy);

    void startGetWorkProxy();

}
