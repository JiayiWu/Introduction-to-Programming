package cn.edu.nju.notebook.vo;

import cn.edu.nju.notebook.entity.TodoEntity;
import lombok.Data;

@Data
public class DirTodoVO {

    private int id;

    private String title;

    public DirTodoVO(TodoEntity todoEntity) {
        if (todoEntity != null) {
            this.id = todoEntity.getId();
            this.title = todoEntity.getTitle();
        }
    }
}
