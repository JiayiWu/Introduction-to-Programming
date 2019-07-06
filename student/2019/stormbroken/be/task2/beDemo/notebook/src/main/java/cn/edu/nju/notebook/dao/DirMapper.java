package cn.edu.nju.notebook.dao;

import cn.edu.nju.notebook.entity.DirEntity;
import cn.edu.nju.notebook.entity.TodoListEntity;
import cn.edu.nju.notebook.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DirMapper {
    void insert(DirEntity dirEntity);
    void update(DirEntity dirEntity);
    void delete(int id);
    List<DirEntity> selectAll(int id);
    List<TodoListEntity> selectKey(int id);
    DirEntity selectById(Integer id);
}
