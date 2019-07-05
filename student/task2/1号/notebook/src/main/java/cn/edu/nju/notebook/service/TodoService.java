package cn.edu.nju.notebook.service;

import cn.edu.nju.notebook.entity.TodoEntity;
import cn.edu.nju.notebook.form.TodoForm;

import java.util.List;

public interface TodoService {

    public TodoEntity addTodo(Integer userId,Integer folderId,TodoForm todo);

    public TodoEntity checkTodo(Integer todoId);

    public void delTodo(Integer todoId);

    public TodoEntity updateTodo(Integer todoId,TodoForm todo);

    public List<TodoEntity> getTodos(Integer folderId);








}
