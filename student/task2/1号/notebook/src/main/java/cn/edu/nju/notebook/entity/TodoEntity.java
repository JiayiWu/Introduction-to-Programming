package cn.edu.nju.notebook.entity;

import lombok.Data;

@Data
public class TodoEntity {
    private Integer id;
    private Integer userId;
    private Integer folderId;
    private String title;
    private long createTime;
    private long noticeTime;
    private String content;

}
