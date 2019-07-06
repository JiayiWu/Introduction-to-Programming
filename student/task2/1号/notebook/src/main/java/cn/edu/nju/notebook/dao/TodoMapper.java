package cn.edu.nju.notebook.dao;

import cn.edu.nju.notebook.entity.TodoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoMapper {

    int insert(TodoEntity todo);
    TodoEntity selectByPrimaryKey(Integer id);
    int deleteByPrimaryKey(Integer id);
    int update(TodoEntity todoEntity);
    TodoEntity selectByTitle(String title);

    //按创建时间排序
    List<TodoEntity> selectByFolderIdOrderByCreateTime(Integer folderId);

    int deleteByFolderId(Integer folderId);

    List<TodoEntity> selectByUserId(Integer userId);

}
