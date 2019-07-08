package cn.edu.nju.notebook.vo;

import cn.edu.nju.notebook.entity.TodoEntity;
import lombok.Data;

@Data
public class TodoVO {

    private int id;

    private String title;

    private String content;

    private int createTime;

    private int noticeTime;

    public TodoVO(TodoEntity todoEntity) {
        if (todoEntity != null) {
            this.id = todoEntity.getId();
            this.title = todoEntity.getTitle();
            this.content = todoEntity.getContent();
            this.createTime = todoEntity.getCreateTime();
            this.noticeTime = todoEntity.getNoticeTime();
        }
    }
}
