package cn.edu.nju.notebook.service.impl;

import cn.edu.nju.notebook.dao.TodoListMapper;
import cn.edu.nju.notebook.entity.TodoListEntity;
import cn.edu.nju.notebook.entity.UserEntity;
import cn.edu.nju.notebook.service.TodoListService;
import cn.edu.nju.notebook.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListServiceImpl implements TodoListService {

  @Autowired
  TodoListMapper todoListMapper;

  @Override
  public List<TodoListEntity> read(Object user){
    List<TodoListEntity> records = todoListMapper.selectAll(new UserVO((UserEntity)user));
//    printAll(records);
    return records;
  }

  @Override
  public void delete(UserVO user) {
    todoListMapper.delete(user);
  }

  @Override
  public void write(List<TodoListEntity> records, UserVO user){
//    printAll(records);
    for(TodoListEntity record : records){
      record.setUser(user.getName());
      todoListMapper.insert(record);
    }
  }

  private void printAll(List<TodoListEntity> records) {
    if(records == null) {
      System.out.println("records not found");
      return;
    }
    for(TodoListEntity todo : records) {
      System.out.println("id: " + todo.getId());
    }
  }
}
