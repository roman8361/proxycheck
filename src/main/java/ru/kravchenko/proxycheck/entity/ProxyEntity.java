package ru.kravchenko.proxycheck.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@Entity
@Table(name = "app_ProxyEntity")
public class ProxyEntity extends AbstractEntity {

    private String ip;

    private String port;

    private String code;

    private String country;

    private String anonymity;

    private Integer checkFlag = 0; // 1 - прокси рабочий, 0 - прокси не рабочий, по умолчанию прокси = 0

    @Override
    public String toString() {
        return "ProxyEntity{" +
                "ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", code='" + code + '\'' +
                ", country='" + country + '\'' +
                ", anonymity='" + anonymity + '\'' +
                '}';
    }

}
