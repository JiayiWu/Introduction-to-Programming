package cn.edu.nju.notebook.dao;

import cn.edu.nju.notebook.entity.TodoEntity;
import cn.edu.nju.notebook.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

//这里是持久层
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer id);

    UserEntity selectByEmail(String email);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKeyWithBLOBs(UserEntity record);

    int updateByPrimaryKey(UserEntity record);

    List<TodoEntity> findTodoList(String email);
}