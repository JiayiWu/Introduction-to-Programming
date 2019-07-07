package cn.edu.nju.notebook.service;

import cn.edu.nju.notebook.entity.DataEntity;
import cn.edu.nju.notebook.entity.TodoListEntity;


public interface TodoService {
    public void add(TodoListEntity todoListEntity);
    public DataEntity get(Object user);
    public void remove(int id);
    public void edit(TodoListEntity todoListEntity);
}
