package com.example.test.service.impl;

import com.example.test.data.ItemData;
import com.example.test.model.Files;
import com.example.test.model.Item;
import com.example.test.repository.ItemRepositoryCrud;
import com.example.test.repository.ItemsRepository;
import com.example.test.service.AccessBackingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AccessBackingServiceImpl implements AccessBackingService {

   @Autowired
   ItemsRepository itemsRepository;

    @Autowired
    ItemRepositoryCrud itemRepositoryCrud;
    @Override
    public Optional<Item> getItemsnames(String name) throws Exception {

        Optional<Item> items= itemsRepository.getItemsnames(name);
        if(items.isEmpty()){

            throw new Exception("No Item Found");

        }

        return items;
    }

    @Override
    public void createSpace(Item item) throws Exception {
        itemsRepository.createSpace(item);
    }

    @Override
    public void createFile(Files fileStored) {
        itemsRepository.createFile(fileStored);
    }

    @Override
    public Item findItemByType(String type) {
      return  itemRepositoryCrud.findItembyType(type);
    }

    @Override
    public List<ItemData> findFileMetaDataByType(String type) {
        return  itemsRepository.findFileMetaDatabyFileType(type);
    }
}
