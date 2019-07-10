package cn.edu.nju.notebook.dao;

import cn.edu.nju.notebook.entity.TodoEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoMapper {

    @Query(nativeQuery = true, value = "SELECT * FROM todo WHERE uid = :uid")
    List<TodoEntity> selectByUserId(@Param("uid") int uid);

    @Modifying
    int insert(TodoEntity record);

    @Query(nativeQuery = true, value = "SELECT * FROM todo WHERE id = :tid AND uid = :uid")
    TodoEntity selectByIdAndUid(@Param("id") int id, @Param("uid") int uid);

    @Modifying
    int updateByPrimaryKeySelective(TodoEntity record);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM todo WHERE id = :tid AND uid = :uid")
    int deleteByPrimaryKey(@Param("id") int id, @Param("uid") int uid);
}
