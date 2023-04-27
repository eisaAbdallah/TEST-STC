package com.example.test.repository.impl;

import com.example.test.dao.DAO;
import com.example.test.data.ItemData;
import com.example.test.model.Files;
import com.example.test.model.Item;
import com.example.test.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class ItemsReositoryImpl implements ItemsRepository {
    @Autowired
    DAO dao;

    @Override
    public Optional<Item> getItemsnames(String name) {


        return this.dao.findItemByName(name);
    }

    @Override
    public void createSpace(Item item) {
         this.dao.createSpace(item);
    }

    @Override
    public void createFile(Files fileStored) {
         this.dao.createFile(fileStored);
    }

    @Override
    public   Optional<Item> findItemByType(String type) {
       return  this.dao.findItemByType(type);
    }


    @Override
    public List<ItemData> findFileMetaDatabyFileType(String type) {
      return  this.dao.findFilemetaDataByType(type);
    }
}
