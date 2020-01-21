package ru.kravchenko.proxycheck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kravchenko.proxycheck.entity.Boomer;

@Repository
public interface BoomersRepository extends JpaRepository<Boomer, String> {

    Boomer findByShortName(String shortName);

}
