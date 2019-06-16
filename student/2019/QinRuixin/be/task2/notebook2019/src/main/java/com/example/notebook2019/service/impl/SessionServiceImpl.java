package com.example.notebook2019.service.impl;

import com.example.notebook2019.constant.ResponseCode;
import com.example.notebook2019.constant.ServerException;
import com.example.notebook2019.dao.UserMapper;
import com.example.notebook2019.entity.UserEntity;
import com.example.notebook2019.service.SessionService;
import com.example.notebook2019.util.MD5Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserEntity login(String email, String password) {
        UserEntity userEntity = userMapper.selectByEmail(email);
        try {
            if(!userEntity.getPassword().equals(MD5Encryption.encrype(password))){
                throw new ServerException(ResponseCode.Error,"Password error");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return userEntity;
    }
}
