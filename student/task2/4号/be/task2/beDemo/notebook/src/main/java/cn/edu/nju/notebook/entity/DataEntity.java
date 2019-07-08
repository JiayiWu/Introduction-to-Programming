package cn.edu.nju.notebook.entity;

import lombok.Data;

import java.util.List;

@Data
public class DataEntity {
    private UserEntity user;
    private List<TodoEntity> todoListEntities;
    //private List<DirEntity> dirEntities;,List<DirEntity> dirEntities
    public DataEntity(UserEntity user,List<TodoEntity> todoListEntities){
        this.user = user;
        this.todoListEntities = todoListEntities;
        //this.dirEntities = dirEntities;
    }
}
