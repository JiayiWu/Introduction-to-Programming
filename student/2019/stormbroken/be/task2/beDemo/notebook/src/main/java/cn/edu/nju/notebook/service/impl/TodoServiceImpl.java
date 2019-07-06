package cn.edu.nju.notebook.service.impl;

import cn.edu.nju.notebook.dao.TodoListMapper;
import cn.edu.nju.notebook.entity.TodoListEntity;
import cn.edu.nju.notebook.entity.UserEntity;
import cn.edu.nju.notebook.service.TodoService;
import cn.edu.nju.notebook.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoListMapper todoListMapper;
    @Override
    public void add(TodoListEntity todoListEntity){
        todoListMapper.insert(todoListEntity);
    }
    @Override
    public List<TodoListEntity> get(Object user){
        List<TodoListEntity> todoListEntities = todoListMapper.selectAll(new UserVO((UserEntity)user));
        return todoListEntities;
    }
    @Override
    public void edit(TodoListEntity todoListEntity){
        todoListMapper.update(todoListEntity);
    }
    @Override
    public void remove(int id){
        todoListMapper.delete(id);
    }

}
