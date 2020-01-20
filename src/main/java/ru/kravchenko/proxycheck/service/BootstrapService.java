package ru.kravchenko.proxycheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.proxycheck.api.IBootstrapService;
import ru.kravchenko.proxycheck.api.IProxyService;

/**
 * @author Roman Kravchenko
 */

@Service
public class BootstrapService implements IBootstrapService {

    @Autowired
    IProxyService proxyService;

    @Override
    public void init() {
        System.out.println("init method start");
        System.out.println("Thread.currentThread().getId() " + Thread.currentThread().getId());
        proxyService.asyncMethod();
        System.out.println("init method end");
    }

}
