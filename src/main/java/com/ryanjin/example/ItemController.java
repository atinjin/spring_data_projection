package com.ryanjin.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Donghyun Ryan Jin [https://github.com/atinjin]
 * spring_data_projection on 2016. 4. 8..
 */
@RestController
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ProjectionFactory projectionFactory;

    @RequestMapping("/item-names")
    public Page<OnlyItemName> getItems(Pageable pageable) {
        Page<ShoppingItem> items = itemRepository.findAll(pageable);

        return items.map(item -> projectionFactory.createProjection(OnlyItemName.class, item));
    }

}
