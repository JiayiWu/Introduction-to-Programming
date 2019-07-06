package cn.edu.nju.notebook.dao;

import cn.edu.nju.notebook.entity.TodoListEntity;
import cn.edu.nju.notebook.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface TodoListMapper {
    List<TodoListEntity> selectAll(UserVO userVO);
    void insert(TodoListEntity record);
    void update(TodoListEntity record);
    void delete(int id);
    TodoListEntity selectById(int id);
}
