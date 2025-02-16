package com.aashish.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table (name="user")
public class User implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
@Id
    private long id;
    private String email;
    private String name;

}
