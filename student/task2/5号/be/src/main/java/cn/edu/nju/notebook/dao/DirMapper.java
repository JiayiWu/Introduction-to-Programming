package cn.edu.nju.notebook.dao;

import cn.edu.nju.notebook.entity.DirEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirMapper {

    @Query(nativeQuery = true, value = "SELECT FROM directory d WHERE d.uid = :uid")
    List<DirEntity> selectByUserId(@Param("uid") int uid);

    @Modifying
    int insert(DirEntity record);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM directory d WHERE d.id = :id AND d.uid = :uid")
    int deleteByPrimaryKeySelective(@Param("id") int id, @Param("uid") int uid);

}
