package com.example.test.dao.impl;

import com.example.test.dao.DAO;
import com.example.test.data.ItemData;
import com.example.test.model.Files;
import com.example.test.model.Item;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DaoImpl implements DAO {
    @Autowired
    EntityManager entityManager;
    @Autowired
    JdbcTemplate jdbcTemplate;
    List<ItemData> itemDataList=new ArrayList<>();
    ItemData itemData=null;
    String MetadataQuery="select i.id,i.type,i.name,i.permission_group_id from Files f INNER JOIN Item i ON  i.id=f.item_id where i.type=?";

    @Override
    @Transactional
    public void createSpace(Item item) {

        entityManager.merge(item);
    }

    @Override
    @Transactional
    public void createFile(Files fileStored) {
        entityManager.merge(fileStored);

    }

    @Override
    @Transactional
    public  Optional<Item> findItemByType(String type) {

        String Jpql="from Item where type= : type";
        TypedQuery<Item> query = entityManager.createQuery(Jpql,Item.class);
        query.setParameter("type",type );
        List<Item> result = query.getResultList();
        Optional<Item> optionWithNull=result.stream().findAny();
        return optionWithNull;
    }

    @Override
    public List<ItemData> findFilemetaDataByType(String type) {

        this.jdbcTemplate.query(MetadataQuery, new RowMapper<ItemData>() {
            @Override
            public ItemData mapRow(ResultSet rs, int rowNum) throws SQLException {
                itemData=new ItemData(rs.getInt("id"),rs.getString("type"),rs.getString("name"),rs.getInt("permission_group_id"));
                itemDataList.add(itemData);

                return itemData;
            }
        });
        return itemDataList;
    }

    @Override
    @Transactional
    public Optional<Item> findItemByName(String name) {

        String Jpql="from Item where name= : name";
        TypedQuery<Item> query = entityManager.createQuery(Jpql,Item.class);
        query.setParameter("name",name );
        List<Item> result = query.getResultList();
        Optional<Item> optionWithNull=result.stream().findAny();
        return optionWithNull;
    }



}
