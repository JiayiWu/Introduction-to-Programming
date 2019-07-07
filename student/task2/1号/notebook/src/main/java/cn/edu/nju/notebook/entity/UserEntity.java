package cn.edu.nju.notebook.entity;

import lombok.Data;

@Data
public class UserEntity {

    private Integer id;

    private String name;

    private String password;

    private String email;

    private String logoUrl;

}