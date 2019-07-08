package cn.edu.nju.notebook.service.impl;

import cn.edu.nju.notebook.dao.TodoListMapper;
import cn.edu.nju.notebook.entity.DataEntity;
import cn.edu.nju.notebook.entity.TodoEntity;
import cn.edu.nju.notebook.entity.UserEntity;
import cn.edu.nju.notebook.service.TodoService;
import cn.edu.nju.notebook.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TodoServiceImpl implements TodoService {
    @Resource
    @Autowired
    TodoListMapper todoListMapper;
    @Override
    public void add(TodoEntity todoListEntity){
        todoListMapper.insert(todoListEntity);
    }
    @Override
    public DataEntity get(Object user){
        UserEntity userEntity = (UserEntity) user;
        DataEntity dataEntity = new DataEntity(userEntity,todoListMapper.selectAll(new UserVO((UserEntity)user)));
        return dataEntity;
    }
    @Override
    public void edit(TodoEntity todoListEntity){
        todoListMapper.update(todoListEntity);
    }
    @Override
    public void remove(String name,int id){
        todoListMapper.delete(name,id);
    }

}
