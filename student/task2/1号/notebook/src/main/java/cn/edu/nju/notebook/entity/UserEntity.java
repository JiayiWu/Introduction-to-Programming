package cn.edu.nju.notebook.entity;

import lombok.Data;

@Data
public class UserEntity {

    private Integer id;

    private String name;

    private String password;

    private String email;

    private String logoUrl;

    public void setPassword(String s) {
        this.password = s;
    }

    public void setName(String test) {
        this.name = test;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getName() {
        return this.name;
    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getLogoUrl() {
        return logoUrl;
    }
}