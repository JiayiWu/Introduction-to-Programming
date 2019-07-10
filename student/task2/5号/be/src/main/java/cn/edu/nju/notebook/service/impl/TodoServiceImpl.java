package cn.edu.nju.notebook.service.impl;

import cn.edu.nju.notebook.constant.ResponseCode;
import cn.edu.nju.notebook.constant.ServerException;
import cn.edu.nju.notebook.dao.TodoMapper;
import cn.edu.nju.notebook.entity.TodoEntity;
import cn.edu.nju.notebook.form.TodoForm;
import cn.edu.nju.notebook.service.TodoService;
import cn.edu.nju.notebook.vo.TodoVO;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoMapper todoMapper;

    @Override
    public List<TodoVO> getTodoList(int uid) throws Exception {
        try {
            List<TodoEntity> todoEntityList = todoMapper.selectByUserId(uid);
            List<TodoVO> todoVOList = new ArrayList<TodoVO>();
            for (int i=0; i<todoEntityList.size(); ++i) {
                todoVOList.add(new TodoVO(todoEntityList.get(i)));
            }
            return todoVOList;
        }
        catch (Exception e) {
            throw new ServerException(ResponseCode.Error, "select error");
        }
    }

    @Override
    public TodoEntity addTodo(int uid, TodoForm todoForm) throws Exception {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(todoForm.getTitle());
        todoEntity.setContent(todoForm.getContent());
        todoEntity.setCreateTime(todoForm.getCreateTime());
        todoEntity.setNoticeTime(todoForm.getNoticeTime());
        todoEntity.setUid(uid);
        try {
            todoMapper.insert(todoEntity);
            return todoEntity;
        }
        catch (Exception e) {
            throw new ServerException(ResponseCode.Error, "insert error");
        }
    }

    @Override
    public TodoEntity checkTodo(int uid, int tid) throws Exception {
        try {
            TodoEntity todoEntity = todoMapper.selectByIdAndUid(tid, uid);
            return todoEntity;
        }
        catch (Exception e) {
            throw new ServerException(ResponseCode.Error, "select error");
        }
    }

    @Override
    public TodoEntity editTodo(int uid, int tid, TodoForm todoForm) throws Exception {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(todoForm.getTitle());
        todoEntity.setContent(todoForm.getContent());
        todoEntity.setCreateTime(todoForm.getCreateTime());
        todoEntity.setNoticeTime(todoForm.getNoticeTime());
        todoEntity.setUid(uid);
        todoEntity.setId(tid);
        try {
            todoMapper.updateByPrimaryKeySelective(todoEntity);
            return todoEntity;
        }
        catch (Exception e) {
            throw new ServerException(ResponseCode.Error, "update error");
        }
    }

    @Override
    public void removeTodo(int uid, int tid) throws Exception {
        try {
            todoMapper.deleteByPrimaryKey(tid, uid);
        }
        catch (Exception e) {
            throw new ServerException(ResponseCode.Error, "delete error");
        }
    }
}
