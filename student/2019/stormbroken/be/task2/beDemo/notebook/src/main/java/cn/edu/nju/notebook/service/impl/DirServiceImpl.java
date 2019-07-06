package cn.edu.nju.notebook.service.impl;

import cn.edu.nju.notebook.dao.DirMapper;
import cn.edu.nju.notebook.dao.TodoListMapper;
import cn.edu.nju.notebook.dao.UserMapper;
import cn.edu.nju.notebook.entity.DirEntity;
import cn.edu.nju.notebook.entity.TodoListEntity;
import cn.edu.nju.notebook.service.DirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DirServiceImpl implements DirService {
    @Autowired
    DirMapper dirMapper;
    TodoListMapper todoListMapper;

    @Override
    public void create(DirEntity dirEntity){
        dirMapper.insert(dirEntity);
    }
    @Override
    public void remove(int todo,int thing){
        DirEntity dirEntity = dirMapper.selectById(todo);
        dirEntity.getTodo().remove(thing-1);
        dirMapper.update(dirEntity);
    }
    @Override
    public void destroy(int id){
        dirMapper.delete(id);
    }
    @Override
    public void add(int todo,int thing){
        DirEntity dirEntity = dirMapper.selectById(todo);
        dirEntity.getTodo().add(thing);
        dirMapper.update(dirEntity);
    }
    @Override
    public List<DirEntity> list(int id){
        return dirMapper.selectAll(id);
    }
    @Override
    public List<TodoListEntity> check(int id){
        return dirMapper.selectKey(id);
    }
}

