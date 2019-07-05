package cn.edu.nju.notebook.vo;

import cn.edu.nju.notebook.entity.TodoEntity;
import lombok.Data;

@Data
public class TodoVO {
    private Integer id;
    private Integer userId;
    private Integer folderId;
    private String title;
    private long createTime;
    private long noticeTime;
    private String content;

    public TodoVO(TodoEntity todoEntity){
        this.id = todoEntity.getId();
        this.userId = todoEntity.getUserId();
        this.folderId = todoEntity.getFolderId();
        this.title = todoEntity.getTitle();
        this.createTime = todoEntity.getCreateTime();
        this.noticeTime = todoEntity.getNoticeTime();
        this.content = todoEntity.getContent();
    }

}
