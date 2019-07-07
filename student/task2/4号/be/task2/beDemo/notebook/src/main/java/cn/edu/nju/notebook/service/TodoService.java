package cn.edu.nju.notebook.service;

import cn.edu.nju.notebook.entity.DataEntity;
import cn.edu.nju.notebook.entity.TodoEntity;


public interface TodoService {
    public void add(TodoEntity todoListEntity);
    public DataEntity get(Object user);
    public void remove(String name,int id);
    public void edit(TodoEntity todoListEntity);
}
