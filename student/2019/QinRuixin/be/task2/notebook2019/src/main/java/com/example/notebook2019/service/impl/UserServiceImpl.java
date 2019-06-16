package com.example.notebook2019.service.impl;

import com.example.notebook2019.constant.ResponseCode;
import com.example.notebook2019.constant.ServerException;
import com.example.notebook2019.dao.UserMapper;
import com.example.notebook2019.entity.UserEntity;
import com.example.notebook2019.form.UserForm;
import com.example.notebook2019.service.UserService;
import com.example.notebook2019.util.MD5Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserEntity createUser(UserForm userForm) {

        UserEntity user = userMapper.selectByEmail(userForm.getEmail());
        if (user != null) {
            throw new ServerException(ResponseCode.Error, "The email has existed");

        }

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userForm.getEmail());
        userEntity.setName(userForm.getName());
        userEntity.setLogoUrl(userForm.getLogoUrl());

        try {
            userEntity.setPassword(MD5Encryption.encrype(userForm.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new ServerException(ResponseCode.Error, "Encode error");

        }
        userMapper.insert(userEntity);
        return userEntity;


    }
}
