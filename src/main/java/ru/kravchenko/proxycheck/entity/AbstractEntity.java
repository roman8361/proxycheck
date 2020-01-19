package ru.kravchenko.proxycheck.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@MappedSuperclass
public abstract  class AbstractEntity {

    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id='" + id + '\'' +
                '}';
    }

}
