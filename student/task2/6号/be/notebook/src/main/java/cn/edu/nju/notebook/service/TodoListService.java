package cn.edu.nju.notebook.service;

import java.util.List;
import cn.edu.nju.notebook.entity.TodoListEntity;
import cn.edu.nju.notebook.vo.UserVO;

public interface TodoListService {

  public List<TodoListEntity> read(Object user);

  public void delete(UserVO user);

  public void write(List<TodoListEntity> records, UserVO user);

}
