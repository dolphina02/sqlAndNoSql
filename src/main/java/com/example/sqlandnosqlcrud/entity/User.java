package com.example.sqlandnosqlcrud.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private enum role {
        ADMIN,
        SELLER,
        BUYER
    }
}
