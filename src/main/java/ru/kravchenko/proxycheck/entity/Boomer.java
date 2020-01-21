package ru.kravchenko.proxycheck.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "app_Boomers")
public class Boomer extends AbstractEntity {

    private String shortName;

    private String url;

    public Boomer(String shortName, String url) {
        this.shortName = shortName;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Boomer{" +
                "shortName='" + shortName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}
