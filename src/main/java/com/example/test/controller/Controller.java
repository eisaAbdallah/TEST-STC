package com.example.test.controller;

import com.example.test.data.ItemData;
import com.example.test.model.Files;
import com.example.test.model.Item;
import com.example.test.model.PermissionsGroups;
import com.example.test.service.AccessBackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;


@RestController
public class Controller {
    @Autowired
    AccessBackingService accessBackingService;

@RequestMapping("space-create")

public ResponseEntity<String> spaceCreation(@RequestBody Item items) throws  Exception{




    items.setName("stc-assessments");
    PermissionsGroups pGroups= new PermissionsGroups("ADMIN");

    items.setPermissionsGroups(pGroups);

    items.setType("space");

    accessBackingService.createSpace(items);



    return new ResponseEntity("The Space Had Been Created ADMIN" ,HttpStatus.CREATED);

}
    @RequestMapping("backend-create")
    public ResponseEntity<String> backEndFolderCreation(@RequestBody Item items) throws  Exception{




        items.setName("stc-assessments/backend");
        PermissionsGroups pGroups= new PermissionsGroups("SubAdmin");

        items.setPermissionsGroups(pGroups);

        items.setType("Folder");

        accessBackingService.createSpace(items);



        return new ResponseEntity("The Folder Had Been Created SUBADMIN" ,HttpStatus.CREATED);

    }
    @RequestMapping("file-create")
    public ResponseEntity<String> fileCreation(@RequestBody Item items,@RequestParam("file") MultipartFile mPFile) throws  Exception{




        items.setName("stc-assessments/backend/"+mPFile.getOriginalFilename());
        PermissionsGroups pGroups= new PermissionsGroups("tester");

        items.setPermissionsGroups(pGroups);

        items.setType("File");

        accessBackingService.createSpace(items);

        Files fileStored=new Files();




        try {
 ;
            fileStored.setBinary(mPFile.getBytes());
        } catch(IOException ioException) {
           System.out.println(ioException);
        }
        Item item=accessBackingService.findItemByType("File");

        if(item==null){

            throw  new Exception("the item type File not Found");
        }
        fileStored.setItem_id(item.getId());
        accessBackingService.createFile(fileStored);

        return new ResponseEntity("The File Had Been Created Tester" ,HttpStatus.CREATED);

    }
    @RequestMapping("file-META-DATA-create")
    public ResponseEntity<List<ItemData>> MetaData(@RequestParam("type")String type) throws  Exception{


      List<ItemData> itemData=this.accessBackingService.findFileMetaDataByType(type);

if(itemData.isEmpty()){

    return new ResponseEntity("No Files Found" ,HttpStatus.NO_CONTENT);
}



        return new ResponseEntity(itemData ,HttpStatus.OK);

    }
}
