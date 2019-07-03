package cn.edu.nju.notebook.dao;

import cn.edu.nju.notebook.entity.TodoListEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListMapper {

  List<TodoListEntity> selectAll();

  void insert(TodoListEntity record);

  void delete();
}
