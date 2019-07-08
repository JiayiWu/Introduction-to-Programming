package cn.edu.nju.notebook.dao;

import cn.edu.nju.notebook.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserMapper {

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM user u WHERE u.id = :id")
    int deleteByPrimaryKey(@Param("id") Integer id);

    @Modifying
    int insert(UserEntity record);

    @Modifying
    int insertSelective(UserEntity record);

    @Query(nativeQuery = true, value = "SELECT FROM user u WHERE u.id = :id")
    UserEntity selectByPrimaryKey(@Param("id") Integer id);

    @Query(nativeQuery = true, value = "SELECT FROM user u WHERE u.email = :email")
    UserEntity selectByEmail(String email);

    @Modifying
    int updateByPrimaryKeySelective(UserEntity record);

    @Modifying
    int updateByPrimaryKeyWithBLOBs(UserEntity record);

    @Modifying
    int updateByPrimaryKey(UserEntity record);
}