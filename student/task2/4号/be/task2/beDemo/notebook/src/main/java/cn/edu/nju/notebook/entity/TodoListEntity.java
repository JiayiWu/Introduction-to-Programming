package cn.edu.nju.notebook.entity;

import lombok.Data;

@Data
public class TodoListEntity {
    private Integer id;
    private String user;
    private String title;
    private String content;
    private long createTime;
    private long noticeTime;
}
