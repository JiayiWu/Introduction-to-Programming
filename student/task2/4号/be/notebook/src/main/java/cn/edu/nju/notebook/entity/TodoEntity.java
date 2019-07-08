package cn.edu.nju.notebook.entity;

import lombok.Data;

@Data
public class TodoEntity {
    private Integer id;
    private Integer number;
    private String user;
    private String title;
    private String content;
    private long createTime;
    private long noticeTime;
}
