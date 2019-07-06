package cn.edu.nju.notebook.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoEntity {
    private Integer id;
    private Integer userId;
    private Integer folderId;
    private String title;
    private long createTime;
    private long noticeTime;
    private String content;

}
