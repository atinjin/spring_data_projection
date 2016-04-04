package com.ryanjin.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by donghyunjin on 2016. 4. 4..
 */
@Entity
public class ShopItem {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private String category;
    private int price;
    private String seller;

}
