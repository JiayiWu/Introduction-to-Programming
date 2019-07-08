package cn.edu.nju.notebook.dao;

import cn.edu.nju.notebook.entity.TodoEntity;
import cn.edu.nju.notebook.entity.UserEntity;
import cn.edu.nju.notebook.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface TodoListMapper {
    void insert(TodoEntity record);
    void update(TodoEntity record);
    void delete(String name, int id);
    List<TodoEntity> selectAll(UserVO userVO);
}
