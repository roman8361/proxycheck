package ru.kravchenko.proxycheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.proxycheck.api.IBootstrapService;

/**
 * @author Roman Kravchenko
 */

@Service
public class BootstrapService implements IBootstrapService {

    @Autowired
    ProxyService proxyService;

    @Override
    public void init() {
        System.out.println("init method start");
        proxyService.startGetWorkProxy();
        System.out.println("init method end");
    }

}
