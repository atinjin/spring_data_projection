package com.ryanjin.example;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Donghyun Ryan Jin [https://github.com/atinjin]
 * spring_data_projection on 2016. 4. 8..
 */
@Repository
public interface ItemRepository extends PagingAndSortingRepository<ShoppingItem, Integer> {
}
