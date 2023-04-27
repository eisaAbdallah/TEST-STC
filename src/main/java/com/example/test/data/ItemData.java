package com.example.test.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemData {

    int id;

    String type;
    String name;
     int permissionGroupId;

    public ItemData(int id, String type, String name, int permissionGroupId) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.permissionGroupId = permissionGroupId;
    }
}
