package cn.edu.nju.notebook.service.impl;

import cn.edu.nju.notebook.dao.TodoMapper;
import cn.edu.nju.notebook.entity.TodoEntity;
import cn.edu.nju.notebook.form.TodoForm;
import cn.edu.nju.notebook.service.TodoService;
import cn.edu.nju.notebook.vo.TodoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoMapper todoMapper;

    @Override
    public List<TodoVO> getTodoList(int uid) throws Exception {
        return null;
    }

    @Override
    public TodoEntity addTodo(int uid, TodoForm todoForm) throws Exception {
        return null;
    }

    @Override
    public TodoEntity checkTodo(int uid, int tid) throws Exception {
        return null;
    }

    @Override
    public TodoEntity editTodo(int uid, int tid, TodoForm todoForm) throws Exception {
        return null;
    }

    @Override
    public void removeTodo(int uid, int tid) throws Exception {

    }
}
