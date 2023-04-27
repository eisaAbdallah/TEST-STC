package com.example.test.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="item")
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    long id;

    @Column(name="type")
    String type;
    @Column(name="id")
    String name;
    @JoinColumn(name = "permission_group_id")
    @ManyToOne(fetch = FetchType.LAZY)
    PermissionsGroups permissionsGroups;

}
