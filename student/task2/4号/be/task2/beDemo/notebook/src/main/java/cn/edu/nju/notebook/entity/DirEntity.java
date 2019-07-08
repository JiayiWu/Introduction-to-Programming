package cn.edu.nju.notebook.entity;

import lombok.Data;

import java.util.List;

@Data
public class DirEntity {
    private Integer id;
    private Integer number;
    private String user;
    private String todo;//持有哪个TODO
    private String title;
}
