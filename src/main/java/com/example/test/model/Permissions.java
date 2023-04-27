package com.example.test.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="permissions")
@Getter
@Setter
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    long id;

    @Column(name="user_email")
    String user_email;

    @Column(name="permission_level")
    String permission_level;
    @Column(name="group_id")
    long group_id;
}
