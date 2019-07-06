package cn.edu.nju.notebook.entity;

import lombok.Data;

import java.util.List;

@Data
public class DirEntity {
    private Integer id;
    private String user;
    private List<Integer> todo;
    private String title;
}
