package cn.edu.nju.notebook.service.impl;

import cn.edu.nju.notebook.dao.DirMapper;
import cn.edu.nju.notebook.entity.DirEntity;
import cn.edu.nju.notebook.service.DirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DirServiceImpl implements DirService {
    @Autowired
    DirMapper dirMapper;

    @Override
    public void create(DirEntity dirEntity){
        dirMapper.insert(dirEntity);
    }
    @Override
    public void remove(int todo,int thing){
        DirEntity dirEntity = dirMapper.selectById(todo);
        String todos = dirEntity.getTodo();
        List<String> result = new ArrayList<String>(Arrays.asList(todos.split(",")));
        result.remove(thing-1);
        StringBuffer resulttodo = new StringBuffer();
        resulttodo.append(result.get(0));
        for (int i = 1;i<result.size();i++) {
            resulttodo.append(","+result.get(i));
        }
        dirEntity.setTodo(resulttodo.toString());
        dirMapper.update(dirEntity);
    }
    @Override
    public void destroy(int id){
        dirMapper.delete(id);
    }
    @Override
    public void add(int todo,int thing){
        DirEntity dirEntity = dirMapper.selectById(todo);
        StringBuffer resulttodo = new StringBuffer(dirEntity.getTodo());
        resulttodo.append(","+thing);
        dirEntity.setTodo(resulttodo.toString());
        dirMapper.update(dirEntity);
    }
}

