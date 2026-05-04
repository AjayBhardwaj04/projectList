package com.mountan.productList.Entity;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "Users")
//@Table(name = "U?sers")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

}
