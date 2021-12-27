package com.caps.springsecuritydemo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_role")
public class RolePo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private Long userId;

    private String roleName;
}
