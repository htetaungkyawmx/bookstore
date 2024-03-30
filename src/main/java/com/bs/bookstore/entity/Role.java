package com.bs.bookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "ROLE")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role(String name){
        this.name = name;
    }
}
