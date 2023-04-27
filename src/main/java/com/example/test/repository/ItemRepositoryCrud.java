package com.example.test.repository;

import com.example.test.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ItemRepositoryCrud extends Repository<Long, Item> {


    Item findItembyType(String type);

}
