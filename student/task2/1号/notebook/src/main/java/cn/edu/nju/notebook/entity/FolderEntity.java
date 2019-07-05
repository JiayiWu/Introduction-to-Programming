package cn.edu.nju.notebook.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FolderEntity {
    private Integer id;
    private Integer userId;
    private String name;
}
