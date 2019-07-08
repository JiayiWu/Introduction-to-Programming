package cn.edu.nju.notebook.service.impl;

import cn.edu.nju.notebook.constant.ResponseCode;
import cn.edu.nju.notebook.constant.ServerException;
import cn.edu.nju.notebook.dao.TodoMapper;
import cn.edu.nju.notebook.entity.TodoEntity;
import cn.edu.nju.notebook.form.TodoForm;
import cn.edu.nju.notebook.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoMapper todoMapper;

    @Override
    public TodoEntity addTodo(Integer userId, Integer folderId, TodoForm todo) {
        if(todo==null){
            throw new ServerException(ResponseCode.Error,"创建待办事项失败");
        }
//        TodoEntity target = todoMapper.selectByTitle(todo.getTitle());
//        if((target!=null)&& (userId.equals(target.getUserId()))&&(folderId.equals(target.getFolderId()))){
//            throw new ServerException(ResponseCode.Error,"待办事项已存在");
//        }
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setUserId(userId);
        todoEntity.setFolderId(folderId);
        todoEntity.setTitle(todo.getTitle());
        todoEntity.setContent(todo.getContent());
        todoEntity.setCreateTime(todo.getCreateTime());
        todoEntity.setNoticeTime(todo.getNoticeTime());
        todoMapper.insert(todoEntity);
        return todoEntity;
    }


    @Override
    public TodoEntity checkTodo(Integer todoId) {
        TodoEntity todoEntity = todoMapper.selectByPrimaryKey(todoId);
        if(todoEntity==null){
            throw new ServerException(ResponseCode.Error,"待办事项不存在");
        }
        return todoEntity;
    }

    @Override
    public void delTodo(Integer todoId) {
        todoMapper.deleteByPrimaryKey(todoId);

    }

    @Override
    public TodoEntity updateTodo(Integer todoId, TodoForm todo) {
        if(todo==null){
            throw new ServerException(ResponseCode.Error,"更新待办事项失败");
        }
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setId(todoId);
        todoEntity.setTitle(todo.getTitle());
        todoEntity.setContent(todo.getContent());
        todoEntity.setNoticeTime(todo.getNoticeTime());
        todoEntity.setUserId(todoMapper.selectByPrimaryKey(todoId).getUserId());
        todoEntity.setFolderId(todoMapper.selectByPrimaryKey(todoId).getFolderId());

        todoMapper.update(todoEntity);
        return todoEntity;

    }

    @Override
    public List<TodoEntity> getTodos(Integer folderId) {

        return todoMapper.selectByFolderIdOrderByCreateTime(folderId);
    }


}
