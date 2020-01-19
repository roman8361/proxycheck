package ru.kravchenko.proxycheck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kravchenko.proxycheck.entity.ProxyEntity;

/**
 * @author Roman Kravchenko
 */

@Repository
public interface ProxyRepository extends JpaRepository<ProxyEntity, String> {

}
