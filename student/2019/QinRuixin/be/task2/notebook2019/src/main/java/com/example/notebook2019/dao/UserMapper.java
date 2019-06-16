package com.example.notebook2019.dao;

import com.example.notebook2019.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int insert(UserEntity record);

//    int deleteByPrimaryKey(Integer id);
//
//    int insertSelective(UserEntity record);


    UserEntity selectByPrimaryKey(int id);
//    UserEntity selectByPrimaryKey(Integer id);

    UserEntity selectByEmail(String email);

//    int updateByPrimaryKeySelective(UserEntity record);
//
//    int updateByPrimaryKeyWithBLOBs(UserEntity record);
//
//    int updateByPrimaryKey(UserEntity record);
}
