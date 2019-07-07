package cn.edu.nju.notebook.dao;

import cn.edu.nju.notebook.entity.TodoListEntity;
import cn.edu.nju.notebook.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface TodoListMapper {
    void insert(TodoListEntity record);
    void update(TodoListEntity record);
    void delete(int id);
    List<TodoListEntity> selectAll(UserVO userVO);
}
