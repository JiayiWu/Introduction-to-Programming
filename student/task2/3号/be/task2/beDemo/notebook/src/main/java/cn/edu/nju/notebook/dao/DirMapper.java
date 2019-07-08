package cn.edu.nju.notebook.dao;

import cn.edu.nju.notebook.entity.DirEntity;
import cn.edu.nju.notebook.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DirMapper {
    void insert(DirEntity dirEntity);
    void update(DirEntity dirEntity);
    void delete(int id);
    List<DirEntity> selectAll(UserVO userVO);
    DirEntity selectById(Integer id);
}
