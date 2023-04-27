package com.example.test.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="permission_groups")
@Getter
@Setter
public class PermissionsGroups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    long id;

    @Column(name="group_name")
    String group_name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "permissionsGroups")
    List<Item> item;

    public PermissionsGroups(  String group_name ) {

        this.group_name = group_name;

    }
    public PermissionsGroups(   ) {


    }
}
