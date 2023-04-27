package com.example.test.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="files")
@Getter
@Setter
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    long id;

    @Column(name="binary")
    byte[] binary;
    @Column(name="item_id")
    long  item_id;

}
