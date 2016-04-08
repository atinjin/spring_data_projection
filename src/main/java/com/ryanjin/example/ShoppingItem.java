package com.ryanjin.example;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Donghyun Ryan Jin [https://github.com/atinjin]
 * spring_data_projection on 2016. 4. 4..
 */
@Entity
@Data
public class ShoppingItem {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private String category;
    private int price;
    private String seller;
}
