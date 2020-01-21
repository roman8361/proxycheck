package ru.kravchenko.proxycheck;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.proxycheck.entity.Boomer;
import ru.kravchenko.proxycheck.repository.BoomersRepository;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class BoomersRepositoryTest {

    @Autowired
    BoomersRepository boomersRepository;

    @Test
    public void fillBoomersDictionary() {
        boomersRepository.saveAll(getListBoomersDictionary());
        Assert.assertFalse(boomersRepository.findAll().isEmpty());
    }

    @Test
    public void delAll() {
        boomersRepository.deleteAll();
        Assert.assertTrue(boomersRepository.findAll().isEmpty());
    }

    @Test
    public void findByShortName() {
        Boomer boomer = boomersRepository.findByShortName("1xbet");
        Assert.assertNotNull(boomer);
    }

    @Test
    public void findByShortNameReturnNull() {
        Boomer boomer = boomersRepository.findByShortName("1111");
        Assert.assertNull(boomer);
    }

    private List<Boomer> getListBoomersDictionary() {
        List<Boomer> listBoomers = new ArrayList<>();
        listBoomers.add(new Boomer("10Bet", "https://www.10bet.com/"));
        listBoomers.add(new Boomer("12Bet", "http://www.12bet.com/"));
        listBoomers.add(new Boomer("188bet", "http://www.188bet.com/"));
        listBoomers.add(new Boomer("18bet", "https://www.18bet.com/en/euro/home"));
        listBoomers.add(new Boomer("1xbet", "https://1xbet.com/"));
        listBoomers.add(new Boomer("888", "https://www.888.ru"));
        listBoomers.add(new Boomer("5dimes", "https://https://www.5dimes.com/.888.ru"));

        return listBoomers;
    }

}
