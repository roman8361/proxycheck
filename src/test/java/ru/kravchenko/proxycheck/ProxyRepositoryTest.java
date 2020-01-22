package ru.kravchenko.proxycheck;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.proxycheck.entity.ProxyEntity;
import ru.kravchenko.proxycheck.repository.ProxyRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ProxyRepositoryTest {

	@Autowired
	ProxyRepository proxyRepository;

	@Test
	public void saveAndGetProxyEntityTest() {
		ProxyEntity proxyEntity = new ProxyEntity();
		proxyRepository.save(proxyEntity);
		ProxyEntity proxyEntity1 = proxyRepository.getOne(proxyEntity.getId());
		assertEquals(proxyEntity.getId(), proxyEntity1.getId());
	}

	@Test
	public void findALL() {
		List<ProxyEntity> list = proxyRepository.findAll();
		for (ProxyEntity p: list) {
			System.out.println(p.getId());
		}
	}

	@Test
	public void dellAll() {
		proxyRepository.deleteAll();
		Assert.assertTrue(proxyRepository.findAll().isEmpty());
	}

}
