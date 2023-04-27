package com.example.test.service;

import com.example.test.data.ItemData;
import com.example.test.model.Files;
import com.example.test.model.Item;

import java.util.List;
import java.util.Optional;

public interface AccessBackingService {
    Optional<Item> getItemsnames(String name) throws Exception;
   void createSpace(Item item) throws Exception;
    List<ItemData> findFileMetaDataByType(String type);
    void createFile(Files fileStored);
    Item findItemByType(String type);
}
