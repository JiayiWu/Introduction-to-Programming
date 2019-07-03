package cn.edu.nju.notebook.service;

import java.util.List;
import cn.edu.nju.notebook.entity.TodoListEntity;

public interface TodoListService {

  public List<TodoListEntity> read();

  public void write(List<TodoListEntity> records);

}
