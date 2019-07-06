package cn.edu.nju.notebook.service;

import cn.edu.nju.notebook.entity.TodoListEntity;
import cn.edu.nju.notebook.entity.UserEntity;

import java.util.List;

public interface TodoService {
    public void add(TodoListEntity todoListEntity);
    public List<TodoListEntity> get(Object user);
    public void remove(int id);
    public void edit(TodoListEntity todoListEntity);
}
