package com.example.test.repository;

import com.example.test.data.ItemData;
import com.example.test.model.Files;
import com.example.test.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemsRepository {
    Optional<Item> getItemsnames(String name);

    void createSpace(Item item);

    void createFile(Files fileStored);

    Optional<Item> findItemByType(String type);
    List<ItemData> findFileMetaDatabyFileType(String type);
}
