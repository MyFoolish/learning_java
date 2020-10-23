package com.xwcoding.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author liuxiaowei
 * @description
 * @date 2020/10/21 17:20
 */
@Entity
@Data
public class User implements Serializable {
    @Id
    @Column
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String role;
}
