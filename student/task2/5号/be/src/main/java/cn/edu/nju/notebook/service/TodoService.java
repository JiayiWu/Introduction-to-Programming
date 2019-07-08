package cn.edu.nju.notebook.service;

import cn.edu.nju.notebook.entity.TodoEntity;
import cn.edu.nju.notebook.form.TodoForm;
import cn.edu.nju.notebook.vo.TodoVO;

import java.util.List;

public interface TodoService {

    public List<TodoVO> getTodoList(int uid) throws Exception;

    public TodoEntity addTodo(int uid, TodoForm todoForm) throws Exception;

    public TodoEntity checkTodo(int uid, int tid) throws Exception;

    public TodoEntity editTodo(int uid, int tid, TodoForm todoForm) throws Exception;

    public void removeTodo(int uid, int tid) throws Exception;

}
