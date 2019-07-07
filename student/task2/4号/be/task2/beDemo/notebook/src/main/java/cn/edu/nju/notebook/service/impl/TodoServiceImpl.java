package cn.edu.nju.notebook.service.impl;

import cn.edu.nju.notebook.dao.DirMapper;
import cn.edu.nju.notebook.dao.TodoListMapper;
import cn.edu.nju.notebook.entity.DataEntity;
import cn.edu.nju.notebook.entity.TodoListEntity;
import cn.edu.nju.notebook.entity.UserEntity;
import cn.edu.nju.notebook.service.TodoService;
import cn.edu.nju.notebook.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoListMapper todoListMapper;
    DirMapper dirMapper;
    @Override
    public void add(TodoListEntity todoListEntity){
        todoListMapper.insert(todoListEntity);
    }
    @Override
    public DataEntity get(Object user){
        UserEntity userEntity = (UserEntity) user;
        DataEntity dataEntity = new DataEntity(userEntity,
                                            todoListMapper.selectAll(new UserVO((UserEntity)user))
                                            );
        return dataEntity;//dirMapper.selectAll(new UserVO((UserEntity)user))
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
